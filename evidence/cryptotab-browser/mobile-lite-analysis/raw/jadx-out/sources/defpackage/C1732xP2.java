package defpackage;

import java.util.Iterator;

/* JADX INFO: renamed from: xP2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1732xP2 implements Iterator {
    public final Iterator t;

    public C1732xP2(AP2 ap2) {
        this.t = ap2.t.iterator();
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
