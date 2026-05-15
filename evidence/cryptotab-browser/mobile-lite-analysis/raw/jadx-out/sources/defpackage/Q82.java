package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Q82 {
    public static final ThreadLocal a = new ThreadLocal();
    public static final int[] b = {-16842910};
    public static final int[] c = {R.attr.state_focused};
    public static final int[] d = {R.attr.state_pressed};
    public static final int[] e = {R.attr.state_checked};
    public static final int[] f = new int[0];
    public static final int[] g = new int[1];

    public static void a(Context context, View view) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(AbstractC0305Yp1.AppCompatTheme);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(AbstractC0305Yp1.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int b(int i, Context context) {
        ColorStateList colorStateListD = d(i, context);
        if (colorStateListD != null && colorStateListD.isStateful()) {
            return colorStateListD.getColorForState(b, colorStateListD.getDefaultColor());
        }
        ThreadLocal threadLocal = a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValue, true);
        float f2 = typedValue.getFloat();
        return AbstractC1721xH.i(c(i, context), Math.round(Color.alpha(r4) * f2));
    }

    public static int c(int i, Context context) {
        int[] iArr = g;
        iArr[0] = i;
        C1342qa2 c1342qa2E = C1342qa2.e(context, null, iArr);
        try {
            return c1342qa2E.b.getColor(0, 0);
        } finally {
            c1342qa2E.g();
        }
    }

    public static ColorStateList d(int i, Context context) {
        int[] iArr = g;
        iArr[0] = i;
        C1342qa2 c1342qa2E = C1342qa2.e(context, null, iArr);
        try {
            return c1342qa2E.a(0);
        } finally {
            c1342qa2E.g();
        }
    }
}
