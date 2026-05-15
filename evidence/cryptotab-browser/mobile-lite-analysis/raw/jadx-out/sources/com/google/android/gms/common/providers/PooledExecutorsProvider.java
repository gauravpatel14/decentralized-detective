package com.google.android.gms.common.providers;

import com.google.android.gms.common.annotation.KeepForSdk;
import defpackage.VB2;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
@Deprecated
public class PooledExecutorsProvider {
    private static PooledExecutorFactory zza;

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public interface PooledExecutorFactory {
        @KeepForSdk
        @Deprecated
        ScheduledExecutorService newSingleThreadScheduledExecutor();
    }

    private PooledExecutorsProvider() {
    }

    @KeepForSdk
    @Deprecated
    public static synchronized PooledExecutorFactory getInstance() {
        try {
            if (zza == null) {
                zza = new VB2();
            }
        } catch (Throwable th) {
            throw th;
        }
        return zza;
    }
}
