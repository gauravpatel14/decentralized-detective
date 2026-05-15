package com.google.android.gms.common.util;

import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import defpackage.AbstractC1201oI2;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public final class JsonUtils {
    private static final Pattern zza = Pattern.compile("\\\\.");
    private static final Pattern zzb = Pattern.compile("[\\\\\"/\b\f\n\r\t]");

    private JsonUtils() {
    }

    @KeepForSdk
    public static boolean areJsonValuesEquivalent(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if ((obj instanceof JSONObject) && (obj2 instanceof JSONObject)) {
            JSONObject jSONObject = (JSONObject) obj;
            JSONObject jSONObject2 = (JSONObject) obj2;
            if (jSONObject.length() != jSONObject2.length()) {
                return false;
            }
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!jSONObject2.has(next)) {
                    return false;
                }
                try {
                    Preconditions.checkNotNull(next);
                } catch (JSONException unused) {
                }
                if (!areJsonValuesEquivalent(jSONObject.get(next), jSONObject2.get(next))) {
                    return false;
                }
            }
            return true;
        }
        if (!(obj instanceof JSONArray) || !(obj2 instanceof JSONArray)) {
            return obj.equals(obj2);
        }
        JSONArray jSONArray = (JSONArray) obj;
        JSONArray jSONArray2 = (JSONArray) obj2;
        if (jSONArray.length() != jSONArray2.length()) {
            return false;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            if (!areJsonValuesEquivalent(jSONArray.get(i), jSONArray2.get(i))) {
                return false;
            }
        }
        return true;
    }

    @KeepForSdk
    public static String escapeString(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = zzb.matcher(str);
        StringBuffer stringBuffer = null;
        while (matcher.find()) {
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            char cCharAt = matcher.group().charAt(0);
            if (cCharAt == '\f') {
                matcher.appendReplacement(stringBuffer, "\\\\f");
            } else if (cCharAt == '\r') {
                matcher.appendReplacement(stringBuffer, "\\\\r");
            } else if (cCharAt == '\"') {
                matcher.appendReplacement(stringBuffer, "\\\\\\\"");
            } else if (cCharAt == '/') {
                matcher.appendReplacement(stringBuffer, "\\\\/");
            } else if (cCharAt != '\\') {
                switch (cCharAt) {
                    case '\b':
                        matcher.appendReplacement(stringBuffer, "\\\\b");
                        break;
                    case ConnectionResult.SERVICE_INVALID /* 9 */:
                        matcher.appendReplacement(stringBuffer, "\\\\t");
                        break;
                    case '\n':
                        matcher.appendReplacement(stringBuffer, "\\\\n");
                        break;
                }
            } else {
                matcher.appendReplacement(stringBuffer, "\\\\\\\\");
            }
        }
        if (stringBuffer == null) {
            return str;
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    @KeepForSdk
    public static String unescapeString(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Pattern pattern = AbstractC1201oI2.a;
        StringBuffer stringBuffer = null;
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = AbstractC1201oI2.a.matcher(str);
            int iEnd = 0;
            StringBuilder sb = null;
            while (matcher.find()) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                int iStart = matcher.start();
                int i = iStart;
                while (i >= 0 && str.charAt(i) == '\\') {
                    i--;
                }
                if ((iStart - i) % 2 != 0) {
                    int i2 = Integer.parseInt(matcher.group().substring(2), 16);
                    sb.append((CharSequence) str, iEnd, matcher.start());
                    if (i2 == 92) {
                        sb.append("\\\\");
                    } else {
                        sb.append(Character.toChars(i2));
                    }
                    iEnd = matcher.end();
                }
            }
            if (sb != null) {
                if (iEnd < matcher.regionEnd()) {
                    sb.append((CharSequence) str, iEnd, matcher.regionEnd());
                }
                str = sb.toString();
            }
        }
        Matcher matcher2 = zza.matcher(str);
        while (matcher2.find()) {
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            char cCharAt = matcher2.group().charAt(1);
            if (cCharAt == '\"') {
                matcher2.appendReplacement(stringBuffer, "\"");
            } else if (cCharAt == '/') {
                matcher2.appendReplacement(stringBuffer, "/");
            } else if (cCharAt == '\\') {
                matcher2.appendReplacement(stringBuffer, "\\\\");
            } else if (cCharAt == 'b') {
                matcher2.appendReplacement(stringBuffer, "\b");
            } else if (cCharAt == 'f') {
                matcher2.appendReplacement(stringBuffer, "\f");
            } else if (cCharAt == 'n') {
                matcher2.appendReplacement(stringBuffer, "\n");
            } else if (cCharAt == 'r') {
                matcher2.appendReplacement(stringBuffer, "\r");
            } else {
                if (cCharAt != 't') {
                    throw new IllegalStateException("Found an escaped character that should never be.");
                }
                matcher2.appendReplacement(stringBuffer, "\t");
            }
        }
        if (stringBuffer == null) {
            return str;
        }
        matcher2.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
