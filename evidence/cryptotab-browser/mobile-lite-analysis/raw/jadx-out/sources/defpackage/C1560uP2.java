package defpackage;

import java.util.ListIterator;

/* JADX INFO: renamed from: uP2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1560uP2 implements ListIterator {
    public final ListIterator t;

    public C1560uP2(AP2 ap2, int i) {
        this.t = ap2.t.listIterator(i);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.t.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.t.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.t.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.t.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ Object previous() {
        return (String) this.t.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.t.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
