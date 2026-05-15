package defpackage;

import android.os.Binder;
import android.os.Process;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class pU0 implements Callable {
    public final /* synthetic */ RunnableC1164ng a;

    public pU0(RunnableC1164ng runnableC1164ng) {
        this.a = runnableC1164ng;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        RunnableC1164ng runnableC1164ng = this.a;
        runnableC1164ng.w.set(true);
        try {
            Process.setThreadPriority(10);
            runnableC1164ng.x.d();
            Binder.flushPendingCommands();
            return null;
        } finally {
        }
    }
}
