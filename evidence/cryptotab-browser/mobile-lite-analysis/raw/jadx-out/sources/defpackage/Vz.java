package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Vz implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ Object u;

    public /* synthetic */ Vz(int i, Object obj) {
        this.t = i;
        this.u = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.t) {
            case 0:
                C0619fA c0619fA = (C0619fA) this.u;
                if (!c0619fA.k && !c0619fA.m && !c0619fA.B) {
                    C0619fA.K = true;
                    boolean z = c0619fA.s.A;
                    boolean z2 = c0619fA.t.A;
                    boolean z3 = C0619fA.I && c0619fA.u.A;
                    boolean z4 = c0619fA.v.A;
                    c0619fA.j();
                    if (!z || c0619fA.s.a()) {
                        if (!z2 || c0619fA.t.a()) {
                            if ((!z3 || c0619fA.u.a()) && z4) {
                                c0619fA.v.a();
                            }
                        }
                    }
                    break;
                }
                break;
            default:
                ((Zz) this.u).a.i();
                break;
        }
    }
}
