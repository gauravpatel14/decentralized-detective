package androidx.fragment.app;

import defpackage.Gk0;
import defpackage.u4;
import defpackage.v4;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements Gk0 {
    public final /* synthetic */ n a;

    public m(n nVar) {
        this.a = nVar;
    }

    @Override // defpackage.Gk0
    public final u4 apply() {
        n nVar = this.a;
        Object obj = nVar.mHost;
        return obj instanceof v4 ? ((v4) obj).m0() : nVar.requireActivity().B;
    }
}
