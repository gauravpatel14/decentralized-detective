package defpackage;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.DuplicateTaskCompletionException;
import com.google.android.gms.tasks.RuntimeExecutionException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: k33, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0939k33 extends G62 {
    public final Object a = new Object();
    public final E13 b = new E13();
    public boolean c;
    public volatile boolean d;
    public Object e;
    public Exception f;

    @Override // defpackage.G62
    public final C0939k33 a(N41 n41) {
        this.b.a(new C0585eV2(K62.a, n41));
        s();
        return this;
    }

    @Override // defpackage.G62
    public final C0939k33 b(Q41 q41) {
        c(K62.a, q41);
        return this;
    }

    @Override // defpackage.G62
    public final C0939k33 c(Executor executor, Q41 q41) {
        this.b.a(new C1853zX2(executor, q41));
        s();
        return this;
    }

    @Override // defpackage.G62
    public final C0939k33 d(U41 u41) {
        e(K62.a, u41);
        return this;
    }

    @Override // defpackage.G62
    public final C0939k33 e(Executor executor, U41 u41) {
        this.b.a(new RY2(executor, u41));
        s();
        return this;
    }

    @Override // defpackage.G62
    public final C0939k33 f(Executor executor, xN xNVar) {
        C0939k33 c0939k33 = new C0939k33();
        this.b.a(new BK2(executor, xNVar, c0939k33));
        s();
        return c0939k33;
    }

    @Override // defpackage.G62
    public final Exception g() {
        Exception exc;
        synchronized (this.a) {
            exc = this.f;
        }
        return exc;
    }

    @Override // defpackage.G62
    public final Object h() {
        Object obj;
        synchronized (this.a) {
            try {
                Preconditions.checkState(this.c, "Task is not yet complete");
                if (this.d) {
                    throw new CancellationException("Task is already canceled.");
                }
                Exception exc = this.f;
                if (exc != null) {
                    throw new RuntimeExecutionException(exc);
                }
                obj = this.e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    @Override // defpackage.G62
    public final Object i(Class cls) {
        Object obj;
        synchronized (this.a) {
            try {
                Preconditions.checkState(this.c, "Task is not yet complete");
                if (this.d) {
                    throw new CancellationException("Task is already canceled.");
                }
                if (cls.isInstance(this.f)) {
                    throw ((Throwable) cls.cast(this.f));
                }
                Exception exc = this.f;
                if (exc != null) {
                    throw new RuntimeExecutionException(exc);
                }
                obj = this.e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    @Override // defpackage.G62
    public final boolean j() {
        boolean z;
        synchronized (this.a) {
            z = this.c;
        }
        return z;
    }

    @Override // defpackage.G62
    public final boolean k() {
        boolean z;
        synchronized (this.a) {
            try {
                z = false;
                if (this.c && !this.d && this.f == null) {
                    z = true;
                }
            } finally {
            }
        }
        return z;
    }

    @Override // defpackage.G62
    public final C0939k33 l(InterfaceC1507tR1 interfaceC1507tR1) {
        L23 l23 = K62.a;
        C0939k33 c0939k33 = new C0939k33();
        this.b.a(new D03(l23, interfaceC1507tR1, c0939k33));
        s();
        return c0939k33;
    }

    public final C0939k33 m(Executor executor, N41 n41) {
        this.b.a(new C0585eV2(executor, n41));
        s();
        return this;
    }

    public final C0939k33 n(Executor executor, xN xNVar) {
        C0939k33 c0939k33 = new C0939k33();
        this.b.a(new FO2(executor, xNVar, c0939k33));
        s();
        return c0939k33;
    }

    public final void o(Exception exc) {
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.a) {
            r();
            this.c = true;
            this.f = exc;
        }
        this.b.b(this);
    }

    public final void p(Object obj) {
        synchronized (this.a) {
            r();
            this.c = true;
            this.e = obj;
        }
        this.b.b(this);
    }

    public final void q() {
        synchronized (this.a) {
            try {
                if (this.c) {
                    return;
                }
                this.c = true;
                this.d = true;
                this.b.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void r() {
        if (this.c) {
            int i = DuplicateTaskCompletionException.t;
            if (!j()) {
                throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
            }
            Exception excG = g();
        }
    }

    public final void s() {
        synchronized (this.a) {
            try {
                if (this.c) {
                    this.b.b(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
