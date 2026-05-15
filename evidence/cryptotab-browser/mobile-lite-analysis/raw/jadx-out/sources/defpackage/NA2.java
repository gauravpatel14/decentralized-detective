package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.a;
import com.google.android.gms.common.api.internal.zabz;
import java.util.concurrent.locks.Lock;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class NA2 implements zabz {
    public final /* synthetic */ a a;

    public /* synthetic */ NA2(a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zaa(ConnectionResult connectionResult) {
        a aVar = this.a;
        aVar.F.lock();
        try {
            aVar.C = connectionResult;
            a.d(aVar);
        } finally {
            aVar.F.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zab(Bundle bundle) {
        a aVar = this.a;
        aVar.F.lock();
        try {
            Bundle bundle2 = aVar.B;
            if (bundle2 == null) {
                aVar.B = bundle;
            } else if (bundle != null) {
                bundle2.putAll(bundle);
            }
            aVar.C = ConnectionResult.RESULT_SUCCESS;
            a.d(aVar);
        } finally {
            aVar.F.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zac(int i, boolean z) {
        ConnectionResult connectionResult;
        a aVar = this.a;
        Lock lock = aVar.F;
        Lock lock2 = aVar.F;
        lock.lock();
        try {
            if (aVar.E || (connectionResult = aVar.D) == null || !connectionResult.isSuccess()) {
                aVar.E = false;
                aVar.u.zac(i, z);
                aVar.D = null;
                aVar.C = null;
            } else {
                aVar.E = true;
                aVar.x.onConnectionSuspended(i);
            }
            lock2.unlock();
        } catch (Throwable th) {
            lock2.unlock();
            throw th;
        }
    }
}
