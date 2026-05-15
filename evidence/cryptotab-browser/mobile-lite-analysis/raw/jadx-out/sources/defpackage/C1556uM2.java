package defpackage;

/* JADX INFO: renamed from: uM2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1556uM2 extends AbstractC1441sM2 {
    public static final C1556uM2 x = new C1556uM2(0, new Object[0]);
    public final transient Object[] v;
    public final transient int w;

    public C1556uM2(int i, Object[] objArr) {
        this.v = objArr;
        this.w = i;
    }

    @Override // defpackage.AbstractC1441sM2, defpackage.AbstractC0462cM2
    public final int f(Object[] objArr) {
        Object[] objArr2 = this.v;
        int i = this.w;
        System.arraycopy(objArr2, 0, objArr, 0, i);
        return i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        RL2.a(i, this.w);
        Object obj = this.v[i];
        obj.getClass();
        return obj;
    }

    @Override // defpackage.AbstractC0462cM2
    public final int i() {
        return this.w;
    }

    @Override // defpackage.AbstractC0462cM2
    public final int j() {
        return 0;
    }

    @Override // defpackage.AbstractC0462cM2
    public final boolean l() {
        return false;
    }

    @Override // defpackage.AbstractC0462cM2
    public final Object[] p() {
        return this.v;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.w;
    }
}
