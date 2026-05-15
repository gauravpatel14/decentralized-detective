package defpackage;

/* JADX INFO: renamed from: Wj2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0270Wj2 extends WQ1 {
    public static final MT[] d;
    public static final MT e;
    public long b;
    public long c;

    static {
        MT[] mtArr = {new MT(24, 0)};
        d = mtArr;
        e = mtArr[0];
    }

    public static C0270Wj2 d(C0965kV c0965kV) {
        if (c0965kV == null) {
            return null;
        }
        c0965kV.b();
        try {
            c0965kV.c(d);
            C0270Wj2 c0270Wj2 = new C0270Wj2(24);
            c0270Wj2.b = c0965kV.q(8);
            c0270Wj2.c = c0965kV.q(16);
            return c0270Wj2;
        } finally {
            c0965kV.a();
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70 i70VarS = i70Var.s(e);
        i70VarS.d(8, this.b);
        i70VarS.d(16, this.c);
    }
}
