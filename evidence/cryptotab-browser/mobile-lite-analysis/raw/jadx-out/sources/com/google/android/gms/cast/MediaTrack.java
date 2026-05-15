package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.JsonUtils;
import defpackage.AbstractC0700gL2;
import defpackage.ME2;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "MediaTrackCreator")
@SafeParcelable.Reserved({1})
public final class MediaTrack extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR = new ME2();
    public String A;
    public JSONObject B;
    public long t;
    public int u;
    public String v;
    public String w;
    public String x;
    public String y;
    public int z;

    public MediaTrack(long j, int i, String str, String str2, String str3, String str4, int i2, String str5) {
        this.t = j;
        this.u = i;
        this.v = str;
        this.w = str2;
        this.x = str3;
        this.y = str4;
        this.z = i2;
        this.A = str5;
        if (str5 == null) {
            this.B = null;
            return;
        }
        try {
            this.B = new JSONObject(this.A);
        } catch (JSONException unused) {
            this.B = null;
            this.A = null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaTrack)) {
            return false;
        }
        MediaTrack mediaTrack = (MediaTrack) obj;
        JSONObject jSONObject = this.B;
        boolean z = jSONObject == null;
        JSONObject jSONObject2 = mediaTrack.B;
        if (z != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || JsonUtils.areJsonValuesEquivalent(jSONObject, jSONObject2)) && this.t == mediaTrack.t && this.u == mediaTrack.u && AbstractC0700gL2.a(this.v, mediaTrack.v) && AbstractC0700gL2.a(this.w, mediaTrack.w) && AbstractC0700gL2.a(this.x, mediaTrack.x) && AbstractC0700gL2.a(this.y, mediaTrack.y) && this.z == mediaTrack.z;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.t), Integer.valueOf(this.u), this.v, this.w, this.x, this.y, Integer.valueOf(this.z), String.valueOf(this.B));
    }

    public final JSONObject toJson() {
        String str = this.y;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackId", this.t);
            int i = this.u;
            if (i == 1) {
                jSONObject.put("type", "TEXT");
            } else if (i == 2) {
                jSONObject.put("type", "AUDIO");
            } else if (i == 3) {
                jSONObject.put("type", "VIDEO");
            }
            String str2 = this.v;
            if (str2 != null) {
                jSONObject.put("trackContentId", str2);
            }
            String str3 = this.w;
            if (str3 != null) {
                jSONObject.put("trackContentType", str3);
            }
            String str4 = this.x;
            if (str4 != null) {
                jSONObject.put("name", str4);
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("language", str);
            }
            int i2 = this.z;
            if (i2 == 1) {
                jSONObject.put("subtype", "SUBTITLES");
            } else if (i2 == 2) {
                jSONObject.put("subtype", "CAPTIONS");
            } else if (i2 == 3) {
                jSONObject.put("subtype", "DESCRIPTIONS");
            } else if (i2 == 4) {
                jSONObject.put("subtype", "CHAPTERS");
            } else if (i2 == 5) {
                jSONObject.put("subtype", "METADATA");
            }
            JSONObject jSONObject2 = this.B;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        JSONObject jSONObject = this.B;
        this.A = jSONObject == null ? null : jSONObject.toString();
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, this.t);
        SafeParcelWriter.writeInt(parcel, 3, this.u);
        SafeParcelWriter.writeString(parcel, 4, this.v, false);
        SafeParcelWriter.writeString(parcel, 5, this.w, false);
        SafeParcelWriter.writeString(parcel, 6, this.x, false);
        SafeParcelWriter.writeString(parcel, 7, this.y, false);
        SafeParcelWriter.writeInt(parcel, 8, this.z);
        SafeParcelWriter.writeString(parcel, 9, this.A, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
