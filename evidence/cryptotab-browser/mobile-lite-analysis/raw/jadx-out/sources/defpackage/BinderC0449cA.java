package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;

/* JADX INFO: renamed from: cA, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC0449cA extends Binder implements hs0 {
    public final /* synthetic */ C0619fA t;

    public BinderC0449cA(C0619fA c0619fA) {
        this.t = c0619fA;
        attachInterface(this, "org.chromium.base.process_launcher.IParentProcess");
    }

    @Override // defpackage.hs0
    public final void f() {
        C0619fA c0619fA;
        synchronized (this.t.a) {
            c0619fA = this.t;
            c0619fA.H = true;
        }
        c0619fA.b.post(new RunnableC0390bA(this));
    }

    @Override // defpackage.hs0
    public final void h(final int i, final int i2, final long j, final Bundle bundle) {
        this.t.b.post(new Runnable() { // from class: aA
            @Override // java.lang.Runnable
            public final void run() {
                C0619fA c0619fA = this.t.t;
                int i3 = c0619fA.n;
                if (i3 != 0) {
                    Log.e("cr_ChildProcessConn", "Pid was sent more than once: pid=" + i3);
                    return;
                }
                c0619fA.n = i;
                c0619fA.o = i2;
                C1005lA c1005lA = c0619fA.i;
                if (c1005lA != null) {
                    c1005lA.a.a.f(c0619fA, bundle);
                }
                c0619fA.i = null;
                int i4 = C0619fA.f26J;
                int i5 = c0619fA.o;
                if (i4 != i5 && i5 != 0) {
                    C0619fA.f26J = i5;
                    Gr1.k(j, "Android.ChildProcessStartTimeV2.Zygote");
                }
                C1005lA c1005lA2 = c0619fA.h;
                if (c1005lA2 != null) {
                    c1005lA2.c();
                }
                c0619fA.h = null;
            }
        });
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface("org.chromium.base.process_launcher.IParentProcess");
        }
        if (i == 1598968902) {
            parcel2.writeString("org.chromium.base.process_launcher.IParentProcess");
            return true;
        }
        if (i == 1) {
            h(parcel.readInt(), parcel.readInt(), parcel.readLong(), (Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null));
        } else if (i == 2) {
            v0(parcel.readString());
            parcel2.writeNoException();
        } else {
            if (i != 3) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            f();
            parcel2.writeNoException();
        }
        return true;
    }

    @Override // defpackage.hs0
    public final void v0(String str) {
        C0619fA c0619fA;
        synchronized (this.t.a) {
            c0619fA = this.t;
            c0619fA.G = str;
        }
        c0619fA.b.post(new RunnableC0390bA(this));
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
