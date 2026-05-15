package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.AbstractC0700gL2;
import defpackage.QB2;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "AdBreakClipInfoCreator")
@SafeParcelable.Reserved({1})
public class AdBreakClipInfo extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new QB2();
    public final String A;
    public final String B;
    public final long C;
    public final String D;
    public final VastAdsRequest E;
    public final JSONObject F;
    public final String t;
    public final String u;
    public final long v;
    public final String w;
    public final String x;
    public final String y;
    public final String z;

    public AdBreakClipInfo(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, long j2, String str9, VastAdsRequest vastAdsRequest) {
        this.t = str;
        this.u = str2;
        this.v = j;
        this.w = str3;
        this.x = str4;
        this.y = str5;
        this.z = str6;
        this.A = str7;
        this.B = str8;
        this.C = j2;
        this.D = str9;
        this.E = vastAdsRequest;
        if (TextUtils.isEmpty(str6)) {
            this.F = new JSONObject();
            return;
        }
        try {
            this.F = new JSONObject(str6);
        } catch (JSONException e) {
            Log.w("AdBreakClipInfo", "Error creating AdBreakClipInfo: " + e.getMessage());
            this.z = null;
            this.F = new JSONObject();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdBreakClipInfo)) {
            return false;
        }
        AdBreakClipInfo adBreakClipInfo = (AdBreakClipInfo) obj;
        return AbstractC0700gL2.a(this.t, adBreakClipInfo.t) && AbstractC0700gL2.a(this.u, adBreakClipInfo.u) && this.v == adBreakClipInfo.v && AbstractC0700gL2.a(this.w, adBreakClipInfo.w) && AbstractC0700gL2.a(this.x, adBreakClipInfo.x) && AbstractC0700gL2.a(this.y, adBreakClipInfo.y) && AbstractC0700gL2.a(this.z, adBreakClipInfo.z) && AbstractC0700gL2.a(this.A, adBreakClipInfo.A) && AbstractC0700gL2.a(this.B, adBreakClipInfo.B) && this.C == adBreakClipInfo.C && AbstractC0700gL2.a(this.D, adBreakClipInfo.D) && AbstractC0700gL2.a(this.E, adBreakClipInfo.E);
    }

    public final int hashCode() {
        return Objects.hashCode(this.t, this.u, Long.valueOf(this.v), this.w, this.x, this.y, this.z, this.A, this.B, Long.valueOf(this.C), this.D, this.E);
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.t);
            jSONObject.put("duration", this.v / 1000.0d);
            long j = this.C;
            if (j != -1) {
                jSONObject.put("whenSkippable", j / 1000.0d);
            }
            String str = this.A;
            if (str != null) {
                jSONObject.put("contentId", str);
            }
            String str2 = this.x;
            if (str2 != null) {
                jSONObject.put("contentType", str2);
            }
            String str3 = this.u;
            if (str3 != null) {
                jSONObject.put("title", str3);
            }
            String str4 = this.w;
            if (str4 != null) {
                jSONObject.put("contentUrl", str4);
            }
            String str5 = this.y;
            if (str5 != null) {
                jSONObject.put("clickThroughUrl", str5);
            }
            JSONObject jSONObject2 = this.F;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
            String str6 = this.B;
            if (str6 != null) {
                jSONObject.put("posterUrl", str6);
            }
            String str7 = this.D;
            if (str7 != null) {
                jSONObject.put("hlsSegmentFormat", str7);
            }
            VastAdsRequest vastAdsRequest = this.E;
            if (vastAdsRequest != null) {
                jSONObject.put("vastAdsRequest", vastAdsRequest.toJson());
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
        SafeParcelWriter.writeLong(parcel, 4, this.v);
        SafeParcelWriter.writeString(parcel, 5, this.w, false);
        SafeParcelWriter.writeString(parcel, 6, this.x, false);
        SafeParcelWriter.writeString(parcel, 7, this.y, false);
        SafeParcelWriter.writeString(parcel, 8, this.z, false);
        SafeParcelWriter.writeString(parcel, 9, this.A, false);
        SafeParcelWriter.writeString(parcel, 10, this.B, false);
        SafeParcelWriter.writeLong(parcel, 11, this.C);
        SafeParcelWriter.writeString(parcel, 12, this.D, false);
        SafeParcelWriter.writeParcelable(parcel, 13, this.E, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
