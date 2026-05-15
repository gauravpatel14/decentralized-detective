package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.AbstractC0700gL2;
import defpackage.RK2;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "ApplicationMetadataCreator")
@SafeParcelable.Reserved({1})
public class ApplicationMetadata extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new RK2();
    public String t;
    public String u;
    public ArrayList v;
    public String w;
    public Uri x;
    public String y;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationMetadata)) {
            return false;
        }
        ApplicationMetadata applicationMetadata = (ApplicationMetadata) obj;
        return AbstractC0700gL2.a(this.t, applicationMetadata.t) && AbstractC0700gL2.a(this.u, applicationMetadata.u) && AbstractC0700gL2.a(this.v, applicationMetadata.v) && AbstractC0700gL2.a(this.w, applicationMetadata.w) && AbstractC0700gL2.a(this.x, applicationMetadata.x) && AbstractC0700gL2.a(this.y, applicationMetadata.y);
    }

    public final int hashCode() {
        return Objects.hashCode(this.t, this.u, this.v, this.w, this.x, this.y);
    }

    public final String toString() {
        ArrayList arrayList = this.v;
        int size = arrayList == null ? 0 : arrayList.size();
        String strValueOf = String.valueOf(this.x);
        String str = this.t;
        int length = String.valueOf(str).length() + 110;
        String str2 = this.u;
        int length2 = String.valueOf(str2).length() + length;
        String str3 = this.w;
        int length3 = strValueOf.length() + String.valueOf(str3).length() + length2;
        String str4 = this.y;
        StringBuilder sb = new StringBuilder(String.valueOf(str4).length() + length3);
        sb.append("applicationId: ");
        sb.append(str);
        sb.append(", name: ");
        sb.append(str2);
        sb.append(", namespaces.count: ");
        sb.append(size);
        sb.append(", senderAppIdentifier: ");
        sb.append(str3);
        sb.append(", senderAppLaunchUrl: ");
        sb.append(strValueOf);
        sb.append(", iconUrl: ");
        sb.append(str4);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.t, false);
        SafeParcelWriter.writeString(parcel, 3, this.u, false);
        SafeParcelWriter.writeTypedList(parcel, 4, null, false);
        SafeParcelWriter.writeStringList(parcel, 5, Collections.unmodifiableList(this.v), false);
        SafeParcelWriter.writeString(parcel, 6, this.w, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.x, i, false);
        SafeParcelWriter.writeString(parcel, 8, this.y, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
