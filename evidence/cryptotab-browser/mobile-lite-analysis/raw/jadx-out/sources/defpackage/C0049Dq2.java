package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: renamed from: Dq2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0049Dq2 {
    public final HashMap a = new HashMap();
    public final J80 b;
    public final C1176nw c;
    public final PriorityBlockingQueue d;

    public C0049Dq2(C1176nw c1176nw, PriorityBlockingQueue priorityBlockingQueue, J80 j80) {
        this.b = j80;
        this.c = c1176nw;
        this.d = priorityBlockingQueue;
    }

    public final synchronized boolean a(AbstractC1701wu1 abstractC1701wu1) {
        try {
            String strF = abstractC1701wu1.f();
            if (!this.a.containsKey(strF)) {
                this.a.put(strF, null);
                synchronized (abstractC1701wu1.w) {
                    abstractC1701wu1.G = this;
                }
                return false;
            }
            List arrayList = (List) this.a.get(strF);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            int i = AbstractC1528tq2.a;
            arrayList.add(abstractC1701wu1);
            this.a.put(strF, arrayList);
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(AbstractC1701wu1 abstractC1701wu1) {
        PriorityBlockingQueue priorityBlockingQueue;
        String strF = abstractC1701wu1.f();
        List list = (List) this.a.remove(strF);
        if (list != null && !list.isEmpty()) {
            AbstractC1701wu1 abstractC1701wu12 = (AbstractC1701wu1) list.remove(0);
            this.a.put(strF, list);
            synchronized (abstractC1701wu12.w) {
                abstractC1701wu12.G = this;
            }
            if (this.c != null && (priorityBlockingQueue = this.d) != null) {
                try {
                    priorityBlockingQueue.put(abstractC1701wu12);
                } catch (InterruptedException e) {
                    AbstractC1583uq2.b("Couldn't add request to queue. %s", e.toString());
                    Thread.currentThread().interrupt();
                    this.c.b();
                }
            }
        }
    }
}
