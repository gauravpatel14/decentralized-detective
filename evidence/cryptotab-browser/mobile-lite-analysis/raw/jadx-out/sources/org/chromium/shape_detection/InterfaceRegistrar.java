package org.chromium.shape_detection;

import android.util.Log;
import com.google.android.gms.internal.vision.zzam;
import defpackage.AbstractC1499tM;
import defpackage.B72;
import defpackage.C0761hE2;
import defpackage.C1801yk2;
import defpackage.C1817z82;
import defpackage.C61;
import defpackage.F72;
import defpackage.GS0;
import defpackage.Rm;
import defpackage.TN;
import defpackage.U90;
import defpackage.XE;
import defpackage.Y90;
import defpackage.Zm;
import defpackage.gx1;
import org.chromium.mojo.system.impl.CoreImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class InterfaceRegistrar {
    public static void bindBarcodeDetectionProvider(long j) {
        CoreImpl coreImpl = TN.a;
        coreImpl.getClass();
        GS0 gs0 = new GS0(new C1801yk2(coreImpl, j));
        Rm rm = null;
        if (XE.a(AbstractC1499tM.a)) {
            int iD = C61.d("com.google.android.gms");
            if (iD >= 19742000) {
                rm = new Rm();
            } else if (iD < 0) {
                Log.w("cr_BarcodeProviderImpl", "Google Play Services not available");
            } else {
                Log.w("cr_BarcodeProviderImpl", "Detection disabled (" + iD + " < 19.7.42)");
            }
        } else {
            Log.w("cr_BarcodeProviderImpl", "Google Play Services not available");
        }
        if (rm == null) {
            gs0.close();
            return;
        }
        gx1 gx1Var = new gx1(gs0);
        CoreImpl coreImpl2 = gs0.u;
        gx1Var.t.x = rm;
        gx1Var.u = new Zm(coreImpl2, rm);
        gx1Var.a();
    }

    public static void bindFaceDetectionProvider(long j) {
        U90 u90 = new U90();
        CoreImpl coreImpl = TN.a;
        coreImpl.getClass();
        GS0 gs0 = new GS0(new C1801yk2(coreImpl, j));
        gx1 gx1Var = new gx1(gs0);
        CoreImpl coreImpl2 = gs0.u;
        gx1Var.t.x = u90;
        gx1Var.u = new Y90(coreImpl2, u90);
        gx1Var.a();
    }

    public static void bindTextDetection(long j) {
        CoreImpl coreImpl = TN.a;
        coreImpl.getClass();
        GS0 gs0 = new GS0(new C1801yk2(coreImpl, j));
        B72 b72 = null;
        if (XE.a(AbstractC1499tM.a)) {
            B72 b722 = new B72();
            b722.t = new C1817z82(new C0761hE2(AbstractC1499tM.a, new zzam(null)));
            b72 = b722;
        } else {
            Log.e("cr_TextDetectionImpl", "Google Play Services not available");
        }
        if (b72 == null) {
            gs0.close();
            return;
        }
        gx1 gx1Var = new gx1(gs0);
        CoreImpl coreImpl2 = gs0.u;
        gx1Var.t.x = b72;
        gx1Var.u = new F72(coreImpl2, b72);
        gx1Var.a();
    }
}
