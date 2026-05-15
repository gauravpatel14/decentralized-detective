package defpackage;

import android.content.Context;

/* JADX INFO: renamed from: zW0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1851zW0 implements Runnable {
    public final /* synthetic */ Context t;
    public final /* synthetic */ S62 u;
    public final /* synthetic */ C1681wW0 v;
    public final /* synthetic */ AW0 w;

    public RunnableC1851zW0(AW0 aw0, Context context, S62 s62, C1681wW0 c1681wW0) {
        this.w = aw0;
        this.t = context;
        this.u = s62;
        this.v = c1681wW0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AW0 aw0 = this.w;
        if (aw0.b) {
            return;
        }
        aw0.d(this.t, this.u, this.v);
    }
}
