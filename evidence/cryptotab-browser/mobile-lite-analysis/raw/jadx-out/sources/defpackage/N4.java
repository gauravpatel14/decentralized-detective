package defpackage;

import J.N;
import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import org.chromium.base.ApplicationStatus;
import org.chromium.ui.base.WindowAndroid;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class N4 extends WindowAndroid implements Sd, Wd {
    public final boolean Q;
    public Lt0 R;

    public N4(Context context, boolean z, C1760xy0 c1760xy0) {
        this(context, z, new Q3(new WeakReference(AbstractC1499tM.a(context))), new Y3(new WeakReference(AbstractC1499tM.a(context))), c1760xy0);
    }

    @Override // defpackage.Wd
    public final void c(Activity activity, boolean z) {
        if (j().get() == activity) {
            this.H = z;
            if (z) {
                h(this.G);
            } else {
                h(0.0f);
            }
        }
    }

    @Override // defpackage.Sd
    public final void e(Activity activity, int i) {
        if (i == 5) {
            long j = this.w;
            if (j == 0) {
                return;
            }
            N._V_JO(285, j, this);
            return;
        }
        if (i == 2) {
            long j2 = this.w;
            if (j2 == 0) {
                return;
            }
            N._V_JO(284, j2, this);
            return;
        }
        M21 m21 = this.K;
        if (i == 4) {
            Iterator it = m21.iterator();
            while (true) {
                L21 l21 = (L21) it;
                if (!l21.hasNext()) {
                    return;
                } else {
                    ((InterfaceC0869iv2) l21.next()).b();
                }
            }
        } else {
            if (i != 3) {
                if (i == 6) {
                    Iterator it2 = m21.iterator();
                    while (true) {
                        L21 l212 = (L21) it2;
                        if (!l212.hasNext()) {
                            break;
                        } else {
                            ((InterfaceC0869iv2) l212.next()).h();
                        }
                    }
                    M21 m212 = ApplicationStatus.h;
                    if (m212 == null) {
                        return;
                    }
                    m212.g(this);
                    return;
                }
                return;
            }
            Iterator it3 = m21.iterator();
            while (true) {
                L21 l213 = (L21) it3;
                if (!l213.hasNext()) {
                    return;
                } else {
                    ((InterfaceC0869iv2) l213.next()).f();
                }
            }
        }
    }

    @Override // org.chromium.ui.base.WindowAndroid
    public final Lt0 j() {
        if (this.R == null) {
            this.R = new Lt0(AbstractC1499tM.a((Context) this.z.get()));
        }
        return this.R;
    }

    @Override // org.chromium.ui.base.WindowAndroid
    public final int k() {
        if (this.Q) {
            return ApplicationStatus.b((Activity) j().get());
        }
        return 6;
    }

    @Override // org.chromium.ui.base.WindowAndroid
    public GC0 n() {
        return (Y3) this.u;
    }

    public N4(Activity activity, Y3 y3, C1760xy0 c1760xy0) {
        this(activity, true, new Q3(new WeakReference(AbstractC1499tM.a(activity))), y3, c1760xy0);
    }

    public N4(Context context, boolean z, Q3 q3, Y3 y3, C1760xy0 c1760xy0) {
        super(context, o00.a(context));
        this.t = c1760xy0;
        Activity activityA = AbstractC1499tM.a(context);
        if (activityA != null) {
            this.Q = z;
            if (z) {
                ApplicationStatus.h(this, activityA);
                ApplicationStatus.j(this);
            }
            y3.x = new C1370rE0(new RR1() { // from class: M4
                @Override // java.util.function.Supplier
                public final Object get() {
                    C0323Zw0 c0323Zw0L = this.t.l();
                    return c0323Zw0L == null ? new H21() : c0323Zw0L.x;
                }
            });
            if (!y3.t.isEmpty()) {
                ((F21) y3.x.b()).k(y3.v);
            }
            this.u = y3;
            GC0.u = y3;
            this.D = q3;
            return;
        }
        throw new IllegalArgumentException("Context is not and does not wrap an Activity");
    }
}
