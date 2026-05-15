package defpackage;

import java.util.Objects;

/* JADX INFO: renamed from: mt1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1112mt1 extends It0 {
    public static final C1112mt1 x = new C1112mt1(0, new Object[0]);
    public final transient Object[] v;
    public final transient int w;

    public C1112mt1(int i, Object[] objArr) {
        this.v = objArr;
        this.w = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        Object obj = this.v[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // defpackage.It0, defpackage.Ft0
    public final int i(Object[] objArr) {
        Object[] objArr2 = this.v;
        int i = this.w;
        System.arraycopy(objArr2, 0, objArr, 0, i);
        return i;
    }

    @Override // defpackage.Ft0
    public final Object[] j() {
        return this.v;
    }

    @Override // defpackage.Ft0
    public final int l() {
        return this.w;
    }

    @Override // defpackage.Ft0
    public final int p() {
        return 0;
    }

    @Override // defpackage.Ft0
    public final boolean s() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.w;
    }
}
