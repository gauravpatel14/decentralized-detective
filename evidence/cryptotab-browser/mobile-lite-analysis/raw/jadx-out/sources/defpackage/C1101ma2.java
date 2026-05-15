package defpackage;

import android.os.SystemClock;

/* JADX INFO: renamed from: ma2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1101ma2 implements AutoCloseable {
    public final String t;
    public final int u;
    public long v;

    public C1101ma2(String str, int i) {
        this.t = str;
        this.u = i;
    }

    public static C1101ma2 a(String str) {
        C1101ma2 c1101ma2 = new C1101ma2(str, 2);
        c1101ma2.v = SystemClock.currentThreadTimeMillis();
        return c1101ma2;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        long j = this.v;
        if (j == 0) {
            return;
        }
        this.v = 0L;
        String str = this.t;
        int i = this.u;
        if (i == 0) {
            Gr1.n(SystemClock.uptimeMillis() - j, str);
        } else if (i == 1) {
            Gr1.k(SystemClock.uptimeMillis() - j, str);
        } else {
            if (i != 2) {
                return;
            }
            Gr1.n(SystemClock.currentThreadTimeMillis() - j, str);
        }
    }
}
