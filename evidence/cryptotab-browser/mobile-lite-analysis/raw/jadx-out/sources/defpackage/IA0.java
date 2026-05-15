package defpackage;

import java.lang.Thread;
import org.chromium.base.JavaHandlerThread;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class IA0 implements Thread.UncaughtExceptionHandler {
    public final /* synthetic */ JavaHandlerThread a;

    public IA0(JavaHandlerThread javaHandlerThread) {
        this.a = javaHandlerThread;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        this.a.b = th;
    }
}
