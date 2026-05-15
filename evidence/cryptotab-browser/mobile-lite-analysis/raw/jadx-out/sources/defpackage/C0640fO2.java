package defpackage;

/* JADX INFO: renamed from: fO2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0640fO2 {
    public final AbstractC0948kF2 a;
    public final String b;
    public final Object[] c;
    public final int d;

    public C0640fO2(AbstractC0948kF2 abstractC0948kF2, String str, Object[] objArr) {
        this.a = abstractC0948kF2;
        this.b = str;
        this.c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.d = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 < 55296) {
                this.d = i | (cCharAt2 << i2);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    public final AbstractC0948kF2 a() {
        return this.a;
    }

    public final int b() {
        int i = this.d;
        if ((i & 1) != 0) {
            return 1;
        }
        return (i & 4) == 4 ? 3 : 2;
    }

    public final String c() {
        return this.b;
    }

    public final Object[] d() {
        return this.c;
    }
}
