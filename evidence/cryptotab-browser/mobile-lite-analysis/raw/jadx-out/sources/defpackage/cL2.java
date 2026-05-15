package defpackage;

import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cL2 {
    public static YK2 a(String str, Bundle bundle) {
        Cp cp = MI2.g;
        if (bundle == null) {
            AbstractC1659wF2.e("BillingClient", str.concat(" got null owned items list"));
            return new YK2(cp, 54);
        }
        int iA = AbstractC1659wF2.a("BillingClient", bundle);
        String strD = AbstractC1659wF2.d("BillingClient", bundle);
        Bp bpA = Cp.a();
        bpA.a = iA;
        bpA.b = strD;
        Cp cpA = bpA.a();
        if (iA != 0) {
            AbstractC1659wF2.e("BillingClient", str + " failed. Response code: " + iA);
            return new YK2(cpA, 23);
        }
        if (!bundle.containsKey("INAPP_PURCHASE_ITEM_LIST") || !bundle.containsKey("INAPP_PURCHASE_DATA_LIST") || !bundle.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
            AbstractC1659wF2.e("BillingClient", "Bundle returned from " + str + " doesn't contain required fields.");
            return new YK2(cp, 55);
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList<String> stringArrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        if (stringArrayList == null) {
            AbstractC1659wF2.e("BillingClient", "Bundle returned from " + str + " contains null SKUs list.");
            return new YK2(cp, 56);
        }
        if (stringArrayList2 == null) {
            AbstractC1659wF2.e("BillingClient", "Bundle returned from " + str + " contains null purchases list.");
            return new YK2(cp, 57);
        }
        if (stringArrayList3 != null) {
            return new YK2(MI2.h, 1);
        }
        AbstractC1659wF2.e("BillingClient", "Bundle returned from " + str + " contains null signatures list.");
        return new YK2(cp, 58);
    }
}
