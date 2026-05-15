package defpackage;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.location.zzg;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BJ2 extends AbstractBinderC0358aV2 {
    public final /* synthetic */ H62 t;
    public final /* synthetic */ BinderC0461cK2 u;

    public BJ2(H62 h62, BinderC0461cK2 binderC0461cK2) {
        this.t = h62;
        this.u = binderC0461cK2;
    }

    @Override // defpackage.InterfaceC0534dW2
    public final void B0(zzg zzgVar) {
        TaskUtil.setResultOrApiException(zzgVar.t, this.t);
    }

    @Override // defpackage.InterfaceC0534dW2
    public final void a() {
        this.u.X0();
    }
}
