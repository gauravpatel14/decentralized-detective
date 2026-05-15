package defpackage;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: renamed from: f11, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0615f11 {
    public final Bundle a;

    public C0615f11(Bundle bundle) {
        if (bundle == null) {
            throw new NullPointerException("data");
        }
        this.a = new Bundle(bundle);
    }

    public static boolean j(Bundle bundle) {
        return "1".equals(bundle.getString("gcm.n.e")) || "1".equals(bundle.getString("gcm.n.e".replace("gcm.n.", "gcm.notification.")));
    }

    public static String l(String str) {
        return str.startsWith("gcm.n.") ? str.substring(6) : str;
    }

    public final boolean a(String str) {
        String strH = h(str);
        return "1".equals(strH) || Boolean.parseBoolean(strH);
    }

    public final Integer b(String str) {
        String strH = h(str);
        if (TextUtils.isEmpty(strH)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(strH));
        } catch (NumberFormatException unused) {
            String strL = l(str);
            StringBuilder sb = new StringBuilder(String.valueOf(strL).length() + 38 + String.valueOf(strH).length());
            sb.append("Couldn't parse value of ");
            sb.append(strL);
            sb.append("(");
            sb.append(strH);
            sb.append(") into an int");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    public final JSONArray c(String str) {
        String strH = h(str);
        if (TextUtils.isEmpty(strH)) {
            return null;
        }
        try {
            return new JSONArray(strH);
        } catch (JSONException unused) {
            String strL = l(str);
            StringBuilder sb = new StringBuilder(String.valueOf(strL).length() + 50 + String.valueOf(strH).length());
            sb.append("Malformed JSON for key ");
            sb.append(strL);
            sb.append(": ");
            sb.append(strH);
            sb.append(", falling back to default");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    public final int[] d() {
        JSONArray jSONArrayC = c("gcm.n.light_settings");
        if (jSONArrayC == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (jSONArrayC.length() != 3) {
                throw new JSONException("lightSettings don't have all three fields");
            }
            int color = Color.parseColor(jSONArrayC.optString(0));
            if (color == -16777216) {
                throw new IllegalArgumentException("Transparent color is invalid");
            }
            iArr[0] = color;
            iArr[1] = jSONArrayC.optInt(1);
            iArr[2] = jSONArrayC.optInt(2);
            return iArr;
        } catch (IllegalArgumentException e) {
            String strValueOf = String.valueOf(jSONArrayC);
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(strValueOf.length() + 60 + String.valueOf(message).length());
            sb.append("LightSettings is invalid: ");
            sb.append(strValueOf);
            sb.append(". ");
            sb.append(message);
            sb.append(". Skipping setting LightSettings");
            Log.w("NotificationParams", sb.toString());
            return null;
        } catch (JSONException unused) {
            String strValueOf2 = String.valueOf(jSONArrayC);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 58);
            sb2.append("LightSettings is invalid: ");
            sb2.append(strValueOf2);
            sb2.append(". Skipping setting LightSettings");
            Log.w("NotificationParams", sb2.toString());
            return null;
        }
    }

    public final Object[] e(String str) {
        JSONArray jSONArrayC = c(str.concat("_loc_args"));
        if (jSONArrayC == null) {
            return null;
        }
        int length = jSONArrayC.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = jSONArrayC.optString(i);
        }
        return strArr;
    }

    public final Long f() {
        String strH = h("gcm.n.event_time");
        if (TextUtils.isEmpty(strH)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(strH));
        } catch (NumberFormatException unused) {
            String strL = l("gcm.n.event_time");
            StringBuilder sb = new StringBuilder(String.valueOf(strL).length() + 38 + String.valueOf(strH).length());
            sb.append("Couldn't parse value of ");
            sb.append(strL);
            sb.append("(");
            sb.append(strH);
            sb.append(") into a long");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    public final String g(Resources resources, String str, String str2) {
        String strH = h(str2);
        if (!TextUtils.isEmpty(strH)) {
            return strH;
        }
        String strH2 = h(str2.concat("_loc_key"));
        if (TextUtils.isEmpty(strH2)) {
            return null;
        }
        int identifier = resources.getIdentifier(strH2, "string", str);
        if (identifier == 0) {
            String strL = l(str2.concat("_loc_key"));
            StringBuilder sb = new StringBuilder(String.valueOf(strL).length() + 49 + str2.length());
            sb.append(strL);
            sb.append(" resource not found: ");
            sb.append(str2);
            sb.append(" Default value will be used.");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
        Object[] objArrE = e(str2);
        if (objArrE == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, objArrE);
        } catch (MissingFormatArgumentException e) {
            String strL2 = l(str2);
            String string = Arrays.toString(objArrE);
            StringBuilder sb2 = new StringBuilder(String.valueOf(strL2).length() + 58 + String.valueOf(string).length());
            sb2.append("Missing format argument for ");
            sb2.append(strL2);
            sb2.append(": ");
            sb2.append(string);
            sb2.append(" Default value will be used.");
            Log.w("NotificationParams", sb2.toString(), e);
            return null;
        }
    }

    public final String h(String str) {
        Bundle bundle = this.a;
        if (!bundle.containsKey(str) && str.startsWith("gcm.n.")) {
            String strReplace = !str.startsWith("gcm.n.") ? str : str.replace("gcm.n.", "gcm.notification.");
            if (bundle.containsKey(strReplace)) {
                str = strReplace;
            }
        }
        return bundle.getString(str);
    }

    public final long[] i() {
        JSONArray jSONArrayC = c("gcm.n.vibrate_timings");
        if (jSONArrayC == null) {
            return null;
        }
        try {
            if (jSONArrayC.length() <= 1) {
                throw new JSONException("vibrateTimings have invalid length");
            }
            int length = jSONArrayC.length();
            long[] jArr = new long[length];
            for (int i = 0; i < length; i++) {
                jArr[i] = jSONArrayC.optLong(i);
            }
            return jArr;
        } catch (NumberFormatException | JSONException unused) {
            String strValueOf = String.valueOf(jSONArrayC);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 74);
            sb.append("User defined vibrateTimings is invalid: ");
            sb.append(strValueOf);
            sb.append(". Skipping setting vibrateTimings.");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    public final Bundle k() {
        Bundle bundle = this.a;
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle.keySet()) {
            if (!str.startsWith("google.c.a.") && !str.equals("from")) {
                bundle2.remove(str);
            }
        }
        return bundle2;
    }
}
