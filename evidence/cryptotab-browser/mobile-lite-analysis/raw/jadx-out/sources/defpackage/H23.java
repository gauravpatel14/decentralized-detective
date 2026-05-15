package defpackage;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class H23 extends S13 {
    public final C0682g23 a = new C0682g23();

    @Override // defpackage.S13
    public final void a(Throwable th, Throwable th2) {
        ConcurrentHashMap concurrentHashMap;
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        C0682g23 c0682g23 = this.a;
        ReferenceQueue referenceQueue = c0682g23.b;
        Reference referencePoll = referenceQueue.poll();
        while (true) {
            concurrentHashMap = c0682g23.a;
            if (referencePoll == null) {
                break;
            }
            concurrentHashMap.remove(referencePoll);
            referencePoll = referenceQueue.poll();
        }
        List vector = (List) concurrentHashMap.get(new u23(th, null));
        if (vector == null) {
            vector = new Vector(2);
            List list = (List) concurrentHashMap.putIfAbsent(new u23(th, referenceQueue), vector);
            if (list != null) {
                vector = list;
            }
        }
        vector.add(th2);
    }
}
