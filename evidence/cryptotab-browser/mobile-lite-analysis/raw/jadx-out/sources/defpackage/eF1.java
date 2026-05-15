package defpackage;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class eF1 {
    public static final YL2 b = new YL2("SessionManager");
    public final Z23 a;

    public eF1(Z23 z23) {
        this.a = z23;
    }

    public final void a(fF1 ff1) {
        Preconditions.checkNotNull(ff1);
        Preconditions.checkNotNull(Ly.class);
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            Z23 z23 = this.a;
            MC2 mc2 = new MC2(ff1);
            Parcel parcelW0 = z23.W0();
            QK2.b(parcelW0, mc2);
            z23.Y0(2, parcelW0);
        } catch (RemoteException unused) {
            b.getClass();
        }
    }

    public final void b(boolean z) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            Z23 z23 = this.a;
            Parcel parcelW0 = z23.W0();
            int i = QK2.a;
            parcelW0.writeInt(1);
            parcelW0.writeInt(z ? 1 : 0);
            z23.Y0(6, parcelW0);
        } catch (RemoteException unused) {
            b.getClass();
        }
    }

    public final AbstractC0338aF1 c() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            Z23 z23 = this.a;
            Parcel parcelX0 = z23.X0(1, z23.W0());
            Zr0 zr0W0 = ObjectWrapper.W0(parcelX0.readStrongBinder());
            parcelX0.recycle();
            return (AbstractC0338aF1) ObjectWrapper.X0(zr0W0);
        } catch (RemoteException unused) {
            b.getClass();
            return null;
        }
    }
}
