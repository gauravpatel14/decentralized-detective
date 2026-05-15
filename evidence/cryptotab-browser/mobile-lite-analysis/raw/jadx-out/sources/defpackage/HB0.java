package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class HB0 {
    public final String a;

    public HB0(String str) {
        this.a = str.substring(0, str.length() - 1);
    }

    public final String a(int i) {
        return this.a + i;
    }

    public final String b(String str) {
        return S3.a(new StringBuilder(), this.a, str);
    }
}
