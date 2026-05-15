package defpackage;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Wl0 extends Handler {
    public final ArrayList a = new ArrayList();
    public final ArrayList b = new ArrayList();
    public final /* synthetic */ bm0 c;

    public Wl0(bm0 bm0Var) {
        this.c = bm0Var;
    }

    public static void a(eP0 ep0, int i, Object obj, int i2) {
        C1087mP0 c1087mP0 = ep0.a;
        int i3 = 65280 & i;
        dP0 dp0 = ep0.b;
        if (i3 != 256) {
            if (i3 != 512) {
                if (i3 == 768 && i == 769) {
                    if (obj != null) {
                        throw new ClassCastException();
                    }
                    dp0.k();
                    return;
                }
                return;
            }
            switch (i) {
                case 513:
                    dp0.a();
                    return;
                case 514:
                    dp0.c();
                    return;
                case 515:
                    dp0.b();
                    return;
                default:
                    return;
            }
        }
        am0 am0Var = (i == 264 || i == 262) ? (am0) obj : null;
        C0838iP0 c0838iP0 = am0Var != null ? am0Var.a : (C0838iP0) obj;
        if (c0838iP0 != null) {
            if ((ep0.d & 2) == 0 && !c0838iP0.f(ep0.c)) {
                C1087mP0.c().getClass();
                return;
            }
            switch (i) {
                case 257:
                    dp0.d(c0838iP0);
                    return;
                case 258:
                    dp0.f(c0838iP0);
                    return;
                case 259:
                    dp0.e(c1087mP0, c0838iP0);
                    return;
                case 260:
                    dp0.j(c0838iP0);
                    return;
                case 261:
                    dp0.getClass();
                    return;
                case 262:
                    dp0.g(c0838iP0);
                    return;
                case 263:
                    dp0.i(c1087mP0, c0838iP0, i2);
                    return;
                case 264:
                    dp0.g(c0838iP0);
                    return;
                default:
                    return;
            }
        }
    }

    public final void b(int i, Object obj) {
        obtainMessage(i, obj).sendToTarget();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int iJ;
        ArrayList arrayList = this.a;
        int i = message.what;
        Object obj = message.obj;
        int i2 = message.arg1;
        bm0 bm0Var = this.c;
        if (i == 259 && bm0Var.e().c.equals(((C0838iP0) obj).c)) {
            bm0Var.m(true);
        }
        ArrayList arrayList2 = this.b;
        if (i == 262) {
            am0 am0Var = (am0) obj;
            C0838iP0 c0838iP0 = am0Var.a;
            if (am0Var.b) {
                bm0Var.q.p(c0838iP0);
            }
            if (bm0Var.s != null && c0838iP0.b()) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    bm0Var.q.o((C0838iP0) it.next());
                }
                arrayList2.clear();
            }
        } else if (i != 264) {
            switch (i) {
                case 257:
                    bm0Var.q.n((C0838iP0) obj);
                    break;
                case 258:
                    bm0Var.q.o((C0838iP0) obj);
                    break;
                case 259:
                    Xg1 xg1 = bm0Var.q;
                    C0838iP0 c0838iP02 = (C0838iP0) obj;
                    xg1.getClass();
                    if (c0838iP02.a() != xg1 && (iJ = xg1.j(c0838iP02)) >= 0) {
                        Xg1.s((C0370ah1) xg1.K.get(iJ));
                    }
                    break;
            }
        } else {
            am0 am0Var2 = (am0) obj;
            C0838iP0 c0838iP03 = am0Var2.a;
            arrayList2.add(c0838iP03);
            bm0Var.q.n(c0838iP03);
            if (am0Var2.b) {
                bm0Var.q.p(c0838iP03);
            }
        }
        try {
            int size = bm0Var.g.size();
            while (true) {
                size--;
                if (size < 0) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        a((eP0) it2.next(), i, obj, i2);
                    }
                    arrayList.clear();
                    return;
                }
                ArrayList arrayList3 = bm0Var.g;
                C1087mP0 c1087mP0 = (C1087mP0) ((WeakReference) arrayList3.get(size)).get();
                if (c1087mP0 == null) {
                    arrayList3.remove(size);
                } else {
                    arrayList.addAll(c1087mP0.b);
                }
            }
        } catch (Throwable th) {
            arrayList.clear();
            throw th;
        }
    }
}
