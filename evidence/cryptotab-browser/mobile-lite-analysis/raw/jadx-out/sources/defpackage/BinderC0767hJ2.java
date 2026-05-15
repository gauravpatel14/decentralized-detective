package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.TaskUtil;

/* JADX INFO: renamed from: hJ2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC0767hJ2 extends IStatusCallback.Stub {
    public final /* synthetic */ Boolean t;
    public final /* synthetic */ H62 u;

    public BinderC0767hJ2(Boolean bool, H62 h62) {
        this.t = bool;
        this.u = h62;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public final void onResult(Status status) {
        TaskUtil.setResultOrApiException(status, this.t, this.u);
    }
}
