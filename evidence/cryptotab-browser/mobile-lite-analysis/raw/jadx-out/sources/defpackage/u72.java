package defpackage;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.vision.zzab;
import com.google.android.gms.internal.vision.zzah;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class u72 {
    public zzah[] a;
    public Point[] b;
    public Rect c;

    public final Point[] a() {
        u72 u72Var = this;
        if (u72Var.b == null) {
            zzah[] zzahVarArr = u72Var.a;
            int i = 0;
            if (zzahVarArr.length == 0) {
                u72Var.b = new Point[0];
            } else {
                int iMax = Integer.MIN_VALUE;
                int i2 = 0;
                int iMin = Integer.MAX_VALUE;
                int iMin2 = Integer.MAX_VALUE;
                int iMax2 = Integer.MIN_VALUE;
                while (i2 < zzahVarArr.length) {
                    zzab zzabVar = zzahVarArr[i2].u;
                    zzab zzabVar2 = zzahVarArr[i].u;
                    int i3 = -zzabVar2.t;
                    int i4 = -zzabVar2.u;
                    float f = zzabVar2.x;
                    double dSin = Math.sin(Math.toRadians(f));
                    int i5 = iMax2;
                    double dCos = Math.cos(Math.toRadians(f));
                    Point point = new Point(zzabVar.t, zzabVar.u);
                    point.offset(i3, i4);
                    Point[] pointArr = {point, new Point(i + i, i), new Point(i + i, i + i), new Point(i, i + i)};
                    Point point2 = pointArr[0];
                    int i6 = point2.x;
                    int i7 = point2.y;
                    int i8 = iMin;
                    int i9 = iMin2;
                    int i10 = (int) ((((double) i7) * dSin) + (((double) i6) * dCos));
                    int i11 = (int) ((((double) i7) * dCos) + (((double) (-i6)) * dSin));
                    point2.x = i10;
                    point2.y = i11;
                    int i12 = zzabVar.v;
                    int i13 = zzabVar.w;
                    iMax2 = i5;
                    iMin = i8;
                    iMin2 = i9;
                    for (int i14 = 0; i14 < 4; i14++) {
                        Point point3 = pointArr[i14];
                        iMin = Math.min(iMin, point3.x);
                        iMax = Math.max(iMax, point3.x);
                        iMin2 = Math.min(iMin2, point3.y);
                        iMax2 = Math.max(iMax2, point3.y);
                    }
                    i2++;
                    i = 0;
                }
                int i15 = i;
                int i16 = iMax2;
                int i17 = iMin;
                int i18 = iMin2;
                zzab zzabVar3 = zzahVarArr[i15].u;
                int i19 = zzabVar3.t;
                float f2 = zzabVar3.x;
                double dSin2 = Math.sin(Math.toRadians(f2));
                double dCos2 = Math.cos(Math.toRadians(f2));
                Point[] pointArr2 = {new Point(i17, i18), new Point(iMax, i18), new Point(iMax, i16), new Point(i17, i16)};
                while (i15 < 4) {
                    Point point4 = pointArr2[i15];
                    int i20 = point4.x;
                    int i21 = point4.y;
                    point4.x = (int) ((((double) i20) * dCos2) - (((double) i21) * dSin2));
                    point4.y = (int) ((((double) i21) * dCos2) + (((double) i20) * dSin2));
                    point4.offset(i19, zzabVar3.u);
                    i15++;
                }
                u72Var = this;
                u72Var.b = pointArr2;
            }
        }
        return u72Var.b;
    }
}
