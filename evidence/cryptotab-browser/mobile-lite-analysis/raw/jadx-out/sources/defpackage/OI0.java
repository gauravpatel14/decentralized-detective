package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class OI0 extends Vw implements InterfaceC0798hk0, DB0 {
    public final boolean z;

    public OI0(int i, Class cls, Object obj, String str, String str2) {
        super(obj, cls, str, str2, (i & 1) == 1);
        this.z = false;
    }

    @Override // defpackage.Vw
    public final zB0 a() {
        Gs1.a.getClass();
        return this;
    }

    @Override // defpackage.InterfaceC0798hk0
    public final Object c() {
        return this.u.getClass().getSimpleName();
    }

    public final zB0 d() {
        if (!this.z) {
            zB0 zb0 = this.t;
            if (zb0 != null) {
                return zb0;
            }
            a();
            this.t = this;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OI0) {
            OI0 oi0 = (OI0) obj;
            return b().equals(oi0.b()) && this.w.equals(oi0.w) && this.x.equals(oi0.x) && this.u.equals(oi0.u);
        }
        if (obj instanceof DB0) {
            return obj.equals(d());
        }
        return false;
    }

    public final int hashCode() {
        return this.x.hashCode() + ((this.w.hashCode() + (b().hashCode() * 31)) * 31);
    }

    public final String toString() {
        zB0 zb0D = d();
        return zb0D != this ? zb0D.toString() : S3.a(new StringBuilder("property "), this.w, " (Kotlin reflection is not available)");
    }
}
