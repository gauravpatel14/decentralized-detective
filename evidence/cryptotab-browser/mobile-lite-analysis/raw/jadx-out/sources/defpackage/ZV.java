package defpackage;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ZV extends WJ1 {
    public static TimeInterpolator s;
    public ArrayList h;
    public ArrayList i;
    public ArrayList j;
    public ArrayList k;
    public ArrayList l;
    public ArrayList m;
    public ArrayList n;
    public ArrayList o;
    public ArrayList p;
    public ArrayList q;
    public ArrayList r;

    public static void m(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((ps1) arrayList.get(size)).t.animate().cancel();
        }
    }

    @Override // defpackage.WJ1
    public final void a(ps1 ps1Var) {
        q(ps1Var);
        ps1Var.t.setAlpha(0.0f);
        this.i.add(ps1Var);
    }

    @Override // defpackage.WJ1
    public final boolean b(ps1 ps1Var, ps1 ps1Var2, int i, int i2, int i3, int i4) {
        if (ps1Var == ps1Var2) {
            return c(ps1Var, i, i2, i3, i4);
        }
        View view = ps1Var.t;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        float alpha = view.getAlpha();
        q(ps1Var);
        view.setTranslationX(translationX);
        view.setTranslationY(translationY);
        view.setAlpha(alpha);
        q(ps1Var2);
        float f = -((int) ((i3 - i) - translationX));
        View view2 = ps1Var2.t;
        view2.setTranslationX(f);
        view2.setTranslationY(-((int) ((i4 - i2) - translationY)));
        view2.setAlpha(0.0f);
        ArrayList arrayList = this.k;
        XV xv = new XV();
        xv.a = ps1Var;
        xv.b = ps1Var2;
        xv.c = i;
        xv.d = i2;
        xv.e = i3;
        xv.f = i4;
        arrayList.add(xv);
        return true;
    }

    @Override // defpackage.WJ1
    public final boolean c(ps1 ps1Var, int i, int i2, int i3, int i4) {
        View view = ps1Var.t;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i2 + ((int) ps1Var.t.getTranslationY());
        q(ps1Var);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            g(ps1Var);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        ArrayList arrayList = this.j;
        YV yv = new YV();
        yv.a = ps1Var;
        yv.b = translationX;
        yv.c = translationY;
        yv.d = i3;
        yv.e = i4;
        arrayList.add(yv);
        return true;
    }

    @Override // defpackage.WJ1
    public final boolean d(ps1 ps1Var) {
        q(ps1Var);
        this.h.add(ps1Var);
        return true;
    }

    @Override // defpackage.WJ1
    public final boolean f(ps1 ps1Var, List list) {
        return !list.isEmpty() || super.f(ps1Var, list);
    }

    @Override // defpackage.WJ1
    public final void i(ps1 ps1Var) {
        View view = ps1Var.t;
        view.animate().cancel();
        ArrayList arrayList = this.j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((YV) arrayList.get(size)).a == ps1Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                g(ps1Var);
                arrayList.remove(size);
            }
        }
        o(this.k, ps1Var);
        if (this.h.remove(ps1Var)) {
            view.setAlpha(1.0f);
            g(ps1Var);
        }
        if (this.i.remove(ps1Var)) {
            view.setAlpha(1.0f);
            g(ps1Var);
        }
        ArrayList arrayList2 = this.n;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList3 = (ArrayList) arrayList2.get(size2);
            o(arrayList3, ps1Var);
            if (arrayList3.isEmpty()) {
                arrayList2.remove(size2);
            }
        }
        ArrayList arrayList4 = this.m;
        for (int size3 = arrayList4.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList5 = (ArrayList) arrayList4.get(size3);
            int size4 = arrayList5.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (((YV) arrayList5.get(size4)).a == ps1Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    g(ps1Var);
                    arrayList5.remove(size4);
                    if (arrayList5.isEmpty()) {
                        arrayList4.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        ArrayList arrayList6 = this.l;
        for (int size5 = arrayList6.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList7 = (ArrayList) arrayList6.get(size5);
            if (arrayList7.remove(ps1Var)) {
                view.setAlpha(1.0f);
                g(ps1Var);
                if (arrayList7.isEmpty()) {
                    arrayList6.remove(size5);
                }
            }
        }
        this.q.remove(ps1Var);
        this.o.remove(ps1Var);
        this.r.remove(ps1Var);
        this.p.remove(ps1Var);
        n();
    }

    @Override // defpackage.WJ1
    public final void j() {
        ArrayList arrayList = this.j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            YV yv = (YV) arrayList.get(size);
            View view = yv.a.t;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            g(yv.a);
            arrayList.remove(size);
        }
        ArrayList arrayList2 = this.h;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            g((ps1) arrayList2.get(size2));
            arrayList2.remove(size2);
        }
        ArrayList arrayList3 = this.i;
        int size3 = arrayList3.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            ps1 ps1Var = (ps1) arrayList3.get(size3);
            ps1Var.t.setAlpha(1.0f);
            g(ps1Var);
            arrayList3.remove(size3);
        }
        ArrayList arrayList4 = this.k;
        for (int size4 = arrayList4.size() - 1; size4 >= 0; size4--) {
            XV xv = (XV) arrayList4.get(size4);
            ps1 ps1Var2 = xv.a;
            if (ps1Var2 != null) {
                p(xv, ps1Var2);
            }
            ps1 ps1Var3 = xv.b;
            if (ps1Var3 != null) {
                p(xv, ps1Var3);
            }
        }
        arrayList4.clear();
        if (k()) {
            ArrayList arrayList5 = this.m;
            for (int size5 = arrayList5.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList6 = (ArrayList) arrayList5.get(size5);
                for (int size6 = arrayList6.size() - 1; size6 >= 0; size6--) {
                    YV yv2 = (YV) arrayList6.get(size6);
                    View view2 = yv2.a.t;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    g(yv2.a);
                    arrayList6.remove(size6);
                    if (arrayList6.isEmpty()) {
                        arrayList5.remove(arrayList6);
                    }
                }
            }
            ArrayList arrayList7 = this.l;
            for (int size7 = arrayList7.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList8 = (ArrayList) arrayList7.get(size7);
                for (int size8 = arrayList8.size() - 1; size8 >= 0; size8--) {
                    ps1 ps1Var4 = (ps1) arrayList8.get(size8);
                    ps1Var4.t.setAlpha(1.0f);
                    g(ps1Var4);
                    arrayList8.remove(size8);
                    if (arrayList8.isEmpty()) {
                        arrayList7.remove(arrayList8);
                    }
                }
            }
            ArrayList arrayList9 = this.n;
            for (int size9 = arrayList9.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList10 = (ArrayList) arrayList9.get(size9);
                for (int size10 = arrayList10.size() - 1; size10 >= 0; size10--) {
                    XV xv2 = (XV) arrayList10.get(size10);
                    ps1 ps1Var5 = xv2.a;
                    if (ps1Var5 != null) {
                        p(xv2, ps1Var5);
                    }
                    ps1 ps1Var6 = xv2.b;
                    if (ps1Var6 != null) {
                        p(xv2, ps1Var6);
                    }
                    if (arrayList10.isEmpty()) {
                        arrayList9.remove(arrayList10);
                    }
                }
            }
            m(this.q);
            m(this.p);
            m(this.o);
            m(this.r);
            h();
        }
    }

    @Override // defpackage.WJ1
    public final boolean k() {
        return (this.i.isEmpty() && this.k.isEmpty() && this.j.isEmpty() && this.h.isEmpty() && this.p.isEmpty() && this.q.isEmpty() && this.o.isEmpty() && this.r.isEmpty() && this.m.isEmpty() && this.l.isEmpty() && this.n.isEmpty()) ? false : true;
    }

    @Override // defpackage.WJ1
    public final void l() {
        int i = 0;
        ArrayList<ps1> arrayList = this.h;
        boolean zIsEmpty = arrayList.isEmpty();
        ArrayList arrayList2 = this.j;
        boolean zIsEmpty2 = arrayList2.isEmpty();
        ArrayList arrayList3 = this.k;
        boolean zIsEmpty3 = arrayList3.isEmpty();
        ArrayList arrayList4 = this.i;
        boolean zIsEmpty4 = arrayList4.isEmpty();
        if (zIsEmpty && zIsEmpty2 && zIsEmpty4 && zIsEmpty3) {
            return;
        }
        for (ps1 ps1Var : arrayList) {
            View view = ps1Var.t;
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
            this.q.add(ps1Var);
            viewPropertyAnimatorAnimate.setDuration(this.d).alpha(0.0f).setListener(new UV(this, ps1Var, viewPropertyAnimatorAnimate, view)).start();
        }
        arrayList.clear();
        if (!zIsEmpty2) {
            ArrayList arrayList5 = new ArrayList();
            arrayList5.addAll(arrayList2);
            this.m.add(arrayList5);
            arrayList2.clear();
            TV tv = new TV(this, arrayList5, i);
            if (zIsEmpty) {
                tv.run();
            } else {
                View view2 = ((YV) arrayList5.get(0)).a.t;
                long j = this.d;
                WeakHashMap weakHashMap = AbstractC0604eo2.a;
                view2.postOnAnimationDelayed(tv, j);
            }
        }
        if (!zIsEmpty3) {
            ArrayList arrayList6 = new ArrayList();
            arrayList6.addAll(arrayList3);
            this.n.add(arrayList6);
            arrayList3.clear();
            TV tv2 = new TV(this, arrayList6, 1);
            if (zIsEmpty) {
                tv2.run();
            } else {
                View view3 = ((XV) arrayList6.get(0)).a.t;
                long j2 = this.d;
                WeakHashMap weakHashMap2 = AbstractC0604eo2.a;
                view3.postOnAnimationDelayed(tv2, j2);
            }
        }
        if (zIsEmpty4) {
            return;
        }
        ArrayList arrayList7 = new ArrayList();
        arrayList7.addAll(arrayList4);
        this.l.add(arrayList7);
        arrayList4.clear();
        TV tv3 = new TV(this, arrayList7, 2);
        if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
            tv3.run();
            return;
        }
        long jMax = Math.max(!zIsEmpty2 ? this.e : 0L, zIsEmpty3 ? 0L : this.f) + (!zIsEmpty ? this.d : 0L);
        View view4 = ((ps1) arrayList7.get(0)).t;
        WeakHashMap weakHashMap3 = AbstractC0604eo2.a;
        view4.postOnAnimationDelayed(tv3, jMax);
    }

    public final void n() {
        if (k()) {
            return;
        }
        h();
    }

    public final void o(ArrayList arrayList, ps1 ps1Var) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            XV xv = (XV) arrayList.get(size);
            if (p(xv, ps1Var) && xv.a == null && xv.b == null) {
                arrayList.remove(xv);
            }
        }
    }

    public final boolean p(XV xv, ps1 ps1Var) {
        if (xv.b == ps1Var) {
            xv.b = null;
        } else {
            if (xv.a != ps1Var) {
                return false;
            }
            xv.a = null;
        }
        ps1Var.t.setAlpha(1.0f);
        View view = ps1Var.t;
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        g(ps1Var);
        return true;
    }

    public final void q(ps1 ps1Var) {
        if (s == null) {
            s = new ValueAnimator().getInterpolator();
        }
        ps1Var.t.animate().setInterpolator(s);
        i(ps1Var);
    }
}
