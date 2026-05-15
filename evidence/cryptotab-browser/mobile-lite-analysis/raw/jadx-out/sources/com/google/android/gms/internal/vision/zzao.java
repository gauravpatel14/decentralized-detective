package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.DE2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "WordBoxParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzao extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new DE2();
    public final zzal[] t;
    public final zzab u;
    public final zzab v;
    public final String w;
    public final float x;
    public final String y;
    public final boolean z;

    public zzao(zzal[] zzalVarArr, zzab zzabVar, zzab zzabVar2, String str, float f, String str2, boolean z) {
        this.t = zzalVarArr;
        this.u = zzabVar;
        this.v = zzabVar2;
        this.w = str;
        this.x = f;
        this.y = str2;
        this.z = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.t, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.u, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.v, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.w, false);
        SafeParcelWriter.writeFloat(parcel, 6, this.x);
        SafeParcelWriter.writeString(parcel, 7, this.y, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.z);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
