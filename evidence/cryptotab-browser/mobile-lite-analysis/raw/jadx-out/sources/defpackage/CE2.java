package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class CE2 extends AbstractC0453cE2 {
    public final transient PE2 v;
    public final transient JE2 w;

    public CE2(PE2 pe2, JE2 je2) {
        this.v = pe2;
        this.w = je2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.v.get(obj) != null;
    }

    @Override // defpackage.AbstractC0335aD2
    public final int f(Object[] objArr) {
        return this.w.f(objArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return this.w.listIterator(0);
    }

    @Override // defpackage.AbstractC0453cE2, defpackage.AbstractC0335aD2
    public final AD2 l() {
        return this.w;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.v.y;
    }
}
