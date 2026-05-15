package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class xi {
    public final String a;
    public final long b;
    public final int c;

    public xi(int i, String str, long j) {
        this.a = str;
        this.b = j;
        this.c = i;
    }

    public static wi a() {
        wi wiVar = new wi();
        wiVar.b = 0L;
        return wiVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof xi)) {
            return false;
        }
        xi xiVar = (xi) obj;
        String str = this.a;
        if (str != null ? str.equals(xiVar.a) : xiVar.a == null) {
            if (this.b == xiVar.b) {
                int i = xiVar.c;
                int i2 = this.c;
                if (i2 == 0) {
                    if (i == 0) {
                        return true;
                    }
                } else if (aM1.a(i2, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j = this.b;
        int i = (((iHashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        int i2 = this.c;
        return (i2 != 0 ? aM1.b(i2) : 0) ^ i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TokenResult{token=");
        sb.append(this.a);
        sb.append(", tokenExpirationTimestamp=");
        sb.append(this.b);
        sb.append(", responseCode=");
        int i = this.c;
        sb.append(i != 1 ? i != 2 ? i != 3 ? "null" : "AUTH_ERROR" : "BAD_CONFIG" : "OK");
        sb.append("}");
        return sb.toString();
    }
}
