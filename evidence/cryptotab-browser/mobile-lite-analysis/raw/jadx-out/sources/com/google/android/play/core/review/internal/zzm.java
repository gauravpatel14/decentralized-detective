package com.google.android.play.core.review.internal;

import defpackage.H62;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
final class zzm extends zzj {
    final /* synthetic */ H62 zza;
    final /* synthetic */ zzj zzb;
    final /* synthetic */ zzt zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzm(zzt zztVar, H62 h62, H62 h622, zzj zzjVar) {
        super(h62);
        this.zza = h622;
        this.zzb = zzjVar;
        this.zzc = zztVar;
    }

    @Override // com.google.android.play.core.review.internal.zzj
    public final void zza() {
        synchronized (this.zzc.zzg) {
            try {
                zzt.zzn(this.zzc, this.zza);
                if (this.zzc.zzl.getAndIncrement() > 0) {
                    this.zzc.zzc.zzc("Already connected to the service.", new Object[0]);
                }
                zzt.zzp(this.zzc, this.zzb);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
