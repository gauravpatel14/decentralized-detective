package defpackage;

import J.N;
import android.content.pm.ApplicationInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.util.List;
import org.chromium.base.ThreadUtils;
import org.chromium.base.process_launcher.FileDescriptorInfo;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BA extends Binder implements Zq0 {
    public static final /* synthetic */ int u = 0;
    public final /* synthetic */ CA t;

    public BA(CA ca) {
        this.t = ca;
        attachInterface(this, "org.chromium.base.process_launcher.IChildProcessService");
    }

    @Override // defpackage.Zq0
    public final void C() {
        synchronized (this.t.e) {
            try {
                if (this.t.l) {
                    N._V(8);
                } else {
                    Log.e("cr_ChildProcessService", "Cannot dump process stack before native is loaded");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.Zq0
    public final void H0(final int i) {
        ThreadUtils.d(new Runnable() { // from class: AA
            @Override // java.lang.Runnable
            public final void run() {
                C0410bQ0 c0410bQ0 = C0410bQ0.f;
                int i2 = c0410bQ0.a;
                int i3 = i;
                if (i3 >= i2) {
                    if (c0410bQ0.c) {
                        c0410bQ0.b = Integer.valueOf(i3);
                    } else {
                        c0410bQ0.c(i3);
                    }
                }
            }
        });
    }

    @Override // defpackage.Zq0
    public final void I0() {
        Process.killProcess(Process.myPid());
    }

    @Override // defpackage.Zq0
    public final ApplicationInfo P0() {
        return this.t.c.getApplicationInfo();
    }

    @Override // defpackage.Zq0
    public final void k(Bundle bundle) {
        this.t.a.getClass();
        OE0.h.d.d(bundle);
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        int i3;
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface("org.chromium.base.process_launcher.IChildProcessService");
        }
        if (i == 1598968902) {
            parcel2.writeString("org.chromium.base.process_launcher.IChildProcessService");
            return true;
        }
        hs0 hs0Var = null;
        switch (i) {
            case 1:
                String string = parcel.readString();
                synchronized (this.t.d) {
                    try {
                        int callingPid = Binder.getCallingPid();
                        CA ca = this.t;
                        int i4 = ca.g;
                        if (i4 == 0 && ca.h == null) {
                            ca.g = callingPid;
                            ca.h = string;
                        } else {
                            i3 = 0;
                            if (i4 != callingPid) {
                                Log.e("cr_ChildProcessService", "Service is already bound by pid " + i4 + ", cannot bind for pid " + callingPid);
                            } else if (!TextUtils.equals(ca.h, string)) {
                                Log.w("cr_ChildProcessService", "Service is already bound by " + this.t.h + ", cannot bind for " + string);
                            }
                        }
                        i3 = 1;
                    } finally {
                    }
                }
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 2:
                ApplicationInfo applicationInfoP0 = P0();
                parcel2.writeNoException();
                if (applicationInfoP0 != null) {
                    parcel2.writeInt(1);
                    applicationInfoP0.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case 3:
                Bundle bundle = (Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("org.chromium.base.process_launcher.IParentProcess");
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof hs0)) {
                        C0737gs0 c0737gs0 = new C0737gs0();
                        c0737gs0.t = strongBinder;
                        hs0Var = c0737gs0;
                    } else {
                        hs0Var = (hs0) iInterfaceQueryLocalInterface;
                    }
                }
                z0(bundle, hs0Var, parcel.createBinderArrayList(), parcel.readStrongBinder());
                return true;
            case 4:
                I0();
                return true;
            case 5:
                H0(parcel.readInt());
                return true;
            case 6:
                C();
                return true;
            case 7:
                k((Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null));
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }

    @Override // defpackage.Zq0
    public final void z0(Bundle bundle, hs0 hs0Var, List list, IBinder iBinder) {
        boolean z;
        long j;
        Bundle bundle2;
        int i;
        synchronized (this.t.d) {
            try {
                CA ca = this.t;
                if (ca.f && ca.g == 0) {
                    Log.e("cr_ChildProcessService", "Service has not been bound with bindToCaller()");
                    hs0Var.h(-1, 0, 0L, null);
                    return;
                }
                int iMyPid = Process.myPid();
                OE0 oe0 = OE0.h;
                synchronized (oe0.e) {
                    z = oe0.f;
                }
                if (z) {
                    int i2 = CA.q;
                    long j2 = CA.r;
                    NE0 ne0 = oe0.d;
                    ne0.b();
                    Bundle bundle3 = new Bundle();
                    ne0.c(bundle3);
                    bundle2 = bundle3;
                    j = j2;
                    i = i2;
                } else {
                    j = -1;
                    bundle2 = null;
                    i = 0;
                }
                hs0Var.h(iMyPid, i, j, bundle2);
                CA ca2 = this.t;
                ca2.n = hs0Var;
                bundle.setClassLoader(ca2.c.getClassLoader());
                synchronized (ca2.i) {
                    try {
                        if (ca2.j == null) {
                            ca2.j = bundle.getStringArray("org.chromium.base.process_launcher.extra.command_line");
                            ca2.i.notifyAll();
                        }
                        Parcelable[] parcelableArray = bundle.getParcelableArray("org.chromium.base.process_launcher.extra.extraFiles");
                        if (parcelableArray != null) {
                            FileDescriptorInfo[] fileDescriptorInfoArr = new FileDescriptorInfo[parcelableArray.length];
                            ca2.k = fileDescriptorInfoArr;
                            System.arraycopy(parcelableArray, 0, fileDescriptorInfoArr, 0, parcelableArray.length);
                        }
                        ca2.a.b(bundle, list, iBinder);
                        ca2.i.notifyAll();
                    } finally {
                    }
                }
            } finally {
            }
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
