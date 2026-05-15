package defpackage;

import android.util.Pair;
import org.chromium.base.TraceEvent;
import org.chromium.base.task.PostTask;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class az implements Runnable {
    public final /* synthetic */ bz t;

    public az(bz bzVar) {
        this.t = bzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.t.getClass();
        Object obj = PostTask.a;
        if (this.t.b) {
            return;
        }
        Pair pair = (Pair) this.t.a.pop();
        TraceEvent traceEventJ = TraceEvent.j("ChainedTask.run: ".concat(((Runnable) pair.second).getClass().getName()), null);
        try {
            ((Runnable) pair.second).run();
            if (traceEventJ != null) {
                traceEventJ.close();
            }
            if (this.t.a.isEmpty()) {
                return;
            }
            PostTask.c(((Integer) ((Pair) this.t.a.peek()).first).intValue(), this);
        } catch (Throwable th) {
            if (traceEventJ != null) {
                try {
                    traceEventJ.close();
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
    }
}
