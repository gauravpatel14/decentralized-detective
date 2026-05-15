package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.b;
import androidx.fragment.app.f;
import androidx.fragment.app.n;
import androidx.fragment.app.y;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class iW implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ Object u;
    public final /* synthetic */ Object v;
    public final /* synthetic */ AbstractC1555uM1 w;

    public /* synthetic */ iW(Object obj, Object obj2, AbstractC1555uM1 abstractC1555uM1, int i) {
        this.t = i;
        this.u = obj;
        this.v = obj2;
        this.w = abstractC1555uM1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbstractC1555uM1 abstractC1555uM1 = this.w;
        Object obj = this.v;
        Object obj2 = this.u;
        switch (this.t) {
            case 0:
                ((ViewGroup) obj2).endViewTransition((View) obj);
                b bVar = (b) abstractC1555uM1;
                bVar.c.a.c(bVar);
                break;
            default:
                n nVar = ((y) obj2).c;
                n nVar2 = ((y) obj).c;
                f fVar = (f) abstractC1555uM1;
                gf gfVar = fVar.n;
                C0185Pi0 c0185Pi0 = AbstractC0118Ki0.a;
                if (!fVar.o) {
                    nVar.getEnterTransitionCallback();
                } else {
                    nVar2.getEnterTransitionCallback();
                }
                break;
        }
    }
}
