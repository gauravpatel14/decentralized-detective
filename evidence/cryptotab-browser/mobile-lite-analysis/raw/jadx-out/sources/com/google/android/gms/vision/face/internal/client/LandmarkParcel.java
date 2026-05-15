package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByNative;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.C1098mY2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@UsedByNative("wrapper.cc")
@SafeParcelable.Class(creator = "LandmarkParcelCreator")
public final class LandmarkParcel extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator CREATOR = new C1098mY2();
    public final int t;
    public final float u;
    public final float v;
    public final int w;

    public LandmarkParcel(int i, float f, float f2, int i2) {
        this.t = i;
        this.u = f;
        this.v = f2;
        this.w = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.t);
        SafeParcelWriter.writeFloat(parcel, 2, this.u);
        SafeParcelWriter.writeFloat(parcel, 3, this.v);
        SafeParcelWriter.writeInt(parcel, 4, this.w);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
