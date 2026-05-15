package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzcl;
import defpackage.AbstractBinderC1832zI2;
import defpackage.AbstractC0579eO2;
import defpackage.BU2;
import defpackage.C03;
import defpackage.C0653fY2;
import defpackage.C0899jR2;
import defpackage.C1391rR2;
import defpackage.C1791yV2;
import defpackage.DT2;
import defpackage.GU2;
import defpackage.IU2;
import defpackage.InterfaceC0631fJ2;
import defpackage.JT2;
import defpackage.NI2;
import defpackage.NZ2;
import defpackage.OT2;
import defpackage.QY2;
import defpackage.RI2;
import defpackage.RU2;
import defpackage.RunnableC0532dV2;
import defpackage.RunnableC0650fW2;
import defpackage.RunnableC0902jU2;
import defpackage.RunnableC0909jY2;
import defpackage.RunnableC1218oU2;
import defpackage.RunnableC1335qU2;
import defpackage.RunnableC1451sU2;
import defpackage.RunnableC1564uU2;
import defpackage.RunnableC1678wU2;
import defpackage.RunnableC1794yX2;
import defpackage.TU2;
import defpackage.WO2;
import defpackage.XZ2;
import defpackage.YI2;
import defpackage.YZ2;
import defpackage.Zr0;
import defpackage.gf;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@DynamiteApi
public class AppMeasurementDynamiteService extends AbstractBinderC1832zI2 {
    public C1391rR2 t;
    public final gf u;

