package defpackage;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class mK implements DE1 {
    public final AtomicReference a;

    public mK(DE1 de1) {
        this.a = new AtomicReference(de1);
    }

    @Override // defpackage.DE1
    public final Iterator iterator() {
        DE1 de1 = (DE1) this.a.getAndSet(null);
        if (de1 != null) {
            return de1.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
