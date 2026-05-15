package defpackage;

import android.util.Log;
import com.android.volley.VolleyError;
import java.util.concurrent.atomic.AtomicBoolean;
import org.chromium.base.Callback;
import org.json.JSONObject;

/* JADX INFO: renamed from: cY, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0481cY implements nv1, mv1 {
    public final /* synthetic */ C0717gY a;
    public final /* synthetic */ Callback b;

    public /* synthetic */ C0481cY(C0717gY c0717gY, Callback callback) {
        this.a = c0717gY;
        this.b = callback;
    }

    @Override // defpackage.nv1
    public void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        C0717gY c0717gY = this.a;
        c0717gY.getClass();
        Log.i("cr_DeviceRegistration", "Device registration result: " + jSONObject);
        AtomicBoolean atomicBoolean = c0717gY.a;
        Callback callback = this.b;
        if (jSONObject == null) {
            atomicBoolean.set(false);
            if (callback != null) {
                callback.a0("");
                return;
            }
            return;
        }
        String strOptString = jSONObject.optString("did", "");
        if (!strOptString.isEmpty()) {
            Sj1.b("bid_pref", strOptString);
        }
        atomicBoolean.set(false);
        if (callback != null) {
            callback.a0(strOptString);
        }
    }

    @Override // defpackage.mv1
    public void c(VolleyError volleyError) {
        C0717gY c0717gY = this.a;
        c0717gY.getClass();
        Log.e("cr_DeviceRegistration", "Device registration error", volleyError);
        c0717gY.a.set(false);
        Callback callback = this.b;
        if (callback != null) {
            callback.a0("");
        }
    }
}
