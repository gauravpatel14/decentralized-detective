package defpackage;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.zabf;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: renamed from: Py2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0193Py2 extends AbstractC0933jz2 {
    public final /* synthetic */ BaseGmsClient.ConnectionProgressReportCallbacks b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0193Py2(zabf zabfVar, BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        super(zabfVar);
        this.b = connectionProgressReportCallbacks;
    }

    @Override // defpackage.AbstractC0933jz2
    public final void a() {
        this.b.onReportServiceBinding(new ConnectionResult(16, null));
    }
}
