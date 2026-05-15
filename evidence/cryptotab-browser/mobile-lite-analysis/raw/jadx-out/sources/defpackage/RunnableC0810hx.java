package defpackage;

/* JADX INFO: renamed from: hx, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0810hx implements Runnable {
    public final /* synthetic */ C0269Wi2 t;
    public final /* synthetic */ int u;

    public RunnableC0810hx(C0269Wi2 c0269Wi2, int i) {
        this.t = c0269Wi2;
        this.u = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        jv1 jv1Var = this.t.a;
        if (jv1Var != null) {
            jv1Var.b(this.u);
        }
    }
}
