package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.zzs;
import defpackage.AbstractC1655wB2;
import defpackage.UH2;
import defpackage.Zr0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class zzae extends AbstractC1655wB2 implements zzag {
    public zzae(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzag
    public final com.google.android.gms.common.zzq zze(com.google.android.gms.common.zzo zzoVar) {
        Parcel parcelZza = zza();
        UH2.c(parcelZza, zzoVar);
        Parcel parcelZzB = zzB(6, parcelZza);
        com.google.android.gms.common.zzq zzqVar = (com.google.android.gms.common.zzq) UH2.a(parcelZzB, com.google.android.gms.common.zzq.CREATOR);
        parcelZzB.recycle();
        return zzqVar;
    }

    @Override // com.google.android.gms.common.internal.zzag
    public final com.google.android.gms.common.zzq zzf(com.google.android.gms.common.zzo zzoVar) {
        Parcel parcelZza = zza();
        UH2.c(parcelZza, zzoVar);
        Parcel parcelZzB = zzB(8, parcelZza);
        com.google.android.gms.common.zzq zzqVar = (com.google.android.gms.common.zzq) UH2.a(parcelZzB, com.google.android.gms.common.zzq.CREATOR);
        parcelZzB.recycle();
        return zzqVar;
    }

    @Override // com.google.android.gms.common.internal.zzag
    public final boolean zzg() {
        Parcel parcelZzB = zzB(9, zza());
        int i = UH2.a;
        boolean z = parcelZzB.readInt() != 0;
        parcelZzB.recycle();
        return z;
    }

    @Override // com.google.android.gms.common.internal.zzag
    public final boolean zzh(zzs zzsVar, Zr0 zr0) {
        Parcel parcelZza = zza();
        UH2.c(parcelZza, zzsVar);
        UH2.d(parcelZza, zr0);
        Parcel parcelZzB = zzB(5, parcelZza);
        boolean z = parcelZzB.readInt() != 0;
        parcelZzB.recycle();
        return z;
    }

    @Override // com.google.android.gms.common.internal.zzag
    public final boolean zzi() {
        Parcel parcelZzB = zzB(7, zza());
        int i = UH2.a;
        boolean z = parcelZzB.readInt() != 0;
        parcelZzB.recycle();
        return z;
    }
}
