package defpackage;

import android.os.Process;
import android.os.SystemClock;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class r50 {
    public final boolean a;
    public final boolean b;
    public final String c;
    public final int d = Process.myTid();
    public final long e = System.nanoTime();
    public final long f = SystemClock.currentThreadTimeMillis();

    public r50(String str, boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
        this.c = str;
    }
}
