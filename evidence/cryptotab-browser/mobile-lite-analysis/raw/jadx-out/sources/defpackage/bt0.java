package defpackage;

import com.android.volley.VolleyError;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class bt0 implements Runnable {
    public final /* synthetic */ C0673ft0 t;

    public bt0(C0673ft0 c0673ft0) {
        this.t = c0673ft0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0673ft0 c0673ft0 = this.t;
        for (ct0 ct0Var : c0673ft0.d.values()) {
            for (dt0 dt0Var : ct0Var.c) {
                InterfaceC0607et0 interfaceC0607et0 = dt0Var.b;
                if (interfaceC0607et0 != null) {
                    VolleyError volleyError = ct0Var.b;
                    if (volleyError == null) {
                        dt0Var.a = ct0Var.a;
                        interfaceC0607et0.b(dt0Var, false);
                    } else {
                        interfaceC0607et0.c(volleyError);
                    }
                }
            }
        }
        c0673ft0.d.clear();
        c0673ft0.f = null;
    }
}
