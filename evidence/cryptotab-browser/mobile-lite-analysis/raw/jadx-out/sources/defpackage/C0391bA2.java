package defpackage;

import android.os.Looper;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* JADX INFO: renamed from: bA2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0391bA2 extends BasePendingResult {
    public final Result a;

    public C0391bA2(Result result) {
        super(Looper.getMainLooper());
        this.a = result;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final Result createFailedResult(Status status) {
        int statusCode = status.getStatusCode();
        Result result = this.a;
        if (statusCode == result.getStatus().getStatusCode()) {
            return result;
        }
        throw new UnsupportedOperationException("Creating failed results is not supported");
    }
}
