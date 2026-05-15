package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.C0945kD2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "LineBoxParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzah extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new C0945kD2();
    public final int A;
    public final boolean B;
    public final int C;
    public final int D;
    public final zzao[] t;
    public final zzab u;
    public final zzab v;
    public final zzab w;
    public final String x;
    public final float y;
    public final String z;

    public zzah(zzao[] zzaoVarArr, zzab zzabVar, zzab zzabVar2, zzab zzabVar3, String str, float f, String str2, int i, boolean z, int i2, int i3) {
        this.t = zzaoVarArr;
        this.u = zzabVar;
        this.v = zzabVar2;
        this.w = zzabVar3;
        this.x = str;
        this.y = f;
        this.z = str2;
        this.A = i;
        this.B = z;
        this.C = i2;
        this.D = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.t, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.u, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.v, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.w, i, false);
        SafeParcelWriter.writeString(parcel, 6, this.x, false);
        SafeParcelWriter.writeFloat(parcel, 7, this.y);
        SafeParcelWriter.writeString(parcel, 8, this.z, false);
        SafeParcelWriter.writeInt(parcel, 9, this.A);
        SafeParcelWriter.writeBoolean(parcel, 10, this.B);
        SafeParcelWriter.writeInt(parcel, 11, this.C);
        SafeParcelWriter.writeInt(parcel, 12, this.D);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
