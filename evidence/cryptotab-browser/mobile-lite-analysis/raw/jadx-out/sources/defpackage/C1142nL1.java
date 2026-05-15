package defpackage;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: nL1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1142nL1 implements Iterator {
    public int t = -1;
    public boolean u;
    public Iterator v;
    public final /* synthetic */ iL1 w;

    public C1142nL1(iL1 il1) {
        this.w = il1;
    }

    public final Iterator a() {
        if (this.v == null) {
            this.v = this.w.v.entrySet().iterator();
        }
        return this.v;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.t + 1;
        iL1 il1 = this.w;
        if (i >= il1.u.size()) {
            return !il1.v.isEmpty() && a().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        this.u = true;
        int i = this.t + 1;
        this.t = i;
        iL1 il1 = this.w;
        return i < il1.u.size() ? (Map.Entry) il1.u.get(this.t) : (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.u) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.u = false;
        int i = iL1.z;
        iL1 il1 = this.w;
        il1.b();
        if (this.t >= il1.u.size()) {
            a().remove();
            return;
        }
        int i2 = this.t;
        this.t = i2 - 1;
        il1.g(i2);
    }
}
