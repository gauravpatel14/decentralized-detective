package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class K extends G {
    public final AtomicReferenceFieldUpdater a;
    public final AtomicReferenceFieldUpdater b;
    public final AtomicReferenceFieldUpdater c;
    public final AtomicReferenceFieldUpdater d;
    public final AtomicReferenceFieldUpdater e;

    public K(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.a = atomicReferenceFieldUpdater;
        this.b = atomicReferenceFieldUpdater2;
        this.c = atomicReferenceFieldUpdater3;
        this.d = atomicReferenceFieldUpdater4;
        this.e = atomicReferenceFieldUpdater5;
    }

    @Override // defpackage.G
    public final boolean a(N n, J j, J j2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.d;
            if (atomicReferenceFieldUpdater.compareAndSet(n, j, j2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(n) == j);
        return false;
    }

    @Override // defpackage.G
    public final boolean b(N n, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.e;
            if (atomicReferenceFieldUpdater.compareAndSet(n, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(n) == obj);
        return false;
    }

    @Override // defpackage.G
    public final boolean c(N n, M m, M m2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.c;
            if (atomicReferenceFieldUpdater.compareAndSet(n, m, m2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(n) == m);
        return false;
    }

    @Override // defpackage.G
    public final void d(M m, M m2) {
        this.b.lazySet(m, m2);
    }

    @Override // defpackage.G
    public final void e(M m, Thread thread) {
        this.a.lazySet(m, thread);
    }
}
