package com.google.android.play.core.review;

import android.app.Activity;
import defpackage.G62;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public interface ReviewManager {
    G62 launchReviewFlow(Activity activity, ReviewInfo reviewInfo);

    G62 requestReviewFlow();
}
