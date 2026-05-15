package com.google.android.gms.common.util;

import android.os.Looper;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class zzb {
    public static boolean zza() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
