package org.chromium.components.crash;

import android.os.DeadSystemException;
import defpackage.AbstractC0174On1;
import defpackage.AbstractC1499tM;
import defpackage.RM1;
import java.lang.Thread;
import org.chromium.base.BundleUtils;
import org.chromium.chrome.browser.base.SplitChromeApplication;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class PureJavaExceptionHandler implements Thread.UncaughtExceptionHandler {
    public static boolean c = true;
    public final Thread.UncaughtExceptionHandler a;
    public boolean b;

    public PureJavaExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, RM1 rm1) {
        this.a = uncaughtExceptionHandler;
    }

    public static void uninstallHandler() {
        c = false;
        CrashKeys.getInstance().flushToNative();
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        if (!this.b && c && !(th instanceof DeadSystemException)) {
            this.b = true;
            ((AbstractC0174On1) BundleUtils.g(SplitChromeApplication.b(AbstractC1499tM.a), "org.chromium.chrome.browser.crash.ChromePureJavaExceptionReporter")).b(th);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
