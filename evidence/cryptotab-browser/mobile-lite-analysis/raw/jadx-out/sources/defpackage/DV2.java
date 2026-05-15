package defpackage;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzq;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class DV2 implements Runnable {
    public final /* synthetic */ AtomicReference t;
    public final /* synthetic */ zzq u;
    public final /* synthetic */ CW2 v;

    public DV2(CW2 cw2, AtomicReference atomicReference, zzq zzqVar) {
        this.v = cw2;
        this.t = atomicReference;
        this.u = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        TP2 tp2;
        synchronized (this.t) {
            try {
                try {
                    tp2 = this.v.a.h;
                    C1391rR2.i(tp2);
                } catch (RemoteException e) {
                    WO2 wo2 = this.v.a.i;
                    C1391rR2.k(wo2);
                    wo2.f.b(e, "Failed to get app instance id");
                    atomicReference = this.t;
                }
                if (!tp2.l().f(EnumC1486tD2.ANALYTICS_STORAGE)) {
                    WO2 wo22 = this.v.a.i;
                    C1391rR2.k(wo22);
                    wo22.k.a("Analytics storage consent denied; will not get app instance id");
                    IU2 iu2 = this.v.a.p;
                    C1391rR2.j(iu2);
                    iu2.g.set(null);
                    TP2 tp22 = this.v.a.h;
                    C1391rR2.i(tp22);
                    tp22.f.b(null);
                    this.t.set(null);
                    return;
                }
                CW2 cw2 = this.v;
                InterfaceC1086mO2 interfaceC1086mO2 = cw2.d;
                if (interfaceC1086mO2 == null) {
                    WO2 wo23 = cw2.a.i;
                    C1391rR2.k(wo23);
                    wo23.f.a("Failed to get app instance id");
                    return;
                }
                Preconditions.checkNotNull(this.u);
                this.t.set(interfaceC1086mO2.S(this.u));
                String str = (String) this.t.get();
                if (str != null) {
                    IU2 iu22 = this.v.a.p;
                    C1391rR2.j(iu22);
                    iu22.g.set(str);
                    TP2 tp23 = this.v.a.h;
                    C1391rR2.i(tp23);
                    tp23.f.b(str);
                }
                this.v.r();
                atomicReference = this.t;
                atomicReference.notify();
            } finally {
                this.t.notify();
            }
        }
    }
}
