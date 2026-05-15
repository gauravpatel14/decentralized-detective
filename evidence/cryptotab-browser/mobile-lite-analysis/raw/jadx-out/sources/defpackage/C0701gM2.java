package defpackage;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: gM2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0701gM2 implements ListIterator, Iterator {
    public final int t;
    public int u;
    public final AbstractC1441sM2 v;

    public C0701gM2(AbstractC1441sM2 abstractC1441sM2, int i) {
        int size = abstractC1441sM2.size();
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException(RL2.c(i, size, "index"));
        }
        this.t = size;
        this.u = i;
        this.v = abstractC1441sM2;
    }

    public final Object a(int i) {
        return this.v.get(i);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.u < this.t;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.u > 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.u;
        this.u = i + 1;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.u;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.u - 1;
        this.u = i;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.u - 1;
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
