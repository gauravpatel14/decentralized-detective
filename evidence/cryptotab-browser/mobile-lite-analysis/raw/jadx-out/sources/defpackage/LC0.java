package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class LC0 implements Comparable {
    public static final LC0 u = new LC0();
    public final int t = 131092;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.t - ((LC0) obj).t;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        LC0 lc0 = obj instanceof LC0 ? (LC0) obj : null;
        return lc0 != null && this.t == lc0.t;
    }

    public final int hashCode() {
        return this.t;
    }

    public final String toString() {
        return "2.0.20";
    }
}
