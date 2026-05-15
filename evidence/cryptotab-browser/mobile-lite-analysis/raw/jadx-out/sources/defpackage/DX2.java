package defpackage;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class DX2 implements Runnable {
    public final /* synthetic */ QX2 t;

    public DX2(QX2 qx2, TX2 tx2) {
        this.t = qx2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        QX2 qx2 = this.t;
        qx2.b().g();
        qx2.k = new C0411bQ2(qx2);
        C0513dE2 c0513dE2 = new C0513dE2(qx2);
        c0513dE2.i();
        qx2.c = c0513dE2;
        qx2.J().c = (InterfaceC0393bD2) Preconditions.checkNotNull(qx2.a);
        EW2 ew2 = new EW2(qx2);
        ew2.i();
        qx2.i = ew2;
        C0334aC2 c0334aC2 = new C0334aC2(qx2);
        c0334aC2.i();
        qx2.f = c0334aC2;
        QU2 qu2 = new QU2(qx2);
        qu2.i();
        qx2.h = qu2;
        C0651fX2 c0651fX2 = new C0651fX2(qx2);
        c0651fX2.i();
        qx2.e = c0651fX2;
        qx2.d = new C1617vP2(qx2);
        if (qx2.q != qx2.r) {
            WO2 wo2D = qx2.d();
            wo2D.f.c(Integer.valueOf(qx2.q), Integer.valueOf(qx2.r), "Not all upload components initialized");
        }
        qx2.m = true;
        qx2.b().g();
        C0513dE2 c0513dE22 = qx2.c;
        QX2.H(c0513dE22);
        c0513dE22.N();
        if (qx2.i.j.a() == 0) {
            qx2.i.j.b(qx2.e().currentTimeMillis());
        }
        qx2.C();
    }
}
