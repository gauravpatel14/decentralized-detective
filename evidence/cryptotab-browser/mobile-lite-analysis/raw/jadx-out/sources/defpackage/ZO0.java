package defpackage;

import android.content.ComponentName;
import android.content.Context;
import java.util.Objects;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ZO0 {
    public boolean A;
    public final Context t;
    public final WO0 u;
    public final VO0 v = new VO0(this);
    public Vl0 w;
    public RO0 x;
    public boolean y;
    public C0351aP0 z;

    public ZO0(Context context, WO0 wo0) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        this.t = context;
        if (wo0 == null) {
            this.u = new WO0(new ComponentName(context, getClass()));
        } else {
            this.u = wo0;
        }
    }

    public UO0 a(String str) {
        if (str != null) {
            return null;
        }
        throw new IllegalArgumentException("initialMemberRouteId cannot be null.");
    }

    public abstract XO0 b(String str);

    public XO0 c(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("routeId cannot be null");
        }
        if (str2 != null) {
            return b(str);
        }
        throw new IllegalArgumentException("routeGroupId cannot be null");
    }

    public abstract void d(RO0 ro0);

    public final void e(C0351aP0 c0351aP0) {
        C1087mP0.b();
        if (this.z != c0351aP0) {
            this.z = c0351aP0;
            if (this.A) {
                return;
            }
            this.A = true;
            this.v.sendEmptyMessage(1);
        }
    }

    public final void f(RO0 ro0) {
        C1087mP0.b();
        if (Objects.equals(this.x, ro0)) {
            return;
        }
        this.x = ro0;
        if (this.y) {
            return;
        }
        this.y = true;
        this.v.sendEmptyMessage(2);
    }
}
