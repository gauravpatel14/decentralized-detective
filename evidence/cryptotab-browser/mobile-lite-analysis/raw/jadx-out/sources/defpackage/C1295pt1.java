package defpackage;

/* JADX INFO: renamed from: pt1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1295pt1 extends Kt0 {
    public final transient rt1 v;
    public final transient qt1 w;

    public C1295pt1(rt1 rt1Var, qt1 qt1Var) {
        this.v = rt1Var;
        this.w = qt1Var;
    }

    @Override // defpackage.Ft0, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.v.get(obj) != null;
    }

    @Override // defpackage.Kt0, defpackage.Ft0
    public final It0 f() {
        return this.w;
    }

    @Override // defpackage.Ft0
    public final int i(Object[] objArr) {
        return this.w.i(objArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.v.y;
    }

    @Override // defpackage.Ft0
    /* JADX INFO: renamed from: t */
    public final AbstractC0494ck2 iterator() {
        return this.w.listIterator(0);
    }
}
