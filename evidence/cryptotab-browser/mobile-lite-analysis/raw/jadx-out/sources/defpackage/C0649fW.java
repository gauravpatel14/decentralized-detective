package defpackage;

/* JADX INFO: renamed from: fW, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0649fW extends Bz1 {
    public static final C0649fW v;

    static {
        int i = Z62.b;
        int i2 = Z62.c;
        long j = Z62.d;
        C0649fW c0649fW = new C0649fW();
        c0649fW.u = new mO(i, i2, j);
        v = c0649fW;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // defpackage.AbstractC0771hO
    public final String toString() {
        return "Dispatchers.Default";
    }
}
