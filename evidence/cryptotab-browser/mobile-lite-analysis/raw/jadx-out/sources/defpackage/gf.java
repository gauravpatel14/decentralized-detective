package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class gf extends UJ1 implements Map {
    public bf w;
    public df x;
    public ff y;

    public gf() {
        super(0);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        bf bfVar = this.w;
        if (bfVar != null) {
            return bfVar;
        }
        bf bfVar2 = new bf(this);
        this.w = bfVar2;
        return bfVar2;
    }

    public final boolean j(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!super.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean k(Collection collection) {
        int i = this.v;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            super.remove(it.next());
        }
        return i != this.v;
    }

    @Override // java.util.Map
    public final Set keySet() {
        df dfVar = this.x;
        if (dfVar != null) {
            return dfVar;
        }
        df dfVar2 = new df(this);
        this.x = dfVar2;
        return dfVar2;
    }

    public final boolean l(Collection collection) {
        int i = this.v;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (!collection.contains(f(i2))) {
                g(i2);
            }
        }
        return i != this.v;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        b(map.size() + this.v);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        ff ffVar = this.y;
        if (ffVar != null) {
            return ffVar;
        }
        ff ffVar2 = new ff(this);
        this.y = ffVar2;
        return ffVar2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gf(UJ1 uj1) {
        super(0);
        int i = uj1.v;
        b(this.v + i);
        if (this.v != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(uj1.f(i2), uj1.i(i2));
            }
        } else if (i > 0) {
            AbstractC1229of.a(0, 0, i, uj1.t, this.t);
            AbstractC1229of.b(0, 0, i << 1, uj1.u, this.u);
            this.v = i;
        }
    }
}
