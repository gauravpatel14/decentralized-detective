package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NI0 extends AbstractC1630vg {
    public final PI0 b;
    public LI0 c;

    public NI0(PI0 pi0) {
        this.b = pi0;
    }

    @Override // defpackage.AbstractC1630vg
    public final void b(Object obj, Object obj2) {
        PI0 pi0 = (PI0) obj;
        boolean z = obj2 == null;
        PI0 pi02 = this.b;
        PI0 pi03 = z ? pi02 : this.c;
        if (pi03 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = PI0.t;
            while (!atomicReferenceFieldUpdater.compareAndSet(pi0, this, pi03)) {
                if (atomicReferenceFieldUpdater.get(pi0) != this) {
                    return;
                }
            }
            if (z) {
                pi02.n(this.c);
            }
        }
    }
}
