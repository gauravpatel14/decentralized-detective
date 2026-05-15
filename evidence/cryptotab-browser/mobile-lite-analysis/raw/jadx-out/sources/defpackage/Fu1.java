package defpackage;

import android.os.Process;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Fu1 extends Thread {
    public final int t;

    public Fu1(Runnable runnable, String str, int i) {
        super(runnable, str);
        this.t = i;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.t);
        super.run();
    }
}
