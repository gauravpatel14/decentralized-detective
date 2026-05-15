package defpackage;

import J.N;
import org.chromium.base.Callback;
import org.chromium.base.task.PostTask;
import org.chromium.components.crash.PureJavaExceptionHandler;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class sW0 implements Runnable {
    public final /* synthetic */ Throwable t;
    public final /* synthetic */ Callback u;

    public /* synthetic */ sW0(Throwable th, Callback callback) {
        this.t = th;
        this.u = callback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = PureJavaExceptionHandler.c;
        final Throwable th = this.t;
        if (z) {
            this.u.a0(th);
        } else {
            PostTask.c(6, new Runnable() { // from class: tW0
                @Override // java.lang.Runnable
                public final void run() {
                    N._V_ZO(0, false, th);
                }
            });
        }
    }
}
