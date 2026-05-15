package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.g;
import androidx.fragment.app.y;
import defpackage.AbstractC0132Lp1;
import defpackage.AbstractC0604eo2;
import defpackage.AbstractC1214oR1;
import defpackage.AbstractC1555uM1;
import defpackage.AbstractC1609vM1;
import defpackage.MG;
import defpackage.TG;
import defpackage.bf;
import defpackage.gf;
import defpackage.lz0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public final ViewGroup a;
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();
    public boolean d;
    public boolean e;
    public boolean f;

    public g(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    public static void f(gf gfVar, View view) {
        WeakHashMap weakHashMap = AbstractC0604eo2.a;
        String transitionName = view.getTransitionName();
        if (transitionName != null) {
            gfVar.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    f(gfVar, childAt);
                }
            }
        }
    }

    public static final g j(ViewGroup viewGroup, s sVar) {
        sVar.H();
        Object tag = viewGroup.getTag(AbstractC0132Lp1.special_effects_controller_view_tag);
        if (tag instanceof g) {
            return (g) tag;
        }
        g gVar = new g(viewGroup);
        viewGroup.setTag(AbstractC0132Lp1.special_effects_controller_view_tag, gVar);
        return gVar;
    }

    public static boolean k(ArrayList arrayList) {
        boolean z;
        Iterator it = arrayList.iterator();
        loop0: while (true) {
            z = true;
            while (it.hasNext()) {
                y yVar = (y) it.next();
                if (!yVar.k.isEmpty()) {
                    ArrayList arrayList2 = yVar.k;
                    if (arrayList2 == null || !arrayList2.isEmpty()) {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            if (!((AbstractC1555uM1) it2.next()).a()) {
                                break;
                            }
                        }
                    }
                }
                z = false;
            }
            break loop0;
        }
        if (z) {
            ArrayList arrayList3 = new ArrayList();
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                TG.e(arrayList3, ((y) it3.next()).k);
            }
            if (!arrayList3.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static void n(gf gfVar, Collection collection) {
        Iterator it = ((bf) gfVar.entrySet()).iterator();
        while (it.hasNext()) {
            View view = (View) ((Map.Entry) it.next()).getValue();
            WeakHashMap weakHashMap = AbstractC0604eo2.a;
            if (!MG.f(collection, view.getTransitionName())) {
                it.remove();
            }
        }
    }

    public final void a(y yVar) {
        if (yVar.i) {
            AbstractC1609vM1.a(yVar.a, yVar.c.requireView(), this.a);
            yVar.i = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x0365 A[LOOP:15: B:134:0x035f->B:136:0x0365, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.util.ArrayList r24, boolean r25) {
        /*
            Method dump skipped, instruction units count: 1046
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.g.b(java.util.ArrayList, boolean):void");
    }

    public final void c(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            TG.e(arrayList2, ((y) it.next()).k);
        }
        List listK = MG.k(MG.m(arrayList2));
        int size = listK.size();
        for (int i = 0; i < size; i++) {
            ((AbstractC1555uM1) listK.get(i)).c(this.a);
        }
        int size2 = arrayList.size();
        for (int i2 = 0; i2 < size2; i2++) {
            a((y) arrayList.get(i2));
        }
        List listK2 = MG.k(arrayList);
        int size3 = listK2.size();
        for (int i3 = 0; i3 < size3; i3++) {
            y yVar = (y) listK2.get(i3);
            if (yVar.k.isEmpty()) {
                yVar.b();
            }
        }
    }

    public final void d(int i, int i2, u uVar) {
        synchronized (this.b) {
            try {
                y yVarG = g(uVar.c);
                if (yVarG == null) {
                    n nVar = uVar.c;
                    yVarG = nVar.mTransitioning ? h(nVar) : null;
                }
                if (yVarG != null) {
                    yVarG.d(i, i2);
                    return;
                }
                final y yVar = new y(i, i2, uVar);
                this.b.add(yVar);
                yVar.d.add(new Runnable() { // from class: androidx.fragment.app.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        g gVar = this.t;
                        ArrayList arrayList = gVar.b;
                        y yVar2 = yVar;
                        if (arrayList.contains(yVar2)) {
                            AbstractC1609vM1.a(yVar2.a, yVar2.c.mView, gVar.a);
                        }
                    }
                });
                yVar.d.add(new Runnable() { // from class: tM1
                    @Override // java.lang.Runnable
                    public final void run() {
                        g gVar = this.t;
                        ArrayList arrayList = gVar.b;
                        y yVar2 = yVar;
                        arrayList.remove(yVar2);
                        gVar.c.remove(yVar2);
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        boolean z;
        if (this.f) {
            return;
        }
        if (!this.a.isAttachedToWindow()) {
            i();
            this.e = false;
            return;
        }
        synchronized (this.b) {
            try {
                ArrayList arrayList = new ArrayList(this.c);
                this.c.clear();
                Iterator it = arrayList.iterator();
                while (true) {
                    z = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    y yVar = (y) it.next();
                    if (this.d) {
                        yVar.b();
                    } else {
                        ViewGroup viewGroup = this.a;
                        boolean z2 = !this.b.isEmpty() && yVar.c.mTransitioning;
                        if (!yVar.e) {
                            if (z2) {
                                yVar.g = true;
                            }
                            yVar.a(viewGroup);
                        }
                    }
                    this.d = false;
                    if (!yVar.f) {
                        this.c.add(yVar);
                    }
                }
                if (!this.b.isEmpty()) {
                    o();
                    ArrayList arrayList2 = new ArrayList(this.b);
                    if (arrayList2.isEmpty()) {
                        return;
                    }
                    this.b.clear();
                    this.c.addAll(arrayList2);
                    b(arrayList2, this.e);
                    boolean zK = k(arrayList2);
                    Iterator it2 = arrayList2.iterator();
                    boolean z3 = true;
                    while (it2.hasNext()) {
                        if (!((y) it2.next()).c.mTransitioning) {
                            z3 = false;
                        }
                    }
                    if (!z3 || zK) {
                        z = false;
                    }
                    this.d = z;
                    if (!z3) {
                        m(arrayList2);
                        c(arrayList2);
                    } else if (zK) {
                        m(arrayList2);
                        int size = arrayList2.size();
                        for (int i = 0; i < size; i++) {
                            a((y) arrayList2.get(i));
                        }
                    }
                    this.e = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final y g(n nVar) {
        Object next;
        Iterator it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            y yVar = (y) next;
            if (lz0.a(yVar.c, nVar) && !yVar.e) {
                break;
            }
        }
        return (y) next;
    }

    public final y h(n nVar) {
        Object next;
        Iterator it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            y yVar = (y) next;
            if (lz0.a(yVar.c, nVar) && !yVar.e) {
                break;
            }
        }
        return (y) next;
    }

    public final void i() {
        this.a.isAttachedToWindow();
        synchronized (this.b) {
            try {
                o();
                m(this.b);
                Iterator it = new ArrayList(this.c).iterator();
                while (it.hasNext()) {
                    ((y) it.next()).a(this.a);
                }
                Iterator it2 = new ArrayList(this.b).iterator();
                while (it2.hasNext()) {
                    ((y) it2.next()).a(this.a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void l() {
        Object objPrevious;
        synchronized (this.b) {
            try {
                o();
                ArrayList arrayList = this.b;
                ListIterator listIterator = arrayList.listIterator(arrayList.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        objPrevious = null;
                        break;
                    }
                    objPrevious = listIterator.previous();
                    y yVar = (y) objPrevious;
                    View view = yVar.c.mView;
                    char c = 4;
                    if (view.getAlpha() != 0.0f || view.getVisibility() != 0) {
                        int visibility = view.getVisibility();
                        if (visibility == 0) {
                            c = 2;
                        } else if (visibility != 4) {
                            if (visibility != 8) {
                                throw new IllegalArgumentException("Unknown visibility " + visibility);
                            }
                            c = 3;
                        }
                    }
                    if (yVar.a == 2 && c != 2) {
                        break;
                    }
                }
                y yVar2 = (y) objPrevious;
                n nVar = yVar2 != null ? yVar2.c : null;
                this.f = nVar != null ? nVar.isPostponed() : false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            y yVar = (y) arrayList.get(i);
            if (!yVar.h) {
                yVar.h = true;
                int i2 = yVar.b;
                u uVar = yVar.l;
                if (i2 == 2) {
                    n nVar = uVar.c;
                    View viewFindFocus = nVar.mView.findFocus();
                    if (viewFindFocus != null) {
                        nVar.setFocusedView(viewFindFocus);
                    }
                    View viewRequireView = yVar.c.requireView();
                    if (viewRequireView.getParent() == null) {
                        uVar.a();
                        viewRequireView.setAlpha(0.0f);
                    }
                    if (viewRequireView.getAlpha() == 0.0f && viewRequireView.getVisibility() == 0) {
                        viewRequireView.setVisibility(4);
                    }
                    viewRequireView.setAlpha(nVar.getPostOnViewCreatedAlpha());
                } else if (i2 == 3) {
                    uVar.c.requireView().clearFocus();
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            TG.e(arrayList2, ((y) it.next()).k);
        }
        List listK = MG.k(MG.m(arrayList2));
        int size2 = listK.size();
        for (int i3 = 0; i3 < size2; i3++) {
            AbstractC1555uM1 abstractC1555uM1 = (AbstractC1555uM1) listK.get(i3);
            if (!abstractC1555uM1.a) {
                abstractC1555uM1.e(this.a);
            }
            abstractC1555uM1.a = true;
        }
    }

    public final void o() {
        for (y yVar : this.b) {
            int i = 2;
            if (yVar.b == 2) {
                int visibility = yVar.c.requireView().getVisibility();
                if (visibility != 0) {
                    i = 4;
                    if (visibility != 4) {
                        if (visibility != 8) {
                            throw new IllegalArgumentException(AbstractC1214oR1.a(visibility, "Unknown visibility "));
                        }
                        i = 3;
                    }
                }
                yVar.d(i, 1);
            }
        }
    }
}
