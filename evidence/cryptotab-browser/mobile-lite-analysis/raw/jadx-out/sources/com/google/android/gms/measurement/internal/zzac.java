package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.IC2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "ConditionalUserPropertyParcelCreator")
public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new IC2();
    public long A;
    public zzaw B;
    public final long C;
    public final zzaw D;
    public String t;
    public String u;
    public zzlo v;
    public long w;
    public boolean x;
    public String y;
    public final zzaw z;

    public zzac(zzac zzacVar) {
        Preconditions.checkNotNull(zzacVar);
        this.t = zzacVar.t;
        this.u = zzacVar.u;
        this.v = zzacVar.v;
        this.w = zzacVar.w;
        this.x = zzacVar.x;
        this.y = zzacVar.y;
        this.z = zzacVar.z;
        this.A = zzacVar.A;
        this.B = zzacVar.B;
        this.C = zzacVar.C;
        this.D = zzacVar.D;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.t, false);
        SafeParcelWriter.writeString(parcel, 3, this.u, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.v, i, false);
        SafeParcelWriter.writeLong(parcel, 5, this.w);
        SafeParcelWriter.writeBoolean(parcel, 6, this.x);
        SafeParcelWriter.writeString(parcel, 7, this.y, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.z, i, false);
        SafeParcelWriter.writeLong(parcel, 9, this.A);
        SafeParcelWriter.writeParcelable(parcel, 10, this.B, i, false);
        SafeParcelWriter.writeLong(parcel, 11, this.C);
        SafeParcelWriter.writeParcelable(parcel, 12, this.D, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzac(String str, String str2, zzlo zzloVar, long j, boolean z, String str3, zzaw zzawVar, long j2, zzaw zzawVar2, long j3, zzaw zzawVar3) {
        this.t = str;
        this.u = str2;
        this.v = zzloVar;
        this.w = j;
        this.x = z;
        this.y = str3;
        this.z = zzawVar;
        this.A = j2;
        this.B = zzawVar2;
        this.C = j3;
        this.D = zzawVar3;
    }
}
