package defpackage;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: jF0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class C0886jF0 extends AbstractC0514dF0 {
    public final boolean a;
    public C0855ib0 b;
    public cF0 c;
    public final WeakReference d;
    public int e;
    public boolean f;
    public boolean g;
    public final ArrayList h;
    public final lO1 i;

    public C0886jF0(InterfaceC0762hF0 interfaceC0762hF0) {
        new AtomicReference(null);
        this.a = true;
        this.b = new C0855ib0();
        cF0 cf0 = cF0.u;
        this.c = cf0;
        this.h = new ArrayList();
        this.d = new WeakReference(interfaceC0762hF0);
        this.i = new lO1(cf0);
    }

    @Override // defpackage.AbstractC0514dF0
    public void a(InterfaceC0692gF0 interfaceC0692gF0) {
        InterfaceC0564eF0 qs1;
        Object obj;
        InterfaceC0762hF0 interfaceC0762hF0;
        ArrayList arrayList = this.h;
        d("addObserver");
        cF0 cf0 = this.c;
        cF0 cf02 = cF0.t;
        if (cf0 != cf02) {
            cf02 = cF0.u;
        }
        C0825iF0 c0825iF0 = new C0825iF0();
        HashMap map = AbstractC0947kF0.a;
        boolean z = interfaceC0692gF0 instanceof InterfaceC0564eF0;
        boolean z2 = interfaceC0692gF0 instanceof InterfaceC0359aW;
        if (z && z2) {
            qs1 = new C0477cW((InterfaceC0359aW) interfaceC0692gF0, (InterfaceC0564eF0) interfaceC0692gF0);
        } else if (z2) {
            qs1 = new C0477cW((InterfaceC0359aW) interfaceC0692gF0, null);
        } else if (z) {
            qs1 = (InterfaceC0564eF0) interfaceC0692gF0;
        } else {
            Class<?> cls = interfaceC0692gF0.getClass();
            if (AbstractC0947kF0.c(cls) == 2) {
                List list = (List) AbstractC0947kF0.b.get(cls);
                if (list.size() == 1) {
                    AbstractC0947kF0.a((Constructor) list.get(0), interfaceC0692gF0);
                    throw null;
                }
                int size = list.size();
                InterfaceC1634vl0[] interfaceC1634vl0Arr = new InterfaceC1634vl0[size];
                if (size > 0) {
                    AbstractC0947kF0.a((Constructor) list.get(0), interfaceC0692gF0);
                    throw null;
                }
                qs1 = new vI(interfaceC1634vl0Arr);
            } else {
                qs1 = new Qs1(interfaceC0692gF0);
            }
        }
        c0825iF0.b = qs1;
        c0825iF0.a = cf02;
        C0855ib0 c0855ib0 = this.b;
        Rx1 rx1E = c0855ib0.e(interfaceC0692gF0);
        if (rx1E != null) {
            obj = rx1E.u;
        } else {
            HashMap map2 = c0855ib0.x;
            Rx1 rx1 = new Rx1(interfaceC0692gF0, c0825iF0);
            c0855ib0.w++;
            Rx1 rx12 = c0855ib0.u;
            if (rx12 == null) {
                c0855ib0.t = rx1;
                c0855ib0.u = rx1;
            } else {
                rx12.v = rx1;
                rx1.w = rx12;
                c0855ib0.u = rx1;
            }
            map2.put(interfaceC0692gF0, rx1);
            obj = null;
        }
        if (((C0825iF0) obj) == null && (interfaceC0762hF0 = (InterfaceC0762hF0) this.d.get()) != null) {
            boolean z3 = this.e != 0 || this.f;
            cF0 cf0C = c(interfaceC0692gF0);
            this.e++;
            while (c0825iF0.a.compareTo(cf0C) < 0 && this.b.x.containsKey(interfaceC0692gF0)) {
                arrayList.add(c0825iF0.a);
                ZE0 ze0 = bF0.Companion;
                cF0 cf03 = c0825iF0.a;
                ze0.getClass();
                int iOrdinal = cf03.ordinal();
                bF0 bf0 = iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? null : bF0.ON_RESUME : bF0.ON_START : bF0.ON_CREATE;
                if (bf0 == null) {
                    throw new IllegalStateException("no event up from " + c0825iF0.a);
                }
                c0825iF0.a(interfaceC0762hF0, bf0);
                arrayList.remove(arrayList.size() - 1);
                cf0C = c(interfaceC0692gF0);
            }
            if (!z3) {
                g();
            }
            this.e--;
        }
    }

    @Override // defpackage.AbstractC0514dF0
    public final void b(InterfaceC0692gF0 interfaceC0692gF0) {
        d("removeObserver");
        this.b.f(interfaceC0692gF0);
    }

    public final cF0 c(InterfaceC0692gF0 interfaceC0692gF0) {
        C0825iF0 c0825iF0;
        HashMap map = this.b.x;
        Rx1 rx1 = map.containsKey(interfaceC0692gF0) ? ((Rx1) map.get(interfaceC0692gF0)).w : null;
        cF0 cf0 = (rx1 == null || (c0825iF0 = (C0825iF0) rx1.u) == null) ? null : c0825iF0.a;
        ArrayList arrayList = this.h;
        cF0 cf02 = arrayList.isEmpty() ? null : (cF0) arrayList.get(arrayList.size() - 1);
        cF0 cf03 = this.c;
        if (cf0 == null || cf0.compareTo(cf03) >= 0) {
            cf0 = cf03;
        }
        return (cf02 == null || cf02.compareTo(cf0) >= 0) ? cf0 : cf02;
    }

    public final void d(String str) {
        if (this.a) {
            le.a().a.getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(BN0.a("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    public final void e(bF0 bf0) {
        d("handleLifecycleEvent");
        f(bf0.a());
    }

    public final void f(cF0 cf0) {
        cF0 cf02 = this.c;
        if (cf02 == cf0) {
            return;
        }
        cF0 cf03 = cF0.u;
        cF0 cf04 = cF0.t;
        if (cf02 == cf03 && cf0 == cf04) {
            throw new IllegalStateException(("State must be at least CREATED to move to " + cf0 + ", but was " + this.c + " in component " + this.d.get()).toString());
        }
        this.c = cf0;
        if (this.f || this.e != 0) {
            this.g = true;
            return;
        }
        this.f = true;
        g();
        this.f = false;
        if (this.c == cf04) {
            this.b = new C0855ib0();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
    
        r11.g = false;
        r11.i.a(r11.c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0031, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g() {
        /*
            Method dump skipped, instruction units count: 383
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0886jF0.g():void");
    }
}
