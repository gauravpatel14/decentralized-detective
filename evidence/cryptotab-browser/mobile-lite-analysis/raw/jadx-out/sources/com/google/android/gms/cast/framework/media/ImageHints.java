package com.google.android.gms.cast.framework.media;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.LO2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "ImageHintsCreator")
@SafeParcelable.Reserved({1})
public class ImageHints extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new LO2();
    public final int t;
    public final int u;
    public final int v;

    public ImageHints(int i, int i2, int i3) {
        this.t = i;
        this.u = i2;
        this.v = i3;
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
