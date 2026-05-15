package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: Zg2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0315Zg2 implements Iterator, BB0 {
    public final ArrayList t = new ArrayList();
    public Iterator u;

    public C0315Zg2(C1235oo2 c1235oo2) {
        this.u = c1235oo2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.u.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object next = this.u.next();
        Iterator it = (Iterator) C1172no2.u.j(next);
        ArrayList arrayList = this.t;
        if (it == null || !it.hasNext()) {
            while (!this.u.hasNext() && !arrayList.isEmpty()) {
                if (arrayList.isEmpty()) {
                    throw new NoSuchElementException("List is empty.");
                }
                this.u = (Iterator) arrayList.get(OG.c(arrayList));
                if (arrayList.isEmpty()) {
                    throw new NoSuchElementException("List is empty.");
                }
                arrayList.remove(OG.c(arrayList));
            }
        } else {
            arrayList.add(this.u);
            this.u = it;
        }
        return next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
