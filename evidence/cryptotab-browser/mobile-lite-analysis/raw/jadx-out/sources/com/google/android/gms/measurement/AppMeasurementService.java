package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;
import defpackage.AbstractC0085Gq2;
import defpackage.C1391rR2;
import defpackage.KW2;
import defpackage.MS2;
import defpackage.MW2;
import defpackage.OW2;
import defpackage.QX2;
import defpackage.WO2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class AppMeasurementService extends Service implements MW2 {
    public OW2 t;

    @Override // defpackage.MW2
    public final void a(Intent intent) {
        SparseArray sparseArray = AbstractC0085Gq2.a;
        int intExtra = intent.getIntExtra("androidx.contentpager.content.wakelockid", 0);
        if (intExtra == 0) {
            return;
        }
        SparseArray sparseArray2 = AbstractC0085Gq2.a;
        synchronized (sparseArray2) {
            try {
                PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) sparseArray2.get(intExtra);
                if (wakeLock != null) {
                    wakeLock.release();
                    sparseArray2.remove(intExtra);
                } else {
                    Log.w("WakefulBroadcastReceiv.", "No active wake lock id #" + intExtra);
                }
            } finally {
            }
        }
    }

    @Override // defpackage.MW2
    public final boolean b(int i) {
        return stopSelfResult(i);
    }

    @Override // defpackage.MW2
    public final void c(JobParameters jobParameters) {
        throw new UnsupportedOperationException();
    }

    public final OW2 d() {
        if (this.t == null) {
            this.t = new OW2(this);
        }
        return this.t;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        OW2 ow2D = d();
        if (intent == null) {
            ow2D.a().f.a("onBind called with null intent");
            return null;
        }
        ow2D.getClass();
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new MS2(QX2.N(ow2D.a));
        }
        ow2D.a().i.b(action, "onBind received unknown action");
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        WO2 wo2 = C1391rR2.r(d().a, null, null).i;
        C1391rR2.k(wo2);
        wo2.n.a("Local AppMeasurementService is starting up");
    }

    @Override // android.app.Service
    public final void onDestroy() {
        WO2 wo2 = C1391rR2.r(d().a, null, null).i;
        C1391rR2.k(wo2);
        wo2.n.a("Local AppMeasurementService is shutting down");
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        OW2 ow2D = d();
        if (intent == null) {
            ow2D.a().f.a("onRebind called with null intent");
            return;
        }
        ow2D.getClass();
        ow2D.a().n.b(intent.getAction(), "onRebind called. action");
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent intent, int i, final int i2) {
        final OW2 ow2D = d();
        final WO2 wo2 = C1391rR2.r(ow2D.a, null, null).i;
        C1391rR2.k(wo2);
        if (intent == null) {
            wo2.i.a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        wo2.n.c(Integer.valueOf(i2), action, "Local AppMeasurementService called. startId, action");
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            return 2;
        }
        Runnable runnable = new Runnable() { // from class: IW2
            @Override // java.lang.Runnable
            public final void run() {
                OW2 ow2 = ow2D;
                MW2 mw2 = (MW2) ow2.a;
                int i3 = i2;
                if (mw2.b(i3)) {
                    wo2.n.b(Integer.valueOf(i3), "Local AppMeasurementService processed last upload request. StartId");
                    ow2.a().n.a("Completed wakeful intent.");
                    mw2.a(intent);
                }
            }
        };
        QX2 qx2N = QX2.N(ow2D.a);
        qx2N.b().o(new KW2(qx2N, runnable));
        return 2;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        OW2 ow2D = d();
        if (intent == null) {
            ow2D.a().f.a("onUnbind called with null intent");
            return true;
        }
        ow2D.getClass();
        ow2D.a().n.b(intent.getAction(), "onUnbind called for intent. action");
        return true;
    }
}
