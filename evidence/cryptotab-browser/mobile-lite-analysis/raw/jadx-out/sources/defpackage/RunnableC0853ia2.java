package defpackage;

import kotlinx.coroutines.TimeoutCancellationException;

/* JADX INFO: renamed from: ia2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0853ia2 extends Kz1 implements Runnable {
    public final long w;

    /* JADX WARN: Illegal instructions before constructor call */
    public RunnableC0853ia2(long j, InterfaceC1670wN interfaceC1670wN) {
        yN yNVar = (yN) interfaceC1670wN;
        super(yNVar.u, yNVar);
        this.w = j;
    }

    @Override // defpackage.YA0
    public final String E() {
        return super.E() + "(timeMillis=" + this.w + ')';
    }

    @Override // java.lang.Runnable
    public final void run() {
        g(new TimeoutCancellationException("Timed out waiting for " + this.w + " ms", this));
    }
}
