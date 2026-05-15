package com.google.android.gms.internal.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.zzae;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.AbstractC0700gL2;
import defpackage.C1204oL2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "DeviceStatusCreator")
@SafeParcelable.Reserved({1})
public final class zzdb extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new C1204oL2();
    public double t;
    public boolean u;
    public int v;
    public ApplicationMetadata w;
    public int x;
    public zzae y;
    public double z;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdb)) {
            return false;
        }
        zzdb zzdbVar = (zzdb) obj;
        if (this.t == zzdbVar.t && this.u == zzdbVar.u && this.v == zzdbVar.v && AbstractC0700gL2.a(this.w, zzdbVar.w) && this.x == zzdbVar.x) {
            zzae zzaeVar = this.y;
            if (AbstractC0700gL2.a(zzaeVar, zzaeVar) && this.z == zzdbVar.z) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Double.valueOf(this.t), Boolean.valueOf(this.u), Integer.valueOf(this.v), this.w, Integer.valueOf(this.x), this.y, Double.valueOf(this.z));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeDouble(parcel, 2, this.t);
        SafeParcelWriter.writeBoolean(parcel, 3, this.u);
        SafeParcelWriter.writeInt(parcel, 4, this.v);
        SafeParcelWriter.writeParcelable(parcel, 5, this.w, i, false);
        SafeParcelWriter.writeInt(parcel, 6, this.x);
        SafeParcelWriter.writeParcelable(parcel, 7, this.y, i, false);
        SafeParcelWriter.writeDouble(parcel, 8, this.z);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
