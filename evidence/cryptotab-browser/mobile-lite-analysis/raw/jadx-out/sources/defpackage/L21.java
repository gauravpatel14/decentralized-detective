package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class L21 implements Iterator {
    public int t;
    public int u;
    public boolean v;
    public final /* synthetic */ M21 w;

    public L21(M21 m21) {
        this.w = m21;
        m21.u++;
        this.t = m21.t.size();
    }

    public final void a() {
        if (this.v) {
            return;
        }
        this.v = true;
        M21 m21 = this.w;
        int i = m21.u - 1;
        m21.u = i;
        if (i <= 0 && m21.w) {
            m21.w = false;
            ArrayList arrayList = m21.t;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size) == null) {
                    arrayList.remove(size);
                }
            }
        }
    }

    public final void b() {
        M21 m21 = this.w;
        if (m21.x) {
            int i = AbstractC1872zv.a;
        }
        a();
        m21.u++;
        this.t = m21.t.size();
        this.v = false;
        this.u = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        M21 m21 = this.w;
        if (m21.x) {
            int i = AbstractC1872zv.a;
        }
        int i2 = this.u;
        while (i2 < this.t && m21.t.get(i2) == null) {
            i2++;
        }
        if (i2 < this.t) {
            return true;
        }
        a();
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        ArrayList arrayList;
        M21 m21 = this.w;
        if (m21.x) {
            int i = AbstractC1872zv.a;
        }
        while (true) {
            int i2 = this.u;
            int i3 = this.t;
            arrayList = m21.t;
            if (i2 >= i3 || arrayList.get(i2) != null) {
                break;
            }
            this.u++;
        }
        int i4 = this.u;
        if (i4 < this.t) {
            this.u = i4 + 1;
            return arrayList.get(i4);
        }
        a();
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