    public AppMeasurementDynamiteService() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        this.t = null;
        this.u = new gf(0);
    }

    public final void X0() {
        if (this.t == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    public final void Y0(String str, NI2 ni2) {
        X0();
        C0653fY2 c0653fY2 = this.t.l;
        C1391rR2.i(c0653fY2);
        c0653fY2.D(str, ni2);
    }

    @Override // defpackage.DI2
    public void beginAdUnitExposure(String str, long j) {
        X0();
        this.t.m().h(j, str);
    }

    @Override // defpackage.DI2
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        X0();
        IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        iu2.k(str, str2, bundle);
    }

    @Override // defpackage.DI2
    public void clearMeasurementEnabled(long j) {
        X0();
        IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        iu2.h();
        C0899jR2 c0899jR2 = iu2.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.o(new RunnableC1678wU2(iu2, null));
    }

    @Override // defpackage.DI2
    public void endAdUnitExposure(String str, long j) {
        X0();
        this.t.m().i(j, str);
    }

    @Override // defpackage.DI2
    public void generateEventId(NI2 ni2) {
        X0();
        C0653fY2 c0653fY2 = this.t.l;
        C1391rR2.i(c0653fY2);
        long jF0 = c0653fY2.f0();
        X0();
        C0653fY2 c0653fY22 = this.t.l;
        C1391rR2.i(c0653fY22);
        c0653fY22.C(ni2, jF0);
    }

    @Override // defpackage.DI2
    public void getAppInstanceId(NI2 ni2) {
        X0();
        C0899jR2 c0899jR2 = this.t.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.o(new OT2(this, ni2));
    }

    @Override // defpackage.DI2
    public void getCachedAppInstanceId(NI2 ni2) {
        X0();
        IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        Y0(iu2.A(), ni2);
    }

    @Override // defpackage.DI2
    public void getConditionalUserProperties(String str, String str2, NI2 ni2) {
        X0();
        C0899jR2 c0899jR2 = this.t.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.o(new RunnableC0909jY2(this, ni2, str, str2));
    }

    @Override // defpackage.DI2
    public void getCurrentScreenClass(NI2 ni2) {
        X0();
        IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        C1791yV2 c1791yV2 = iu2.a.o;
        C1391rR2.j(c1791yV2);
        TU2 tu2 = c1791yV2.c;
        Y0(tu2 != null ? tu2.b : null, ni2);
    }

    @Override // defpackage.DI2
    public void getCurrentScreenName(NI2 ni2) {
        X0();
        IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        C1791yV2 c1791yV2 = iu2.a.o;
        C1391rR2.j(c1791yV2);
        TU2 tu2 = c1791yV2.c;
        Y0(tu2 != null ? tu2.a : null, ni2);
    }

    @Override // defpackage.DI2
    public void getGmpAppId(NI2 ni2) {
        X0();
        IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        C1391rR2 c1391rR2 = iu2.a;
        String strB = c1391rR2.b;
        if (strB == null) {
            try {
                strB = RU2.b(c1391rR2.a, c1391rR2.s);
            } catch (IllegalStateException e) {
                WO2 wo2 = c1391rR2.i;
                C1391rR2.k(wo2);
                wo2.f.b(e, "getGoogleAppId failed with exception");
                strB = null;
            }
        }
        Y0(strB, ni2);
    }

    @Override // defpackage.DI2
    public void getMaxUserProperties(String str, NI2 ni2) {
        X0();
        IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        Preconditions.checkNotEmpty(str);
        iu2.a.getClass();
        X0();
        C0653fY2 c0653fY2 = this.t.l;
        C1391rR2.i(c0653fY2);
        c0653fY2.B(ni2, 25);
    }

    @Override // defpackage.DI2
    public void getTestFlag(NI2 ni2, int i) {
        X0();
        if (i == 0) {
            C0653fY2 c0653fY2 = this.t.l;
            C1391rR2.i(c0653fY2);
            IU2 iu2 = this.t.p;
            C1391rR2.j(iu2);
            AtomicReference atomicReference = new AtomicReference();
            C0899jR2 c0899jR2 = iu2.a.j;
            C1391rR2.k(c0899jR2);
            c0653fY2.D((String) c0899jR2.l(atomicReference, 15000L, "String test flag value", new RunnableC1218oU2(iu2, atomicReference)), ni2);
            return;
        }
        if (i == 1) {
            C0653fY2 c0653fY22 = this.t.l;
            C1391rR2.i(c0653fY22);
            IU2 iu22 = this.t.p;
            C1391rR2.j(iu22);
            AtomicReference atomicReference2 = new AtomicReference();
            C0899jR2 c0899jR22 = iu22.a.j;
            C1391rR2.k(c0899jR22);
            c0653fY22.C(ni2, ((Long) c0899jR22.l(atomicReference2, 15000L, "long test flag value", new RunnableC1335qU2(iu22, atomicReference2))).longValue());
            return;
        }
        if (i == 2) {
            C0653fY2 c0653fY23 = this.t.l;
            C1391rR2.i(c0653fY23);
            IU2 iu23 = this.t.p;
            C1391rR2.j(iu23);
            AtomicReference atomicReference3 = new AtomicReference();
            C0899jR2 c0899jR23 = iu23.a.j;
            C1391rR2.k(c0899jR23);
            double dDoubleValue = ((Double) c0899jR23.l(atomicReference3, 15000L, "double test flag value", new RunnableC1564uU2(iu23, atomicReference3))).doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", dDoubleValue);
            try {
                ni2.e(bundle);
                return;
            } catch (RemoteException e) {
                WO2 wo2 = c0653fY23.a.i;
                C1391rR2.k(wo2);
                wo2.i.b(e, "Error returning double value to wrapper");
                return;
            }
        }
        if (i == 3) {
            C0653fY2 c0653fY24 = this.t.l;
            C1391rR2.i(c0653fY24);
            IU2 iu24 = this.t.p;
            C1391rR2.j(iu24);
            AtomicReference atomicReference4 = new AtomicReference();
            C0899jR2 c0899jR24 = iu24.a.j;
            C1391rR2.k(c0899jR24);
            c0653fY24.B(ni2, ((Integer) c0899jR24.l(atomicReference4, 15000L, "int test flag value", new RunnableC1451sU2(iu24, atomicReference4))).intValue());
            return;
        }
        if (i != 4) {
            return;
        }
        C0653fY2 c0653fY25 = this.t.l;
        C1391rR2.i(c0653fY25);
        IU2 iu25 = this.t.p;
        C1391rR2.j(iu25);
        AtomicReference atomicReference5 = new AtomicReference();
        C0899jR2 c0899jR25 = iu25.a.j;
        C1391rR2.k(c0899jR25);
        c0653fY25.x(ni2, ((Boolean) c0899jR25.l(atomicReference5, 15000L, "boolean test flag value", new RunnableC0902jU2(iu25, atomicReference5))).booleanValue());
    }

    @Override // defpackage.DI2
    public void getUserProperties(String str, String str2, boolean z, NI2 ni2) {
        X0();
        C0899jR2 c0899jR2 = this.t.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.o(new RunnableC0650fW2(this, ni2, str, str2, z));
    }

    @Override // defpackage.DI2
    public void initForTests(Map map) {
        X0();
    }

    @Override // defpackage.DI2
    public void initialize(Zr0 zr0, zzcl zzclVar, long j) {
        C1391rR2 c1391rR2 = this.t;
        if (c1391rR2 == null) {
            this.t = C1391rR2.r((Context) Preconditions.checkNotNull((Context) ObjectWrapper.X0(zr0)), zzclVar, Long.valueOf(j));
            return;
        }
        WO2 wo2 = c1391rR2.i;
        C1391rR2.k(wo2);
        wo2.i.a("Attempting to initialize multiple times");
    }

    @Override // defpackage.DI2
    public void isDataCollectionEnabled(NI2 ni2) {
        X0();
        C0899jR2 c0899jR2 = this.t.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.o(new QY2(this, ni2));
    }

    @Override // defpackage.DI2
    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        X0();
        IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        iu2.m(str, str2, bundle, z, z2, j);
    }

    @Override // defpackage.DI2
    public void logEventAndBundle(String str, String str2, Bundle bundle, NI2 ni2, long j) {
        X0();
        Preconditions.checkNotEmpty(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        zzaw zzawVar = new zzaw(str2, new zzau(bundle), "app", j);
        C0899jR2 c0899jR2 = this.t.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.o(new RunnableC0532dV2(this, ni2, zzawVar, str));
    }

    @Override // defpackage.DI2
    public void logHealthData(int i, String str, Zr0 zr0, Zr0 zr02, Zr0 zr03) {
        X0();
        Object objX0 = zr0 == null ? null : ObjectWrapper.X0(zr0);
        Object objX02 = zr02 == null ? null : ObjectWrapper.X0(zr02);
        Object objX03 = zr03 != null ? ObjectWrapper.X0(zr03) : null;
        WO2 wo2 = this.t.i;
        C1391rR2.k(wo2);
        wo2.r(i, true, false, str, objX0, objX02, objX03);
    }

    @Override // defpackage.DI2
    public void onActivityCreated(Zr0 zr0, Bundle bundle, long j) {
        X0();
        IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        GU2 gu2 = iu2.c;
        if (gu2 != null) {
            IU2 iu22 = this.t.p;
            C1391rR2.j(iu22);
            iu22.l();
            gu2.onActivityCreated((Activity) ObjectWrapper.X0(zr0), bundle);
        }
    }

    @Override // defpackage.DI2
    public void onActivityDestroyed(Zr0 zr0, long j) {
        X0();
        IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        GU2 gu2 = iu2.c;
        if (gu2 != null) {
            IU2 iu22 = this.t.p;
            C1391rR2.j(iu22);
            iu22.l();
            gu2.onActivityDestroyed((Activity) ObjectWrapper.X0(zr0));
        }
    }

    @Override // defpackage.DI2
    public void onActivityPaused(Zr0 zr0, long j) {
        X0();
        IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        GU2 gu2 = iu2.c;
        if (gu2 != null) {
            IU2 iu22 = this.t.p;
            C1391rR2.j(iu22);
            iu22.l();
            gu2.onActivityPaused((Activity) ObjectWrapper.X0(zr0));
        }
    }

    @Override // defpackage.DI2
    public void onActivityResumed(Zr0 zr0, long j) {
        X0();
        IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        GU2 gu2 = iu2.c;
        if (gu2 != null) {
            IU2 iu22 = this.t.p;
            C1391rR2.j(iu22);
            iu22.l();
            gu2.onActivityResumed((Activity) ObjectWrapper.X0(zr0));
        }
    }

    @Override // defpackage.DI2
    public void onActivitySaveInstanceState(Zr0 zr0, NI2 ni2, long j) {
        X0();
        IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        GU2 gu2 = iu2.c;
        Bundle bundle = new Bundle();
        if (gu2 != null) {
            IU2 iu22 = this.t.p;
            C1391rR2.j(iu22);
            iu22.l();
            gu2.onActivitySaveInstanceState((Activity) ObjectWrapper.X0(zr0), bundle);
        }
        try {
            ni2.e(bundle);
        } catch (RemoteException e) {
            WO2 wo2 = this.t.i;
            C1391rR2.k(wo2);
            wo2.i.b(e, "Error returning bundle value to wrapper");
        }
    }

    @Override // defpackage.DI2
    public void onActivityStarted(Zr0 zr0, long j) {
        X0();
        IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        if (iu2.c != null) {
            IU2 iu22 = this.t.p;
            C1391rR2.j(iu22);
            iu22.l();
        }
    }

    @Override // defpackage.DI2
    public void onActivityStopped(Zr0 zr0, long j) {
        X0();
        IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        if (iu2.c != null) {
            IU2 iu22 = this.t.p;
            C1391rR2.j(iu22);
            iu22.l();
        }
    }

    @Override // defpackage.DI2
    public void performAction(Bundle bundle, NI2 ni2, long j) {
        X0();
        ni2.e(null);
    }

    @Override // defpackage.DI2
    public void registerOnMeasurementEventListener(YI2 yi2) {
        C03 c03;
        X0();
        synchronized (this.u) {
            try {
                gf gfVar = this.u;
                RI2 ri2 = (RI2) yi2;
                Parcel parcelX0 = ri2.X0(2, ri2.W0());
                int i = parcelX0.readInt();
                parcelX0.recycle();
                c03 = (C03) gfVar.get(Integer.valueOf(i));
                if (c03 == null) {
                    c03 = new C03(this, ri2);
                    gf gfVar2 = this.u;
                    Parcel parcelX02 = ri2.X0(2, ri2.W0());
                    int i2 = parcelX02.readInt();
                    parcelX02.recycle();
                    gfVar2.put(Integer.valueOf(i2), c03);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        iu2.h();
        Preconditions.checkNotNull(c03);
        if (iu2.e.add(c03)) {
            return;
        }
        WO2 wo2 = iu2.a.i;
        C1391rR2.k(wo2);
        wo2.i.a("OnEventListener already registered");
    }

    @Override // defpackage.DI2
    public void resetAnalyticsData(long j) {
        X0();
        IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        iu2.g.set(null);
        C0899jR2 c0899jR2 = iu2.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.o(new JT2(iu2, j));
    }

    @Override // defpackage.DI2
    public void setConditionalUserProperty(Bundle bundle, long j) {
        X0();
        if (bundle == null) {
            WO2 wo2 = this.t.i;
            C1391rR2.k(wo2);
            wo2.f.a("Conditional user property must not be null");
        } else {
            IU2 iu2 = this.t.p;
            C1391rR2.j(iu2);
            iu2.r(bundle, j);
        }
    }

    @Override // defpackage.DI2
    public void setConsent(final Bundle bundle, final long j) {
        X0();
        final IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        ((YZ2) XZ2.u.t.zza()).getClass();
        C1391rR2 c1391rR2 = iu2.a;
        if (!c1391rR2.g.p(null, AbstractC0579eO2.h0)) {
            iu2.x(bundle, j);
            return;
        }
        C0899jR2 c0899jR2 = c1391rR2.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.p(new Runnable() { // from class: uT2
            @Override // java.lang.Runnable
            public final void run() {
                iu2.x(bundle, j);
            }
        });
    }

    @Override // defpackage.DI2
    public void setConsentThirdParty(Bundle bundle, long j) {
        X0();
        IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        iu2.s(bundle, -20, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0094, code lost:
    
        if (r4.length() <= 100) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00bf, code lost:
    
        if (r5.length() <= 100) goto L33;
     */
    @Override // defpackage.DI2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setCurrentScreen(defpackage.Zr0 r3, java.lang.String r4, java.lang.String r5, long r6) {
        /*
            Method dump skipped, instruction units count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.AppMeasurementDynamiteService.setCurrentScreen(Zr0, java.lang.String, java.lang.String, long):void");
    }

    @Override // defpackage.DI2
    public void setDataCollectionEnabled(boolean z) {
        X0();
        IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        iu2.h();
        C0899jR2 c0899jR2 = iu2.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.o(new BU2(iu2, z));
    }

    @Override // defpackage.DI2
    public void setDefaultEventParameters(Bundle bundle) {
        X0();
        final IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        final Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
        C0899jR2 c0899jR2 = iu2.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.o(new Runnable() { // from class: wT2
            @Override // java.lang.Runnable
            public final void run() {
                C1094mU2 c1094mU2;
                WO2 wo2;
                C0653fY2 c0653fY2;
                IU2 iu22 = iu2;
                C1391rR2 c1391rR2 = iu22.a;
                Bundle bundle3 = bundle2;
                if (bundle3 == null) {
                    TP2 tp2 = c1391rR2.h;
                    C1391rR2.i(tp2);
                    tp2.v.b(new Bundle());
                    return;
                }
                TP2 tp22 = c1391rR2.h;
                C1391rR2.i(tp22);
                Bundle bundleA = tp22.v.a();
                Iterator<String> it = bundle3.keySet().iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    c1094mU2 = iu22.p;
                    wo2 = c1391rR2.i;
                    c0653fY2 = c1391rR2.l;
                    if (!zHasNext) {
                        break;
                    }
                    String next = it.next();
                    Object obj = bundle3.get(next);
                    if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                        C1391rR2.i(c0653fY2);
                        if (C0653fY2.N(obj)) {
                            C0653fY2.v(c1094mU2, null, 27, null, null, 0);
                        }
                        C1391rR2.k(wo2);
                        wo2.k.c(next, obj, "Invalid default event parameter type. Name, value");
                    } else if (C0653fY2.P(next)) {
                        C1391rR2.k(wo2);
                        wo2.k.b(next, "Invalid default event parameter name. Name");
                    } else if (obj == null) {
                        bundleA.remove(next);
                    } else {
                        C1391rR2.i(c0653fY2);
                        if (c0653fY2.J(obj, 100, "param", next)) {
                            c0653fY2.w(bundleA, next, obj);
                        }
                    }
                }
                C1391rR2.i(c0653fY2);
                int iJ = c1391rR2.g.j();
                if (bundleA.size() > iJ) {
                    int i = 0;
                    for (String str : new TreeSet(bundleA.keySet())) {
                        i++;
                        if (i > iJ) {
                            bundleA.remove(str);
                        }
                    }
                    C1391rR2.i(c0653fY2);
                    C0653fY2.v(c1094mU2, null, 26, null, null, 0);
                    C1391rR2.k(wo2);
                    wo2.k.a("Too many default event parameters set. Discarding beyond event parameter limit");
                }
                TP2 tp23 = c1391rR2.h;
                C1391rR2.i(tp23);
                tp23.v.b(bundleA);
                CW2 cw2S = c1391rR2.s();
                cw2S.g();
                cw2S.h();
                cw2S.s(new IV2(cw2S, cw2S.p(false), bundleA));
            }
        });
    }

    @Override // defpackage.DI2
    public void setEventInterceptor(YI2 yi2) {
        X0();
        NZ2 nz2 = new NZ2(this, yi2);
        C0899jR2 c0899jR2 = this.t.j;
        C1391rR2.k(c0899jR2);
        if (!c0899jR2.q()) {
            C0899jR2 c0899jR22 = this.t.j;
            C1391rR2.k(c0899jR22);
            c0899jR22.o(new RunnableC1794yX2(this, nz2));
            return;
        }
        IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        iu2.g();
        iu2.h();
        NZ2 nz22 = iu2.d;
        if (nz2 != nz22) {
            Preconditions.checkState(nz22 == null, "EventInterceptor already set.");
        }
        iu2.d = nz2;
    }

    @Override // defpackage.DI2
    public void setInstanceIdProvider(InterfaceC0631fJ2 interfaceC0631fJ2) {
        X0();
    }

    @Override // defpackage.DI2
    public void setMeasurementEnabled(boolean z, long j) {
        X0();
        IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        Boolean boolValueOf = Boolean.valueOf(z);
        iu2.h();
        C0899jR2 c0899jR2 = iu2.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.o(new RunnableC1678wU2(iu2, boolValueOf));
    }

    @Override // defpackage.DI2
    public void setMinimumSessionDuration(long j) {
        X0();
    }

    @Override // defpackage.DI2
    public void setSessionTimeoutDuration(long j) {
        X0();
        IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        C0899jR2 c0899jR2 = iu2.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.o(new DT2(iu2, j));
    }

    @Override // defpackage.DI2
    public void setUserId(final String str, long j) {
        X0();
        final IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        C1391rR2 c1391rR2 = iu2.a;
        if (str != null && TextUtils.isEmpty(str)) {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.i.a("User ID must be non-empty or null");
        } else {
            C0899jR2 c0899jR2 = c1391rR2.j;
            C1391rR2.k(c0899jR2);
            c0899jR2.o(new Runnable() { // from class: yT2
                @Override // java.lang.Runnable
                public final void run() {
                    IU2 iu22 = iu2;
                    C1270pO2 c1270pO2O = iu22.a.o();
                    String str2 = c1270pO2O.p;
                    String str3 = str;
                    boolean z = false;
                    if (str2 != null && !str2.equals(str3)) {
                        z = true;
                    }
                    c1270pO2O.p = str3;
                    if (z) {
                        iu22.a.o().m();
                    }
                }
            });
            iu2.v(null, "_id", str, true, j);
        }
    }

    @Override // defpackage.DI2
    public void setUserProperty(String str, String str2, Zr0 zr0, boolean z, long j) {
        X0();
        Object objX0 = ObjectWrapper.X0(zr0);
        IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        iu2.v(str, str2, objX0, z, j);
    }

    @Override // defpackage.DI2
    public void unregisterOnMeasurementEventListener(YI2 yi2) {
        RI2 ri2;
        C03 c03;
        X0();
        synchronized (this.u) {
            gf gfVar = this.u;
            ri2 = (RI2) yi2;
            Parcel parcelX0 = ri2.X0(2, ri2.W0());
            int i = parcelX0.readInt();
            parcelX0.recycle();
            c03 = (C03) gfVar.remove(Integer.valueOf(i));
        }
        if (c03 == null) {
            c03 = new C03(this, ri2);
        }
        IU2 iu2 = this.t.p;
        C1391rR2.j(iu2);
        iu2.h();
        Preconditions.checkNotNull(c03);
        if (iu2.e.remove(c03)) {
            return;
        }
        WO2 wo2 = iu2.a.i;
        C1391rR2.k(wo2);
        wo2.i.a("OnEventListener had not been registered");
    }
}
