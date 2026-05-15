package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class SV extends F80 implements Executor {
    public static final SV u = new SV();
    public static final pF0 v;

    static {
        C0434bk2 c0434bk2 = C0434bk2.u;
        int i = AbstractC1563uU1.a;
        if (64 >= i) {
            i = 64;
        }
        v = (pF0) c0434bk2.e(AbstractC1511tU1.b(i, 0, 0, 12, "kotlinx.coroutines.io.parallelism"));
    }

    @Override // defpackage.AbstractC0771hO
    public final void c(InterfaceC0577eO interfaceC0577eO, Runnable runnable) {
        v.c(interfaceC0577eO, runnable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // defpackage.AbstractC0771hO
    public final AbstractC0771hO e(int i) {
        return C0434bk2.u.e(1);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        c(R60.t, runnable);
    }

    @Override // defpackage.AbstractC0771hO
    public final String toString() {
        return "Dispatchers.IO";
    }

    @Override // defpackage.F80
    public final Executor k() {
        return this;
    }
}
