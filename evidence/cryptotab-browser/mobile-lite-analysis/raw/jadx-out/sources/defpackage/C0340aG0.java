package defpackage;

import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: aG0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0340aG0 implements ListIterator, BB0 {
    public int u;
    public int w;
    public final B x;
    public final /* synthetic */ int t = 0;
    public int v = -1;

    public C0340aG0(C0456cG0 c0456cG0, int i) {
        this.x = c0456cG0;
        this.u = i;
        this.w = ((AbstractList) c0456cG0).modCount;
    }

    public void a() {
        if (((AbstractList) ((C0396bG0) this.x).x).modCount != this.w) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        switch (this.t) {
            case 0:
                a();
                int i = this.u;
                this.u = i + 1;
                C0396bG0 c0396bG0 = (C0396bG0) this.x;
                c0396bG0.add(i, obj);
                this.v = -1;
                this.w = ((AbstractList) c0396bG0).modCount;
                break;
            default:
                b();
                int i2 = this.u;
                this.u = i2 + 1;
                C0456cG0 c0456cG0 = (C0456cG0) this.x;
                c0456cG0.add(i2, obj);
                this.v = -1;
                this.w = ((AbstractList) c0456cG0).modCount;
                break;
        }
    }

    public void b() {
        if (((AbstractList) ((C0456cG0) this.x)).modCount != this.w) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        switch (this.t) {
            case 0:
                if (this.u < ((C0396bG0) this.x).v) {
                }
                break;
            default:
                if (this.u < ((C0456cG0) this.x).u) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        switch (this.t) {
            case 0:
                if (this.u > 0) {
                }
                break;
            default:
                if (this.u > 0) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.t) {
            case 0:
                a();
                int i = this.u;
                C0396bG0 c0396bG0 = (C0396bG0) this.x;
                if (i >= c0396bG0.v) {
                    throw new NoSuchElementException();
                }
                this.u = i + 1;
                this.v = i;
                return c0396bG0.t[c0396bG0.u + i];
            default:
                b();
                int i2 = this.u;
                C0456cG0 c0456cG0 = (C0456cG0) this.x;
                if (i2 >= c0456cG0.u) {
                    throw new NoSuchElementException();
                }
                this.u = i2 + 1;
                this.v = i2;
                return c0456cG0.t[i2];
        }
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        switch (this.t) {
        }
        return this.u;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.t) {
            case 0:
                a();
                int i = this.u;
                if (i <= 0) {
                    throw new NoSuchElementException();
                }
                int i2 = i - 1;
                this.u = i2;
                this.v = i2;
                C0396bG0 c0396bG0 = (C0396bG0) this.x;
                return c0396bG0.t[c0396bG0.u + i2];
            default:
                b();
                int i3 = this.u;
                if (i3 <= 0) {
                    throw new NoSuchElementException();
                }
                int i4 = i3 - 1;
                this.u = i4;
                this.v = i4;
                return ((C0456cG0) this.x).t[i4];
        }
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        switch (this.t) {
        }
        return this.u - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        switch (this.t) {
            case 0:
                a();
                int i = this.v;
                if (i == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                C0396bG0 c0396bG0 = (C0396bG0) this.x;
                c0396bG0.i(i);
                this.u = this.v;
                this.v = -1;
                this.w = ((AbstractList) c0396bG0).modCount;
                return;
            default:
                b();
                int i2 = this.v;
                if (i2 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                C0456cG0 c0456cG0 = (C0456cG0) this.x;
                c0456cG0.i(i2);
                this.u = this.v;
                this.v = -1;
                this.w = ((AbstractList) c0456cG0).modCount;
                return;
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        switch (this.t) {
            case 0:
                a();
                int i = this.v;
                if (i == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                ((C0396bG0) this.x).set(i, obj);
                return;
            default:
                b();
                int i2 = this.v;
                if (i2 == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                ((C0456cG0) this.x).set(i2, obj);
                return;
        }
    }

    public C0340aG0(C0396bG0 c0396bG0, int i) {
        this.x = c0396bG0;
        this.u = i;
        this.w = ((AbstractList) c0396bG0).modCount;
    }
}
