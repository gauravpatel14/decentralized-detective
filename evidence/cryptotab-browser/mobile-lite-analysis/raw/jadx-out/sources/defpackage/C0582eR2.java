package defpackage;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: renamed from: eR2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0582eR2 extends FutureTask implements Comparable {
    public final long t;
    public final boolean u;
    public final String v;
    public final /* synthetic */ C0899jR2 w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0582eR2(C0899jR2 c0899jR2, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        this.w = c0899jR2;
        Preconditions.checkNotNull(str);
        long andIncrement = C0899jR2.k.getAndIncrement();
        this.t = andIncrement;
        this.v = str;
        this.u = z;
        if (andIncrement == Long.MAX_VALUE) {
            WO2 wo2 = c0899jR2.a.i;
            C1391rR2.k(wo2);
            wo2.f.a("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        C0582eR2 c0582eR2 = (C0582eR2) obj;
        boolean z = c0582eR2.u;
        boolean z2 = this.u;
        if (z2 == z) {
            long j = this.t;
            long j2 = c0582eR2.t;
            if (j < j2) {
                return -1;
            }
            if (j <= j2) {
                WO2 wo2 = this.w.a.i;
                C1391rR2.k(wo2);
                wo2.g.b(Long.valueOf(j), "Two tasks share the same index. index");
                return 0;
            }
        } else if (z2) {
            return -1;
        }
        return 1;
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        WO2 wo2 = this.w.a.i;
        C1391rR2.k(wo2);
        wo2.f.b(th, this.v);
        super.setException(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0582eR2(C0899jR2 c0899jR2, Callable callable, boolean z) {
        super(callable);
        this.w = c0899jR2;
        Preconditions.checkNotNull("Task exception on worker thread");
        long andIncrement = C0899jR2.k.getAndIncrement();
        this.t = andIncrement;
        this.v = "Task exception on worker thread";
        this.u = z;
        if (andIncrement == Long.MAX_VALUE) {
            WO2 wo2 = c0899jR2.a.i;
            C1391rR2.k(wo2);
            wo2.f.a("Tasks index overflow");
        }
    }
}
