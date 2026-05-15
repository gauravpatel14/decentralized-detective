package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import org.chromium.base.TraceEvent;

/* JADX INFO: renamed from: Ip2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0106Ip2 {
    public static final int[] a = new int[2];

    public static Zw1 a(Resources resources, Bitmap bitmap, int i) {
        Zw1 zw1 = new Zw1(resources, bitmap);
        zw1.b(i);
        return zw1;
    }

    public static int b(Context context, float f) {
        return c(context.getResources().getDisplayMetrics(), f);
    }

    public static int c(DisplayMetrics displayMetrics, float f) {
        return Math.round(TypedValue.applyDimension(1, f, displayMetrics));
    }

    public static void d(FrameLayout frameLayout, View view, int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        if (frameLayout == null || view == frameLayout) {
            return;
        }
        while (view != null) {
            iArr[0] = (int) (view.getX() + iArr[0]);
            iArr[1] = (int) (view.getY() + iArr[1]);
            if (view.getParent() == frameLayout) {
                return;
            } else {
                view = (View) view.getParent();
            }
        }
    }

    public static void e(View view, View view2, int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        if (view == null || view2 == view) {
            return;
        }
        while (view2 != null) {
            iArr[0] = view2.getLeft() + iArr[0];
            iArr[1] = view2.getTop() + iArr[1];
            if (view2.getParent() == view) {
                return;
            } else {
                view2 = (View) view2.getParent();
            }
        }
    }

    public static void f(View view) {
        view.invalidate();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    f(childAt);
                }
            }
        }
    }

    public static void g(View view, String str) {
        TraceEvent.d("requestLayout caller: ".concat(str));
        view.requestLayout();
    }

    public static void h(FrameLayout frameLayout, boolean z) {
        for (ViewGroup viewGroup = frameLayout; viewGroup != null; viewGroup = (ViewGroup) viewGroup.getParent()) {
            viewGroup.setClipChildren(z);
            if (!(viewGroup.getParent() instanceof ViewGroup) || viewGroup.getId() == 16908290) {
                return;
            }
        }
    }

    public static void i(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                i(viewGroup.getChildAt(i), z);
            }
        }
    }

    public static void j(View view, View view2, Canvas canvas) {
        while (view2 != view) {
            canvas.translate(view2.getLeft(), view2.getTop());
            if (!(view2.getParent() instanceof View)) {
                throw new IllegalArgumentException("View 'to' was not a desendent of 'from'.");
            }
            view2 = (View) view2.getParent();
        }
    }
}
