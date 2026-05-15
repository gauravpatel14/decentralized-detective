package com.google.android.gms.cast;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.JsonUtils;
import defpackage.AbstractC0700gL2;
import defpackage.GH2;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "TextTrackStyleCreator")
@SafeParcelable.Reserved({1})
public final class TextTrackStyle extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new GH2();
    public int A;
    public String B;
    public int C;
    public int D;
    public String E;
    public JSONObject F;
    public float t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public TextTrackStyle(float f, int i, int i2, int i3, int i4, int i5, int i6, int i7, String str, int i8, int i9, String str2) {
        this.t = f;
        this.u = i;
        this.v = i2;
        this.w = i3;
        this.x = i4;
        this.y = i5;
        this.z = i6;
        this.A = i7;
        this.B = str;
        this.C = i8;
        this.D = i9;
        this.E = str2;
        if (str2 == null) {
            this.F = null;
            return;
        }
        try {
            this.F = new JSONObject(this.E);
        } catch (JSONException unused) {
            this.F = null;
            this.E = null;
        }
    }

    public static String f2(int i) {
        return String.format("#%02X%02X%02X%02X", Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Integer.valueOf(Color.alpha(i)));
    }

    public static int g2(String str) {
        if (str != null && str.length() == 9 && str.charAt(0) == '#') {
            try {
                return Color.argb(Integer.parseInt(str.substring(7, 9), 16), Integer.parseInt(str.substring(1, 3), 16), Integer.parseInt(str.substring(3, 5), 16), Integer.parseInt(str.substring(5, 7), 16));
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextTrackStyle)) {
            return false;
        }
        TextTrackStyle textTrackStyle = (TextTrackStyle) obj;
        JSONObject jSONObject = this.F;
        boolean z = jSONObject == null;
        JSONObject jSONObject2 = textTrackStyle.F;
        if (z != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || JsonUtils.areJsonValuesEquivalent(jSONObject, jSONObject2)) && this.t == textTrackStyle.t && this.u == textTrackStyle.u && this.v == textTrackStyle.v && this.w == textTrackStyle.w && this.x == textTrackStyle.x && this.y == textTrackStyle.y && this.A == textTrackStyle.A && AbstractC0700gL2.a(this.B, textTrackStyle.B) && this.C == textTrackStyle.C && this.D == textTrackStyle.D;
    }

    public final int hashCode() {
        return Objects.hashCode(Float.valueOf(this.t), Integer.valueOf(this.u), Integer.valueOf(this.v), Integer.valueOf(this.w), Integer.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.z), Integer.valueOf(this.A), this.B, Integer.valueOf(this.C), Integer.valueOf(this.D), String.valueOf(this.F));
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fontScale", this.t);
            int i = this.u;
            if (i != 0) {
                jSONObject.put("foregroundColor", f2(i));
            }
            int i2 = this.v;
            if (i2 != 0) {
                jSONObject.put("backgroundColor", f2(i2));
            }
            int i3 = this.w;
            if (i3 == 0) {
                jSONObject.put("edgeType", "NONE");
            } else if (i3 == 1) {
                jSONObject.put("edgeType", "OUTLINE");
            } else if (i3 == 2) {
                jSONObject.put("edgeType", "DROP_SHADOW");
            } else if (i3 == 3) {
                jSONObject.put("edgeType", "RAISED");
            } else if (i3 == 4) {
                jSONObject.put("edgeType", "DEPRESSED");
            }
            int i4 = this.x;
            if (i4 != 0) {
                jSONObject.put("edgeColor", f2(i4));
            }
            int i5 = this.y;
            if (i5 == 0) {
                jSONObject.put("windowType", "NONE");
            } else if (i5 == 1) {
                jSONObject.put("windowType", "NORMAL");
            } else if (i5 == 2) {
                jSONObject.put("windowType", "ROUNDED_CORNERS");
            }
            int i6 = this.z;
            if (i6 != 0) {
                jSONObject.put("windowColor", f2(i6));
            }
            if (this.y == 2) {
                jSONObject.put("windowRoundedCornerRadius", this.A);
            }
            String str = this.B;
            if (str != null) {
                jSONObject.put("fontFamily", str);
            }
            switch (this.C) {
                case 0:
                    jSONObject.put("fontGenericFamily", "SANS_SERIF");
                    break;
                case 1:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
                    break;
                case 2:
                    jSONObject.put("fontGenericFamily", "SERIF");
                    break;
                case 3:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SERIF");
                    break;
                case 4:
                    jSONObject.put("fontGenericFamily", "CASUAL");
                    break;
                case 5:
                    jSONObject.put("fontGenericFamily", "CURSIVE");
                    break;
                case 6:
                    jSONObject.put("fontGenericFamily", "SMALL_CAPITALS");
                    break;
            }
            int i7 = this.D;
            if (i7 == 0) {
                jSONObject.put("fontStyle", "NORMAL");
            } else if (i7 == 1) {
                jSONObject.put("fontStyle", "BOLD");
            } else if (i7 == 2) {
                jSONObject.put("fontStyle", "ITALIC");
            } else if (i7 == 3) {
                jSONObject.put("fontStyle", "BOLD_ITALIC");
            }
            JSONObject jSONObject2 = this.F;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        JSONObject jSONObject = this.F;
        this.E = jSONObject == null ? null : jSONObject.toString();
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloat(parcel, 2, this.t);
        SafeParcelWriter.writeInt(parcel, 3, this.u);
        SafeParcelWriter.writeInt(parcel, 4, this.v);
        SafeParcelWriter.writeInt(parcel, 5, this.w);
        SafeParcelWriter.writeInt(parcel, 6, this.x);
        SafeParcelWriter.writeInt(parcel, 7, this.y);
        SafeParcelWriter.writeInt(parcel, 8, this.z);
        SafeParcelWriter.writeInt(parcel, 9, this.A);
        SafeParcelWriter.writeString(parcel, 10, this.B, false);
        SafeParcelWriter.writeInt(parcel, 11, this.C);
        SafeParcelWriter.writeInt(parcel, 12, this.D);
        SafeParcelWriter.writeString(parcel, 13, this.E, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
