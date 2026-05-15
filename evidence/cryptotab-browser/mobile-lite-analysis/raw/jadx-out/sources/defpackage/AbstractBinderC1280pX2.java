package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.play.core.splitinstall.SplitInstallException;

/* JADX INFO: renamed from: pX2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC1280pX2 extends Binder implements IInterface {
    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i, parcel, parcel2, i2)) {
            return true;
        }
        AbstractBinderC0341aG2 abstractBinderC0341aG2 = (AbstractBinderC0341aG2) this;
        H62 h62 = abstractBinderC0341aG2.t;
        C0765hG2 c0765hG2 = abstractBinderC0341aG2.u;
        switch (i) {
            case 2:
                int i3 = parcel.readInt();
                Bundle bundle = (Bundle) AbstractC1398rY2.a(parcel, Bundle.CREATOR);
                AbstractC1398rY2.b(parcel);
                abstractBinderC0341aG2.B(i3, bundle);
                break;
            case 3:
                int i4 = parcel.readInt();
                AbstractC1398rY2.b(parcel);
                c0765hG2.b.d(h62);
                C0765hG2.c.c("onCompleteInstall(%d)", Integer.valueOf(i4));
                break;
            case 4:
                int i5 = parcel.readInt();
                AbstractC1398rY2.b(parcel);
                c0765hG2.b.d(h62);
                C0765hG2.c.c("onCancelInstall(%d)", Integer.valueOf(i5));
                break;
            case 5:
                int i6 = parcel.readInt();
                AbstractC1398rY2.b(parcel);
                c0765hG2.b.d(h62);
                C0765hG2.c.c("onGetSession(%d)", Integer.valueOf(i6));
                break;
            case 6:
                Bundle bundle2 = (Bundle) AbstractC1398rY2.a(parcel, Bundle.CREATOR);
                AbstractC1398rY2.b(parcel);
                c0765hG2.b.d(h62);
                int i7 = bundle2.getInt("error_code");
                C0765hG2.c.a("onError(%d)", Integer.valueOf(i7));
                h62.c(new SplitInstallException(i7));
                break;
            case 7:
                parcel.createTypedArrayList(Bundle.CREATOR);
                AbstractC1398rY2.b(parcel);
                c0765hG2.b.d(h62);
                C0765hG2.c.c("onGetSessionStates", new Object[0]);
                break;
            case 8:
                AbstractC1398rY2.b(parcel);
                c0765hG2.b.d(h62);
                C0765hG2.c.c("onDeferredUninstall", new Object[0]);
                break;
            case ConnectionResult.SERVICE_INVALID /* 9 */:
                Bundle bundle3 = (Bundle) AbstractC1398rY2.a(parcel, Bundle.CREATOR);
                AbstractC1398rY2.b(parcel);
                abstractBinderC0341aG2.b(bundle3);
                break;
            case 10:
                AbstractC1398rY2.b(parcel);
                c0765hG2.b.d(h62);
                C0765hG2.c.c("onGetSplitsForAppUpdate", new Object[0]);
                break;
            case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                AbstractC1398rY2.b(parcel);
                c0765hG2.b.d(h62);
                C0765hG2.c.c("onCompleteInstallForAppUpdate", new Object[0]);
                break;
            case 12:
                Bundle bundle4 = (Bundle) AbstractC1398rY2.a(parcel, Bundle.CREATOR);
                AbstractC1398rY2.b(parcel);
                abstractBinderC0341aG2.e(bundle4);
                break;
            case 13:
                AbstractC1398rY2.b(parcel);
                c0765hG2.b.d(h62);
                C0765hG2.c.c("onDeferredLanguageUninstall", new Object[0]);
                break;
        }
        return true;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
