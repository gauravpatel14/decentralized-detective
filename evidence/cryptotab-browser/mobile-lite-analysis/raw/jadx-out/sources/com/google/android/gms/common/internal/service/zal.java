package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.AbstractC0062Ey2;
import defpackage.AbstractC1646vz2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class zal extends AbstractC0062Ey2 implements IInterface {
    public zal(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.ICommonService");
    }

    public final void zae(zak zakVar) {
        Parcel parcelZaa = zaa();
        AbstractC1646vz2.d(parcelZaa, zakVar);
        zad(1, parcelZaa);
    }
}
