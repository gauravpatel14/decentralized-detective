package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Ze implements Iterator, BB0 {
    public final Object[] t;
    public int u;

    public Ze(Object[] objArr) {
        this.t = objArr;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.u < this.t.length;
    }

    @Override // java.util.Iterator
    public final Object next() {
        try {
            Object[] objArr = this.t;
            int i = this.u;
            this.u = i + 1;
            return objArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.u--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
