package defpackage;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: renamed from: gW2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0715gW2 implements Runnable {
    public final /* synthetic */ G62 t;
    public final /* synthetic */ C1853zX2 u;

    public RunnableC0715gW2(C1853zX2 c1853zX2, G62 g62) {
        this.u = c1853zX2;
        this.t = g62;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.u.b) {
            try {
                Q41 q41 = this.u.c;
                if (q41 != null) {
                    q41.d((Exception) Preconditions.checkNotNull(this.t.g()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
