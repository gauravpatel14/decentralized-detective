package defpackage;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.browser.customtabs.CustomTabsSessionToken;
import com.google.android.gms.common.ConnectionResult;
import java.util.NoSuchElementException;
import org.chromium.chrome.browser.customtabs.CustomTabsConnectionService;

/* JADX INFO: renamed from: rT, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC1392rT extends Binder implements hr0 {
    public final /* synthetic */ CustomTabsConnectionService t;

    public BinderC1392rT(CustomTabsConnectionService customTabsConnectionService) {
        this.t = customTabsConnectionService;
        attachInterface(this, hr0.b);
    }

    public static PendingIntent W0(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("android.support.customtabs.extra.SESSION_ID");
        bundle.remove("android.support.customtabs.extra.SESSION_ID");
        return pendingIntent;
    }

    public final boolean X0(InterfaceC0671fr0 interfaceC0671fr0, PendingIntent pendingIntent) {
        final CustomTabsSessionToken customTabsSessionToken = new CustomTabsSessionToken(interfaceC0671fr0, pendingIntent);
        try {
            IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() { // from class: qT
                @Override // android.os.IBinder.DeathRecipient
                public final void binderDied() {
                    BinderC1392rT binderC1392rT = this.a;
                    CustomTabsSessionToken customTabsSessionToken2 = customTabsSessionToken;
                    CustomTabsConnectionService customTabsConnectionService = binderC1392rT.t;
                    customTabsConnectionService.w.a(customTabsSessionToken2);
                    try {
                        synchronized (customTabsConnectionService.t) {
                            try {
                                InterfaceC0671fr0 interfaceC0671fr02 = customTabsSessionToken2.a;
                                IBinder iBinderAsBinder = interfaceC0671fr02 == null ? null : interfaceC0671fr02.asBinder();
                                if (iBinderAsBinder == null) {
                                    return;
                                }
                                iBinderAsBinder.unlinkToDeath((IBinder.DeathRecipient) customTabsConnectionService.t.get(iBinderAsBinder), 0);
                                customTabsConnectionService.t.remove(iBinderAsBinder);
                            } finally {
                            }
                        }
                    } catch (NoSuchElementException unused) {
                    }
                }
            };
            synchronized (this.t.t) {
                interfaceC0671fr0.asBinder().linkToDeath(deathRecipient, 0);
                this.t.t.put(interfaceC0671fr0.asBinder(), deathRecipient);
            }
            return this.t.w.e(customTabsSessionToken);
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        String str = hr0.b;
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        CustomTabsConnectionService customTabsConnectionService = this.t;
        switch (i) {
            case 2:
                boolean zP = customTabsConnectionService.w.p(parcel.readLong());
                parcel2.writeNoException();
                parcel2.writeInt(zP ? 1 : 0);
                return true;
            case 3:
                boolean zX0 = X0(dr0.W0(parcel.readStrongBinder()), null);
                parcel2.writeNoException();
                parcel2.writeInt(zX0 ? 1 : 0);
                return true;
            case 4:
                InterfaceC0671fr0 interfaceC0671fr0W0 = dr0.W0(parcel.readStrongBinder());
                Uri uri = (Uri) gr0.a(parcel, Uri.CREATOR);
                Parcelable.Creator creator = Bundle.CREATOR;
                Bundle bundle = (Bundle) gr0.a(parcel, creator);
                boolean zD = customTabsConnectionService.w.d(new CustomTabsSessionToken(interfaceC0671fr0W0, W0(bundle)), uri, bundle, parcel.createTypedArrayList(creator));
                parcel2.writeNoException();
                parcel2.writeInt(zD ? 1 : 0);
                return true;
            case 5:
                parcel.readString();
                customTabsConnectionService.w.b();
                parcel2.writeNoException();
                parcel2.writeInt(0);
                return true;
            case 6:
                InterfaceC0671fr0 interfaceC0671fr0W02 = dr0.W0(parcel.readStrongBinder());
                Bundle bundle2 = (Bundle) gr0.a(parcel, Bundle.CREATOR);
                boolean zN = customTabsConnectionService.w.n(new CustomTabsSessionToken(interfaceC0671fr0W02, W0(bundle2)), bundle2);
                parcel2.writeNoException();
                parcel2.writeInt(zN ? 1 : 0);
                return true;
            case 7:
                InterfaceC0671fr0 interfaceC0671fr0W03 = dr0.W0(parcel.readStrongBinder());
                Uri uri2 = (Uri) gr0.a(parcel, Uri.CREATOR);
                CustomTabsSessionToken customTabsSessionToken = new CustomTabsSessionToken(interfaceC0671fr0W03, null);
                new Bundle();
                customTabsConnectionService.getClass();
                Gr1.b("CustomTabs.PostMessage.RequestPostMessageChannelWithTargetOrigin", true);
                boolean zL = customTabsConnectionService.w.l(customTabsSessionToken, uri2, null);
                parcel2.writeNoException();
                parcel2.writeInt(zL ? 1 : 0);
                return true;
            case 8:
                int i3 = customTabsConnectionService.w.i(new CustomTabsSessionToken(dr0.W0(parcel.readStrongBinder()), W0((Bundle) gr0.a(parcel, Bundle.CREATOR))), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case ConnectionResult.SERVICE_INVALID /* 9 */:
                boolean zO = customTabsConnectionService.w.o(parcel.readInt(), (Uri) gr0.a(parcel, Uri.CREATOR), new CustomTabsSessionToken(dr0.W0(parcel.readStrongBinder()), W0((Bundle) gr0.a(parcel, Bundle.CREATOR))));
                parcel2.writeNoException();
                parcel2.writeInt(zO ? 1 : 0);
                return true;
            case 10:
                boolean zX02 = X0(dr0.W0(parcel.readStrongBinder()), W0((Bundle) gr0.a(parcel, Bundle.CREATOR)));
                parcel2.writeNoException();
                parcel2.writeInt(zX02 ? 1 : 0);
                return true;
            case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                InterfaceC0671fr0 interfaceC0671fr0W04 = dr0.W0(parcel.readStrongBinder());
                Uri uri3 = (Uri) gr0.a(parcel, Uri.CREATOR);
                Bundle bundle3 = (Bundle) gr0.a(parcel, Bundle.CREATOR);
                CustomTabsSessionToken customTabsSessionToken2 = new CustomTabsSessionToken(interfaceC0671fr0W04, W0(bundle3));
                Uri uri4 = bundle3 != null ? Build.VERSION.SDK_INT >= 33 ? (Uri) AbstractC0593ea.a("target_origin", bundle3) : (Uri) bundle3.getParcelable("target_origin") : null;
                customTabsConnectionService.getClass();
                Gr1.b("CustomTabs.PostMessage.RequestPostMessageChannelWithTargetOrigin", true);
                boolean zL2 = customTabsConnectionService.w.l(customTabsSessionToken2, uri3, uri4);
                parcel2.writeNoException();
                parcel2.writeInt(zL2 ? 1 : 0);
                return true;
            case 12:
                boolean zK = customTabsConnectionService.w.k(parcel.readInt(), (Uri) gr0.a(parcel, Uri.CREATOR), new CustomTabsSessionToken(dr0.W0(parcel.readStrongBinder()), W0((Bundle) gr0.a(parcel, Bundle.CREATOR))));
                parcel2.writeNoException();
                parcel2.writeInt(zK ? 1 : 0);
                return true;
            case 13:
                boolean zC = customTabsConnectionService.w.c(new CustomTabsSessionToken(dr0.W0(parcel.readStrongBinder()), W0((Bundle) gr0.a(parcel, Bundle.CREATOR))));
                parcel2.writeNoException();
                parcel2.writeInt(zC ? 1 : 0);
                return true;
            case 14:
                InterfaceC0671fr0 interfaceC0671fr0W05 = dr0.W0(parcel.readStrongBinder());
                IBinder strongBinder = parcel.readStrongBinder();
                Bundle bundle4 = (Bundle) gr0.a(parcel, Bundle.CREATOR);
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(InterfaceC1641vr0.c);
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC1641vr0)) {
                        new ur0().t = strongBinder;
                    }
                }
                boolean zM = customTabsConnectionService.w.m(new CustomTabsSessionToken(interfaceC0671fr0W05, W0(bundle4)), new q70());
                parcel2.writeNoException();
                parcel2.writeInt(zM ? 1 : 0);
                return true;
            case 15:
                InterfaceC0671fr0 interfaceC0671fr0W06 = dr0.W0(parcel.readStrongBinder());
                Uri uri5 = (Uri) gr0.a(parcel, Uri.CREATOR);
                Bundle bundle5 = (Bundle) gr0.a(parcel, Bundle.CREATOR);
                customTabsConnectionService.w.j(new CustomTabsSessionToken(interfaceC0671fr0W06, null), uri5, new C0286Xj1(bundle5.getBoolean("androidx.browser.customtabs.PrefetchOptions.KEY_REQUIRES_ANONYMOUS_IP_WHEN_CROSS_ORIGIN"), Build.VERSION.SDK_INT >= 33 ? (Uri) AbstractC0593ea.a("androidx.browser.customtabs.PrefetchOptions.KEY_SOURCE_ORIGIN", bundle5) : (Uri) bundle5.getParcelable("androidx.browser.customtabs.PrefetchOptions.KEY_SOURCE_ORIGIN")));
                parcel2.writeNoException();
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
