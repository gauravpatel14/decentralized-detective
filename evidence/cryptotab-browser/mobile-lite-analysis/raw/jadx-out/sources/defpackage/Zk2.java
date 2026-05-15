package defpackage;

import android.app.Activity;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Zk2 implements Runnable {
    public final /* synthetic */ C0374al2 t;
    public final /* synthetic */ Gd u;
    public final /* synthetic */ Activity v;

    public /* synthetic */ Zk2(C0374al2 c0374al2, Gd gd, Activity activity) {
        this.t = c0374al2;
        this.u = gd;
        this.v = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Gd gd = this.u;
        Activity activity = this.v;
        this.t.getClass();
        int i = AbstractC1872zv.a;
        try {
            C0374al2.f.getClass();
            if (LQ2.a(gd, activity)) {
                return;
            }
            C0374al2.d = 1;
        } catch (Exception unused) {
            int i2 = AbstractC1872zv.a;
        }
    }
}
