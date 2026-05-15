package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.AbstractC0700gL2;
import defpackage.JH2;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "VastAdsRequestCreator")
@SafeParcelable.Reserved({1})
public class VastAdsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new JH2();
    public final String t;
    public final String u;

    public VastAdsRequest(String str, String str2) {
        this.t = str;
        this.u = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VastAdsRequest)) {
            return false;
        }
        VastAdsRequest vastAdsRequest = (VastAdsRequest) obj;
        return AbstractC0700gL2.a(this.t, vastAdsRequest.t) && AbstractC0700gL2.a(this.u, vastAdsRequest.u);
    }

    public final int hashCode() {
        return Objects.hashCode(this.t, this.u);
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.t;
            if (str != null) {
                jSONObject.put("adTagUrl", str);
            }
            String str2 = this.u;
            if (str2 != null) {
                jSONObject.put("adsResponse", str2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.t, false);
        SafeParcelWriter.writeString(parcel, 3, this.u, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
