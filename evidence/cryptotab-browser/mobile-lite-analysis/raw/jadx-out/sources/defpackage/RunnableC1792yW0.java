package defpackage;

/* JADX INFO: renamed from: yW0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1792yW0 implements Runnable {
    public final /* synthetic */ InterfaceC1692wm t;
    public final /* synthetic */ AW0 u;

    public RunnableC1792yW0(AW0 aw0, InterfaceC1692wm interfaceC1692wm) {
        this.u = aw0;
        this.t = interfaceC1692wm;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.u.b) {
            return;
        }
        this.t.a(true);
    }
}
