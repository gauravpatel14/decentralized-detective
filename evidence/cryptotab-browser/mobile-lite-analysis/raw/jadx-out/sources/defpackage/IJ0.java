package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class IJ0 {
    public static float a(float[] fArr, float f, float f2) {
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        int iMin = Math.min((int) ((fArr.length - 1) * f2), fArr.length - 2);
        float f3 = (f2 - (iMin * f)) / f;
        float f4 = fArr[iMin];
        return AbstractC0146Mm2.a(fArr[iMin + 1], f4, f3, f4);
    }
}
