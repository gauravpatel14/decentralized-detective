package defpackage;

import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.zzae;
import com.google.android.gms.internal.cast.zzdb;

/* JADX INFO: renamed from: hK2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0768hK2 implements Runnable {
    public final /* synthetic */ OJ2 t;
    public final /* synthetic */ zzdb u;

    public RunnableC0768hK2(OJ2 oj2, zzdb zzdbVar) {
        this.t = oj2;
        this.u = zzdbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        boolean z2;
        YL2 yl2 = OJ2.Q;
        OJ2 oj2 = this.t;
        zzdb zzdbVar = this.u;
        ApplicationMetadata applicationMetadata = zzdbVar.w;
        boolean zA = AbstractC0700gL2.a(applicationMetadata, oj2.t);
        Ky ky = oj2.v;
        if (!zA) {
            oj2.t = applicationMetadata;
            ky.c(applicationMetadata);
        }
        double d = zzdbVar.t;
        boolean z3 = true;
        if (Double.isNaN(d) || Math.abs(d - oj2.F) <= 1.0E-7d) {
            z = false;
        } else {
            oj2.F = d;
            z = true;
        }
        boolean z4 = oj2.B;
        boolean z5 = zzdbVar.u;
        if (z5 != z4) {
            oj2.B = z5;
            z = true;
        }
        Double.isNaN(zzdbVar.z);
        OJ2.Q.getClass();
        if (ky != null && (z || oj2.D)) {
            ky.f();
        }
        int i = oj2.H;
        int i2 = zzdbVar.v;
        if (i2 != i) {
            oj2.H = i2;
            z2 = true;
        } else {
            z2 = false;
        }
        if (ky != null && (z2 || oj2.D)) {
            ky.a(oj2.H);
        }
        int i3 = oj2.I;
        int i4 = zzdbVar.x;
        if (i4 != i3) {
            oj2.I = i4;
        } else {
            z3 = false;
        }
        if (ky != null && (z3 || oj2.D)) {
            ky.e(oj2.I);
        }
        zzae zzaeVar = oj2.G;
        zzae zzaeVar2 = zzdbVar.y;
        if (!AbstractC0700gL2.a(zzaeVar, zzaeVar2)) {
            oj2.G = zzaeVar2;
        }
        oj2.D = false;
    }
}
