package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Runnable {
    public final /* synthetic */ Result t;
    public final /* synthetic */ zada u;

    public f(zada zadaVar, Result result) {
        this.u = zadaVar;
        this.t = result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Result result = this.t;
        zada zadaVar = this.u;
        try {
            try {
                ThreadLocal threadLocal = BasePendingResult.zaa;
                threadLocal.set(Boolean.TRUE);
                zadaVar.zah.sendMessage(zadaVar.zah.obtainMessage(0, ((ResultTransform) Preconditions.checkNotNull(zadaVar.zaa)).onSuccess(result)));
                threadLocal.set(Boolean.FALSE);
                zada.zan(result);
                GoogleApiClient googleApiClient = (GoogleApiClient) zadaVar.zag.get();
                result = googleApiClient;
                if (googleApiClient != null) {
                    googleApiClient.zap(zadaVar);
                }
            } catch (RuntimeException e) {
                zadaVar.zah.sendMessage(zadaVar.zah.obtainMessage(1, e));
                BasePendingResult.zaa.set(Boolean.FALSE);
                zada.zan(result);
                GoogleApiClient googleApiClient2 = (GoogleApiClient) zadaVar.zag.get();
                result = googleApiClient2;
                if (googleApiClient2 != null) {
                    googleApiClient2.zap(zadaVar);
                    result = googleApiClient2;
                }
            }
        } catch (Throwable th) {
            BasePendingResult.zaa.set(Boolean.FALSE);
            zada.zan(result);
            GoogleApiClient googleApiClient3 = (GoogleApiClient) zadaVar.zag.get();
            if (googleApiClient3 != null) {
                googleApiClient3.zap(zadaVar);
            }
            throw th;
        }
    }
}
