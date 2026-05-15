package defpackage;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.android.volley.VolleyError;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: renamed from: kY0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0970kY0 extends Thread {
    public final PriorityBlockingQueue t;
    public final Ho u;
    public final c00 v;
    public final J80 w;
    public volatile boolean x = false;

    public C0970kY0(PriorityBlockingQueue priorityBlockingQueue, Ho ho, c00 c00Var, J80 j80) {
        this.t = priorityBlockingQueue;
        this.u = ho;
        this.v = c00Var;
        this.w = j80;
    }

    private void a() {
        AbstractC1701wu1 abstractC1701wu1 = (AbstractC1701wu1) this.t.take();
        J80 j80 = this.w;
        SystemClock.elapsedRealtime();
        abstractC1701wu1.m(3);
        try {
            try {
                int i = AbstractC1528tq2.a;
                if (abstractC1701wu1.i()) {
                    abstractC1701wu1.c();
                    abstractC1701wu1.j();
                } else {
                    TrafficStats.setThreadStatsTag(abstractC1701wu1.v);
                    C1223oY0 c1223oY0A = this.u.a(abstractC1701wu1);
                    if (c1223oY0A.d && abstractC1701wu1.h()) {
                        abstractC1701wu1.c();
                        abstractC1701wu1.j();
                    } else {
                        ov1 ov1VarL = abstractC1701wu1.l(c1223oY0A);
                        if (abstractC1701wu1.A && ov1VarL.b != null) {
                            this.v.f(abstractC1701wu1.f(), ov1VarL.b);
                        }
                        synchronized (abstractC1701wu1.w) {
                            abstractC1701wu1.C = true;
                        }
                        j80.a(abstractC1701wu1, ov1VarL, null);
                        abstractC1701wu1.k(ov1VarL);
                    }
                }
            } catch (VolleyError e) {
                SystemClock.elapsedRealtime();
                j80.getClass();
                int i2 = AbstractC1528tq2.a;
                j80.a.execute(new I80(abstractC1701wu1, new ov1(e), null));
                abstractC1701wu1.j();
            } catch (Exception e2) {
                Log.e("Volley", AbstractC1583uq2.a("Unhandled exception %s", e2.toString()), e2);
                VolleyError volleyError = new VolleyError(e2);
                SystemClock.elapsedRealtime();
                j80.getClass();
                int i3 = AbstractC1528tq2.a;
                j80.a.execute(new I80(abstractC1701wu1, new ov1(volleyError), null));
                abstractC1701wu1.j();
            }
        } finally {
            abstractC1701wu1.m(4);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.x) {
                    Thread.currentThread().interrupt();
                    return;
                }
                AbstractC1583uq2.b("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
