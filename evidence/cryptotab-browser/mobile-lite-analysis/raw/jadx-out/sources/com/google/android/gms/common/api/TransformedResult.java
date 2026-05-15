package com.google.android.gms.common.api;

import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TransformedResult {
    public abstract void andFinally(ResultCallbacks resultCallbacks);

    @ResultIgnorabilityUnspecified
    public abstract TransformedResult then(ResultTransform resultTransform);
}
