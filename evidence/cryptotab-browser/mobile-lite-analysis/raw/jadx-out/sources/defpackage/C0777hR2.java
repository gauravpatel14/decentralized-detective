package defpackage;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.AbstractQueue;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: renamed from: hR2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0777hR2 extends Thread {
    public final Object t;
    public final AbstractQueue u;
    public boolean v = false;
    public final /* synthetic */ C0899jR2 w;

    /* JADX WARN: Multi-variable type inference failed */
    public C0777hR2(C0899jR2 c0899jR2, String str, BlockingQueue blockingQueue) {
        this.w = c0899jR2;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.t = new Object();
        this.u = (AbstractQueue) blockingQueue;
        setName(str);
    }

    public final void a() {
        synchronized (this.w.i) {
            try {
                if (!this.v) {
                    this.w.j.release();
                    this.w.i.notifyAll();
                    C0899jR2 c0899jR2 = this.w;
                    if (this == c0899jR2.c) {
                        c0899jR2.c = null;
                    } else if (this == c0899jR2.d) {
                        c0899jR2.d = null;
                    } else {
                        WO2 wo2 = c0899jR2.a.i;
                        C1391rR2.k(wo2);
                        wo2.f.a("Current scheduler thread is neither worker nor network");
                    }
                    this.v = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z = false;
        while (!z) {
            try {
                this.w.j.acquire();
                z = true;
            } catch (InterruptedException e) {
                WO2 wo2 = this.w.a.i;
                C1391rR2.k(wo2);
                wo2.i.b(e, String.valueOf(getName()).concat(" was interrupted"));
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                C0582eR2 c0582eR2 = (C0582eR2) this.u.poll();
                if (c0582eR2 != null) {
                    Process.setThreadPriority(true != c0582eR2.u ? 10 : threadPriority);
                    c0582eR2.run();
                } else {
                    synchronized (this.t) {
                        if (this.u.peek() == null) {
                            this.w.getClass();
                            try {
                                this.t.wait(30000L);
                            } catch (InterruptedException e2) {
                                WO2 wo22 = this.w.a.i;
                                C1391rR2.k(wo22);
                                wo22.i.b(e2, String.valueOf(getName()).concat(" was interrupted"));
                            }
                        }
                    }
                    synchronized (this.w.i) {
                        try {
                            if (this.u.peek() == null) {
                                break;
                            }
                        } finally {
                        }
                    }
                }
            }
            if (this.w.a.g.p(null, AbstractC0579eO2.e0)) {
                a();
            }
            a();
        } catch (Throwable th) {
            a();
            throw th;
        }
    }
}
