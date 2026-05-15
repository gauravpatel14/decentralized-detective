package defpackage;

import org.chromium.base.Callback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Yw implements Xw, Callback {
    public Callback t;
    public final /* synthetic */ C0384ax u;

    public Yw(C0384ax c0384ax, Callback callback) {
        this.u = c0384ax;
        this.t = callback;
    }

    @Override // defpackage.Xw
    public final void cancel() {
        this.t = null;
    }

    @Override // org.chromium.base.Callback
    /* JADX INFO: renamed from: onResult */
    public final void a0(Object obj) {
        synchronized (this.u) {
            try {
                Callback callback = this.t;
                if (callback != null) {
                    callback.a0(obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
