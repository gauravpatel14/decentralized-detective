package defpackage;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: wX2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1683wX2 extends AbstractC0584eU2 {
    public final C1568uW2 a = new C1568uW2();

    @Override // defpackage.AbstractC0584eU2
    public final void a(Throwable th, Throwable th2) {
        ConcurrentHashMap concurrentHashMap;
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        C1568uW2 c1568uW2 = this.a;
        ReferenceQueue referenceQueue = c1568uW2.b;
        while (true) {
            Reference referencePoll = referenceQueue.poll();
            concurrentHashMap = c1568uW2.a;
            if (referencePoll == null) {
                break;
            } else {
                concurrentHashMap.remove(referencePoll);
            }
        }
        List vector = (List) concurrentHashMap.get(new C1395rV2(th, null));
        if (vector == null) {
            vector = new Vector(2);
            List list = (List) concurrentHashMap.putIfAbsent(new C1395rV2(th, referenceQueue), vector);
            if (list != null) {
                vector = list;
            }
        }
        vector.add(th2);
    }
}
