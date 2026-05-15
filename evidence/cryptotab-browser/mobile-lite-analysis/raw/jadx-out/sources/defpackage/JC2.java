package defpackage;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class JC2 implements U41, Q41, L41 {
    public final CountDownLatch a = new CountDownLatch(1);

    @Override // defpackage.U41
    public final void a(Object obj) {
        this.a.countDown();
    }

    @Override // defpackage.L41
    public final void c() {
        this.a.countDown();
    }

    @Override // defpackage.Q41
    public final void d(Exception exc) {
        this.a.countDown();
    }
}
