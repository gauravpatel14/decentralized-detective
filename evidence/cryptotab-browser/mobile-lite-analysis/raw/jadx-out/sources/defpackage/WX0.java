package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class WX0 implements Runnable {
    public final /* synthetic */ C0908jY0 t;

    public WX0(C0908jY0 c0908jY0) {
        this.t = c0908jY0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0908jY0 c0908jY0 = this.t;
        if (c0908jY0.l) {
            c0908jY0.l = false;
        } else {
            c0908jY0.b();
        }
    }
}
