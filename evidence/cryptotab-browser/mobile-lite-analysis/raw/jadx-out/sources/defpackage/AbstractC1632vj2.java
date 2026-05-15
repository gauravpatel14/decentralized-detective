package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.StrictMode;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: renamed from: vj2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1632vj2 {
    public static final HashMap a;
    public static Boolean b;

    static {
        HashMap map = new HashMap();
        a = map;
        map.put("htc", 26);
    }

    public static int[] a(ListAdapter listAdapter, ViewGroup viewGroup) {
        View view;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-2, -2);
        int[] iArr = {0, 0};
        View[] viewArr = new View[listAdapter.getViewTypeCount()];
        for (int i = 0; i < listAdapter.getCount(); i++) {
            int itemViewType = listAdapter.getItemViewType(i);
            if (itemViewType < 0) {
                view = listAdapter.getView(i, null, viewGroup);
            } else {
                View view2 = listAdapter.getView(i, viewArr[itemViewType], viewGroup);
                viewArr[itemViewType] = view2;
                view = view2;
            }
            view.setLayoutParams(layoutParams);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iArr[0] = Math.max(iArr[0], view.getMeasuredWidth());
            iArr[1] = view.getMeasuredHeight() + iArr[1];
        }
        return iArr;
    }

    public static File b(Context context) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            File file = new File(context.getFilesDir(), "images");
            if (!file.exists() && !file.mkdir()) {
                throw new IOException("Folder cannot be created.");
            }
            return file;
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    public static Drawable c(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (typedArray == null || (resourceId = typedArray.getResourceId(i, -1)) == -1) {
            return null;
        }
        return AbstractC1686wb.a(resourceId, context);
    }

    public static Drawable d(Context context, int i, int i2) {
        return e(context, i, U3.b(i2, context));
    }

    public static Drawable e(Context context, int i, ColorStateList colorStateList) {
        Drawable drawableMutate = AbstractC1686wb.a(i, context).mutate();
        drawableMutate.setTintList(colorStateList);
        return drawableMutate;
    }

    public static int f(ViewGroup viewGroup, View view, View view2, boolean z) {
        int iIndexOfChild = viewGroup.indexOfChild(view);
        if (iIndexOfChild >= 0) {
            return iIndexOfChild;
        }
        int iIndexOfChild2 = viewGroup.indexOfChild(view2);
        if (iIndexOfChild2 < 0) {
            return -1;
        }
        if (z) {
            iIndexOfChild2++;
        }
        viewGroup.addView(view, iIndexOfChild2);
        return iIndexOfChild2;
    }

    public static boolean g(Window window) {
        return C0383aw2.g(null, window.getDecorView().getRootWindowInsets()).a.f(16).a > 0;
    }

    public static boolean h() {
        return AbstractC1499tM.a.getResources().getConfiguration().keyboard != 1;
    }

    public static boolean i() {
        if (b == null) {
            b = Boolean.FALSE;
            HashMap map = a;
            String str = Build.MANUFACTURER;
            Locale locale = Locale.US;
            if (map.containsKey(str.toLowerCase(locale))) {
                b = Boolean.valueOf(Build.VERSION.SDK_INT < ((Integer) map.get(str.toLowerCase(locale))).intValue());
            }
        }
        return b.booleanValue();
    }

    public static void j(View view, boolean z) {
        if (!(view instanceof ViewGroup)) {
            if (view instanceof SurfaceView) {
                view.setWillNotDraw(!z);
            }
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                j(viewGroup.getChildAt(i), z);
            }
        }
    }

    public static void k(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    public static void l(View view, boolean z) {
        int systemUiVisibility = view.getSystemUiVisibility();
        view.setSystemUiVisibility(z ? systemUiVisibility | 16 : systemUiVisibility & (-17));
    }

    public static void m(Window window, int i) {
        if ((window.getAttributes().flags & Integer.MIN_VALUE) == 0) {
            window.addFlags(Integer.MIN_VALUE);
        }
        int i2 = AbstractC1872zv.a;
        if (Bv.a.n) {
            window.setStatusBarColor(-16777216);
        } else {
            window.setStatusBarColor(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void n(android.view.View r1, boolean r2) {
        /*
            int r0 = r1.getSystemUiVisibility()
            if (r2 == 0) goto L11
            int r2 = defpackage.AbstractC1872zv.a
            org.chromium.base.BuildInfo r2 = defpackage.Bv.a
            boolean r2 = r2.n
            if (r2 != 0) goto L11
            r2 = r0 | 8192(0x2000, float:1.148E-41)
            goto L13
        L11:
            r2 = r0 & (-8193(0xffffffffffffdfff, float:NaN))
        L13:
            r1.setSystemUiVisibility(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractC1632vj2.n(android.view.View, boolean):void");
    }
}
