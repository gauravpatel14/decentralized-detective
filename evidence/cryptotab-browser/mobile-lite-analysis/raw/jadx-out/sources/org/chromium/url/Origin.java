package org.chromium.url;

import J.N;
import defpackage.B51;
import defpackage.C0270Wj2;
import java.util.Objects;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class Origin {
    public final String a;
    public final String b;
    public final short c;
    public final boolean d;
    public final long e;
    public final long f;

    public Origin(B51 b51) {
        this.a = b51.b;
        this.b = b51.c;
        this.c = b51.d;
        C0270Wj2 c0270Wj2 = b51.e;
        if (c0270Wj2 != null) {
            this.d = true;
            this.e = c0270Wj2.b;
            this.f = c0270Wj2.c;
        } else {
            this.d = false;
            this.e = 0L;
            this.f = 0L;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Origin)) {
            return false;
        }
        Origin origin = (Origin) obj;
        return this.a.equals(origin.a) && this.b.equals(origin.b) && this.c == origin.c && this.d == origin.d && this.e == origin.e && this.f == origin.f;
    }

    public final int hashCode() {
        return Objects.hash(this.a, this.b, Short.valueOf(this.c), Boolean.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.f));
    }

    public final long toNativeOrigin() {
        return N._J_ZJJSOO(0, this.d, this.e, this.f, this.c, this.a, this.b);
    }

    public final String toString() {
        if (this.d) {
            return "null";
        }
        return this.a + "://" + this.b + ":" + ((int) this.c);
    }

    public Origin(String str, String str2, short s, boolean z, long j, long j2) {
        this.a = str;
        this.b = str2;
        this.c = s;
        this.d = z;
        this.e = j;
        this.f = j2;
    }
}
