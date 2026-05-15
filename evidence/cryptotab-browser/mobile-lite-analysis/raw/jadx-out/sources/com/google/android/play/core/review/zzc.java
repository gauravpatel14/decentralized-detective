package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import defpackage.H62;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
final class zzc extends ResultReceiver {
    final /* synthetic */ H62 zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzc(zzd zzdVar, Handler handler, H62 h62) {
        super(handler);
        this.zza = h62;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        this.zza.d(null);
    }
}
