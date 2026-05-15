package defpackage;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class dm1 {
    public final String a;
    public final long b;
    public final String c;
    public final String d;

    public dm1(JSONObject jSONObject) throws JSONException {
        this.a = jSONObject.optString("formattedPrice");
        this.b = jSONObject.optLong("priceAmountMicros");
        this.c = jSONObject.optString("priceCurrencyCode");
        String strOptString = jSONObject.optString("offerIdToken");
        this.d = true == strOptString.isEmpty() ? null : strOptString;
        jSONObject.optString("offerId").getClass();
        jSONObject.optString("purchaseOptionId").getClass();
        jSONObject.optInt("offerType");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("offerTags");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add(jSONArrayOptJSONArray.getString(i));
            }
        }
        AD2.u(arrayList);
        if (jSONObject.has("fullPriceMicros")) {
            jSONObject.optLong("fullPriceMicros");
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("discountDisplayInfo");
        if (jSONObjectOptJSONObject != null) {
            jSONObjectOptJSONObject.getInt("percentageDiscount");
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("validTimeWindow");
        if (jSONObjectOptJSONObject2 != null) {
            jSONObjectOptJSONObject2.getLong("startTimeMillis");
            jSONObjectOptJSONObject2.getLong("endTimeMillis");
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("limitedQuantityInfo");
        if (jSONObjectOptJSONObject3 != null) {
            jSONObjectOptJSONObject3.getInt("maximumQuantity");
            jSONObjectOptJSONObject3.getInt("remainingQuantity");
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("preorderDetails");
        if (jSONObjectOptJSONObject4 != null) {
            jSONObjectOptJSONObject4.getLong("preorderReleaseTimeMillis");
            jSONObjectOptJSONObject4.getLong("preorderPresaleEndTimeMillis");
        }
        JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("rentalDetails");
        if (jSONObjectOptJSONObject5 == null) {
            return;
        }
        jSONObjectOptJSONObject5.getString("rentalPeriod");
        jSONObjectOptJSONObject5.optString("rentalExpirationPeriod").getClass();
    }
}
