package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import defpackage.AbstractC1655wB2;
import defpackage.UH2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class zzw extends AbstractC1655wB2 implements IAccountAccessor {
    public zzw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override // com.google.android.gms.common.internal.IAccountAccessor
    public final Account zzb() {
        Parcel parcelZzB = zzB(2, zza());
        Account account = (Account) UH2.a(parcelZzB, Account.CREATOR);
        parcelZzB.recycle();
        return account;
    }
}
