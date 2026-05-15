package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class H41 implements vx {
    public final AbstractC1815z41 t;
    public final /* synthetic */ J41 u;

    public H41(J41 j41, AbstractC1815z41 abstractC1815z41) {
        this.u = j41;
        this.t = abstractC1815z41;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [Ik0, hk0] */
    @Override // defpackage.vx
    public final void cancel() {
        J41 j41 = this.u;
        Ye ye = j41.b;
        AbstractC1815z41 abstractC1815z41 = this.t;
        ye.remove(abstractC1815z41);
        if (lz0.a(j41.c, abstractC1815z41)) {
            abstractC1815z41.a();
            j41.c = null;
        }
        abstractC1815z41.b.remove(this);
        ?? r0 = abstractC1815z41.c;
        if (r0 != 0) {
            r0.c();
        }
        abstractC1815z41.c = null;
    }
}
