package defpackage;

import java.util.Objects;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class qt1 extends It0 {
    public final transient Object[] v;
    public final transient int w;
    public final transient int x;

    public qt1(Object[] objArr, int i, int i2) {
        this.v = objArr;
        this.w = i;
        this.x = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        Object obj = this.v[(i * 2) + this.w];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // defpackage.Ft0
    public final boolean s() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.x;
    }
}
