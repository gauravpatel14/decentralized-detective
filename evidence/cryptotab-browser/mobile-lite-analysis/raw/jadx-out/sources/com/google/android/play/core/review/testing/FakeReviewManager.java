package com.google.android.play.core.review.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.review.ReviewException;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import defpackage.G62;
import defpackage.Y62;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class FakeReviewManager implements ReviewManager {
    private final Context zza;
    private ReviewInfo zzb;
    private int zzc = 0;

    public FakeReviewManager(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.play.core.review.ReviewManager
    public G62 launchReviewFlow(Activity activity, ReviewInfo reviewInfo) {
        if (reviewInfo != this.zzb) {
            return Y62.d(new ReviewException(-2));
        }
        this.zzc++;
        return Y62.e(null);
    }

    @Override // com.google.android.play.core.review.ReviewManager
    public G62 requestReviewFlow() {
        ReviewInfo reviewInfoZzc = ReviewInfo.zzc(PendingIntent.getBroadcast(this.zza, 0, new Intent(), 67108864), false);
        this.zzb = reviewInfoZzc;
        return Y62.e(reviewInfoZzc);
    }
}
