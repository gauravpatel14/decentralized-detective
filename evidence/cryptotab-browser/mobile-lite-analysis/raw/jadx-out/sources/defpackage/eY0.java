package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class eY0 implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ fY0 u;

    public eY0(fY0 fy0, int i) {
        this.u = fy0;
        this.t = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.u.b.d.a(this.t);
    }
}
