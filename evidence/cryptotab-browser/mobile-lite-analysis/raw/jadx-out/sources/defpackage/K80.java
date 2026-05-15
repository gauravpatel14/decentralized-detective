package defpackage;

import J.N;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.impl.CoreImpl;
import org.chromium.mojo.system.impl.WatcherImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class K80 implements Executor, InterfaceC0177Oq2 {
    public final FS0 t;
    public final FS0 u;
    public final ArrayList v;
    public final Object w;
    public final WatcherImpl x;

    public K80(CoreImpl coreImpl) {
        coreImpl.getClass();
        WatcherImpl watcherImpl = new WatcherImpl();
        watcherImpl.a = N._J_O(49, watcherImpl);
        this.x = watcherImpl;
        this.w = new Object();
        BS0 bs0 = new BS0();
        bs0.a = AS0.c;
        J81 j81B = coreImpl.b(bs0);
        FS0 fs0 = (FS0) j81B.a;
        this.u = fs0;
        this.t = (FS0) j81B.b;
        this.v = new ArrayList();
        watcherImpl.a(fs0, SN.c, this);
    }

    @Override // defpackage.InterfaceC0177Oq2
    public final void a(int i) throws IOException {
        Runnable runnable;
        if (i == 0) {
            try {
                FS0 fs0 = this.u;
                CS0 cs0 = CS0.c;
                if (fs0.l0().a == 0) {
                    synchronized (this.w) {
                        runnable = (Runnable) this.v.remove(0);
                    }
                    runnable.run();
                    return;
                }
            } catch (MojoException unused) {
            }
        }
        synchronized (this.w) {
            this.t.close();
            this.v.clear();
        }
        WatcherImpl watcherImpl = this.x;
        long j = watcherImpl.a;
        if (j != 0) {
            watcherImpl.b = null;
            N._V_JO(275, j, watcherImpl);
        }
        WatcherImpl watcherImpl2 = this.x;
        long j2 = watcherImpl2.a;
        if (j2 != 0) {
            N._V_JO(276, j2, watcherImpl2);
            watcherImpl2.a = 0L;
        }
        this.u.close();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        synchronized (this.w) {
            try {
                if (!this.t.f()) {
                    throw new IllegalStateException("Trying to execute an action on a closed executor.");
                }
                this.v.add(runnable);
                FS0 fs0 = this.t;
                ThreadLocal threadLocal = L80.a;
                ES0 es0 = ES0.c;
                fs0.g0(null, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
