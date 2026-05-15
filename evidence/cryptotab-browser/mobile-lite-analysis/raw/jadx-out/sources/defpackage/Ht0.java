package defpackage;

import java.util.Iterator;
import java.util.ListIterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Ht0 extends It0 {
    public final transient int v;
    public final transient int w;
    public final /* synthetic */ It0 x;

    public Ht0(It0 it0, int i, int i2) {
        this.x = it0;
        this.v = i;
        this.w = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        return this.x.get(i + this.v);
    }

    @Override // defpackage.It0, defpackage.Ft0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return listIterator(0);
    }

    @Override // defpackage.Ft0
    public final Object[] j() {
        return this.x.j();
    }

    @Override // defpackage.Ft0
    public final int l() {
        return this.x.p() + this.v + this.w;
    }

    @Override // defpackage.It0, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // defpackage.Ft0
    public final int p() {
        return this.x.p() + this.v;
    }

    @Override // defpackage.Ft0
    public final boolean s() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.w;
    }

    @Override // defpackage.It0, java.util.List
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public final It0 subList(int i, int i2) {
        int i3 = this.v;
        return this.x.subList(i + i3, i2 + i3);
    }

    @Override // defpackage.It0, java.util.List
    public final /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return listIterator(i);
    }
}
