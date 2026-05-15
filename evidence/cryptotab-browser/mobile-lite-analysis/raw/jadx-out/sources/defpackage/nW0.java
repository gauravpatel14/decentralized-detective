package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class nW0 extends AbstractC1630vg {
    public final mW0 b;

    public nW0(mW0 mw0) {
        this.b = mw0;
    }

    @Override // defpackage.AbstractC1630vg
    public final void b(Object obj, Object obj2) {
        pW0 pw0 = (pW0) obj;
        Object obj3 = obj2 == null ? qW0.e : this.b;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = pW0.a;
        while (!atomicReferenceFieldUpdater.compareAndSet(pw0, this, obj3) && atomicReferenceFieldUpdater.get(pw0) == this) {
        }
    }

    @Override // defpackage.AbstractC1630vg
    public final eT1 c(Object obj) {
        mW0 mw0 = this.b;
        if (mw0.o() == mw0) {
            return null;
        }
        return qW0.a;
    }
}
