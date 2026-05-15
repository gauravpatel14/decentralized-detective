package defpackage;

import J.N;

/* JADX INFO: renamed from: Gb0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0080Gb0 {
    public long a;

    public final void a() {
        if (this.a == 0) {
            this.a = e();
        }
    }

    public final String b(String str, String str2) {
        a();
        return (String) N._O_JOO(0, this.a, str, str2);
    }

    public final boolean c(String str, String str2, boolean z) {
        a();
        return N._Z_ZJOO(0, z, this.a, str, str2);
    }

    public final int d(int i, String str, String str2) {
        a();
        return N._I_IJOO(0, i, this.a, str, str2);
    }

    public abstract long e();

    public final boolean f(String str) {
        a();
        return N._Z_JO(0, this.a, str);
    }
}
