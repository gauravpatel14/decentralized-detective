package com.google.android.gms.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.SparseArray;
import defpackage.AbstractC0085Gq2;
import defpackage.C0581eQ2;
import defpackage.C1391rR2;
import defpackage.WO2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class AppMeasurementReceiver extends AbstractC0085Gq2 {
    public C0581eQ2 c;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.c == null) {
            this.c = new C0581eQ2(this);
        }
        C0581eQ2 c0581eQ2 = this.c;
        c0581eQ2.getClass();
        WO2 wo2 = C1391rR2.r(context, null, null).i;
        C1391rR2.k(wo2);
        if (intent == null) {
            wo2.i.a("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        wo2.n.b(action, "Local receiver got");
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
                wo2.i.a("Install Referrer Broadcasts are deprecated");
                return;
            }
            return;
        }
        Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        wo2.n.a("Starting wakeful intent.");
        c0581eQ2.a.getClass();
        SparseArray sparseArray = AbstractC0085Gq2.a;
        synchronized (sparseArray) {
            try {
                int i = AbstractC0085Gq2.b;
                int i2 = i + 1;
                AbstractC0085Gq2.b = i2;
                if (i2 <= 0) {
                    AbstractC0085Gq2.b = 1;
                }
                className.putExtra("androidx.contentpager.content.wakelockid", i);
                ComponentName componentNameStartService = context.startService(className);
                if (componentNameStartService == null) {
                    return;
                }
                PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "androidx.core:wake:" + componentNameStartService.flattenToShortString());
                wakeLockNewWakeLock.setReferenceCounted(false);
                wakeLockNewWakeLock.acquire(60000L);
                sparseArray.put(i, wakeLockNewWakeLock);
            } finally {
            }
        }
    }
}
