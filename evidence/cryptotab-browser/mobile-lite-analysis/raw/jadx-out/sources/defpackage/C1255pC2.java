package defpackage;

/* JADX INFO: renamed from: pC2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1255pC2 extends P23 {
    public final /* synthetic */ LC2 u;

    public C1255pC2(LC2 lc2) {
        this.u = lc2;
    }

    @Override // defpackage.P23
    public final void a() {
        LC2 lc2 = this.u;
        C0562eD2 c0562eD2 = lc2.t;
        c0562eD2.b.c("unlinkToDeath", new Object[0]);
        c0562eD2.l.asBinder().unlinkToDeath(c0562eD2.i, 0);
        C0562eD2 c0562eD22 = lc2.t;
        c0562eD22.l = null;
        c0562eD22.g = false;
    }
}
