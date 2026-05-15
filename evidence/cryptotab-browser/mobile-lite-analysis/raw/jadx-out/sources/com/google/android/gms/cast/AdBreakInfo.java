package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.AbstractC0700gL2;
import defpackage.LF2;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "AdBreakInfoCreator")
@SafeParcelable.Reserved({1})
public class AdBreakInfo extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new LF2();
    public final long t;
    public final String u;
    public final long v;
    public final boolean w;
    public final String[] x;
    public final boolean y;

    public AdBreakInfo(long j, String str, long j2, boolean z, String[] strArr, boolean z2) {
        this.t = j;
        this.u = str;
        this.v = j2;
        this.w = z;
        this.x = strArr;
        this.y = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdBreakInfo)) {
            return false;
        }
        AdBreakInfo adBreakInfo = (AdBreakInfo) obj;
        return AbstractC0700gL2.a(this.u, adBreakInfo.u) && this.t == adBreakInfo.t && this.v == adBreakInfo.v && this.w == adBreakInfo.w && Arrays.equals(this.x, adBreakInfo.x) && this.y == adBreakInfo.y;
    }

    public final int hashCode() {
        return this.u.hashCode();
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.u);
            jSONObject.put("position", this.t / 1000.0d);
            jSONObject.put("isWatched", this.w);
            jSONObject.put("isEmbedded", this.y);
            jSONObject.put("duration", this.v / 1000.0d);
            String[] strArr = this.x;
            if (strArr != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : strArr) {
                    jSONArray.put(str);
                }
                jSONObject.put("breakClipIds", jSONArray);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, this.t);
        SafeParcelWriter.writeString(parcel, 3, this.u, false);
        SafeParcelWriter.writeLong(parcel, 4, this.v);
        SafeParcelWriter.writeBoolean(parcel, 5, this.w);
        SafeParcelWriter.writeStringArray(parcel, 6, this.x, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.y);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
