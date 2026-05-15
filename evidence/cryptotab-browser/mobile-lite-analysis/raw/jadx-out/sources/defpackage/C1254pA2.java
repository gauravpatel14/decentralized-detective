package defpackage;

import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: pA2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1254pA2 extends Drawable implements Drawable.Callback {
    public boolean A;
    public final C1068mA2 B;
    public Drawable C;
    public Drawable D;
    public boolean E;
    public boolean F;
    public boolean G;
    public int H;
    public long u;
    public int v;
    public int x;
    public int t = 0;
    public int w = 255;
    public int y = 0;
    public final boolean z = true;

    public C1254pA2(C1068mA2 c1068mA2) {
        C1068mA2 c1068mA22 = new C1068mA2();
        if (c1068mA2 != null) {
            c1068mA22.a = c1068mA2.a;
            c1068mA22.b = c1068mA2.b;
        }
        this.B = c1068mA22;
    }

    public final boolean a() {
        if (!this.E) {
            boolean z = false;
            if (this.C.getConstantState() != null && this.D.getConstantState() != null) {
                z = true;
            }
            this.F = z;
            this.E = true;
        }
        return this.F;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void draw(android.graphics.Canvas r8) {
        /*
            r7 = this;
            int r0 = r7.t
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == r3) goto L3a
            if (r0 == r1) goto Lb
        L9:
            r4 = r3
            goto L43
        Lb:
            long r0 = r7.u
            r4 = 0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 < 0) goto L9
            long r0 = android.os.SystemClock.uptimeMillis()
            long r4 = r7.u
            long r0 = r0 - r4
            int r4 = r7.x
            float r4 = (float) r4
            float r0 = (float) r0
            float r0 = r0 / r4
            r1 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r4 < 0) goto L27
            r4 = r3
            goto L28
        L27:
            r4 = r2
        L28:
            if (r4 == 0) goto L2c
            r7.t = r2
        L2c:
            float r0 = java.lang.Math.min(r0, r1)
            int r1 = r7.v
            float r1 = (float) r1
            float r1 = r1 * r0
            r0 = 0
            float r1 = r1 + r0
            int r0 = (int) r1
            r7.y = r0
            goto L43
        L3a:
            long r4 = android.os.SystemClock.uptimeMillis()
            r7.u = r4
            r7.t = r1
            r4 = r2
        L43:
            int r0 = r7.y
            boolean r1 = r7.z
            android.graphics.drawable.Drawable r5 = r7.C
            android.graphics.drawable.Drawable r6 = r7.D
            if (r4 == 0) goto L62
            if (r1 == 0) goto L52
            if (r0 != 0) goto L57
            goto L53
        L52:
            r2 = r0
        L53:
            r5.draw(r8)
            r0 = r2
        L57:
            int r1 = r7.w
            if (r0 != r1) goto L61
            r6.setAlpha(r1)
            r6.draw(r8)
        L61:
            return
        L62:
            if (r1 == 0) goto L6b
            int r1 = r7.w
            int r1 = r1 - r0
            r5.setAlpha(r1)
            r2 = r3
        L6b:
            r5.draw(r8)
            if (r2 == 0) goto L75
            int r1 = r7.w
            r5.setAlpha(r1)
        L75:
            if (r0 <= 0) goto L82
            r6.setAlpha(r0)
            r6.draw(r8)
            int r8 = r7.w
            r6.setAlpha(r8)
        L82:
            r7.invalidateSelf()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1254pA2.draw(android.graphics.Canvas):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        C1068mA2 c1068mA2 = this.B;
        return changingConfigurations | c1068mA2.a | c1068mA2.b;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!a()) {
            return null;
        }
        int changingConfigurations = getChangingConfigurations();
        C1068mA2 c1068mA2 = this.B;
        c1068mA2.a = changingConfigurations;
        return c1068mA2;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return Math.max(this.C.getIntrinsicHeight(), this.D.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.max(this.C.getIntrinsicWidth(), this.D.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        if (!this.G) {
            this.H = Drawable.resolveOpacity(this.C.getOpacity(), this.D.getOpacity());
            this.G = true;
        }
        return this.H;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.A && super.mutate() == this) {
            if (!a()) {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            this.C.mutate();
            this.D.mutate();
            this.A = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.C.setBounds(rect);
        this.D.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.y == this.w) {
            this.y = i;
        }
        this.w = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.C.setColorFilter(colorFilter);
        this.D.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }
}
