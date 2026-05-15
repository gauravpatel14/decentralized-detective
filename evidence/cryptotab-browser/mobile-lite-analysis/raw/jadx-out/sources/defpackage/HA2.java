package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.moduleinstall.InstallStatusListener;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.common.moduleinstall.internal.zaa;
import com.google.android.gms.common.moduleinstall.internal.zay;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class HA2 extends zaa {
    public final /* synthetic */ AtomicReference t;
    public final /* synthetic */ H62 u;
    public final /* synthetic */ InstallStatusListener v;
    public final /* synthetic */ zay w;

    public HA2(zay zayVar, AtomicReference atomicReference, H62 h62, InstallStatusListener installStatusListener) {
        this.w = zayVar;
        this.t = atomicReference;
        this.u = h62;
        this.v = installStatusListener;
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zaa, com.google.android.gms.common.moduleinstall.internal.zae
    public final void zad(Status status, ModuleInstallResponse moduleInstallResponse) {
        if (moduleInstallResponse != null) {
            this.t.set(moduleInstallResponse);
        }
        TaskUtil.trySetResultOrApiException(status, null, this.u);
        if (!status.isSuccess() || (moduleInstallResponse != null && moduleInstallResponse.zaa())) {
            this.w.doUnregisterEventListener(ListenerHolders.createListenerKey(this.v, "InstallStatusListener"), 27306);
        }
    }
}
