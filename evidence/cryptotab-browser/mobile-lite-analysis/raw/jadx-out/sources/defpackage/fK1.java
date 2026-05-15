package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class fK1 extends Bh0 implements ss1 {
    public final KG0 u;
    public final gK1 v;
    public final dK1 w;

    public fK1(KG0 kg0, gK1 gk1, eK1 ek1) {
        dK1 dk1 = new dK1(ek1);
        this.v = gk1;
        this.w = dk1;
        this.u = kg0;
        kg0.l(this);
    }

    @Override // defpackage.ss1
    public final int g() {
        return this.u.u.size();
    }

    @Override // defpackage.ss1
    public final int getItemViewType(int i) {
        gK1 gk1 = this.v;
        if (gk1 == null) {
            return 0;
        }
        return gk1.b(this.u.u.get(i));
    }

    @Override // defpackage.ss1
    public final void i(ps1 ps1Var, int i, Object obj) {
        Object obj2 = this.u.u.get(i);
        dK1 dk1 = this.w;
        dk1.getClass();
        dk1.a.c(ps1Var, obj2);
    }
}
