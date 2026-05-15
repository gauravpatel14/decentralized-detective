package defpackage;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: renamed from: aF1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0338aF1 {
    public static final YL2 b = new YL2("Session");
    public final InterfaceC0878j23 a;

    public AbstractC0338aF1(Context context, String str, String str2) {
        InterfaceC0878j23 m23;
        ZE1 ze1 = new ZE1(this);
        BS2 bs2A = SM2.a(context);
        InterfaceC0878j23 interfaceC0878j23 = null;
        try {
            Parcel parcelW0 = bs2A.W0();
            parcelW0.writeString(str);
            parcelW0.writeString(str2);
            QK2.b(parcelW0, ze1);
            Parcel parcelX0 = bs2A.X0(2, parcelW0);
            IBinder strongBinder = parcelX0.readStrongBinder();
            int i = V13.t;
            if (strongBinder == null) {
                m23 = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.cast.framework.ISession");
                m23 = iInterfaceQueryLocalInterface instanceof InterfaceC0878j23 ? (InterfaceC0878j23) iInterfaceQueryLocalInterface : new M23(strongBinder, "com.google.android.gms.cast.framework.ISession");
            }
            parcelX0.recycle();
            interfaceC0878j23 = m23;
        } catch (RemoteException unused) {
            SM2.a.getClass();
        }
        this.a = interfaceC0878j23;
    }

    public final boolean a() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            M23 m23 = (M23) this.a;
            Parcel parcelX0 = m23.X0(5, m23.W0());
            int i = QK2.a;
            boolean z = parcelX0.readInt() != 0;
            parcelX0.recycle();
            return z;
        } catch (RemoteException unused) {
            b.getClass();
            return false;
        }
    }

    public final void b(int i) {
        try {
            M23 m23 = (M23) this.a;
            Parcel parcelW0 = m23.W0();
            parcelW0.writeInt(i);
            m23.Y0(13, parcelW0);
        } catch (RemoteException unused) {
            b.getClass();
        }
    }

    public final Zr0 c() {
        try {
            M23 m23 = (M23) this.a;
            Parcel parcelX0 = m23.X0(1, m23.W0());
            Zr0 zr0W0 = ObjectWrapper.W0(parcelX0.readStrongBinder());
            parcelX0.recycle();
            return zr0W0;
        } catch (RemoteException unused) {
            b.getClass();
            return null;
        }
    }
}
