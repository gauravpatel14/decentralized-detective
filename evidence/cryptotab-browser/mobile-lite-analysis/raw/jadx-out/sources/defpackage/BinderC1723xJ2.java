package defpackage;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.location.zzg;

/* JADX INFO: renamed from: xJ2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC1723xJ2 extends AbstractBinderC0358aV2 {
    public final /* synthetic */ H62 t;
    public final /* synthetic */ BinderC1496tK2 u;

    public BinderC1723xJ2(H62 h62, BinderC1496tK2 binderC1496tK2) {
        this.t = h62;
        this.u = binderC1496tK2;
    }

    @Override // defpackage.InterfaceC0534dW2
    public final void B0(zzg zzgVar) {
        TaskUtil.setResultOrApiException(zzgVar.t, this.t);
    }

    @Override // defpackage.InterfaceC0534dW2
    public final void a() {
        this.u.a();
    }
}
