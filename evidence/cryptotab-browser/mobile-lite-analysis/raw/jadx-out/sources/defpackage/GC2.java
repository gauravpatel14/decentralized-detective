package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class GC2 implements Iterator {
    public int t = 0;
    public final /* synthetic */ PC2 u;

    public GC2(PC2 pc2) {
        this.u = pc2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.t < this.u.j();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        int i = this.t;
        PC2 pc2 = this.u;
        if (i >= pc2.j()) {
            throw new NoSuchElementException(AbstractC1214oR1.a(this.t, "Out of bounds index: "));
        }
        int i2 = this.t;
        this.t = i2 + 1;
        return pc2.k(i2);
    }
}
