package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.HC2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@ShowFirstParty
@SafeParcelable.Class(creator = "NetworkLocationStatusCreator")
@Deprecated
public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new HC2();
    public final int t;
    public final int u;
    public final long v;
    public final long w;

    public zzac(int i, int i2, long j, long j2) {
        this.t = i;
        this.u = i2;
        this.v = j;
        this.w = j2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzac) {
            zzac zzacVar = (zzac) obj;
            if (this.t == zzacVar.t && this.u == zzacVar.u && this.v == zzacVar.v && this.w == zzacVar.w) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.u), Integer.valueOf(this.t), Long.valueOf(this.w), Long.valueOf(this.v));
    }

    public final String toString() {
        return "NetworkLocationStatus: Wifi status: " + this.t + " Cell status: " + this.u + " elapsed time NS: " + this.w + " system time ms: " + this.v;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.t);
        SafeParcelWriter.writeInt(parcel, 2, this.u);
        SafeParcelWriter.writeLong(parcel, 3, this.v);
        SafeParcelWriter.writeLong(parcel, 4, this.w);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
