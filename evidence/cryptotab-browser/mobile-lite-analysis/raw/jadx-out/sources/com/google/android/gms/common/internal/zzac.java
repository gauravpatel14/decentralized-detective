package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import defpackage.AbstractBinderC1432sF2;
import defpackage.UH2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzac extends AbstractBinderC1432sF2 implements IGmsCallbacks {
    public zzac() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // defpackage.AbstractBinderC1432sF2
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            int i3 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) UH2.a(parcel, Bundle.CREATOR);
            UH2.b(parcel);
            onPostInitComplete(i3, strongBinder, bundle);
        } else if (i == 2) {
            int i4 = parcel.readInt();
            Bundle bundle2 = (Bundle) UH2.a(parcel, Bundle.CREATOR);
            UH2.b(parcel);
            zzb(i4, bundle2);
        } else {
            if (i != 3) {
                return false;
            }
            int i5 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            zzk zzkVar = (zzk) UH2.a(parcel, zzk.CREATOR);
            UH2.b(parcel);
            zzc(i5, strongBinder2, zzkVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
