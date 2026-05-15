package org.chromium.base;

import android.util.Log;
import defpackage.BN0;
import defpackage.Pg1;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class JniAndroid {

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public class UncaughtExceptionException extends RuntimeException {
    }

    public static Throwable handleException(Throwable th, String str) {
        try {
            Log.e("cr_JniAndroid", "Handling uncaught Java exception", th);
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), new UncaughtExceptionException(BN0.a("Native stack trace:", System.lineSeparator(), str), th));
            Log.e("cr_JniAndroid", "Global uncaught exception handler did not terminate the process.");
            return null;
        } catch (OutOfMemoryError unused) {
            return null;
        } catch (Throwable th2) {
            Log.e("cr_JniAndroid", "Exception in uncaught exception handler.", th2);
            return th2;
        }
    }

    public static String sanitizedStacktraceForUnhandledException(Throwable th) {
        try {
            try {
                return Pg1.b(Log.getStackTraceString(th));
            } catch (Throwable th2) {
                return "Error while getting stack trace: " + Log.getStackTraceString(th2);
            }
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }
}
