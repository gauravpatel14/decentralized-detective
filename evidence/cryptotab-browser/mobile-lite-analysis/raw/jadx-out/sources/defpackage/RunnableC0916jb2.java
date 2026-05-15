package defpackage;

/* JADX INFO: renamed from: jb2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0916jb2 implements Runnable {
    public final /* synthetic */ mb2 t;

    public RunnableC0916jb2(mb2 mb2Var) {
        this.t = mb2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        mb2 mb2Var = this.t;
        WindowCallbackC0365ab windowCallbackC0365ab = mb2Var.b;
        MenuC0775hQ0 menuC0775hQ0U = mb2Var.u();
        MenuC0775hQ0 menuC0775hQ0 = menuC0775hQ0U != null ? menuC0775hQ0U : null;
        if (menuC0775hQ0 != null) {
            menuC0775hQ0.w();
        }
        try {
            menuC0775hQ0U.clear();
            if (!windowCallbackC0365ab.onCreatePanelMenu(0, menuC0775hQ0U) || !windowCallbackC0365ab.onPreparePanel(0, null, menuC0775hQ0U)) {
                menuC0775hQ0U.clear();
            }
            if (menuC0775hQ0 != null) {
                menuC0775hQ0.v();
            }
        } catch (Throwable th) {
            if (menuC0775hQ0 != null) {
                menuC0775hQ0.v();
            }
            throw th;
        }
    }
}
