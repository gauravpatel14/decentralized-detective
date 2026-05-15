package defpackage;

import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class WD2 extends Lt1 {
    public final /* synthetic */ int[] d;
    public final /* synthetic */ Nt1 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WD2(Nt1 nt1, GoogleApiClient googleApiClient, int[] iArr) {
        super(nt1, googleApiClient, true);
        this.e = nt1;
        this.d = iArr;
    }

    @Override // defpackage.Lt1
    public final void b() {
        UL2 ul2 = this.e.c;
        C0565eF2 c0565eF2 = this.a;
        int[] iArr = this.d;
        ul2.getClass();
        JSONObject jSONObject = new JSONObject();
        long jC = ul2.c();
        try {
            jSONObject.put("requestId", jC);
            jSONObject.put("type", "QUEUE_GET_ITEMS");
            jSONObject.put("mediaSessionId", ul2.l());
            JSONArray jSONArray = new JSONArray();
            for (int i : iArr) {
                jSONArray.put(i);
            }
            jSONObject.put("itemIds", jSONArray);
        } catch (JSONException unused) {
        }
        ul2.a(jC, jSONObject.toString());
        ul2.q.c(jC, c0565eF2);
    }
}
