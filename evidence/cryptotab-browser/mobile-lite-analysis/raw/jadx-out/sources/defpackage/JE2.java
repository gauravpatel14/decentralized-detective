package defpackage;

import java.util.Objects;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class JE2 extends AD2 {
    public final transient Object[] v;
    public final transient int w;
    public final transient int x;

    public JE2(Object[] objArr, int i, int i2) {
        this.v = objArr;
        this.w = i;
        this.x = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        YB2.a(i, this.x);
        Object obj = this.v[i + i + this.w];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // defpackage.AbstractC0335aD2
    public final boolean p() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.x;
    }
}
