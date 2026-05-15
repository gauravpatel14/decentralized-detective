package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import defpackage.CM0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class CM0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(final Parcel parcel) {
        return new Parcelable(parcel) { // from class: android.support.v4.media.MediaBrowserCompat$MediaItem
            public static final Parcelable.Creator CREATOR = new CM0();
            public final int t;
            public final MediaDescriptionCompat u;

            {
                this.t = parcel.readInt();
                this.u = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            public final String toString() {
                return "MediaItem{mFlags=" + this.t + ", mDescription=" + this.u + '}';
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel parcel2, int i) {
                parcel2.writeInt(this.t);
                this.u.writeToParcel(parcel2, i);
            }
        };
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new MediaBrowserCompat$MediaItem[i];
    }
}
