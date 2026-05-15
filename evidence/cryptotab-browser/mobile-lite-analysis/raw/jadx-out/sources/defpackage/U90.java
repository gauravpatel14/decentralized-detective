package defpackage;

import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.impl.CoreImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class U90 implements T90 {
    @Override // defpackage.T90
    public final void H1(bz0 bz0Var, C0974ka0 c0974ka0) {
        if (XE.a(AbstractC1499tM.a)) {
            S90 s90 = new S90(c0974ka0);
            FS0 fs0N1 = bz0Var.t.n1();
            gx1 gx1Var = new gx1(fs0N1);
            CoreImpl coreImplF0 = fs0N1.f0();
            gx1Var.t.x = s90;
            gx1Var.u = new C0787ha0(coreImplF0, s90);
            gx1Var.a();
            return;
        }
        R90 r90 = new R90(c0974ka0);
        FS0 fs0N12 = bz0Var.t.n1();
        gx1 gx1Var2 = new gx1(fs0N12);
        CoreImpl coreImplF02 = fs0N12.f0();
        gx1Var2.t.x = r90;
        gx1Var2.u = new C0787ha0(coreImplF02, r90);
        gx1Var2.a();
    }

    @Override // defpackage.Ny0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // defpackage.DJ
    public final void d(MojoException mojoException) {
    }
}
