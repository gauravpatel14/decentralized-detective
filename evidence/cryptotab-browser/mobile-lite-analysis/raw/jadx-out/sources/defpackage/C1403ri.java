package defpackage;

/* JADX INFO: renamed from: ri, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1403ri {
    public final String a;
    public final String b;
    public final String c;
    public final xi d;
    public final int e;

    public C1403ri(String str, String str2, String str3, xi xiVar, int i) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = xiVar;
        this.e = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1403ri)) {
            return false;
        }
        C1403ri c1403ri = (C1403ri) obj;
        String str = this.a;
        if (str != null ? str.equals(c1403ri.a) : c1403ri.a == null) {
            String str2 = this.b;
            if (str2 != null ? str2.equals(c1403ri.b) : c1403ri.b == null) {
                String str3 = this.c;
                if (str3 != null ? str3.equals(c1403ri.c) : c1403ri.c == null) {
                    xi xiVar = this.d;
                    if (xiVar != null ? xiVar.equals(c1403ri.d) : c1403ri.d == null) {
                        int i = this.e;
                        if (i == 0) {
                            if (c1403ri.e == 0) {
                                return true;
                            }
                        } else if (aM1.a(i, c1403ri.e)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.c;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        xi xiVar = this.d;
        int iHashCode4 = (iHashCode3 ^ (xiVar == null ? 0 : xiVar.hashCode())) * 1000003;
        int i = this.e;
        return (i != 0 ? aM1.b(i) : 0) ^ iHashCode4;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("InstallationResponse{uri=");
        sb.append(this.a);
        sb.append(", fid=");
        sb.append(this.b);
        sb.append(", refreshToken=");
        sb.append(this.c);
        sb.append(", authToken=");
        sb.append(this.d);
        sb.append(", responseCode=");
        int i = this.e;
        sb.append(i != 1 ? i != 2 ? "null" : "BAD_CONFIG" : "OK");
        sb.append("}");
        return sb.toString();
    }
}
