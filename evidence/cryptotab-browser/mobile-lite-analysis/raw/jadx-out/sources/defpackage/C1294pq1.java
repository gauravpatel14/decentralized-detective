package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.RatingCompat;

/* JADX INFO: renamed from: pq1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1294pq1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new RatingCompat(parcel.readInt(), parcel.readFloat());
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new RatingCompat[i];
    }
}
