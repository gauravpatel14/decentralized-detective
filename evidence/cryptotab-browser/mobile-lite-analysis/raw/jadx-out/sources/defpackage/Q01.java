package defpackage;

import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Q01 {
    public final String a;
    public final JSONObject b;

    public Q01(gf gfVar) {
        this.a = (String) gfVar.get("event_url");
        String str = (String) gfVar.get("meta");
        this.b = str != null ? new JSONObject(str) : null;
    }

    public Q01(JSONObject jSONObject) {
        this.a = jSONObject.getString("event_url");
        this.b = jSONObject.optJSONObject("meta");
    }
}
