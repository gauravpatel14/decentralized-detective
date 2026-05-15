package defpackage;

import androidx.mediarouter.app.d;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class AO0 implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ Object u;

    public /* synthetic */ AO0(int i, Object obj) {
        this.t = i;
        this.u = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.t) {
            case 0:
                d dVar = (d) this.u;
                dVar.m(true);
                dVar.X.requestLayout();
                dVar.X.getViewTreeObserver().addOnGlobalLayoutListener(new yO0(dVar));
                break;
            default:
                d dVar2 = ((IO0) this.u).u;
                if (dVar2.f0 != null) {
                    dVar2.f0 = null;
                    if (dVar2.v0) {
                        dVar2.t(dVar2.w0);
                    }
                }
                break;
        }
    }
}
