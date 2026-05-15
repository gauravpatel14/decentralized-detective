package defpackage;

import java.util.AbstractMap;
import java.util.Objects;

/* JADX INFO: renamed from: nt1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1174nt1 extends It0 {
    public final /* synthetic */ C1237ot1 v;

    public C1174nt1(C1237ot1 c1237ot1) {
        this.v = c1237ot1;
    }

    @Override // java.util.List
    public final Object get(int i) {
        C1237ot1 c1237ot1 = this.v;
        int i2 = c1237ot1.x;
        int i3 = i * 2;
        Object[] objArr = c1237ot1.w;
        Object obj = objArr[i3];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[i3 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // defpackage.Ft0
    public final boolean s() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.v.x;
    }
}
