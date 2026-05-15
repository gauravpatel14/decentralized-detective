package defpackage;

import com.google.android.gms.common.api.internal.a;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class KA2 implements Runnable {
    public final /* synthetic */ a t;

    public KA2(a aVar) {
        this.t = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar = this.t;
        aVar.F.lock();
        try {
            a.d(aVar);
        } finally {
            aVar.F.unlock();
        }
    }
}
