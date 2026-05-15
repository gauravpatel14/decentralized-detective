package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.common.moduleinstall.internal.zaa;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class LA2 extends zaa {
    public final /* synthetic */ H62 t;

    public LA2(H62 h62) {
        this.t = h62;
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zaa, com.google.android.gms.common.moduleinstall.internal.zae
    public final void zac(Status status, ModuleInstallIntentResponse moduleInstallIntentResponse) {
        TaskUtil.trySetResultOrApiException(status, moduleInstallIntentResponse, this.t);
    }
}
