package defpackage;

import android.os.Process;

/* JADX INFO: renamed from: sB2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1427sB2 implements Runnable {
    public final Runnable t;

    public RunnableC1427sB2(Runnable runnable) {
        this.t = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(0);
        this.t.run();
    }
}
