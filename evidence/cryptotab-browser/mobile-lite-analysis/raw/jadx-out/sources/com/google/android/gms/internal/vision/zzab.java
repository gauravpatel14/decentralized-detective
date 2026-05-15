package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.ZB2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "BoundingBoxParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzab extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new ZB2();
    public final int t;
    public final int u;
    public final int v;
    public final int w;
    public final float x;

    public zzab(int i, int i2, int i3, int i4, float f) {
        this.t = i;
        this.u = i2;
        this.v = i3;
        this.w = i4;
        this.x = f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.t);
        SafeParcelWriter.writeInt(parcel, 3, this.u);
        SafeParcelWriter.writeInt(parcel, 4, this.v);
        SafeParcelWriter.writeInt(parcel, 5, this.w);
        SafeParcelWriter.writeFloat(parcel, 6, this.x);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
