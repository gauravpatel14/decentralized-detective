package defpackage;

import org.chromium.mojo.system.impl.CoreImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Ly0 {
    public final Ky0 a(FS0 fs0, int i) {
        gx1 gx1Var = new gx1(fs0);
        CoreImpl coreImplF0 = fs0.f0();
        Ky0 ky0C = c(coreImplF0, new C0491ci(coreImplF0, gx1Var));
        FW fw = new FW();
        fw.t.add(ky0C);
        gx1Var.t.x = fw;
        gx1Var.a();
        ky0C.a().v = i;
        return ky0C;
    }

    public final gx1 b(Ny0 ny0, FS0 fs0) {
        gx1 gx1Var = new gx1(fs0);
        CoreImpl coreImplF0 = fs0.f0();
        gx1Var.t.x = ny0;
        gx1Var.u = d(coreImplF0, ny0);
        gx1Var.a();
        return gx1Var;
    }

    public abstract Ky0 c(CoreImpl coreImpl, C0491ci c0491ci);

    public abstract My0 d(CoreImpl coreImpl, Ny0 ny0);

    public abstract String e();
}
