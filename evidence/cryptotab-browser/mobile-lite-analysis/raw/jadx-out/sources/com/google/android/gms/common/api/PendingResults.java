package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.OptionalPendingResultImpl;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;
import defpackage.C0391bA2;
import defpackage.C0511dA2;
import defpackage.C0822iA2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class PendingResults {
    private PendingResults() {
    }

    public static PendingResult canceledPendingResult() {
        StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
        statusPendingResult.cancel();
        return statusPendingResult;
    }

    @KeepForSdk
    public static PendingResult immediateFailedResult(Result result, GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(result, "Result must not be null");
        Preconditions.checkArgument(!result.getStatus().isSuccess(), "Status code must not be SUCCESS");
        C0511dA2 c0511dA2 = new C0511dA2(result, googleApiClient);
        c0511dA2.setResult(result);
        return c0511dA2;
    }

    public static OptionalPendingResult immediatePendingResult(Result result) {
        Preconditions.checkNotNull(result, "Result must not be null");
        C0822iA2 c0822iA2 = new C0822iA2(null);
        c0822iA2.setResult(result);
        return new OptionalPendingResultImpl(c0822iA2);
    }

    public static PendingResult canceledPendingResult(Result result) {
        Preconditions.checkNotNull(result, "Result must not be null");
        Preconditions.checkArgument(result.getStatus().getStatusCode() == 16, "Status code must be CommonStatusCodes.CANCELED");
        C0391bA2 c0391bA2 = new C0391bA2(result);
        c0391bA2.cancel();
        return c0391bA2;
    }

    @KeepForSdk
    public static OptionalPendingResult immediatePendingResult(Result result, GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(result, "Result must not be null");
        C0822iA2 c0822iA2 = new C0822iA2(googleApiClient);
        c0822iA2.setResult(result);
        return new OptionalPendingResultImpl(c0822iA2);
    }

    public static PendingResult immediatePendingResult(Status status) {
        Preconditions.checkNotNull(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
        statusPendingResult.setResult(status);
        return statusPendingResult;
    }

    @KeepForSdk
    public static PendingResult immediatePendingResult(Status status, GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(googleApiClient);
        statusPendingResult.setResult(status);
        return statusPendingResult;
    }
}
