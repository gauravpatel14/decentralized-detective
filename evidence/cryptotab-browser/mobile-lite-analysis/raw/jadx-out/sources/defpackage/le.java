package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class le extends J62 {
    public static volatile le b;
    public static final ke c = new ke();
    public final C1566uW a = new C1566uW();

    public static le a() {
        if (b != null) {
            return b;
        }
        synchronized (le.class) {
            try {
                if (b == null) {
                    b = new le();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return b;
    }
}
