package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: renamed from: Bt2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0021Bt2 {
    public final C1700wt2 a;
    public final ArrayList b;
    public final String c;
    public final String d;
    public final Bundle e;

    public C0021Bt2(C1700wt2 c1700wt2, ArrayList arrayList, String str, String str2, Bundle bundle) {
        this.a = c1700wt2;
        this.b = arrayList;
        this.c = str;
        this.d = str2;
        this.e = bundle;
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        C1700wt2 c1700wt2 = this.a;
        if (c1700wt2 != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("currency", c1700wt2.a);
            bundle2.putString("value", c1700wt2.b);
            bundle.putBundle("total", bundle2);
        }
        ArrayList arrayList = this.b;
        if (arrayList != null && !arrayList.isEmpty()) {
            bundle.putParcelableArray("shippingOptions", C0036Ct2.a(arrayList));
        }
        String str = this.c;
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("error", str);
        }
        String str2 = this.d;
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString("stringifiedPaymentMethodErrors", str2);
        }
        Bundle bundle3 = this.e;
        if (bundle3 != null) {
            bundle.putBundle("addressErrors", bundle3);
        }
        return bundle;
    }
}
