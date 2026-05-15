package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: oU2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1218oU2 implements Runnable {
    public final /* synthetic */ AtomicReference t;
    public final /* synthetic */ IU2 u;

    public RunnableC1218oU2(IU2 iu2, AtomicReference atomicReference) {
        this.u = iu2;
        this.t = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        synchronized (this.t) {
            try {
                try {
                    AtomicReference atomicReference = this.t;
                    C1391rR2 c1391rR2 = this.u.a;
                    C1009lD2 c1009lD2 = c1391rR2.g;
                    String strK = c1391rR2.o().k();
                    C0467cO2 c0467cO2 = AbstractC0579eO2.K;
                    if (strK == null) {
                        c1009lD2.getClass();
                        str = (String) c0467cO2.a(null);
                    } else {
                        str = (String) c0467cO2.a(c1009lD2.c.a(strK, c0467cO2.a));
                    }
                    atomicReference.set(str);
                } finally {
                    this.t.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
