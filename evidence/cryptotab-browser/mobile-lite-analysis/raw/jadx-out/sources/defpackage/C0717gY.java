package defpackage;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.net.URLEncoder;
import java.util.concurrent.atomic.AtomicBoolean;
import org.chromium.base.Callback;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: gY, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0717gY {
    public final AtomicBoolean a = new AtomicBoolean();

    public final void a(Context context, Callback callback) {
        String str;
        Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme("https").authority("api.cryptobrowser.site").appendEncodedPath("api/v2").appendEncodedPath("devices/register").appendQueryParameter("app_id", context.getPackageName()).appendQueryParameter("av", "0.0.0");
        Jd jd = lQ.a;
        int i = AbstractC1872zv.a;
        Uri.Builder builderAppendQueryParameter2 = builderAppendQueryParameter.appendQueryParameter("v", "6.2.34").appendQueryParameter("platform", "android");
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            if (!advertisingIdInfo.isLimitAdTrackingEnabled()) {
                builderAppendQueryParameter2.appendQueryParameter("gaid", advertisingIdInfo.getId());
            }
        } catch (Exception e) {
            Log.e("cr_DeviceRegistration", "Append advertising id error", e);
        }
        String string = builderAppendQueryParameter2.build().toString();
        C0029Cc c0029Cc = AbstractC0013Bc.a;
        c0029Cc.getClass();
        try {
            c0029Cc.b.await();
        } catch (InterruptedException e2) {
            Log.e("cr_AppInstanceIdController", "App instance id interruption", e2);
        }
        String str2 = c0029Cc.c;
        W40 w40 = V40.a;
        if (w40.b.get()) {
            try {
                w40.a.await();
            } catch (InterruptedException e3) {
                Log.e("cr_DynamicLinkController", "Dynamic link interruption", e3);
            }
            str = (String) w40.c.get();
        } else {
            str = null;
        }
        C1056lx0 c1056lx0 = kx0.a;
        c1056lx0.getClass();
        try {
            c1056lx0.b.await();
        } catch (InterruptedException e4) {
            Log.e("cr_InstallReferrerController", "Install referrer interruption", e4);
        }
        String str3 = c1056lx0.c;
        String strEncode = "";
        if (!RP1.a(str3)) {
            try {
                strEncode = URLEncoder.encode(str3, "UTF-8");
            } catch (Exception e5) {
                Log.e("cr_UrlSafeEncoder", "Encode error", e5);
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_instance_id", str2);
            jSONObject.put("dl_url", str);
            jSONObject.put("ref", strEncode);
        } catch (JSONException e6) {
            Log.e("cr_DeviceRegistration", "Get request params error", e6);
        }
        C0481cY c0481cY = new C0481cY(this, callback);
        C0481cY c0481cY2 = new C0481cY(this, callback);
        Log.i("cr_DeviceRegistration", "Device registration request params: " + jSONObject);
        Log.i("cr_DeviceRegistration", "Device registration url: " + string);
        eY eYVar = new eY(1, string, jSONObject, c0481cY, c0481cY2);
        eYVar.D = new C0586eW(1.1f, 2500, 5);
        Pu1.a.a(eYVar);
    }
}
