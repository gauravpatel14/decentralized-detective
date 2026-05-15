package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ix {
    public final C0269Wi2 a;
    public final Hu1 b;

    public ix(C0269Wi2 c0269Wi2, Hu1 hu1) {
        this.a = c0269Wi2;
        this.b = hu1;
    }

    public final void a(C0795hh0 c0795hh0) {
        int i = c0795hh0.b;
        Hu1 hu1 = this.b;
        C0269Wi2 c0269Wi2 = this.a;
        if (i == 0) {
            hu1.execute(new RunnableC0743gx(c0269Wi2, c0795hh0.a));
        } else {
            hu1.execute(new RunnableC0810hx(c0269Wi2, i));
        }
    }
}
