package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: Bl0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0016Bl0 implements Iterator, BB0 {
    public Object t;
    public int u = -2;
    public final /* synthetic */ Cl0 v;

    public C0016Bl0(Cl0 cl0) {
        this.v = cl0;
    }

    public final void a() {
        Object objJ;
        int i = this.u;
        Cl0 cl0 = this.v;
        if (i == -2) {
            cl0.getClass();
            objJ = C1423s4.u.c();
        } else {
            objJ = cl0.a.j(this.t);
        }
        this.t = objJ;
        this.u = objJ == null ? 0 : 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.u < 0) {
            a();
        }
        return this.u == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.u < 0) {
            a();
        }
        if (this.u == 0) {
            throw new NoSuchElementException();
        }
        Object obj = this.t;
        this.u = -1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
