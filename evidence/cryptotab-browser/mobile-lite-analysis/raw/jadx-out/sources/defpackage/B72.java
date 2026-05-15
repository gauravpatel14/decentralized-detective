package defpackage;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.vision.zzah;
import org.chromium.mojo.system.MojoException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class B72 implements A72 {
    public C1817z82 t;

    @Override // defpackage.A72
    public final void G1(sq sqVar, J72 j72) {
        String string;
        C1817z82 c1817z82 = this.t;
        if (!c1817z82.c.c()) {
            Log.e("cr_TextDetectionImpl", "TextDetector is not operational");
            j72.a(new C72[0]);
            return;
        }
        aj0 aj0VarB = vq.b(sqVar);
        if (aj0VarB == null) {
            Log.e("cr_TextDetectionImpl", "Error converting Mojom Bitmap to Frame");
            j72.a(new C72[0]);
            return;
        }
        SparseArray sparseArrayA = c1817z82.a(aj0VarB);
        C72[] c72Arr = new C72[sparseArrayA.size()];
        for (int i = 0; i < sparseArrayA.size(); i++) {
            c72Arr[i] = new C72(0);
            u72 u72Var = (u72) sparseArrayA.valueAt(i);
            C72 c72 = c72Arr[i];
            zzah[] zzahVarArr = u72Var.a;
            if (zzahVarArr.length == 0) {
                string = "";
            } else {
                StringBuilder sb = new StringBuilder(zzahVarArr[0].x);
                for (int i2 = 1; i2 < zzahVarArr.length; i2++) {
                    sb.append("\n");
                    sb.append(zzahVarArr[i2].x);
                }
                string = sb.toString();
            }
            c72.b = string;
            if (u72Var.c == null) {
                Point[] pointArrA = u72Var.a();
                int iMin = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                int iMax = Integer.MIN_VALUE;
                int iMax2 = Integer.MIN_VALUE;
                int iMin2 = Integer.MAX_VALUE;
                for (Point point : pointArrA) {
                    iMin = Math.min(iMin, point.x);
                    iMax = Math.max(iMax, point.x);
                    iMin2 = Math.min(iMin2, point.y);
                    iMax2 = Math.max(iMax2, point.y);
                }
                u72Var.c = new Rect(iMin, iMin2, iMax, iMax2);
            }
            Rect rect = u72Var.c;
            c72Arr[i].c = new Kr1(0);
            Kr1 kr1 = c72Arr[i].c;
            kr1.b = rect.left;
            kr1.c = rect.top;
            kr1.d = rect.width();
            c72Arr[i].c.e = rect.height();
            Point[] pointArrA2 = u72Var.a();
            c72Arr[i].d = new C0492ci1[pointArrA2.length];
            for (int i3 = 0; i3 < pointArrA2.length; i3++) {
                c72Arr[i].d[i3] = new C0492ci1(0);
                C0492ci1 c0492ci1 = c72Arr[i].d[i3];
                Point point2 = pointArrA2[i3];
                c0492ci1.b = point2.x;
                c0492ci1.c = point2.y;
            }
        }
        j72.a(c72Arr);
    }

    @Override // defpackage.Ny0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.t.d();
    }

    @Override // defpackage.DJ
    public final void d(MojoException mojoException) {
        close();
    }
}
