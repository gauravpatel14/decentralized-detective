package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import defpackage.AbstractBinderC0441bz2;
import defpackage.AbstractC1646vz2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zad extends AbstractBinderC0441bz2 implements zae {
    public zad() {
        super("com.google.android.gms.common.moduleinstall.internal.IModuleInstallCallbacks");
    }

    @Override // defpackage.AbstractBinderC0441bz2
    public final boolean zaa(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            Status status = (Status) AbstractC1646vz2.a(parcel, Status.CREATOR);
            ModuleAvailabilityResponse moduleAvailabilityResponse = (ModuleAvailabilityResponse) AbstractC1646vz2.a(parcel, ModuleAvailabilityResponse.CREATOR);
            AbstractC1646vz2.b(parcel);
            zae(status, moduleAvailabilityResponse);
        } else if (i == 2) {
            Status status2 = (Status) AbstractC1646vz2.a(parcel, Status.CREATOR);
            ModuleInstallResponse moduleInstallResponse = (ModuleInstallResponse) AbstractC1646vz2.a(parcel, ModuleInstallResponse.CREATOR);
            AbstractC1646vz2.b(parcel);
            zad(status2, moduleInstallResponse);
        } else if (i == 3) {
            Status status3 = (Status) AbstractC1646vz2.a(parcel, Status.CREATOR);
            ModuleInstallIntentResponse moduleInstallIntentResponse = (ModuleInstallIntentResponse) AbstractC1646vz2.a(parcel, ModuleInstallIntentResponse.CREATOR);
            AbstractC1646vz2.b(parcel);
            zac(status3, moduleInstallIntentResponse);
        } else {
            if (i != 4) {
                return false;
            }
            Status status4 = (Status) AbstractC1646vz2.a(parcel, Status.CREATOR);
            AbstractC1646vz2.b(parcel);
            zab(status4);
        }
        return true;
    }
}
