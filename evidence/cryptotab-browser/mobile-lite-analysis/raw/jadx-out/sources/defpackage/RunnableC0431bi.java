package defpackage;

/* JADX INFO: renamed from: bi, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0431bi implements Runnable {
    public final /* synthetic */ C0491ci t;

    public RunnableC0431bi(C0491ci c0491ci) {
        this.t = c0491ci;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.t.close();
    }
}
