package defpackage;

/* JADX INFO: renamed from: qS2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1332qS2 implements r13 {
    public final ExecutorC1709x23 a;
    public final Object b = new Object();
    public L41 c;

    public C1332qS2(ExecutorC1709x23 executorC1709x23, L41 l41) {
        this.a = executorC1709x23;
        this.c = l41;
    }

    @Override // defpackage.r13
    public final void b(G62 g62) {
        if (((C0939k33) g62).d) {
            synchronized (this.b) {
                try {
                    if (this.c == null) {
                        return;
                    }
                    this.a.getClass();
                    synchronized (this.b) {
                        try {
                            L41 l41 = this.c;
                            if (l41 != null) {
                                l41.c();
                            }
                        } finally {
                        }
                    }
                } finally {
                }
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
