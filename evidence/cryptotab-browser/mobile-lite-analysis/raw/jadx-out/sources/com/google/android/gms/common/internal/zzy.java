package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.ObjectWrapper;
import defpackage.AbstractC1655wB2;
import defpackage.Zr0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class zzy extends AbstractC1655wB2 implements zzaa {
    public zzy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.common.internal.zzaa
    public final int zzc() {
        Parcel parcelZzB = zzB(2, zza());
        int i = parcelZzB.readInt();
        parcelZzB.recycle();
        return i;
    }

    @Override // com.google.android.gms.common.internal.zzaa
    public final Zr0 zzd() {
        Parcel parcelZzB = zzB(1, zza());
        Zr0 zr0W0 = ObjectWrapper.W0(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return zr0W0;
    }
}
