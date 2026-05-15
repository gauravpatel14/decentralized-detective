package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class U30 implements Runnable {
    public final /* synthetic */ V30 t;

    public U30(V30 v30) {
        this.t = v30;
    }

    @Override // java.lang.Runnable
    public final void run() {
        V30 v30 = this.t;
        v30.E = null;
        v30.drawableStateChanged();
    }
}
