package defpackage;

import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class AP2 extends AbstractList implements RandomAccess, JL2 {
    public final FL2 t;

    public AP2(FL2 fl2) {
        this.t = fl2;
    }

    @Override // defpackage.JL2
    public final List b() {
        return Collections.unmodifiableList(this.t.u);
    }

    @Override // defpackage.JL2
    public final Object d(int i) {
        return this.t.u.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return this.t.get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new C1732xP2(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new C1560uP2(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.t.u.size();
    }

    @Override // defpackage.JL2
    public final JL2 a() {
        return this;
    }
}
