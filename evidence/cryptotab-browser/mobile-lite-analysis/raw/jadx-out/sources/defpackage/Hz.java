package defpackage;

import java.util.ArrayDeque;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Hz implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ C0619fA u;
    public final /* synthetic */ Iz v;

    public /* synthetic */ Hz(Iz iz, C0619fA c0619fA, int i) {
        this.t = i;
        this.v = iz;
        this.u = c0619fA;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        switch (this.t) {
            case 0:
                this.v.a.a(this.u);
                break;
            default:
                Mz mz = this.v.b;
                mz.d(this.u);
                ArrayDeque arrayDeque = mz.b;
                if (!arrayDeque.isEmpty()) {
                    ((Runnable) arrayDeque.remove()).run();
                    if (!arrayDeque.isEmpty() && (runnable = mz.a) != null) {
                        runnable.run();
                        break;
                    }
                }
                break;
        }
    }
}
