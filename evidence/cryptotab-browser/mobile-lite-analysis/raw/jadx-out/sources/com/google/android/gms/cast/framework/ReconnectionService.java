package com.google.android.gms.cast.framework;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import defpackage.B13;
import defpackage.BS2;
import defpackage.C0025By;
import defpackage.C1764y23;
import defpackage.F03;
import defpackage.HK2;
import defpackage.L13;
import defpackage.QK2;
import defpackage.SM2;
import defpackage.YL2;
import defpackage.Z23;
import defpackage.Zr0;
import defpackage.eF1;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ReconnectionService extends Service {
    public static final YL2 u = new YL2("ReconnectionService");
    public L13 t;

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        try {
            C1764y23 c1764y23 = (C1764y23) this.t;
            Parcel parcelW0 = c1764y23.W0();
            QK2.c(parcelW0, intent);
            Parcel parcelX0 = c1764y23.X0(3, parcelW0);
            IBinder strongBinder = parcelX0.readStrongBinder();
            parcelX0.recycle();
            return strongBinder;
        } catch (RemoteException unused) {
            u.getClass();
            return null;
        }
    }

    @Override // android.app.Service
    public final void onCreate() {
        Zr0 zr0W0;
        Zr0 zr0W02;
        L13 c1764y23;
        C0025By c0025ByB = C0025By.b(this);
        eF1 ef1A = c0025ByB.a();
        ef1A.getClass();
        L13 l13 = null;
        try {
            Z23 z23 = ef1A.a;
            Parcel parcelX0 = z23.X0(7, z23.W0());
            zr0W0 = ObjectWrapper.W0(parcelX0.readStrongBinder());
            parcelX0.recycle();
        } catch (RemoteException unused) {
            eF1.b.getClass();
            zr0W0 = null;
        }
        Preconditions.checkMainThread("Must be called from the main thread.");
        HK2 hk2 = c0025ByB.d;
        hk2.getClass();
        try {
            F03 f03 = hk2.a;
            Parcel parcelX02 = f03.X0(5, f03.W0());
            zr0W02 = ObjectWrapper.W0(parcelX02.readStrongBinder());
            parcelX02.recycle();
        } catch (RemoteException unused2) {
            HK2.b.getClass();
            zr0W02 = null;
        }
        YL2 yl2 = SM2.a;
        BS2 bs2A = SM2.a(getApplicationContext());
        ObjectWrapper objectWrapper = new ObjectWrapper(this);
        try {
            Parcel parcelW0 = bs2A.W0();
            QK2.b(parcelW0, objectWrapper);
            QK2.b(parcelW0, zr0W0);
            QK2.b(parcelW0, zr0W02);
            Parcel parcelX03 = bs2A.X0(5, parcelW0);
            IBinder strongBinder = parcelX03.readStrongBinder();
            int i = B13.t;
            if (strongBinder == null) {
                c1764y23 = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.cast.framework.IReconnectionService");
                c1764y23 = iInterfaceQueryLocalInterface instanceof L13 ? (L13) iInterfaceQueryLocalInterface : new C1764y23(strongBinder, "com.google.android.gms.cast.framework.IReconnectionService");
            }
            parcelX03.recycle();
            l13 = c1764y23;
        } catch (RemoteException unused3) {
            SM2.a.getClass();
        }
        this.t = l13;
        try {
            C1764y23 c1764y232 = (C1764y23) l13;
            c1764y232.Y0(1, c1764y232.W0());
        } catch (RemoteException unused4) {
            u.getClass();
        }
        super.onCreate();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        try {
            C1764y23 c1764y23 = (C1764y23) this.t;
            c1764y23.Y0(4, c1764y23.W0());
        } catch (RemoteException unused) {
            u.getClass();
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        try {
            C1764y23 c1764y23 = (C1764y23) this.t;
            Parcel parcelW0 = c1764y23.W0();
            QK2.c(parcelW0, intent);
            parcelW0.writeInt(i);
            parcelW0.writeInt(i2);
            Parcel parcelX0 = c1764y23.X0(2, parcelW0);
            int i3 = parcelX0.readInt();
            parcelX0.recycle();
            return i3;
        } catch (RemoteException unused) {
            u.getClass();
            return 1;
        }
    }
}
