package defpackage;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class VO0 extends Handler {
    public final /* synthetic */ ZO0 a;

    public VO0(ZO0 zo0) {
        this.a = zo0;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        ZO0 zo0 = this.a;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            zo0.y = false;
            zo0.d(zo0.x);
            return;
        }
        zo0.A = false;
        Vl0 vl0 = zo0.w;
        if (vl0 != null) {
            C0351aP0 c0351aP0 = zo0.z;
            bm0 bm0Var = vl0.a;
            hP0 hp0D = bm0Var.d(zo0);
            if (hp0D != null) {
                bm0Var.k(hp0D, c0351aP0);
            }
        }
    }
}
