package defpackage;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class SI0 {
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ long _state = 0;
    public final int a;
    public final boolean b;
    public final int c;
    public final /* synthetic */ AtomicReferenceArray d;
    public static final eT1 g = new eT1("REMOVE_FROZEN");
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(SI0.class, Object.class, "_next");
    public static final /* synthetic */ AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(SI0.class, "_state");

    public SI0(int i, boolean z) {
        this.a = i;
        this.b = z;
        int i2 = i - 1;
        this.c = i2;
        this.d = new AtomicReferenceArray(i);
        if (i2 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i & i2) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Object r13) {
        /*
            r12 = this;
        L0:
            long r2 = r12._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L15
            r4 = 2305843009213693952(0x2000000000000000, double:1.4916681462400413E-154)
            long r2 = r2 & r4
            int r13 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r13 == 0) goto L14
            r1 = 2
        L14:
            return r1
        L15:
            r4 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r4 = r4 & r2
            int r0 = (int) r4
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r8 = 30
            long r4 = r4 >> r8
            int r9 = (int) r4
            int r10 = r12.c
            int r4 = r9 + 2
            r4 = r4 & r10
            r5 = r0 & r10
            if (r4 != r5) goto L2e
            return r1
        L2e:
            boolean r4 = r12.b
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r4 != 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceArray r4 = r12.d
            r11 = r9 & r10
            java.lang.Object r4 = r4.get(r11)
            if (r4 == 0) goto L4d
            int r2 = r12.a
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 < r3) goto L4c
            int r9 = r9 - r0
            r0 = r9 & r5
            int r2 = r2 >> 1
            if (r0 <= r2) goto L0
        L4c:
            return r1
        L4d:
            int r0 = r9 + 1
            r0 = r0 & r5
            r4 = -1152921503533105153(0xf00000003fffffff, double:-3.1050369248997324E231)
            long r4 = r4 & r2
            long r0 = (long) r0
            long r0 = r0 << r8
            long r4 = r4 | r0
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = defpackage.SI0.f
            r1 = r12
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L0
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.d
            r1 = r9 & r10
            r0.set(r1, r13)
            r0 = r12
        L6a:
            long r1 = r0._state
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 == 0) goto L91
            SI0 r0 = r0.e()
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r0.d
            int r2 = r0.c
            r2 = r2 & r9
            java.lang.Object r3 = r1.get(r2)
            boolean r4 = r3 instanceof defpackage.RI0
            if (r4 == 0) goto L8e
            RI0 r3 = (defpackage.RI0) r3
            int r3 = r3.a
            if (r3 != r9) goto L8e
            r1.set(r2, r13)
            goto L8f
        L8e:
            r0 = 0
        L8f:
            if (r0 != 0) goto L6a
        L91:
            r13 = 0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.SI0.a(java.lang.Object):int");
    }

    public final boolean b() {
        long j;
        do {
            j = this._state;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!f.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    public final int c() {
        long j = this._state;
        return (((int) ((j & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j))) & 1073741823;
    }

    public final boolean d() {
        long j = this._state;
        return ((int) (1073741823 & j)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    public final SI0 e() {
        long j;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        while (true) {
            j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                break;
            }
            long j2 = j | 1152921504606846976L;
            if (f.compareAndSet(this, j, j2)) {
                j = j2;
                break;
            }
        }
        while (true) {
            SI0 si0 = (SI0) this._next;
            if (si0 != null) {
                return si0;
            }
            SI0 si02 = new SI0(this.a * 2, this.b);
            int i = (int) (1073741823 & j);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            while (true) {
                int i3 = this.c;
                int i4 = i & i3;
                if (i4 == (i3 & i2)) {
                    break;
                }
                Object ri0 = this.d.get(i4);
                if (ri0 == null) {
                    ri0 = new RI0(i);
                }
                si02.d.set(si02.c & i, ri0);
                i++;
            }
            si02._state = (-1152921504606846977L) & j;
            do {
                atomicReferenceFieldUpdater = e;
                if (atomicReferenceFieldUpdater.compareAndSet(this, null, si02)) {
                    break;
                }
            } while (atomicReferenceFieldUpdater.get(this) == null);
        }
    }

    public final Object f() {
        while (true) {
            long j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                return g;
            }
            int i = (int) (j & 1073741823);
            int i2 = this.c;
            int i3 = ((int) ((1152921503533105152L & j) >> 30)) & i2;
            int i4 = i2 & i;
            if (i3 == i4) {
                return null;
            }
            Object obj = this.d.get(i4);
            if (obj == null) {
                if (this.b) {
                    return null;
                }
            } else {
                if (obj instanceof RI0) {
                    return null;
                }
                long j2 = (i + 1) & 1073741823;
                if (f.compareAndSet(this, j, (j & (-1073741824)) | j2)) {
                    this.d.set(this.c & i, null);
                    return obj;
                }
                if (this.b) {
                    SI0 si0E = this;
                    while (true) {
                        long j3 = si0E._state;
                        int i5 = (int) (j3 & 1073741823);
                        if ((j3 & 1152921504606846976L) != 0) {
                            si0E = si0E.e();
                        } else {
                            if (f.compareAndSet(si0E, j3, (j3 & (-1073741824)) | j2)) {
                                si0E.d.set(si0E.c & i5, null);
                                si0E = null;
                            } else {
                                continue;
                            }
                        }
                        if (si0E == null) {
                            return obj;
                        }
                    }
                }
            }
        }
    }
}
