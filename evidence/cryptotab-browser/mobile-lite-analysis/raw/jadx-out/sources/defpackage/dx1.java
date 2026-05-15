package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class dx1 implements Runnable {
    public final /* synthetic */ gx1 t;

    public dx1(gx1 gx1Var) {
        this.t = gx1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.t.close();
    }
}
