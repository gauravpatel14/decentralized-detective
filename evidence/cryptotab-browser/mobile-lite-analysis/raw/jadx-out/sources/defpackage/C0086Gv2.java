package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: Gv2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0086Gv2 extends AbstractC0122Kv2 {
    public static final PathInterpolator e = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);
    public static final InterpolatorC0723gb0 f = new InterpolatorC0723gb0();
    public static final DecelerateInterpolator g = new DecelerateInterpolator();

    public static void e(C0134Lv2 c0134Lv2, View view) {
        Uw0 uw0J = j(view);
        if (uw0J == null) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    e(c0134Lv2, viewGroup.getChildAt(i));
                }
                return;
            }
            return;
        }
        Iterator it = uw0J.b.y.iterator();
        while (true) {
            L21 l21 = (L21) it;
            if (!l21.hasNext()) {
                return;
            } else {
                ((Xw0) l21.next()).b(c0134Lv2);
            }
        }
    }

    public static void f(View view, C0134Lv2 c0134Lv2, WindowInsets windowInsets, boolean z) {
        Uw0 uw0J = j(view);
        if (uw0J != null) {
            uw0J.a = windowInsets;
            if (!z) {
                Iterator it = uw0J.b.y.iterator();
                while (true) {
                    L21 l21 = (L21) it;
                    if (!l21.hasNext()) {
                        break;
                    } else {
                        ((Xw0) l21.next()).d(c0134Lv2);
                    }
                }
                z = true;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                f(viewGroup.getChildAt(i), c0134Lv2, windowInsets, z);
            }
        }
    }

    public static void g(View view, C0383aw2 c0383aw2, List list) {
        Uw0 uw0J = j(view);
        if (uw0J == null) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    g(viewGroup.getChildAt(i), c0383aw2, list);
                }
                return;
            }
            return;
        }
        Iterator it = uw0J.b.y.iterator();
        while (true) {
            L21 l21 = (L21) it;
            if (!l21.hasNext()) {
                return;
            } else {
                ((Xw0) l21.next()).a(list);
            }
        }
    }

    public static void h(View view, C0134Lv2 c0134Lv2, C0022Bv2 c0022Bv2) {
        Uw0 uw0J = j(view);
        if (uw0J == null) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    h(viewGroup.getChildAt(i), c0134Lv2, c0022Bv2);
                }
                return;
            }
            return;
        }
        Iterator it = uw0J.b.y.iterator();
        while (true) {
            L21 l21 = (L21) it;
            if (!l21.hasNext()) {
                return;
            } else {
                ((Xw0) l21.next()).getClass();
            }
        }
    }

    public static WindowInsets i(View view, WindowInsets windowInsets) {
        return view.getTag(AbstractC0132Lp1.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
    }

    public static Uw0 j(View view) {
        Object tag = view.getTag(AbstractC0132Lp1.tag_window_insets_animation_callback);
        if (tag instanceof ViewOnApplyWindowInsetsListenerC0075Fv2) {
            return ((ViewOnApplyWindowInsetsListenerC0075Fv2) tag).t;
        }
        return null;
    }
}
