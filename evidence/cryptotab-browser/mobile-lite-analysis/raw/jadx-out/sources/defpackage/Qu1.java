package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;
import com.android.volley.VolleyError;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Qu1 {
    public Lu1 a;
    public C0673ft0 b;

    public final void a(rB0 rb0) {
        rb0.D = new C0586eW(2.0f, 25000, 3);
        this.a.a(rb0);
    }

    public final void b(final String str) {
        Log.i("RequestSingleton", "Try send registration token: " + str);
        Context context = AbstractC1499tM.a;
        if (context == null) {
            return;
        }
        String strA = Sj1.a("bid_pref", "");
        if (strA.isEmpty()) {
            return;
        }
        SharedPreferences sharedPreferences = AbstractC1440sM.a;
        if (sharedPreferences.getString("firebase_token_value", "undefined").equals(str)) {
            long j = sharedPreferences.getLong("firebase_token_time", 0L);
            if (j != 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis >= j && jCurrentTimeMillis < j + 86400000) {
                    return;
                }
            }
        }
        Log.i("RequestSingleton", "Send registration token: " + str);
        Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme("https").authority("api.cryptobrowser.site").appendEncodedPath("api/v2").appendEncodedPath("fcm/register").appendQueryParameter("app_id", context.getPackageName()).appendQueryParameter("av", "0.0.0");
        Jd jd = lQ.a;
        int i = AbstractC1872zv.a;
        final String string = builderAppendQueryParameter.appendQueryParameter("v", "6.2.34").appendQueryParameter("bid", strA).build().toString();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("token", str);
            jSONObject.put("device_type", "android");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        a(new hK1(string, jSONObject, new nv1() { // from class: Mu1
            @Override // defpackage.nv1
            public final void a(Object obj) {
                Log.i("RequestSingleton", "Token registered with url: " + string);
                AbstractC1440sM.a.edit().putLong("firebase_token_time", System.currentTimeMillis()).putString("firebase_token_value", str).apply();
            }
        }, new mv1() { // from class: Nu1
            @Override // defpackage.mv1
            public final void c(VolleyError volleyError) {
                Log.e("RequestSingleton", "Register token error with url: " + string, volleyError);
            }
        }));
    }
}
