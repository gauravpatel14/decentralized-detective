package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.C1193oC2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@ShowFirstParty
@SafeParcelable.Class(creator = "EqualizerBandSettingsCreator")
@SafeParcelable.Reserved({1})
public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new C1193oC2();
    public final float t;
    public final float u;
    public final float v;

    public zzac(float f, float f2, float f3) {
        this.t = f;
        this.u = f2;
        this.v = f3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzac)) {
            return false;
        }
        zzac zzacVar = (zzac) obj;
        return this.t == zzacVar.t && this.u == zzacVar.u && this.v == zzacVar.v;
    }

    public final int hashCode() {
        return Objects.hashCode(Float.valueOf(this.t), Float.valueOf(this.u), Float.valueOf(this.v));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloat(parcel, 2, this.t);
        SafeParcelWriter.writeFloat(parcel, 3, this.u);
        SafeParcelWriter.writeFloat(parcel, 4, this.v);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
