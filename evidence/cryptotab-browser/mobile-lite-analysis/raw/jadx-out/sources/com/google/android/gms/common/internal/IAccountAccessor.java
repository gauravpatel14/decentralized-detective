package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.AbstractBinderC1432sF2;
import defpackage.UH2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public interface IAccountAccessor extends IInterface {

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public abstract class Stub extends AbstractBinderC1432sF2 implements IAccountAccessor {
        public Stub() {
            super("com.google.android.gms.common.internal.IAccountAccessor");
        }

        public static IAccountAccessor asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return iInterfaceQueryLocalInterface instanceof IAccountAccessor ? (IAccountAccessor) iInterfaceQueryLocalInterface : new zzw(iBinder);
        }

        @Override // defpackage.AbstractBinderC1432sF2
        public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 2) {
                return false;
            }
            Account accountZzb = zzb();
            parcel2.writeNoException();
            int i3 = UH2.a;
            if (accountZzb == null) {
                parcel2.writeInt(0);
            } else {
                parcel2.writeInt(1);
                accountZzb.writeToParcel(parcel2, 1);
            }
            return true;
        }
    }

    Account zzb();
}
