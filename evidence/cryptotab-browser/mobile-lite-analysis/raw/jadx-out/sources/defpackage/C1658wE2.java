package defpackage;

import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: wE2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1658wE2 extends Lt1 {
    public final /* synthetic */ double d;
    public final /* synthetic */ Nt1 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1658wE2(Nt1 nt1, GoogleApiClient googleApiClient, double d) {
        super(nt1, googleApiClient, false);
        this.e = nt1;
        this.d = d;
    }

    @Override // defpackage.Lt1
    public final void b() {
        Nt1 nt1 = this.e;
        C0565eF2 c0565eF2 = this.a;
        UL2 ul2 = nt1.c;
        ul2.getClass();
        double d = this.d;
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Volume cannot be ");
            sb.append(d);
            throw new IllegalArgumentException(sb.toString());
        }
        JSONObject jSONObject = new JSONObject();
        long jC = ul2.c();
        try {
            jSONObject.put("requestId", jC);
            jSONObject.put("type", "SET_VOLUME");
            jSONObject.put("mediaSessionId", ul2.l());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("level", d);
            jSONObject.put("volume", jSONObject2);
        } catch (JSONException unused) {
        }
        ul2.a(jC, jSONObject.toString());
        ul2.l.c(jC, c0565eF2);
    }
}
