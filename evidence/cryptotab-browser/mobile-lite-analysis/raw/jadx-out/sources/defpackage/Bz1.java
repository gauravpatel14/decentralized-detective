package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Bz1 extends F80 {
    public mO u;

    @Override // defpackage.AbstractC0771hO
    public final void c(InterfaceC0577eO interfaceC0577eO, Runnable runnable) {
        mO mOVar = this.u;
        AtomicLongFieldUpdater atomicLongFieldUpdater = mO.z;
        mOVar.b(runnable, Z62.f, false);
    }

    @Override // defpackage.F80
    public final Executor k() {
        return this.u;
    }
}
