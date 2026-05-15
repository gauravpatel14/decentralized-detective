package defpackage;

import java.util.AbstractMap;
import java.util.Objects;

/* JADX INFO: renamed from: sE2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1431sE2 extends AD2 {
    public final /* synthetic */ C1770yE2 v;

    public C1431sE2(C1770yE2 c1770yE2) {
        this.v = c1770yE2;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        C1770yE2 c1770yE2 = this.v;
        YB2.a(i, c1770yE2.x);
        int i2 = i + i;
        Object[] objArr = c1770yE2.w;
        Object obj = objArr[i2];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[i2 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // defpackage.AbstractC0335aD2
    public final boolean p() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.v.x;
    }
}
