package defpackage;

import android.os.Process;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: renamed from: nw, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1176nw extends Thread {
    public final PriorityBlockingQueue t;
    public final PriorityBlockingQueue u;
    public final c00 v;
    public final J80 w;
    public volatile boolean x = false;
    public final C0049Dq2 y;

    public C1176nw(PriorityBlockingQueue priorityBlockingQueue, PriorityBlockingQueue priorityBlockingQueue2, c00 c00Var, J80 j80) {
        this.t = priorityBlockingQueue;
        this.u = priorityBlockingQueue2;
        this.v = c00Var;
        this.w = j80;
        this.y = new C0049Dq2(this, priorityBlockingQueue2, j80);
    }

    private void a() {
        AbstractC1701wu1 abstractC1701wu1 = (AbstractC1701wu1) this.t.take();
        abstractC1701wu1.getClass();
        int i = AbstractC1528tq2.a;
        abstractC1701wu1.m(1);
        try {
            if (abstractC1701wu1.i()) {
                abstractC1701wu1.c();
            } else {
                C0994kw c0994kwA = this.v.a(abstractC1701wu1.f());
                if (c0994kwA != null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (c0994kwA.e < jCurrentTimeMillis) {
                        abstractC1701wu1.E = c0994kwA;
                        if (!this.y.a(abstractC1701wu1)) {
                            this.u.put(abstractC1701wu1);
                        }
                    } else {
                        ov1 ov1VarL = abstractC1701wu1.l(new C1223oY0(c0994kwA.a, c0994kwA.g));
                        if (!(ov1VarL.c == null)) {
                            c00 c00Var = this.v;
                            String strF = abstractC1701wu1.f();
                            synchronized (c00Var) {
                                C0994kw c0994kwA2 = c00Var.a(strF);
                                if (c0994kwA2 != null) {
                                    c0994kwA2.f = 0L;
                                    c0994kwA2.e = 0L;
                                    c00Var.f(strF, c0994kwA2);
                                }
                            }
                            abstractC1701wu1.E = null;
                            if (!this.y.a(abstractC1701wu1)) {
                                this.u.put(abstractC1701wu1);
                            }
                        } else if (c0994kwA.f < jCurrentTimeMillis) {
                            abstractC1701wu1.E = c0994kwA;
                            ov1VarL.d = true;
                            if (this.y.a(abstractC1701wu1)) {
                                this.w.a(abstractC1701wu1, ov1VarL, null);
                            } else {
                                this.w.a(abstractC1701wu1, ov1VarL, new RunnableC1115mw(this, abstractC1701wu1));
                            }
                        } else {
                            this.w.a(abstractC1701wu1, ov1VarL, null);
                        }
                    }
                } else if (!this.y.a(abstractC1701wu1)) {
                    this.u.put(abstractC1701wu1);
                }
            }
        } finally {
            abstractC1701wu1.m(2);
        }
    }

    public final void b() {
        this.x = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        this.v.d();
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.x) {
                    Thread.currentThread().interrupt();
                    return;
                }
                AbstractC1583uq2.b("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
