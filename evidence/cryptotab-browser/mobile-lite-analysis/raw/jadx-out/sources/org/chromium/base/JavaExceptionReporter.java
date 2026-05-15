package org.chromium.base;

import J.N;
import android.os.DeadSystemException;
import java.lang.Thread;
import org.chromium.base.JniAndroid;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class JavaExceptionReporter implements Thread.UncaughtExceptionHandler {
    public final Thread.UncaughtExceptionHandler a;
    public final boolean b;
    public boolean c;

    public JavaExceptionReporter(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, boolean z) {
        this.a = uncaughtExceptionHandler;
        this.b = z;
    }

    public static void installHandler(boolean z) {
        Thread.setDefaultUncaughtExceptionHandler(new JavaExceptionReporter(Thread.getDefaultUncaughtExceptionHandler(), z));
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        if (!this.c && !(th instanceof DeadSystemException)) {
            this.c = true;
            N._V_ZO(0, this.b, th instanceof JniAndroid.UncaughtExceptionException ? th.getCause() : th);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
