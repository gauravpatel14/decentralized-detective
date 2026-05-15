package defpackage;

import org.chromium.base.task.PostTask;

/* JADX INFO: renamed from: kY, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC0969kY implements Runnable {
    public final /* synthetic */ int t;

    public /* synthetic */ RunnableC0969kY(int i) {
        this.t = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.t) {
            case 0:
                PostTask.c(1, new RunnableC0969kY(1));
                break;
            default:
                AbstractC1034lY.a(Runtime.getRuntime());
                break;
        }
    }
}
