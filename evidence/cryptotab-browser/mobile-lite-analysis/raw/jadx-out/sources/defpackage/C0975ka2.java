package defpackage;

import android.os.SystemClock;
import java.io.Closeable;

/* JADX INFO: renamed from: ka2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0975ka2 implements Closeable {
    public static C0975ka2 u;
    public static long v;
    public final long t = SystemClock.uptimeMillis();

    public C0975ka2() {
        if (u == null) {
            u = this;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (u == this) {
            u = null;
            v = (SystemClock.uptimeMillis() - this.t) + v;
        }
    }
}
