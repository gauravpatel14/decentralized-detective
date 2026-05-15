package defpackage;

import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class L23 implements Executor {
    public final AB2 t;

    public L23() {
        AB2 ab2 = new AB2(Looper.getMainLooper());
        Looper.getMainLooper();
        this.t = ab2;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.t.post(runnable);
    }
}
