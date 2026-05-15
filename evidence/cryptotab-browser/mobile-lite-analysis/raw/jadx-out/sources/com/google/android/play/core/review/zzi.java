package com.google.android.play.core.review;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.review.internal.zzt;
import com.google.android.play.core.review.internal.zzw;
import defpackage.G62;
import defpackage.H62;
import defpackage.Y62;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
public final class zzi {
    private static final com.google.android.play.core.review.internal.zzi zzb = new com.google.android.play.core.review.internal.zzi("ReviewService");
    zzt zza;
    private final String zzc;

    /* JADX WARN: Type inference failed for: r7v0, types: [com.google.android.play.core.review.zze] */
    public zzi(Context context) {
        this.zzc = context.getPackageName();
        if (zzw.zza(context)) {
            this.zza = new zzt(context, zzb, "com.google.android.finsky.inappreviewservice.InAppReviewService", new Intent("com.google.android.finsky.BIND_IN_APP_REVIEW_SERVICE").setPackage("com.android.vending"), new Object() { // from class: com.google.android.play.core.review.zze
            }, null);
        }
    }

    public final G62 zza() {
        String str = this.zzc;
        com.google.android.play.core.review.internal.zzi zziVar = zzb;
        zziVar.zzc("requestInAppReview (%s)", str);
        if (this.zza == null) {
            zziVar.zza("Play Store app is either not installed or not the official version", new Object[0]);
            return Y62.d(new ReviewException(-1));
        }
        H62 h62 = new H62();
        this.zza.zzs(new zzf(this, h62, h62), h62);
        return h62.a;
    }
}
