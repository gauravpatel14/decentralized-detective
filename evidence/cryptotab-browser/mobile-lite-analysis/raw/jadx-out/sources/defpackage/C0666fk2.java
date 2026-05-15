package defpackage;

import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: renamed from: fk2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0666fk2 extends AbstractList implements vE0, RandomAccess {
    public final C1545uE0 t;

    public C0666fk2(C1545uE0 c1545uE0) {
        this.t = c1545uE0;
    }

    @Override // defpackage.vE0
    public final List B1() {
        return Collections.unmodifiableList(this.t.u);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return (String) this.t.get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new C0601ek2(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new C0545dk2(this, i);
    }

    @Override // defpackage.vE0
    public final void q(C0199Qv c0199Qv) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.vE0
    public final Object q1(int i) {
        return this.t.u.get(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.t.size();
    }

    @Override // defpackage.vE0
    public final vE0 M0() {
        return this;
    }
}
