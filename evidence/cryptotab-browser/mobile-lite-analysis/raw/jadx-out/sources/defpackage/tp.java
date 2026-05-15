package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class tp {
    public volatile int a;
    public final String b;
    public final Handler c;
    public volatile RZ2 d;
    public final Context e;
    public final WI2 f;
    public volatile InterfaceC0818i23 g;
    public volatile jG2 h;
    public boolean i;
    public int j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public final C0312Ze1 u;
    public final boolean v;
    public ExecutorService w;

    public tp(C0312Ze1 c0312Ze1, Context context, InterfaceC0161Nn1 interfaceC0161Nn1) {
        String str;
        try {
            str = (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            str = "7.0.0";
        }
        this.a = 0;
        this.c = new Handler(Looper.getMainLooper());
        this.j = 0;
        this.b = str;
        this.e = context.getApplicationContext();
        SR2 sr2O = VR2.o();
        sr2O.c();
        VR2.l((VR2) sr2O.u, str);
        String packageName = this.e.getPackageName();
        sr2O.c();
        VR2.m((VR2) sr2O.u, packageName);
        this.f = new WI2(this.e, (VR2) sr2O.a());
        if (interfaceC0161Nn1 == null) {
            AbstractC1659wF2.e("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.d = new RZ2(this.e, interfaceC0161Nn1, this.f);
        this.u = c0312Ze1;
        this.v = false;
        this.e.getPackageName();
    }

    public final void a(final OK ok, final PK pk) {
        if (!b()) {
            Cp cp = MI2.i;
            i(CI2.a(2, 4, cp));
            pk.c(cp, ok.a);
        } else if (h(new Callable() { // from class: vD2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String strD;
                int i;
                tp tpVar = this.a;
                OK ok2 = ok;
                PK pk2 = pk;
                tpVar.getClass();
                String str = ok2.a;
                try {
                    int i2 = AbstractC1659wF2.a;
                    if (tpVar.l) {
                        InterfaceC0818i23 interfaceC0818i23 = tpVar.g;
                        String packageName = tpVar.e.getPackageName();
                        boolean z = tpVar.l;
                        String str2 = tpVar.b;
                        Bundle bundle = new Bundle();
                        if (z) {
                            bundle.putString("playBillingLibraryVersion", str2);
                        }
                        C1304q13 c1304q13 = (C1304q13) interfaceC0818i23;
                        Parcel parcelY0 = c1304q13.Y0();
                        parcelY0.writeInt(9);
                        parcelY0.writeString(packageName);
                        parcelY0.writeString(str);
                        int i3 = x33.a;
                        parcelY0.writeInt(1);
                        bundle.writeToParcel(parcelY0, 0);
                        Parcel parcelZ0 = c1304q13.Z0(12, parcelY0);
                        Bundle bundle2 = (Bundle) x33.a(parcelZ0, Bundle.CREATOR);
                        parcelZ0.recycle();
                        i = bundle2.getInt("RESPONSE_CODE");
                        strD = AbstractC1659wF2.d("BillingClient", bundle2);
                    } else {
                        InterfaceC0818i23 interfaceC0818i232 = tpVar.g;
                        String packageName2 = tpVar.e.getPackageName();
                        C1304q13 c1304q132 = (C1304q13) interfaceC0818i232;
                        Parcel parcelY02 = c1304q132.Y0();
                        parcelY02.writeInt(3);
                        parcelY02.writeString(packageName2);
                        parcelY02.writeString(str);
                        Parcel parcelZ02 = c1304q132.Z0(5, parcelY02);
                        int i4 = parcelZ02.readInt();
                        parcelZ02.recycle();
                        strD = "";
                        i = i4;
                    }
                    Cp cpA = MI2.a(i, strD);
                    if (i == 0) {
                        pk2.c(cpA, str);
                        return null;
                    }
                    AbstractC1659wF2.e("BillingClient", "Error consuming purchase with token. Response code: " + i);
                    tpVar.i(CI2.a(23, 4, cpA));
                    pk2.c(cpA, str);
                    return null;
                } catch (Exception e) {
                    AbstractC1659wF2.f("BillingClient", "Error consuming purchase!", e);
                    Cp cp2 = MI2.i;
                    tpVar.i(CI2.a(29, 4, cp2));
                    pk2.c(cp2, str);
                    return null;
                }
            }
        }, 30000L, new Runnable() { // from class: ED2
            @Override // java.lang.Runnable
            public final void run() {
                tp tpVar = this.t;
                tpVar.getClass();
                Cp cp2 = MI2.j;
                tpVar.i(CI2.a(24, 4, cp2));
                pk.c(cp2, ok.a);
            }
        }, e()) == null) {
            Cp cpG = g();
            i(CI2.a(25, 4, cpG));
            pk.c(cpG, ok.a);
        }
    }

    public final boolean b() {
        return (this.a != 2 || this.g == null || this.h == null) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:155:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(android.app.Activity r37, final defpackage.Ap r38) {
        /*
            Method dump skipped, instruction units count: 1391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tp.c(android.app.Activity, Ap):void");
    }

    public final void d(up upVar) {
        if (b()) {
            int i = AbstractC1659wF2.a;
            j(CI2.b(6));
            upVar.d(MI2.h);
            return;
        }
        int i2 = 1;
        if (this.a == 1) {
            AbstractC1659wF2.e("BillingClient", "Client is already in the process of connecting to billing service.");
            Cp cp = MI2.c;
            i(CI2.a(37, 6, cp));
            upVar.d(cp);
            return;
        }
        if (this.a == 3) {
            AbstractC1659wF2.e("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            Cp cp2 = MI2.i;
            i(CI2.a(38, 6, cp2));
            upVar.d(cp2);
            return;
        }
        this.a = 1;
        int i3 = AbstractC1659wF2.a;
        this.h = new jG2(this, upVar);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List<ResolveInfo> listQueryIntentServices = this.e.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            i2 = 41;
        } else {
            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
            if (serviceInfo != null) {
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if (!"com.android.vending".equals(str) || str2 == null) {
                    AbstractC1659wF2.e("BillingClient", "The device doesn't have valid Play Store.");
                    i2 = 40;
                } else {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    intent2.putExtra("playBillingLibraryVersion", this.b);
                    if (this.e.bindService(intent2, this.h, 1)) {
                        return;
                    }
                    AbstractC1659wF2.e("BillingClient", "Connection to Billing service is blocked.");
                    i2 = 39;
                }
            }
        }
        this.a = 0;
        Cp cp3 = MI2.b;
        i(CI2.a(i2, 6, cp3));
        upVar.d(cp3);
    }

    public final Handler e() {
        return Looper.myLooper() == null ? this.c : new Handler(Looper.myLooper());
    }

    public final void f(final Cp cp) {
        if (Thread.interrupted()) {
            return;
        }
        this.c.post(new Runnable() { // from class: t13
            @Override // java.lang.Runnable
            public final void run() {
                tp tpVar = this.t;
                Cp cp2 = cp;
                if (tpVar.d.b != null) {
                    tpVar.d.b.a(cp2, null);
                } else {
                    AbstractC1659wF2.e("BillingClient", "No valid listener is set in BroadcastManager");
                }
            }
        });
    }

    public final Cp g() {
        return (this.a == 0 || this.a == 3) ? MI2.i : MI2.g;
    }

    public final Future h(Callable callable, long j, final Runnable runnable, Handler handler) {
        if (this.w == null) {
            this.w = Executors.newFixedThreadPool(AbstractC1659wF2.a, new SE2());
        }
        try {
            final Future futureSubmit = this.w.submit(callable);
            handler.postDelayed(new Runnable() { // from class: M33
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = futureSubmit;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    future.cancel(true);
                    AbstractC1659wF2.e("BillingClient", "Async task is taking too long, cancel it!");
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, (long) (j * 0.95d));
            return futureSubmit;
        } catch (Exception e) {
            AbstractC1659wF2.f("BillingClient", "Async task throws exception!", e);
            return null;
        }
    }

    public final void i(OQ2 oq2) {
        WI2 wi2 = this.f;
        int i = this.j;
        wi2.getClass();
        try {
            VR2 vr2 = wi2.b;
            AbstractC1495tJ2 abstractC1495tJ2 = (AbstractC1495tJ2) vr2.k(5);
            if (!abstractC1495tJ2.t.equals(vr2)) {
                if (!abstractC1495tJ2.u.j()) {
                    abstractC1495tJ2.d();
                }
                AbstractC1495tJ2.e(abstractC1495tJ2.u, vr2);
            }
            SR2 sr2 = (SR2) abstractC1495tJ2;
            sr2.c();
            VR2.n((VR2) sr2.u, i);
            wi2.b = (VR2) sr2.a();
            wi2.a(oq2);
        } catch (Throwable th) {
            AbstractC1659wF2.f("BillingLogger", "Unable to log.", th);
        }
    }

    public final void j(C0412bR2 c0412bR2) {
        WI2 wi2 = this.f;
        int i = this.j;
        wi2.getClass();
        try {
            VR2 vr2 = wi2.b;
            AbstractC1495tJ2 abstractC1495tJ2 = (AbstractC1495tJ2) vr2.k(5);
            if (!abstractC1495tJ2.t.equals(vr2)) {
                if (!abstractC1495tJ2.u.j()) {
                    abstractC1495tJ2.d();
                }
                AbstractC1495tJ2.e(abstractC1495tJ2.u, vr2);
            }
            SR2 sr2 = (SR2) abstractC1495tJ2;
            sr2.c();
            VR2.n((VR2) sr2.u, i);
            wi2.b = (VR2) sr2.a();
            wi2.b(c0412bR2);
        } catch (Throwable th) {
            AbstractC1659wF2.f("BillingLogger", "Unable to log.", th);
        }
    }

    public final void k(int i, int i2, Cp cp) {
        C0412bR2 c0412bR2 = null;
        OQ2 oq2 = null;
        if (cp.a == 0) {
            int i3 = CI2.a;
            try {
                YQ2 yq2N = C0412bR2.n();
                yq2N.c();
                C0412bR2.m((C0412bR2) yq2N.u, 5);
                C1090mS2 c1090mS2M = JS2.m();
                c1090mS2M.c();
                JS2.l((JS2) c1090mS2M.u, i2);
                JS2 js2 = (JS2) c1090mS2M.a();
                yq2N.c();
                C0412bR2.l((C0412bR2) yq2N.u, js2);
                c0412bR2 = (C0412bR2) yq2N.a();
            } catch (Exception e) {
                AbstractC1659wF2.f("BillingLogger", "Unable to create logging payload", e);
            }
            j(c0412bR2);
            return;
        }
        int i4 = CI2.a;
        try {
            xQ2 xq2P = OQ2.p();
            C0708gR2 c0708gR2P = qR2.p();
            int i5 = cp.a;
            c0708gR2P.c();
            qR2.l((qR2) c0708gR2P.u, i5);
            String str = cp.b;
            c0708gR2P.c();
            qR2.m((qR2) c0708gR2P.u, str);
            c0708gR2P.c();
            qR2.o((qR2) c0708gR2P.u, i);
            xq2P.c();
            OQ2.m((OQ2) xq2P.u, (qR2) c0708gR2P.a());
            xq2P.c();
            OQ2.o((OQ2) xq2P.u, 5);
            C1090mS2 c1090mS2M2 = JS2.m();
            c1090mS2M2.c();
            JS2.l((JS2) c1090mS2M2.u, i2);
            JS2 js22 = (JS2) c1090mS2M2.a();
            xq2P.c();
            OQ2.n((OQ2) xq2P.u, js22);
            oq2 = (OQ2) xq2P.a();
        } catch (Exception e2) {
            AbstractC1659wF2.f("BillingLogger", "Unable to create logging payload", e2);
        }
        i(oq2);
    }
}
