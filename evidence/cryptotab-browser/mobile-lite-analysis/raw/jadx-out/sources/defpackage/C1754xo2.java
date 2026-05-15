package defpackage;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: xo2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1754xo2 extends Yv1 implements xk0, Hk0 {
    public final int u;
    public int v;
    public /* synthetic */ Object w;
    public final /* synthetic */ View x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1754xo2(View view, InterfaceC1670wN interfaceC1670wN) {
        super(interfaceC1670wN);
        this.x = view;
        this.u = 2;
    }

    @Override // defpackage.AbstractC1864zn
    public final InterfaceC1670wN a(Object obj, InterfaceC1670wN interfaceC1670wN) {
        C1754xo2 c1754xo2 = new C1754xo2(this.x, interfaceC1670wN);
        c1754xo2.w = obj;
        return c1754xo2;
    }

    @Override // defpackage.Hk0
    public final int f() {
        return this.u;
    }

    @Override // defpackage.xk0
    public final Object i(Object obj, Object obj2) {
        return ((C1754xo2) a((EE1) obj, (InterfaceC1670wN) obj2)).l(C0302Yj2.a);
    }

    @Override // defpackage.AbstractC1864zn
    public final Object l(Object obj) throws Throwable {
        Object obj2;
        pO pOVar = pO.t;
        int i = this.v;
        View view = this.x;
        if (i == 0) {
            bw1.a(obj);
            EE1 ee1 = (EE1) this.w;
            this.w = ee1;
            this.v = 1;
            ee1.u = view;
            ee1.t = 3;
            ee1.w = this;
            return pOVar;
        }
        C0302Yj2 c0302Yj2 = C0302Yj2.a;
        if (i == 1) {
            EE1 ee12 = (EE1) this.w;
            bw1.a(obj);
            if (view instanceof ViewGroup) {
                this.w = null;
                this.v = 2;
                ee12.getClass();
                C0315Zg2 c0315Zg2 = new C0315Zg2(new C1235oo2((ViewGroup) view));
                if (c0315Zg2.u.hasNext()) {
                    ee12.v = c0315Zg2;
                    ee12.t = 2;
                    ee12.w = this;
                    obj2 = pOVar;
                } else {
                    obj2 = c0302Yj2;
                }
                if (obj2 != pOVar) {
                    obj2 = c0302Yj2;
                }
                if (obj2 == pOVar) {
                    return pOVar;
                }
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            bw1.a(obj);
        }
        return c0302Yj2;
    }

    @Override // defpackage.AbstractC1864zn
    public final String toString() {
        if (this.t != null) {
            return super.toString();
        }
        Gs1.a.getClass();
        return Ls1.a(this);
    }
}
