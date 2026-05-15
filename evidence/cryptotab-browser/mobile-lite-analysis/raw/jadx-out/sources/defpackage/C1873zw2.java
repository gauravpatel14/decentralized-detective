package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: zw2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1873zw2 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(C1873zw2.class, Object.class, "lastScheduledTask");
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(C1873zw2.class, "producerIndex");
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(C1873zw2.class, "consumerIndex");
    public static final /* synthetic */ AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(C1873zw2.class, "blockingTasksInBuffer");
    public final AtomicReferenceArray a = new AtomicReferenceArray(128);
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    public final F62 a(F62 f62) {
        if (f62.u.a == 1) {
            e.incrementAndGet(this);
        }
        if (this.producerIndex - this.consumerIndex == 127) {
            return f62;
        }
        int i = this.producerIndex & 127;
        while (this.a.get(i) != null) {
            Thread.yield();
        }
        this.a.lazySet(i, f62);
        c.incrementAndGet(this);
        return null;
    }

    public final int b() {
        return this.lastScheduledTask != null ? (this.producerIndex - this.consumerIndex) + 1 : this.producerIndex - this.consumerIndex;
    }

    public final F62 c() {
        F62 f62;
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & 127;
            if (d.compareAndSet(this, i, i + 1) && (f62 = (F62) this.a.getAndSet(i2, null)) != null) {
                if (f62.u.a == 1) {
                    e.decrementAndGet(this);
                }
                return f62;
            }
        }
    }

    public final long d(C1873zw2 c1873zw2) {
        int i = c1873zw2.producerIndex;
        AtomicReferenceArray atomicReferenceArray = c1873zw2.a;
        for (int i2 = c1873zw2.consumerIndex; i2 != i; i2++) {
            int i3 = i2 & 127;
            if (c1873zw2.blockingTasksInBuffer == 0) {
                break;
            }
            F62 f62 = (F62) atomicReferenceArray.get(i3);
            if (f62 != null && f62.u.a == 1) {
                while (!atomicReferenceArray.compareAndSet(i3, f62, null)) {
                    if (atomicReferenceArray.get(i3) != f62) {
                        break;
                    }
                }
                e.decrementAndGet(c1873zw2);
                F62 f622 = (F62) b.getAndSet(this, f62);
                if (f622 == null) {
                    return -1L;
                }
                a(f622);
                return -1L;
            }
        }
        return e(c1873zw2, true);
    }

    public final long e(C1873zw2 c1873zw2, boolean z) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        while (true) {
            F62 f62 = (F62) c1873zw2.lastScheduledTask;
            if (f62 == null) {
                return -2L;
            }
            if (z && f62.u.a != 1) {
                return -2L;
            }
            Z62.e.getClass();
            long jNanoTime = System.nanoTime() - f62.t;
            long j = Z62.a;
            if (jNanoTime < j) {
                return j - jNanoTime;
            }
            do {
                atomicReferenceFieldUpdater = b;
                if (atomicReferenceFieldUpdater.compareAndSet(c1873zw2, f62, null)) {
                    F62 f622 = (F62) atomicReferenceFieldUpdater.getAndSet(this, f62);
                    if (f622 == null) {
                        return -1L;
                    }
                    a(f622);
                    return -1L;
                }
            } while (atomicReferenceFieldUpdater.get(c1873zw2) == f62);
        }
    }
}
