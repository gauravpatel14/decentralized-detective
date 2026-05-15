package defpackage;

import org.json.JSONObject;

/* JADX INFO: renamed from: em1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0602em1 {
    public final String a;
    public final long b;
    public final String c;
    public final String d;
    public final int e;
    public final int f;

    public C0602em1(JSONObject jSONObject) {
        this.d = jSONObject.optString("billingPeriod");
        this.c = jSONObject.optString("priceCurrencyCode");
        this.a = jSONObject.optString("formattedPrice");
        this.b = jSONObject.optLong("priceAmountMicros");
        this.f = jSONObject.optInt("recurrenceMode");
        this.e = jSONObject.optInt("billingCycleCount");
    }
}
