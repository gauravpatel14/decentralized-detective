package com.google.android.gms.common.moduleinstall.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.internal.IStatusCallback;
import defpackage.AbstractC0062Ey2;
import defpackage.AbstractC1646vz2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class zaf extends AbstractC0062Ey2 implements IInterface {
    public zaf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.moduleinstall.internal.IModuleInstallService");
    }

    public final void zae(zae zaeVar, ApiFeatureRequest apiFeatureRequest) {
        Parcel parcelZaa = zaa();
        AbstractC1646vz2.d(parcelZaa, zaeVar);
        AbstractC1646vz2.c(parcelZaa, apiFeatureRequest);
        zac(1, parcelZaa);
    }

    public final void zaf(zae zaeVar, ApiFeatureRequest apiFeatureRequest) {
        Parcel parcelZaa = zaa();
        AbstractC1646vz2.d(parcelZaa, zaeVar);
        AbstractC1646vz2.c(parcelZaa, apiFeatureRequest);
        zac(3, parcelZaa);
    }

    public final void zag(zae zaeVar, ApiFeatureRequest apiFeatureRequest, zah zahVar) {
        Parcel parcelZaa = zaa();
        AbstractC1646vz2.d(parcelZaa, zaeVar);
        AbstractC1646vz2.c(parcelZaa, apiFeatureRequest);
        AbstractC1646vz2.d(parcelZaa, zahVar);
        zac(2, parcelZaa);
    }

    public final void zah(IStatusCallback iStatusCallback, ApiFeatureRequest apiFeatureRequest) {
        Parcel parcelZaa = zaa();
        AbstractC1646vz2.d(parcelZaa, iStatusCallback);
        AbstractC1646vz2.c(parcelZaa, apiFeatureRequest);
        zac(4, parcelZaa);
    }

    public final void zai(IStatusCallback iStatusCallback, zah zahVar) {
        Parcel parcelZaa = zaa();
        AbstractC1646vz2.d(parcelZaa, iStatusCallback);
        AbstractC1646vz2.d(parcelZaa, zahVar);
        zac(6, parcelZaa);
    }
}
