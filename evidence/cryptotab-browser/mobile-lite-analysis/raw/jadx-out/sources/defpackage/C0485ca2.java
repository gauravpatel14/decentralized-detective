package defpackage;

/* JADX INFO: renamed from: ca2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0485ca2 extends WQ1 {
    public static final MT[] c;
    public static final MT d;
    public long b;

    static {
        MT[] mtArr = {new MT(16, 0)};
        c = mtArr;
        d = mtArr[0];
    }

    public static C0485ca2 d(C0965kV c0965kV) {
        if (c0965kV == null) {
            return null;
        }
        c0965kV.b();
        try {
            c0965kV.c(c);
            C0485ca2 c0485ca2 = new C0485ca2(16);
            c0485ca2.b = c0965kV.q(8);
            return c0485ca2;
        } finally {
            c0965kV.a();
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70Var.s(d).d(8, this.b);
    }
}
