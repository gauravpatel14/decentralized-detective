package com.google.android.gms.vision.face.internal.client;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.C0520dI2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "ContourParcelCreator")
@SafeParcelable.Reserved({1})
public final class zza extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new C0520dI2();
    public final PointF[] t;
    public final int u;

    public zza(PointF[] pointFArr, int i) {
        this.t = pointFArr;
        this.u = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.t, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.u);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
