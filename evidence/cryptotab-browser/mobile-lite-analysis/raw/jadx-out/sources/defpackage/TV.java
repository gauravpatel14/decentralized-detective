package defpackage;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TV implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ ArrayList u;
    public final /* synthetic */ ZV v;

    public /* synthetic */ TV(ZV zv, ArrayList arrayList, int i) {
        this.t = i;
        this.v = zv;
        this.u = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.t) {
            case 0:
                ArrayList arrayList = this.u;
                Iterator it = arrayList.iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    ZV zv = this.v;
                    if (!zHasNext) {
                        arrayList.clear();
                        zv.m.remove(arrayList);
                    } else {
                        YV yv = (YV) it.next();
                        ps1 ps1Var = yv.a;
                        zv.getClass();
                        View view = ps1Var.t;
                        int i = yv.d - yv.b;
                        int i2 = yv.e - yv.c;
                        if (i != 0) {
                            view.animate().translationX(0.0f);
                        }
                        if (i2 != 0) {
                            view.animate().translationY(0.0f);
                        }
                        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                        zv.p.add(ps1Var);
                        viewPropertyAnimatorAnimate.setDuration(zv.e).setListener(new VV(zv, ps1Var, i, view, i2, viewPropertyAnimatorAnimate)).start();
                    }
                    break;
                }
                break;
            case 1:
                ArrayList arrayList2 = this.u;
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    boolean zHasNext2 = it2.hasNext();
                    ZV zv2 = this.v;
                    if (!zHasNext2) {
                        arrayList2.clear();
                        zv2.n.remove(arrayList2);
                        break;
                    } else {
                        XV xv = (XV) it2.next();
                        zv2.getClass();
                        ps1 ps1Var2 = xv.a;
                        View view2 = ps1Var2 == null ? null : ps1Var2.t;
                        ps1 ps1Var3 = xv.b;
                        View view3 = ps1Var3 != null ? ps1Var3.t : null;
                        ArrayList arrayList3 = zv2.r;
                        if (view2 != null) {
                            ViewPropertyAnimator duration = view2.animate().setDuration(zv2.f);
                            arrayList3.add(xv.a);
                            duration.translationX(xv.e - xv.c);
                            duration.translationY(xv.f - xv.d);
                            duration.alpha(0.0f).setListener(new WV(zv2, xv, duration, view2, 0)).start();
                        }
                        if (view3 != null) {
                            ViewPropertyAnimator viewPropertyAnimatorAnimate2 = view3.animate();
                            arrayList3.add(xv.b);
                            viewPropertyAnimatorAnimate2.translationX(0.0f).translationY(0.0f).setDuration(zv2.f).alpha(1.0f).setListener(new WV(zv2, xv, viewPropertyAnimatorAnimate2, view3, 1)).start();
                        }
                    }
                }
                break;
            default:
                ArrayList arrayList4 = this.u;
                Iterator it3 = arrayList4.iterator();
                while (true) {
                    boolean zHasNext3 = it3.hasNext();
                    ZV zv3 = this.v;
                    if (!zHasNext3) {
                        arrayList4.clear();
                        zv3.l.remove(arrayList4);
                    } else {
                        ps1 ps1Var4 = (ps1) it3.next();
                        zv3.getClass();
                        View view4 = ps1Var4.t;
                        ViewPropertyAnimator viewPropertyAnimatorAnimate3 = view4.animate();
                        zv3.o.add(ps1Var4);
                        viewPropertyAnimatorAnimate3.alpha(1.0f).setDuration(zv3.c).setListener(new UV(zv3, ps1Var4, view4, viewPropertyAnimatorAnimate3)).start();
                    }
                    break;
                }
                break;
        }
    }
}
