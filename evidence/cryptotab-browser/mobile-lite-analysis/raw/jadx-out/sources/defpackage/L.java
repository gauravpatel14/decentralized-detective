package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class L extends G {
    @Override // defpackage.G
    public final boolean a(N n, J j, J j2) {
        synchronized (n) {
            try {
                if (n.u != j) {
                    return false;
                }
                n.u = j2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.G
    public final boolean b(N n, Object obj, Object obj2) {
        synchronized (n) {
            try {
                if (n.t != obj) {
                    return false;
                }
                n.t = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.G
    public final boolean c(N n, M m, M m2) {
        synchronized (n) {
            try {
                if (n.v != m) {
                    return false;
                }
                n.v = m2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.G
    public final void d(M m, M m2) {
        m.b = m2;
    }

    @Override // defpackage.G
    public final void e(M m, Thread thread) {
        m.a = thread;
    }
}
