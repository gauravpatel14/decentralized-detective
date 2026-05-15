package androidx.fragment.app;

import android.os.Bundle;
import defpackage.AbstractC0128Lh0;
import defpackage.AbstractC1120mz1;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends AbstractC0128Lh0 {
    public final /* synthetic */ n a;

    public j(n nVar) {
        this.a = nVar;
    }

    @Override // defpackage.AbstractC0128Lh0
    public final void a() {
        n nVar = this.a;
        nVar.mSavedStateRegistryController.a();
        AbstractC1120mz1.b(nVar);
        Bundle bundle = nVar.mSavedFragmentState;
        nVar.mSavedStateRegistryController.b(bundle != null ? bundle.getBundle("registryState") : null);
    }
}
