package defpackage;

import android.graphics.Path;

/* JADX INFO: renamed from: f9, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0618f9 {
    public static final C1286pc1 a;

    static {
        C1286pc1 c1286pc1 = new C1286pc1();
        Path path = new Path();
        float f = 0.0f;
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(0.2f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        float[] fArrApproximate = path.approximate(0.002f);
        c1286pc1.a = fArrApproximate;
        int length = fArrApproximate.length / 3;
        int i = 0;
        if (C1286pc1.a(c1286pc1.b(0), 0.0f) && C1286pc1.a(c1286pc1.c(0), 0.0f)) {
            int i2 = length - 1;
            if (C1286pc1.a(c1286pc1.b(i2), 1.0f) && C1286pc1.a(c1286pc1.c(i2), 1.0f)) {
                float f2 = 0.0f;
                while (i < length) {
                    float f3 = c1286pc1.a[i * 3];
                    float fB = c1286pc1.b(i);
                    if (f3 == f && fB != f2) {
                        throw new IllegalArgumentException("The Path cannot have discontinuity in the X axis.");
                    }
                    if (fB < f2) {
                        throw new IllegalArgumentException("The Path cannot loop back on itself.");
                    }
                    i++;
                    f = f3;
                    f2 = fB;
                }
                a = c1286pc1;
                return;
            }
        }
        throw new IllegalArgumentException("The Path must start at (0,0) and end at (1,1)");
    }
}
