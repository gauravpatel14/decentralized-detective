package defpackage;

import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.ArrayList;

/* JADX INFO: renamed from: en2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0603en2 extends AbstractC0669fn2 {
    public final Matrix a;
    public final ArrayList b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public final Matrix j;
    public String k;

    public C0603en2() {
        this.a = new Matrix();
        this.b = new ArrayList();
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 1.0f;
        this.g = 1.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = new Matrix();
        this.k = null;
    }

    @Override // defpackage.AbstractC0669fn2
    public final boolean a() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.b;
            if (i >= arrayList.size()) {
                return false;
            }
            if (((AbstractC0669fn2) arrayList.get(i)).a()) {
                return true;
            }
            i++;
        }
    }

    @Override // defpackage.AbstractC0669fn2
    public final boolean b(int[] iArr) {
        int i = 0;
        boolean zB = false;
        while (true) {
            ArrayList arrayList = this.b;
            if (i >= arrayList.size()) {
                return zB;
            }
            zB |= ((AbstractC0669fn2) arrayList.get(i)).b(iArr);
            i++;
        }
    }

    public final void c() {
        Matrix matrix = this.j;
        matrix.reset();
        matrix.postTranslate(-this.d, -this.e);
        matrix.postScale(this.f, this.g);
        matrix.postRotate(this.c, 0.0f, 0.0f);
        matrix.postTranslate(this.h + this.d, this.i + this.e);
    }

    public String getGroupName() {
        return this.k;
    }

    public Matrix getLocalMatrix() {
        return this.j;
    }

    public float getPivotX() {
        return this.d;
    }

    public float getPivotY() {
        return this.e;
    }

    public float getRotation() {
        return this.c;
    }

    public float getScaleX() {
        return this.f;
    }

    public float getScaleY() {
        return this.g;
    }

    public float getTranslateX() {
        return this.h;
    }

    public float getTranslateY() {
        return this.i;
    }

    public void setPivotX(float f) {
        if (f != this.d) {
            this.d = f;
            c();
        }
    }

    public void setPivotY(float f) {
        if (f != this.e) {
            this.e = f;
            c();
        }
    }

    public void setRotation(float f) {
        if (f != this.c) {
            this.c = f;
            c();
        }
    }

    public void setScaleX(float f) {
        if (f != this.f) {
            this.f = f;
            c();
        }
    }

    public void setScaleY(float f) {
        if (f != this.g) {
            this.g = f;
            c();
        }
    }

    public void setTranslateX(float f) {
        if (f != this.h) {
            this.h = f;
            c();
        }
    }

    public void setTranslateY(float f) {
        if (f != this.i) {
            this.i = f;
            c();
        }
    }

    public C0603en2(C0603en2 c0603en2, gf gfVar) {
        AbstractC0735gn2 c0500cn2;
        this.a = new Matrix();
        this.b = new ArrayList();
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 1.0f;
        this.g = 1.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        Matrix matrix = new Matrix();
        this.j = matrix;
        this.k = null;
        this.c = c0603en2.c;
        this.d = c0603en2.d;
        this.e = c0603en2.e;
        this.f = c0603en2.f;
        this.g = c0603en2.g;
        this.h = c0603en2.h;
        this.i = c0603en2.i;
        String str = c0603en2.k;
        this.k = str;
        if (str != null) {
            gfVar.put(str, this);
        }
        matrix.set(c0603en2.j);
        ArrayList arrayList = c0603en2.b;
        for (int i = 0; i < arrayList.size(); i++) {
            Object obj = arrayList.get(i);
            if (obj instanceof C0603en2) {
                this.b.add(new C0603en2((C0603en2) obj, gfVar));
            } else {
                if (obj instanceof C0547dn2) {
                    C0547dn2 c0547dn2 = (C0547dn2) obj;
                    C0547dn2 c0547dn22 = new C0547dn2(c0547dn2);
                    c0547dn22.e = 0.0f;
                    c0547dn22.g = 1.0f;
                    c0547dn22.h = 1.0f;
                    c0547dn22.i = 0.0f;
                    c0547dn22.j = 1.0f;
                    c0547dn22.k = 0.0f;
                    c0547dn22.l = Paint.Cap.BUTT;
                    c0547dn22.m = Paint.Join.MITER;
                    c0547dn22.n = 4.0f;
                    c0547dn22.d = c0547dn2.d;
                    c0547dn22.e = c0547dn2.e;
                    c0547dn22.g = c0547dn2.g;
                    c0547dn22.f = c0547dn2.f;
                    c0547dn22.c = c0547dn2.c;
                    c0547dn22.h = c0547dn2.h;
                    c0547dn22.i = c0547dn2.i;
                    c0547dn22.j = c0547dn2.j;
                    c0547dn22.k = c0547dn2.k;
                    c0547dn22.l = c0547dn2.l;
                    c0547dn22.m = c0547dn2.m;
                    c0547dn22.n = c0547dn2.n;
                    c0500cn2 = c0547dn22;
                } else if (obj instanceof C0500cn2) {
                    c0500cn2 = new C0500cn2((C0500cn2) obj);
                } else {
                    throw new IllegalStateException("Unknown object in the tree!");
                }
                this.b.add(c0500cn2);
                Object obj2 = c0500cn2.b;
                if (obj2 != null) {
                    gfVar.put(obj2, c0500cn2);
                }
            }
        }
    }
}
