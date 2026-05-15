package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class jG2 implements ServiceConnection {
    public final Object t = new Object();
    public final up u;
    public final /* synthetic */ tp v;

    public /* synthetic */ jG2(tp tpVar, up upVar) {
        this.v = tpVar;
        this.u = upVar;
    }

    public final void a(Cp cp) {
        synchronized (this.t) {
            try {
                up upVar = this.u;
                if (upVar != null) {
                    upVar.d(cp);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        InterfaceC0818i23 c1304q13;
        int i = AbstractC1659wF2.a;
        tp tpVar = this.v;
        int i2 = T13.t;
        if (iBinder == null) {
            c1304q13 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
            c1304q13 = iInterfaceQueryLocalInterface instanceof InterfaceC0818i23 ? (InterfaceC0818i23) iInterfaceQueryLocalInterface : new C1304q13(iBinder);
        }
        tpVar.g = c1304q13;
        Callable callable = new Callable() { // from class: qF2
            /* JADX WARN: Removed duplicated region for block: B:101:0x0165  */
            /* JADX WARN: Removed duplicated region for block: B:107:0x0188  */
            @Override // java.util.concurrent.Callable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object call() {
                /*
                    Method dump skipped, instruction units count: 533
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: defpackage.CallableC1316qF2.call():java.lang.Object");
            }
        };
        Runnable runnable = new Runnable() { // from class: XF2
            @Override // java.lang.Runnable
            public final void run() {
                jG2 jg2 = this.t;
                jg2.v.a = 0;
                jg2.v.g = null;
                Cp cp = MI2.j;
                jg2.v.i(CI2.a(24, 6, cp));
                jg2.a(cp);
            }
        };
        tp tpVar2 = this.v;
        if (tpVar2.h(callable, 30000L, runnable, tpVar2.e()) == null) {
            tp tpVar3 = this.v;
            Cp cpG = tpVar3.g();
            tpVar3.i(CI2.a(25, 6, cpG));
            a(cpG);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        AbstractC1659wF2.e("BillingClient", "Billing service disconnected.");
        WI2 wi2 = this.v.f;
        C1029lT2 c1029lT2L = C1029lT2.l();
        wi2.getClass();
        if (c1029lT2L != null) {
            try {
                PS2 ps2P = TS2.p();
                VR2 vr2 = wi2.b;
                ps2P.c();
                TS2.m((TS2) ps2P.u, vr2);
                ps2P.c();
                TS2.l((TS2) ps2P.u, c1029lT2L);
                wi2.c.a((TS2) ps2P.a());
            } catch (Throwable th) {
                AbstractC1659wF2.f("BillingLogger", "Unable to log.", th);
            }
        }
        this.v.g = null;
        this.v.a = 0;
        synchronized (this.t) {
            this.u.e();
        }
    }
}
