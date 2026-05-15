package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class JT2 implements Runnable {
    public final /* synthetic */ long t;
    public final /* synthetic */ IU2 u;

    public JT2(IU2 iu2, long j) {
        this.u = iu2;
        this.t = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j = this.t;
        IU2 iu2 = this.u;
        iu2.q(j, true);
        iu2.a.s().x(new AtomicReference());
    }
}
