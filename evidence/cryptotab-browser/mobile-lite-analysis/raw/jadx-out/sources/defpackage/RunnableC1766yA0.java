package defpackage;

import android.os.Handler;

/* JADX INFO: renamed from: yA0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1766yA0 implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ AA0 u;

    public /* synthetic */ RunnableC1766yA0(AA0 aa0, int i) {
        this.t = i;
        this.u = aa0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AA0 aa0 = this.u;
        switch (this.t) {
            case 0:
                aa0.a.getClass();
                int i = AbstractC1872zv.a;
                break;
            default:
                BA0 ba0 = BA0.b;
                aa0.getClass();
                Handler handler = AbstractC1819zA0.a;
                handler.post(new RunnableC1713xA0(aa0.a, ba0, false, handler, null));
                if (aa0.c.get()) {
                    handler.post(new RunnableC1713xA0(aa0.a, ba0, true, handler, null));
                    handler.postDelayed(aa0.b, 5000L);
                }
                break;
        }
    }
}
