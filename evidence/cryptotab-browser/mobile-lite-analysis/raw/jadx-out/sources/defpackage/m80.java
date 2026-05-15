package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m80 implements Runnable, Comparable, L00 {
    private volatile Object _heap;
    public long t;
    public int u;

    public final synchronized int a(long j, n80 n80Var, o80 o80Var) {
        if (this._heap == q80.a) {
            return 2;
        }
        synchronized (n80Var) {
            try {
                m80[] m80VarArr = n80Var.a;
                m80 m80Var = m80VarArr != null ? m80VarArr[0] : null;
                if (o80.E(o80Var)) {
                    return 1;
                }
                if (m80Var == null) {
                    n80Var.b = j;
                } else {
                    long j2 = m80Var.t;
                    if (j2 - j < 0) {
                        j = j2;
                    }
                    if (j - n80Var.b > 0) {
                        n80Var.b = j;
                    }
                }
                long j3 = this.t;
                long j4 = n80Var.b;
                if (j3 - j4 < 0) {
                    this.t = j4;
                }
                n80Var.a(this);
                return 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(n80 n80Var) {
        if (this._heap == q80.a) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this._heap = n80Var;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j = this.t - ((m80) obj).t;
        if (j > 0) {
            return 1;
        }
        return j < 0 ? -1 : 0;
    }

    @Override // defpackage.L00
    public final synchronized void d() {
        try {
            Object obj = this._heap;
            eT1 et1 = q80.a;
            if (obj == et1) {
                return;
            }
            n80 n80Var = obj instanceof n80 ? (n80) obj : null;
            if (n80Var != null) {
                synchronized (n80Var) {
                    Object obj2 = this._heap;
                    if ((obj2 instanceof Z82 ? (Z82) obj2 : null) != null) {
                        n80Var.c(this.u);
                    }
                }
            }
            this._heap = et1;
        } catch (Throwable th) {
            throw th;
        }
    }

    public String toString() {
        return "Delayed[nanos=" + this.t + ']';
    }
}
