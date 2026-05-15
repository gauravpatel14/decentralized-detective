package defpackage;

/* JADX INFO: renamed from: eM1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0574eM1 implements Comparable {
    public final String t;
    public final String u;
    public final Object[] v;
    public int w;
    public int x;

    public C0574eM1(Object obj, String str, String str2) {
        this.t = str;
        this.u = str2;
        this.v = obj == null ? null : new Object[]{obj};
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        int i = this.w;
        int i2 = ((C0574eM1) obj).w;
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public final boolean equals(Object obj) {
        int i;
        int i2;
        return (obj instanceof C0574eM1) && (i = this.w) >= (i2 = ((C0574eM1) obj).w) && i == i2;
    }

    public final int hashCode() {
        return 0;
    }

    public C0574eM1(Object... objArr) {
        this.t = "<new>";
        this.u = "</new>";
        this.v = objArr;
    }
}
