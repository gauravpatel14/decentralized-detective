package defpackage;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import org.chromium.base.ApplicationStatus;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class FA0 implements CA0 {
    public static final boolean e;
    public boolean a;
    public C1483tA0 b;
    public AA0 c;
    public boolean d;

    static {
        e = Build.VERSION.SDK_INT >= 31;
    }

    @Override // defpackage.CA0
    public final void a() {
        c(BA0.c, -1L);
    }

    @Override // defpackage.CA0
    public final void b(BA0 ba0) {
        if (e && this.a) {
            AA0 aa0 = this.c;
            aa0.getClass();
            Handler handler = AbstractC1819zA0.a;
            handler.post(new RunnableC1713xA0(aa0.a, ba0, true, handler, null));
        }
    }

    @Override // defpackage.CA0
    public final void c(BA0 ba0, long j) {
        if (e && this.a) {
            AA0 aa0 = this.c;
            aa0.getClass();
            C1542uA0 c1542uA0 = j <= 0 ? null : new C1542uA0(j);
            Handler handler = AbstractC1819zA0.a;
            handler.post(new RunnableC1713xA0(aa0.a, ba0, false, handler, c1542uA0));
        }
    }

    @Override // defpackage.CA0
    public final void destroy() {
        this.d = true;
        if (e && this.a) {
            C1483tA0 c1483tA0 = this.b;
            c1483tA0.getClass();
            int i = AbstractC1872zv.a;
            ApplicationStatus.k(c1483tA0);
            AA0 aa0 = c1483tA0.u;
            if (aa0.c.getAndSet(false)) {
                Handler handler = AbstractC1819zA0.a;
                RunnableC1766yA0 runnableC1766yA0 = aa0.b;
                handler.removeCallbacks(runnableC1766yA0);
                handler.post(runnableC1766yA0);
            }
            Activity activity = (Activity) c1483tA0.w.get();
            if (activity != null) {
                c1483tA0.a(activity.getWindow());
            }
            c1483tA0.v.t = true;
        }
    }
}
