package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class P23 implements Runnable {
    public final H62 t;

    public P23() {
        this.t = null;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Exception e) {
            H62 h62 = this.t;
            if (h62 != null) {
                h62.c(e);
            }
        }
    }

    public P23(H62 h62) {
        this.t = h62;
    }
}
