package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.C1637vn2;
import defpackage.InterfaceC1694wn2;
import defpackage.Z81;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Z81();
    public final InterfaceC1694wn2 t;

    public ParcelImpl(InterfaceC1694wn2 interfaceC1694wn2) {
        this.t = interfaceC1694wn2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        new C1637vn2(parcel).l(this.t);
    }

    public ParcelImpl(Parcel parcel) {
        this.t = new C1637vn2(parcel).h();
    }
}
