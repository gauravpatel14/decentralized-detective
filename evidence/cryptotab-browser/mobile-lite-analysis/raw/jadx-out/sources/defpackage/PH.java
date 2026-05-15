package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class PH {
    public final Object a;
    public final InterfaceC0926jk0 b;

    public PH(InterfaceC0926jk0 interfaceC0926jk0, Object obj) {
        this.a = obj;
        this.b = interfaceC0926jk0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PH)) {
            return false;
        }
        PH ph = (PH) obj;
        return lz0.a(this.a, ph.a) && lz0.a(this.b, ph.b);
    }

    public final int hashCode() {
        Object obj = this.a;
        return this.b.hashCode() + ((obj == null ? 0 : obj.hashCode()) * 31);
    }

    public final String toString() {
        return "CompletedWithCancellation(result=" + this.a + ", onCancellation=" + this.b + ')';
    }
}
