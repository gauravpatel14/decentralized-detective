package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.ArrayList;

/* JADX INFO: renamed from: aH2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0342aH2 implements InterfaceC0889jH2, IInterface {
    public final IBinder t;

    public C0342aH2(IBinder iBinder) {
        this.t = iBinder;
    }

    @Override // defpackage.InterfaceC0889jH2
    public final void C0(String str, ArrayList arrayList, Bundle bundle, WF2 wf2) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken("com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
        parcelObtain.writeString(str);
        parcelObtain.writeTypedList(arrayList);
        int i = AbstractC1398rY2.a;
        parcelObtain.writeInt(1);
        bundle.writeToParcel(parcelObtain, 0);
        parcelObtain.writeStrongBinder(wf2);
        W0(2, parcelObtain);
    }

    public final void W0(int i, Parcel parcel) {
        try {
            this.t.transact(i, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.t;
    }

    @Override // defpackage.InterfaceC0889jH2
    public final void r(String str, ArrayList arrayList, Bundle bundle, BinderC0339aF2 binderC0339aF2) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken("com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
        parcelObtain.writeString(str);
        parcelObtain.writeTypedList(arrayList);
        int i = AbstractC1398rY2.a;
        parcelObtain.writeInt(1);
        bundle.writeToParcel(parcelObtain, 0);
        parcelObtain.writeStrongBinder(binderC0339aF2);
        W0(13, parcelObtain);
    }

    @Override // defpackage.InterfaceC0889jH2
    public final void v(String str, ArrayList arrayList, Bundle bundle, VE2 ve2) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken("com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
        parcelObtain.writeString(str);
        parcelObtain.writeTypedList(arrayList);
        int i = AbstractC1398rY2.a;
        parcelObtain.writeInt(1);
        bundle.writeToParcel(parcelObtain, 0);
        parcelObtain.writeStrongBinder(ve2);
        W0(8, parcelObtain);
    }
}
