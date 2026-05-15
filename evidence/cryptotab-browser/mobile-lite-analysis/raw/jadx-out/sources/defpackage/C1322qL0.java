package defpackage;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: qL0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1322qL0 implements Iterator, BB0 {
    public final C1438sL0 t;
    public int u;
    public int v = -1;
    public int w;
    public final /* synthetic */ int x;

    public C1322qL0(C1438sL0 c1438sL0, int i) {
        this.x = i;
        this.t = c1438sL0;
        this.w = c1438sL0.A;
        b();
    }

    public final void a() {
        if (this.t.A != this.w) {
            throw new ConcurrentModificationException();
        }
    }

    public final void b() {
        while (true) {
            int i = this.u;
            C1438sL0 c1438sL0 = this.t;
            if (i >= c1438sL0.y || c1438sL0.v[i] >= 0) {
                return;
            } else {
                this.u = i + 1;
            }
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.u < this.t.y;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.x) {
            case 0:
                a();
                int i = this.u;
                C1438sL0 c1438sL0 = this.t;
                if (i >= c1438sL0.y) {
                    throw new NoSuchElementException();
                }
                this.u = i + 1;
                this.v = i;
                C1379rL0 c1379rL0 = new C1379rL0(c1438sL0, i);
                b();
                return c1379rL0;
            case 1:
                a();
                int i2 = this.u;
                C1438sL0 c1438sL02 = this.t;
                if (i2 >= c1438sL02.y) {
                    throw new NoSuchElementException();
                }
                this.u = i2 + 1;
                this.v = i2;
                Object obj = c1438sL02.t[i2];
                b();
                return obj;
            default:
                a();
                int i3 = this.u;
                C1438sL0 c1438sL03 = this.t;
                if (i3 >= c1438sL03.y) {
                    throw new NoSuchElementException();
                }
                this.u = i3 + 1;
                this.v = i3;
                Object obj2 = c1438sL03.u[i3];
                b();
                return obj2;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        a();
        if (this.v == -1) {
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }
        C1438sL0 c1438sL0 = this.t;
        c1438sL0.b();
        c1438sL0.p(this.v);
        this.v = -1;
        this.w = c1438sL0.A;
    }
}
