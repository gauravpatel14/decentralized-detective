package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: kn2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0989kn2 extends AbstractC0437bn2 {
    public static final PorterDuff.Mode C = PorterDuff.Mode.SRC_IN;
    public final Matrix A;
    public final Rect B;
    public C0867in2 u;
    public PorterDuffColorFilter v;
    public ColorFilter w;
    public boolean x;
    public boolean y;
    public final float[] z;

    public C0989kn2() {
        this.y = true;
        this.z = new float[9];
        this.A = new Matrix();
        this.B = new Rect();
        C0867in2 c0867in2 = new C0867in2();
        c0867in2.c = null;
        c0867in2.d = C;
        c0867in2.b = new C0803hn2();
        this.u = c0867in2;
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.t;
        if (drawable == null) {
            return false;
        }
        drawable.canApplyTheme();
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.B;
        copyBounds(rect);
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.w;
        if (colorFilter == null) {
            colorFilter = this.v;
        }
        Matrix matrix = this.A;
        canvas.getMatrix(matrix);
        float[] fArr = this.z;
        matrix.getValues(fArr);
        float fAbs = Math.abs(fArr[0]);
        float fAbs2 = Math.abs(fArr[4]);
        float fAbs3 = Math.abs(fArr[1]);
        float fAbs4 = Math.abs(fArr[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iWidth = (int) (rect.width() * fAbs);
        int iMin = Math.min(2048, iWidth);
        int iMin2 = Math.min(2048, (int) (rect.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(rect.left, rect.top);
        if (isAutoMirrored() && getLayoutDirection() == 1) {
            canvas.translate(rect.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        rect.offsetTo(0, 0);
        C0867in2 c0867in2 = this.u;
        Bitmap bitmap = c0867in2.f;
        if (bitmap == null || iMin != bitmap.getWidth() || iMin2 != c0867in2.f.getHeight()) {
            c0867in2.f = Bitmap.createBitmap(iMin, iMin2, Bitmap.Config.ARGB_8888);
            c0867in2.k = true;
        }
        if (this.y) {
            C0867in2 c0867in22 = this.u;
            if (c0867in22.k || c0867in22.g != c0867in22.c || c0867in22.h != c0867in22.d || c0867in22.j != c0867in22.e || c0867in22.i != c0867in22.b.getRootAlpha()) {
                C0867in2 c0867in23 = this.u;
                c0867in23.f.eraseColor(0);
                Canvas canvas2 = new Canvas(c0867in23.f);
                C0803hn2 c0803hn2 = c0867in23.b;
                c0803hn2.a(c0803hn2.g, C0803hn2.p, canvas2, iMin, iMin2);
                C0867in2 c0867in24 = this.u;
                c0867in24.g = c0867in24.c;
                c0867in24.h = c0867in24.d;
                c0867in24.i = c0867in24.b.getRootAlpha();
                c0867in24.j = c0867in24.e;
                c0867in24.k = false;
            }
        } else {
            C0867in2 c0867in25 = this.u;
            c0867in25.f.eraseColor(0);
            Canvas canvas3 = new Canvas(c0867in25.f);
            C0803hn2 c0803hn22 = c0867in25.b;
            c0803hn22.a(c0803hn22.g, C0803hn2.p, canvas3, iMin, iMin2);
        }
        C0867in2 c0867in26 = this.u;
        if (c0867in26.b.getRootAlpha() >= 255 && colorFilter == null) {
            paint = null;
        } else {
            if (c0867in26.l == null) {
                Paint paint2 = new Paint();
                c0867in26.l = paint2;
                paint2.setFilterBitmap(true);
            }
            c0867in26.l.setAlpha(c0867in26.b.getRootAlpha());
            c0867in26.l.setColorFilter(colorFilter);
            paint = c0867in26.l;
        }
        canvas.drawBitmap(c0867in26.f, (Rect) null, rect, paint);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.t;
        return drawable != null ? drawable.getAlpha() : this.u.b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.t;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.u.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.t;
        return drawable != null ? drawable.getColorFilter() : this.w;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.t != null) {
            return new C0928jn2(this.t.getConstantState());
        }
        this.u.a = getChangingConfigurations();
        return this.u;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.t;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.u.b.i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.t;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.u.b.h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.t;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.t;
        return drawable != null ? drawable.isAutoMirrored() : this.u.e;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        Drawable drawable = this.t;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (!super.isStateful()) {
            C0867in2 c0867in2 = this.u;
            if (c0867in2 != null) {
                C0803hn2 c0803hn2 = c0867in2.b;
                if (c0803hn2.n == null) {
                    c0803hn2.n = Boolean.valueOf(c0803hn2.g.a());
                }
                if (c0803hn2.n.booleanValue() || ((colorStateList = this.u.c) != null && colorStateList.isStateful())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.x && super.mutate() == this) {
            C0867in2 c0867in2 = this.u;
            C0867in2 c0867in22 = new C0867in2();
            c0867in22.c = null;
            c0867in22.d = C;
            if (c0867in2 != null) {
                c0867in22.a = c0867in2.a;
                C0803hn2 c0803hn2 = new C0803hn2(c0867in2.b);
                c0867in22.b = c0803hn2;
                if (c0867in2.b.e != null) {
                    c0803hn2.e = new Paint(c0867in2.b.e);
                }
                if (c0867in2.b.d != null) {
                    c0867in22.b.d = new Paint(c0867in2.b.d);
                }
                c0867in22.c = c0867in2.c;
                c0867in22.d = c0867in2.d;
                c0867in22.e = c0867in2.e;
            }
            this.u = c0867in22;
            this.x = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean z;
        PorterDuff.Mode mode;
        Drawable drawable = this.t;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        C0867in2 c0867in2 = this.u;
        ColorStateList colorStateList = c0867in2.c;
        if (colorStateList == null || (mode = c0867in2.d) == null) {
            z = false;
        } else {
            this.v = a(colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        C0803hn2 c0803hn2 = c0867in2.b;
        if (c0803hn2.n == null) {
            c0803hn2.n = Boolean.valueOf(c0803hn2.g.a());
        }
        if (c0803hn2.n.booleanValue()) {
            boolean zB = c0867in2.b.g.b(iArr);
            c0867in2.k |= zB;
            if (zB) {
                invalidateSelf();
                return true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.u.b.getRootAlpha() != i) {
            this.u.b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
        } else {
            this.u.e = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.w = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        Drawable drawable = this.t;
        if (drawable != null) {
            C30.a(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
            return;
        }
        C0867in2 c0867in2 = this.u;
        if (c0867in2.c != colorStateList) {
            c0867in2.c = colorStateList;
            this.v = a(colorStateList, c0867in2.d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.setTintMode(mode);
            return;
        }
        C0867in2 c0867in2 = this.u;
        if (c0867in2.d != mode) {
            c0867in2.d = mode;
            this.v = a(c0867in2.c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.t;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        C0803hn2 c0803hn2;
        int i;
        int i2;
        boolean z;
        int i3;
        boolean z2;
        Paint.Join join;
        Paint.Cap cap;
        Paint.Join join2;
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0867in2 c0867in2 = this.u;
        c0867in2.b = new C0803hn2();
        TypedArray typedArrayD = AbstractC0255Vi2.d(resources, theme, attributeSet, U8.a);
        C0867in2 c0867in22 = this.u;
        C0803hn2 c0803hn22 = c0867in22.b;
        int i4 = !AbstractC0255Vi2.c(xmlPullParser, "tintMode") ? -1 : typedArrayD.getInt(6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        int i5 = 3;
        if (i4 == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (i4 != 5) {
            if (i4 != 9) {
                switch (i4) {
                    case 14:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        c0867in22.d = mode;
        int i6 = 1;
        ColorStateList colorStateListA = null;
        boolean z3 = false;
        if (AbstractC0255Vi2.c(xmlPullParser, "tint")) {
            TypedValue typedValue = new TypedValue();
            typedArrayD.getValue(1, typedValue);
            int i7 = typedValue.type;
            if (i7 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue);
            }
            if (i7 >= 28 && i7 <= 31) {
                colorStateListA = ColorStateList.valueOf(typedValue.data);
            } else {
                Resources resources2 = typedArrayD.getResources();
                int resourceId = typedArrayD.getResourceId(1, 0);
                ThreadLocal threadLocal = AbstractC1492tH.a;
                try {
                    colorStateListA = AbstractC1492tH.a(resources2, resources2.getXml(resourceId), theme);
                } catch (Exception e) {
                    Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
                }
            }
        }
        ColorStateList colorStateList = colorStateListA;
        if (colorStateList != null) {
            c0867in22.c = colorStateList;
        }
        boolean z4 = c0867in22.e;
        if (AbstractC0255Vi2.c(xmlPullParser, "autoMirrored")) {
            z4 = typedArrayD.getBoolean(5, z4);
        }
        c0867in22.e = z4;
        float f = c0803hn22.j;
        if (AbstractC0255Vi2.c(xmlPullParser, "viewportWidth")) {
            f = typedArrayD.getFloat(7, f);
        }
        c0803hn22.j = f;
        float f2 = c0803hn22.k;
        if (AbstractC0255Vi2.c(xmlPullParser, "viewportHeight")) {
            f2 = typedArrayD.getFloat(8, f2);
        }
        c0803hn22.k = f2;
        if (c0803hn22.j <= 0.0f) {
            throw new XmlPullParserException(typedArrayD.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f2 > 0.0f) {
            c0803hn22.h = typedArrayD.getDimension(3, c0803hn22.h);
            float dimension = typedArrayD.getDimension(2, c0803hn22.i);
            c0803hn22.i = dimension;
            if (c0803hn22.h <= 0.0f) {
                throw new XmlPullParserException(typedArrayD.getPositionDescription() + "<vector> tag requires width > 0");
            }
            if (dimension > 0.0f) {
                float alpha = c0803hn22.getAlpha();
                if (AbstractC0255Vi2.c(xmlPullParser, "alpha")) {
                    alpha = typedArrayD.getFloat(4, alpha);
                }
                c0803hn22.setAlpha(alpha);
                String string = typedArrayD.getString(0);
                if (string != null) {
                    c0803hn22.m = string;
                    c0803hn22.o.put(string, c0803hn22);
                }
                typedArrayD.recycle();
                c0867in2.a = getChangingConfigurations();
                c0867in2.k = true;
                C0867in2 c0867in23 = this.u;
                C0803hn2 c0803hn23 = c0867in23.b;
                ArrayDeque arrayDeque = new ArrayDeque();
                arrayDeque.push(c0803hn23.g);
                int eventType = xmlPullParser.getEventType();
                int depth = xmlPullParser.getDepth() + 1;
                boolean z5 = true;
                while (eventType != i6 && (xmlPullParser.getDepth() >= depth || eventType != i5)) {
                    if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        C0603en2 c0603en2 = (C0603en2) arrayDeque.peek();
                        if (c0603en2 != null) {
                            boolean zEquals = "path".equals(name);
                            ArrayList arrayList = c0603en2.b;
                            i = depth;
                            gf gfVar = c0803hn23.o;
                            if (zEquals) {
                                C0547dn2 c0547dn2 = new C0547dn2();
                                c0547dn2.e = 0.0f;
                                c0547dn2.g = 1.0f;
                                c0547dn2.h = 1.0f;
                                c0547dn2.i = 0.0f;
                                c0547dn2.j = 1.0f;
                                c0547dn2.k = 0.0f;
                                Paint.Cap cap2 = Paint.Cap.BUTT;
                                c0547dn2.l = cap2;
                                Paint.Join join3 = Paint.Join.MITER;
                                c0547dn2.m = join3;
                                c0803hn2 = c0803hn23;
                                c0547dn2.n = 4.0f;
                                TypedArray typedArrayD2 = AbstractC0255Vi2.d(resources, theme, attributeSet, U8.c);
                                if (AbstractC0255Vi2.c(xmlPullParser, "pathData")) {
                                    String string2 = typedArrayD2.getString(0);
                                    if (string2 != null) {
                                        c0547dn2.b = string2;
                                    }
                                    String string3 = typedArrayD2.getString(2);
                                    if (string3 != null) {
                                        c0547dn2.a = rc1.b(string3);
                                    }
                                    c0547dn2.f = AbstractC0255Vi2.b(typedArrayD2, xmlPullParser, theme, "fillColor", 1);
                                    float f3 = c0547dn2.h;
                                    if (AbstractC0255Vi2.c(xmlPullParser, "fillAlpha")) {
                                        f3 = typedArrayD2.getFloat(12, f3);
                                    }
                                    c0547dn2.h = f3;
                                    int i8 = !AbstractC0255Vi2.c(xmlPullParser, "strokeLineCap") ? -1 : typedArrayD2.getInt(8, -1);
                                    Paint.Cap cap3 = c0547dn2.l;
                                    if (i8 != 0) {
                                        join = join3;
                                        if (i8 != 1) {
                                            cap = i8 != 2 ? cap3 : Paint.Cap.SQUARE;
                                        } else {
                                            cap = Paint.Cap.ROUND;
                                        }
                                    } else {
                                        join = join3;
                                        cap = cap2;
                                    }
                                    c0547dn2.l = cap;
                                    int i9 = !AbstractC0255Vi2.c(xmlPullParser, "strokeLineJoin") ? -1 : typedArrayD2.getInt(9, -1);
                                    Paint.Join join4 = c0547dn2.m;
                                    if (i9 == 0) {
                                        join2 = join;
                                    } else if (i9 != 1) {
                                        join2 = i9 != 2 ? join4 : Paint.Join.BEVEL;
                                    } else {
                                        join2 = Paint.Join.ROUND;
                                    }
                                    c0547dn2.m = join2;
                                    float f4 = c0547dn2.n;
                                    if (AbstractC0255Vi2.c(xmlPullParser, "strokeMiterLimit")) {
                                        f4 = typedArrayD2.getFloat(10, f4);
                                    }
                                    c0547dn2.n = f4;
                                    c0547dn2.d = AbstractC0255Vi2.b(typedArrayD2, xmlPullParser, theme, "strokeColor", 3);
                                    float f5 = c0547dn2.g;
                                    if (AbstractC0255Vi2.c(xmlPullParser, "strokeAlpha")) {
                                        f5 = typedArrayD2.getFloat(11, f5);
                                    }
                                    c0547dn2.g = f5;
                                    float f6 = c0547dn2.e;
                                    if (AbstractC0255Vi2.c(xmlPullParser, "strokeWidth")) {
                                        f6 = typedArrayD2.getFloat(4, f6);
                                    }
                                    c0547dn2.e = f6;
                                    float f7 = c0547dn2.j;
                                    if (AbstractC0255Vi2.c(xmlPullParser, "trimPathEnd")) {
                                        f7 = typedArrayD2.getFloat(6, f7);
                                    }
                                    c0547dn2.j = f7;
                                    float f8 = c0547dn2.k;
                                    if (AbstractC0255Vi2.c(xmlPullParser, "trimPathOffset")) {
                                        f8 = typedArrayD2.getFloat(7, f8);
                                    }
                                    c0547dn2.k = f8;
                                    float f9 = c0547dn2.i;
                                    if (AbstractC0255Vi2.c(xmlPullParser, "trimPathStart")) {
                                        f9 = typedArrayD2.getFloat(5, f9);
                                    }
                                    c0547dn2.i = f9;
                                    int i10 = c0547dn2.c;
                                    if (AbstractC0255Vi2.c(xmlPullParser, "fillType")) {
                                        i10 = typedArrayD2.getInt(13, i10);
                                    }
                                    c0547dn2.c = i10;
                                }
                                typedArrayD2.recycle();
                                arrayList.add(c0547dn2);
                                if (c0547dn2.getPathName() != null) {
                                    gfVar.put(c0547dn2.getPathName(), c0547dn2);
                                }
                                c0867in23.a = c0867in23.a;
                                z2 = false;
                                i2 = 1;
                                z5 = false;
                            } else {
                                c0803hn2 = c0803hn23;
                                if ("clip-path".equals(name)) {
                                    C0500cn2 c0500cn2 = new C0500cn2();
                                    if (AbstractC0255Vi2.c(xmlPullParser, "pathData")) {
                                        TypedArray typedArrayD3 = AbstractC0255Vi2.d(resources, theme, attributeSet, U8.d);
                                        String string4 = typedArrayD3.getString(0);
                                        if (string4 != null) {
                                            c0500cn2.b = string4;
                                        }
                                        String string5 = typedArrayD3.getString(1);
                                        if (string5 != null) {
                                            c0500cn2.a = rc1.b(string5);
                                        }
                                        c0500cn2.c = !AbstractC0255Vi2.c(xmlPullParser, "fillType") ? 0 : typedArrayD3.getInt(2, 0);
                                        typedArrayD3.recycle();
                                    }
                                    arrayList.add(c0500cn2);
                                    if (c0500cn2.getPathName() != null) {
                                        gfVar.put(c0500cn2.getPathName(), c0500cn2);
                                    }
                                    c0867in23.a = c0867in23.a;
                                } else if ("group".equals(name)) {
                                    C0603en2 c0603en22 = new C0603en2();
                                    TypedArray typedArrayD4 = AbstractC0255Vi2.d(resources, theme, attributeSet, U8.b);
                                    float f10 = c0603en22.c;
                                    if (AbstractC0255Vi2.c(xmlPullParser, "rotation")) {
                                        f10 = typedArrayD4.getFloat(5, f10);
                                    }
                                    c0603en22.c = f10;
                                    i2 = 1;
                                    c0603en22.d = typedArrayD4.getFloat(1, c0603en22.d);
                                    c0603en22.e = typedArrayD4.getFloat(2, c0603en22.e);
                                    float f11 = c0603en22.f;
                                    if (AbstractC0255Vi2.c(xmlPullParser, "scaleX")) {
                                        f11 = typedArrayD4.getFloat(3, f11);
                                    }
                                    c0603en22.f = f11;
                                    float f12 = c0603en22.g;
                                    if (AbstractC0255Vi2.c(xmlPullParser, "scaleY")) {
                                        f12 = typedArrayD4.getFloat(4, f12);
                                    }
                                    c0603en22.g = f12;
                                    float f13 = c0603en22.h;
                                    if (AbstractC0255Vi2.c(xmlPullParser, "translateX")) {
                                        f13 = typedArrayD4.getFloat(6, f13);
                                    }
                                    c0603en22.h = f13;
                                    float f14 = c0603en22.i;
                                    if (AbstractC0255Vi2.c(xmlPullParser, "translateY")) {
                                        f14 = typedArrayD4.getFloat(7, f14);
                                    }
                                    c0603en22.i = f14;
                                    z2 = false;
                                    String string6 = typedArrayD4.getString(0);
                                    if (string6 != null) {
                                        c0603en22.k = string6;
                                    }
                                    c0603en22.c();
                                    typedArrayD4.recycle();
                                    arrayList.add(c0603en22);
                                    arrayDeque.push(c0603en22);
                                    if (c0603en22.getGroupName() != null) {
                                        gfVar.put(c0603en22.getGroupName(), c0603en22);
                                    }
                                    c0867in23.a = c0867in23.a;
                                }
                                z2 = false;
                                i2 = 1;
                            }
                        } else {
                            c0803hn2 = c0803hn23;
                            i = depth;
                            i2 = i6;
                            z2 = z3;
                        }
                        z = z2;
                        i3 = 3;
                    } else {
                        c0803hn2 = c0803hn23;
                        i = depth;
                        i2 = i6;
                        z = z3;
                        i3 = 3;
                        if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                            arrayDeque.pop();
                        }
                    }
                    eventType = xmlPullParser.next();
                    i5 = i3;
                    z3 = z;
                    i6 = i2;
                    depth = i;
                    c0803hn23 = c0803hn2;
                }
                if (!z5) {
                    this.v = a(c0867in2.c, c0867in2.d);
                    return;
                }
                throw new XmlPullParserException("no path defined");
            }
            throw new XmlPullParserException(typedArrayD.getPositionDescription() + "<vector> tag requires height > 0");
        }
        throw new XmlPullParserException(typedArrayD.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }

    public C0989kn2(C0867in2 c0867in2) {
        this.y = true;
        this.z = new float[9];
        this.A = new Matrix();
        this.B = new Rect();
        this.u = c0867in2;
        this.v = a(c0867in2.c, c0867in2.d);
    }
}
