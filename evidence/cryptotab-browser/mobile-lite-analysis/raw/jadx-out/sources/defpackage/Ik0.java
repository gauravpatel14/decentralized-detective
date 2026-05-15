package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Ik0 extends Vw implements Hk0, zB0, yk0 {
    public final int A;
    public final int z;

    public Ik0(int i, Class cls, Object obj, String str, String str2) {
        super(obj, cls, str, str2, false);
        this.z = i;
        this.A = 0;
    }

    @Override // defpackage.Vw
    public final zB0 a() {
        Gs1.a.getClass();
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Ik0) {
            Ik0 ik0 = (Ik0) obj;
            return this.w.equals(ik0.w) && this.x.equals(ik0.x) && this.A == ik0.A && this.z == ik0.z && this.u.equals(ik0.u) && b().equals(ik0.b());
        }
        if (!(obj instanceof Ik0)) {
            return false;
        }
        zB0 zb0 = this.t;
        if (zb0 == null) {
            a();
            this.t = this;
            zb0 = this;
        }
        return obj.equals(zb0);
    }

    @Override // defpackage.Hk0
    public final int f() {
        return this.z;
    }

    public final int hashCode() {
        b();
        return this.x.hashCode() + ((this.w.hashCode() + (b().hashCode() * 31)) * 31);
    }

    public final String toString() {
        zB0 zb0 = this.t;
        if (zb0 == null) {
            a();
            this.t = this;
            zb0 = this;
        }
        if (zb0 != this) {
            return zb0.toString();
        }
        String str = this.w;
        return "<init>".equals(str) ? "constructor (Kotlin reflection is not available)" : BN0.a("function ", str, " (Kotlin reflection is not available)");
    }
}
