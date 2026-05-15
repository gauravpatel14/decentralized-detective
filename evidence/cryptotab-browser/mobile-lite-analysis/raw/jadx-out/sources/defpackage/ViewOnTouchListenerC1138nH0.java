package defpackage;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.ListView;

/* JADX INFO: renamed from: nH0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnTouchListenerC1138nH0 implements View.OnTouchListener {
    public static final int K = ViewConfiguration.getTapTimeout();
    public final int A;
    public final float[] B;
    public final float[] C;
    public final float[] D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final V30 f32J;
    public final C1044li t;
    public final AccelerateInterpolator u;
    public final ListView v;
    public RunnableC1105mi w;
    public final float[] x;
    public final float[] y;
    public final int z;

    public ViewOnTouchListenerC1138nH0(V30 v30) {
        C1044li c1044li = new C1044li();
        c1044li.e = Long.MIN_VALUE;
        c1044li.g = -1L;
        c1044li.f = 0L;
        this.t = c1044li;
        this.u = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.x = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.y = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.B = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.C = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.D = fArr5;
        this.v = v30;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = ((int) ((1575.0f * f) + 0.5f)) / 1000.0f;
        fArr5[0] = f2;
        fArr5[1] = f2;
        float f3 = ((int) ((f * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f3;
        fArr4[1] = f3;
        this.z = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.A = K;
        c1044li.a = 500;
        c1044li.b = 500;
        this.f32J = v30;
    }

    public static float b(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float a(float r4, float r5, float r6, int r7) {
        /*
            r3 = this;
            float[] r0 = r3.x
            r0 = r0[r7]
            float[] r1 = r3.y
            r1 = r1[r7]
            float r0 = r0 * r5
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r4, r0)
            float r5 = r5 - r4
            float r4 = r3.c(r5, r0)
            float r4 = r4 - r1
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            android.view.animation.AccelerateInterpolator r0 = r3.u
            if (r5 >= 0) goto L25
            float r4 = -r4
            float r4 = r0.getInterpolation(r4)
            float r4 = -r4
            goto L2d
        L25:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 <= 0) goto L36
            float r4 = r0.getInterpolation(r4)
        L2d:
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r4 = b(r4, r5, r0)
            goto L37
        L36:
            r4 = r2
        L37:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 != 0) goto L3c
            return r2
        L3c:
            float[] r0 = r3.B
            r0 = r0[r7]
            float[] r1 = r3.C
            r1 = r1[r7]
            float[] r2 = r3.D
            r7 = r2[r7]
            float r0 = r0 * r6
            if (r5 <= 0) goto L51
            float r4 = r4 * r0
            float r4 = b(r4, r1, r7)
            return r4
        L51:
            float r4 = -r4
            float r4 = r4 * r0
            float r4 = b(r4, r1, r7)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ViewOnTouchListenerC1138nH0.a(float, float, float, int):float");
    }

    public final float c(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int i = this.z;
        if (i == 0 || i == 1) {
            if (f < f2) {
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.H && i == 1) {
                    return 1.0f;
                }
            }
        } else if (i == 2 && f < 0.0f) {
            return f / (-f2);
        }
        return 0.0f;
    }

    public final void d() {
        int i = 0;
        if (this.F) {
            this.H = false;
            return;
        }
        C1044li c1044li = this.t;
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i2 = (int) (jCurrentAnimationTimeMillis - c1044li.e);
        int i3 = c1044li.b;
        if (i2 > i3) {
            i = i3;
        } else if (i2 >= 0) {
            i = i2;
        }
        c1044li.i = i;
        c1044li.h = c1044li.a(jCurrentAnimationTimeMillis);
        c1044li.g = jCurrentAnimationTimeMillis;
    }

    public final boolean e() {
        V30 v30;
        int count;
        C1044li c1044li = this.t;
        float f = c1044li.d;
        int iAbs = (int) (f / Math.abs(f));
        Math.abs(c1044li.c);
        if (iAbs == 0 || (count = (v30 = this.f32J).getCount()) == 0) {
            return false;
        }
        int childCount = v30.getChildCount();
        int firstVisiblePosition = v30.getFirstVisiblePosition();
        int i = firstVisiblePosition + childCount;
        if (iAbs > 0) {
            if (i >= count && v30.getChildAt(childCount - 1).getBottom() <= v30.getHeight()) {
                return false;
            }
        } else {
            if (iAbs >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && v30.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            boolean r0 = r7.I
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r8 = 3
            if (r0 == r8) goto L16
            goto L7b
        L16:
            r7.d()
            goto L7b
        L1a:
            r7.G = r2
            r7.E = r1
        L1e:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            android.widget.ListView r4 = r7.v
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.a(r0, r3, r5, r1)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.a(r9, r8, r3, r2)
            li r9 = r7.t
            r9.c = r0
            r9.d = r8
            boolean r8 = r7.H
            if (r8 != 0) goto L7b
            boolean r8 = r7.e()
            if (r8 == 0) goto L7b
            mi r8 = r7.w
            if (r8 != 0) goto L5f
            mi r8 = new mi
            r8.<init>(r7)
            r7.w = r8
        L5f:
            r7.H = r2
            r7.F = r2
            boolean r8 = r7.E
            if (r8 != 0) goto L74
            int r8 = r7.A
            if (r8 <= 0) goto L74
            mi r9 = r7.w
            long r5 = (long) r8
            java.util.WeakHashMap r8 = defpackage.AbstractC0604eo2.a
            r4.postOnAnimationDelayed(r9, r5)
            goto L79
        L74:
            mi r8 = r7.w
            r8.run()
        L79:
            r7.E = r2
        L7b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ViewOnTouchListenerC1138nH0.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
