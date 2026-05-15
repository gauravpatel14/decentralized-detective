package defpackage;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.vision.zzk;
import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.impl.CoreImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Rm implements Qm {
    @Override // defpackage.Qm
    public final void L(Xm xm) {
        Vm vm = new Vm(0);
        vm.b = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13};
        xm.b.g(vm.c(xm.a, new wS0(1, 2, xm.c)));
    }

    @Override // defpackage.Qm
    public final void S0(bz0 bz0Var, ln lnVar) {
        Pm pm = new Pm();
        int[] iArr = lnVar.b;
        int i = 0;
        if (iArr != null && iArr.length > 0) {
            int i2 = 0;
            while (true) {
                int[] iArr2 = lnVar.b;
                if (i >= iArr2.length) {
                    break;
                }
                int i3 = iArr2[i];
                if (i3 == 0) {
                    i2 |= 4096;
                } else if (i3 == 1) {
                    i2 |= 1;
                } else if (i3 == 2) {
                    i2 |= 2;
                } else if (i3 == 3) {
                    i2 |= 4;
                } else if (i3 == 4) {
                    i2 |= 8;
                } else if (i3 == 5) {
                    i2 |= 16;
                } else if (i3 == 6) {
                    i2 |= 32;
                } else if (i3 == 7) {
                    i2 |= 64;
                } else if (i3 == 8) {
                    i2 |= 128;
                } else if (i3 == 9) {
                    i2 |= 2048;
                } else if (i3 == 10) {
                    i2 |= 256;
                } else if (i3 == 12) {
                    i2 |= 512;
                } else if (i3 == 13) {
                    i2 |= 1024;
                } else {
                    Log.e("cr_BarcodeDetectionImpl", "Unsupported barcode format hint: " + i3);
                }
                i++;
            }
            i = i2;
        }
        Context context = AbstractC1499tM.a;
        zzk zzkVar = new zzk();
        zzkVar.t = i;
        pm.t = new kn(new AY2(context, zzkVar));
        FS0 fs0N1 = bz0Var.t.n1();
        gx1 gx1Var = new gx1(fs0N1);
        CoreImpl coreImplF0 = fs0N1.f0();
        gx1Var.t.x = pm;
        gx1Var.u = new in(coreImplF0, pm);
        gx1Var.a();
    }

    @Override // defpackage.Ny0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // defpackage.DJ
    public final void d(MojoException mojoException) {
    }
}
