package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.ObjectWrapper;
import defpackage.AbstractC0062Ey2;
import defpackage.AbstractC1646vz2;
import defpackage.Zr0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class zam extends AbstractC0062Ey2 implements IInterface {
    public zam(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    public final Zr0 zae(Zr0 zr0, zax zaxVar) {
        Parcel parcelZaa = zaa();
        AbstractC1646vz2.d(parcelZaa, zr0);
        AbstractC1646vz2.c(parcelZaa, zaxVar);
        Parcel parcelZab = zab(2, parcelZaa);
        Zr0 zr0W0 = ObjectWrapper.W0(parcelZab.readStrongBinder());
        parcelZab.recycle();
        return zr0W0;
    }
}
