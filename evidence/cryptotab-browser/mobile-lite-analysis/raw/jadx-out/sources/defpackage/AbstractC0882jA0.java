package defpackage;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: jA0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0882jA0 {
    public static final InterpolatorC0821iA0 b = new InterpolatorC0821iA0(0);
    public static final InterpolatorC0821iA0 c = new InterpolatorC0821iA0(1);
    public int a = -1;

    public static int c(int i, int i2) {
        int i3;
        int i4 = i & 3158064;
        if (i4 == 0) {
            return i;
        }
        int i5 = i & (~i4);
        if (i2 == 0) {
            i3 = i4 >> 2;
        } else {
            int i6 = i4 >> 1;
            i5 |= (-3158065) & i6;
            i3 = (i6 & 3158064) >> 2;
        }
        return i5 | i3;
    }

    public static int d(int i, int i2) {
        int i3;
        int i4 = i & 789516;
        if (i4 == 0) {
            return i;
        }
        int i5 = i & (~i4);
        if (i2 == 0) {
            i3 = i4 << 2;
        } else {
            int i6 = i4 << 1;
            i5 |= (-789517) & i6;
            i3 = (i6 & 789516) << 2;
        }
        return i5 | i3;
    }

    public static int j(int i, int i2) {
        int i3 = i2 | i;
        return (i << 16) | (i2 << 8) | i3;
    }

    public abstract boolean a(ps1 ps1Var, ps1 ps1Var2);

    public void b(RecyclerView recyclerView, ps1 ps1Var) {
        View view = ps1Var.t;
        Object tag = view.getTag(AbstractC0132Lp1.item_touch_helper_previous_elevation);
        if (tag instanceof Float) {
            float fFloatValue = ((Float) tag).floatValue();
            WeakHashMap weakHashMap = AbstractC0604eo2.a;
            view.setElevation(fFloatValue);
        }
        view.setTag(AbstractC0132Lp1.item_touch_helper_previous_elevation, null);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    public abstract int e(RecyclerView recyclerView, ps1 ps1Var);

    public float f() {
        return 0.5f;
    }

    public final int g(RecyclerView recyclerView, int i, int i2, long j) {
        if (this.a == -1) {
            this.a = recyclerView.getResources().getDimensionPixelSize(Hp1.item_touch_helper_max_drag_scroll_per_frame);
        }
        int interpolation = (int) (b.getInterpolation(j <= 2000 ? j / 2000.0f : 1.0f) * ((int) (c.getInterpolation(Math.min(1.0f, (Math.abs(i2) * 1.0f) / i)) * ((int) Math.signum(i2)) * this.a)));
        return interpolation == 0 ? i2 > 0 ? 1 : -1 : interpolation;
    }

    public boolean h() {
        return true;
    }

    public boolean i() {
        return true;
    }

    public void k(Canvas canvas, RecyclerView recyclerView, ps1 ps1Var, float f, float f2, int i, boolean z) {
        View view = ps1Var.t;
        if (z && view.getTag(AbstractC0132Lp1.item_touch_helper_previous_elevation) == null) {
            WeakHashMap weakHashMap = AbstractC0604eo2.a;
            Float fValueOf = Float.valueOf(view.getElevation());
            int childCount = recyclerView.getChildCount();
            float f3 = 0.0f;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                if (childAt != view) {
                    WeakHashMap weakHashMap2 = AbstractC0604eo2.a;
                    float elevation = childAt.getElevation();
                    if (elevation > f3) {
                        f3 = elevation;
                    }
                }
            }
            view.setElevation(f3 + 1.0f);
            view.setTag(AbstractC0132Lp1.item_touch_helper_previous_elevation, fValueOf);
        }
        view.setTranslationX(f);
        view.setTranslationY(f2);
    }

    public abstract boolean l(ps1 ps1Var, ps1 ps1Var2);

    public abstract void m(ps1 ps1Var, int i);

    public abstract void n(ps1 ps1Var);
}
