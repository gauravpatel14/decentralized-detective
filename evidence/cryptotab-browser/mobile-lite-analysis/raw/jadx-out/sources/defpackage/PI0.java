package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class PI0 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater t = AtomicReferenceFieldUpdater.newUpdater(PI0.class, Object.class, "_next");
    public static final /* synthetic */ AtomicReferenceFieldUpdater u = AtomicReferenceFieldUpdater.newUpdater(PI0.class, Object.class, "_prev");
    public static final /* synthetic */ AtomicReferenceFieldUpdater v = AtomicReferenceFieldUpdater.newUpdater(PI0.class, Object.class, "_removedRef");
    volatile /* synthetic */ Object _next = this;
    volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    public void d() {
        t();
    }

    public final boolean l(PI0 pi0, PI0 pi02) {
        u.lazySet(pi0, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = t;
        atomicReferenceFieldUpdater.lazySet(pi0, pi02);
        while (!atomicReferenceFieldUpdater.compareAndSet(this, pi02, pi0)) {
            if (atomicReferenceFieldUpdater.get(this) != pi02) {
                return false;
            }
        }
        pi0.n(pi02);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0038, code lost:
    
        r4 = ((defpackage.Zt1) r4).a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003c, code lost:
    
        r5 = defpackage.PI0.t;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0042, code lost:
    
        if (r5.compareAndSet(r3, r2, r4) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004a, code lost:
    
        if (r5.get(r3) == r2) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.PI0 m() {
        /*
            r8 = this;
        L0:
            java.lang.Object r0 = r8._prev
            PI0 r0 = (defpackage.PI0) r0
            r1 = 0
            r2 = r0
        L6:
            r3 = r1
        L7:
            java.lang.Object r4 = r2._next
            if (r4 != r8) goto L1e
            if (r0 != r2) goto Le
            return r2
        Le:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = defpackage.PI0.u
            boolean r3 = r1.compareAndSet(r8, r0, r2)
            if (r3 == 0) goto L17
            return r2
        L17:
            java.lang.Object r1 = r1.get(r8)
            if (r1 == r0) goto Le
            goto L0
        L1e:
            boolean r5 = r8.s()
            if (r5 == 0) goto L25
            return r1
        L25:
            if (r4 != 0) goto L28
            return r2
        L28:
            boolean r5 = r4 instanceof defpackage.h51
            if (r5 == 0) goto L32
            h51 r4 = (defpackage.h51) r4
            r4.a(r2)
            goto L0
        L32:
            boolean r5 = r4 instanceof defpackage.Zt1
            if (r5 == 0) goto L52
            if (r3 == 0) goto L4d
            Zt1 r4 = (defpackage.Zt1) r4
            PI0 r4 = r4.a
        L3c:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = defpackage.PI0.t
            boolean r6 = r5.compareAndSet(r3, r2, r4)
            if (r6 == 0) goto L46
            r2 = r3
            goto L6
        L46:
            java.lang.Object r5 = r5.get(r3)
            if (r5 == r2) goto L3c
            goto L0
        L4d:
            java.lang.Object r2 = r2._prev
            PI0 r2 = (defpackage.PI0) r2
            goto L7
        L52:
            r3 = r4
            PI0 r3 = (defpackage.PI0) r3
            r7 = r3
            r3 = r2
            r2 = r7
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.PI0.m():PI0");
    }

    public final void n(PI0 pi0) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        while (true) {
            PI0 pi02 = (PI0) pi0._prev;
            if (o() != pi0) {
                return;
            }
            do {
                atomicReferenceFieldUpdater = u;
                if (atomicReferenceFieldUpdater.compareAndSet(pi0, pi02, this)) {
                    if (s()) {
                        pi0.m();
                        return;
                    }
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(pi0) == pi02);
        }
    }

    public final Object o() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof h51)) {
                return obj;
            }
            ((h51) obj).a(this);
        }
    }

    public final PI0 p() {
        PI0 pi0;
        Object objO = o();
        Zt1 zt1 = objO instanceof Zt1 ? (Zt1) objO : null;
        return (zt1 == null || (pi0 = zt1.a) == null) ? (PI0) objO : pi0;
    }

    public final PI0 q() {
        PI0 pi0M = m();
        if (pi0M == null) {
            Object obj = this._prev;
            while (true) {
                pi0M = (PI0) obj;
                if (!pi0M.s()) {
                    break;
                }
                obj = pi0M._prev;
            }
        }
        return pi0M;
    }

    public final void r() {
        PI0 pi0 = this;
        while (true) {
            Object objO = pi0.o();
            if (!(objO instanceof Zt1)) {
                pi0.m();
                return;
            }
            pi0 = ((Zt1) objO).a;
        }
    }

    public boolean s() {
        return o() instanceof Zt1;
    }

    public boolean t() {
        return u() == null;
    }

    public String toString() {
        return new OI0(1, hV.class, this, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;") + '@' + hV.a(this);
    }

    public final PI0 u() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        while (true) {
            Object objO = o();
            if (objO instanceof Zt1) {
                return ((Zt1) objO).a;
            }
            if (objO == this) {
                return (PI0) objO;
            }
            PI0 pi0 = (PI0) objO;
            Zt1 zt1 = (Zt1) pi0._removedRef;
            if (zt1 == null) {
                zt1 = new Zt1(pi0);
                v.lazySet(pi0, zt1);
            }
            do {
                atomicReferenceFieldUpdater = t;
                if (atomicReferenceFieldUpdater.compareAndSet(this, objO, zt1)) {
                    pi0.m();
                    return null;
                }
            } while (atomicReferenceFieldUpdater.get(this) == objO);
        }
    }

    public final int v(PI0 pi0, LI0 li0, NI0 ni0) {
        u.lazySet(pi0, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = t;
        atomicReferenceFieldUpdater.lazySet(pi0, li0);
        ni0.c = li0;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, li0, ni0)) {
            if (atomicReferenceFieldUpdater.get(this) != li0) {
                return 0;
            }
        }
        return ni0.a(this) == null ? 1 : 2;
    }
}
