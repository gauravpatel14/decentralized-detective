package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: eV2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0585eV2 implements r13 {
    public final Executor a;
    public final Object b = new Object();
    public N41 c;

    public C0585eV2(Executor executor, N41 n41) {
        this.a = executor;
        this.c = n41;
    }

    @Override // defpackage.r13
    public final void b(G62 g62) {
        synchronized (this.b) {
            try {
                if (this.c == null) {
                    return;
                }
                this.a.execute(new PT2(this, g62));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.r13
    public final void zzc() {
        synchronized (this.b) {
            this.c = null;
        }
    }
}
