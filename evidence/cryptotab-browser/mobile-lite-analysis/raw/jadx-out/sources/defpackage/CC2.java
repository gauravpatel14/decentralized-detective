package defpackage;

import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class CC2 extends Lt1 {
    public final /* synthetic */ C1779yN0 d;
    public final /* synthetic */ Nt1 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CC2(Nt1 nt1, GoogleApiClient googleApiClient, C1779yN0 c1779yN0) {
        super(nt1, googleApiClient, false);
        this.e = nt1;
        this.d = c1779yN0;
    }

    @Override // defpackage.Lt1
    public final void b() {
        Nt1 nt1 = this.e;
        C0565eF2 c0565eF2 = this.a;
        UL2 ul2 = nt1.c;
        ul2.getClass();
        C1779yN0 c1779yN0 = this.d;
        if (c1779yN0.a == null) {
            throw new IllegalArgumentException("MediaInfo and MediaQueueData should not be both null");
        }
        JSONObject jSONObject = new JSONObject();
        long jC = ul2.c();
        try {
            jSONObject.put("requestId", jC);
            jSONObject.put("type", "LOAD");
            MediaInfo mediaInfo = c1779yN0.a;
            if (mediaInfo != null) {
                jSONObject.put("media", mediaInfo.toJson());
            }
            Boolean bool = c1779yN0.b;
            if (bool != null) {
                jSONObject.put("autoplay", bool);
            }
            long j = c1779yN0.c;
            if (j != -1) {
                jSONObject.put("currentTime", j / 1000.0d);
            }
            jSONObject.put("playbackRate", c1779yN0.d);
        } catch (JSONException unused) {
        }
        ul2.a(jC, jSONObject.toString());
        ul2.h.c(jC, c0565eF2);
    }
}
