package com.google.android.play.core.review;

import android.app.PendingIntent;
import android.os.Bundle;
import defpackage.H62;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
final class zzh extends zzg {
    public zzh(zzi zziVar, H62 h62, String str) {
        super(zziVar, new com.google.android.play.core.review.internal.zzi("OnRequestInstallCallback"), h62);
    }

    @Override // com.google.android.play.core.review.zzg, com.google.android.play.core.review.internal.zzh
    public final void zzb(Bundle bundle) {
        super.zzb(bundle);
        this.zzb.d(new zza((PendingIntent) bundle.get("confirmation_intent"), bundle.getBoolean("is_review_no_op")));
    }
}
