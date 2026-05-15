package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.zacp;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ResultTransform {
    public final PendingResult createFailedResult(Status status) {
        return new zacp(status);
    }

    public abstract PendingResult onSuccess(Result result);

    public Status onFailure(Status status) {
        return status;
    }
}
