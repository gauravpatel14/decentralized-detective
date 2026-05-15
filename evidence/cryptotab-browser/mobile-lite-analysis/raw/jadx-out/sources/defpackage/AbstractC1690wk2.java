package defpackage;

/* JADX INFO: renamed from: wk2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1690wk2 {
    public static String a(long j) {
        if (j == 0) {
            return "0";
        }
        if (j > 0) {
            return Long.toString(j, 10);
        }
        char[] cArr = new char[64];
        long j2 = (j >>> 1) / ((long) 5);
        long j3 = 10;
        int i = 63;
        cArr[63] = Character.forDigit((int) (j - (j2 * j3)), 10);
        while (j2 > 0) {
            i--;
            cArr[i] = Character.forDigit((int) (j2 % j3), 10);
            j2 /= j3;
        }
        return new String(cArr, i, 64 - i);
    }
}
