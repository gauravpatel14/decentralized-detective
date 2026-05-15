package defpackage;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.vision.barcode.Barcode;
import org.chromium.mojo.system.MojoException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Pm implements Om {
    public kn t;

    @Override // defpackage.Ny0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.t.d();
    }

    @Override // defpackage.DJ
    public final void d(MojoException mojoException) {
        close();
    }

    @Override // defpackage.Om
    public final void p1(sq sqVar, gn gnVar) {
        kn knVar = this.t;
        if (!knVar.c.c()) {
            Log.e("cr_BarcodeDetectionImpl", "BarcodeDetector is not operational");
            gnVar.a(new C0435bn[0]);
            return;
        }
        aj0 aj0VarB = vq.b(sqVar);
        if (aj0VarB == null) {
            Log.e("cr_BarcodeDetectionImpl", "Error converting Mojom Bitmap to Frame");
            gnVar.a(new C0435bn[0]);
            return;
        }
        SparseArray sparseArrayA = knVar.a(aj0VarB);
        C0435bn[] c0435bnArr = new C0435bn[sparseArrayA.size()];
        for (int i = 0; i < sparseArrayA.size(); i++) {
            c0435bnArr[i] = new C0435bn(0);
            Barcode barcode = (Barcode) sparseArrayA.valueAt(i);
            c0435bnArr[i].b = barcode.u;
            int iMin = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            int i2 = 0;
            int iMax = Integer.MIN_VALUE;
            int iMax2 = Integer.MIN_VALUE;
            int iMin2 = Integer.MAX_VALUE;
            while (true) {
                Point[] pointArr = barcode.x;
                if (i2 < pointArr.length) {
                    Point point = pointArr[i2];
                    iMin = Math.min(iMin, point.x);
                    iMax = Math.max(iMax, point.x);
                    iMin2 = Math.min(iMin2, point.y);
                    iMax2 = Math.max(iMax2, point.y);
                    i2++;
                } else {
                    Rect rect = new Rect(iMin, iMin2, iMax, iMax2);
                    c0435bnArr[i].c = new Kr1(0);
                    Kr1 kr1 = c0435bnArr[i].c;
                    kr1.b = rect.left;
                    kr1.c = rect.top;
                    kr1.d = rect.width();
                    c0435bnArr[i].c.e = rect.height();
                    c0435bnArr[i].e = new C0492ci1[pointArr.length];
                    for (int i3 = 0; i3 < pointArr.length; i3++) {
                        c0435bnArr[i].e[i3] = new C0492ci1(0);
                        C0492ci1 c0492ci1 = c0435bnArr[i].e[i3];
                        Point point2 = pointArr[i3];
                        c0492ci1.b = point2.x;
                        c0492ci1.c = point2.y;
                    }
                    C0435bn c0435bn = c0435bnArr[i];
                    int i4 = barcode.t;
                    int i5 = 1;
                    if (i4 != 1) {
                        i5 = 2;
                        if (i4 != 2) {
                            switch (i4) {
                                case 4:
                                    i5 = 3;
                                    break;
                                case 8:
                                    i5 = 4;
                                    break;
                                case 16:
                                    i5 = 5;
                                    break;
                                case 32:
                                    i5 = 6;
                                    break;
                                case 64:
                                    i5 = 7;
                                    break;
                                case 128:
                                    i5 = 8;
                                    break;
                                case 256:
                                    i5 = 10;
                                    break;
                                case 512:
                                    i5 = 12;
                                    break;
                                case 1024:
                                    i5 = 13;
                                    break;
                                case 2048:
                                    i5 = 9;
                                    break;
                                case 4096:
                                    i5 = 0;
                                    break;
                                default:
                                    i5 = 11;
                                    break;
                            }
                        }
                    }
                    c0435bn.d = i5;
                }
            }
        }
        gnVar.a(c0435bnArr);
    }
}
