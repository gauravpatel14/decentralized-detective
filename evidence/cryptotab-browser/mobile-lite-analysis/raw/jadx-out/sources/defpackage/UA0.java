package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class UA0 extends PI0 implements L00, Vv0, InterfaceC0926jk0 {
    public YA0 w;

    @Override // defpackage.Vv0
    public final boolean a() {
        return true;
    }

    @Override // defpackage.PI0, defpackage.L00
    public final void d() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        YA0 ya0W = w();
        while (true) {
            Object objX = ya0W.x();
            if (!(objX instanceof UA0)) {
                if (!(objX instanceof Vv0) || ((Vv0) objX).k() == null) {
                    return;
                }
                t();
                return;
            }
            if (objX != this) {
                return;
            }
            K60 k60 = ZA0.g;
            do {
                atomicReferenceFieldUpdater = YA0.t;
                if (atomicReferenceFieldUpdater.compareAndSet(ya0W, objX, k60)) {
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(ya0W) == objX);
        }
    }

    @Override // defpackage.Vv0
    public final m01 k() {
        return null;
    }

    @Override // defpackage.PI0
    public final String toString() {
        return getClass().getSimpleName() + '@' + hV.a(this) + "[job@" + hV.a(w()) + ']';
    }

    public final YA0 w() {
        YA0 ya0 = this.w;
        if (ya0 != null) {
            return ya0;
        }
        lz0.c("job");
        throw null;
    }

    public abstract void x(Throwable th);
}
