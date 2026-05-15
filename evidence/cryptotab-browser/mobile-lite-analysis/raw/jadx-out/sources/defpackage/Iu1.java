package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Iu1 implements Runnable {
    public final /* synthetic */ C0729gh0 t;
    public final /* synthetic */ Object u;

    public Iu1(C0729gh0 c0729gh0, Object obj) {
        this.t = c0729gh0;
        this.u = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.t.accept(this.u);
    }
}
