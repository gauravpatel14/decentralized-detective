package defpackage;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: rV2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1395rV2 extends WeakReference {
    public final int a;

    public C1395rV2(Throwable th, ReferenceQueue referenceQueue) {
        super(th, referenceQueue);
        this.a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == C1395rV2.class) {
            if (this == obj) {
                return true;
            }
            C1395rV2 c1395rV2 = (C1395rV2) obj;
            if (this.a == c1395rV2.a && get() == c1395rV2.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.a;
    }
}
