package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.AbstractC0462cM2;
import defpackage.AbstractC1214oR1;
import defpackage.AbstractC1441sM2;
import defpackage.C0701gM2;
import defpackage.C1556uM2;
import defpackage.NL2;
import defpackage.WM2;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "ClientIdentityCreator")
public final class zzd extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new WM2();
    public final AbstractC1441sM2 A;
    public final int t;
    public final int u;
    public final String v;
    public final String w;
    public final int x;
    public final String y;
    public final zzd z;

    static {
        Process.myUid();
        Process.myPid();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public zzd(int i, int i2, String str, String str2, String str3, int i3, List list, zzd zzdVar) {
        C1556uM2 c1556uM2;
        C1556uM2 c1556uM22;
        AbstractC1441sM2 abstractC1441sM2;
        this.t = i;
        this.u = i2;
        this.v = str;
        this.w = str2;
        this.y = str3;
        this.x = i3;
        C0701gM2 c0701gM2 = AbstractC1441sM2.u;
        if (list instanceof AbstractC0462cM2) {
            abstractC1441sM2 = (AbstractC1441sM2) ((AbstractC0462cM2) list);
            abstractC1441sM2.getClass();
            if (abstractC1441sM2.l()) {
                Object[] array = abstractC1441sM2.toArray(AbstractC0462cM2.t);
                int length = array.length;
                if (length == 0) {
                    c1556uM22 = C1556uM2.x;
                    abstractC1441sM2 = c1556uM22;
                } else {
                    c1556uM2 = new C1556uM2(length, array);
                    abstractC1441sM2 = c1556uM2;
                }
            }
        } else {
            Object[] array2 = list.toArray();
            int length2 = array2.length;
            for (int i4 = 0; i4 < length2; i4++) {
                if (array2[i4] == null) {
                    throw new NullPointerException(AbstractC1214oR1.a(i4, "at index "));
                }
            }
            if (length2 == 0) {
                c1556uM22 = C1556uM2.x;
                abstractC1441sM2 = c1556uM22;
            } else {
                c1556uM2 = new C1556uM2(length2, array2);
                abstractC1441sM2 = c1556uM2;
            }
        }
        this.A = abstractC1441sM2;
        this.z = zzdVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzd) {
            zzd zzdVar = (zzd) obj;
            if (this.t == zzdVar.t && this.u == zzdVar.u && this.x == zzdVar.x && this.v.equals(zzdVar.v) && NL2.a(this.w, zzdVar.w) && NL2.a(this.y, zzdVar.y) && NL2.a(this.z, zzdVar.z) && this.A.equals(zzdVar.A)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.t), this.v, this.w, this.y});
    }

    public final String toString() {
        String str = this.v;
        int length = str.length() + 18;
        String str2 = this.w;
        if (str2 != null) {
            length += str2.length();
        }
        StringBuilder sb = new StringBuilder(length);
        sb.append(this.t);
        sb.append("/");
        sb.append(str);
        if (str2 != null) {
            sb.append("[");
            if (str2.startsWith(str)) {
                sb.append((CharSequence) str2, str.length(), str2.length());
            } else {
                sb.append(str2);
            }
            sb.append("]");
        }
        String str3 = this.y;
        if (str3 != null) {
            sb.append("/");
            sb.append(Integer.toHexString(str3.hashCode()));
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.t);
        SafeParcelWriter.writeInt(parcel, 2, this.u);
        SafeParcelWriter.writeString(parcel, 3, this.v, false);
        SafeParcelWriter.writeString(parcel, 4, this.w, false);
        SafeParcelWriter.writeInt(parcel, 5, this.x);
        SafeParcelWriter.writeString(parcel, 6, this.y, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.z, i, false);
        SafeParcelWriter.writeTypedList(parcel, 8, this.A, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
