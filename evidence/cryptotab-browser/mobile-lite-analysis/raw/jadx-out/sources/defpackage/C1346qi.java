package defpackage;

import java.util.ArrayList;

/* JADX INFO: renamed from: qi, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1346qi {
    public final String a;
    public final ArrayList b;

    public C1346qi(String str, ArrayList arrayList) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.a = str;
        this.b = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1346qi)) {
            return false;
        }
        C1346qi c1346qi = (C1346qi) obj;
        return this.a.equals(c1346qi.a) && this.b.equals(c1346qi.b);
    }

    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public final String toString() {
        return "HeartBeatResult{userAgent=" + this.a + ", usedDates=" + this.b + "}";
    }
}
