package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class VH implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ Object u;

    public /* synthetic */ VH(int i, Object obj) {
        this.t = i;
        this.u = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.t) {
            case 0:
                ((iI) this.u).invalidateOptionsMenu();
                return;
            case 1:
                try {
                    super/*android.app.Activity*/.onBackPressed();
                    return;
                } catch (IllegalStateException e) {
                    if (!lz0.a(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                        throw e;
                    }
                    return;
                } catch (NullPointerException e2) {
                    if (!lz0.a(e2.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                        throw e2;
                    }
                    return;
                }
            default:
                dI dIVar = (dI) this.u;
                Runnable runnable = dIVar.u;
                if (runnable != null) {
                    runnable.run();
                    dIVar.u = null;
                    return;
                }
                return;
        }
    }
}
