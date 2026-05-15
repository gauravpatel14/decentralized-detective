package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class QI0 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(QI0.class, Object.class, "_cur");
    private volatile /* synthetic */ Object _cur = new SI0(8, false);

    public final boolean a(Runnable runnable) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        while (true) {
            SI0 si0 = (SI0) this._cur;
            int iA = si0.a(runnable);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                SI0 si0E = si0.e();
                do {
                    atomicReferenceFieldUpdater = a;
                    if (atomicReferenceFieldUpdater.compareAndSet(this, si0, si0E)) {
                        break;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == si0);
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            SI0 si0 = (SI0) this._cur;
            if (si0.b()) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            SI0 si0E = si0.e();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, si0, si0E) && atomicReferenceFieldUpdater.get(this) == si0) {
            }
        }
    }

    public final int c() {
        return ((SI0) this._cur).c();
    }

    public final Object d() {
        while (true) {
            SI0 si0 = (SI0) this._cur;
            Object objF = si0.f();
            if (objF != SI0.g) {
                return objF;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            SI0 si0E = si0.e();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, si0, si0E) && atomicReferenceFieldUpdater.get(this) == si0) {
            }
        }
    }
}
