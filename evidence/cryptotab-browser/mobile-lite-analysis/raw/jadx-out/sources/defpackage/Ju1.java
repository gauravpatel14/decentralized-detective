package defpackage;

import android.os.Handler;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Ju1 implements Runnable {
    public CallableC0664fh0 t;
    public C0729gh0 u;
    public Handler v;

    @Override // java.lang.Runnable
    public final void run() {
        Object objCall;
        try {
            objCall = this.t.call();
        } catch (Exception unused) {
            objCall = null;
        }
        this.v.post(new Iu1(this.u, objCall));
    }
}
