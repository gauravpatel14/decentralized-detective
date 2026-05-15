package defpackage;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: renamed from: zA0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1819zA0 {
    public static final Handler a;

    static {
        HandlerThread handlerThread = new HandlerThread("Jank-Tracker");
        handlerThread.start();
        a = new Handler(handlerThread.getLooper());
    }
}
