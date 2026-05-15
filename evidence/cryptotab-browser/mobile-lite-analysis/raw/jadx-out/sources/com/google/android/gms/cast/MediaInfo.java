package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.JsonUtils;
import defpackage.AbstractC0700gL2;
import defpackage.KD2;
import defpackage.ML2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "MediaInfoCreator")
@SafeParcelable.Reserved({1})
public class MediaInfo extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR = new KD2();
    public String A;
    public ArrayList B;
    public ArrayList C;
    public final String D;
    public final VastAdsRequest E;
    public final long F;
    public final JSONObject G;
    public final String t;
    public int u;
    public String v;
    public final MediaMetadata w;
    public final long x;
    public final ArrayList y;
    public final TextTrackStyle z;

    public MediaInfo(String str, int i, String str2, MediaMetadata mediaMetadata, long j, ArrayList arrayList, TextTrackStyle textTrackStyle, String str3, ArrayList arrayList2, ArrayList arrayList3, String str4, VastAdsRequest vastAdsRequest, long j2) {
        this.t = str;
        this.u = i;
        this.v = str2;
        this.w = mediaMetadata;
        this.x = j;
        this.y = arrayList;
        this.z = textTrackStyle;
        this.A = str3;
        if (str3 != null) {
            try {
                this.G = new JSONObject(this.A);
            } catch (JSONException unused) {
                this.G = null;
                this.A = null;
            }
        } else {
            this.G = null;
        }
        this.B = arrayList2;
        this.C = arrayList3;
        this.D = str4;
        this.E = vastAdsRequest;
        this.F = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) obj;
        JSONObject jSONObject = this.G;
        boolean z = jSONObject == null;
        JSONObject jSONObject2 = mediaInfo.G;
        if (z != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || JsonUtils.areJsonValuesEquivalent(jSONObject, jSONObject2)) && AbstractC0700gL2.a(this.t, mediaInfo.t) && this.u == mediaInfo.u && AbstractC0700gL2.a(this.v, mediaInfo.v) && AbstractC0700gL2.a(this.w, mediaInfo.w) && this.x == mediaInfo.x && AbstractC0700gL2.a(this.y, mediaInfo.y) && AbstractC0700gL2.a(this.z, mediaInfo.z) && AbstractC0700gL2.a(this.B, mediaInfo.B) && AbstractC0700gL2.a(this.C, mediaInfo.C) && AbstractC0700gL2.a(this.D, mediaInfo.D) && AbstractC0700gL2.a(this.E, mediaInfo.E) && this.F == mediaInfo.F;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01ad A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0094 A[LOOP:0: B:5:0x0025->B:29:0x0094, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01a4 A[LOOP:2: B:34:0x00be->B:83:0x01a4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f2(org.json.JSONObject r38) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaInfo.f2(org.json.JSONObject):void");
    }

    public final int hashCode() {
        Integer numValueOf = Integer.valueOf(this.u);
        String str = this.v;
        Long lValueOf = Long.valueOf(this.x);
        String strValueOf = String.valueOf(this.G);
        ArrayList arrayList = this.B;
        ArrayList arrayList2 = this.C;
        Long lValueOf2 = Long.valueOf(this.F);
        return Objects.hashCode(this.t, numValueOf, str, this.w, lValueOf, strValueOf, this.y, this.z, arrayList, arrayList2, this.D, this.E, lValueOf2);
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentId", this.t);
            int i = this.u;
            jSONObject.put("streamType", i != 1 ? i != 2 ? "NONE" : "LIVE" : "BUFFERED");
            String str = this.v;
            if (str != null) {
                jSONObject.put("contentType", str);
            }
            MediaMetadata mediaMetadata = this.w;
            if (mediaMetadata != null) {
                jSONObject.put("metadata", mediaMetadata.toJson());
            }
            long j = this.x;
            if (j <= -1) {
                jSONObject.put("duration", JSONObject.NULL);
            } else {
                jSONObject.put("duration", j / 1000.0d);
            }
            ArrayList arrayList = this.y;
            if (arrayList != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((MediaTrack) it.next()).toJson());
                }
                jSONObject.put("tracks", jSONArray);
            }
            TextTrackStyle textTrackStyle = this.z;
            if (textTrackStyle != null) {
                jSONObject.put("textTrackStyle", textTrackStyle.toJson());
            }
            JSONObject jSONObject2 = this.G;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
            String str2 = this.D;
            if (str2 != null) {
                jSONObject.put("entity", str2);
            }
            if (this.B != null) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator it2 = this.B.iterator();
                while (it2.hasNext()) {
                    jSONArray2.put(((AdBreakInfo) it2.next()).toJson());
                }
                jSONObject.put("breaks", jSONArray2);
            }
            if (this.C != null) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator it3 = this.C.iterator();
                while (it3.hasNext()) {
                    jSONArray3.put(((AdBreakClipInfo) it3.next()).toJson());
                }
                jSONObject.put("breakClips", jSONArray3);
            }
            VastAdsRequest vastAdsRequest = this.E;
            if (vastAdsRequest != null) {
                jSONObject.put("vmapAdsRequest", vastAdsRequest.toJson());
            }
            long j2 = this.F;
            if (j2 != -1) {
                jSONObject.put("startAbsoluteTime", j2 / 1000.0d);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        JSONObject jSONObject = this.G;
        this.A = jSONObject == null ? null : jSONObject.toString();
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.t, false);
        SafeParcelWriter.writeInt(parcel, 3, this.u);
        SafeParcelWriter.writeString(parcel, 4, this.v, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.w, i, false);
        SafeParcelWriter.writeLong(parcel, 6, this.x);
        SafeParcelWriter.writeTypedList(parcel, 7, this.y, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.z, i, false);
        SafeParcelWriter.writeString(parcel, 9, this.A, false);
        ArrayList arrayList = this.B;
        SafeParcelWriter.writeTypedList(parcel, 10, arrayList == null ? null : Collections.unmodifiableList(arrayList), false);
        ArrayList arrayList2 = this.C;
        SafeParcelWriter.writeTypedList(parcel, 11, arrayList2 != null ? Collections.unmodifiableList(arrayList2) : null, false);
        SafeParcelWriter.writeString(parcel, 12, this.D, false);
        SafeParcelWriter.writeParcelable(parcel, 13, this.E, i, false);
        SafeParcelWriter.writeLong(parcel, 14, this.F);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public MediaInfo(JSONObject jSONObject) throws JSONException {
        MediaInfo mediaInfo;
        this(jSONObject.getString("contentId"), -1, null, null, -1L, null, null, null, null, null, null, null, -1L);
        String string = jSONObject.getString("streamType");
        if ("NONE".equals(string)) {
            mediaInfo = this;
            mediaInfo.u = 0;
        } else {
            mediaInfo = this;
            if ("BUFFERED".equals(string)) {
                mediaInfo.u = 1;
            } else if ("LIVE".equals(string)) {
                mediaInfo.u = 2;
            } else {
                mediaInfo.u = -1;
            }
        }
        mediaInfo.v = jSONObject.optString("contentType", null);
        if (jSONObject.has("metadata")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
            MediaMetadata mediaMetadata = new MediaMetadata(jSONObject2.getInt("metadataType"));
            mediaInfo.w = mediaMetadata;
            mediaMetadata.h2(jSONObject2);
        }
        mediaInfo.x = -1L;
        if (jSONObject.has("duration") && !jSONObject.isNull("duration")) {
            double dOptDouble = jSONObject.optDouble("duration", 0.0d);
            if (!Double.isNaN(dOptDouble) && !Double.isInfinite(dOptDouble)) {
                mediaInfo.x = (long) (dOptDouble * 1000.0d);
            }
        }
        if (jSONObject.has("tracks")) {
            mediaInfo.y = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("tracks");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                MediaTrack mediaTrack = new MediaTrack(0L, 0, null, null, null, null, -1, null);
                mediaTrack.t = jSONObject3.getLong("trackId");
                String string2 = jSONObject3.getString("type");
                if ("TEXT".equals(string2)) {
                    mediaTrack.u = 1;
                } else if ("AUDIO".equals(string2)) {
                    mediaTrack.u = 2;
                } else if ("VIDEO".equals(string2)) {
                    mediaTrack.u = 3;
                } else {
                    String strValueOf = String.valueOf(string2);
                    throw new JSONException(strValueOf.length() != 0 ? "invalid type: ".concat(strValueOf) : new String("invalid type: "));
                }
                mediaTrack.v = jSONObject3.optString("trackContentId", null);
                mediaTrack.w = jSONObject3.optString("trackContentType", null);
                mediaTrack.x = jSONObject3.optString("name", null);
                mediaTrack.y = jSONObject3.optString("language", null);
                if (jSONObject3.has("subtype")) {
                    String string3 = jSONObject3.getString("subtype");
                    if ("SUBTITLES".equals(string3)) {
                        mediaTrack.z = 1;
                    } else if ("CAPTIONS".equals(string3)) {
                        mediaTrack.z = 2;
                    } else if ("DESCRIPTIONS".equals(string3)) {
                        mediaTrack.z = 3;
                    } else if ("CHAPTERS".equals(string3)) {
                        mediaTrack.z = 4;
                    } else if ("METADATA".equals(string3)) {
                        mediaTrack.z = 5;
                    } else {
                        mediaTrack.z = -1;
                    }
                } else {
                    mediaTrack.z = 0;
                }
                mediaTrack.B = jSONObject3.optJSONObject("customData");
                mediaInfo.y.add(mediaTrack);
            }
        } else {
            mediaInfo.y = null;
        }
        if (jSONObject.has("textTrackStyle")) {
            JSONObject jSONObject4 = jSONObject.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle = new TextTrackStyle(1.0f, 0, 0, -1, 0, -1, 0, 0, null, -1, -1, null);
            textTrackStyle.t = (float) jSONObject4.optDouble("fontScale", 1.0d);
            textTrackStyle.u = TextTrackStyle.g2(jSONObject4.optString("foregroundColor"));
            textTrackStyle.v = TextTrackStyle.g2(jSONObject4.optString("backgroundColor"));
            if (jSONObject4.has("edgeType")) {
                String string4 = jSONObject4.getString("edgeType");
                if ("NONE".equals(string4)) {
                    textTrackStyle.w = 0;
                } else if ("OUTLINE".equals(string4)) {
                    textTrackStyle.w = 1;
                } else if ("DROP_SHADOW".equals(string4)) {
                    textTrackStyle.w = 2;
                } else if ("RAISED".equals(string4)) {
                    textTrackStyle.w = 3;
                } else if ("DEPRESSED".equals(string4)) {
                    textTrackStyle.w = 4;
                }
            }
            textTrackStyle.x = TextTrackStyle.g2(jSONObject4.optString("edgeColor"));
            if (jSONObject4.has("windowType")) {
                String string5 = jSONObject4.getString("windowType");
                if ("NONE".equals(string5)) {
                    textTrackStyle.y = 0;
                } else if ("NORMAL".equals(string5)) {
                    textTrackStyle.y = 1;
                } else if ("ROUNDED_CORNERS".equals(string5)) {
                    textTrackStyle.y = 2;
                }
            }
            textTrackStyle.z = TextTrackStyle.g2(jSONObject4.optString("windowColor"));
            if (textTrackStyle.y == 2) {
                textTrackStyle.A = jSONObject4.optInt("windowRoundedCornerRadius", 0);
            }
            textTrackStyle.B = jSONObject4.optString("fontFamily", null);
            if (jSONObject4.has("fontGenericFamily")) {
                String string6 = jSONObject4.getString("fontGenericFamily");
                if ("SANS_SERIF".equals(string6)) {
                    textTrackStyle.C = 0;
                } else if ("MONOSPACED_SANS_SERIF".equals(string6)) {
                    textTrackStyle.C = 1;
                } else if ("SERIF".equals(string6)) {
                    textTrackStyle.C = 2;
                } else if ("MONOSPACED_SERIF".equals(string6)) {
                    textTrackStyle.C = 3;
                } else if ("CASUAL".equals(string6)) {
                    textTrackStyle.C = 4;
                } else if ("CURSIVE".equals(string6)) {
                    textTrackStyle.C = 5;
                } else if ("SMALL_CAPITALS".equals(string6)) {
                    textTrackStyle.C = 6;
                }
            }
            if (jSONObject4.has("fontStyle")) {
                String string7 = jSONObject4.getString("fontStyle");
                if ("NORMAL".equals(string7)) {
                    textTrackStyle.D = 0;
                } else if ("BOLD".equals(string7)) {
                    textTrackStyle.D = 1;
                } else if ("ITALIC".equals(string7)) {
                    textTrackStyle.D = 2;
                } else if ("BOLD_ITALIC".equals(string7)) {
                    textTrackStyle.D = 3;
                }
            }
            textTrackStyle.F = jSONObject4.optJSONObject("customData");
            mediaInfo.z = textTrackStyle;
        } else {
            mediaInfo.z = null;
        }
        f2(jSONObject);
        mediaInfo.G = jSONObject.optJSONObject("customData");
        if (jSONObject.has("entity")) {
            mediaInfo.D = jSONObject.getString("entity");
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("vmapAdsRequest");
        mediaInfo.E = jSONObjectOptJSONObject != null ? new VastAdsRequest(jSONObjectOptJSONObject.optString("adTagUrl", null), jSONObjectOptJSONObject.optString("adsResponse", null)) : null;
        if (ML2.b && jSONObject.has("startAbsoluteTime") && !jSONObject.isNull("startAbsoluteTime")) {
            double dOptDouble2 = jSONObject.optDouble("startAbsoluteTime");
            if (Double.isNaN(dOptDouble2) || Double.isInfinite(dOptDouble2) || dOptDouble2 < 0.0d) {
                return;
            }
            mediaInfo.F = (long) (dOptDouble2 * 1000.0d);
        }
    }
}
