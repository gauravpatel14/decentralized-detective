package defpackage;

import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class IY2 extends AbstractList implements RandomAccess, XW2 {
    public final VW2 t;

    public IY2(VW2 vw2) {
        this.t = vw2;
    }

    @Override // defpackage.XW2
    public final void C(WU2 wu2) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.XW2
    public final List b() {
        return Collections.unmodifiableList(this.t.u);
    }

    @Override // defpackage.XW2
    public final Object d(int i) {
        return this.t.u.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return this.t.get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new HY2(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new GY2(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.t.size();
    }

    @Override // defpackage.XW2
    public final XW2 a() {
        return this;
    }
}
