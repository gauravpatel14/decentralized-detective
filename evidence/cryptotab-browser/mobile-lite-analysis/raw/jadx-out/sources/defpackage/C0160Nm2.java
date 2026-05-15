package defpackage;

import android.view.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: renamed from: Nm2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0160Nm2 implements Cloneable {
    public static final Q K = new Q();
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public long F;
    public boolean G;
    public jz0 H;
    public C0668fn1[] I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public HashMap f2J;
    public ArrayList t;
    public ArrayList u;
    public ArrayList v;
    public long w;
    public float x;
    public float y;
    public long z;

    public static float b(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        return Math.min(f, 1);
    }

    public static float d(float f) {
        float fB = b(f);
        float fB2 = b(fB);
        double d = fB2;
        double dFloor = Math.floor(d);
        if (d == dFloor && fB2 > 0.0f) {
            dFloor -= 1.0d;
        }
        return fB - ((int) dFloor);
    }

    public final void a(float f) {
        float fA;
        float interpolation = this.H.getInterpolation(f);
        int length = this.I.length;
        for (int i = 0; i < length; i++) {
            C0668fn1 c0668fn1 = this.I[i];
            C1860zg0 c1860zg0 = c0668fn1.x;
            List list = c1860zg0.u;
            int i2 = 1;
            if (interpolation > 0.0f) {
                int i3 = c1860zg0.t;
                if (interpolation < 1.0f) {
                    HC0 hc0 = (HC0) list.get(0);
                    while (true) {
                        if (i2 >= i3) {
                            fA = ((HC0) list.get(i3 - 1)).v;
                            break;
                        }
                        HC0 hc02 = (HC0) list.get(i2);
                        float f2 = hc02.u;
                        if (interpolation < f2) {
                            float f3 = hc0.u;
                            float f4 = (interpolation - f3) / (f2 - f3);
                            InterfaceC0208Ri2 interfaceC0208Ri2 = c1860zg0.v;
                            float f5 = hc0.v;
                            float f6 = hc02.v;
                            fA = interfaceC0208Ri2 == null ? AbstractC0146Mm2.a(f6, f5, f4, f5) : ((Float) interfaceC0208Ri2.a(f4, Float.valueOf(f5), Float.valueOf(f6))).floatValue();
                        } else {
                            i2++;
                            hc0 = hc02;
                        }
                    }
                } else {
                    HC0 hc03 = (HC0) list.get(i3 - 2);
                    HC0 hc04 = (HC0) list.get(i3 - 1);
                    float f7 = hc03.v;
                    float f8 = hc04.v;
                    float f9 = hc03.u;
                    float f10 = (interpolation - f9) / (hc04.u - f9);
                    InterfaceC0208Ri2 interfaceC0208Ri22 = c1860zg0.v;
                    fA = interfaceC0208Ri22 == null ? AbstractC0146Mm2.a(f8, f7, f10, f7) : ((Float) interfaceC0208Ri22.a(f10, Float.valueOf(f7), Float.valueOf(f8))).floatValue();
                }
            } else {
                HC0 hc05 = (HC0) list.get(0);
                HC0 hc06 = (HC0) list.get(1);
                float f11 = hc05.v;
                float f12 = hc06.v;
                float f13 = hc05.u;
                float f14 = (interpolation - f13) / (hc06.u - f13);
                InterfaceC0208Ri2 interfaceC0208Ri23 = c1860zg0.v;
                fA = interfaceC0208Ri23 == null ? AbstractC0146Mm2.a(f12, f11, f14, f11) : ((Float) interfaceC0208Ri23.a(f14, Float.valueOf(f11), Float.valueOf(f12))).floatValue();
            }
            c0668fn1.y = fA;
        }
        ArrayList arrayList = this.v;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((K9) this.v.get(i4)).a(this);
            }
        }
    }

    public final void c() {
        ArrayList arrayList;
        if (this.E) {
            return;
        }
        if (this.G) {
            ThreadLocal threadLocal = C9.d;
            if (threadLocal.get() == null) {
                threadLocal.set(new C9());
            }
            C9 c9 = (C9) threadLocal.get();
            ArrayList arrayList2 = c9.b;
            int iIndexOf = arrayList2.indexOf(this);
            if (iIndexOf >= 0) {
                arrayList2.set(iIndexOf, null);
                c9.c = true;
            }
        }
        this.E = true;
        boolean z = (this.B || this.A) && this.t != null;
        if (z && !this.A) {
            f();
        }
        this.A = false;
        this.B = false;
        this.C = false;
        this.z = -1L;
        this.w = -1L;
        if (!z || (arrayList = this.t) == null) {
            return;
        }
        ArrayList arrayList3 = (ArrayList) arrayList.clone();
        int size = arrayList3.size();
        for (int i = 0; i < size; i++) {
            ((L9) arrayList3.get(i)).a();
        }
    }

    public final Object clone() {
        try {
            C0160Nm2 c0160Nm2 = (C0160Nm2) super.clone();
            if (this.t != null) {
                c0160Nm2.t = new ArrayList(this.t);
            }
            if (this.u != null) {
                c0160Nm2.u = new ArrayList(this.u);
            }
            if (this.v != null) {
                c0160Nm2.v = new ArrayList(this.v);
            }
            c0160Nm2.x = -1.0f;
            c0160Nm2.D = false;
            c0160Nm2.B = false;
            c0160Nm2.A = false;
            c0160Nm2.C = false;
            c0160Nm2.w = -1L;
            c0160Nm2.E = false;
            c0160Nm2.z = -1L;
            c0160Nm2.y = 0.0f;
            c0160Nm2.G = true;
            C0668fn1[] c0668fn1Arr = this.I;
            if (c0668fn1Arr != null) {
                int length = c0668fn1Arr.length;
                c0160Nm2.I = new C0668fn1[length];
                c0160Nm2.f2J = new HashMap(length);
                for (int i = 0; i < length; i++) {
                    C0668fn1 c0668fn1A = c0668fn1Arr[i].clone();
                    c0160Nm2.I[i] = c0668fn1A;
                    c0160Nm2.f2J.put("", c0668fn1A);
                }
            }
            return c0160Nm2;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public final void e() {
        if (this.D) {
            return;
        }
        int length = this.I.length;
        for (int i = 0; i < length; i++) {
            C0668fn1 c0668fn1 = this.I[i];
            if (c0668fn1.w == null) {
                Class cls = c0668fn1.t;
                c0668fn1.w = cls == Integer.class ? C1243oy0.a : cls == Float.class ? C1798yg0.a : null;
            }
            InterfaceC0208Ri2 interfaceC0208Ri2 = c0668fn1.w;
            if (interfaceC0208Ri2 != null) {
                c0668fn1.u.v = interfaceC0208Ri2;
            }
        }
        this.D = true;
    }

    public final void f() {
        ArrayList arrayList = this.t;
        if (arrayList != null && !this.C) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                ((L9) arrayList2.get(i)).getClass();
            }
        }
        this.C = true;
    }

    public final void g(float f) {
        e();
        float fB = b(f);
        if (this.z >= 0) {
            this.w = AnimationUtils.currentAnimationTimeMillis() - ((long) (((long) (this.F * 1.0f)) * fB));
        } else {
            this.x = fB;
        }
        this.y = fB;
        a(d(fB));
    }

    public final void h() {
        this.E = false;
        e();
        this.A = true;
        float f = this.x;
        if (f >= 0.0f) {
            this.y = f;
        } else {
            this.y = 0.0f;
        }
        if (this.t != null) {
            f();
        }
    }

    public final String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.I != null) {
            for (int i = 0; i < this.I.length; i++) {
                str = str + "\n    " + this.I[i].toString();
            }
        }
        return str;
    }
}
