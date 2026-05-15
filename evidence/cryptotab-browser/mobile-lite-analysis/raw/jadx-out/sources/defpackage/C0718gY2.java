package defpackage;

/* JADX INFO: renamed from: gY2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0718gY2 {
    public final CU2 a;
    public final String b;
    public final Object[] c;
    public final int d;

    public C0718gY2(CU2 cu2, String str, Object[] objArr) {
        this.a = cu2;
        this.b = str;
        this.c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.d = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 1;
        int i3 = 13;
        while (true) {
            int i4 = i2 + 1;
            char cCharAt2 = str.charAt(i2);
            if (cCharAt2 < 55296) {
                this.d = i | (cCharAt2 << i3);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i3;
                i3 += 13;
                i2 = i4;
            }
        }
    }

    public final CU2 a() {
        return this.a;
    }

    public final int b() {
        return (this.d & 1) == 1 ? 1 : 2;
    }

    public final String c() {
        return this.b;
    }

    public final Object[] d() {
        return this.c;
    }
}
