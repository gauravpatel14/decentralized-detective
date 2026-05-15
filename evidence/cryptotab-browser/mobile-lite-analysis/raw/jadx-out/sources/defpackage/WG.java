package defpackage;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class WG {
    public static final UG f = new UG();
    public final int[] a;
    public final int[] b;
    public final ArrayList c;
    public final L81[] d;
    public final float[] e = new float[3];

    public WG(int[] iArr, int i, L81[] l81Arr) {
        VG vg;
        this.d = l81Arr;
        int[] iArr2 = new int[32768];
        this.b = iArr2;
        int i2 = 0;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int i4 = iArr[i3];
            int iB = b(Color.blue(i4), 8, 5) | (b(Color.red(i4), 8, 5) << 10) | (b(Color.green(i4), 8, 5) << 5);
            iArr[i3] = iB;
            iArr2[iB] = iArr2[iB] + 1;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < 32768; i6++) {
            if (iArr2[i6] > 0) {
                int iRgb = Color.rgb(b((i6 >> 10) & 31, 5, 8), b((i6 >> 5) & 31, 5, 8), b(i6 & 31, 5, 8));
                ThreadLocal threadLocal = AbstractC1721xH.a;
                int iRed = Color.red(iRgb);
                int iGreen = Color.green(iRgb);
                int iBlue = Color.blue(iRgb);
                float[] fArr = this.e;
                AbstractC1721xH.a(iRed, iGreen, iBlue, fArr);
                if (c(fArr)) {
                    iArr2[i6] = 0;
                }
            }
            if (iArr2[i6] > 0) {
                i5++;
            }
        }
        int[] iArr3 = new int[i5];
        this.a = iArr3;
        int i7 = 0;
        for (int i8 = 0; i8 < 32768; i8++) {
            if (iArr2[i8] > 0) {
                iArr3[i7] = i8;
                i7++;
            }
        }
        if (i5 <= i) {
            this.c = new ArrayList();
            while (i2 < i5) {
                int i9 = iArr3[i2];
                this.c.add(new N81(Color.rgb(b((i9 >> 10) & 31, 5, 8), b((i9 >> 5) & 31, 5, 8), b(i9 & 31, 5, 8)), iArr2[i9]));
                i2++;
            }
            return;
        }
        PriorityQueue<VG> priorityQueue = new PriorityQueue(i, f);
        priorityQueue.offer(new VG(this, 0, this.a.length - 1));
        while (priorityQueue.size() < i && (vg = (VG) priorityQueue.poll()) != null) {
            int i10 = vg.b;
            int iMin = vg.a;
            if ((i10 + 1) - iMin <= 1) {
                break;
            }
            if ((i10 + 1) - iMin <= 1) {
                throw new IllegalStateException("Can not split a box with only 1 color");
            }
            int i11 = vg.e - vg.d;
            int i12 = vg.g - vg.f;
            int i13 = vg.i - vg.h;
            int i14 = (i11 < i12 || i11 < i13) ? (i12 < i11 || i12 < i13) ? -1 : -2 : -3;
            WG wg = vg.j;
            int[] iArr4 = wg.a;
            a(iArr4, i14, iMin, i10);
            Arrays.sort(iArr4, iMin, vg.b + 1);
            a(iArr4, i14, iMin, vg.b);
            int i15 = vg.c / 2;
            int i16 = i2;
            int i17 = iMin;
            while (true) {
                int i18 = vg.b;
                if (i17 <= i18) {
                    i16 += wg.b[iArr4[i17]];
                    if (i16 >= i15) {
                        iMin = Math.min(i18 - 1, i17);
                        break;
                    }
                    i17++;
                }
            }
            VG vg2 = new VG(wg, iMin + 1, vg.b);
            vg.b = iMin;
            vg.a();
            priorityQueue.offer(vg2);
            priorityQueue.offer(vg);
            i2 = 0;
        }
        ArrayList arrayList = new ArrayList(priorityQueue.size());
        for (VG vg3 : priorityQueue) {
            WG wg2 = vg3.j;
            int[] iArr5 = wg2.a;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            for (int i23 = vg3.a; i23 <= vg3.b; i23++) {
                int i24 = iArr5[i23];
                int i25 = wg2.b[i24];
                i20 += i25;
                i19 = (((i24 >> 10) & 31) * i25) + i19;
                i21 = (((i24 >> 5) & 31) * i25) + i21;
                i22 += i25 * (i24 & 31);
            }
            float f2 = i20;
            N81 n81 = new N81(Color.rgb(b(Math.round(i19 / f2), 5, 8), b(Math.round(i21 / f2), 5, 8), b(Math.round(i22 / f2), 5, 8)), i20);
            if (!c(n81.b())) {
                arrayList.add(n81);
            }
        }
        this.c = arrayList;
    }

    public static void a(int[] iArr, int i, int i2, int i3) {
        if (i == -2) {
            while (i2 <= i3) {
                int i4 = iArr[i2];
                iArr[i2] = (i4 & 31) | (((i4 >> 5) & 31) << 10) | (((i4 >> 10) & 31) << 5);
                i2++;
            }
            return;
        }
        if (i != -1) {
            return;
        }
        while (i2 <= i3) {
            int i5 = iArr[i2];
            iArr[i2] = ((i5 >> 10) & 31) | ((i5 & 31) << 10) | (((i5 >> 5) & 31) << 5);
            i2++;
        }
    }

    public static int b(int i, int i2, int i3) {
        return (i3 > i2 ? i << (i3 - i2) : i >> (i2 - i3)) & ((1 << i3) - 1);
    }

    public final boolean c(float[] fArr) {
        L81[] l81Arr = this.d;
        if (l81Arr != null && l81Arr.length > 0) {
            for (L81 l81 : l81Arr) {
                l81.getClass();
                float f2 = fArr[2];
                if (f2 < 0.95f && f2 > 0.05f) {
                    float f3 = fArr[0];
                    if (f3 < 10.0f || f3 > 37.0f || fArr[1] > 0.82f) {
                    }
                }
                return true;
            }
        }
        return false;
    }
}
