package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.RemoteException;
import defpackage.H62;
import java.util.Map;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
final class zzf extends com.google.android.play.core.review.internal.zzj {
    final /* synthetic */ H62 zza;
    final /* synthetic */ zzi zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzf(zzi zziVar, H62 h62, H62 h622) {
        super(h62);
        this.zza = h622;
        this.zzb = zziVar;
    }

    @Override // com.google.android.play.core.review.internal.zzj
    public final void zza() {
        try {
            com.google.android.play.core.review.internal.zzf zzfVar = (com.google.android.play.core.review.internal.zzf) this.zzb.zza.zze();
            String str = this.zzb.zzc;
            Bundle bundle = new Bundle();
            Map mapZza = zzj.zza();
            bundle.putInt("playcore_version_code", ((Integer) mapZza.get("java")).intValue());
            if (mapZza.containsKey("native")) {
                bundle.putInt("playcore_native_version", ((Integer) mapZza.get("native")).intValue());
            }
            if (mapZza.containsKey("unity")) {
                bundle.putInt("playcore_unity_version", ((Integer) mapZza.get("unity")).intValue());
            }
            zzi zziVar = this.zzb;
            zzfVar.zzc(str, bundle, new zzh(zziVar, this.zza, zziVar.zzc));
        } catch (RemoteException e) {
            zzi.zzb.zzb(e, "error requesting in-app review for %s", this.zzb.zzc);
            this.zza.c(new RuntimeException(e));
        }
    }
}
