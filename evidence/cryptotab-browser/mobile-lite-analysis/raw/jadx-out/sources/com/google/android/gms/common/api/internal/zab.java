package com.google.android.gms.common.api.internal;

import defpackage.C0026By2;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class zab extends ActivityLifecycleObserver {
    private final WeakReference zaa;

    public zab(C0026By2 c0026By2) {
        this.zaa = new WeakReference(c0026By2);
    }

    @Override // com.google.android.gms.common.api.internal.ActivityLifecycleObserver
    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        C0026By2 c0026By2 = (C0026By2) this.zaa.get();
        if (c0026By2 == null) {
            throw new IllegalStateException("The target activity has already been GC'd");
        }
        synchronized (c0026By2) {
            c0026By2.t.add(runnable);
        }
        return this;
    }
}
