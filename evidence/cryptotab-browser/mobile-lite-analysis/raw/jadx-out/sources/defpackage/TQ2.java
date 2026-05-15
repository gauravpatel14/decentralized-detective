package defpackage;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzkm;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TQ2 extends AbstractC0906jX2 implements InterfaceC0393bD2 {
    public final gf d;
    public final gf e;
    public final gf f;
    public final gf g;
    public final gf h;
    public final gf i;
    public final uQ2 j;
    public final C1785yQ2 k;
    public final gf l;
    public final gf m;
    public final gf n;

    public TQ2(QX2 qx2) {
        super(qx2);
        this.d = new gf(0);
        this.e = new gf(0);
        this.f = new gf(0);
        this.g = new gf(0);
        this.h = new gf(0);
        this.l = new gf(0);
        this.m = new gf(0);
        this.n = new gf(0);
        this.i = new gf(0);
        this.j = new uQ2(this);
        this.k = new C1785yQ2(this);
    }

    public static final gf o(gP2 gp2) {
        gf gfVar = new gf(0);
        for (C1505tP2 c1505tP2 : gp2.w()) {
            gfVar.put(c1505tP2.l(), c1505tP2.m());
        }
        return gfVar;
    }

    public final boolean A(String str) throws Throwable {
        g();
        m(str);
        gf gfVar = this.e;
        return gfVar.get(str) != null && ((Set) gfVar.get(str)).contains("google_signals");
    }

    public final boolean B(String str) throws Throwable {
        g();
        m(str);
        gf gfVar = this.e;
        if (gfVar.get(str) != null) {
            return ((Set) gfVar.get(str)).contains("os_version") || ((Set) gfVar.get(str)).contains("device_info");
        }
        return false;
    }

    public final boolean C(String str) throws Throwable {
        g();
        m(str);
        gf gfVar = this.e;
        return gfVar.get(str) != null && ((Set) gfVar.get(str)).contains("user_id");
    }

    @Override // defpackage.InterfaceC0393bD2
    public final String a(String str, String str2) throws Throwable {
        g();
        m(str);
        Map map = (Map) this.d.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    public final gP2 k(String str, byte[] bArr) {
        C1391rR2 c1391rR2 = this.a;
        if (bArr == null) {
            return gP2.q();
        }
        try {
            gP2 gp2 = (gP2) ((C0528dP2) VX2.s(gP2.p(), bArr)).d();
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.n.c(gp2.B() ? Long.valueOf(gp2.n()) : null, gp2.A() ? gp2.r() : null, "Parsed config. version, gmp_app_id");
            return gp2;
        } catch (zzkm e) {
            WO2 wo22 = c1391rR2.i;
            C1391rR2.k(wo22);
            wo22.i.c(WO2.n(str), e, "Unable to merge remote config. appId");
            return gP2.q();
        } catch (RuntimeException e2) {
            WO2 wo23 = c1391rR2.i;
            C1391rR2.k(wo23);
            wo23.i.c(WO2.n(str), e2, "Unable to merge remote config. appId");
            return gP2.q();
        }
    }

    public final void l(String str, C0528dP2 c0528dP2) {
        HashSet hashSet = new HashSet();
        gf gfVar = new gf(0);
        gf gfVar2 = new gf(0);
        gf gfVar3 = new gf(0);
        P03.b();
        C1391rR2 c1391rR2 = this.a;
        if (c1391rR2.g.p(null, AbstractC0579eO2.v0)) {
            Iterator it = Collections.unmodifiableList(((gP2) c0528dP2.u).u()).iterator();
            while (it.hasNext()) {
                hashSet.add(((VO2) it.next()).l());
            }
        }
        for (int i = 0; i < ((gP2) c0528dP2.u).m(); i++) {
            YO2 yo2 = (YO2) ((gP2) c0528dP2.u).o(i).e();
            boolean zIsEmpty = yo2.g().isEmpty();
            WO2 wo2 = c1391rR2.i;
            if (zIsEmpty) {
                C1391rR2.k(wo2);
                wo2.i.a("EventConfig contained null event name");
            } else {
                String strG = yo2.g();
                String strA = RU2.a(yo2.g(), AbstractC0355aT2.a, AbstractC0355aT2.c);
                if (!TextUtils.isEmpty(strA)) {
                    if (yo2.v) {
                        yo2.f();
                        yo2.v = false;
                    }
                    C0469cP2.n((C0469cP2) yo2.u, strA);
                    if (c0528dP2.v) {
                        c0528dP2.f();
                        c0528dP2.v = false;
                    }
                    gP2.x((gP2) c0528dP2.u, i, (C0469cP2) yo2.d());
                }
                if (((C0469cP2) yo2.u).q() && ((C0469cP2) yo2.u).o()) {
                    gfVar.put(strG, Boolean.TRUE);
                }
                if (((C0469cP2) yo2.u).r() && ((C0469cP2) yo2.u).p()) {
                    gfVar2.put(yo2.g(), Boolean.TRUE);
                }
                if (((C0469cP2) yo2.u).s()) {
                    if (((C0469cP2) yo2.u).l() < 2 || ((C0469cP2) yo2.u).l() > 65535) {
                        C1391rR2.k(wo2);
                        wo2.i.c(yo2.g(), Integer.valueOf(((C0469cP2) yo2.u).l()), "Invalid sampling rate. Event name, sample rate");
                    } else {
                        gfVar3.put(yo2.g(), Integer.valueOf(((C0469cP2) yo2.u).l()));
                    }
                }
            }
        }
        this.e.put(str, hashSet);
        this.f.put(str, gfVar);
        this.g.put(str, gfVar2);
        this.i.put(str, gfVar3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011e  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m(java.lang.String r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.TQ2.m(java.lang.String):void");
    }

    public final void n(final String str, gP2 gp2) {
        int iL = gp2.l();
        uQ2 uq2 = this.j;
        if (iL == 0) {
            uq2.d(str);
            return;
        }
        C1391rR2 c1391rR2 = this.a;
        WO2 wo2 = c1391rR2.i;
        WO2 wo22 = c1391rR2.i;
        C1391rR2.k(wo2);
        wo2.n.b(Integer.valueOf(gp2.l()), "EES programs found");
        OR2 or2 = (OR2) gp2.v().get(0);
        try {
            XH2 xh2 = new XH2();
            SO2 so2 = xh2.a;
            so2.d.a.put("internal.remoteConfig", new Callable() { // from class: lQ2
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    PQ2 pq2 = new PQ2(this.a, str);
                    C0719gZ2 c0719gZ2 = new C0719gZ2("internal.remoteConfig");
                    c0719gZ2.u.put("getValue", new C1855zY2(pq2));
                    return c0719gZ2;
                }
            });
            so2.d.a.put("internal.appMetadata", new Callable() { // from class: oQ2
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new I23(new CallableC0839iQ2(this.a, str));
                }
            });
            so2.d.a.put("internal.logger", new Callable() { // from class: rQ2
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new C1593v23(this.a.k);
                }
            });
            xh2.a(or2);
            uq2.c(str, xh2);
            C1391rR2.k(wo22);
            wo22.n.c(str, Integer.valueOf(or2.l().l()), "EES program loaded for appId, activities");
            for (JR2 jr2 : or2.l().n()) {
                C1391rR2.k(wo22);
                wo22.n.b(jr2.l(), "EES program activity");
            }
        } catch (zzd unused) {
            C1391rR2.k(wo22);
            wo22.f.b(str, "Failed to load EES program. appId");
        }
    }

    public final int p(String str, String str2) throws Throwable {
        Integer num;
        g();
        m(str);
        Map map = (Map) this.i.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    public final gP2 q(String str) {
        h();
        g();
        Preconditions.checkNotEmpty(str);
        m(str);
        return (gP2) this.h.get(str);
    }

    public final String r(String str) throws Throwable {
        g();
        m(str);
        return (String) this.l.get(str);
    }

    public final Set s(String str) throws Throwable {
        g();
        m(str);
        return (Set) this.e.get(str);
    }

    public final boolean t(String str) {
        g();
        gP2 gp2Q = q(str);
        if (gp2Q == null) {
            return false;
        }
        return gp2Q.z();
    }

    public final boolean u(String str, String str2) throws Throwable {
        Boolean bool;
        g();
        m(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map map = (Map) this.g.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean v(String str, String str2) {
        Boolean bool;
        g();
        m(str);
        if ("1".equals(a(str, "measurement.upload.blacklist_internal")) && C0653fY2.P(str2)) {
            return true;
        }
        if ("1".equals(a(str, "measurement.upload.blacklist_public")) && C0653fY2.Q(str2)) {
            return true;
        }
        Map map = (Map) this.f.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x035f, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0360, code lost:
    
        r1.put("filter_id", r3);
        r1.put("event_name", r10.q());
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0370, code lost:
    
        if (r10.z() == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0372, code lost:
    
        r3 = java.lang.Boolean.valueOf(r10.w());
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x037b, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x037c, code lost:
    
        r1.put("session_scoped", r3);
        r1.put("data", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0390, code lost:
    
        if (r8.y().insertWithOnConflict("event_filters", null, r1, 5) != (-1)) goto L234;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0392, code lost:
    
        r1 = r5.i;
        defpackage.C1391rR2.k(r1);
        r1.f.b(defpackage.WO2.n(r28), "Failed to insert event filter (got -1). appId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x03a2, code lost:
    
        r3 = r21;
        r7 = r22;
        r1 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x03aa, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x03ab, code lost:
    
        r1 = r5.i;
        defpackage.C1391rR2.k(r1);
        r1.f.c(defpackage.WO2.n(r28), r0, "Error storing event filter. appId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x03c1, code lost:
    
        r23 = r1;
        r0 = r0.r().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x03cf, code lost:
    
        if (r0.hasNext() == false) goto L236;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x03d1, code lost:
    
        r1 = (defpackage.C1446sO2) r0.next();
        r8.h();
        r8.g();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r28);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x03eb, code lost:
    
        if (r1.o().isEmpty() == false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x03ed, code lost:
    
        r0 = r5.i;
        defpackage.C1391rR2.k(r0);
        r0 = r0.i;
        r4 = defpackage.WO2.n(r28);
        r5 = java.lang.Integer.valueOf(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0402, code lost:
    
        if (r1.t() == false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0404, code lost:
    
        r1 = java.lang.Integer.valueOf(r1.l());
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x040d, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x040e, code lost:
    
        r0.d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r4, r5, java.lang.String.valueOf(r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0417, code lost:
    
        r7 = r1.b();
        r10 = new android.content.ContentValues();
        r10.put(r3, r28);
        r22 = r0;
        r10.put("audience_id", java.lang.Integer.valueOf(r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0430, code lost:
    
        if (r1.t() == false) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0432, code lost:
    
        r0 = java.lang.Integer.valueOf(r1.l());
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x043b, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x043c, code lost:
    
        r10.put("filter_id", r0);
        r24 = r3;
        r10.put("property_name", r1.o());
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x044e, code lost:
    
        if (r1.u() == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0450, code lost:
    
        r0 = java.lang.Boolean.valueOf(r1.s());
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0459, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x045a, code lost:
    
        r10.put("session_scoped", r0);
        r10.put("data", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x046e, code lost:
    
        if (r8.y().insertWithOnConflict("property_filters", null, r10, 5) != (-1)) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0470, code lost:
    
        r0 = r5.i;
        defpackage.C1391rR2.k(r0);
        r0.f.b(defpackage.WO2.n(r28), "Failed to insert property filter (got -1). appId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0481, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0483, code lost:
    
        r0 = r22;
        r3 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0489, code lost:
    
        r1 = r5.i;
        defpackage.C1391rR2.k(r1);
        r1.f.c(defpackage.WO2.n(r28), r0, "Error storing property filter. appId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0499, code lost:
    
        r8.h();
        r8.g();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r28);
        r0 = r8.y();
        r3 = r20;
        r0.delete("property_filters", r3, new java.lang.String[]{r28, java.lang.String.valueOf(r6)});
        r0.delete("event_filters", r3, new java.lang.String[]{r28, java.lang.String.valueOf(r6)});
        r20 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x04c0, code lost:
    
        r3 = r21;
        r1 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x02a2, code lost:
    
        r7 = r0.r().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x02ae, code lost:
    
        if (r7.hasNext() == false) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x02ba, code lost:
    
        if (((defpackage.C1446sO2) r7.next()).t() != false) goto L230;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x02bc, code lost:
    
        r0 = r5.i;
        defpackage.C1391rR2.k(r0);
        r0.i.c(defpackage.WO2.n(r28), java.lang.Integer.valueOf(r6), "Property filter with no ID. Audience definition ignored. appId, audienceId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x02d2, code lost:
    
        r7 = r0.q().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x02de, code lost:
    
        r21 = r3;
        r3 = "app_id";
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x02ea, code lost:
    
        if (r7.hasNext() == false) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x02ec, code lost:
    
        r10 = (defpackage.RN2) r7.next();
        r8.h();
        r8.g();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r28);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0306, code lost:
    
        if (r10.q().isEmpty() == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0308, code lost:
    
        r0 = r5.i;
        defpackage.C1391rR2.k(r0);
        r0 = r0.i;
        r4 = defpackage.WO2.n(r28);
        r5 = java.lang.Integer.valueOf(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x031d, code lost:
    
        if (r10.y() == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x031f, code lost:
    
        r7 = java.lang.Integer.valueOf(r10.m());
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0328, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0329, code lost:
    
        r0.d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r4, r5, java.lang.String.valueOf(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0330, code lost:
    
        r23 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0334, code lost:
    
        r22 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0336, code lost:
    
        r7 = r10.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x033a, code lost:
    
        r23 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x033c, code lost:
    
        r1 = new android.content.ContentValues();
        r1.put("app_id", r28);
        r1.put("audience_id", java.lang.Integer.valueOf(r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x034f, code lost:
    
        if (r10.y() == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0351, code lost:
    
        r3 = java.lang.Integer.valueOf(r10.m());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(java.lang.String r28, byte[] r29, java.lang.String r30, java.lang.String r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1614
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.TQ2.w(java.lang.String, byte[], java.lang.String, java.lang.String):void");
    }

    public final boolean x(String str) throws Throwable {
        g();
        m(str);
        gf gfVar = this.e;
        return gfVar.get(str) != null && ((Set) gfVar.get(str)).contains("app_instance_id");
    }

    public final boolean y(String str) throws Throwable {
        g();
        m(str);
        gf gfVar = this.e;
        if (gfVar.get(str) != null) {
            return ((Set) gfVar.get(str)).contains("device_model") || ((Set) gfVar.get(str)).contains("device_info");
        }
        return false;
    }

    public final boolean z(String str) throws Throwable {
        g();
        m(str);
        gf gfVar = this.e;
        return gfVar.get(str) != null && ((Set) gfVar.get(str)).contains("enhanced_user_id");
    }

    @Override // defpackage.AbstractC0906jX2
    public final void j() {
    }
}
