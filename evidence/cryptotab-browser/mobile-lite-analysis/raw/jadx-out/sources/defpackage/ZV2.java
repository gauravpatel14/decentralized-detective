package defpackage;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ZV2 implements Runnable {
    public final /* synthetic */ InterfaceC1086mO2 t;
    public final /* synthetic */ AW2 u;

    public ZV2(AW2 aw2, InterfaceC1086mO2 interfaceC1086mO2) {
        this.u = aw2;
        this.t = interfaceC1086mO2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.u) {
            try {
                this.u.t = false;
                if (!this.u.v.m()) {
                    WO2 wo2 = this.u.v.a.i;
                    C1391rR2.k(wo2);
                    wo2.n.a("Connected to service");
                    CW2 cw2 = this.u.v;
                    InterfaceC1086mO2 interfaceC1086mO2 = this.t;
                    cw2.g();
                    Preconditions.checkNotNull(interfaceC1086mO2);
                    cw2.d = interfaceC1086mO2;
                    cw2.r();
                    cw2.q();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
