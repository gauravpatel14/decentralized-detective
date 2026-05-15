package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class NZ {
    public String a;
    public final String b;
    public final long c;
    public final long d;
    public final int e;

    public NZ(String str, String str2, long j, long j2, int i) {
        this(str2, j, j2, i);
        this.a = str;
    }

    public final Object clone() {
        return new NZ(this.a, this.b, this.c, this.d, this.e);
    }

    public NZ(String str, long j, long j2, int i) {
        this.b = str;
        this.c = j;
        this.d = j2;
        this.e = i;
    }
}
