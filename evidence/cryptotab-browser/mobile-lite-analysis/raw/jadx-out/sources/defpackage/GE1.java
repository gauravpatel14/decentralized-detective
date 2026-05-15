package defpackage;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class GE1 extends X62 implements FE1 {
    public AtomicInteger l;
    public volatile boolean m;

    @Override // defpackage.X62
    public final void c() {
        this.m = true;
        if (this.l.getAndIncrement() == 0) {
            super.c();
        }
    }

    @Override // defpackage.X62
    public final void g() {
        super.g();
        if (this.l.decrementAndGet() > 0) {
            if (this.m) {
                super.c();
            } else {
                super.i();
            }
        }
    }

    @Override // defpackage.X62
    public final void i() {
        if (this.l.getAndIncrement() == 0) {
            super.i();
        }
    }
}
