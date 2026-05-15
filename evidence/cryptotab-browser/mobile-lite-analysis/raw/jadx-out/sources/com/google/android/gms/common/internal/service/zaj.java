package com.google.android.gms.common.internal.service;

import android.os.Parcel;
import defpackage.AbstractBinderC0441bz2;
import defpackage.AbstractC1646vz2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zaj extends AbstractBinderC0441bz2 implements zak {
    public zaj() {
        super("com.google.android.gms.common.internal.service.ICommonCallbacks");
    }

    @Override // defpackage.AbstractBinderC0441bz2
    public final boolean zaa(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        int i3 = parcel.readInt();
        AbstractC1646vz2.b(parcel);
        zab(i3);
        return true;
    }
}
