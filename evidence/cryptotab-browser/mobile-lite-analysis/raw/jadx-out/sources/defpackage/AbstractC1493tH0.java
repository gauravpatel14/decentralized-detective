package defpackage;

import android.os.Looper;
import java.util.Map;

/* JADX INFO: renamed from: tH0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1493tH0 {
    public static final Object k = new Object();
    public final Object a = new Object();
    public final Ux1 b = new Ux1();
    public int c = 0;
    public boolean d;
    public volatile Object e;
    public volatile Object f;
    public int g;
    public boolean h;
    public boolean i;
    public final RunnableC1261pH0 j;

    public AbstractC1493tH0() {
        Object obj = k;
        this.f = obj;
        this.j = new RunnableC1261pH0(this);
        this.e = obj;
        this.g = -1;
    }

    public static void a(String str) {
        le.a().a.getClass();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException(BN0.a("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void b(AbstractC1435sH0 abstractC1435sH0) {
        if (abstractC1435sH0.u) {
            if (!abstractC1435sH0.g()) {
                abstractC1435sH0.d(false);
                return;
            }
            int i = abstractC1435sH0.v;
            int i2 = this.g;
            if (i >= i2) {
                return;
            }
            abstractC1435sH0.v = i2;
            abstractC1435sH0.t.a(this.e);
        }
    }

    public final void c(AbstractC1435sH0 abstractC1435sH0) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (abstractC1435sH0 != null) {
                b(abstractC1435sH0);
                abstractC1435sH0 = null;
            } else {
                Ux1 ux1 = this.b;
                ux1.getClass();
                Sx1 sx1 = new Sx1(ux1);
                ux1.v.put(sx1, Boolean.FALSE);
                while (sx1.hasNext()) {
                    b((AbstractC1435sH0) ((Map.Entry) sx1.next()).getValue());
                    if (this.i) {
                        break;
                    }
                }
            }
        } while (this.i);
        this.h = false;
    }

    public final void d(InterfaceC0762hF0 interfaceC0762hF0, K21 k21) {
        Object obj;
        a("observe");
        if (((C0886jF0) interfaceC0762hF0.getLifecycle()).c == cF0.t) {
            return;
        }
        C1374rH0 c1374rH0 = new C1374rH0(this, interfaceC0762hF0, k21);
        Ux1 ux1 = this.b;
        Rx1 rx1E = ux1.e(k21);
        if (rx1E != null) {
            obj = rx1E.u;
        } else {
            Rx1 rx1 = new Rx1(k21, c1374rH0);
            ux1.w++;
            Rx1 rx12 = ux1.u;
            if (rx12 == null) {
                ux1.t = rx1;
                ux1.u = rx1;
            } else {
                rx12.v = rx1;
                rx1.w = rx12;
                ux1.u = rx1;
            }
            obj = null;
        }
        AbstractC1435sH0 abstractC1435sH0 = (AbstractC1435sH0) obj;
        if (abstractC1435sH0 != null && !abstractC1435sH0.f(interfaceC0762hF0)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (abstractC1435sH0 != null) {
            return;
        }
        interfaceC0762hF0.getLifecycle().a(c1374rH0);
    }

    public void g(K21 k21) {
        a("removeObserver");
        AbstractC1435sH0 abstractC1435sH0 = (AbstractC1435sH0) this.b.f(k21);
        if (abstractC1435sH0 == null) {
            return;
        }
        abstractC1435sH0.e();
        abstractC1435sH0.d(false);
    }

    public abstract void h(Object obj);

    public void e() {
    }

    public void f() {
    }
}
