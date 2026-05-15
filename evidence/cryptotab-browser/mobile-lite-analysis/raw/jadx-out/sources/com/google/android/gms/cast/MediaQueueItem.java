package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.JsonUtils;
import defpackage.AE2;
import defpackage.AbstractC0700gL2;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "MediaQueueItemCreator")
@SafeParcelable.Reserved({1})
public class MediaQueueItem extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new AE2();
    public String A;
    public JSONObject B;
    public MediaInfo t;
    public int u;
    public boolean v;
    public double w;
    public double x;
    public double y;
    public long[] z;

    public MediaQueueItem(MediaInfo mediaInfo, int i, boolean z, double d, double d2, double d3, long[] jArr, String str) {
        this.t = mediaInfo;
        this.u = i;
        this.v = z;
        this.w = d;
        this.x = d2;
        this.y = d3;
        this.z = jArr;
        this.A = str;
        if (str == null) {
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
        if (!(obj instanceof MediaQueueItem)) {
            return false;
        }
        MediaQueueItem mediaQueueItem = (MediaQueueItem) obj;
        JSONObject jSONObject = this.B;
        boolean z = jSONObject == null;
        JSONObject jSONObject2 = mediaQueueItem.B;
        if (z != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || JsonUtils.areJsonValuesEquivalent(jSONObject, jSONObject2)) && AbstractC0700gL2.a(this.t, mediaQueueItem.t) && this.u == mediaQueueItem.u && this.v == mediaQueueItem.v && ((Double.isNaN(this.w) && Double.isNaN(mediaQueueItem.w)) || this.w == mediaQueueItem.w) && this.x == mediaQueueItem.x && this.y == mediaQueueItem.y && Arrays.equals(this.z, mediaQueueItem.z);
    }

    public final boolean f2(JSONObject jSONObject) throws JSONException {
        boolean z;
        long[] jArr;
        boolean z2;
        int i;
        boolean z3 = false;
        if (jSONObject.has("media")) {
            this.t = new MediaInfo(jSONObject.getJSONObject("media"));
            z = true;
        } else {
            z = false;
        }
        if (jSONObject.has("itemId") && this.u != (i = jSONObject.getInt("itemId"))) {
            this.u = i;
            z = true;
        }
        if (jSONObject.has("autoplay") && this.v != (z2 = jSONObject.getBoolean("autoplay"))) {
            this.v = z2;
            z = true;
        }
        double dOptDouble = jSONObject.optDouble("startTime");
        if (Double.isNaN(dOptDouble) != Double.isNaN(this.w) || (!Double.isNaN(dOptDouble) && Math.abs(dOptDouble - this.w) > 1.0E-7d)) {
            this.w = dOptDouble;
            z = true;
        }
        if (jSONObject.has("playbackDuration")) {
            double d = jSONObject.getDouble("playbackDuration");
            if (Math.abs(d - this.x) > 1.0E-7d) {
                this.x = d;
                z = true;
            }
        }
        if (jSONObject.has("preloadTime")) {
            double d2 = jSONObject.getDouble("preloadTime");
            if (Math.abs(d2 - this.y) > 1.0E-7d) {
                this.y = d2;
                z = true;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            jArr = new long[length];
            for (int i2 = 0; i2 < length; i2++) {
                jArr[i2] = jSONArray.getLong(i2);
            }
            long[] jArr2 = this.z;
            if (jArr2 == null || jArr2.length != length) {
                z3 = true;
                break;
            }
            for (int i3 = 0; i3 < length; i3++) {
                if (this.z[i3] != jArr[i3]) {
                    z3 = true;
                    break;
                }
            }
        } else {
            jArr = null;
        }
        if (z3) {
            this.z = jArr;
            z = true;
        }
        if (!jSONObject.has("customData")) {
            return z;
        }
        this.B = jSONObject.getJSONObject("customData");
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.t, Integer.valueOf(this.u), Boolean.valueOf(this.v), Double.valueOf(this.w), Double.valueOf(this.x), Double.valueOf(this.y), Integer.valueOf(Arrays.hashCode(this.z)), String.valueOf(this.B));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        JSONObject jSONObject = this.B;
        this.A = jSONObject == null ? null : jSONObject.toString();
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.t, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.u);
        SafeParcelWriter.writeBoolean(parcel, 4, this.v);
        SafeParcelWriter.writeDouble(parcel, 5, this.w);
        SafeParcelWriter.writeDouble(parcel, 6, this.x);
        SafeParcelWriter.writeDouble(parcel, 7, this.y);
        SafeParcelWriter.writeLongArray(parcel, 8, this.z, false);
        SafeParcelWriter.writeString(parcel, 9, this.A, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public MediaQueueItem(JSONObject jSONObject) throws JSONException {
        this(null, 0, true, Double.NaN, Double.POSITIVE_INFINITY, 0.0d, null, null);
        f2(jSONObject);
    }
}
