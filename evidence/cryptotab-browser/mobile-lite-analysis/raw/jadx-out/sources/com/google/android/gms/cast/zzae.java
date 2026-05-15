package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.AbstractC0700gL2;
import defpackage.BC2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@ShowFirstParty
@SafeParcelable.Class(creator = "EqualizerSettingsCreator")
@SafeParcelable.Reserved({1})
public final class zzae extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new BC2();
    public final zzac t;
    public final zzac u;

    public zzae(zzac zzacVar, zzac zzacVar2) {
        this.t = zzacVar;
        this.u = zzacVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzae)) {
            return false;
        }
        zzae zzaeVar = (zzae) obj;
        return AbstractC0700gL2.a(this.t, zzaeVar.t) && AbstractC0700gL2.a(this.u, zzaeVar.u);
    }

    public final int hashCode() {
        return Objects.hashCode(this.t, this.u);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.t, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.u, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
