package defpackage;

import org.chromium.mojo.bindings.DeserializationException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Vm extends WQ1 {
    public static final MT[] c;
    public static final MT d;
    public int[] b;

    static {
        MT[] mtArr = {new MT(16, 0)};
        c = mtArr;
        d = mtArr[0];
    }

    public Vm(int i) {
        super(16);
    }

    public static Vm d(ER0 er0) {
        C0965kV c0965kV = new C0965kV(er0);
        c0965kV.b();
        try {
            Vm vm = new Vm(c0965kV.c(c).b);
            int i = 0;
            vm.b = c0965kV.p(8, 0);
            while (true) {
                int[] iArr = vm.b;
                if (i >= iArr.length) {
                    c0965kV.a();
                    return vm;
                }
                int i2 = iArr[i];
                if (i2 < 0 || i2 > 13) {
                    break;
                }
                iArr[i] = i2;
                i++;
            }
            throw new DeserializationException("Invalid enum value.");
        } catch (Throwable th) {
            c0965kV.a();
            throw th;
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70Var.s(d).c(8, 0, this.b);
    }
}
