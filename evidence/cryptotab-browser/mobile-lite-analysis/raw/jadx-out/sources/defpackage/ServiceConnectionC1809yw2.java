package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.ArrayDeque;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: renamed from: yw2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ServiceConnectionC1809yw2 implements ServiceConnection {
    public final Context t;
    public final Intent u;
    public final ScheduledThreadPoolExecutor v;
    public final ArrayDeque w;
    public BinderC1587uw2 x;
    public boolean y;

    public ServiceConnectionC1809yw2(Context context) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection"));
        this.w = new ArrayDeque();
        this.y = false;
        Context applicationContext = context.getApplicationContext();
        this.t = applicationContext;
        this.u = new Intent("com.google.firebase.MESSAGING_EVENT").setPackage(applicationContext.getPackageName());
        this.v = scheduledThreadPoolExecutor;
    }

    public final synchronized void a() {
        while (!this.w.isEmpty()) {
            try {
                BinderC1587uw2 binderC1587uw2 = this.x;
                if (binderC1587uw2 == null || !binderC1587uw2.isBinderAlive()) {
                    if (!this.y) {
                        this.y = true;
                        try {
                            if (!ConnectionTracker.getInstance().bindService(this.t, this.u, this, 65)) {
                                Log.e("FirebaseInstanceId", "binding to the service failed");
                            }
                        } catch (SecurityException e) {
                            Log.e("FirebaseInstanceId", "Exception while binding the service", e);
                        }
                        this.y = false;
                        while (true) {
                            ArrayDeque arrayDeque = this.w;
                            if (arrayDeque.isEmpty()) {
                                break;
                            } else {
                                ((C1759xw2) arrayDeque.poll()).b.d(null);
                            }
                        }
                    }
                    return;
                }
                this.x.a((C1759xw2) this.w.poll());
            } finally {
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.y = false;
        if (iBinder instanceof BinderC1587uw2) {
            this.x = (BinderC1587uw2) iBinder;
            a();
            return;
        }
        String strValueOf = String.valueOf(iBinder);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 28);
        sb.append("Invalid service connection: ");
        sb.append(strValueOf);
        Log.e("FirebaseInstanceId", sb.toString());
        while (true) {
            ArrayDeque arrayDeque = this.w;
            if (arrayDeque.isEmpty()) {
                return;
            } else {
                ((C1759xw2) arrayDeque.poll()).b.d(null);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        a();
    }
}
