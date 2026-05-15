package defpackage;

import org.chromium.mojo.bindings.DeserializationException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Wm extends zI1 implements KS0 {
    public final Xm t;

    public Wm(Xm xm) {
        this.t = xm;
    }

    @Override // defpackage.KS0
    public final boolean g(ER0 er0) {
        try {
            SE1 se1A = er0.a();
            if (!se1A.d.c(1, 2)) {
                return false;
            }
            Vm vmD = Vm.d(se1A.b());
            Xm xm = this.t;
            int[] iArr = vmD.b;
            Vm vm = new Vm(0);
            vm.b = iArr;
            xm.b.g(vm.c(xm.a, new wS0(1, 2, xm.c)));
            return true;
        } catch (DeserializationException unused) {
            return false;
        }
    }
}
