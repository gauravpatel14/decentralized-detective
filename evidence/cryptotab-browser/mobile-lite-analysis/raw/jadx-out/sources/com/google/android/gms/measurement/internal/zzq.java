package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.D13;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "AppMetadataCreator")
@SafeParcelable.Reserved({1, 17, 20})
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new D13();
    public final boolean A;
    public final boolean B;
    public final long C;
    public final String D;
    public final long E;
    public final long F;
    public final int G;
    public final boolean H;
    public final boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final String f24J;
    public final Boolean K;
    public final long L;
    public final List M;
    public final String N;
    public final String O;
    public final String P;
    public final String Q;
    public final String t;
    public final String u;
    public final String v;
    public final String w;
    public final long x;
    public final long y;
    public final String z;

    public zzq(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, long j5, int i, boolean z3, boolean z4, String str7, Boolean bool, long j6, List list, String str8, String str9, String str10) {
        Preconditions.checkNotEmpty(str);
        this.t = str;
        this.u = true != TextUtils.isEmpty(str2) ? str2 : null;
        this.v = str3;
        this.C = j;
        this.w = str4;
        this.x = j2;
        this.y = j3;
        this.z = str5;
        this.A = z;
        this.B = z2;
        this.D = str6;
        this.E = j4;
        this.F = j5;
        this.G = i;
        this.H = z3;
        this.I = z4;
        this.f24J = str7;
        this.K = bool;
        this.L = j6;
        this.M = list;
        this.N = null;
        this.O = str8;
        this.P = str9;
        this.Q = str10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.t, false);
        SafeParcelWriter.writeString(parcel, 3, this.u, false);
        SafeParcelWriter.writeString(parcel, 4, this.v, false);
        SafeParcelWriter.writeString(parcel, 5, this.w, false);
        SafeParcelWriter.writeLong(parcel, 6, this.x);
        SafeParcelWriter.writeLong(parcel, 7, this.y);
        SafeParcelWriter.writeString(parcel, 8, this.z, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.A);
        SafeParcelWriter.writeBoolean(parcel, 10, this.B);
        SafeParcelWriter.writeLong(parcel, 11, this.C);
        SafeParcelWriter.writeString(parcel, 12, this.D, false);
        SafeParcelWriter.writeLong(parcel, 13, this.E);
        SafeParcelWriter.writeLong(parcel, 14, this.F);
        SafeParcelWriter.writeInt(parcel, 15, this.G);
        SafeParcelWriter.writeBoolean(parcel, 16, this.H);
        SafeParcelWriter.writeBoolean(parcel, 18, this.I);
        SafeParcelWriter.writeString(parcel, 19, this.f24J, false);
        SafeParcelWriter.writeBooleanObject(parcel, 21, this.K, false);
        SafeParcelWriter.writeLong(parcel, 22, this.L);
        SafeParcelWriter.writeStringList(parcel, 23, this.M, false);
        SafeParcelWriter.writeString(parcel, 24, this.N, false);
        SafeParcelWriter.writeString(parcel, 25, this.O, false);
        SafeParcelWriter.writeString(parcel, 26, this.P, false);
        SafeParcelWriter.writeString(parcel, 27, this.Q, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzq(String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z, boolean z2, long j3, String str6, long j4, long j5, int i, boolean z3, boolean z4, String str7, Boolean bool, long j6, ArrayList arrayList, String str8, String str9, String str10, String str11) {
        this.t = str;
        this.u = str2;
        this.v = str3;
        this.C = j3;
        this.w = str4;
        this.x = j;
        this.y = j2;
        this.z = str5;
        this.A = z;
        this.B = z2;
        this.D = str6;
        this.E = j4;
        this.F = j5;
        this.G = i;
        this.H = z3;
        this.I = z4;
        this.f24J = str7;
        this.K = bool;
        this.L = j6;
        this.M = arrayList;
        this.N = str8;
        this.O = str9;
        this.P = str10;
        this.Q = str11;
    }
}
