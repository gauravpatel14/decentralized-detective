package defpackage;

import android.os.OutcomeReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BN extends AtomicBoolean implements OutcomeReceiver {
    public final C1703wx t;

    public BN(C1703wx c1703wx) {
        super(false);
        this.t = c1703wx;
    }

    public final void onError(Throwable th) {
        if (compareAndSet(false, true)) {
            this.t.d(new Zv1(th));
        }
    }

    public final void onResult(Object obj) {
        if (compareAndSet(false, true)) {
            this.t.d(obj);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public final String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
