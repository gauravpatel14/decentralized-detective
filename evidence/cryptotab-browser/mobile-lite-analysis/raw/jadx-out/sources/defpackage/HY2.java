package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class HY2 implements Iterator {
    public final Iterator t;

    public HY2(IY2 iy2) {
        this.t = iy2.t.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.t.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.t.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
