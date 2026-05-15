package com.google.android.play.core.review.internal;

import defpackage.H62;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzj implements Runnable {
    private final H62 zza;

    public zzj() {
        this.zza = null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zza();
        } catch (Exception e) {
            zzc(e);
        }
    }

    public abstract void zza();

    public final H62 zzb() {
        return this.zza;
    }

    public final void zzc(Exception exc) {
        H62 h62 = this.zza;
        if (h62 != null) {
            h62.c(exc);
        }
    }

    public zzj(H62 h62) {
        this.zza = h62;
    }
}
