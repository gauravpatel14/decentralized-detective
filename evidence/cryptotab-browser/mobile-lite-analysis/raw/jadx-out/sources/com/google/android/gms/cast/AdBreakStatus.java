package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.AbstractC0700gL2;
import defpackage.C0459cI2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "AdBreakStatusCreator")
@SafeParcelable.Reserved({1})
public class AdBreakStatus extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new C0459cI2();
    public final long t;
    public final long u;
    public final String v;
    public final String w;
    public final long x;

    public AdBreakStatus(long j, long j2, String str, String str2, long j3) {
        this.t = j;
        this.u = j2;
        this.v = str;
        this.w = str2;
        this.x = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdBreakStatus)) {
            return false;
        }
        AdBreakStatus adBreakStatus = (AdBreakStatus) obj;
        return this.t == adBreakStatus.t && this.u == adBreakStatus.u && AbstractC0700gL2.a(this.v, adBreakStatus.v) && AbstractC0700gL2.a(this.w, adBreakStatus.w) && this.x == adBreakStatus.x;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.t), Long.valueOf(this.u), this.v, this.w, Long.valueOf(this.x));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, this.t);
        SafeParcelWriter.writeLong(parcel, 3, this.u);
        SafeParcelWriter.writeString(parcel, 4, this.v, false);
        SafeParcelWriter.writeString(parcel, 5, this.w, false);
        SafeParcelWriter.writeLong(parcel, 6, this.x);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
