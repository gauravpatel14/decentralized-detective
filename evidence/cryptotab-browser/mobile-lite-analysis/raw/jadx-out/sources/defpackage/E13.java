package defpackage;

import java.util.ArrayDeque;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class E13 {
    public final Object a = new Object();
    public ArrayDeque b;
    public boolean c;

    public final void a(r13 r13Var) {
        synchronized (this.a) {
            try {
                if (this.b == null) {
                    this.b = new ArrayDeque();
                }
                this.b.add(r13Var);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(G62 g62) {
        r13 r13Var;
        synchronized (this.a) {
            if (this.b != null && !this.c) {
                this.c = true;
                while (true) {
                    synchronized (this.a) {
                        try {
                            r13Var = (r13) this.b.poll();
                            if (r13Var == null) {
                                this.c = false;
                                return;
                            }
                        } finally {
                        }
                    }
                    r13Var.b(g62);
                }
            }
        }
    }
}
