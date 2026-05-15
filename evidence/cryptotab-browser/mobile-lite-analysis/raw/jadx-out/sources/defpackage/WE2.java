package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.android.billingclient.api.Purchase;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class WE2 implements Callable {
    public final /* synthetic */ String a;
    public final /* synthetic */ InterfaceC0147Mn1 b;
    public final /* synthetic */ tp c;

    public WE2(tp tpVar, String str, InterfaceC0147Mn1 interfaceC0147Mn1) {
        this.a = str;
        this.b = interfaceC0147Mn1;
        this.c = tpVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        C1724xK2 c1724xK2;
        Bundle bundle;
        int i = 1;
        tp tpVar = this.c;
        String str = this.a;
        "Querying owned items, item type: ".concat(str);
        int i2 = AbstractC1659wF2.a;
        ArrayList arrayList = new ArrayList();
        boolean z = tpVar.l;
        boolean z2 = tpVar.r;
        tpVar.u.getClass();
        tpVar.u.getClass();
        Bundle bundleB = AbstractC1659wF2.b(tpVar.b, z, z2);
        ArrayList arrayList2 = null;
        String string = null;
        while (true) {
            int i3 = 9;
            try {
                int i4 = 0;
                if (tpVar.l) {
                    InterfaceC0818i23 interfaceC0818i23 = tpVar.g;
                    int i5 = i != tpVar.r ? 9 : 19;
                    String packageName = tpVar.e.getPackageName();
                    C1304q13 c1304q13 = (C1304q13) interfaceC0818i23;
                    Parcel parcelY0 = c1304q13.Y0();
                    parcelY0.writeInt(i5);
                    parcelY0.writeString(packageName);
                    parcelY0.writeString(str);
                    parcelY0.writeString(string);
                    int i6 = x33.a;
                    parcelY0.writeInt(i);
                    bundleB.writeToParcel(parcelY0, 0);
                    Parcel parcelZ0 = c1304q13.Z0(11, parcelY0);
                    bundle = (Bundle) x33.a(parcelZ0, Bundle.CREATOR);
                    parcelZ0.recycle();
                } else {
                    InterfaceC0818i23 interfaceC0818i232 = tpVar.g;
                    String packageName2 = tpVar.e.getPackageName();
                    C1304q13 c1304q132 = (C1304q13) interfaceC0818i232;
                    Parcel parcelY02 = c1304q132.Y0();
                    parcelY02.writeInt(3);
                    parcelY02.writeString(packageName2);
                    parcelY02.writeString(str);
                    parcelY02.writeString(string);
                    Parcel parcelZ02 = c1304q132.Z0(4, parcelY02);
                    bundle = (Bundle) x33.a(parcelZ02, Bundle.CREATOR);
                    parcelZ02.recycle();
                }
                YK2 yk2A = cL2.a("getPurchase()", bundle);
                Cp cp = yk2A.a;
                if (cp != MI2.h) {
                    tpVar.i(CI2.a(yk2A.b, 9, cp));
                    c1724xK2 = new C1724xK2(cp, arrayList2);
                    break;
                }
                ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                boolean z3 = false;
                while (i4 < stringArrayList2.size()) {
                    String str2 = stringArrayList2.get(i4);
                    String str3 = stringArrayList3.get(i4);
                    "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i4)));
                    int i7 = AbstractC1659wF2.a;
                    try {
                        Purchase purchase = new Purchase(str2, str3);
                        JSONObject jSONObject = purchase.c;
                        if (TextUtils.isEmpty(jSONObject.optString("token", jSONObject.optString("purchaseToken")))) {
                            AbstractC1659wF2.e("BillingClient", "BUG: empty/null token!");
                            z3 = true;
                        }
                        arrayList.add(purchase);
                        i = 1;
                        i4++;
                        i3 = 9;
                    } catch (JSONException e) {
                        AbstractC1659wF2.f("BillingClient", "Got an exception trying to decode the purchase!", e);
                        Cp cp2 = MI2.g;
                        tpVar.i(CI2.a(51, 9, cp2));
                        c1724xK2 = new C1724xK2(cp2, null);
                    }
                }
                int i8 = i3;
                if (z3) {
                    tpVar.i(CI2.a(26, i8, MI2.g));
                }
                string = bundle.getString("INAPP_CONTINUATION_TOKEN");
                "Continuation token: ".concat(String.valueOf(string));
                int i9 = AbstractC1659wF2.a;
                if (TextUtils.isEmpty(string)) {
                    c1724xK2 = new C1724xK2(MI2.h, arrayList);
                    break;
                }
                arrayList2 = null;
            } catch (Exception e2) {
                Cp cp3 = MI2.i;
                tpVar.i(CI2.a(52, 9, cp3));
                AbstractC1659wF2.f("BillingClient", "Got exception trying to get purchasesm try to reconnect", e2);
                c1724xK2 = new C1724xK2(cp3, null);
            }
        }
        ArrayList arrayList3 = c1724xK2.a;
        if (arrayList3 != null) {
            this.b.a(c1724xK2.b, arrayList3);
            return null;
        }
        InterfaceC0147Mn1 interfaceC0147Mn1 = this.b;
        Cp cp4 = c1724xK2.b;
        C0884jD2 c0884jD2 = AD2.u;
        interfaceC0147Mn1.a(cp4, C1196oE2.x);
        return null;
    }
}
