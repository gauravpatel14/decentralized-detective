package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import defpackage.AbstractBinderC0441bz2;
import defpackage.AbstractC1646vz2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public interface IStatusCallback extends IInterface {

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public abstract class Stub extends AbstractBinderC0441bz2 implements IStatusCallback {
        public Stub() {
            super("com.google.android.gms.common.api.internal.IStatusCallback");
        }

        public static IStatusCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
            return iInterfaceQueryLocalInterface instanceof IStatusCallback ? (IStatusCallback) iInterfaceQueryLocalInterface : new zaby(iBinder);
        }

        @Override // defpackage.AbstractBinderC0441bz2
        public final boolean zaa(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                return false;
            }
            Status status = (Status) AbstractC1646vz2.a(parcel, Status.CREATOR);
            AbstractC1646vz2.b(parcel);
            onResult(status);
            return true;
        }
    }

    void onResult(Status status);
}
