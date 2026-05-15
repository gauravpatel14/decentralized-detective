package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class NG0 implements QG0 {
    public final Object t;
    public final RG0 u;
    public final MG0 v;

    public NG0(RG0 rg0, Object obj, MG0 mg0) {
        this.u = rg0;
        this.t = obj;
        this.v = mg0;
    }

    @Override // defpackage.QG0
    public final void e(SG0 sg0, int i, int i2, Object obj) {
        this.v.e(i, i2, this.u, this.t, obj);
    }

    @Override // defpackage.QG0
    public final void f(int i, int i2) {
        this.v.d(i, i2, this.u, this.t);
    }

    @Override // defpackage.QG0
    public final void j(SG0 sg0, int i, int i2) {
        this.v.b(i, i2, this.u, this.t);
    }
}
