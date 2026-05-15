package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.Preconditions;
import defpackage.C1426sA2;
import defpackage.uA2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Runnable {
    public final C1426sA2 t;
    public final /* synthetic */ zap u;

    public g(zap zapVar, C1426sA2 c1426sA2) {
        this.u = zapVar;
        this.t = c1426sA2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.u.zaa) {
            ConnectionResult connectionResult = this.t.b;
            if (connectionResult.hasResolution()) {
                zap zapVar = this.u;
                zapVar.mLifecycleFragment.startActivityForResult(GoogleApiActivity.zaa(zapVar.getActivity(), (PendingIntent) Preconditions.checkNotNull(connectionResult.getResolution()), this.t.a, false), 1);
                return;
            }
            zap zapVar2 = this.u;
            if (zapVar2.zac.getErrorResolutionIntent(zapVar2.getActivity(), connectionResult.getErrorCode(), null) != null) {
                zap zapVar3 = this.u;
                zapVar3.zac.zag(zapVar3.getActivity(), zapVar3.mLifecycleFragment, connectionResult.getErrorCode(), 2, this.u);
                return;
            }
            if (connectionResult.getErrorCode() != 18) {
                this.u.zaa(connectionResult, this.t.a);
                return;
            }
            zap zapVar4 = this.u;
            Dialog dialogZab = zapVar4.zac.zab(zapVar4.getActivity(), zapVar4);
            zap zapVar5 = this.u;
            zapVar5.zac.zac(zapVar5.getActivity().getApplicationContext(), new uA2(this, dialogZab));
        }
    }
}
