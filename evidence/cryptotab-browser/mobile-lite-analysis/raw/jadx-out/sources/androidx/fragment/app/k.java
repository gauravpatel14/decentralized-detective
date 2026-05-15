package androidx.fragment.app;

import android.view.View;
import defpackage.AbstractC0246Uh0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends AbstractC0246Uh0 {
    public final /* synthetic */ n t;

    public k(n nVar) {
        this.t = nVar;
    }

    @Override // defpackage.AbstractC0246Uh0
    public final View b(int i) {
        n nVar = this.t;
        View view = nVar.mView;
        if (view != null) {
            return view.findViewById(i);
        }
        throw new IllegalStateException("Fragment " + nVar + " does not have a view");
    }

    @Override // defpackage.AbstractC0246Uh0
    public final boolean c() {
        return this.t.mView != null;
    }
}
