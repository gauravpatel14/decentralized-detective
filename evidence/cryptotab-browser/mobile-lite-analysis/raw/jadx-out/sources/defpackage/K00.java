package defpackage;

import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class K00 implements L00 {
    public final ScheduledFuture t;

    public K00(ScheduledFuture scheduledFuture) {
        this.t = scheduledFuture;
    }

    @Override // defpackage.L00
    public final void d() {
        this.t.cancel(false);
    }

    public final String toString() {
        return "DisposableFutureHandle[" + this.t + ']';
    }
}
