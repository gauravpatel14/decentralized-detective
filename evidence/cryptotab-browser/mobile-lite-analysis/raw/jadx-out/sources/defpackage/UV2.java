package defpackage;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzq;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class UV2 implements Runnable {
    public final /* synthetic */ AtomicReference t;
    public final /* synthetic */ String u;
    public final /* synthetic */ String v;
    public final /* synthetic */ zzq w;
    public final /* synthetic */ CW2 x;

    public UV2(CW2 cw2, AtomicReference atomicReference, String str, String str2, zzq zzqVar) {
        this.x = cw2;
        this.t = atomicReference;
        this.u = str;
        this.v = str2;
        this.w = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        CW2 cw2;
        InterfaceC1086mO2 interfaceC1086mO2;
        synchronized (this.t) {
            try {
                try {
                    cw2 = this.x;
                    interfaceC1086mO2 = cw2.d;
                } catch (RemoteException e) {
                    WO2 wo2 = this.x.a.i;
                    C1391rR2.k(wo2);
                    wo2.f.d("(legacy) Failed to get conditional properties; remote exception", null, this.u, e);
                    this.t.set(Collections.emptyList());
                    atomicReference = this.t;
                }
                if (interfaceC1086mO2 == null) {
                    WO2 wo22 = cw2.a.i;
                    C1391rR2.k(wo22);
                    wo22.f.d("(legacy) Failed to get conditional properties; not connected to service", null, this.u, this.v);
                    this.t.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(null)) {
                    Preconditions.checkNotNull(this.w);
                    this.t.set(interfaceC1086mO2.T0(this.u, this.v, this.w));
                } else {
                    this.t.set(interfaceC1086mO2.d0(null, this.u, this.v));
                }
                this.x.r();
                atomicReference = this.t;
                atomicReference.notify();
            } finally {
                this.t.notify();
            }
        }
    }
}
