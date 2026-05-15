package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Ha {
    public final View a;
    public C1227oa2 d;
    public C1227oa2 e;
    public C1227oa2 f;
    public int c = -1;
    public final C0914jb b = C0914jb.a();

    public Ha(View view) {
        this.a = view;
    }

    public final void a() {
        View view = this.a;
        Drawable background = view.getBackground();
        if (background != null) {
            if (this.d != null) {
                if (this.f == null) {
                    this.f = new C1227oa2();
                }
                C1227oa2 c1227oa2 = this.f;
                c1227oa2.a = null;
                c1227oa2.d = false;
                c1227oa2.b = null;
                c1227oa2.c = false;
                WeakHashMap weakHashMap = AbstractC0604eo2.a;
                ColorStateList backgroundTintList = view.getBackgroundTintList();
                if (backgroundTintList != null) {
                    c1227oa2.d = true;
                    c1227oa2.a = backgroundTintList;
                }
                PorterDuff.Mode backgroundTintMode = view.getBackgroundTintMode();
                if (backgroundTintMode != null) {
                    c1227oa2.c = true;
                    c1227oa2.b = backgroundTintMode;
                }
                if (c1227oa2.d || c1227oa2.c) {
                    C0914jb.e(background, c1227oa2, view.getDrawableState());
                    return;
                }
            }
            C1227oa2 c1227oa22 = this.e;
            if (c1227oa22 != null) {
                C0914jb.e(background, c1227oa22, view.getDrawableState());
                return;
            }
            C1227oa2 c1227oa23 = this.d;
            if (c1227oa23 != null) {
                C0914jb.e(background, c1227oa23, view.getDrawableState());
            }
        }
    }

    public final void b(AttributeSet attributeSet, int i) {
        ColorStateList colorStateListF;
        View view = this.a;
        C1342qa2 c1342qa2F = C1342qa2.f(view.getContext(), attributeSet, AbstractC0305Yp1.ViewBackgroundHelper, i);
        TypedArray typedArray = c1342qa2F.b;
        View view2 = this.a;
        AbstractC0604eo2.n(view2, view2.getContext(), AbstractC0305Yp1.ViewBackgroundHelper, attributeSet, c1342qa2F.b, i, 0);
        try {
            if (typedArray.hasValue(AbstractC0305Yp1.ViewBackgroundHelper_android_background)) {
                this.c = typedArray.getResourceId(AbstractC0305Yp1.ViewBackgroundHelper_android_background, -1);
                C0914jb c0914jb = this.b;
                Context context = view.getContext();
                int i2 = this.c;
                synchronized (c0914jb) {
                    colorStateListF = c0914jb.a.f(i2, context);
                }
                if (colorStateListF != null) {
                    e(colorStateListF);
                }
            }
            if (typedArray.hasValue(AbstractC0305Yp1.ViewBackgroundHelper_backgroundTint)) {
                view.setBackgroundTintList(c1342qa2F.a(AbstractC0305Yp1.ViewBackgroundHelper_backgroundTint));
            }
            if (typedArray.hasValue(AbstractC0305Yp1.ViewBackgroundHelper_backgroundTintMode)) {
                view.setBackgroundTintMode(J30.c(typedArray.getInt(AbstractC0305Yp1.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            c1342qa2F.g();
        }
    }

    public final void c() {
        this.c = -1;
        e(null);
        a();
    }

    public final void d(int i) {
        ColorStateList colorStateListF;
        this.c = i;
        C0914jb c0914jb = this.b;
        if (c0914jb != null) {
            Context context = this.a.getContext();
            synchronized (c0914jb) {
                colorStateListF = c0914jb.a.f(i, context);
            }
        } else {
            colorStateListF = null;
        }
        e(colorStateListF);
        a();
    }

    public final void e(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new C1227oa2();
            }
            C1227oa2 c1227oa2 = this.d;
            c1227oa2.a = colorStateList;
            c1227oa2.d = true;
        } else {
            this.d = null;
        }
        a();
    }
}
