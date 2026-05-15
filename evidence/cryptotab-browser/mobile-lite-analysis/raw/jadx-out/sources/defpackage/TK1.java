package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TK1 extends Kt0 {
    public final transient Object v;

    public TK1(Object obj) {
        this.v = obj;
    }

    @Override // defpackage.Ft0, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.v.equals(obj);
    }

    @Override // defpackage.Kt0, defpackage.Ft0
    public final It0 f() {
        return It0.v(this.v);
    }

    @Override // defpackage.Kt0, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.v.hashCode();
    }

    @Override // defpackage.Ft0
    public final int i(Object[] objArr) {
        objArr[0] = this.v;
        return 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // defpackage.Ft0
    /* JADX INFO: renamed from: t */
    public final AbstractC0494ck2 iterator() {
        return new oA0(this.v);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return "[" + this.v.toString() + ']';
    }
}
