package defpackage;

import android.os.Bundle;
import android.util.Log;
import com.android.volley.VolleyError;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class P01 {
    public final R01 a;
    public final Q01 b;
    public final HashMap c;

    public P01(R01 r01, Q01 q01, HashMap map) {
        this.a = r01;
        this.b = q01;
        this.c = map;
    }

    public static P01 a(Bundle bundle) {
        Q01 q01;
        R01 r01 = (R01) bundle.getSerializable("notification_event");
        if (r01 == null) {
            return null;
        }
        try {
            q01 = new Q01(new JSONObject(bundle.getString("notification_common_data")));
        } catch (Exception e) {
            e.printStackTrace();
            q01 = null;
        }
        if (q01 == null) {
            return null;
        }
        return new P01(r01, q01, (HashMap) bundle.getSerializable("notification_content"));
    }

    public final void b() {
        try {
            c();
        } catch (Exception e) {
            Log.e("NotificationEvent", "Failed to send", e);
        }
    }

    public final void c() {
        final String str;
        Q01 q01 = this.b;
        if (q01 == null) {
            return;
        }
        R01 r01 = this.a;
        if (r01 == null || (str = q01.a) == null) {
            Log.w("NotificationEvent", "Invalid data");
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event", r01.t);
            JSONObject jSONObject2 = q01.b;
            if (jSONObject2 != null) {
                jSONObject.put("meta", jSONObject2);
            }
            HashMap map = this.c;
            if (map != null) {
                jSONObject.put("data", new JSONObject(map));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("NotificationEvent", "Send to url: " + str + " with params: " + jSONObject);
        hK1 hk1 = new hK1(str, jSONObject, new nv1() { // from class: N01
            @Override // defpackage.nv1
            public final void a(Object obj) {
                Log.i("NotificationEvent", "Received from url: " + str + " with params: " + jSONObject + " response: " + String.valueOf((Void) obj));
            }
        }, new mv1() { // from class: O01
            @Override // defpackage.mv1
            public final void c(VolleyError volleyError) {
                Log.w("NotificationEvent", "Send error to url: " + str, volleyError);
            }
        });
        Qu1 qu1 = Pu1.a;
        F11 f11 = new F11();
        qu1.getClass();
        hk1.D = f11;
        qu1.a.a(hk1);
    }
}
