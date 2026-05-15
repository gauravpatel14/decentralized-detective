package defpackage;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import androidx.browser.customtabs.CustomTabsSessionToken;

/* JADX INFO: renamed from: sT, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1450sT {
    public final /* synthetic */ CustomTabsSessionToken a;

    public C1450sT(CustomTabsSessionToken customTabsSessionToken) {
        this.a = customTabsSessionToken;
    }

    public final void a(String str, Bundle bundle) {
        try {
            cr0 cr0Var = (cr0) this.a.a;
            cr0Var.getClass();
            Parcel parcelObtain = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(InterfaceC0671fr0.a);
                parcelObtain.writeString(str);
                AbstractC0605er0.a(parcelObtain, bundle);
                cr0Var.t.transact(3, parcelObtain, null, 1);
                parcelObtain.recycle();
            } catch (Throwable th) {
                parcelObtain.recycle();
                throw th;
            }
        } catch (RemoteException unused) {
            Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
        }
    }

    public final void b(int i, int i2, Bundle bundle) {
        try {
            cr0 cr0Var = (cr0) this.a.a;
            cr0Var.getClass();
            Parcel parcelObtain = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(InterfaceC0671fr0.a);
                parcelObtain.writeInt(i);
                parcelObtain.writeInt(i2);
                AbstractC0605er0.a(parcelObtain, bundle);
                cr0Var.t.transact(8, parcelObtain, null, 1);
                parcelObtain.recycle();
            } catch (Throwable th) {
                parcelObtain.recycle();
                throw th;
            }
        } catch (RemoteException unused) {
            Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
        }
    }

    public final void c(Bundle bundle) {
        try {
            cr0 cr0Var = (cr0) this.a.a;
            cr0Var.getClass();
            Parcel parcelObtain = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(InterfaceC0671fr0.a);
                AbstractC0605er0.a(parcelObtain, bundle);
                cr0Var.t.transact(11, parcelObtain, null, 1);
                parcelObtain.recycle();
            } catch (Throwable th) {
                parcelObtain.recycle();
                throw th;
            }
        } catch (RemoteException unused) {
            Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
        }
    }

    public final void d(int i, Bundle bundle) {
        try {
            cr0 cr0Var = (cr0) this.a.a;
            cr0Var.getClass();
            Parcel parcelObtain = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(InterfaceC0671fr0.a);
                parcelObtain.writeInt(i);
                AbstractC0605er0.a(parcelObtain, bundle);
                cr0Var.t.transact(2, parcelObtain, null, 1);
                parcelObtain.recycle();
            } catch (Throwable th) {
                parcelObtain.recycle();
                throw th;
            }
        } catch (RemoteException unused) {
            Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
        }
    }

    public final void e(int i, Uri uri, boolean z, Bundle bundle) {
        try {
            cr0 cr0Var = (cr0) this.a.a;
            cr0Var.getClass();
            Parcel parcelObtain = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(InterfaceC0671fr0.a);
                parcelObtain.writeInt(i);
                AbstractC0605er0.a(parcelObtain, uri);
                parcelObtain.writeInt(z ? 1 : 0);
                AbstractC0605er0.a(parcelObtain, bundle);
                cr0Var.t.transact(6, parcelObtain, null, 1);
                parcelObtain.recycle();
            } catch (Throwable th) {
                parcelObtain.recycle();
                throw th;
            }
        } catch (RemoteException unused) {
            Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
        }
    }

    public final void f(Bundle bundle) {
        try {
            cr0 cr0Var = (cr0) this.a.a;
            cr0Var.getClass();
            Parcel parcelObtain = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(InterfaceC0671fr0.a);
                AbstractC0605er0.a(parcelObtain, bundle);
                cr0Var.t.transact(12, parcelObtain, null, 1);
                parcelObtain.recycle();
            } catch (Throwable th) {
                parcelObtain.recycle();
                throw th;
            }
        } catch (RemoteException unused) {
            Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
        }
    }

    public final void g(Bundle bundle) {
        try {
            cr0 cr0Var = (cr0) this.a.a;
            cr0Var.getClass();
            Parcel parcelObtain = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(InterfaceC0671fr0.a);
                AbstractC0605er0.a(parcelObtain, bundle);
                cr0Var.t.transact(9, parcelObtain, null, 1);
                parcelObtain.recycle();
            } catch (Throwable th) {
                parcelObtain.recycle();
                throw th;
            }
        } catch (RemoteException unused) {
            Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
        }
    }
}
