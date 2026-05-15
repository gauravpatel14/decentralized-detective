package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.NH2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "VideoInfoCreator")
@SafeParcelable.Reserved({1})
public final class VideoInfo extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new NH2();
    public final int t;
    public final int u;
    public final int v;

    public VideoInfo(int i, int i2, int i3) {
        this.t = i;
        this.u = i2;
        this.v = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoInfo)) {
            return false;
        }
        VideoInfo videoInfo = (VideoInfo) obj;
        return this.u == videoInfo.u && this.t == videoInfo.t && this.v == videoInfo.v;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.u), Integer.valueOf(this.t), Integer.valueOf(this.v));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.t);
        SafeParcelWriter.writeInt(parcel, 3, this.u);
        SafeParcelWriter.writeInt(parcel, 4, this.v);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
