package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class fx1 implements KS0 {
    public boolean t;
    public final /* synthetic */ gx1 u;

    public fx1(gx1 gx1Var) {
        this.u = gx1Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.u.close();
    }

    public final void finalize() throws Throwable {
        gx1 gx1Var;
        Executor executor;
        if (!this.t && (executor = (gx1Var = this.u).x) != null) {
            executor.execute(new dx1(gx1Var));
        }
        super.finalize();
    }

    @Override // defpackage.KS0
    public final boolean g(ER0 er0) {
        this.t = true;
        return this.u.t.g(er0);
    }
}
