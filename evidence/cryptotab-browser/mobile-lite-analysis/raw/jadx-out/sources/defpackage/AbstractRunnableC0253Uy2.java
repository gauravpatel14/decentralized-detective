package defpackage;

import com.google.android.gms.common.api.internal.zaaw;

/* JADX INFO: renamed from: Uy2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractRunnableC0253Uy2 implements Runnable {
    public final /* synthetic */ zaaw t;

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        zaaw zaawVar = this.t;
        zaawVar.zab.lock();
        try {
            try {
                if (!Thread.interrupted()) {
                    a();
                }
            } catch (RuntimeException e) {
                zaawVar.zaa.zam(e);
            }
        } finally {
            zaawVar.zab.unlock();
        }
    }
}
