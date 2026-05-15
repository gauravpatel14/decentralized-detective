package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: Nv, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0165Nv implements Iterator {
    public int t = 0;
    public final int u;
    public final /* synthetic */ C0199Qv v;

    public C0165Nv(C0199Qv c0199Qv) {
        this.v = c0199Qv;
        this.u = c0199Qv.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.t < this.u;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.t;
        if (i >= this.u) {
            throw new NoSuchElementException();
        }
        this.t = i + 1;
        return Byte.valueOf(this.v.t(i));
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
