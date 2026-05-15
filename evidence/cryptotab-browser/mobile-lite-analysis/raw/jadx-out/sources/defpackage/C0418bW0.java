package defpackage;

import java.io.Serializable;

/* JADX INFO: renamed from: bW0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0418bW0 extends x implements Serializable {
    public static final C0418bW0 v;
    public final int t;
    public final boolean u;

    static {
        new C0418bW0(0, false);
        v = new C0418bW0(0, true);
        new C0418bW0(AbstractC0004An0.a, true);
    }

    public C0418bW0(int i, boolean z) {
        this.t = i;
        this.u = z;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0418bW0)) {
            return false;
        }
        C0418bW0 c0418bW0 = (C0418bW0) obj;
        return this.t == c0418bW0.t && this.u == c0418bW0.u;
    }

    public final int hashCode() {
        return C0418bW0.class.hashCode() ^ this.t;
    }

    public final String toString() {
        return "Hashing.murmur3_32(" + this.t + ")";
    }
}
