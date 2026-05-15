package defpackage;

import android.content.Context;
import android.media.MediaRoute2Info;
import android.media.MediaRouter2;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class bm0 {
    public CP0 A;
    public final Vl0 B;
    public C0838iP0 c;
    public XO0 d;
    public gP0 e;
    public final Context f;
    public final Ct1 l;
    public final Vl0 m;
    public final boolean n;
    public final boolean o;
    public final C0772hO0 p;
    public final Xg1 q;
    public final nP0 r;
    public C0838iP0 s;
    public C0838iP0 t;
    public C0838iP0 u;
    public UO0 v;
    public RO0 w;
    public RO0 x;
    public int y;
    public Zl0 z;
    public final Wl0 a = new Wl0(this);
    public final HashMap b = new HashMap();
    public final ArrayList g = new ArrayList();
    public final ArrayList h = new ArrayList();
    public final HashMap i = new HashMap();
    public final ArrayList j = new ArrayList();
    public final ArrayList k = new ArrayList();

    /* JADX WARN: Removed duplicated region for block: B:7:0x0086  */
    /* JADX WARN: Type inference failed for: r5v2, types: [Ul0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public bm0(android.content.Context r8) {
        /*
            Method dump skipped, instruction units count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bm0.<init>(android.content.Context):void");
    }

    public final void a(ZO0 zo0, boolean z) {
        if (d(zo0) == null) {
            hP0 hp0 = new hP0(zo0, z);
            this.j.add(hp0);
            this.a.b(513, hp0);
            k(hp0, zo0.z);
            C1087mP0.b();
            zo0.w = this.m;
            zo0.f(this.w);
        }
    }

    public final String b(hP0 hp0, String str) {
        String strFlattenToShortString = hp0.d.a.flattenToShortString();
        boolean z = hp0.c;
        String strB = z ? str : F.b(strFlattenToShortString, ":", str);
        HashMap map = this.i;
        if (!z) {
            ArrayList arrayList = this.h;
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                }
                if (((C0838iP0) arrayList.get(i)).c.equals(strB)) {
                    break;
                }
                i++;
            }
            if (i >= 0) {
                Log.w("AxMediaRouter", "Either " + str + " isn't unique in " + strFlattenToShortString + " or we're trying to assign a unique ID for an already added route");
                int i2 = 2;
                while (true) {
                    String str2 = strB + "_" + i2;
                    int size2 = arrayList.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size2) {
                            i3 = -1;
                            break;
                        }
                        if (((C0838iP0) arrayList.get(i3)).c.equals(str2)) {
                            break;
                        }
                        i3++;
                    }
                    if (i3 < 0) {
                        map.put(new K81(strFlattenToShortString, str), str2);
                        return str2;
                    }
                    i2++;
                }
            }
        }
        map.put(new K81(strFlattenToShortString, str), strB);
        return strB;
    }

    public final C0838iP0 c() {
        for (C0838iP0 c0838iP0 : this.h) {
            if (c0838iP0 != this.s && c0838iP0.a() == this.q && c0838iP0.k("android.media.intent.category.LIVE_AUDIO") && !c0838iP0.k("android.media.intent.category.LIVE_VIDEO") && c0838iP0.d()) {
                return c0838iP0;
            }
        }
        return this.s;
    }

    public final hP0 d(ZO0 zo0) {
        for (hP0 hp0 : this.j) {
            if (hp0.a == zo0) {
                return hp0;
            }
        }
        return null;
    }

    public final C0838iP0 e() {
        C0838iP0 c0838iP0 = this.c;
        if (c0838iP0 != null) {
            return c0838iP0;
        }
        throw new IllegalStateException("There is no currently selected route.  The media router has not yet been fully initialized.");
    }

    public final void f() {
        if (this.c.c()) {
            List<C0838iP0> listUnmodifiableList = Collections.unmodifiableList(this.c.v);
            HashSet hashSet = new HashSet();
            Iterator it = listUnmodifiableList.iterator();
            while (it.hasNext()) {
                hashSet.add(((C0838iP0) it.next()).c);
            }
            HashMap map = this.b;
            Iterator it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                if (!hashSet.contains(entry.getKey())) {
                    XO0 xo0 = (XO0) entry.getValue();
                    xo0.h(0);
                    xo0.d();
                    it2.remove();
                }
            }
            for (C0838iP0 c0838iP0 : listUnmodifiableList) {
                if (!map.containsKey(c0838iP0.c)) {
                    XO0 xo0C = c0838iP0.a().c(c0838iP0.b, this.c.b);
                    if (xo0C != null) {
                        xo0C.e();
                        map.put(c0838iP0.c, xo0C);
                    }
                }
            }
        }
    }

    public final void g(C0838iP0 c0838iP0, int i, boolean z) {
        if (!this.h.contains(c0838iP0)) {
            Log.w("AxMediaRouter", "Ignoring attempt to select removed route: " + c0838iP0);
            return;
        }
        if (!c0838iP0.g) {
            Log.w("AxMediaRouter", "Ignoring attempt to select disabled route: " + c0838iP0);
            return;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            ZO0 zo0A = c0838iP0.a();
            C0772hO0 c0772hO0 = this.p;
            if (zo0A == c0772hO0 && this.c != c0838iP0) {
                String str = c0838iP0.b;
                MediaRoute2Info mediaRoute2Info = null;
                if (str != null) {
                    Iterator it = c0772hO0.I.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MediaRoute2Info mediaRoute2InfoB = YN0.b(it.next());
                        if (TextUtils.equals(mediaRoute2InfoB.getId(), str)) {
                            mediaRoute2Info = mediaRoute2InfoB;
                            break;
                        }
                    }
                } else {
                    c0772hO0.getClass();
                }
                if (mediaRoute2Info != null) {
                    c0772hO0.B.transferTo(mediaRoute2Info);
                    return;
                }
                Log.w("MR2Provider", "transferTo: Specified route not found. routeId=" + str);
                return;
            }
        }
        h(c0838iP0, i, z);
    }

    public final void h(C0838iP0 c0838iP0, int i, boolean z) {
        C0351aP0 c0351aP0;
        String str;
        if (this.c == c0838iP0) {
            return;
        }
        boolean z2 = c0838iP0 == this.s;
        if (this.t != null && z2) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StringBuilder sb = new StringBuilder("- Stracktrace: [");
            int i2 = 3;
            while (i2 < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i2];
                sb.append(stackTraceElement.getClassName());
                sb.append(".");
                sb.append(stackTraceElement.getMethodName());
                sb.append(":");
                sb.append(stackTraceElement.getLineNumber());
                i2++;
                if (i2 < stackTrace.length) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            C0838iP0 c0838iP02 = this.c;
            if (c0838iP02 != null) {
                String str2 = c0838iP02.d;
                C1087mP0.b();
                str = str2 + "(BT=" + (C1087mP0.c().t == c0838iP02) + ")";
            } else {
                str = null;
            }
            Log.w("AxMediaRouter", "Changing selection(" + str + ") to default while BT is available: pkgName=" + this.f.getPackageName() + ((Object) sb));
        }
        if (this.u != null) {
            this.u = null;
            UO0 uo0 = this.v;
            if (uo0 != null) {
                uo0.h(3);
                this.v.d();
                this.v = null;
            }
        }
        if (this.o && (c0351aP0 = c0838iP0.a.e) != null && c0351aP0.b) {
            UO0 uo0A = c0838iP0.a().a(c0838iP0.b);
            if (uo0A != null) {
                Context context = this.f;
                Executor executorA = Build.VERSION.SDK_INT >= 28 ? LL.a(context) : new E80(new Handler(context.getMainLooper()));
                Vl0 vl0 = this.B;
                synchronized (uo0A.a) {
                    try {
                        if (executorA == null) {
                            throw new NullPointerException("Executor shouldn't be null");
                        }
                        if (vl0 == null) {
                            throw new NullPointerException("Listener shouldn't be null");
                        }
                        uo0A.b = executorA;
                        uo0A.c = vl0;
                        ArrayList arrayList = uo0A.e;
                        if (arrayList != null && !arrayList.isEmpty()) {
                            OO0 oo0 = uo0A.d;
                            ArrayList arrayList2 = uo0A.e;
                            uo0A.d = null;
                            uo0A.e = null;
                            uo0A.b.execute(new SO0(uo0A, vl0, oo0, arrayList2, 0));
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                this.u = c0838iP0;
                this.v = uo0A;
                uo0A.e();
                return;
            }
            Log.w("AxMediaRouter", "setSelectedRouteInternal: Failed to create dynamic group route controller. route=" + c0838iP0);
        }
        XO0 xo0B = c0838iP0.a().b(c0838iP0.b);
        if (xo0B != null) {
            xo0B.e();
        }
        if (this.c == null) {
            this.c = c0838iP0;
            this.d = xo0B;
            Wl0 wl0 = this.a;
            wl0.getClass();
            Message messageObtainMessage = wl0.obtainMessage(262, new am0(null, c0838iP0, z));
            messageObtainMessage.arg1 = i;
            messageObtainMessage.sendToTarget();
            return;
        }
        gP0 gp0 = this.e;
        if (gp0 != null) {
            if (!gp0.i && !gp0.j) {
                gp0.j = true;
                XO0 xo0 = gp0.a;
                if (xo0 != null) {
                    xo0.h(0);
                    xo0.d();
                }
            }
            this.e = null;
        }
        gP0 gp02 = new gP0(this, c0838iP0, xo0B, i, z, null, null);
        this.e = gp02;
        gp02.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x00de A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i() {
        /*
            Method dump skipped, instruction units count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bm0.i():void");
    }

    public final void j() {
        int i;
        MediaRouter2.RoutingController routingController;
        C0838iP0 c0838iP0 = this.c;
        if (c0838iP0 == null) {
            Zl0 zl0 = this.z;
            if (zl0 != null) {
                zl0.a();
                return;
            }
            return;
        }
        int i2 = c0838iP0.p;
        Ct1 ct1 = this.l;
        ct1.a = i2;
        ct1.b = c0838iP0.q;
        if (!c0838iP0.c()) {
            i = c0838iP0.o;
        } else if (C1087mP0.c == null) {
            i = 0;
        } else {
            C1087mP0.c().getClass();
            i = c0838iP0.o;
        }
        ct1.c = i;
        C0838iP0 c0838iP02 = this.c;
        ct1.d = c0838iP02.m;
        String id = null;
        if (this.o && c0838iP02.a() == this.p) {
            XO0 xo0 = this.d;
            if ((xo0 instanceof C0526dO0) && (routingController = ((C0526dO0) xo0).g) != null) {
                id = routingController.getId();
            }
            ct1.e = id;
        } else {
            ct1.e = null;
        }
        Iterator it = this.k.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        Zl0 zl02 = this.z;
        if (zl02 != null) {
            C0838iP0 c0838iP03 = this.c;
            C0838iP0 c0838iP04 = this.s;
            if (c0838iP04 == null) {
                throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
            }
            if (c0838iP03 == c0838iP04 || c0838iP03 == this.t) {
                zl02.a();
                return;
            }
            int i3 = ct1.c == 1 ? 2 : 0;
            int i4 = ct1.b;
            int i5 = ct1.a;
            String str = ct1.e;
            CP0 cp0 = zl02.a;
            if (cp0 != null) {
                Yl0 yl0 = zl02.b;
                if (yl0 != null && i3 == 0 && i4 == 0) {
                    yl0.d = i5;
                    yl0.a().setCurrentVolume(i5);
                    return;
                }
                Yl0 yl02 = new Yl0(zl02, i3, i4, i5, str);
                zl02.b = yl02;
                wP0 wp0 = cp0.a;
                wp0.getClass();
                wp0.a.setPlaybackToRemote(yl02.a());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012d A[LOOP:3: B:54:0x0127->B:56:0x012d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(defpackage.hP0 r19, defpackage.C0351aP0 r20) {
        /*
            Method dump skipped, instruction units count: 459
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bm0.k(hP0, aP0):void");
    }

    public final int l(C0838iP0 c0838iP0, OO0 oo0) {
        int iG = c0838iP0.g(oo0);
        if (iG != 0) {
            int i = iG & 1;
            Wl0 wl0 = this.a;
            if (i != 0) {
                wl0.b(259, c0838iP0);
            }
            if ((iG & 2) != 0) {
                wl0.b(260, c0838iP0);
            }
            if ((iG & 4) != 0) {
                wl0.b(261, c0838iP0);
            }
        }
        return iG;
    }

    public final void m(boolean z) {
        C0838iP0 c0838iP0 = this.s;
        if (c0838iP0 != null && !c0838iP0.d()) {
            Log.i("AxMediaRouter", "Clearing the default route because it is no longer selectable: " + this.s);
            this.s = null;
        }
        C0838iP0 c0838iP02 = this.s;
        ArrayList arrayList = this.h;
        if (c0838iP02 == null) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C0838iP0 c0838iP03 = (C0838iP0) it.next();
                if (c0838iP03.a() == this.q && c0838iP03.b.equals("DEFAULT_ROUTE") && c0838iP03.d()) {
                    this.s = c0838iP03;
                    Log.i("AxMediaRouter", "Found default route: " + this.s);
                    break;
                }
            }
        }
        C0838iP0 c0838iP04 = this.t;
        if (c0838iP04 != null && !c0838iP04.d()) {
            Log.i("AxMediaRouter", "Clearing the bluetooth route because it is no longer selectable: " + this.t);
            this.t = null;
        }
        if (this.t == null) {
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                C0838iP0 c0838iP05 = (C0838iP0) it2.next();
                if (c0838iP05.a() == this.q && c0838iP05.k("android.media.intent.category.LIVE_AUDIO") && !c0838iP05.k("android.media.intent.category.LIVE_VIDEO") && c0838iP05.d()) {
                    this.t = c0838iP05;
                    Log.i("AxMediaRouter", "Found bluetooth route: " + this.t);
                    break;
                }
            }
        }
        C0838iP0 c0838iP06 = this.c;
        if (c0838iP06 == null || !c0838iP06.g) {
            Log.i("AxMediaRouter", "Unselecting the current route because it is no longer selectable: " + this.c);
            h(c(), 0, true);
            return;
        }
        if (z) {
            f();
            j();
        }
    }
}
