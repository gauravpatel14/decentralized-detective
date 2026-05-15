package defpackage;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: yE2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1770yE2 extends AbstractC0453cE2 {
    public final transient PE2 v;
    public final transient Object[] w;
    public final transient int x;

    public C1770yE2(PE2 pe2, Object[] objArr, int i) {
        this.v = pe2;
        this.w = objArr;
        this.x = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.v.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.AbstractC0335aD2
    public final int f(Object[] objArr) {
        return l().f(objArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return l().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.x;
    }

    @Override // defpackage.AbstractC0453cE2
    public final AD2 t() {
        return new C1431sE2(this);
    }
}
