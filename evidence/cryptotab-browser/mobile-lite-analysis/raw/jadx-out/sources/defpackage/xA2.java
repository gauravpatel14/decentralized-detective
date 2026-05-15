package defpackage;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.zas;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class xA2 implements PendingResult.StatusListener {
    public final /* synthetic */ PendingResult a;
    public final /* synthetic */ H62 b;
    public final /* synthetic */ PendingResultUtil.ResultConverter c;
    public final /* synthetic */ zas d;

    public xA2(PendingResult pendingResult, H62 h62, PendingResultUtil.ResultConverter resultConverter, zas zasVar) {
        this.a = pendingResult;
        this.b = h62;
        this.c = resultConverter;
        this.d = zasVar;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        boolean zIsSuccess = status.isSuccess();
        H62 h62 = this.b;
        if (!zIsSuccess) {
            h62.a(ApiExceptionUtil.fromStatus(status));
            return;
        }
        h62.b(this.c.convert(this.a.await(0L, TimeUnit.MILLISECONDS)));
    }
}
