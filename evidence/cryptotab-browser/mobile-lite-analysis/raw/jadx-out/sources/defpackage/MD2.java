package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class MD2 implements Iterator {
    public final /* synthetic */ Iterator t;

    public MD2(Iterator it) {
        this.t = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.t.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return new OE2((String) this.t.next());
    }
}
