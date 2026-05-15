package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class KW2 implements Runnable {
    public final /* synthetic */ QX2 t;
    public final /* synthetic */ Runnable u;

    public KW2(QX2 qx2, Runnable runnable) {
        this.t = qx2;
        this.u = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        QX2 qx2 = this.t;
        qx2.a();
        qx2.b().g();
        if (qx2.p == null) {
            qx2.p = new ArrayList();
        }
        qx2.p.add(this.u);
        qx2.t();
    }
}
