package defpackage;

import java.util.concurrent.Executor;
import org.chromium.mojo.system.impl.CoreImpl;

/* JADX INFO: renamed from: ci, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0491ci implements LS0, InterfaceC1527tn0 {
    public final gx1 t;
    public final Executor u;
    public final Exception v = new Exception("AutocloseableRouter allocated at:");
    public boolean w;

    public C0491ci(CoreImpl coreImpl, gx1 gx1Var) {
        this.t = gx1Var;
        this.u = L80.a(coreImpl);
    }

    @Override // defpackage.InterfaceC1527tn0
    public final FS0 F1() {
        return this.t.F1();
    }

    @Override // defpackage.LS0
    public final boolean N(ER0 er0, KS0 ks0) {
        return this.t.N(er0, ks0);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.t.close();
        this.w = true;
    }

    public final void finalize() throws Throwable {
        if (this.w) {
            super.finalize();
        } else {
            this.u.execute(new RunnableC0431bi(this));
            throw new IllegalStateException("Warning: Router objects should be explicitly closed when no longer required otherwise you may leak handles.", this.v);
        }
    }

    @Override // defpackage.KS0
    public final boolean g(ER0 er0) {
        return this.t.t.g(er0);
    }
}
