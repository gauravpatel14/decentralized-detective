package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.BaseGmsClient;
import defpackage.RunnableC1244oz2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements BaseGmsClient.SignOutCallbacks {
    public final /* synthetic */ zabq a;

    public e(zabq zabqVar) {
        this.a = zabqVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks
    public final void onSignOutComplete() {
        this.a.zaa.zar.post(new RunnableC1244oz2(this));
    }
}
