package org.chromium.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import defpackage.AbstractC1872zv;
import defpackage.RunnableC0727gf2;
import org.chromium.base.task.PostTask;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ThreadUtils {
    public static final Object a = new Object();
    public static volatile Handler b;

    public static void a() {
        if (!f()) {
            throw new IllegalStateException("Must be called on the UI thread.");
        }
    }

    public static Handler b() {
        if (b != null) {
            return b;
        }
        Looper mainLooper = Looper.getMainLooper();
        synchronized (a) {
            try {
                if (b == null) {
                    int i = AbstractC1872zv.a;
                    b = new Handler(mainLooper);
                    TraceEvent.v = true;
                    if (TraceEvent.u) {
                        PostTask.d(7, new RunnableC0727gf2());
                    }
                } else if (b.getLooper() != mainLooper) {
                    RuntimeException runtimeException = new RuntimeException("UI thread looper is already set to " + b.getLooper() + " (Main thread looper is " + Looper.getMainLooper() + "), cannot set to new looper " + mainLooper);
                    int i2 = AbstractC1872zv.a;
                    throw runtimeException;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return b;
    }

    public static Looper c() {
        return b().getLooper();
    }

    public static void d(Runnable runnable) {
        PostTask.c(7, runnable);
    }

    public static void e(Runnable runnable) {
        PostTask.d(7, runnable);
    }

    public static boolean f() {
        return b().getLooper() == Looper.myLooper();
    }

    public static boolean isThreadPriorityAudio(int i) {
        return Process.getThreadPriority(i) == -16;
    }

    public static void setThreadPriorityAudio(int i) {
        Process.setThreadPriority(i, -16);
    }
}
