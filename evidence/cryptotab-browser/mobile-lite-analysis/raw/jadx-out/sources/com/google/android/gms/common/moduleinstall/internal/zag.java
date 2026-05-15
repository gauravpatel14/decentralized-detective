package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import com.google.android.gms.common.moduleinstall.ModuleInstallStatusUpdate;
import defpackage.AbstractBinderC0441bz2;
import defpackage.AbstractC1646vz2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zag extends AbstractBinderC0441bz2 implements zah {
    public zag() {
        super("com.google.android.gms.common.moduleinstall.internal.IModuleInstallStatusListener");
    }

    @Override // defpackage.AbstractBinderC0441bz2
    public final boolean zaa(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        ModuleInstallStatusUpdate moduleInstallStatusUpdate = (ModuleInstallStatusUpdate) AbstractC1646vz2.a(parcel, ModuleInstallStatusUpdate.CREATOR);
        AbstractC1646vz2.b(parcel);
        zab(moduleInstallStatusUpdate);
        return true;
    }
}
