package defpackage;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ef implements Iterator, Map.Entry {
    public int t;
    public int u = -1;
    public boolean v;
    public final /* synthetic */ gf w;

    public ef(gf gfVar) {
        this.w = gfVar;
        this.t = gfVar.v - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!this.v) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        int i = this.u;
        gf gfVar = this.w;
        return lz0.a(key, gfVar.f(i)) && lz0.a(entry.getValue(), gfVar.i(this.u));
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (this.v) {
            return this.w.f(this.u);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.v) {
            return this.w.i(this.u);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.u < this.t;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        if (!this.v) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        int i = this.u;
        gf gfVar = this.w;
        Object objF = gfVar.f(i);
        Object objI = gfVar.i(this.u);
        return (objF == null ? 0 : objF.hashCode()) ^ (objI != null ? objI.hashCode() : 0);
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.u++;
        this.v = true;
        return this;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.v) {
            throw new IllegalStateException();
        }
        this.w.g(this.u);
        this.u--;
        this.t--;
        this.v = false;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (this.v) {
            return this.w.h(this.u, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
