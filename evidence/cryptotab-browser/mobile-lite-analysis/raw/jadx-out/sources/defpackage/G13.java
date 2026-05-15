package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class G13 extends UY2 {
    public final /* synthetic */ n33 u;

    public G13(n33 n33Var) {
        this.u = n33Var;
    }

    @Override // defpackage.UY2
    public final void a() {
        synchronized (this.u.f) {
            try {
                if (this.u.j.get() > 0 && this.u.j.decrementAndGet() > 0) {
                    this.u.b.b("Leaving the connection open for other ongoing calls.", new Object[0]);
                    return;
                }
                n33 n33Var = this.u;
                if (n33Var.l != null) {
                    n33Var.b.b("Unbind from service.", new Object[0]);
                    n33 n33Var2 = this.u;
                    n33Var2.a.unbindService(n33Var2.k);
                    n33 n33Var3 = this.u;
                    n33Var3.g = false;
                    n33Var3.l = null;
                    n33Var3.k = null;
                }
                this.u.d();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
