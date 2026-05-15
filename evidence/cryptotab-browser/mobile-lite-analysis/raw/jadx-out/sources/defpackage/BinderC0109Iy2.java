package defpackage;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.moduleinstall.ModuleInstallStatusUpdate;
import com.google.android.gms.common.moduleinstall.internal.zag;

/* JADX INFO: renamed from: Iy2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC0109Iy2 extends zag {
    public final ListenerHolder t;

    public BinderC0109Iy2(ListenerHolder listenerHolder) {
        this.t = listenerHolder;
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zah
    public final void zab(ModuleInstallStatusUpdate moduleInstallStatusUpdate) {
        this.t.notifyListener(new C0097Hy2(moduleInstallStatusUpdate));
    }
}
