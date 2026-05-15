package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PendingResult {

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @KeepForSdk
    public interface StatusListener {
        @KeepForSdk
        void onComplete(Status status);
    }

    @KeepForSdk
    public void addStatusListener(StatusListener statusListener) {
        throw new UnsupportedOperationException();
    }

    @ResultIgnorabilityUnspecified
    public abstract Result await();

    @ResultIgnorabilityUnspecified
    public abstract Result await(long j, TimeUnit timeUnit);

    public abstract void cancel();

    public abstract boolean isCanceled();

    public abstract void setResultCallback(ResultCallback resultCallback);

    public abstract void setResultCallback(ResultCallback resultCallback, long j, TimeUnit timeUnit);

    public TransformedResult then(ResultTransform resultTransform) {
        throw new UnsupportedOperationException();
    }
}
