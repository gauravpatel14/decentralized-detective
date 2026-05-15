package defpackage;

import com.google.android.gms.internal.cast.zzcj;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TK2 implements Runnable {
    public final /* synthetic */ OJ2 t;
    public final /* synthetic */ zzcj u;

    public TK2(OJ2 oj2, zzcj zzcjVar) {
        this.t = oj2;
        this.u = zzcjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        YL2 yl2 = OJ2.Q;
        OJ2 oj2 = this.t;
        String str = this.u.t;
        if (AbstractC0700gL2.a(str, oj2.A)) {
            z = false;
        } else {
            oj2.A = str;
            z = true;
        }
        OJ2.Q.getClass();
        Ky ky = oj2.v;
        if (ky != null && (z || oj2.C)) {
            ky.d();
        }
        oj2.C = false;
    }
}
