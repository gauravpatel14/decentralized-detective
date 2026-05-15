package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class J13 extends BroadcastReceiver {
    public final /* synthetic */ C1189o33 a;

    public /* synthetic */ J13(C1189o33 c1189o33) {
        this.a = c1189o33;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        C1189o33 c1189o33 = this.a;
        c1189o33.getClass();
        Bundle bundleExtra = intent.getBundleExtra("session_state");
        if (bundleExtra == null) {
            return;
        }
        IB2 ib2B = IB2.b(bundleExtra);
        c1189o33.a.getClass();
        c1189o33.h.getClass();
        QD2 qd2 = (QD2) GZ2.u.get();
        if (ib2B.b != 3 || qd2 == null) {
            c1189o33.c(ib2B);
            return;
        }
        O23 o23 = new O23(c1189o33, ib2B, intent, context);
        if (NM1.e.get() == null) {
            throw new IllegalStateException("Ingestion should only be called in SplitCompat mode.");
        }
        qd2.d.execute(new JD2(qd2, ib2B.i, o23));
    }
}
