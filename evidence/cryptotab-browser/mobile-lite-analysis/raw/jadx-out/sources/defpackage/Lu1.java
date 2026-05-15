package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Lu1 {
    public final AtomicInteger a;
    public final HashSet b;
    public final PriorityBlockingQueue c;
    public final PriorityBlockingQueue d;
    public final c00 e;
    public final Ho f;
    public final J80 g;
    public final C0970kY0[] h;
    public C1176nw i;
    public final ArrayList j;
    public final ArrayList k;

    public Lu1(c00 c00Var, Ho ho) {
        J80 j80 = new J80(new Handler(Looper.getMainLooper()));
        this.a = new AtomicInteger();
        this.b = new HashSet();
        this.c = new PriorityBlockingQueue();
        this.d = new PriorityBlockingQueue();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.e = c00Var;
        this.f = ho;
        this.h = new C0970kY0[4];
        this.g = j80;
    }

    public final void a(AbstractC1701wu1 abstractC1701wu1) {
        abstractC1701wu1.z = this;
        synchronized (this.b) {
            this.b.add(abstractC1701wu1);
        }
        abstractC1701wu1.y = Integer.valueOf(this.a.incrementAndGet());
        int i = AbstractC1528tq2.a;
        b();
        if (abstractC1701wu1.A) {
            this.c.add(abstractC1701wu1);
        } else {
            this.d.add(abstractC1701wu1);
        }
    }

    public final void b() {
        synchronized (this.k) {
            try {
                Iterator it = this.k.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
