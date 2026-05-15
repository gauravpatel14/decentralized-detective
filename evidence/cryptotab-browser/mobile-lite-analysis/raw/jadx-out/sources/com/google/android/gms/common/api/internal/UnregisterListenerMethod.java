package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ListenerHolder;
import defpackage.H62;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public abstract class UnregisterListenerMethod {
    private final ListenerHolder.ListenerKey zaa;

    @KeepForSdk
    public UnregisterListenerMethod(ListenerHolder.ListenerKey listenerKey) {
        this.zaa = listenerKey;
    }

    @KeepForSdk
    public ListenerHolder.ListenerKey getListenerKey() {
        return this.zaa;
    }

    @KeepForSdk
    public abstract void unregisterListener(Api.AnyClient anyClient, H62 h62);
}
