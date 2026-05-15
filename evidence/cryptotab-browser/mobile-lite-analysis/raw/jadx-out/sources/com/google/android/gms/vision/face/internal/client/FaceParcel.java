package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByNative;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.DK2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@UsedByNative("wrapper.cc")
@SafeParcelable.Class(creator = "FaceParcelCreator")
public class FaceParcel extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator CREATOR = new DK2();
    public final float A;
    public final float B;
    public final LandmarkParcel[] C;
    public final float D;
    public final float E;
    public final float F;
    public final zza[] G;
    public final float H;
    public final int t;
    public final int u;
    public final float v;
    public final float w;
    public final float x;
    public final float y;
    public final float z;

    public FaceParcel(int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, LandmarkParcel[] landmarkParcelArr, float f8, float f9, float f10, zza[] zzaVarArr, float f11) {
        this.t = i;
        this.u = i2;
        this.v = f;
        this.w = f2;
        this.x = f3;
        this.y = f4;
        this.z = f5;
        this.A = f6;
        this.B = f7;
        this.C = landmarkParcelArr;
        this.D = f8;
        this.E = f9;
        this.F = f10;
        this.G = zzaVarArr;
        this.H = f11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.t);
        SafeParcelWriter.writeInt(parcel, 2, this.u);
        SafeParcelWriter.writeFloat(parcel, 3, this.v);
        SafeParcelWriter.writeFloat(parcel, 4, this.w);
        SafeParcelWriter.writeFloat(parcel, 5, this.x);
        SafeParcelWriter.writeFloat(parcel, 6, this.y);
        SafeParcelWriter.writeFloat(parcel, 7, this.z);
        SafeParcelWriter.writeFloat(parcel, 8, this.A);
        SafeParcelWriter.writeTypedArray(parcel, 9, this.C, i, false);
        SafeParcelWriter.writeFloat(parcel, 10, this.D);
        SafeParcelWriter.writeFloat(parcel, 11, this.E);
        SafeParcelWriter.writeFloat(parcel, 12, this.F);
        SafeParcelWriter.writeTypedArray(parcel, 13, this.G, i, false);
        SafeParcelWriter.writeFloat(parcel, 14, this.B);
        SafeParcelWriter.writeFloat(parcel, 15, this.H);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
