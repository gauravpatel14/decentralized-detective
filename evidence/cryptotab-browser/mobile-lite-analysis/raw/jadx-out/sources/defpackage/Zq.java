package defpackage;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Zq extends u {
    public final Thread v;
    public final p80 w;

    public Zq(InterfaceC0577eO interfaceC0577eO, Thread thread, p80 p80Var) {
        super(interfaceC0577eO, true);
        this.v = thread;
        this.w = p80Var;
    }

    @Override // defpackage.YA0
    public final void e(Object obj) {
        Thread threadCurrentThread = Thread.currentThread();
        Thread thread = this.v;
        if (lz0.a(threadCurrentThread, thread)) {
            return;
        }
        LockSupport.unpark(thread);
    }
}
