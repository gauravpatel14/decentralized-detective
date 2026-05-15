package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BK2 implements r13 {
    public final Executor a;
    public final xN b;
    public final C0939k33 c;

    public BK2(Executor executor, xN xNVar, C0939k33 c0939k33) {
        this.a = executor;
        this.b = xNVar;
        this.c = c0939k33;
    }

    @Override // defpackage.r13
    public final void b(G62 g62) {
        this.a.execute(new RunnableC0343aI2(this, g62));
    }

    @Override // defpackage.r13
    public final void zzc() {
        throw new UnsupportedOperationException();
    }
}
