package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class CG2 implements Iterator {
    public int t = 0;
    public final int u;
    public final /* synthetic */ C0519dH2 v;

    public CG2(C0519dH2 c0519dH2) {
        this.v = c0519dH2;
        this.u = c0519dH2.j();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.t < this.u;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.t;
        if (i >= this.u) {
            throw new NoSuchElementException();
        }
        this.t = i + 1;
        return Byte.valueOf(this.v.i(i));
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
