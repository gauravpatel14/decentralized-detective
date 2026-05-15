package defpackage;

import java.util.ListIterator;

/* JADX INFO: renamed from: dk2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0545dk2 implements ListIterator {
    public final ListIterator t;

    public C0545dk2(C0666fk2 c0666fk2, int i) {
        this.t = c0666fk2.t.listIterator(i);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
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
    public final Object next() {
        return (String) this.t.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.t.nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
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
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
