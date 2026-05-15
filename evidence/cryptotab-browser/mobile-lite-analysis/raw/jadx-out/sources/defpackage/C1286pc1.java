package defpackage;

/* JADX INFO: renamed from: pc1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1286pc1 implements jz0 {
    public float[] a;

    public static boolean a(float f, float f2) {
        return Math.abs(f - f2) < 0.01f;
    }

    public final float b(int i) {
        return this.a[(i * 3) + 1];
    }

    public final float c(int i) {
        return this.a[(i * 3) + 2];
    }

    @Override // defpackage.jz0
    public final float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int length = (this.a.length / 3) - 1;
        int i = 0;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < b(i2)) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float fB = b(length) - b(i);
        if (fB == 0.0f) {
            return c(i);
        }
        float fB2 = (f - b(i)) / fB;
        float fC = c(i);
        return ((c(length) - fC) * fB2) + fC;
    }
}
