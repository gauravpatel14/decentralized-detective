package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class zz0 extends SA0 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater y = AtomicIntegerFieldUpdater.newUpdater(zz0.class, "_invoked");
    private volatile /* synthetic */ int _invoked = 0;
    public final InterfaceC0926jk0 x;

    public zz0(InterfaceC0926jk0 interfaceC0926jk0) {
        this.x = interfaceC0926jk0;
    }

    @Override // defpackage.InterfaceC0926jk0
    public final /* bridge */ /* synthetic */ Object j(Object obj) {
        x((Throwable) obj);
        return C0302Yj2.a;
    }

    @Override // defpackage.UA0
    public final void x(Throwable th) {
        if (y.compareAndSet(this, 0, 1)) {
            this.x.j(th);
        }
    }
}
