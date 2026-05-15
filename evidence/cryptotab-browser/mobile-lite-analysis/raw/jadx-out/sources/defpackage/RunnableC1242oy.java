package defpackage;

/* JADX INFO: renamed from: oy, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1242oy implements Runnable {
    public final /* synthetic */ C1358qy t;
    public final /* synthetic */ DQ0 u;
    public final /* synthetic */ MenuC0775hQ0 v;
    public final /* synthetic */ C1300py w;

    public RunnableC1242oy(C1300py c1300py, C1358qy c1358qy, DQ0 dq0, MenuC0775hQ0 menuC0775hQ0) {
        this.w = c1300py;
        this.t = c1358qy;
        this.u = dq0;
        this.v = menuC0775hQ0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1358qy c1358qy = this.t;
        if (c1358qy != null) {
            C1300py c1300py = this.w;
            c1300py.a.S = true;
            c1358qy.b.c(false);
            c1300py.a.S = false;
        }
        DQ0 dq0 = this.u;
        if (dq0.isEnabled() && dq0.hasSubMenu()) {
            this.v.q(dq0, null, 4);
        }
    }
}
