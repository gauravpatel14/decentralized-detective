package defpackage;

import org.chromium.mojo.bindings.DeserializationException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ln extends WQ1 {
    public static final MT[] c;
    public static final MT d;
    public int[] b;

    static {
        MT[] mtArr = {new MT(16, 0)};
        c = mtArr;
        d = mtArr[0];
    }

    public static ln d(C0965kV c0965kV) {
        if (c0965kV == null) {
            return null;
        }
        c0965kV.b();
        try {
            c0965kV.c(c);
            ln lnVar = new ln(16);
            int i = 0;
            lnVar.b = c0965kV.p(8, 0);
            while (true) {
                int[] iArr = lnVar.b;
                if (i >= iArr.length) {
                    c0965kV.a();
                    return lnVar;
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
