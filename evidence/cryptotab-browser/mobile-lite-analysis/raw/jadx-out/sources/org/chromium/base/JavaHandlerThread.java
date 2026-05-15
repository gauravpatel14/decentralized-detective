package org.chromium.base;

import android.os.Handler;
import android.os.HandlerThread;
import defpackage.GA0;
import defpackage.HA0;
import defpackage.IA0;
import java.lang.Thread;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class JavaHandlerThread {
    public final HandlerThread a;
    public Throwable b;

    public JavaHandlerThread(String str, int i) {
        this.a = new HandlerThread(str, i);
    }

    public static JavaHandlerThread create(String str, int i) {
        return new JavaHandlerThread(str, i);
    }

    public final Throwable getUncaughtExceptionIfAny() {
        return this.b;
    }

    public final boolean isAlive() {
        return this.a.isAlive();
    }

    public final void joinThread() {
        boolean z = false;
        while (!z) {
            try {
                this.a.join();
                z = true;
            } catch (InterruptedException unused) {
            }
        }
    }

    public final void listenForUncaughtExceptionsForTesting() {
        this.a.setUncaughtExceptionHandler(new IA0(this));
    }

    public final void quitThreadSafely(long j) {
        HandlerThread handlerThread = this.a;
        new Handler(handlerThread.getLooper()).post(new HA0(this, j));
        handlerThread.getLooper().quitSafely();
    }

    public final void startAndInitialize(long j, long j2) {
        HandlerThread handlerThread = this.a;
        if (handlerThread.getState() == Thread.State.NEW) {
            handlerThread.start();
        }
        new Handler(handlerThread.getLooper()).post(new GA0(j, j2));
    }
}
