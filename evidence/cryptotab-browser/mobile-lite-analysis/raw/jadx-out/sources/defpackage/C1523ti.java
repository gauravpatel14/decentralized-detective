package defpackage;

/* JADX INFO: renamed from: ti, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1523ti {
    public final String a;
    public final String b;

    public C1523ti(String str, String str2) {
        this.a = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1523ti)) {
            return false;
        }
        C1523ti c1523ti = (C1523ti) obj;
        return this.a.equals(c1523ti.a) && this.b.equals(c1523ti.b);
    }

    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LibraryVersion{libraryName=");
        sb.append(this.a);
        sb.append(", version=");
        return S3.a(sb, this.b, "}");
    }
}
