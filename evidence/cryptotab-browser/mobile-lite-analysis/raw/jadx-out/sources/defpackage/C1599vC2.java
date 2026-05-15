package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: vC2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1599vC2 implements Iterator {
    public final /* synthetic */ Iterator t;
    public final /* synthetic */ Iterator u;

    public C1599vC2(Iterator it, Iterator it2) {
        this.t = it;
        this.u = it2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.t.hasNext()) {
            return true;
        }
        return this.u.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Iterator it = this.t;
        if (it.hasNext()) {
            return new OE2(((Integer) it.next()).toString());
        }
        Iterator it2 = this.u;
        if (it2.hasNext()) {
            return new OE2((String) it2.next());
        }
        throw new NoSuchElementException();
    }
}
