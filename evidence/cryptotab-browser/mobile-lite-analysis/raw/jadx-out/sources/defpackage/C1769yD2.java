package defpackage;

/* JADX INFO: renamed from: yD2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1769yD2 extends AbstractC0760hD2 {
    public static final C1769yD2 x = new C1769yD2(0, new Object[0]);
    public final transient Object[] v;
    public final transient int w;

    public C1769yD2(int i, Object[] objArr) {
        this.v = objArr;
        this.w = i;
    }

    @Override // defpackage.AbstractC0760hD2, defpackage.AbstractC1543uC2
    public final int f(Object[] objArr) {
        Object[] objArr2 = this.v;
        int i = this.w;
        System.arraycopy(objArr2, 0, objArr, 0, i);
        return i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        f23.a(i, this.w);
        Object obj = this.v[i];
        obj.getClass();
        return obj;
    }

    @Override // defpackage.AbstractC1543uC2
    public final int i() {
        return this.w;
    }

    @Override // defpackage.AbstractC1543uC2
    public final int j() {
        return 0;
    }

    @Override // defpackage.AbstractC1543uC2
    public final boolean l() {
        return false;
    }

    @Override // defpackage.AbstractC1543uC2
    public final Object[] p() {
        return this.v;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.w;
    }
}
