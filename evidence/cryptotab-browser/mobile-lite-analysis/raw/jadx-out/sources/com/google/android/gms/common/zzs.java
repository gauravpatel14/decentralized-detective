package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.dynamic.ObjectWrapper;
import defpackage.AbstractBinderC1095mV2;
import defpackage.BinderC1396rW2;
import defpackage.Zr0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "GoogleCertificatesQueryCreator")
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzt();

    @SafeParcelable.Field(getter = "getCallingPackage", id = 1)
    private final String zza;

    @SafeParcelable.Field(getter = "getCallingCertificateBinder", id = 2, type = "android.os.IBinder")
    private final AbstractBinderC1095mV2 zzb;

    @SafeParcelable.Field(getter = "getAllowTestKeys", id = 3)
    private final boolean zzc;

    @SafeParcelable.Field(defaultValue = "false", getter = "getIgnoreTestKeysOverride", id = 4)
    private final boolean zzd;

    public zzs(String str, AbstractBinderC1095mV2 abstractBinderC1095mV2, boolean z, boolean z2) {
        this.zza = str;
        this.zzb = abstractBinderC1095mV2;
        this.zzc = z;
        this.zzd = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, str, false);
        AbstractBinderC1095mV2 abstractBinderC1095mV2 = this.zzb;
        if (abstractBinderC1095mV2 == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            abstractBinderC1095mV2 = null;
        }
        SafeParcelWriter.writeIBinder(parcel, 2, abstractBinderC1095mV2, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzs(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) boolean z2) {
        this.zza = str;
        BinderC1396rW2 binderC1396rW2 = null;
        if (iBinder != null) {
            try {
                Zr0 zr0Zzd = zzz.zzg(iBinder).zzd();
                byte[] bArr = zr0Zzd == null ? null : (byte[]) ObjectWrapper.X0(zr0Zzd);
                if (bArr != null) {
                    binderC1396rW2 = new BinderC1396rW2(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            }
        }
        this.zzb = binderC1396rW2;
        this.zzc = z;
        this.zzd = z2;
    }
}
