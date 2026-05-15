package defpackage;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BP2 {
    public final String a;
    public final Bundle b;
    public Bundle c;
    public final /* synthetic */ TP2 d;

    public BP2(TP2 tp2) {
        this.d = tp2;
        Preconditions.checkNotEmpty("default_event_parameters");
        this.a = "default_event_parameters";
        this.b = new Bundle();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0098 A[Catch: NumberFormatException | JSONException -> 0x00a0, NumberFormatException | JSONException -> 0x00a0, TRY_LEAVE, TryCatch #1 {NumberFormatException | JSONException -> 0x00a0, blocks: (B:10:0x0027, B:32:0x0071, B:32:0x0071, B:33:0x0080, B:33:0x0080, B:34:0x008c, B:34:0x008c, B:35:0x0098, B:35:0x0098), top: B:49:0x0027, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle a() {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.BP2.a():android.os.Bundle");
    }

    public final void b(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        TP2 tp2 = this.d;
        SharedPreferences.Editor editorEdit = tp2.k().edit();
        int size = bundle.size();
        String str = this.a;
        if (size == 0) {
            editorEdit.remove(str);
        } else {
            JSONArray jSONArray = new JSONArray();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("n", str2);
                        jSONObject.put("v", obj.toString());
                        if (obj instanceof String) {
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("t", "l");
                        } else if (obj instanceof Double) {
                            jSONObject.put("t", "d");
                        } else {
                            WO2 wo2 = tp2.a.i;
                            C1391rR2.k(wo2);
                            wo2.f.b(obj.getClass(), "Cannot serialize bundle value to SharedPreferences. Type");
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        WO2 wo22 = tp2.a.i;
                        C1391rR2.k(wo22);
                        wo22.f.b(e, "Cannot serialize bundle value to SharedPreferences");
                    }
                }
            }
            editorEdit.putString(str, jSONArray.toString());
        }
        editorEdit.apply();
        this.c = bundle;
    }
}
