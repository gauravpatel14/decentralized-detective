package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.internal.zaa;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BA2 extends zaa {
    public final /* synthetic */ H62 t;

    public BA2(H62 h62) {
        this.t = h62;
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zaa, com.google.android.gms.common.moduleinstall.internal.zae
    public final void zae(Status status, ModuleAvailabilityResponse moduleAvailabilityResponse) {
        TaskUtil.trySetResultOrApiException(status, moduleAvailabilityResponse, this.t);
    }
}
