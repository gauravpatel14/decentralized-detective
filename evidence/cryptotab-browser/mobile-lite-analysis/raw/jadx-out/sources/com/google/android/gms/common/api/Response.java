package com.google.android.gms.common.api;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class Response {
    private Result zza;

    public Response() {
    }

    public Result getResult() {
        return this.zza;
    }

    public void setResult(Result result) {
        this.zza = result;
    }

    public Response(Result result) {
        this.zza = result;
    }
}
