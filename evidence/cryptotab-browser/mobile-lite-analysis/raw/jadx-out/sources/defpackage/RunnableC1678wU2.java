package defpackage;

/* JADX INFO: renamed from: wU2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1678wU2 implements Runnable {
    public final /* synthetic */ Boolean t;
    public final /* synthetic */ IU2 u;

    public RunnableC1678wU2(IU2 iu2, Boolean bool) {
        this.u = iu2;
        this.t = bool;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.u.y(this.t, true);
    }
}
