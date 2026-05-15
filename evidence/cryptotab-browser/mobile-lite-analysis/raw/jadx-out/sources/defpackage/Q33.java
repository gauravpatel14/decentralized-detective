package defpackage;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Q33 implements Runnable {
    public final /* synthetic */ C0939k33 t;
    public final /* synthetic */ Callable u;

    public Q33(C0939k33 c0939k33, Callable callable) {
        this.t = c0939k33;
        this.u = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0939k33 c0939k33 = this.t;
        try {
            c0939k33.p(this.u.call());
        } catch (Exception e) {
            c0939k33.o(e);
        } catch (Throwable th) {
            c0939k33.o(new RuntimeException(th));
        }
    }
}
