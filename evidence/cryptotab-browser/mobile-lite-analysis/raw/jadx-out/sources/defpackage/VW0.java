package defpackage;

import J.N;
import android.os.SystemClock;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class VW0 {
    public final Map a = Collections.synchronizedMap(new HashMap());

    public final long a(String str) {
        Long l = (Long) this.a.get(str);
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public final void b(long j, long j2, String str) {
        if (j != j2) {
            this.a.put(str, Long.valueOf(j2));
        }
    }

    public final void c(String str, boolean z) {
        long jA = a(str);
        b(jA, N._J_ZJO(0, z, jA, str), str);
    }

    public final void d(int i, int i2, int i3, int i4, String str) {
        long jA = a(str);
        b(jA, N._J_IIIIJO(0, i, i2, i3, i4, jA, str), str);
    }

    public final void e(int i, int i2, int i3, int i4, String str) {
        long jA = a(str);
        b(jA, N._J_IIIIJO(1, i, i2, i3, i4, jA, str), str);
    }

    public final void f(int i, String str) {
        long jA = a(str);
        b(jA, N._J_IJO(0, i, jA, str), str);
    }

    public final void g(long j, String str) {
        N._V_JO(4, SystemClock.elapsedRealtime() - j, str);
    }
}
