package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.AbstractBinderC1432sF2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public interface ICancelToken extends IInterface {

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public abstract class Stub extends AbstractBinderC1432sF2 implements ICancelToken {
        public Stub() {
            super("com.google.android.gms.common.internal.ICancelToken");
        }

        public static ICancelToken asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken");
            return iInterfaceQueryLocalInterface instanceof ICancelToken ? (ICancelToken) iInterfaceQueryLocalInterface : new zzx(iBinder);
        }

        @Override // defpackage.AbstractBinderC1432sF2
        public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 2) {
                return false;
            }
            cancel();
            return true;
        }
    }

    void cancel();
}
