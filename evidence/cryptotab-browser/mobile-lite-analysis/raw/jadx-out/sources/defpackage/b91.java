package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.ParcelableVolumeInfo;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class b91 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ParcelableVolumeInfo parcelableVolumeInfo = new ParcelableVolumeInfo();
        parcelableVolumeInfo.t = parcel.readInt();
        parcelableVolumeInfo.v = parcel.readInt();
        parcelableVolumeInfo.w = parcel.readInt();
        parcelableVolumeInfo.x = parcel.readInt();
        parcelableVolumeInfo.u = parcel.readInt();
        return parcelableVolumeInfo;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new ParcelableVolumeInfo[i];
    }
}
