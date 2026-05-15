package defpackage;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Wx1 implements lE0, Serializable {
    public static final AtomicReferenceFieldUpdater v = AtomicReferenceFieldUpdater.newUpdater(Wx1.class, Object.class, "u");
    public volatile RC0 t;
    public volatile Object u;

    /* JADX WARN: Type inference failed for: r0v1, types: [RC0, hk0] */
    @Override // defpackage.lE0
    public final Object getValue() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj = this.u;
        C0797hj2 c0797hj2 = C0797hj2.a;
        if (obj != c0797hj2) {
            return obj;
        }
        ?? r0 = this.t;
        if (r0 != 0) {
            Object objC = r0.c();
            do {
                atomicReferenceFieldUpdater = v;
                if (atomicReferenceFieldUpdater.compareAndSet(this, c0797hj2, objC)) {
                    this.t = null;
                    return objC;
                }
            } while (atomicReferenceFieldUpdater.get(this) == c0797hj2);
        }
        return this.u;
    }

    public final String toString() {
        return this.u != C0797hj2.a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
