package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: renamed from: qa2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1342qa2 {
    public final Context a;
    public final TypedArray b;
    public TypedValue c;

    public C1342qa2(Context context, TypedArray typedArray) {
        this.a = context;
        this.b = typedArray;
    }

    public static C1342qa2 e(Context context, AttributeSet attributeSet, int[] iArr) {
        return new C1342qa2(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static C1342qa2 f(Context context, AttributeSet attributeSet, int[] iArr, int i) {
        return new C1342qa2(context, context.obtainStyledAttributes(attributeSet, iArr, i, 0));
    }

    public final ColorStateList a(int i) {
        int resourceId;
        ColorStateList colorStateListB;
        TypedArray typedArray = this.b;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListB = U3.b(resourceId, this.a)) == null) ? typedArray.getColorStateList(i) : colorStateListB;
    }

    public final Drawable b(int i) {
        int resourceId;
        TypedArray typedArray = this.b;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) ? typedArray.getDrawable(i) : AbstractC1686wb.a(resourceId, this.a);
    }

    public final Drawable c(int i) {
        int resourceId;
        Drawable drawableD;
        if (!this.b.hasValue(i) || (resourceId = this.b.getResourceId(i, 0)) == 0) {
            return null;
        }
        C0914jb c0914jbA = C0914jb.a();
        Context context = this.a;
        synchronized (c0914jbA) {
            drawableD = c0914jbA.a.d(resourceId, context, true);
        }
        return drawableD;
    }

    public final Typeface d(int i, int i2, Jb jb) {
        int resourceId = this.b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.c == null) {
            this.c = new TypedValue();
        }
        TypedValue typedValue = this.c;
        ThreadLocal threadLocal = kv1.a;
        Context context = this.a;
        if (context.isRestricted()) {
            return null;
        }
        return kv1.c(context, resourceId, typedValue, i2, jb, true, false);
    }

    public final void g() {
        this.b.recycle();
    }
}
