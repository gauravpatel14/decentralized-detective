package defpackage;

import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class GE2 extends Lt1 {
    public final /* synthetic */ C1387rP0 d;
    public final /* synthetic */ Nt1 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GE2(Nt1 nt1, GoogleApiClient googleApiClient, C1387rP0 c1387rP0) {
        super(nt1, googleApiClient, false);
        this.e = nt1;
        this.d = c1387rP0;
    }

    @Override // defpackage.Lt1
    public final void b() {
        UL2 ul2 = this.e.c;
        C0565eF2 c0565eF2 = this.a;
        ul2.getClass();
        JSONObject jSONObject = new JSONObject();
        long jC = ul2.c();
        long j = this.d.a;
        try {
            jSONObject.put("requestId", jC);
            jSONObject.put("type", "SEEK");
            jSONObject.put("mediaSessionId", ul2.l());
            jSONObject.put("currentTime", j / 1000.0d);
        } catch (JSONException unused) {
        }
        ul2.a(jC, jSONObject.toString());
        ul2.f = Long.valueOf(j);
        ul2.k.c(jC, new C0635fM2(ul2, c0565eF2));
    }
}
