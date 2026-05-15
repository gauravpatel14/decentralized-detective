package defpackage;

import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Kk0 implements Runnable {
    public final InterfaceFutureC1199oH0 t;
    public final Jk0 u;

    public Kk0(InterfaceFutureC1199oH0 interfaceFutureC1199oH0, Jk0 jk0) {
        this.t = interfaceFutureC1199oH0;
        this.u = jk0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Jk0 jk0 = this.u;
        try {
            jk0.a(Lk0.a(this.t));
        } catch (Error e) {
            e = e;
            jk0.b(e);
        } catch (RuntimeException e2) {
            e = e2;
            jk0.b(e);
        } catch (ExecutionException e3) {
            jk0.b(e3.getCause());
        }
    }

    public final String toString() {
        MU0 mu0 = new MU0(Kk0.class.getSimpleName());
        LU0 lu0 = new LU0();
        mu0.c.b = lu0;
        mu0.c = lu0;
        lu0.a = this.u;
        return mu0.toString();
    }
}
