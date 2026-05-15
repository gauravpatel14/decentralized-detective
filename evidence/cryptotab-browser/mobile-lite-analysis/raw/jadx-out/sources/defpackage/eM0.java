package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class eM0 {
    public static boolean a(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    public static float b(float f, float f2, float f3) {
        float f4 = f2 > f3 ? f3 : f2;
        if (f2 <= f3) {
            f2 = f3;
        }
        return f < f4 ? f4 : f > f2 ? f2 : f;
    }

    public static int c(int i, int i2, int i3) {
        int i4 = i2 > i3 ? i3 : i2;
        if (i2 <= i3) {
            i2 = i3;
        }
        return i < i4 ? i4 : i > i2 ? i2 : i;
    }

    public static long d(long j, long j2, long j3) {
        long j4 = j2 > j3 ? j3 : j2;
        if (j2 <= j3) {
            j2 = j3;
        }
        return j < j4 ? j4 : j > j2 ? j2 : j;
    }

    public static float e(float f, float f2, float f3) {
        return AbstractC0146Mm2.a(f2, f, f3, f);
    }
}
