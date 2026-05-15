package defpackage;

import J.N;
import android.os.Process;
import android.util.Pair;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import org.chromium.base.TraceEvent;
import org.chromium.base.task.PostTask;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class X62 implements U62 {
    public static final ReferenceQueue j = new ReferenceQueue();
    public static final HashSet k = new HashSet();
    public final int a;
    public final String b;
    public final int c;
    public volatile long d;
    public final V62 e;
    public final Object f;
    public boolean g;
    public ArrayDeque h;
    public ArrayList i;

    public X62(int i) {
        this(i, "TaskRunnerImpl", 0);
        b();
    }

    public static void b() {
        while (true) {
            W62 w62 = (W62) j.poll();
            if (w62 == null) {
                return;
            }
            N._V_J(3, w62.a);
            HashSet hashSet = k;
            synchronized (hashSet) {
                hashSet.remove(w62);
            }
        }
    }

    public void c() {
        long j_J_II = N._J_II(0, this.c, this.a);
        synchronized (this.f) {
            try {
                ArrayDeque<Runnable> arrayDeque = this.h;
                if (arrayDeque != null) {
                    for (Runnable runnable : arrayDeque) {
                        N._V_JJOO(0, j_J_II, 0L, runnable, runnable.getClass().getName());
                    }
                    this.h = null;
                }
                ArrayList<Pair> arrayList = this.i;
                if (arrayList != null) {
                    for (Pair pair : arrayList) {
                        N._V_JJOO(0, j_J_II, ((Long) pair.second).longValue(), (Runnable) pair.first, pair.getClass().getName());
                    }
                    this.i = null;
                }
                this.d = j_J_II;
            } catch (Throwable th) {
                throw th;
            }
        }
        HashSet hashSet = k;
        synchronized (hashSet) {
            hashSet.add(new W62(this));
        }
        b();
    }

    public final void d() {
        if (this.g) {
            return;
        }
        this.g = true;
        synchronized (PostTask.a) {
            ArrayList arrayList = PostTask.b;
            if (arrayList == null) {
                c();
                return;
            }
            arrayList.add(this);
            this.h = new ArrayDeque();
            this.i = new ArrayList();
        }
    }

    public final void e(Runnable runnable, long j2) {
        Object obj = PostTask.a;
        if (this.d != 0) {
            N._V_JJOO(0, this.d, j2, runnable, runnable.getClass().getName());
            return;
        }
        synchronized (this.f) {
            try {
                d();
                if (this.d != 0) {
                    N._V_JJOO(0, this.d, j2, runnable, runnable.getClass().getName());
                    return;
                }
                if (j2 == 0) {
                    this.h.add(runnable);
                    i();
                } else if (!h(runnable, j2)) {
                    this.i.add(new Pair(runnable, Long.valueOf(j2)));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f(Runnable runnable) {
        e(runnable, 0L);
    }

    public void g() {
        TraceEvent traceEventJ = TraceEvent.j(this.b, null);
        try {
            synchronized (this.f) {
                ArrayDeque arrayDeque = this.h;
                if (arrayDeque == null) {
                    if (traceEventJ != null) {
                        traceEventJ.close();
                        return;
                    }
                    return;
                }
                Runnable runnable = (Runnable) arrayDeque.poll();
                int i = this.a;
                if (i == 0 || i == 1) {
                    Process.setThreadPriority(10);
                } else if (i == 2 || i == 3) {
                    Process.setThreadPriority(0);
                } else if (i == 4 || i == 5) {
                    Process.setThreadPriority(-1);
                }
                runnable.run();
                if (traceEventJ != null) {
                    traceEventJ.close();
                }
            }
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

    public boolean h(Runnable runnable, long j2) {
        return false;
    }

    public void i() {
        PostTask.d.execute(this.e);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [V62] */
    public X62(int i, String str, int i2) {
        this.e = new Runnable() { // from class: V62
            @Override // java.lang.Runnable
            public final void run() {
                this.t.g();
            }
        };
        this.f = new Object();
        this.a = i;
        this.b = str.concat(".PreNativeTask.run");
        this.c = i2;
    }
}
