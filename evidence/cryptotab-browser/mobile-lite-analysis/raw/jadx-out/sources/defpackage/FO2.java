package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class FO2 implements U41, Q41, L41, r13 {
    public final Executor a;
    public final xN b;
    public final C0939k33 c;

    public FO2(Executor executor, xN xNVar, C0939k33 c0939k33) {
        this.a = executor;
        this.b = xNVar;
        this.c = c0939k33;
    }

    @Override // defpackage.U41
    public final void a(Object obj) {
        this.c.p(obj);
    }

    @Override // defpackage.r13
    public final void b(G62 g62) {
        this.a.execute(new ZM2(this, g62));
    }

    @Override // defpackage.L41
    public final void c() {
        this.c.q();
    }

    @Override // defpackage.Q41
    public final void d(Exception exc) {
        this.c.o(exc);
    }

    @Override // defpackage.r13
    public final void zzc() {
        throw new UnsupportedOperationException();
    }
}
