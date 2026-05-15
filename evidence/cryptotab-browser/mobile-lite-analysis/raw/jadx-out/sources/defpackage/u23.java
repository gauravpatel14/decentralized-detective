package defpackage;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class u23 extends WeakReference {
    public final int a;

    public u23(Throwable th, ReferenceQueue referenceQueue) {
        super(th, referenceQueue);
        this.a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == u23.class) {
            if (this == obj) {
                return true;
            }
            u23 u23Var = (u23) obj;
            if (this.a == u23Var.a && get() == u23Var.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.a;
    }
}
