package com.google.android.gms.common.api;

import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.internal.Preconditions;
import defpackage.BN0;
import defpackage.df;
import defpackage.gf;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class AvailabilityException extends Exception {
    private final gf zaa;

    public AvailabilityException(gf gfVar) {
        this.zaa = gfVar;
    }

    public ConnectionResult getConnectionResult(GoogleApi googleApi) {
        gf gfVar = this.zaa;
        ApiKey apiKey = googleApi.getApiKey();
        Object obj = gfVar.get(apiKey);
        Preconditions.checkArgument(obj != null, BN0.a("The given API (", apiKey.zaa(), ") was not part of the availability request."));
        return (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) this.zaa.get(apiKey));
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (ApiKey apiKey : (df) this.zaa.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) this.zaa.get(apiKey));
            z &= !connectionResult.isSuccess();
            arrayList.add(apiKey.zaa() + ": " + String.valueOf(connectionResult));
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("None of the queried APIs are available. ");
        } else {
            sb.append("Some of the queried APIs are unavailable. ");
        }
        sb.append(TextUtils.join("; ", arrayList));
        return sb.toString();
    }

    public ConnectionResult getConnectionResult(HasApiKey hasApiKey) {
        gf gfVar = this.zaa;
        ApiKey apiKey = hasApiKey.getApiKey();
        Object obj = gfVar.get(apiKey);
        Preconditions.checkArgument(obj != null, BN0.a("The given API (", apiKey.zaa(), ") was not part of the availability request."));
        return (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) this.zaa.get(apiKey));
    }
}
