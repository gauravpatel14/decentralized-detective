package defpackage;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzaw;
import com.google.android.gms.measurement.internal.zzlo;
import com.google.android.gms.measurement.internal.zzq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class MS2 extends AbstractBinderC0458cH2 implements InterfaceC1086mO2 {
    public final QX2 t;
    public Boolean u;
    public String v;

    public MS2(QX2 qx2) {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
        Preconditions.checkNotNull(qx2);
        this.t = qx2;
        this.v = null;
    }

    @Override // defpackage.InterfaceC1086mO2
    public final byte[] G(zzaw zzawVar, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzawVar);
        a1(str, true);
        QX2 qx2 = this.t;
        WO2 wo2D = qx2.d();
        C1391rR2 c1391rR2 = qx2.l;
        C1672wO2 c1672wO2 = c1391rR2.m;
        String str2 = zzawVar.t;
        wo2D.m.b(c1672wO2.b(str2), "Log and bundle. event");
        long jNanoTime = qx2.e().nanoTime() / 1000000;
        C0899jR2 c0899jR2B = qx2.b();
        CallableC0709gS2 callableC0709gS2 = new CallableC0709gS2(this, zzawVar, str);
        c0899jR2B.i();
        Preconditions.checkNotNull(callableC0709gS2);
        C0582eR2 c0582eR2 = new C0582eR2(c0899jR2B, callableC0709gS2, true);
        if (Thread.currentThread() == c0899jR2B.c) {
            c0582eR2.run();
        } else {
            c0899jR2B.r(c0582eR2);
        }
        try {
            byte[] bArr = (byte[]) c0582eR2.get();
            if (bArr == null) {
                qx2.d().f.b(WO2.n(str), "Log and bundle returned null. appId");
                bArr = new byte[0];
            }
            qx2.d().m.d("Log and bundle processed. event, size, time_ms", c1391rR2.m.b(str2), Integer.valueOf(bArr.length), Long.valueOf((qx2.e().nanoTime() / 1000000) - jNanoTime));
            return bArr;
        } catch (InterruptedException e) {
            e = e;
            WO2 wo2D2 = qx2.d();
            wo2D2.f.d("Failed to log and bundle. appId, event, error", WO2.n(str), c1391rR2.m.b(str2), e);
            return null;
        } catch (ExecutionException e2) {
            e = e2;
            WO2 wo2D22 = qx2.d();
            wo2D22.f.d("Failed to log and bundle. appId, event, error", WO2.n(str), c1391rR2.m.b(str2), e);
            return null;
        }
    }

    @Override // defpackage.InterfaceC1086mO2
    public final void G0(zzlo zzloVar, zzq zzqVar) {
        Preconditions.checkNotNull(zzloVar);
        Z0(zzqVar);
        Y0(new RunnableC0900jS2(this, zzloVar, zzqVar));
    }

    @Override // defpackage.InterfaceC1086mO2
    public final void J(zzq zzqVar) {
        Preconditions.checkNotEmpty(zzqVar.t);
        Preconditions.checkNotNull(zzqVar.O);
        WR2 wr2 = new WR2(this, zzqVar);
        Preconditions.checkNotNull(wr2);
        QX2 qx2 = this.t;
        if (qx2.b().q()) {
            wr2.run();
        } else {
            qx2.b().p(wr2);
        }
    }

    @Override // defpackage.InterfaceC1086mO2
    public final void K0(zzaw zzawVar, zzq zzqVar) {
        Preconditions.checkNotNull(zzawVar);
        Z0(zzqVar);
        Y0(new ZR2(this, zzawVar, zzqVar));
    }

    @Override // defpackage.InterfaceC1086mO2
    public final List Q(String str, String str2, boolean z, zzq zzqVar) {
        Z0(zzqVar);
        String str3 = zzqVar.t;
        Preconditions.checkNotNull(str3);
        QX2 qx2 = this.t;
        try {
            List<C0362aY2> list = (List) qx2.b().m(new CR2(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (C0362aY2 c0362aY2 : list) {
                if (z || !C0653fY2.P(c0362aY2.c)) {
                    arrayList.add(new zzlo(c0362aY2));
                }
            }
            return arrayList;
        } catch (InterruptedException e) {
            e = e;
            WO2 wo2D = qx2.d();
            wo2D.f.c(WO2.n(str3), e, "Failed to query user properties. appId");
            return Collections.emptyList();
        } catch (ExecutionException e2) {
            e = e2;
            WO2 wo2D2 = qx2.d();
            wo2D2.f.c(WO2.n(str3), e, "Failed to query user properties. appId");
            return Collections.emptyList();
        }
    }

    @Override // defpackage.InterfaceC1086mO2
    public final void R0(zzq zzqVar) {
        Z0(zzqVar);
        Y0(new GS2(this, zzqVar));
    }

    @Override // defpackage.InterfaceC1086mO2
    public final String S(zzq zzqVar) {
        Z0(zzqVar);
        QX2 qx2 = this.t;
        try {
            return (String) qx2.b().m(new IX2(qx2, zzqVar)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            WO2 wo2D = qx2.d();
            wo2D.f.c(WO2.n(zzqVar.t), e, "Failed to get app instance id. appId");
            return null;
        }
    }

    @Override // defpackage.InterfaceC1086mO2
    public final List T0(String str, String str2, zzq zzqVar) {
        Z0(zzqVar);
        String str3 = zzqVar.t;
        Preconditions.checkNotNull(str3);
        QX2 qx2 = this.t;
        try {
            return (List) qx2.b().m(new IR2(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            qx2.d().f.b(e, "Failed to get conditional user properties");
            return Collections.emptyList();
        }
    }

    @Override // defpackage.AbstractBinderC0458cH2
    public final boolean W0(int i, Parcel parcel, Parcel parcel2) {
        boolean z;
        ArrayList arrayList;
        switch (i) {
            case 1:
                zzaw zzawVar = (zzaw) hH2.a(parcel, zzaw.CREATOR);
                zzq zzqVar = (zzq) hH2.a(parcel, zzq.CREATOR);
                hH2.b(parcel);
                K0(zzawVar, zzqVar);
                parcel2.writeNoException();
                return true;
            case 2:
                zzlo zzloVar = (zzlo) hH2.a(parcel, zzlo.CREATOR);
                zzq zzqVar2 = (zzq) hH2.a(parcel, zzq.CREATOR);
                hH2.b(parcel);
                G0(zzloVar, zzqVar2);
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                zzq zzqVar3 = (zzq) hH2.a(parcel, zzq.CREATOR);
                hH2.b(parcel);
                R0(zzqVar3);
                parcel2.writeNoException();
                return true;
            case 5:
                zzaw zzawVar2 = (zzaw) hH2.a(parcel, zzaw.CREATOR);
                String string = parcel.readString();
                parcel.readString();
                hH2.b(parcel);
                Preconditions.checkNotNull(zzawVar2);
                Preconditions.checkNotEmpty(string);
                a1(string, true);
                Y0(new RunnableC0473cS2(this, zzawVar2, string));
                parcel2.writeNoException();
                return true;
            case 6:
                zzq zzqVar4 = (zzq) hH2.a(parcel, zzq.CREATOR);
                hH2.b(parcel);
                o(zzqVar4);
                parcel2.writeNoException();
                return true;
            case 7:
                zzq zzqVar5 = (zzq) hH2.a(parcel, zzq.CREATOR);
                z = parcel.readInt() != 0;
                hH2.b(parcel);
                Z0(zzqVar5);
                String str = zzqVar5.t;
                Preconditions.checkNotNull(str);
                QX2 qx2 = this.t;
                try {
                    List<C0362aY2> list = (List) qx2.b().m(new CallableC1150nS2(this, str)).get();
                    arrayList = new ArrayList(list.size());
                    for (C0362aY2 c0362aY2 : list) {
                        if (z || !C0653fY2.P(c0362aY2.c)) {
                            arrayList.add(new zzlo(c0362aY2));
                        }
                        break;
                    }
                } catch (InterruptedException e) {
                    e = e;
                    qx2.d().f.c(WO2.n(str), e, "Failed to get user properties. appId");
                    arrayList = null;
                } catch (ExecutionException e2) {
                    e = e2;
                    qx2.d().f.c(WO2.n(str), e, "Failed to get user properties. appId");
                    arrayList = null;
                }
                parcel2.writeNoException();
                parcel2.writeTypedList(arrayList);
                return true;
            case ConnectionResult.SERVICE_INVALID /* 9 */:
                zzaw zzawVar3 = (zzaw) hH2.a(parcel, zzaw.CREATOR);
                String string2 = parcel.readString();
                hH2.b(parcel);
                byte[] bArrG = G(zzawVar3, string2);
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrG);
                return true;
            case 10:
                long j = parcel.readLong();
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                String string5 = parcel.readString();
                hH2.b(parcel);
                j(j, string3, string4, string5);
                parcel2.writeNoException();
                return true;
            case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                zzq zzqVar6 = (zzq) hH2.a(parcel, zzq.CREATOR);
                hH2.b(parcel);
                String strS = S(zzqVar6);
                parcel2.writeNoException();
                parcel2.writeString(strS);
                return true;
            case 12:
                zzac zzacVar = (zzac) hH2.a(parcel, zzac.CREATOR);
                zzq zzqVar7 = (zzq) hH2.a(parcel, zzq.CREATOR);
                hH2.b(parcel);
                o0(zzacVar, zzqVar7);
                parcel2.writeNoException();
                return true;
            case 13:
                zzac zzacVar2 = (zzac) hH2.a(parcel, zzac.CREATOR);
                hH2.b(parcel);
                Preconditions.checkNotNull(zzacVar2);
                Preconditions.checkNotNull(zzacVar2.v);
                Preconditions.checkNotEmpty(zzacVar2.t);
                a1(zzacVar2.t, true);
                Y0(new RunnableC1786yR2(this, new zzac(zzacVar2)));
                parcel2.writeNoException();
                return true;
            case 14:
                String string6 = parcel.readString();
                String string7 = parcel.readString();
                ClassLoader classLoader = hH2.a;
                z = parcel.readInt() != 0;
                zzq zzqVar8 = (zzq) hH2.a(parcel, zzq.CREATOR);
                hH2.b(parcel);
                List listQ = Q(string6, string7, z, zzqVar8);
                parcel2.writeNoException();
                parcel2.writeTypedList(listQ);
                return true;
            case 15:
                String string8 = parcel.readString();
                String string9 = parcel.readString();
                String string10 = parcel.readString();
                ClassLoader classLoader2 = hH2.a;
                z = parcel.readInt() != 0;
                hH2.b(parcel);
                List listZ = z(string8, string9, string10, z);
                parcel2.writeNoException();
                parcel2.writeTypedList(listZ);
                return true;
            case 16:
                String string11 = parcel.readString();
                String string12 = parcel.readString();
                zzq zzqVar9 = (zzq) hH2.a(parcel, zzq.CREATOR);
                hH2.b(parcel);
                List listT0 = T0(string11, string12, zzqVar9);
                parcel2.writeNoException();
                parcel2.writeTypedList(listT0);
                return true;
            case 17:
                String string13 = parcel.readString();
                String string14 = parcel.readString();
                String string15 = parcel.readString();
                hH2.b(parcel);
                List listD0 = d0(string13, string14, string15);
                parcel2.writeNoException();
                parcel2.writeTypedList(listD0);
                return true;
            case ConnectionResult.SERVICE_UPDATING /* 18 */:
                zzq zzqVar10 = (zzq) hH2.a(parcel, zzq.CREATOR);
                hH2.b(parcel);
                g0(zzqVar10);
                parcel2.writeNoException();
                return true;
            case 19:
                Bundle bundle = (Bundle) hH2.a(parcel, Bundle.CREATOR);
                zzq zzqVar11 = (zzq) hH2.a(parcel, zzq.CREATOR);
                hH2.b(parcel);
                x(bundle, zzqVar11);
                parcel2.writeNoException();
                return true;
            case 20:
                zzq zzqVar12 = (zzq) hH2.a(parcel, zzq.CREATOR);
                hH2.b(parcel);
                J(zzqVar12);
                parcel2.writeNoException();
                return true;
        }
    }

    public final void X0(zzaw zzawVar, zzq zzqVar) {
        QX2 qx2 = this.t;
        qx2.a();
        qx2.i(zzawVar, zzqVar);
    }

    public final void Y0(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        QX2 qx2 = this.t;
        if (qx2.b().q()) {
            runnable.run();
        } else {
            qx2.b().o(runnable);
        }
    }

    public final void Z0(zzq zzqVar) {
        Preconditions.checkNotNull(zzqVar);
        Preconditions.checkNotEmpty(zzqVar.t);
        a1(zzqVar.t, false);
        this.t.P().F(zzqVar.u, zzqVar.f24J);
    }

    public final void a1(String str, boolean z) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        QX2 qx2 = this.t;
        if (zIsEmpty) {
            qx2.d().f.a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                if (this.u == null) {
                    boolean z2 = true;
                    if (!"com.google.android.gms".equals(this.v) && !UidVerifier.isGooglePlayServicesUid(qx2.l.a, Binder.getCallingUid()) && !GoogleSignatureVerifier.getInstance(qx2.l.a).isUidGoogleSigned(Binder.getCallingUid())) {
                        z2 = false;
                    }
                    this.u = Boolean.valueOf(z2);
                }
                if (this.u.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                qx2.d().f.b(WO2.n(str), "Measurement Service called with invalid calling package. appId");
                throw e;
            }
        }
        if (this.v == null && GooglePlayServicesUtilLight.uidHasPackageName(qx2.l.a, Binder.getCallingUid(), str)) {
            this.v = str;
        }
        if (str.equals(this.v)) {
            return;
        }
        throw new SecurityException("Unknown calling package name '" + str + "'.");
    }

    @Override // defpackage.InterfaceC1086mO2
    public final List d0(String str, String str2, String str3) {
        a1(str, true);
        QX2 qx2 = this.t;
        try {
            return (List) qx2.b().m(new MR2(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            qx2.d().f.b(e, "Failed to get conditional user properties as");
            return Collections.emptyList();
        }
    }

    @Override // defpackage.InterfaceC1086mO2
    public final void g0(zzq zzqVar) {
        Preconditions.checkNotEmpty(zzqVar.t);
        a1(zzqVar.t, false);
        Y0(new PR2(this, zzqVar));
    }

    @Override // defpackage.InterfaceC1086mO2
    public final void j(long j, String str, String str2, String str3) {
        Y0(new KS2(this, str2, str3, str, j));
    }

    @Override // defpackage.InterfaceC1086mO2
    public final void o(zzq zzqVar) {
        Z0(zzqVar);
        Y0(new TR2(this, zzqVar));
    }

    @Override // defpackage.InterfaceC1086mO2
    public final void o0(zzac zzacVar, zzq zzqVar) {
        Preconditions.checkNotNull(zzacVar);
        Preconditions.checkNotNull(zzacVar.v);
        Z0(zzqVar);
        zzac zzacVar2 = new zzac(zzacVar);
        zzacVar2.t = zzqVar.t;
        Y0(new RunnableC1674wR2(this, zzacVar2, zzqVar));
    }

    @Override // defpackage.InterfaceC1086mO2
    public final void x(final Bundle bundle, zzq zzqVar) {
        Z0(zzqVar);
        final String str = zzqVar.t;
        Preconditions.checkNotNull(str);
        Y0(new Runnable() { // from class: uR2
            @Override // java.lang.Runnable
            public final void run() {
                zzau zzauVar;
                C0513dE2 c0513dE2 = this.t.t.c;
                QX2.H(c0513dE2);
                c0513dE2.g();
                c0513dE2.h();
                String str2 = str;
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty("dep");
                TextUtils.isEmpty("");
                Bundle bundle2 = bundle;
                C1391rR2 c1391rR2 = c0513dE2.a;
                if (bundle2 == null || bundle2.isEmpty()) {
                    zzauVar = new zzau(new Bundle());
                } else {
                    Bundle bundle3 = new Bundle(bundle2);
                    Iterator<String> it = bundle3.keySet().iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (next == null) {
                            WO2 wo2 = c1391rR2.i;
                            C1391rR2.k(wo2);
                            wo2.f.a("Param name can't be null");
                            it.remove();
                        } else {
                            C0653fY2 c0653fY2 = c1391rR2.l;
                            C1391rR2.i(c0653fY2);
                            Object objK = c0653fY2.k(bundle3.get(next), next);
                            if (objK == null) {
                                WO2 wo22 = c1391rR2.i;
                                C1391rR2.k(wo22);
                                wo22.i.b(c1391rR2.m.c(next), "Param value can't be null");
                                it.remove();
                            } else {
                                C0653fY2 c0653fY22 = c1391rR2.l;
                                C1391rR2.i(c0653fY22);
                                c0653fY22.w(bundle3, next, objK);
                            }
                        }
                    }
                    zzauVar = new zzau(bundle3);
                }
                VX2 vx2 = c0513dE2.b.g;
                QX2.H(vx2);
                ZP2 zp2O = C0471cQ2.o();
                if (zp2O.v) {
                    zp2O.f();
                    zp2O.v = false;
                }
                C0471cQ2.z(0L, (C0471cQ2) zp2O.u);
                Bundle bundle4 = zzauVar.t;
                for (String str3 : bundle4.keySet()) {
                    C0960kQ2 c0960kQ2P = C1149nQ2.p();
                    c0960kQ2P.h(str3);
                    Object obj = bundle4.get(str3);
                    Preconditions.checkNotNull(obj);
                    vx2.w(c0960kQ2P, obj);
                    zp2O.i(c0960kQ2P);
                }
                byte[] bArrB = ((C0471cQ2) zp2O.d()).b();
                WO2 wo23 = c1391rR2.i;
                C1391rR2.k(wo23);
                wo23.n.c(c1391rR2.m.b(str2), Integer.valueOf(bArrB.length), "Saving default event parameters, appId, data size");
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str2);
                contentValues.put("parameters", bArrB);
                try {
                    if (c0513dE2.y().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                        C1391rR2.k(wo23);
                        wo23.f.b(WO2.n(str2), "Failed to insert default event parameters (got -1). appId");
                    }
                } catch (SQLiteException e) {
                    C1391rR2.k(wo23);
                    wo23.f.c(WO2.n(str2), e, "Error storing default event parameters. appId");
                }
            }
        });
    }

    @Override // defpackage.InterfaceC1086mO2
    public final List z(String str, String str2, String str3, boolean z) {
        a1(str, true);
        QX2 qx2 = this.t;
        try {
            List<C0362aY2> list = (List) qx2.b().m(new FR2(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (C0362aY2 c0362aY2 : list) {
                if (z || !C0653fY2.P(c0362aY2.c)) {
                    arrayList.add(new zzlo(c0362aY2));
                }
            }
            return arrayList;
        } catch (InterruptedException e) {
            e = e;
            WO2 wo2D = qx2.d();
            wo2D.f.c(WO2.n(str), e, "Failed to get user properties as. appId");
            return Collections.emptyList();
        } catch (ExecutionException e2) {
            e = e2;
            WO2 wo2D2 = qx2.d();
            wo2D2.f.c(WO2.n(str), e, "Failed to get user properties as. appId");
            return Collections.emptyList();
        }
    }
}
