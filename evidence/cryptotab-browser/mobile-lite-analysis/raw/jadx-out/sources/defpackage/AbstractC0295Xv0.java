package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: Xv0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0295Xv0 implements Iterator, BB0 {
    public int t;
    public int u;
    public boolean v;

    public AbstractC0295Xv0(int i) {
        this.t = i;
    }

    public abstract Object a(int i);

    public abstract void b(int i);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.u < this.t;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object objA = a(this.u);
        this.u++;
        this.v = true;
        return objA;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.v) {
            throw new IllegalStateException("Call next() before removing an element.");
        }
        int i = this.u - 1;
        this.u = i;
        b(i);
        this.t--;
        this.v = false;
    }
}
