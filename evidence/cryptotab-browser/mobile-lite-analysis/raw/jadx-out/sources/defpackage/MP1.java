package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class MP1 extends WQ1 {
    public static final MT c = new MT[]{new MT(16, 0)}[0];
    public short[] b;

    public MP1() {
        super(16);
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70 i70VarS = i70Var.s(c);
        short[] sArr = this.b;
        if (sArr == null) {
            i70VarS.p(8, Ip.a(0));
        } else {
            i70VarS.r(2, sArr.length, 8, -1).b.b.asShortBuffer().put(sArr);
        }
    }
}
