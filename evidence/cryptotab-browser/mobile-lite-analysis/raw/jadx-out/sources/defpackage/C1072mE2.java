package defpackage;

import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: mE2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1072mE2 extends Lt1 {
    public final /* synthetic */ Nt1 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1072mE2(Nt1 nt1, GoogleApiClient googleApiClient) {
        super(nt1, googleApiClient, false);
        this.d = nt1;
    }

    @Override // defpackage.Lt1
    public final void b() {
        UL2 ul2 = this.d.c;
        C0565eF2 c0565eF2 = this.a;
        ul2.getClass();
        JSONObject jSONObject = new JSONObject();
        long jC = ul2.c();
        try {
            jSONObject.put("requestId", jC);
            jSONObject.put("type", "PLAY");
            jSONObject.put("mediaSessionId", ul2.l());
        } catch (JSONException unused) {
        }
        ul2.a(jC, jSONObject.toString());
        ul2.j.c(jC, c0565eF2);
    }
}
