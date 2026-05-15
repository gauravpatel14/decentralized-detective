package android.support.v4.media;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.C1294pq1;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator CREATOR = new C1294pq1();
    public final int t;
    public final float u;
    public Object v;

    public RatingCompat(int i, float f) {
        this.t = i;
        this.u = f;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.t;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Rating:style=");
        sb.append(this.t);
        sb.append(" rating=");
        float f = this.u;
        sb.append(f < 0.0f ? "unrated" : String.valueOf(f));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.t);
        parcel.writeFloat(this.u);
    }
}
