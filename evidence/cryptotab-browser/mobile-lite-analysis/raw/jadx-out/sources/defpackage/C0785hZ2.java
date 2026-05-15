package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: renamed from: hZ2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0785hZ2 extends BroadcastReceiver {
    public boolean a;
    public final boolean b;
    public final /* synthetic */ RZ2 c;

    public C0785hZ2(RZ2 rz2, boolean z) {
        this.c = rz2;
        this.b = z;
    }

    public final synchronized void a(Context context, IntentFilter intentFilter) {
        try {
            if (this.a) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(this, intentFilter, true != this.b ? 4 : 2);
            } else {
                context.registerReceiver(this, intentFilter);
            }
            this.a = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void b(Bundle bundle, Cp cp, int i) {
        HI2 hi2A;
        if (bundle.getByteArray("FAILURE_LOGGING_PAYLOAD") == null) {
            this.c.c.a(CI2.a(23, i, cp));
            return;
        }
        try {
            WI2 wi2 = this.c.c;
            byte[] byteArray = bundle.getByteArray("FAILURE_LOGGING_PAYLOAD");
            int i2 = HI2.a;
            synchronized (HI2.class) {
                int i3 = HI2.a;
                hi2A = AbstractC0831iJ2.a();
                int i4 = HI2.a;
            }
            wi2.a(OQ2.l(byteArray, hi2A));
        } catch (Throwable unused) {
            AbstractC1659wF2.e("BillingBroadcastManager", "Failed parsing Api failure.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ea  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onReceive(android.content.Context r10, android.content.Intent r11) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0785hZ2.onReceive(android.content.Context, android.content.Intent):void");
    }
}
