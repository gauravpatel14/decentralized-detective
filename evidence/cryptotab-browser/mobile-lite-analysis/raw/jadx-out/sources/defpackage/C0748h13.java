package defpackage;

/* JADX INFO: renamed from: h13, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0748h13 extends UY2 {
    public final /* synthetic */ H62 u;
    public final /* synthetic */ UY2 v;
    public final /* synthetic */ n33 w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0748h13(n33 n33Var, H62 h62, H62 h622, UY2 uy2) {
        super(h62);
        this.w = n33Var;
        this.u = h622;
        this.v = uy2;
    }

    @Override // defpackage.UY2
    public final void a() {
        synchronized (this.w.f) {
            try {
                final n33 n33Var = this.w;
                final H62 h62 = this.u;
                n33Var.e.add(h62);
                h62.a.a(new N41() { // from class: QZ2
                    @Override // defpackage.N41
                    public final void onComplete(G62 g62) {
                        n33 n33Var2 = n33Var;
                        H62 h622 = h62;
                        synchronized (n33Var2.f) {
                            n33Var2.e.remove(h622);
                        }
                    }
                });
                if (this.w.j.getAndIncrement() > 0) {
                    this.w.b.b("Already connected to the service.", new Object[0]);
                }
                n33.b(this.w, this.v);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
