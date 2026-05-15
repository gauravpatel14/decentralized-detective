package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class IH0 extends AbstractC1867zo2 {
    public static final HH0 d = new HH0();
    public final C1325qM1 b = new C1325qM1();
    public boolean c = false;

    @Override // defpackage.AbstractC1867zo2
    public final void b() {
        C1325qM1 c1325qM1 = this.b;
        int i = c1325qM1.v;
        for (int i2 = 0; i2 < i; i2++) {
            FH0 fh0 = (FH0) c1325qM1.u[i2];
            AbstractC1230og abstractC1230og = fh0.l;
            abstractC1230og.a();
            abstractC1230og.c = true;
            GH0 gh0 = fh0.n;
            if (gh0 != null) {
                fh0.g(gh0);
            }
            FH0 fh02 = abstractC1230og.a;
            if (fh02 == null) {
                throw new IllegalStateException("No listener register");
            }
            if (fh02 != fh0) {
                throw new IllegalArgumentException("Attempting to unregister the wrong listener");
            }
            abstractC1230og.a = null;
            if (gh0 != null) {
                boolean z = gh0.b;
            }
            abstractC1230og.d = true;
            abstractC1230og.b = false;
            abstractC1230og.c = false;
            abstractC1230og.e = false;
        }
        int i3 = c1325qM1.v;
        Object[] objArr = c1325qM1.u;
        for (int i4 = 0; i4 < i3; i4++) {
            objArr[i4] = null;
        }
        c1325qM1.v = 0;
    }
}
