package defpackage;

import android.os.Process;
import java.lang.Thread;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class KC0 implements Thread.UncaughtExceptionHandler {
    public boolean a;

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        if (this.a) {
            return;
        }
        this.a = true;
        Process.killProcess(Process.myPid());
        System.exit(10);
    }
}
