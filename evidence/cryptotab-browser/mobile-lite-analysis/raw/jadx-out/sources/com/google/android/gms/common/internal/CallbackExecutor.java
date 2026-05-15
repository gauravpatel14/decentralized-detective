package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import defpackage.AbstractC1154nV2;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public final class CallbackExecutor {
    private CallbackExecutor() {
    }

    @KeepForSdk
    public static ExecutorService executorService() {
        return AbstractC1154nV2.a;
    }
}
