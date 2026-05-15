package defpackage;

import android.os.Trace;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: ql0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1349ql0 implements Runnable {
    public static final ThreadLocal x = new ThreadLocal();
    public static final C1168nl0 y = new C1168nl0();
    public long u;
    public long v;
    public final ArrayList t = new ArrayList();
    public final ArrayList w = new ArrayList();

    public static ps1 c(RecyclerView recyclerView, int i, long j) {
        int iH = recyclerView.y.h();
        for (int i2 = 0; i2 < iH; i2++) {
            ps1 ps1VarN = RecyclerView.N(recyclerView.y.g(i2));
            if (ps1VarN.v == i && !ps1VarN.k()) {
                return null;
            }
        }
        C0738gs1 c0738gs1 = recyclerView.v;
        if (j == Long.MAX_VALUE) {
            try {
                if (AbstractC0368af2.a()) {
                    Trace.beginSection("RV Prefetch forced - needed next frame");
                }
            } catch (Throwable th) {
                recyclerView.b0(false);
                Trace.endSection();
                throw th;
            }
        }
        recyclerView.a0();
        ps1 ps1VarK = c0738gs1.k(i, j);
        if (ps1VarK != null) {
            if (!ps1VarK.j() || ps1VarK.k()) {
                c0738gs1.a(ps1VarK, false);
            } else {
                c0738gs1.h(ps1VarK.t);
            }
        }
        recyclerView.b0(false);
        Trace.endSection();
        return ps1VarK;
    }

    public final void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.M) {
            int[] iArr = RecyclerView.W0;
            if (this.u == 0) {
                this.u = RecyclerView.Q();
                recyclerView.post(this);
            }
        }
        ol0 ol0Var = recyclerView.A0;
        ol0Var.a = i;
        ol0Var.b = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x0140  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(long r18) {
        /*
            Method dump skipped, instruction units count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.RunnableC1349ql0.b(long):void");
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Trace.beginSection("RV Prefetch");
            ArrayList arrayList = this.t;
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                long jMax = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = (RecyclerView) arrayList.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    b(TimeUnit.MILLISECONDS.toNanos(jMax) + this.v);
                    this.u = 0L;
                    Trace.endSection();
                }
            }
        } finally {
            this.u = 0L;
            Trace.endSection();
        }
    }
}
