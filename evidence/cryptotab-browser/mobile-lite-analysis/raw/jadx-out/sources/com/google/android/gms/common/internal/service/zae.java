package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import defpackage.C1535tz2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class zae {
    public final PendingResult zaa(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new C1535tz2(Common.API, googleApiClient));
    }
}
