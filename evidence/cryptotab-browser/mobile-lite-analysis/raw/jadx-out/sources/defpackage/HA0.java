package defpackage;

import J.N;
import org.chromium.base.JavaHandlerThread;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class HA0 implements Runnable {
    public final /* synthetic */ long t;
    public final /* synthetic */ JavaHandlerThread u;

    public HA0(JavaHandlerThread javaHandlerThread, long j) {
        this.u = javaHandlerThread;
        this.t = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.u.a.quit();
        N._V_J(0, this.t);
    }
}
