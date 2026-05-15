package defpackage;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Z62 {
    public static final long a = AbstractC1511tU1.a("kotlinx.coroutines.scheduler.resolution.ns", 100000, 1, Long.MAX_VALUE);
    public static final int b;
    public static final int c;
    public static final long d;
    public static final rW0 e;
    public static final I62 f;
    public static final I62 g;

    static {
        int i = AbstractC1563uU1.a;
        if (i < 2) {
            i = 2;
        }
        b = AbstractC1511tU1.b(i, 1, 0, 8, "kotlinx.coroutines.scheduler.core.pool.size");
        c = AbstractC1511tU1.b(2097150, 0, 2097150, 4, "kotlinx.coroutines.scheduler.max.pool.size");
        d = TimeUnit.SECONDS.toNanos(AbstractC1511tU1.a("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, Long.MAX_VALUE));
        e = rW0.a;
        f = new I62(0);
        g = new I62(1);
    }
}
