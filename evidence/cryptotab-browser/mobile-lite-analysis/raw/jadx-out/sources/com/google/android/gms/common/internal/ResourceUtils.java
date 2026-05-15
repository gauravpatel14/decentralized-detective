package com.google.android.gms.common.internal;

import android.net.Uri;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public final class ResourceUtils {
    private static final Uri zza = new Uri.Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("drawable").build();

    private ResourceUtils() {
    }
}
