package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class YE1 {
    public static final YE1 c;
    public int[] a;
    public boolean b;

    static {
        YE1 ye1 = new YE1();
        ye1.a = new int[4];
        ye1.b = false;
        c = ye1;
    }

    public static int a(boolean z, boolean z2, boolean z3) {
        if (z) {
            return -1;
        }
        return z2 ? z3 ? 3 : 1 : z3 ? 2 : 0;
    }
}
