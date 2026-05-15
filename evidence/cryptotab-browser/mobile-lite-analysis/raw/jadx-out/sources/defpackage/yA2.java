package defpackage;

import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class yA2 implements PendingResultUtil.ResultConverter {
    public final /* synthetic */ Response a;

    public yA2(Response response) {
        this.a = response;
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* bridge */ /* synthetic */ Object convert(Result result) {
        Response response = this.a;
        response.setResult(result);
        return response;
    }
}
