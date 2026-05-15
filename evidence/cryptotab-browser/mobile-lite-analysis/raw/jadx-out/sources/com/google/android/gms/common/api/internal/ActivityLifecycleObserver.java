package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.annotation.KeepForSdk;
import defpackage.C0026By2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public abstract class ActivityLifecycleObserver {
    @KeepForSdk
    public static final ActivityLifecycleObserver of(Activity activity) {
        C0026By2 c0026By2;
        synchronized (activity) {
            try {
                LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
                c0026By2 = (C0026By2) fragment.getCallbackOrNull("LifecycleObserverOnStop", C0026By2.class);
                if (c0026By2 == null) {
                    c0026By2 = new C0026By2(fragment);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return new zab(c0026By2);
    }

    @KeepForSdk
    public abstract ActivityLifecycleObserver onStopCallOnce(Runnable runnable);
}
