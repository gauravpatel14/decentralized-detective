package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class dv1 {
    public static dv1 g;
    public WeakHashMap a;
    public final WeakHashMap b = new WeakHashMap(0);
    public TypedValue c;
    public boolean d;
    public C0854ib e;
    public static final PorterDuff.Mode f = PorterDuff.Mode.SRC_IN;
    public static final cv1 h = new cv1(6);

    public static synchronized dv1 b() {
        try {
            if (g == null) {
                g = new dv1();
            }
        } catch (Throwable th) {
            throw th;
        }
        return g;
    }

    public static synchronized PorterDuffColorFilter e(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        cv1 cv1Var = h;
        cv1Var.getClass();
        int i2 = (31 + i) * 31;
        porterDuffColorFilter = (PorterDuffColorFilter) cv1Var.b(Integer.valueOf(mode.hashCode() + i2));
        if (porterDuffColorFilter == null) {
            porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
        }
        return porterDuffColorFilter;
    }

    public final Drawable a(int i, Context context) {
        Drawable drawableNewDrawable;
        WeakReference weakReference;
        if (this.c == null) {
            this.c = new TypedValue();
        }
        TypedValue typedValue = this.c;
        context.getResources().getValue(i, typedValue, true);
        long j = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        synchronized (this) {
            EJ0 ej0 = (EJ0) this.b.get(context);
            drawableNewDrawable = null;
            if (ej0 != null && (weakReference = (WeakReference) ej0.b(j)) != null) {
                Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
                if (constantState != null) {
                    drawableNewDrawable = constantState.newDrawable(context.getResources());
                } else {
                    ej0.f(j);
                }
            }
        }
        if (drawableNewDrawable != null) {
            return drawableNewDrawable;
        }
        LayerDrawable layerDrawableC = null;
        if (this.e != null) {
            if (i == Ip1.abc_cab_background_top_material) {
                layerDrawableC = new LayerDrawable(new Drawable[]{c(Ip1.abc_cab_background_internal_bg, context), c(Ip1.abc_cab_background_top_mtrl_alpha, context)});
            } else if (i == Ip1.abc_ratingbar_material) {
                layerDrawableC = C0854ib.c(this, context, Hp1.abc_star_big);
            } else if (i == Ip1.abc_ratingbar_indicator_material) {
                layerDrawableC = C0854ib.c(this, context, Hp1.abc_star_medium);
            } else if (i == Ip1.abc_ratingbar_small_material) {
                layerDrawableC = C0854ib.c(this, context, Hp1.abc_star_small);
            }
        }
        if (layerDrawableC != null) {
            layerDrawableC.setChangingConfigurations(typedValue.changingConfigurations);
            synchronized (this) {
                try {
                    Drawable.ConstantState constantState2 = layerDrawableC.getConstantState();
                    if (constantState2 != null) {
                        EJ0 ej02 = (EJ0) this.b.get(context);
                        if (ej02 == null) {
                            ej02 = new EJ0();
                            this.b.put(context, ej02);
                        }
                        ej02.e(j, new WeakReference(constantState2));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return layerDrawableC;
    }

    public final synchronized Drawable c(int i, Context context) {
        return d(i, context, false);
    }

    public final synchronized Drawable d(int i, Context context, boolean z) {
        Drawable drawableA;
        try {
            if (!this.d) {
                this.d = true;
                Drawable drawableC = c(Ip1.abc_vector_test, context);
                if (drawableC == null || (!(drawableC instanceof C0989kn2) && !"android.graphics.drawable.VectorDrawable".equals(drawableC.getClass().getName()))) {
                    this.d = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            drawableA = a(i, context);
            if (drawableA == null) {
                drawableA = context.getDrawable(i);
            }
            if (drawableA != null) {
                drawableA = g(context, i, z, drawableA);
            }
            if (drawableA != null) {
                J30.a(drawableA);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableA;
    }

    public final synchronized ColorStateList f(int i, Context context) {
        ColorStateList colorStateList;
        C1325qM1 c1325qM1;
        WeakHashMap weakHashMap = this.a;
        ColorStateList colorStateListD = null;
        colorStateList = (weakHashMap == null || (c1325qM1 = (C1325qM1) weakHashMap.get(context)) == null) ? null : (ColorStateList) c1325qM1.b(i);
        if (colorStateList == null) {
            C0854ib c0854ib = this.e;
            if (c0854ib != null) {
                colorStateListD = c0854ib.d(i, context);
            }
            if (colorStateListD != null) {
                if (this.a == null) {
                    this.a = new WeakHashMap();
                }
                C1325qM1 c1325qM12 = (C1325qM1) this.a.get(context);
                if (c1325qM12 == null) {
                    c1325qM12 = new C1325qM1();
                    this.a.put(context, c1325qM12);
                }
                c1325qM12.a(i, colorStateListD);
            }
            colorStateList = colorStateListD;
        }
        return colorStateList;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable g(android.content.Context r9, int r10, boolean r11, android.graphics.drawable.Drawable r12) {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dv1.g(android.content.Context, int, boolean, android.graphics.drawable.Drawable):android.graphics.drawable.Drawable");
    }
}
