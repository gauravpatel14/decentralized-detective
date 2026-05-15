package defpackage;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: renamed from: uE2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1546uE2 {
    public static volatile LH2 d;
    public final WS2 a;
    public final RunnableC1258pE2 b;
    public volatile long c;

    public AbstractC1546uE2(WS2 ws2) {
        Preconditions.checkNotNull(ws2);
        this.a = ws2;
        this.b = new RunnableC1258pE2(this, ws2);
    }

    public final void a() {
        this.c = 0L;
        d().removeCallbacks(this.b);
    }

    public abstract void b();

    public final void c(long j) {
        a();
        if (j >= 0) {
            this.c = this.a.e().currentTimeMillis();
            if (d().postDelayed(this.b, j)) {
                return;
            }
            this.a.d().f.b(Long.valueOf(j), "Failed to schedule delayed post. time");
        }
    }

    public final Handler d() {
        LH2 lh2;
        if (d != null) {
            return d;
        }
        synchronized (AbstractC1546uE2.class) {
            try {
                if (d == null) {
                    d = new LH2(this.a.c().getMainLooper());
                }
                lh2 = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return lh2;
    }
}
