package defpackage;

import J.N;
import java.util.HashMap;
import java.util.concurrent.Executor;
import org.chromium.mojo.system.impl.CoreImpl;
import org.chromium.mojo.system.impl.WatcherImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class gx1 implements LS0, InterfaceC1527tn0 {
    public final hK t;
    public My0 u;
    public long v;
    public final HashMap w;
    public final Executor x;

    public gx1(FS0 fs0) {
        WatcherImpl watcherImpl;
        if (fs0.f0() != null) {
            fs0.f0().getClass();
            watcherImpl = new WatcherImpl();
            watcherImpl.a = N._J_O(49, watcherImpl);
        } else {
            watcherImpl = null;
        }
        this.v = 1L;
        this.w = new HashMap();
        hK hKVar = new hK(fs0, watcherImpl);
        this.t = hKVar;
        hKVar.w = new ex1(this);
        CoreImpl coreImplF0 = fs0.f0();
        if (coreImplF0 != null) {
            this.x = L80.a(coreImplF0);
        } else {
            this.x = null;
        }
    }

    @Override // defpackage.InterfaceC1527tn0
    public final FS0 F1() {
        hK hKVar = this.t;
        WatcherImpl watcherImpl = hKVar.v;
        long j = watcherImpl.a;
        if (j != 0) {
            watcherImpl.b = null;
            N._V_JO(275, j, watcherImpl);
        }
        long j2 = watcherImpl.a;
        if (j2 != 0) {
            N._V_JO(276, j2, watcherImpl);
            watcherImpl.a = 0L;
        }
        FS0 fs0N1 = hKVar.u.n1();
        ex1 ex1Var = hKVar.w;
        if (ex1Var != null) {
            ex1Var.close();
        }
        return fs0N1;
    }

    @Override // defpackage.LS0
    public final boolean N(ER0 er0, KS0 ks0) {
        SE1 se1A = er0.a();
        long j = this.v;
        long j2 = 1 + j;
        this.v = j2;
        if (j == 0) {
            this.v = j + 2;
            j = j2;
        }
        HashMap map = this.w;
        if (map.containsKey(Long.valueOf(j))) {
            throw new IllegalStateException("Unable to find a new request identifier.");
        }
        wS0 ws0 = se1A.d;
        se1A.a.putLong(24, j);
        ws0.d = j;
        if (!this.t.g(se1A)) {
            return false;
        }
        map.put(Long.valueOf(j), ks0);
        return true;
    }

    public final void a() {
        hK hKVar = this.t;
        hKVar.getClass();
        hKVar.v.a(hKVar.u, SN.c, hKVar.t);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.t.close();
    }

    @Override // defpackage.KS0
    public final boolean g(ER0 er0) {
        return this.t.g(er0);
    }
}
