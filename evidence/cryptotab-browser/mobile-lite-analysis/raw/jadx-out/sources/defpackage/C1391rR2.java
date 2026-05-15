package defpackage;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.measurement.zzcl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: rR2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1391rR2 implements WS2 {
    public static volatile C1391rR2 H;
    public volatile Boolean A;
    public final Boolean B;
    public final Boolean C;
    public volatile boolean D;
    public int E;
    public final long G;
    public final Context a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final C1070mC2 f;
    public final C1009lD2 g;
    public final TP2 h;
    public final WO2 i;
    public final C0899jR2 j;
    public final C0420bX2 k;
    public final C0653fY2 l;
    public final C1672wO2 m;
    public final Clock n;
    public final C1791yV2 o;
    public final IU2 p;
    public final AK2 q;
    public final PU2 r;
    public final String s;
    public C1503tO2 t;
    public CW2 u;
    public C1825zE2 v;
    public C1270pO2 w;
    public Boolean y;
    public long z;
    public boolean x = false;
    public final AtomicInteger F = new AtomicInteger(0);

    public C1391rR2(C1393rT2 c1393rT2) {
        Context context;
        Bundle bundle;
        Preconditions.checkNotNull(c1393rT2);
        Context context2 = c1393rT2.a;
        C1070mC2 c1070mC2 = new C1070mC2();
        this.f = c1070mC2;
        XN2.a = c1070mC2;
        this.a = context2;
        this.b = c1393rT2.b;
        this.c = c1393rT2.c;
        this.d = c1393rT2.d;
        this.e = c1393rT2.h;
        this.A = c1393rT2.e;
        this.s = c1393rT2.j;
        this.D = true;
        zzcl zzclVar = c1393rT2.g;
        if (zzclVar != null && (bundle = zzclVar.z) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.B = (Boolean) obj;
            }
            Object obj2 = zzclVar.z.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.C = (Boolean) obj2;
            }
        }
        if (LT2.g == null) {
            Object obj3 = LT2.f;
            synchronized (obj3) {
                try {
                    if (LT2.g == null) {
                        synchronized (obj3) {
                            IS2 is2 = LT2.g;
                            final Context applicationContext = context2.getApplicationContext();
                            if (applicationContext == null) {
                                applicationContext = context2;
                            }
                            if (is2 == null || is2.a != applicationContext) {
                                SS2.c();
                                NT2.a();
                                synchronized (C1217oT2.class) {
                                    try {
                                        C1217oT2 c1217oT2 = C1217oT2.c;
                                        if (c1217oT2 != null && (context = c1217oT2.a) != null && c1217oT2.b != null) {
                                            context.getContentResolver().unregisterContentObserver(C1217oT2.c.b);
                                        }
                                        C1217oT2.c = null;
                                    } finally {
                                    }
                                }
                                LT2.g = new IS2(applicationContext, AbstractC1848zU2.a(new InterfaceC1394rU2() { // from class: xT2
                                    @Override // defpackage.InterfaceC1394rU2
                                    public final Object zza() {
                                        File file;
                                        Object obj4 = LT2.f;
                                        String str = Build.TYPE;
                                        String str2 = Build.TAGS;
                                        boolean zEquals = str.equals("eng");
                                        AbstractC1153nU2 c1277pU2 = C0964kU2.t;
                                        if ((zEquals || str.equals("userdebug")) && (str2.contains("dev-keys") || str2.contains("test-keys"))) {
                                            Context contextCreateDeviceProtectedStorageContext = applicationContext;
                                            if (!contextCreateDeviceProtectedStorageContext.isDeviceProtectedStorage()) {
                                                contextCreateDeviceProtectedStorageContext = contextCreateDeviceProtectedStorageContext.createDeviceProtectedStorageContext();
                                            }
                                            StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                                            try {
                                                StrictMode.allowThreadDiskWrites();
                                                try {
                                                    file = new File(contextCreateDeviceProtectedStorageContext.getDir("phenotype_hermetic", 0), "overrides.txt");
                                                } catch (RuntimeException e) {
                                                    Log.e("HermeticFileOverrides", "no data dir", e);
                                                }
                                                AbstractC1153nU2 c1277pU22 = file.exists() ? new C1277pU2(file) : c1277pU2;
                                                if (c1277pU22.b()) {
                                                    File file2 = (File) c1277pU22.a();
                                                    try {
                                                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                                                        try {
                                                            HashMap map = new HashMap();
                                                            HashMap map2 = new HashMap();
                                                            while (true) {
                                                                String line = bufferedReader.readLine();
                                                                if (line == null) {
                                                                    break;
                                                                }
                                                                String[] strArrSplit = line.split(" ", 3);
                                                                if (strArrSplit.length != 3) {
                                                                    Log.e("HermeticFileOverrides", "Invalid: " + line);
                                                                } else {
                                                                    String str3 = new String(strArrSplit[0]);
                                                                    String strDecode = Uri.decode(new String(strArrSplit[1]));
                                                                    String strDecode2 = (String) map2.get(strArrSplit[2]);
                                                                    if (strDecode2 == null) {
                                                                        String str4 = new String(strArrSplit[2]);
                                                                        strDecode2 = Uri.decode(str4);
                                                                        if (strDecode2.length() < 1024 || strDecode2 == str4) {
                                                                            map2.put(str4, strDecode2);
                                                                        }
                                                                    }
                                                                    if (!map.containsKey(str3)) {
                                                                        map.put(str3, new HashMap());
                                                                    }
                                                                    ((Map) map.get(str3)).put(strDecode, strDecode2);
                                                                }
                                                            }
                                                            Log.i("HermeticFileOverrides", "Parsed " + file2.toString());
                                                            ZS2 zs2 = new ZS2(map);
                                                            bufferedReader.close();
                                                            c1277pU2 = new C1277pU2(zs2);
                                                        } catch (Throwable th) {
                                                            try {
                                                                bufferedReader.close();
                                                            } catch (Throwable th2) {
                                                                try {
                                                                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                                                                } catch (Exception unused) {
                                                                }
                                                            }
                                                            throw th;
                                                        }
                                                    } catch (IOException e2) {
                                                        throw new RuntimeException(e2);
                                                    }
                                                }
                                                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                                            } catch (Throwable th3) {
                                                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                                                throw th3;
                                            }
                                        }
                                        return c1277pU2;
                                    }
                                }));
                                LT2.h.incrementAndGet();
                            }
                        }
                    }
                } finally {
                }
            }
        }
        Clock defaultClock = DefaultClock.getInstance();
        this.n = defaultClock;
        Long l = c1393rT2.i;
        this.G = l != null ? l.longValue() : defaultClock.currentTimeMillis();
        C1009lD2 c1009lD2 = new C1009lD2(this);
        c1009lD2.c = TC2.a;
        this.g = c1009lD2;
        TP2 tp2 = new TP2(this);
        tp2.j();
        this.h = tp2;
        WO2 wo2 = new WO2(this);
        wo2.j();
        this.i = wo2;
        C0653fY2 c0653fY2 = new C0653fY2(this);
        c0653fY2.j();
        this.l = c0653fY2;
        this.m = new C1672wO2(new C1152nT2(this));
        this.q = new AK2(this);
        C1791yV2 c1791yV2 = new C1791yV2(this);
        c1791yV2.i();
        this.o = c1791yV2;
        IU2 iu2 = new IU2(this);
        iu2.i();
        this.p = iu2;
        C0420bX2 c0420bX2 = new C0420bX2(this);
        c0420bX2.i();
        this.k = c0420bX2;
        PU2 pu2 = new PU2(this);
        pu2.j();
        this.r = pu2;
        C0899jR2 c0899jR2 = new C0899jR2(this);
        c0899jR2.j();
        this.j = c0899jR2;
        zzcl zzclVar2 = c1393rT2.g;
        boolean z = zzclVar2 == null || zzclVar2.u == 0;
        if (context2.getApplicationContext() instanceof Application) {
            j(iu2);
            if (iu2.a.a.getApplicationContext() instanceof Application) {
                Application application = (Application) iu2.a.a.getApplicationContext();
                if (iu2.c == null) {
                    iu2.c = new GU2(iu2);
                }
                if (z) {
                    application.unregisterActivityLifecycleCallbacks(iu2.c);
                    application.registerActivityLifecycleCallbacks(iu2.c);
                    WO2 wo22 = iu2.a.i;
                    k(wo22);
                    wo22.n.a("Registered activity lifecycle callback");
                }
            }
        } else {
            k(wo2);
            wo2.i.a("Application context is not an Application");
        }
        c0899jR2.o(new RunnableC1215oR2(this, c1393rT2));
    }

    public static final void i(QS2 qs2) {
        if (qs2 == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    public static final void j(TO2 to2) {
        if (to2 == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!to2.b) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(to2.getClass())));
        }
    }

    public static final void k(US2 us2) {
        if (us2 == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!us2.b) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(us2.getClass())));
        }
    }

    public static C1391rR2 r(Context context, zzcl zzclVar, Long l) {
        Bundle bundle;
        if (zzclVar != null && (zzclVar.x == null || zzclVar.y == null)) {
            zzclVar = new zzcl(zzclVar.t, zzclVar.u, zzclVar.v, zzclVar.w, null, null, zzclVar.z, null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (H == null) {
            synchronized (C1391rR2.class) {
                try {
                    if (H == null) {
                        H = new C1391rR2(new C1393rT2(context, zzclVar, l));
                    }
                } finally {
                }
            }
        } else if (zzclVar != null && (bundle = zzclVar.z) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            Preconditions.checkNotNull(H);
            H.A = Boolean.valueOf(zzclVar.z.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(H);
        return H;
    }

    public final void a() {
        this.F.incrementAndGet();
    }

    @Override // defpackage.WS2
    public final C0899jR2 b() {
        C0899jR2 c0899jR2 = this.j;
        k(c0899jR2);
        return c0899jR2;
    }

    @Override // defpackage.WS2
    public final Context c() {
        return this.a;
    }

    @Override // defpackage.WS2
    public final WO2 d() {
        WO2 wo2 = this.i;
        k(wo2);
        return wo2;
    }

    @Override // defpackage.WS2
    public final Clock e() {
        return this.n;
    }

    @Override // defpackage.WS2
    public final C1070mC2 f() {
        return this.f;
    }

    public final boolean g() {
        return l() == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h() {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1391rR2.h():boolean");
    }

    public final int l() {
        C0899jR2 c0899jR2 = this.j;
        k(c0899jR2);
        c0899jR2.g();
        if (this.g.s()) {
            return 1;
        }
        Boolean bool = this.C;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        C0899jR2 c0899jR22 = this.j;
        k(c0899jR22);
        c0899jR22.g();
        if (!this.D) {
            return 8;
        }
        TP2 tp2 = this.h;
        i(tp2);
        tp2.g();
        Boolean boolValueOf = tp2.k().contains("measurement_enabled") ? Boolean.valueOf(tp2.k().getBoolean("measurement_enabled", true)) : null;
        if (boolValueOf != null) {
            return boolValueOf.booleanValue() ? 0 : 3;
        }
        C1009lD2 c1009lD2 = this.g;
        C1070mC2 c1070mC2 = c1009lD2.a.f;
        Boolean boolO = c1009lD2.o("firebase_analytics_collection_enabled");
        if (boolO != null) {
            return boolO.booleanValue() ? 0 : 4;
        }
        Boolean bool2 = this.B;
        return bool2 != null ? bool2.booleanValue() ? 0 : 5 : (this.A == null || this.A.booleanValue()) ? 0 : 7;
    }

    public final AK2 m() {
        AK2 ak2 = this.q;
        if (ak2 != null) {
            return ak2;
        }
        throw new IllegalStateException("Component not created");
    }

    public final C1825zE2 n() {
        k(this.v);
        return this.v;
    }

    public final C1270pO2 o() {
        j(this.w);
        return this.w;
    }

    public final C1503tO2 p() {
        j(this.t);
        return this.t;
    }

    public final C1672wO2 q() {
        return this.m;
    }

    public final CW2 s() {
        j(this.u);
        return this.u;
    }
}
