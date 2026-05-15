package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.firebase.dynamiclinks.internal.DynamicLinkData;

/* JADX INFO: renamed from: ff0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC0662ff0 extends Binder implements IInterface {
    public final H62 t;
    public final InterfaceC0988kn1 u;

    public BinderC0662ff0(InterfaceC0988kn1 interfaceC0988kn1, H62 h62) {
        attachInterface(this, "com.google.firebase.dynamiclinks.internal.IDynamicLinksCallbacks");
        this.u = interfaceC0988kn1;
        this.t = h62;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        m7 m7Var;
        if (i != 1) {
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.google.firebase.dynamiclinks.internal.IDynamicLinksCallbacks");
                return true;
            }
            parcel.enforceInterface("com.google.firebase.dynamiclinks.internal.IDynamicLinksCallbacks");
            if (parcel.readInt() != 0) {
            }
            if (parcel.readInt() != 0) {
            }
            throw new UnsupportedOperationException();
        }
        parcel.enforceInterface("com.google.firebase.dynamiclinks.internal.IDynamicLinksCallbacks");
        Status status = parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null;
        DynamicLinkData dynamicLinkData = parcel.readInt() != 0 ? (DynamicLinkData) DynamicLinkData.CREATOR.createFromParcel(parcel) : null;
        TaskUtil.setResultOrApiException(status, dynamicLinkData != null ? new C0267We1(dynamicLinkData) : null, this.t);
        if (dynamicLinkData != null) {
            Bundle bundle = dynamicLinkData.x;
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = bundle.getBundle("scionData");
            if (bundle2 != null && bundle2.keySet() != null && (m7Var = (m7) this.u.get()) != null) {
                for (String str : bundle2.keySet()) {
                    ((n7) m7Var).a("fdl", str, bundle2.getBundle(str));
                }
            }
        }
        return true;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
