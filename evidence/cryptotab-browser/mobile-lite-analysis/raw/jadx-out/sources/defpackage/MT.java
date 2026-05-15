package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class MT {
    public final int a;
    public final int b;

    public MT(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || MT.class != obj.getClass()) {
            return false;
        }
        MT mt = (MT) obj;
        return this.b == mt.b && this.a == mt.a;
    }

    public final int hashCode() {
        return ((this.b + 31) * 31) + this.a;
    }
}
