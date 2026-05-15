package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONException;

/* JADX INFO: renamed from: lE2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CallableC1010lE2 implements Callable {
    public final /* synthetic */ tp a;
    public final /* synthetic */ Ro1 b;
    public final /* synthetic */ InterfaceC0866im1 c;

    public /* synthetic */ CallableC1010lE2(tp tpVar, Ro1 ro1, InterfaceC0866im1 interfaceC0866im1) {
        this.a = tpVar;
        this.b = ro1;
        this.c = interfaceC0866im1;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Object obj;
        String strD;
        int iA;
        int i;
        int i2;
        InterfaceC0818i23 interfaceC0818i23;
        int i3;
        String packageName;
        String str;
        Bundle bundle;
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2;
        AD2 ad2;
        int size;
        int i4;
        boolean z;
        int i5 = 0;
        int i6 = 1;
        tp tpVar = this.a;
        Ro1 ro1 = this.b;
        InterfaceC0866im1 interfaceC0866im1 = this.c;
        tpVar.getClass();
        ArrayList arrayList3 = new ArrayList();
        String str2 = ((Qo1) ro1.a.get(0)).b;
        AD2 ad22 = ro1.a;
        int size2 = ad22.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size2) {
                obj = null;
                strD = "";
                iA = 0;
                break;
            }
            int i8 = i7 + 20;
            ArrayList arrayList4 = new ArrayList(ad22.subList(i7, i8 > size2 ? size2 : i8));
            ArrayList<String> arrayList5 = new ArrayList<>();
            int size3 = arrayList4.size();
            for (int i9 = i5; i9 < size3; i9 += i6) {
                arrayList5.add(((Qo1) arrayList4.get(i9)).a);
            }
            Bundle bundle2 = new Bundle();
            bundle2.putStringArrayList("ITEM_ID_LIST", arrayList5);
            bundle2.putString("playBillingLibraryVersion", tpVar.b);
            try {
                interfaceC0818i23 = tpVar.g;
                i3 = i6 != tpVar.s ? 17 : 20;
                packageName = tpVar.e.getPackageName();
                if (tpVar.r) {
                    tpVar.u.getClass();
                }
                str = tpVar.b;
            } catch (Exception e) {
                e = e;
                i = 6;
                obj = null;
            }
            try {
                if (TextUtils.isEmpty(null)) {
                    tpVar.e.getPackageName();
                }
                if (TextUtils.isEmpty(null)) {
                    tpVar.e.getPackageName();
                }
                if (TextUtils.isEmpty(null)) {
                    tpVar.e.getPackageName();
                }
                bundle = new Bundle();
                bundle.putString("playBillingLibraryVersion", str);
                bundle.putBoolean("enablePendingPurchases", true);
                bundle.putString("SKU_DETAILS_RESPONSE_FORMAT", "PRODUCT_DETAILS");
                arrayList = new ArrayList<>();
                arrayList2 = new ArrayList<>();
                ad2 = ad22;
                size = arrayList4.size();
                i4 = 0;
                z = false;
            } catch (Exception e2) {
                e = e2;
                obj = null;
                i = 6;
                i2 = 7;
            }
            while (i4 < size) {
                int i10 = size;
                Qo1 qo1 = (Qo1) arrayList4.get(i4);
                int i11 = size2;
                arrayList.add(null);
                z |= !TextUtils.isEmpty(null);
                if (qo1.b.equals("first_party")) {
                    throw new NullPointerException("Serialized DocId is required for constructing ExtraParams to query ProductDetails for all first party products.");
                }
                i4++;
                size2 = i11;
                size = i10;
                i2 = 7;
                AbstractC1659wF2.f("BillingClient", "queryProductDetailsAsync got a remote exception (try to reconnect).", e);
                tpVar.i(CI2.a(43, i2, MI2.g));
                strD = "An internal error occurred.";
                iA = i;
            }
            int i12 = size2;
            if (z) {
                bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList);
            }
            if (!arrayList2.isEmpty()) {
                bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList2);
            }
            i2 = 7;
            obj = null;
            try {
                Bundle bundleX0 = ((C1304q13) interfaceC0818i23).X0(i3, packageName, str2, bundle2, bundle);
                strD = "Item is unavailable for purchase.";
                if (bundleX0 == null) {
                    AbstractC1659wF2.e("BillingClient", "queryProductDetailsAsync got empty product details response.");
                    tpVar.i(CI2.a(44, 7, MI2.p));
                    break;
                }
                if (bundleX0.containsKey("DETAILS_LIST")) {
                    ArrayList<String> stringArrayList = bundleX0.getStringArrayList("DETAILS_LIST");
                    if (stringArrayList == null) {
                        AbstractC1659wF2.e("BillingClient", "queryProductDetailsAsync got null response list");
                        tpVar.i(CI2.a(46, 7, MI2.p));
                        break;
                    }
                    for (int i13 = 0; i13 < stringArrayList.size(); i13++) {
                        try {
                            C0801hm1 c0801hm1 = new C0801hm1(stringArrayList.get(i13));
                            "Got product details: ".concat(c0801hm1.toString());
                            int i14 = AbstractC1659wF2.a;
                            arrayList3.add(c0801hm1);
                        } catch (JSONException e3) {
                            AbstractC1659wF2.f("BillingClient", "Got a JSON exception trying to decode ProductDetails. \n Exception: ", e3);
                            strD = "Error trying to decode SkuDetails.";
                            i = 6;
                            tpVar.i(CI2.a(47, 7, MI2.a(6, "Error trying to decode SkuDetails.")));
                        }
                    }
                    size2 = i12;
                    i7 = i8;
                    ad22 = ad2;
                    i5 = 0;
                    i6 = 1;
                } else {
                    iA = AbstractC1659wF2.a("BillingClient", bundleX0);
                    strD = AbstractC1659wF2.d("BillingClient", bundleX0);
                    if (iA != 0) {
                        AbstractC1659wF2.e("BillingClient", "getSkuDetails() failed for queryProductDetailsAsync. Response code: " + iA);
                        tpVar.i(CI2.a(23, 7, MI2.a(iA, strD)));
                    } else {
                        AbstractC1659wF2.e("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.");
                        tpVar.i(CI2.a(45, 7, MI2.a(6, strD)));
                        iA = 6;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                i = 6;
                AbstractC1659wF2.f("BillingClient", "queryProductDetailsAsync got a remote exception (try to reconnect).", e);
                tpVar.i(CI2.a(43, i2, MI2.g));
                strD = "An internal error occurred.";
            }
        }
        iA = 4;
        interfaceC0866im1.b(MI2.a(iA, strD), arrayList3);
        return obj;
    }
}
