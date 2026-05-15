package defpackage;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.google.android.gms.common.util.UidVerifier;
import java.util.ArrayList;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: renamed from: sl0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class HandlerC1467sl0 extends ZU2 {
    public final /* synthetic */ AbstractServiceC1578ul0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC1467sl0(AbstractServiceC1578ul0 abstractServiceC1578ul0, Looper looper) {
        super(looper);
        this.a = abstractServiceC1578ul0;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Messenger messenger;
        int i = message.sendingUid;
        AbstractServiceC1578ul0 abstractServiceC1578ul0 = this.a;
        if (!UidVerifier.uidHasPackageName(abstractServiceC1578ul0, i, "com.google.android.gms")) {
            Log.e("GcmTaskService", "unable to verify presence of Google Play Services");
            return;
        }
        int i2 = message.what;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 4) {
                    abstractServiceC1578ul0.a();
                    return;
                }
                String strValueOf = String.valueOf(message);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 31);
                sb.append("Unrecognized message received: ");
                sb.append(strValueOf);
                Log.e("GcmTaskService", sb.toString());
                return;
            }
            return;
        }
        Bundle data = message.getData();
        if (data.isEmpty() || (messenger = message.replyTo) == null) {
            return;
        }
        String string = data.getString("tag");
        ArrayList parcelableArrayList = data.getParcelableArrayList("triggered_uris");
        long j = data.getLong("max_exec_duration", 180L);
        if (abstractServiceC1578ul0.d(string)) {
            return;
        }
        Bundle bundle = data.getBundle("extras");
        AbstractServiceC1578ul0 abstractServiceC1578ul02 = this.a;
        RunnableC1526tl0 runnableC1526tl0 = new RunnableC1526tl0(abstractServiceC1578ul02, string, messenger, bundle, j, parcelableArrayList);
        abstractServiceC1578ul02.getClass();
        try {
            abstractServiceC1578ul02.v.execute(runnableC1526tl0);
        } catch (RejectedExecutionException e) {
            Log.e("GcmTaskService", "Executor is shutdown. onDestroy was called but main looper had an unprocessed start task message. The task will be retried with backoff delay.", e);
            runnableC1526tl0.a(1);
        }
    }
}
