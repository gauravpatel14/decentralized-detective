package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/* JADX INFO: renamed from: jb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0914jb {
    public static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
    public static C0914jb c;
    public dv1 a;

    public static synchronized C0914jb a() {
        try {
            if (c == null) {
                d();
            }
        } catch (Throwable th) {
            throw th;
        }
        return c;
    }

    public static synchronized PorterDuffColorFilter c(int i, PorterDuff.Mode mode) {
        return dv1.e(i, mode);
    }

    public static synchronized void d() {
        if (c == null) {
            C0914jb c0914jb = new C0914jb();
            c = c0914jb;
            c0914jb.a = dv1.b();
            dv1 dv1Var = c.a;
            C0854ib c0854ib = new C0854ib();
            synchronized (dv1Var) {
                dv1Var.e = c0854ib;
            }
        }
    }

    public static void e(Drawable drawable, C1227oa2 c1227oa2, int[] iArr) {
        PorterDuff.Mode mode = dv1.f;
        int[] state = drawable.getState();
        if (drawable.mutate() == drawable) {
            if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
                drawable.setState(new int[0]);
                drawable.setState(state);
            }
            boolean z = c1227oa2.d;
            if (!z && !c1227oa2.c) {
                drawable.clearColorFilter();
                return;
            }
            PorterDuffColorFilter porterDuffColorFilterE = null;
            ColorStateList colorStateList = z ? c1227oa2.a : null;
            PorterDuff.Mode mode2 = c1227oa2.c ? c1227oa2.b : dv1.f;
            if (colorStateList != null && mode2 != null) {
                porterDuffColorFilterE = dv1.e(colorStateList.getColorForState(iArr, 0), mode2);
            }
            drawable.setColorFilter(porterDuffColorFilterE);
        }
    }

    public final synchronized Drawable b(int i, Context context) {
        return this.a.c(i, context);
    }
}
