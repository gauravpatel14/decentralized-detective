package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class qy0 implements Iterator, BB0 {
    public final int t;
    public final int u;
    public boolean v;
    public int w;

    public qy0(int i, int i2, int i3) {
        this.t = i3;
        this.u = i2;
        boolean z = false;
        if (i3 <= 0 ? i >= i2 : i <= i2) {
            z = true;
        }
        this.v = z;
        this.w = z ? i : i2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.v;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.w;
        if (i != this.u) {
            this.w = this.t + i;
        } else {
            if (!this.v) {
                throw new NoSuchElementException();
            }
            this.v = false;
        }
        return Integer.valueOf(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
