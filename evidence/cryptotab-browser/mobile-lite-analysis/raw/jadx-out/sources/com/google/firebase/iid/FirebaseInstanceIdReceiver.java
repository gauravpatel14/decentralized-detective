package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;
import defpackage.C0055Eb0;
import defpackage.C0836iN2;
import defpackage.C0939k33;
import defpackage.Y62;
import defpackage.ZY2;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class FirebaseInstanceIdReceiver extends BroadcastReceiver {
    public static final /* synthetic */ int b = 0;
    public final ExecutorService a;

    public FirebaseInstanceIdReceiver() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("firebase-iid-executor"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.a = Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    public static int a(Context context, Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("CloudMessagingReceiver", "Notification pending intent canceled");
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.remove("pending_intent");
        } else {
            extras = new Bundle();
        }
        if ("com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            try {
                Y62.a(new C0055Eb0(context).b(new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN").putExtras(extras)));
                return -1;
            } catch (InterruptedException | ExecutionException e) {
                Log.e("FirebaseInstanceId", "Failed to send notification open event to service.", e);
                return -1;
            }
        }
        if (!"com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(intent.getAction())) {
            Log.e("CloudMessagingReceiver", "Unknown notification action");
            return 500;
        }
        try {
            Y62.a(new C0055Eb0(context).b(new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(extras)));
            return -1;
        } catch (InterruptedException | ExecutionException e2) {
            Log.e("FirebaseInstanceId", "Failed to send notification dismissed event to service.", e2);
            return -1;
        }
    }

    public static int b(Context context, Intent intent) {
        int i;
        C0939k33 c0939k33B;
        int iIntValue = 500;
        if (intent.getExtras() == null) {
            return 500;
        }
        String stringExtra = intent.getStringExtra("google.message_id");
        if (TextUtils.isEmpty(stringExtra)) {
            c0939k33B = Y62.e(null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("google.message_id", stringExtra);
            C0836iN2 c0836iN2A = C0836iN2.a(context);
            synchronized (c0836iN2A) {
                i = c0836iN2A.d;
                c0836iN2A.d = i + 1;
            }
            c0939k33B = c0836iN2A.b(new ZY2(i, 2, bundle));
        }
        try {
            iIntValue = ((Integer) Y62.a(new C0055Eb0(context).b(new CloudMessage(intent).t))).intValue();
        } catch (InterruptedException | ExecutionException e) {
            Log.e("FirebaseInstanceId", "Failed to send message to service.", e);
        }
        try {
            Y62.b(c0939k33B, TimeUnit.SECONDS.toMillis(1L), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            String strValueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 20);
            sb.append("Message ack failed: ");
            sb.append(strValueOf);
            Log.w("CloudMessagingReceiver", sb.toString());
        }
        return iIntValue;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, final Intent intent) {
        if (intent == null) {
            return;
        }
        final boolean zIsOrderedBroadcast = isOrderedBroadcast();
        final BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        this.a.execute(new Runnable(this, intent, context, zIsOrderedBroadcast, pendingResultGoAsync) { // from class: KK2
            public final FirebaseInstanceIdReceiver t;
            public final Intent u;
            public final Context v;
            public final boolean w;
            public final BroadcastReceiver.PendingResult x;

            {
                this.t = this;
                this.u = intent;
                this.v = context;
                this.w = zIsOrderedBroadcast;
                this.x = pendingResultGoAsync;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Intent intent2 = this.u;
                BroadcastReceiver.PendingResult pendingResult = this.x;
                this.t.getClass();
                try {
                    Parcelable parcelableExtra = intent2.getParcelableExtra("wrapped_intent");
                    Intent intent3 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
                    Context context2 = this.v;
                    int iA = intent3 != null ? FirebaseInstanceIdReceiver.a(context2, intent3) : FirebaseInstanceIdReceiver.b(context2, intent2);
                    if (this.w) {
                        pendingResult.setResultCode(iA);
                    }
                } finally {
                    pendingResult.finish();
                }
            }
        });
    }
}
