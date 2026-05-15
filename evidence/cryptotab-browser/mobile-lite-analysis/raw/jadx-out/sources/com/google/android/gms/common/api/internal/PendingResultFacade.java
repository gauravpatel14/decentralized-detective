package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.TransformedResult;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public abstract class PendingResultFacade extends PendingResult {
    @Override // com.google.android.gms.common.api.PendingResult
    public final void addStatusListener(PendingResult.StatusListener statusListener) {
        throw null;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final Result await() {
        throw null;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void cancel() {
        throw null;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final boolean isCanceled() {
        throw null;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback resultCallback) {
        throw null;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @ResultIgnorabilityUnspecified
    public final TransformedResult then(ResultTransform resultTransform) {
        throw null;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final Result await(long j, TimeUnit timeUnit) {
        throw null;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback resultCallback, long j, TimeUnit timeUnit) {
        throw null;
    }
}
