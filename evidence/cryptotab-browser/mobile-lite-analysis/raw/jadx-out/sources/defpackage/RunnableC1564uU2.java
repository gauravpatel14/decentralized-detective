package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: uU2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1564uU2 implements Runnable {
    public final /* synthetic */ AtomicReference t;
    public final /* synthetic */ IU2 u;

    public RunnableC1564uU2(IU2 iu2, AtomicReference atomicReference) {
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
                    atomicReference.set(Double.valueOf(c1391rR2.g.i(c1391rR2.o().k(), AbstractC0579eO2.N)));
                } finally {
                    this.t.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
