package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class JV2 extends AbstractC1546uE2 {
    public final /* synthetic */ CW2 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JV2(CW2 cw2, C1391rR2 c1391rR2) {
        super(c1391rR2);
        this.e = cw2;
    }

    @Override // defpackage.AbstractC1546uE2
    public final void b() {
        CW2 cw2 = this.e;
        cw2.g();
        if (cw2.m()) {
            WO2 wo2 = cw2.a.i;
            C1391rR2.k(wo2);
            wo2.n.a("Inactivity, disconnecting from the service");
            cw2.w();
        }
    }
}
