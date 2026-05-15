package androidx.fragment.app;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import defpackage.AbstractC0118Ki0;
import defpackage.AbstractC0207Ri0;
import defpackage.AbstractC0604eo2;
import defpackage.AbstractC1555uM1;
import defpackage.Bx;
import defpackage.C0375am;
import defpackage.C1155nW;
import defpackage.Es1;
import defpackage.I81;
import defpackage.InterfaceC0798hk0;
import defpackage.PG;
import defpackage.RunnableC0196Qi0;
import defpackage.ViewTreeObserverOnPreDrawListenerC0447c51;
import defpackage.gf;
import defpackage.lW;
import defpackage.mW;
import defpackage.pW;
import defpackage.qW;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends AbstractC1555uM1 {
    public final ArrayList c;
    public final y d;
    public final y e;
    public final AbstractC0207Ri0 f;
    public final Object g;
    public final ArrayList h;
    public final ArrayList i;
    public final gf j;
    public final ArrayList k;
    public final ArrayList l;
    public final gf m;
    public final gf n;
    public final boolean o;
    public final Bx p = new Bx();
    public Object q;

    public f(ArrayList arrayList, y yVar, y yVar2, AbstractC0207Ri0 abstractC0207Ri0, Object obj, ArrayList arrayList2, ArrayList arrayList3, gf gfVar, ArrayList arrayList4, ArrayList arrayList5, gf gfVar2, gf gfVar3, boolean z) {
        this.c = arrayList;
        this.d = yVar;
        this.e = yVar2;
        this.f = abstractC0207Ri0;
        this.g = obj;
        this.h = arrayList2;
        this.i = arrayList3;
        this.j = gfVar;
        this.k = arrayList4;
        this.l = arrayList5;
        this.m = gfVar2;
        this.n = gfVar3;
        this.o = z;
    }

    public static void f(View view, ArrayList arrayList) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.isTransitionGroup()) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                f(childAt, arrayList);
            }
        }
    }

    @Override // defpackage.AbstractC1555uM1
    public final boolean a() {
        Object obj;
        Object obj2;
        AbstractC0207Ri0 abstractC0207Ri0 = this.f;
        if (abstractC0207Ri0.l()) {
            ArrayList<qW> arrayList = this.c;
            if (!arrayList.isEmpty()) {
                for (qW qWVar : arrayList) {
                    if (Build.VERSION.SDK_INT < 34 || (obj2 = qWVar.b) == null || !abstractC0207Ri0.m(obj2)) {
                        break;
                    }
                }
                obj = this.g;
                if (obj != null) {
                }
                return true;
            }
            obj = this.g;
            if (obj != null || abstractC0207Ri0.m(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.AbstractC1555uM1
    public final void b(ViewGroup viewGroup) {
        this.p.a();
    }

    @Override // defpackage.AbstractC1555uM1
    public final void c(ViewGroup viewGroup) {
        boolean zIsLaidOut = viewGroup.isLaidOut();
        ArrayList arrayList = this.c;
        if (!zIsLaidOut) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((qW) it.next()).a.c(this);
            }
            return;
        }
        Object obj = this.q;
        AbstractC0207Ri0 abstractC0207Ri0 = this.f;
        if (obj != null) {
            abstractC0207Ri0.c(obj);
            return;
        }
        I81 i81G = g(viewGroup, this.e, this.d);
        ArrayList arrayList2 = (ArrayList) i81G.t;
        ArrayList arrayList3 = new ArrayList(PG.d(arrayList));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((qW) it2.next()).a);
        }
        Iterator it3 = arrayList3.iterator();
        while (true) {
            boolean zHasNext = it3.hasNext();
            Object obj2 = i81G.u;
            if (!zHasNext) {
                i(arrayList2, viewGroup, new C1155nW(this, viewGroup, obj2));
                return;
            }
            y yVar = (y) it3.next();
            abstractC0207Ri0.u(yVar.c, obj2, this.p, new mW(yVar, this, 1));
        }
    }

    @Override // defpackage.AbstractC1555uM1
    public final void d(C0375am c0375am) {
        Object obj = this.q;
        if (obj != null) {
            this.f.r(obj, c0375am.c);
        }
    }

    @Override // defpackage.AbstractC1555uM1
    public final void e(ViewGroup viewGroup) {
        Object obj;
        boolean zIsLaidOut = viewGroup.isLaidOut();
        ArrayList arrayList = this.c;
        if (!zIsLaidOut) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                y yVar = ((qW) it.next()).a;
            }
            return;
        }
        boolean zH = h();
        y yVar2 = this.e;
        y yVar3 = this.d;
        if (zH && (obj = this.g) != null && !a()) {
            Log.i("FragmentManager", "Ignoring shared elements transition " + obj + " between " + yVar3 + " and " + yVar2 + " as neither fragment has set a Transition. In order to run a SharedElementTransition, you must also set either an enter or exit transition on a fragment involved in the transaction. The sharedElementTransition will run after the back gesture has been committed.");
        }
        if (!a() || !h()) {
            return;
        }
        Es1 es1 = new Es1();
        I81 i81G = g(viewGroup, yVar2, yVar3);
        ArrayList arrayList2 = (ArrayList) i81G.t;
        ArrayList arrayList3 = new ArrayList(PG.d(arrayList));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((qW) it2.next()).a);
        }
        Iterator it3 = arrayList3.iterator();
        while (true) {
            boolean zHasNext = it3.hasNext();
            Object obj2 = i81G.u;
            if (!zHasNext) {
                i(arrayList2, viewGroup, new pW(this, viewGroup, obj2, es1));
                return;
            }
            y yVar4 = (y) it3.next();
            lW lWVar = new lW(es1, 0);
            n nVar = yVar4.c;
            this.f.v(obj2, this.p, lWVar, new mW(yVar4, this, 0));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x017d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.I81 g(android.view.ViewGroup r27, androidx.fragment.app.y r28, androidx.fragment.app.y r29) {
        /*
            Method dump skipped, instruction units count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.f.g(android.view.ViewGroup, androidx.fragment.app.y, androidx.fragment.app.y):I81");
    }

    public final boolean h() {
        ArrayList arrayList = this.c;
        if (arrayList.isEmpty()) {
            return true;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((qW) it.next()).a.c.mTransitioning) {
                return false;
            }
        }
        return true;
    }

    public final void i(ArrayList arrayList, ViewGroup viewGroup, InterfaceC0798hk0 interfaceC0798hk0) {
        AbstractC0118Ki0.a(4, arrayList);
        AbstractC0207Ri0 abstractC0207Ri0 = this.f;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = this.i;
        int size = arrayList3.size();
        for (int i = 0; i < size; i++) {
            View view = (View) arrayList3.get(i);
            WeakHashMap weakHashMap = AbstractC0604eo2.a;
            arrayList2.add(view.getTransitionName());
            view.setTransitionName(null);
        }
        interfaceC0798hk0.c();
        int size2 = arrayList3.size();
        ArrayList arrayList4 = new ArrayList();
        int i2 = 0;
        while (true) {
            ArrayList arrayList5 = this.h;
            if (i2 >= size2) {
                ViewTreeObserverOnPreDrawListenerC0447c51.a(viewGroup, new RunnableC0196Qi0(size2, arrayList3, arrayList2, arrayList5, arrayList4));
                AbstractC0118Ki0.a(0, arrayList);
                abstractC0207Ri0.x(this.g, arrayList5, arrayList3);
                return;
            }
            View view2 = (View) arrayList5.get(i2);
            WeakHashMap weakHashMap2 = AbstractC0604eo2.a;
            String transitionName = view2.getTransitionName();
            arrayList4.add(transitionName);
            if (transitionName != null) {
                view2.setTransitionName(null);
                String str = (String) this.j.get(transitionName);
                int i3 = 0;
                while (true) {
                    if (i3 >= size2) {
                        break;
                    }
                    if (str.equals(arrayList2.get(i3))) {
                        ((View) arrayList3.get(i3)).setTransitionName(transitionName);
                        break;
                    }
                    i3++;
                }
            }
            i2++;
        }
    }
}
