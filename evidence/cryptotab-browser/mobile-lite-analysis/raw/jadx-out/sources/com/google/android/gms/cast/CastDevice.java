package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.AbstractC0700gL2;
import defpackage.YY2;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "CastDeviceCreator")
@SafeParcelable.Reserved({1})
public class CastDevice extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR = new YY2();
    public List A;
    public int B;
    public int C;
    public String D;
    public String E;
    public int F;
    public String G;
    public byte[] H;
    public String I;
    public String t;
    public String u;
    public InetAddress v;
    public String w;
    public String x;
    public String y;
    public int z;

    public static CastDevice f2(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(CastDevice.class.getClassLoader());
        return (CastDevice) bundle.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }

    public final boolean equals(Object obj) {
        int i;
        int i2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CastDevice)) {
            return false;
        }
        CastDevice castDevice = (CastDevice) obj;
        String str = this.t;
        if (str == null) {
            return castDevice.t == null;
        }
        if (AbstractC0700gL2.a(str, castDevice.t) && AbstractC0700gL2.a(this.v, castDevice.v) && AbstractC0700gL2.a(this.x, castDevice.x) && AbstractC0700gL2.a(this.w, castDevice.w)) {
            String str2 = this.y;
            String str3 = castDevice.y;
            if (AbstractC0700gL2.a(str2, str3) && (i = this.z) == (i2 = castDevice.z) && AbstractC0700gL2.a(this.A, castDevice.A) && this.B == castDevice.B && this.C == castDevice.C && AbstractC0700gL2.a(this.D, castDevice.D) && AbstractC0700gL2.a(Integer.valueOf(this.F), Integer.valueOf(castDevice.F)) && AbstractC0700gL2.a(this.G, castDevice.G) && AbstractC0700gL2.a(this.E, castDevice.E) && AbstractC0700gL2.a(str2, str3) && i == i2) {
                byte[] bArr = castDevice.H;
                byte[] bArr2 = this.H;
                if (((bArr2 == null && bArr == null) || Arrays.equals(bArr2, bArr)) && AbstractC0700gL2.a(this.I, castDevice.I)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean g2(int i) {
        return (this.B & i) == i;
    }

    public final int hashCode() {
        String str = this.t;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String toString() {
        return "\"" + this.w + "\" (" + this.t + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.t, false);
        SafeParcelWriter.writeString(parcel, 3, this.u, false);
        SafeParcelWriter.writeString(parcel, 4, this.w, false);
        SafeParcelWriter.writeString(parcel, 5, this.x, false);
        SafeParcelWriter.writeString(parcel, 6, this.y, false);
        SafeParcelWriter.writeInt(parcel, 7, this.z);
        SafeParcelWriter.writeTypedList(parcel, 8, Collections.unmodifiableList(this.A), false);
        SafeParcelWriter.writeInt(parcel, 9, this.B);
        SafeParcelWriter.writeInt(parcel, 10, this.C);
        SafeParcelWriter.writeString(parcel, 11, this.D, false);
        SafeParcelWriter.writeString(parcel, 12, this.E, false);
        SafeParcelWriter.writeInt(parcel, 13, this.F);
        SafeParcelWriter.writeString(parcel, 14, this.G, false);
        SafeParcelWriter.writeByteArray(parcel, 15, this.H, false);
        SafeParcelWriter.writeString(parcel, 16, this.I, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
