package defpackage;

import android.app.Application;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.measurement.internal.zzq;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class IU2 extends TO2 {
    public GU2 c;
    public NZ2 d;
    public final CopyOnWriteArraySet e;
    public boolean f;
    public final AtomicReference g;
    public final Object h;
    public CD2 i;
    public int j;
    public final AtomicLong k;
    public long l;
    public int m;
    public final X13 n;
    public boolean o;
    public final C1094mU2 p;

    public IU2(C1391rR2 c1391rR2) {
        super(c1391rR2);
        this.e = new CopyOnWriteArraySet();
        this.h = new Object();
        this.o = true;
        this.p = new C1094mU2(this);
        this.g = new AtomicReference();
        this.i = new CD2(null, null);
        this.j = 100;
        this.l = -1L;
        this.m = 100;
        this.k = new AtomicLong(0L);
        this.n = new X13(c1391rR2);
    }

    public static /* bridge */ /* synthetic */ void B(IU2 iu2, CD2 cd2, CD2 cd22) {
        EnumC1486tD2 enumC1486tD2 = EnumC1486tD2.ANALYTICS_STORAGE;
        EnumC1486tD2 enumC1486tD22 = EnumC1486tD2.AD_STORAGE;
        EnumC1486tD2[] enumC1486tD2Arr = {enumC1486tD2, enumC1486tD22};
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= 2) {
                break;
            }
            EnumC1486tD2 enumC1486tD23 = enumC1486tD2Arr[i];
            if (!cd22.f(enumC1486tD23) && cd2.f(enumC1486tD23)) {
                z = true;
                break;
            }
            i++;
        }
        boolean zG = cd2.g(cd22, enumC1486tD2, enumC1486tD22);
        if (z || zG) {
            iu2.a.o().m();
        }
    }

    public static void C(IU2 iu2, CD2 cd2, int i, long j, boolean z, boolean z2) {
        iu2.g();
        iu2.h();
        long j2 = iu2.l;
        C1391rR2 c1391rR2 = iu2.a;
        if (j <= j2) {
            int i2 = iu2.m;
            CD2 cd22 = CD2.b;
            if (i2 <= i) {
                WO2 wo2 = c1391rR2.i;
                C1391rR2.k(wo2);
                wo2.l.b(cd2, "Dropped out-of-date consent setting, proposed settings");
                return;
            }
        }
        TP2 tp2 = c1391rR2.h;
        C1391rR2.i(tp2);
        tp2.g();
        if (!tp2.o(i)) {
            WO2 wo22 = c1391rR2.i;
            C1391rR2.k(wo22);
            wo22.l.b(Integer.valueOf(i), "Lower precedence consent source ignored, proposed source");
            return;
        }
        SharedPreferences.Editor editorEdit = tp2.k().edit();
        editorEdit.putString("consent_settings", cd2.e());
        editorEdit.putInt("consent_source", i);
        editorEdit.apply();
        iu2.l = j;
        iu2.m = i;
        CW2 cw2S = c1391rR2.s();
        cw2S.g();
        cw2S.h();
        if (z) {
            C1391rR2 c1391rR22 = cw2S.a;
            c1391rR22.getClass();
            c1391rR22.p().l();
        }
        if (cw2S.n()) {
            cw2S.s(new QV2(cw2S, cw2S.p(false)));
        }
        if (z2) {
            c1391rR2.s().x(new AtomicReference());
        }
    }

    public final String A() {
        return (String) this.g.get();
    }

    public final void D() {
        g();
        h();
        C1391rR2 c1391rR2 = this.a;
        if (c1391rR2.h()) {
            C0467cO2 c0467cO2 = AbstractC0579eO2.X;
            C1009lD2 c1009lD2 = c1391rR2.g;
            if (c1009lD2.p(null, c0467cO2)) {
                c1009lD2.a.getClass();
                Boolean boolO = c1009lD2.o("google_analytics_deferred_deep_link_enabled");
                if (boolO != null && boolO.booleanValue()) {
                    WO2 wo2 = c1391rR2.i;
                    C1391rR2.k(wo2);
                    wo2.m.a("Deferred Deep Link feature enabled.");
                    C0899jR2 c0899jR2 = c1391rR2.j;
                    C1391rR2.k(c0899jR2);
                    c0899jR2.o(new Runnable() { // from class: zT2
                        @Override // java.lang.Runnable
                        public final void run() {
                            Pair pair;
                            NetworkInfo activeNetworkInfo;
                            IU2 iu2 = this.t;
                            iu2.g();
                            C1391rR2 c1391rR22 = iu2.a;
                            TP2 tp2 = c1391rR22.h;
                            C1391rR2.i(tp2);
                            boolean zB = tp2.q.b();
                            WO2 wo22 = c1391rR22.i;
                            if (zB) {
                                C1391rR2.k(wo22);
                                wo22.m.a("Deferred Deep Link already retrieved. Not fetching again.");
                                return;
                            }
                            TP2 tp22 = c1391rR22.h;
                            C1391rR2.i(tp22);
                            long jA = tp22.r.a();
                            C1391rR2.i(tp22);
                            tp22.r.b(1 + jA);
                            boolean z = true;
                            if (jA >= 5) {
                                C1391rR2.k(wo22);
                                wo22.i.a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                                C1391rR2.i(tp22);
                                tp22.q.a(true);
                                return;
                            }
                            C0899jR2 c0899jR22 = c1391rR22.j;
                            C1391rR2.k(c0899jR22);
                            c0899jR22.g();
                            PU2 pu2 = c1391rR22.r;
                            C1391rR2.k(pu2);
                            C1391rR2.k(pu2);
                            String strK = c1391rR22.o().k();
                            C1391rR2.i(tp22);
                            tp22.g();
                            C1391rR2 c1391rR23 = tp22.a;
                            long jElapsedRealtime = c1391rR23.n.elapsedRealtime();
                            String str = tp22.g;
                            if (str == null || jElapsedRealtime >= tp22.i) {
                                tp22.i = c1391rR23.g.m(strK, AbstractC0579eO2.b) + jElapsedRealtime;
                                AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
                                try {
                                    AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(c1391rR23.a);
                                    tp22.g = "";
                                    String id = advertisingIdInfo.getId();
                                    if (id != null) {
                                        tp22.g = id;
                                    }
                                    tp22.h = advertisingIdInfo.isLimitAdTrackingEnabled();
                                } catch (Exception e) {
                                    WO2 wo23 = c1391rR23.i;
                                    C1391rR2.k(wo23);
                                    wo23.m.b(e, "Unable to get advertising id");
                                    tp22.g = "";
                                }
                                AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
                                pair = new Pair(tp22.g, Boolean.valueOf(tp22.h));
                            } else {
                                pair = new Pair(str, Boolean.valueOf(tp22.h));
                            }
                            Boolean boolO2 = c1391rR22.g.o("google_analytics_adid_collection_enabled");
                            if (boolO2 != null && !boolO2.booleanValue()) {
                                z = false;
                            }
                            if (!z || ((Boolean) pair.second).booleanValue() || TextUtils.isEmpty((CharSequence) pair.first)) {
                                C1391rR2.k(wo22);
                                wo22.m.a("ADID unavailable to retrieve Deferred Deep Link. Skipping");
                                return;
                            }
                            C1391rR2.k(pu2);
                            pu2.i();
                            C1391rR2 c1391rR24 = pu2.a;
                            ConnectivityManager connectivityManager = (ConnectivityManager) c1391rR24.a.getSystemService("connectivity");
                            URL url = null;
                            if (connectivityManager != null) {
                                try {
                                    activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                                } catch (SecurityException unused) {
                                    activeNetworkInfo = null;
                                }
                            } else {
                                activeNetworkInfo = null;
                            }
                            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                                C1391rR2.k(wo22);
                                wo22.i.a("Network is not available for Deferred Deep Link request. Skipping");
                                return;
                            }
                            C0653fY2 c0653fY2 = c1391rR22.l;
                            C1391rR2.i(c0653fY2);
                            c1391rR22.o().a.g.l();
                            String str2 = (String) pair.first;
                            long jA2 = tp22.r.a() - 1;
                            C1391rR2 c1391rR25 = c0653fY2.a;
                            try {
                                Preconditions.checkNotEmpty(str2);
                                Preconditions.checkNotEmpty(strK);
                                String strConcat = "https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=" + ("v64000." + c0653fY2.d0()) + "&rdid=" + str2 + "&bundleid=" + strK + "&retry=" + jA2;
                                if (strK.equals(c1391rR25.g.h("debug.deferred.deeplink"))) {
                                    strConcat = strConcat.concat("&ddl_test=1");
                                }
                                url = new URL(strConcat);
                            } catch (IllegalArgumentException e2) {
                                e = e2;
                                WO2 wo24 = c1391rR25.i;
                                C1391rR2.k(wo24);
                                wo24.f.b(e.getMessage(), "Failed to create BOW URL for Deferred Deep Link. exception");
                            } catch (MalformedURLException e3) {
                                e = e3;
                                WO2 wo242 = c1391rR25.i;
                                C1391rR2.k(wo242);
                                wo242.f.b(e.getMessage(), "Failed to create BOW URL for Deferred Deep Link. exception");
                            }
                            if (url != null) {
                                C1391rR2.k(pu2);
                                C1089mR2 c1089mR2 = new C1089mR2(c1391rR22);
                                pu2.g();
                                pu2.i();
                                Preconditions.checkNotNull(url);
                                Preconditions.checkNotNull(c1089mR2);
                                C0899jR2 c0899jR23 = c1391rR24.j;
                                C1391rR2.k(c0899jR23);
                                c0899jR23.n(new NU2(pu2, strK, url, c1089mR2));
                            }
                        }
                    });
                }
            }
            CW2 cw2S = c1391rR2.s();
            cw2S.g();
            cw2S.h();
            zzq zzqVarP = cw2S.p(true);
            cw2S.a.p().n(3, new byte[0]);
            cw2S.s(new GV2(cw2S, zzqVarP));
            this.o = false;
            TP2 tp2 = c1391rR2.h;
            C1391rR2.i(tp2);
            tp2.g();
            String string = tp2.k().getString("previous_os_version", null);
            tp2.a.n().i();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor editorEdit = tp2.k().edit();
                editorEdit.putString("previous_os_version", str);
                editorEdit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            c1391rR2.n().i();
            if (string.equals(str)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            n("auto", "_ou", bundle);
        }
    }

    @Override // defpackage.TO2
    public final boolean j() {
        return false;
    }

    public final void k(String str, String str2, Bundle bundle) {
        C1391rR2 c1391rR2 = this.a;
        long jCurrentTimeMillis = c1391rR2.n.currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong("creation_timestamp", jCurrentTimeMillis);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        C0899jR2 c0899jR2 = c1391rR2.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.o(new MT2(this, bundle2));
    }

    public final void l() {
        C1391rR2 c1391rR2 = this.a;
        if (!(c1391rR2.a.getApplicationContext() instanceof Application) || this.c == null) {
            return;
        }
        ((Application) c1391rR2.a.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00f3, code lost:
    
        if (r5 > 100) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0125, code lost:
    
        if (r6 > 100) goto L72;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m(java.lang.String r21, java.lang.String r22, android.os.Bundle r23, boolean r24, boolean r25, long r26) {
        /*
            Method dump skipped, instruction units count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.IU2.m(java.lang.String, java.lang.String, android.os.Bundle, boolean, boolean, long):void");
    }

    public final void n(String str, String str2, Bundle bundle) {
        g();
        o(this.a.n.currentTimeMillis(), bundle, str, str2);
    }

    public final void o(long j, Bundle bundle, String str, String str2) {
        g();
        p(str, str2, j, bundle, true, this.d == null || C0653fY2.P(str2), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:147:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0549  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0207  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(java.lang.String r28, java.lang.String r29, long r30, android.os.Bundle r32, boolean r33, boolean r34, boolean r35) {
        /*
            Method dump skipped, instruction units count: 1367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.IU2.p(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean):void");
    }

    public final void q(long j, boolean z) {
        g();
        h();
        C1391rR2 c1391rR2 = this.a;
        WO2 wo2 = c1391rR2.i;
        C1391rR2.k(wo2);
        wo2.m.a("Resetting analytics data (FE)");
        C0420bX2 c0420bX2 = c1391rR2.k;
        C1391rR2.j(c0420bX2);
        c0420bX2.g();
        YW2 yw2 = c0420bX2.e;
        yw2.c.a();
        yw2.a = 0L;
        yw2.b = 0L;
        Y03.a();
        C0467cO2 c0467cO2 = AbstractC0579eO2.C0;
        C1009lD2 c1009lD2 = c1391rR2.g;
        if (c1009lD2.p(null, c0467cO2)) {
            c1391rR2.o().m();
        }
        boolean zG = c1391rR2.g();
        TP2 tp2 = c1391rR2.h;
        C1391rR2.i(tp2);
        tp2.e.b(j);
        C1391rR2 c1391rR22 = tp2.a;
        TP2 tp22 = c1391rR22.h;
        C1391rR2.i(tp22);
        if (!TextUtils.isEmpty(tp22.s.a())) {
            tp2.s.b(null);
        }
        C0680g03 c0680g03 = C0680g03.u;
        ((InterfaceC0747h03) c0680g03.t.zza()).getClass();
        C0467cO2 c0467cO22 = AbstractC0579eO2.d0;
        C1009lD2 c1009lD22 = c1391rR22.g;
        if (c1009lD22.p(null, c0467cO22)) {
            tp2.n.b(0L);
        }
        if (!c1009lD22.s()) {
            tp2.m(!zG);
        }
        tp2.t.b(null);
        tp2.u.b(0L);
        tp2.v.b(null);
        if (z) {
            CW2 cw2S = c1391rR2.s();
            cw2S.g();
            cw2S.h();
            zzq zzqVarP = cw2S.p(false);
            C1391rR2 c1391rR23 = cw2S.a;
            c1391rR23.getClass();
            c1391rR23.p().l();
            cw2S.s(new CV2(cw2S, zzqVarP));
        }
        ((InterfaceC0747h03) c0680g03.t.zza()).getClass();
        if (c1009lD2.p(null, c0467cO22)) {
            C1391rR2.j(c0420bX2);
            c0420bX2.d.a();
        }
        this.o = !zG;
    }

    public final void r(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        boolean zIsEmpty = TextUtils.isEmpty(bundle2.getString("app_id"));
        C1391rR2 c1391rR2 = this.a;
        if (!zIsEmpty) {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.i.a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        YS2.a(bundle2, "app_id", String.class, null);
        YS2.a(bundle2, "origin", String.class, null);
        YS2.a(bundle2, "name", String.class, null);
        YS2.a(bundle2, "value", Object.class, null);
        YS2.a(bundle2, "trigger_event_name", String.class, null);
        YS2.a(bundle2, "trigger_timeout", Long.class, 0L);
        YS2.a(bundle2, "timed_out_event_name", String.class, null);
        YS2.a(bundle2, "timed_out_event_params", Bundle.class, null);
        YS2.a(bundle2, "triggered_event_name", String.class, null);
        YS2.a(bundle2, "triggered_event_params", Bundle.class, null);
        YS2.a(bundle2, "time_to_live", Long.class, 0L);
        YS2.a(bundle2, "expired_event_name", String.class, null);
        YS2.a(bundle2, "expired_event_params", Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong("creation_timestamp", j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        C0653fY2 c0653fY2 = c1391rR2.l;
        C1391rR2.i(c0653fY2);
        if (c0653fY2.c0(string) != 0) {
            WO2 wo22 = c1391rR2.i;
            C1391rR2.k(wo22);
            wo22.f.b(c1391rR2.m.d(string), "Invalid conditional user property name");
            return;
        }
        C0653fY2 c0653fY22 = c1391rR2.l;
        C1391rR2.i(c0653fY22);
        if (c0653fY22.Y(obj, string) != 0) {
            WO2 wo23 = c1391rR2.i;
            C1391rR2.k(wo23);
            wo23.f.c(c1391rR2.m.d(string), obj, "Invalid conditional user property value");
            return;
        }
        C0653fY2 c0653fY23 = c1391rR2.l;
        C1391rR2.i(c0653fY23);
        Object objL = c0653fY23.l(obj, string);
        if (objL == null) {
            WO2 wo24 = c1391rR2.i;
            C1391rR2.k(wo24);
            wo24.f.c(c1391rR2.m.d(string), obj, "Unable to normalize conditional user property value");
            return;
        }
        YS2.b(bundle2, objL);
        long j2 = bundle2.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name"))) {
            c1391rR2.getClass();
            if (j2 > 15552000000L || j2 < 1) {
                WO2 wo25 = c1391rR2.i;
                C1391rR2.k(wo25);
                wo25.f.c(c1391rR2.m.d(string), Long.valueOf(j2), "Invalid conditional user property timeout");
                return;
            }
        }
        long j3 = bundle2.getLong("time_to_live");
        c1391rR2.getClass();
        if (j3 <= 15552000000L && j3 >= 1) {
            C0899jR2 c0899jR2 = c1391rR2.j;
            C1391rR2.k(c0899jR2);
            c0899jR2.o(new KT2(this, bundle2));
        } else {
            WO2 wo26 = c1391rR2.i;
            C1391rR2.k(wo26);
            wo26.f.c(c1391rR2.m.d(string), Long.valueOf(j3), "Invalid conditional user property time to live");
        }
    }

    public final void s(Bundle bundle, int i, long j) {
        Object obj;
        String string;
        h();
        CD2 cd2 = CD2.b;
        EnumC1486tD2[] enumC1486tD2ArrValues = EnumC1486tD2.values();
        int length = enumC1486tD2ArrValues.length;
        int i2 = 0;
        while (true) {
            obj = null;
            if (i2 >= length) {
                break;
            }
            EnumC1486tD2 enumC1486tD2 = enumC1486tD2ArrValues[i2];
            if (bundle.containsKey(enumC1486tD2.t) && (string = bundle.getString(enumC1486tD2.t)) != null) {
                if (string.equals("granted")) {
                    obj = Boolean.TRUE;
                } else if (string.equals("denied")) {
                    obj = Boolean.FALSE;
                }
                if (obj == null) {
                    obj = string;
                    break;
                }
            }
            i2++;
        }
        if (obj != null) {
            C1391rR2 c1391rR2 = this.a;
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.k.b(obj, "Ignoring invalid consent setting");
            WO2 wo22 = c1391rR2.i;
            C1391rR2.k(wo22);
            wo22.k.a("Valid consent values are 'granted', 'denied'");
        }
        t(CD2.a(bundle), i, j);
    }

    public final void t(CD2 cd2, int i, long j) {
        CD2 cd22;
        boolean z;
        boolean zG;
        boolean z2;
        CD2 cd2D = cd2;
        h();
        if (i != -10) {
            if (((Boolean) cd2D.a.get(EnumC1486tD2.AD_STORAGE)) == null) {
                if (((Boolean) cd2D.a.get(EnumC1486tD2.ANALYTICS_STORAGE)) == null) {
                    WO2 wo2 = this.a.i;
                    C1391rR2.k(wo2);
                    wo2.k.a("Discarding empty consent settings");
                    return;
                }
            }
        }
        synchronized (this.h) {
            try {
                cd22 = this.i;
                int i2 = this.j;
                CD2 cd23 = CD2.b;
                z = false;
                if (i <= i2) {
                    zG = cd2D.g(cd22, (EnumC1486tD2[]) cd2D.a.keySet().toArray(new EnumC1486tD2[0]));
                    EnumC1486tD2 enumC1486tD2 = EnumC1486tD2.ANALYTICS_STORAGE;
                    if (cd2D.f(enumC1486tD2) && !this.i.f(enumC1486tD2)) {
                        z = true;
                    }
                    cd2D = cd2D.d(this.i);
                    this.i = cd2D;
                    this.j = i;
                    z2 = z;
                    z = true;
                } else {
                    zG = false;
                    z2 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z) {
            WO2 wo22 = this.a.i;
            C1391rR2.k(wo22);
            wo22.l.b(cd2D, "Ignoring lower-priority consent settings, proposed settings");
            return;
        }
        long andIncrement = this.k.getAndIncrement();
        if (zG) {
            this.g.set(null);
            C0899jR2 c0899jR2 = this.a.j;
            C1391rR2.k(c0899jR2);
            c0899jR2.p(new RunnableC1790yU2(this, cd2D, j, i, andIncrement, z2, cd22));
            return;
        }
        AU2 au2 = new AU2(this, cd2D, i, andIncrement, z2, cd22);
        if (i == 30 || i == -10) {
            C0899jR2 c0899jR22 = this.a.j;
            C1391rR2.k(c0899jR22);
            c0899jR22.p(au2);
        } else {
            C0899jR2 c0899jR23 = this.a.j;
            C1391rR2.k(c0899jR23);
            c0899jR23.o(au2);
        }
    }

    public final void u(CD2 cd2) {
        g();
        boolean z = (cd2.f(EnumC1486tD2.ANALYTICS_STORAGE) && cd2.f(EnumC1486tD2.AD_STORAGE)) || this.a.s().n();
        C1391rR2 c1391rR2 = this.a;
        C0899jR2 c0899jR2 = c1391rR2.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        if (z != c1391rR2.D) {
            C1391rR2 c1391rR22 = this.a;
            C0899jR2 c0899jR22 = c1391rR22.j;
            C1391rR2.k(c0899jR22);
            c0899jR22.g();
            c1391rR22.D = z;
            TP2 tp2 = this.a.h;
            C1391rR2.i(tp2);
            tp2.g();
            Boolean boolValueOf = tp2.k().contains("measurement_enabled_from_api") ? Boolean.valueOf(tp2.k().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z || boolValueOf == null || boolValueOf.booleanValue()) {
                y(Boolean.valueOf(z), false);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(java.lang.String r13, java.lang.String r14, java.lang.Object r15, boolean r16, long r17) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.IU2.v(java.lang.String, java.lang.String, java.lang.Object, boolean, long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(long r11, java.lang.Object r13, java.lang.String r14, java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.IU2.w(long, java.lang.Object, java.lang.String, java.lang.String):void");
    }

    public final void x(Bundle bundle, long j) {
        C1391rR2 c1391rR2 = this.a;
        if (TextUtils.isEmpty(c1391rR2.o().l())) {
            s(bundle, 0, j);
            return;
        }
        WO2 wo2 = c1391rR2.i;
        C1391rR2.k(wo2);
        wo2.k.a("Using developer consent only; google app id found");
    }

    public final void y(Boolean bool, boolean z) {
        g();
        h();
        C1391rR2 c1391rR2 = this.a;
        WO2 wo2 = c1391rR2.i;
        C1391rR2.k(wo2);
        wo2.m.b(bool, "Setting app measurement enabled (FE)");
        TP2 tp2 = c1391rR2.h;
        C1391rR2.i(tp2);
        tp2.g();
        SharedPreferences.Editor editorEdit = tp2.k().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled");
        }
        editorEdit.apply();
        if (z) {
            TP2 tp22 = c1391rR2.h;
            C1391rR2.i(tp22);
            tp22.g();
            SharedPreferences.Editor editorEdit2 = tp22.k().edit();
            if (bool != null) {
                editorEdit2.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                editorEdit2.remove("measurement_enabled_from_api");
            }
            editorEdit2.apply();
        }
        C0899jR2 c0899jR2 = c1391rR2.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        if (c1391rR2.D || !(bool == null || bool.booleanValue())) {
            z();
        }
    }

    public final void z() {
        g();
        C1391rR2 c1391rR2 = this.a;
        TP2 tp2 = c1391rR2.h;
        C1391rR2.i(tp2);
        String strA = tp2.l.a();
        if (strA != null) {
            boolean zEquals = "unset".equals(strA);
            Clock clock = c1391rR2.n;
            if (zEquals) {
                w(clock.currentTimeMillis(), null, "app", "_npa");
            } else {
                w(clock.currentTimeMillis(), Long.valueOf(true != "true".equals(strA) ? 0L : 1L), "app", "_npa");
            }
        }
        boolean zG = c1391rR2.g();
        WO2 wo2 = c1391rR2.i;
        if (!zG || !this.o) {
            C1391rR2.k(wo2);
            wo2.m.a("Updating Scion state (FE)");
            CW2 cw2S = c1391rR2.s();
            cw2S.g();
            cw2S.h();
            cw2S.s(new OV2(cw2S, cw2S.p(true)));
            return;
        }
        C1391rR2.k(wo2);
        wo2.m.a("Recording app launch after enabling measurement for the first time (FE)");
        D();
        ((InterfaceC0747h03) C0680g03.u.t.zza()).getClass();
        if (c1391rR2.g.p(null, AbstractC0579eO2.d0)) {
            C0420bX2 c0420bX2 = c1391rR2.k;
            C1391rR2.j(c0420bX2);
            c0420bX2.d.a();
        }
        C0899jR2 c0899jR2 = c1391rR2.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.o(new BT2(this));
    }
}
