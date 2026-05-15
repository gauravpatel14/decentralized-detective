package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.nm;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public class BackStackState implements Parcelable {
    public static final Parcelable.Creator CREATOR = new nm();
    public final ArrayList t;
    public final ArrayList u;

    public BackStackState(Parcel parcel) {
        this.t = parcel.createStringArrayList();
        this.u = parcel.createTypedArrayList(BackStackRecordState.CREATOR);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.t);
        parcel.writeTypedList(this.u);
    }
}
