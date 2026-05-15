package defpackage;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: qA0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1310qA0 implements Iterator {
    public Iterator t;
    public Iterator u;
    public Iterator v;
    public ArrayDeque w;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Iterator it;
        while (!this.u.hasNext()) {
            while (true) {
                Iterator it2 = this.v;
                if (it2 != null && it2.hasNext()) {
                    it = this.v;
                    break;
                }
                ArrayDeque arrayDeque = this.w;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    break;
                }
                this.v = (Iterator) this.w.removeFirst();
            }
            it = null;
            this.v = it;
            if (it == null) {
                return false;
            }
            Iterator it3 = (Iterator) it.next();
            this.u = it3;
            if (it3 instanceof C1310qA0) {
                C1310qA0 c1310qA0 = (C1310qA0) it3;
                this.u = c1310qA0.u;
                if (this.w == null) {
                    this.w = new ArrayDeque();
                }
                this.w.addFirst(this.v);
                if (c1310qA0.w != null) {
                    while (!c1310qA0.w.isEmpty()) {
                        this.w.addFirst((Iterator) c1310qA0.w.removeLast());
                    }
                }
                this.v = c1310qA0.v;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Iterator it = this.u;
        this.t = it;
        return it.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        Iterator it = this.t;
        if (it == null) {
            throw new IllegalStateException("no calls to next() since the last call to remove()");
        }
        it.remove();
        this.t = null;
    }
}
