package defpackage;

import android.view.View;
import androidx.fragment.app.h;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class qY extends AbstractC0246Uh0 {
    public final /* synthetic */ AbstractC0246Uh0 t;
    public final /* synthetic */ h u;

    public qY(h hVar, AbstractC0246Uh0 abstractC0246Uh0) {
        this.u = hVar;
        this.t = abstractC0246Uh0;
    }

    @Override // defpackage.AbstractC0246Uh0
    public final View b(int i) {
        AbstractC0246Uh0 abstractC0246Uh0 = this.t;
        return abstractC0246Uh0.c() ? abstractC0246Uh0.b(i) : this.u.onFindViewById(i);
    }

    @Override // defpackage.AbstractC0246Uh0
    public final boolean c() {
        return this.t.c() || this.u.onHasView();
    }
}
