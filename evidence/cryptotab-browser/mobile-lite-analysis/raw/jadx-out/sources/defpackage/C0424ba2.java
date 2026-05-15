package defpackage;

/* JADX INFO: renamed from: ba2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0424ba2 extends WQ1 {
    public static final MT[] c;
    public static final MT d;
    public long b;

    static {
        MT[] mtArr = {new MT(16, 0)};
        c = mtArr;
        d = mtArr[0];
    }

    public static C0424ba2 d(C0965kV c0965kV) {
        if (c0965kV == null) {
            return null;
        }
        c0965kV.b();
        try {
            c0965kV.c(c);
            C0424ba2 c0424ba2 = new C0424ba2(16);
            c0424ba2.b = c0965kV.q(8);
            return c0424ba2;
        } finally {
            c0965kV.a();
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70Var.s(d).d(8, this.b);
    }
}
