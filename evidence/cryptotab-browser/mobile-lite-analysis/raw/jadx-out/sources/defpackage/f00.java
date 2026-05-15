package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class f00 extends Kz1 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater w = AtomicIntegerFieldUpdater.newUpdater(f00.class, "_decision");
    private volatile /* synthetic */ int _decision;

    public f00(InterfaceC1670wN interfaceC1670wN, InterfaceC0577eO interfaceC0577eO) {
        super(interfaceC0577eO, (yN) interfaceC1670wN);
        this._decision = 0;
    }

    public final Object N() throws Throwable {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                Object objA = ZA0.a(x());
                if (objA instanceof OH) {
                    throw ((OH) objA).a;
                }
                return objA;
            }
        } while (!w.compareAndSet(this, 0, 1));
        return pO.t;
    }

    @Override // defpackage.Kz1, defpackage.YA0
    public final void e(Object obj) {
        f(obj);
    }

    @Override // defpackage.Kz1, defpackage.YA0
    public final void f(Object obj) {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                AbstractC0554e00.a(oz0.b(this.v), QH.a(obj), null);
                return;
            }
        } while (!w.compareAndSet(this, 0, 2));
    }
}
