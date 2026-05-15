package defpackage;

import java.util.Map;

/* JADX INFO: renamed from: ot1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1237ot1 extends Kt0 {
    public final transient rt1 v;
    public final transient Object[] w;
    public final transient int x;

    public C1237ot1(rt1 rt1Var, Object[] objArr, int i) {
        this.v = rt1Var;
        this.w = objArr;
        this.x = i;
    }

    @Override // defpackage.Ft0, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object value = entry.getValue();
        return value != null && value.equals(this.v.get(key));
    }

    @Override // defpackage.Ft0
    public final int i(Object[] objArr) {
        return f().i(objArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.x;
    }

    @Override // defpackage.Ft0
    /* JADX INFO: renamed from: t */
    public final AbstractC0494ck2 iterator() {
        return f().listIterator(0);
    }

    @Override // defpackage.Kt0
    public final It0 w() {
        return new C1174nt1(this);
    }
}
