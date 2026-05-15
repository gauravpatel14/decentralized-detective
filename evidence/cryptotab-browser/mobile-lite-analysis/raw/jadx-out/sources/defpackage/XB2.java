package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class XB2 {
    public String a;
    public final long b;
    public final HashMap c;

    public XB2(String str, long j, HashMap map) {
        this.a = str;
        this.b = j;
        HashMap map2 = new HashMap();
        this.c = map2;
        if (map != null) {
            map2.putAll(map);
        }
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final XB2 clone() {
        return new XB2(this.a, this.b, new HashMap(this.c));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XB2)) {
            return false;
        }
        XB2 xb2 = (XB2) obj;
        if (this.b == xb2.b && this.a.equals(xb2.a)) {
            return this.c.equals(xb2.c);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        long j = this.b;
        return this.c.hashCode() + ((iHashCode + ((int) (j ^ (j >>> 32)))) * 31);
    }

    public final String toString() {
        return "Event{name='" + this.a + "', timestamp=" + this.b + ", params=" + this.c.toString() + "}";
    }
}
