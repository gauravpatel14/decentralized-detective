package defpackage;

import android.content.IntentFilter;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: renamed from: iP0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0838iP0 {
    public final hP0 a;
    public final String b;
    public final String c;
    public String d;
    public String e;
    public Uri f;
    public boolean g;
    public final boolean h;
    public int i;
    public boolean j;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public Bundle s;
    public IntentSender t;
    public OO0 u;
    public gf w;
    public final ArrayList k = new ArrayList();
    public int r = -1;
    public ArrayList v = new ArrayList();

    public C0838iP0(hP0 hp0, String str, String str2, boolean z) {
        this.a = hp0;
        this.b = str;
        this.c = str2;
        this.h = z;
    }

    public final ZO0 a() {
        hP0 hp0 = this.a;
        hp0.getClass();
        C1087mP0.b();
        return hp0.a;
    }

    public final boolean b() {
        C1087mP0.b();
        C0838iP0 c0838iP0 = C1087mP0.c().s;
        if (c0838iP0 == null) {
            throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
        }
        if (c0838iP0 == this || this.n == 3) {
            return true;
        }
        return TextUtils.equals(a().u.a.getPackageName(), "android") && k("android.media.intent.category.LIVE_AUDIO") && !k("android.media.intent.category.LIVE_VIDEO");
    }

    public final boolean c() {
        return Collections.unmodifiableList(this.v).size() >= 1;
    }

    public final boolean d() {
        return this.u != null && this.g;
    }

    public final boolean e() {
        C1087mP0.b();
        return C1087mP0.c().e() == this;
    }

    public final boolean f(C0468cP0 c0468cP0) {
        if (c0468cP0 == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        C1087mP0.b();
        ArrayList<IntentFilter> arrayList = this.k;
        if (arrayList == null) {
            return false;
        }
        c0468cP0.a();
        if (c0468cP0.b.isEmpty()) {
            return false;
        }
        for (IntentFilter intentFilter : arrayList) {
            if (intentFilter != null) {
                Iterator it = c0468cP0.b.iterator();
                while (it.hasNext()) {
                    if (intentFilter.hasCategory((String) it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0101 A[EDGE_INSN: B:128:0x0101->B:68:0x0101 BREAK  A[LOOP:0: B:35:0x0094->B:134:0x0094], EDGE_INSN: B:129:0x0101->B:68:0x0101 BREAK  A[LOOP:0: B:35:0x0094->B:134:0x0094], EDGE_INSN: B:130:0x0101->B:68:0x0101 BREAK  A[LOOP:0: B:35:0x0094->B:134:0x0094], EDGE_INSN: B:131:0x0101->B:68:0x0101 BREAK  A[LOOP:0: B:35:0x0094->B:134:0x0094, LOOP_LABEL: LOOP:0: B:35:0x0094->B:134:0x0094], EDGE_INSN: B:132:0x0101->B:68:0x0101 BREAK  A[LOOP:0: B:35:0x0094->B:134:0x0094], EDGE_INSN: B:133:0x0101->B:68:0x0101 BREAK  A[LOOP:0: B:35:0x0094->B:134:0x0094, LOOP_LABEL: LOOP:0: B:35:0x0094->B:134:0x0094]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int g(defpackage.OO0 r15) {
        /*
            Method dump skipped, instruction units count: 585
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0838iP0.g(OO0):int");
    }

    public final void h(int i) {
        XO0 xo0;
        XO0 xo02;
        C1087mP0.b();
        bm0 bm0VarC = C1087mP0.c();
        int iMin = Math.min(this.q, Math.max(0, i));
        if (this == bm0VarC.c && (xo02 = bm0VarC.d) != null) {
            xo02.f(iMin);
            return;
        }
        HashMap map = bm0VarC.b;
        if (map.isEmpty() || (xo0 = (XO0) map.get(this.c)) == null) {
            return;
        }
        xo0.f(iMin);
    }

    public final void i(int i) {
        XO0 xo0;
        XO0 xo02;
        C1087mP0.b();
        if (i != 0) {
            bm0 bm0VarC = C1087mP0.c();
            if (this == bm0VarC.c && (xo02 = bm0VarC.d) != null) {
                xo02.i(i);
                return;
            }
            HashMap map = bm0VarC.b;
            if (map.isEmpty() || (xo0 = (XO0) map.get(this.c)) == null) {
                return;
            }
            xo0.i(i);
        }
    }

    public final void j(boolean z) {
        C1087mP0.b();
        C1087mP0.c().g(this, 3, z);
    }

    public final boolean k(String str) {
        C1087mP0.b();
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            if (((IntentFilter) it.next()).hasCategory(str)) {
                return true;
            }
        }
        return false;
    }

    public final void l(ArrayList arrayList) {
        C0838iP0 c0838iP0;
        this.v.clear();
        if (this.w == null) {
            this.w = new gf(0);
        }
        this.w.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            TO0 to0 = (TO0) it.next();
            String strD = to0.a.d();
            Iterator it2 = this.a.b.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    c0838iP0 = null;
                    break;
                } else {
                    c0838iP0 = (C0838iP0) it2.next();
                    if (c0838iP0.b.equals(strD)) {
                        break;
                    }
                }
            }
            if (c0838iP0 != null) {
                this.w.put(c0838iP0.c, to0);
                int i = to0.b;
                if (i == 2 || i == 3) {
                    this.v.add(c0838iP0);
                }
            }
        }
        C1087mP0.c().a.b(259, this);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MediaRouter.RouteInfo{ uniqueId=");
        sb.append(this.c);
        sb.append(", name=");
        sb.append(this.d);
        sb.append(", description=");
        sb.append(this.e);
        sb.append(", iconUri=");
        sb.append(this.f);
        sb.append(", enabled=");
        sb.append(this.g);
        sb.append(", isSystemRoute=");
        sb.append(this.h);
        sb.append(", connectionState=");
        sb.append(this.i);
        sb.append(", canDisconnect=");
        sb.append(this.j);
        sb.append(", playbackType=");
        sb.append(this.l);
        sb.append(", playbackStream=");
        sb.append(this.m);
        sb.append(", deviceType=");
        sb.append(this.n);
        sb.append(", volumeHandling=");
        sb.append(this.o);
        sb.append(", volume=");
        sb.append(this.p);
        sb.append(", volumeMax=");
        sb.append(this.q);
        sb.append(", presentationDisplayId=");
        sb.append(this.r);
        sb.append(", extras=");
        sb.append(this.s);
        sb.append(", settingsIntent=");
        sb.append(this.t);
        sb.append(", providerPackageName=");
        sb.append(this.a.d.a.getPackageName());
        if (c()) {
            sb.append(", members=[");
            int size = this.v.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                if (this.v.get(i) != this) {
                    sb.append(((C0838iP0) this.v.get(i)).c);
                }
            }
            sb.append(']');
        }
        sb.append(" }");
        return sb.toString();
    }
}
