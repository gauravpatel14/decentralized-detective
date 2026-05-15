package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: sU2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1451sU2 implements Runnable {
    public final /* synthetic */ AtomicReference t;
    public final /* synthetic */ IU2 u;

    public RunnableC1451sU2(IU2 iu2, AtomicReference atomicReference) {
        this.u = iu2;
        this.t = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.t) {
            try {
                try {
                    AtomicReference atomicReference = this.t;
                    C1391rR2 c1391rR2 = this.u.a;
                    atomicReference.set(Integer.valueOf(c1391rR2.g.k(c1391rR2.o().k(), AbstractC0579eO2.M)));
                } finally {
                    this.t.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
