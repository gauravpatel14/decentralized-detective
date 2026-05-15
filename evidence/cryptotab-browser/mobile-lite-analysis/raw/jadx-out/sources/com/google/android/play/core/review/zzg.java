package com.google.android.play.core.review;

import android.os.Bundle;
import com.google.android.play.core.review.internal.zzt;
import defpackage.H62;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
class zzg extends com.google.android.play.core.review.internal.zzg {
    final com.google.android.play.core.review.internal.zzi zza;
    final H62 zzb;
    final /* synthetic */ zzi zzc;

    public zzg(zzi zziVar, com.google.android.play.core.review.internal.zzi zziVar2, H62 h62) {
        this.zzc = zziVar;
        this.zza = zziVar2;
        this.zzb = h62;
    }

    @Override // com.google.android.play.core.review.internal.zzh
    public void zzb(Bundle bundle) {
        zzt zztVar = this.zzc.zza;
        if (zztVar != null) {
            zztVar.zzu(this.zzb);
        }
        this.zza.zzc("onGetLaunchReviewFlowInfo", new Object[0]);
    }
}
