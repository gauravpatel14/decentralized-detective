package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class st1 extends Kt0 {
    public static final Object[] A;
    public static final st1 B;
    public final transient Object[] v;
    public final transient int w;
    public final transient Object[] x;
    public final transient int y;
    public final transient int z;

    static {
        Object[] objArr = new Object[0];
        A = objArr;
        B = new st1(0, 0, 0, objArr, objArr);
    }

    public st1(int i, int i2, int i3, Object[] objArr, Object[] objArr2) {
        this.v = objArr;
        this.w = i;
        this.x = objArr2;
        this.y = i2;
        this.z = i3;
    }

    @Override // defpackage.Ft0, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.x;
            if (objArr.length != 0) {
                int iA = AbstractC0017Bn0.a(obj.hashCode());
                while (true) {
                    int i = iA & this.y;
                    Object obj2 = objArr[i];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iA = i + 1;
                }
            }
        }
        return false;
    }

    @Override // defpackage.Kt0, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.w;
    }

    @Override // defpackage.Ft0
    public final int i(Object[] objArr) {
        Object[] objArr2 = this.v;
        int i = this.z;
        System.arraycopy(objArr2, 0, objArr, 0, i);
        return i;
    }

    @Override // defpackage.Ft0
    public final Object[] j() {
        return this.v;
    }

    @Override // defpackage.Ft0
    public final int l() {
        return this.z;
    }

    @Override // defpackage.Ft0
    public final int p() {
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.z;
    }

    @Override // defpackage.Ft0
    /* JADX INFO: renamed from: t */
    public final AbstractC0494ck2 iterator() {
        return f().listIterator(0);
    }

    @Override // defpackage.Kt0
    public final It0 w() {
        return It0.u(this.z, this.v);
    }
}
