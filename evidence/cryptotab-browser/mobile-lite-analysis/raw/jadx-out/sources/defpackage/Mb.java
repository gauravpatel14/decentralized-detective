package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Mb {
    public final TextView a;
    public C1227oa2 b;
    public C1227oa2 c;
    public C1227oa2 d;
    public C1227oa2 e;
    public C1227oa2 f;
    public C1227oa2 g;
    public final Ub h;
    public Typeface k;
    public boolean m;
    public int i = 0;
    public int j = -1;
    public String l = null;

    public Mb(TextView textView) {
        this.a = textView;
        this.h = new Ub(textView);
    }

    public static C1227oa2 d(Context context, C0914jb c0914jb, int i) {
        ColorStateList colorStateListF;
        synchronized (c0914jb) {
            colorStateListF = c0914jb.a.f(i, context);
        }
        if (colorStateListF == null) {
            return null;
        }
        C1227oa2 c1227oa2 = new C1227oa2();
        c1227oa2.d = true;
        c1227oa2.a = colorStateListF;
        return c1227oa2;
    }

    public final void a(Drawable drawable, C1227oa2 c1227oa2) {
        if (drawable == null || c1227oa2 == null) {
            return;
        }
        C0914jb.e(drawable, c1227oa2, this.a.getDrawableState());
    }

    public final void b() {
        C1227oa2 c1227oa2 = this.b;
        TextView textView = this.a;
        if (c1227oa2 != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (this.f == null && this.g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f);
        a(compoundDrawablesRelative[2], this.g);
    }

    public final void c(boolean z) {
        Typeface typeface = this.k;
        TextView textView = this.a;
        if (typeface != null) {
            if (this.j == -1) {
                textView.setTypeface(typeface, this.i);
            } else {
                textView.setTypeface(typeface);
            }
        } else if (z) {
            textView.setTypeface(null);
        }
        String str = this.l;
        if (str != null) {
            if (Objects.equals(textView.getFontVariationSettings(), str)) {
                textView.setFontVariationSettings("");
            }
            textView.setFontVariationSettings(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:209:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:222:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(android.util.AttributeSet r20, int r21) {
        /*
            Method dump skipped, instruction units count: 967
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Mb.e(android.util.AttributeSet, int):void");
    }

    public final void f(int i, Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, AbstractC0305Yp1.TextAppearance);
        C1342qa2 c1342qa2 = new C1342qa2(context, typedArrayObtainStyledAttributes);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(AbstractC0305Yp1.TextAppearance_textAllCaps);
        TextView textView = this.a;
        if (zHasValue) {
            textView.setAllCaps(typedArrayObtainStyledAttributes.getBoolean(AbstractC0305Yp1.TextAppearance_textAllCaps, false));
        }
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC0305Yp1.TextAppearance_android_textSize) && typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC0305Yp1.TextAppearance_android_textSize, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        boolean zJ = j(context, c1342qa2);
        c1342qa2.g();
        c(zJ);
    }

    public final void g(int i, int i2, int i3, int i4) {
        Ub ub = this.h;
        if (ub.j()) {
            DisplayMetrics displayMetrics = ub.j.getResources().getDisplayMetrics();
            ub.k(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (ub.h()) {
                ub.a();
            }
        }
    }

    public final void h(int[] iArr, int i) {
        Ub ub = this.h;
        if (ub.j()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = ub.j.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArrCopyOf[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                ub.f = Ub.b(iArrCopyOf);
                if (!ub.i()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                ub.g = false;
            }
            if (ub.h()) {
                ub.a();
            }
        }
    }

    public final void i(int i) {
        Ub ub = this.h;
        if (ub.j()) {
            if (i == 0) {
                ub.a = 0;
                ub.d = -1.0f;
                ub.e = -1.0f;
                ub.c = -1.0f;
                ub.f = new int[0];
                ub.b = false;
                return;
            }
            if (i != 1) {
                throw new IllegalArgumentException(AbstractC1214oR1.a(i, "Unknown auto-size text type: "));
            }
            DisplayMetrics displayMetrics = ub.j.getResources().getDisplayMetrics();
            ub.k(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (ub.h()) {
                ub.a();
            }
        }
    }

    public final boolean j(Context context, C1342qa2 c1342qa2) {
        String string;
        int i = AbstractC0305Yp1.TextAppearance_android_textStyle;
        int i2 = this.i;
        TypedArray typedArray = c1342qa2.b;
        this.i = typedArray.getInt(i, i2);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 28) {
            int i4 = typedArray.getInt(AbstractC0305Yp1.TextAppearance_android_textFontWeight, -1);
            this.j = i4;
            if (i4 != -1) {
                this.i &= 2;
            }
        }
        if (typedArray.hasValue(AbstractC0305Yp1.TextAppearance_fontVariationSettings)) {
            this.l = typedArray.getString(AbstractC0305Yp1.TextAppearance_fontVariationSettings);
        }
        if (!typedArray.hasValue(AbstractC0305Yp1.TextAppearance_android_fontFamily) && !typedArray.hasValue(AbstractC0305Yp1.TextAppearance_fontFamily)) {
            if (!typedArray.hasValue(AbstractC0305Yp1.TextAppearance_android_typeface)) {
                return false;
            }
            this.m = false;
            int i5 = typedArray.getInt(AbstractC0305Yp1.TextAppearance_android_typeface, 1);
            if (i5 == 1) {
                this.k = Typeface.SANS_SERIF;
            } else if (i5 == 2) {
                this.k = Typeface.SERIF;
            } else if (i5 == 3) {
                this.k = Typeface.MONOSPACE;
            }
            return true;
        }
        this.k = null;
        int i6 = typedArray.hasValue(AbstractC0305Yp1.TextAppearance_fontFamily) ? AbstractC0305Yp1.TextAppearance_fontFamily : AbstractC0305Yp1.TextAppearance_android_fontFamily;
        int i7 = this.j;
        int i8 = this.i;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceD = c1342qa2.d(i6, this.i, new Jb(this, i7, i8, new WeakReference(this.a)));
                if (typefaceD != null) {
                    if (i3 < 28 || this.j == -1) {
                        this.k = typefaceD;
                    } else {
                        this.k = Lb.a(Typeface.create(typefaceD, 0), this.j, (this.i & 2) != 0);
                    }
                }
                this.m = this.k == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.k == null && (string = typedArray.getString(i6)) != null) {
            if (Build.VERSION.SDK_INT < 28 || this.j == -1) {
                this.k = Typeface.create(string, this.i);
            } else {
                this.k = Lb.a(Typeface.create(string, 0), this.j, (this.i & 2) != 0);
            }
        }
        return true;
    }
}
