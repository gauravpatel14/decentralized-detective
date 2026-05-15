package org.chromium.chrome.browser.metrics;

import android.os.Process;
import android.os.SystemClock;
import defpackage.Ej2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class UmaUtils {
    public static Ej2 a;
    public static long b;
    public static long c;
    public static long d;

    public static boolean a() {
        return d != 0;
    }

    public static boolean b() {
        return c != 0;
    }

    public static void c() {
        long j = c;
        if (j == 0 || j < d) {
            Ej2 ej2 = a;
            if (ej2 != null && j == 0) {
                ej2.a();
            }
            c = SystemClock.uptimeMillis();
        }
    }

    public static long getApplicationStartTime() {
        return b;
    }

    public static long getProcessStartTime() {
        return Process.getStartUptimeMillis();
    }
}
