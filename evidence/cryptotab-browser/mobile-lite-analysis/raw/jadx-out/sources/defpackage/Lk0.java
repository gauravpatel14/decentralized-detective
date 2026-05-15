package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Lk0 {
    public static Object a(InterfaceFutureC1199oH0 interfaceFutureC1199oH0) {
        Object obj;
        interfaceFutureC1199oH0.isDone();
        boolean z = false;
        while (true) {
            try {
                obj = interfaceFutureC1199oH0.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }
}
