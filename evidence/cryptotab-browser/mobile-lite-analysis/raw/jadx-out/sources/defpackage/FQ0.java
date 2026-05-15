package defpackage;

import android.view.ActionProvider;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class FQ0 implements ActionProvider.VisibilityListener {
    public CQ0 a;
    public final ActionProvider b;
    public final /* synthetic */ JQ0 c;

    public FQ0(JQ0 jq0, ActionProvider actionProvider) {
        this.c = jq0;
        this.b = actionProvider;
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z) {
        CQ0 cq0 = this.a;
        if (cq0 != null) {
            MenuC0775hQ0 menuC0775hQ0 = cq0.a.n;
            menuC0775hQ0.h = true;
            menuC0775hQ0.p(true);
        }
    }
}
