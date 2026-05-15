package defpackage;

import android.content.Context;
import android.graphics.PointF;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.vision.face.internal.client.zzf;
import java.util.ArrayList;
import java.util.List;
import org.chromium.mojo.system.MojoException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class S90 implements P90 {
    public final int t;
    public final boolean u;
    public final C0912ja0 v;

    public S90(C0974ka0 c0974ka0) {
        boolean z;
        int i;
        boolean z2;
        Context context = AbstractC1499tM.a;
        int iMin = Math.min(c0974ka0.b, 32);
        this.t = iMin;
        boolean z3 = c0974ka0.c;
        this.u = z3;
        int i2 = !z3 ? 1 : 0;
        boolean z4 = false;
        if (z3 || i2 == 1 || i2 == 2) {
            z = iMin == 1;
            i = 1;
        } else {
            try {
                StringBuilder sb = new StringBuilder(25);
                sb.append("Invalid mode: ");
                sb.append(i2);
                throw new IllegalArgumentException(sb.toString());
            } catch (IllegalArgumentException e) {
                Log.e("cr_FaceDetectionImpl", "Unexpected exception " + e);
                z = false;
                i = 0;
                i2 = 0;
            }
        }
        zzf zzfVar = new zzf();
        zzfVar.t = i2;
        zzfVar.u = i;
        zzfVar.v = 0;
        zzfVar.w = z;
        zzfVar.x = true;
        zzfVar.y = -1.0f;
        if (i2 == 2 || i != 2) {
            z2 = true;
        } else {
            Log.e("FaceDetector", "Contour is not supported for non-SELFIE mode.");
            z2 = false;
        }
        if (zzfVar.u == 2 && zzfVar.v == 1) {
            Log.e("FaceDetector", "Classification is not supported with contour.");
        } else {
            z4 = z2;
        }
        if (!z4) {
            throw new IllegalArgumentException("Invalid build options");
        }
        this.v = new C0912ja0(new DF2(context, zzfVar));
    }

    @Override // defpackage.Ny0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.v.d();
    }

    @Override // defpackage.DJ
    public final void d(MojoException mojoException) {
        close();
    }

    @Override // defpackage.P90
    public final void x0(sq sqVar, C0656fa0 c0656fa0) {
        C0912ja0 c0912ja0 = this.v;
        if (!c0912ja0.d.c()) {
            Log.e("cr_FaceDetectionImpl", "FaceDetector is not operational");
            C0974ka0 c0974ka0 = new C0974ka0(0);
            c0974ka0.c = this.u;
            c0974ka0.b = this.t;
            new R90(c0974ka0).x0(sqVar, c0656fa0);
            return;
        }
        aj0 aj0VarB = vq.b(sqVar);
        if (aj0VarB == null) {
            Log.e("cr_FaceDetectionImpl", "Error converting Mojom Bitmap to Frame");
            c0656fa0.a(new C0364aa0[0]);
            return;
        }
        SparseArray sparseArrayA = c0912ja0.a(aj0VarB);
        C0364aa0[] c0364aa0Arr = new C0364aa0[sparseArrayA.size()];
        for (int i = 0; i < sparseArrayA.size(); i++) {
            c0364aa0Arr[i] = new C0364aa0(0);
            O90 o90 = (O90) sparseArrayA.valueAt(i);
            o90.getClass();
            PointF pointF = o90.b;
            float f = pointF.x;
            float f2 = o90.c;
            float f3 = pointF.y;
            float f4 = o90.d;
            PointF pointF2 = new PointF(f - (f2 / 2.0f), f3 - (f4 / 2.0f));
            c0364aa0Arr[i].b = new Kr1(0);
            Kr1 kr1 = c0364aa0Arr[i].b;
            kr1.b = pointF2.x;
            kr1.c = pointF2.y;
            kr1.d = f2;
            kr1.e = f4;
            List list = o90.e;
            ArrayList arrayList = new ArrayList(list.size());
            for (int i2 = 0; i2 < list.size(); i2++) {
                TC0 tc0 = (TC0) list.get(i2);
                int i3 = tc0.b;
                if (i3 == 4 || i3 == 10 || i3 == 0 || i3 == 6) {
                    SC0 sc0 = new SC0(0);
                    sc0.b = new C0492ci1[]{new C0492ci1(0)};
                    C0492ci1 c0492ci1 = sc0.b[0];
                    PointF pointF3 = tc0.a;
                    c0492ci1.b = pointF3.x;
                    c0492ci1.c = pointF3.y;
                    if (i3 == 4 || i3 == 10) {
                        sc0.c = 1;
                    } else if (i3 == 0) {
                        sc0.c = 0;
                    } else {
                        sc0.c = 2;
                    }
                    arrayList.add(sc0);
                }
            }
            c0364aa0Arr[i].c = (SC0[]) arrayList.toArray(new SC0[arrayList.size()]);
        }
        c0656fa0.a(c0364aa0Arr);
    }
}
