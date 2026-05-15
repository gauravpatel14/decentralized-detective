package defpackage;

/* JADX INFO: renamed from: eX2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0590eX2 extends AbstractC1546uE2 {
    public final /* synthetic */ C0651fX2 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0590eX2(C0651fX2 c0651fX2, C1391rR2 c1391rR2) {
        super(c1391rR2);
        this.e = c0651fX2;
    }

    @Override // defpackage.AbstractC1546uE2
    public final void b() throws Throwable {
        C0651fX2 c0651fX2 = this.e;
        c0651fX2.k();
        WO2 wo2 = c0651fX2.a.i;
        C1391rR2.k(wo2);
        wo2.n.a("Starting upload from DelayedRunnable");
        c0651fX2.b.t();
    }
}
