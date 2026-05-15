package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.BN0;
import defpackage.C1133nD2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@ShowFirstParty
@SafeParcelable.Class(creator = "JoinOptionsCreator")
@SafeParcelable.Reserved({1})
public final class zzah extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new C1133nD2();
    public final int t;

    public zzah(int i) {
        this.t = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof zzah) && this.t == ((zzah) obj).t;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.t));
    }

    public final String toString() {
        int i = this.t;
        return BN0.a("joinOptions(connectionType=", i != 0 ? i != 2 ? "UNKNOWN" : "INVISIBLE" : "STRONG", ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.t);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
