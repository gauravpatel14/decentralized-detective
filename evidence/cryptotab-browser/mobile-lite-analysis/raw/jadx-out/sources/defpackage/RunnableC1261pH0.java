package defpackage;

/* JADX INFO: renamed from: pH0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1261pH0 implements Runnable {
    public final /* synthetic */ AbstractC1493tH0 t;

    public RunnableC1261pH0(AbstractC1493tH0 abstractC1493tH0) {
        this.t = abstractC1493tH0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        synchronized (this.t.a) {
            obj = this.t.f;
            this.t.f = AbstractC1493tH0.k;
        }
        this.t.h(obj);
    }
}
