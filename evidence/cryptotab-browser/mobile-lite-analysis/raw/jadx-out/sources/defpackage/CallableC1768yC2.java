package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import com.android.billingclient.api.SkuDetails;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONException;

/* JADX INFO: renamed from: yC2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CallableC1768yC2 implements Callable {
    public final /* synthetic */ tp a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ArrayList c;
    public final /* synthetic */ hL1 d;

    public /* synthetic */ CallableC1768yC2(tp tpVar, String str, ArrayList arrayList, hL1 hl1) {
        this.a = tpVar;
        this.b = str;
        this.c = arrayList;
        this.d = hl1;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String strD;
        int iA;
        int i;
        int i2;
        int i3;
        Bundle bundleX0;
        tp tpVar = this.a;
        String str = this.b;
        ArrayList arrayList = this.c;
        hL1 hl1 = this.d;
        tpVar.getClass();
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                strD = "";
                iA = 0;
                break;
            }
            int i5 = i4 + 20;
            ArrayList<String> arrayList3 = new ArrayList<>(arrayList.subList(i4, i5 > size ? size : i5));
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList3);
            bundle.putString("playBillingLibraryVersion", tpVar.b);
            try {
                if (tpVar.m) {
                    InterfaceC0818i23 interfaceC0818i23 = tpVar.g;
                    String packageName = tpVar.e.getPackageName();
                    int i6 = tpVar.j;
                    tpVar.u.getClass();
                    if (tpVar.r) {
                        tpVar.u.getClass();
                    }
                    String str2 = tpVar.b;
                    Bundle bundle2 = new Bundle();
                    if (i6 >= 9) {
                        bundle2.putString("playBillingLibraryVersion", str2);
                    }
                    if (i6 >= 9) {
                        bundle2.putBoolean("enablePendingPurchases", true);
                    }
                    i = 8;
                    i2 = i5;
                    try {
                        bundleX0 = ((C1304q13) interfaceC0818i23).X0(10, packageName, str, bundle, bundle2);
                        i3 = 0;
                    } catch (Exception e) {
                        e = e;
                        AbstractC1659wF2.f("BillingClient", "querySkuDetailsAsync got a remote exception (try to reconnect).", e);
                        tpVar.i(CI2.a(43, i, MI2.i));
                        strD = "Service connection is disconnected.";
                        iA = -1;
                    }
                } else {
                    i2 = i5;
                    i = 8;
                    InterfaceC0818i23 interfaceC0818i232 = tpVar.g;
                    String packageName2 = tpVar.e.getPackageName();
                    C1304q13 c1304q13 = (C1304q13) interfaceC0818i232;
                    Parcel parcelY0 = c1304q13.Y0();
                    parcelY0.writeInt(3);
                    parcelY0.writeString(packageName2);
                    parcelY0.writeString(str);
                    int i7 = x33.a;
                    parcelY0.writeInt(1);
                    i3 = 0;
                    bundle.writeToParcel(parcelY0, 0);
                    Parcel parcelZ0 = c1304q13.Z0(2, parcelY0);
                    Bundle bundle3 = (Bundle) x33.a(parcelZ0, Bundle.CREATOR);
                    parcelZ0.recycle();
                    bundleX0 = bundle3;
                }
                strD = "Item is unavailable for purchase.";
                if (bundleX0 == null) {
                    AbstractC1659wF2.e("BillingClient", "querySkuDetailsAsync got null sku details list");
                    tpVar.i(CI2.a(44, i, MI2.p));
                    break;
                }
                if (bundleX0.containsKey("DETAILS_LIST")) {
                    ArrayList<String> stringArrayList = bundleX0.getStringArrayList("DETAILS_LIST");
                    if (stringArrayList == null) {
                        AbstractC1659wF2.e("BillingClient", "querySkuDetailsAsync got null response list");
                        tpVar.i(CI2.a(46, i, MI2.p));
                        break;
                    }
                    for (int i8 = i3; i8 < stringArrayList.size(); i8++) {
                        try {
                            SkuDetails skuDetails = new SkuDetails(stringArrayList.get(i8));
                            "Got sku details: ".concat(skuDetails.toString());
                            int i9 = AbstractC1659wF2.a;
                            arrayList2.add(skuDetails);
                        } catch (JSONException e2) {
                            AbstractC1659wF2.f("BillingClient", "Got a JSON exception trying to decode SkuDetails.", e2);
                            strD = "Error trying to decode SkuDetails.";
                            tpVar.i(CI2.a(47, i, MI2.a(6, "Error trying to decode SkuDetails.")));
                            iA = 6;
                        }
                    }
                    i4 = i2;
                } else {
                    iA = AbstractC1659wF2.a("BillingClient", bundleX0);
                    strD = AbstractC1659wF2.d("BillingClient", bundleX0);
                    if (iA != 0) {
                        AbstractC1659wF2.e("BillingClient", "getSkuDetails() failed. Response code: " + iA);
                        tpVar.i(CI2.a(23, i, MI2.a(iA, strD)));
                    } else {
                        AbstractC1659wF2.e("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a detail list.");
                        tpVar.i(CI2.a(45, i, MI2.a(6, strD)));
                        iA = 6;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                i = 8;
            }
        }
        iA = 4;
        arrayList2 = null;
        hl1.a(MI2.a(iA, strD), arrayList2);
        return null;
    }
}
