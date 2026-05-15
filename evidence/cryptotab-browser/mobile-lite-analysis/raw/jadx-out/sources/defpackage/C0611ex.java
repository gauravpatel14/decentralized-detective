package defpackage;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: ex, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0611ex implements InterfaceFutureC1199oH0 {
    public final WeakReference t;
    public final dx u = new dx(this);

    public C0611ex(C0440bx c0440bx) {
        this.t = new WeakReference(c0440bx);
    }

    @Override // defpackage.InterfaceFutureC1199oH0
    public final void a(Runnable runnable, Executor executor) {
        this.u.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        C0440bx c0440bx = (C0440bx) this.t.get();
        boolean zCancel = this.u.cancel(z);
        if (zCancel && c0440bx != null) {
            c0440bx.a = null;
            c0440bx.b = null;
            c0440bx.c.i(null);
        }
        return zCancel;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.u.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.u.t instanceof H;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.u.isDone();
    }

    public final String toString() {
        return this.u.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        return this.u.get(j, timeUnit);
    }
}
