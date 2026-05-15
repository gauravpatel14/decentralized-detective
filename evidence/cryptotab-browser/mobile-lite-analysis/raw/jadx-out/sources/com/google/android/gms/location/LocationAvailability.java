package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.C0819i33;
import java.util.Arrays;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "LocationAvailabilityCreator")
@SafeParcelable.Reserved({1000})
public final class LocationAvailability extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    public final int t;
    public final int u;
    public final long v;
    public final int w;
    public final zzac[] x;

    static {
        new LocationAvailability(0, 1, 1, 0L, null);
        new LocationAvailability(1000, 1, 1, 0L, null);
        CREATOR = new C0819i33();
    }

    public LocationAvailability(int i, int i2, int i3, long j, zzac[] zzacVarArr) {
        this.w = i < 1000 ? 0 : 1000;
        this.t = i2;
        this.u = i3;
        this.v = j;
        this.x = zzacVarArr;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof LocationAvailability) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            if (this.t == locationAvailability.t && this.u == locationAvailability.u && this.v == locationAvailability.v && this.w == locationAvailability.w && Arrays.equals(this.x, locationAvailability.x)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.w));
    }

    public final String toString() {
        return "LocationAvailability[" + (this.w < 1000) + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.t);
        SafeParcelWriter.writeInt(parcel, 2, this.u);
        SafeParcelWriter.writeLong(parcel, 3, this.v);
        SafeParcelWriter.writeInt(parcel, 4, this.w);
        SafeParcelWriter.writeTypedArray(parcel, 5, this.x, i, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.w < 1000);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
