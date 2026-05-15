package defpackage;

/* JADX INFO: renamed from: sC2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1428sC2 {
    public static C1428sC2 a;

    public static synchronized C1428sC2 a() {
        try {
            if (a == null) {
                a = new C1428sC2();
            }
        } catch (Throwable th) {
            throw th;
        }
        return a;
    }
}
