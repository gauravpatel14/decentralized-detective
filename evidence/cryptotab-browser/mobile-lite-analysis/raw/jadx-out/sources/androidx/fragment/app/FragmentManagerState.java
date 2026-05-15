package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.C1347qi0;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator CREATOR = new C1347qi0();
    public ArrayList A;
    public ArrayList t;
    public ArrayList u;
    public BackStackRecordState[] v;
    public int w;
    public String x;
    public ArrayList y;
    public ArrayList z;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.t);
        parcel.writeStringList(this.u);
        parcel.writeTypedArray(this.v, i);
        parcel.writeInt(this.w);
        parcel.writeString(this.x);
        parcel.writeStringList(this.y);
        parcel.writeTypedList(this.z);
        parcel.writeTypedList(this.A);
    }
}
