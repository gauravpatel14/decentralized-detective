package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.C1078mJ2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "InitializationParamsCreator")
public final class zzcl extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new C1078mJ2();
    public final String A;
    public final long t;
    public final long u;
    public final boolean v;
    public final String w;
    public final String x;
    public final String y;
    public final Bundle z;

    public zzcl(long j, long j2, boolean z, String str, String str2, String str3, Bundle bundle, String str4) {
        this.t = j;
        this.u = j2;
        this.v = z;
        this.w = str;
        this.x = str2;
        this.y = str3;
        this.z = bundle;
        this.A = str4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.t);
        SafeParcelWriter.writeLong(parcel, 2, this.u);
        SafeParcelWriter.writeBoolean(parcel, 3, this.v);
        SafeParcelWriter.writeString(parcel, 4, this.w, false);
        SafeParcelWriter.writeString(parcel, 5, this.x, false);
        SafeParcelWriter.writeString(parcel, 6, this.y, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.z, false);
        SafeParcelWriter.writeString(parcel, 8, this.A, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
