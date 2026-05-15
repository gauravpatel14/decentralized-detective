package defpackage;

import com.google.android.gms.common.images.WebImage;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class OM2 {
    public static final YL2 a = new YL2("MetadataUtils");
    public static final String[] b;
    public static final String c;

    static {
        String[] strArr = {"Z", "+hh", "+hhmm", "+hh:mm"};
        b = strArr;
        String strValueOf = String.valueOf(strArr[0]);
        c = strValueOf.length() != 0 ? "yyyyMMdd'T'HHmmss".concat(strValueOf) : new String("yyyyMMdd'T'HHmmss");
    }

    public static void a(ArrayList arrayList, JSONArray jSONArray) {
        try {
            arrayList.clear();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    arrayList.add(new WebImage(jSONArray.getJSONObject(i)));
                } catch (IllegalArgumentException unused) {
                }
            }
        } catch (JSONException unused2) {
        }
    }

    public static JSONArray b(ArrayList arrayList) {
        if (arrayList == null && arrayList.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put(((WebImage) it.next()).toJson());
        }
        return jSONArray;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Calendar c(java.lang.String r9) {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.OM2.c(java.lang.String):java.util.Calendar");
    }
}
