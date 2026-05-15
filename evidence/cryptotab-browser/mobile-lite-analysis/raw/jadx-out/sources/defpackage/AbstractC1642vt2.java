package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: vt2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1642vt2 {
    public static void a(String str, String str2, byte[][] bArr, HashMap map, Bundle bundle) {
        Parcelable[] parcelableArr;
        c(str, "schemelessOrigin");
        bundle.putString("topLevelOrigin", str);
        c(str2, "schemelessIframeOrigin");
        bundle.putString("paymentRequestOrigin", str2);
        if (bArr == null || bArr.length <= 0) {
            parcelableArr = null;
        } else {
            parcelableArr = new Parcelable[bArr.length];
            for (int i = 0; i < bArr.length; i++) {
                Bundle bundle2 = new Bundle();
                b(bArr[i], "certificateChain[" + i + "]");
                bundle2.putByteArray("certificate", bArr[i]);
                parcelableArr[i] = bundle2;
            }
            bundle.putParcelableArray("topLevelCertificateChain", parcelableArr);
        }
        if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException("methodDataMap should not be null or empty.");
        }
        bundle.putStringArrayList("methodNames", new ArrayList<>(map.keySet()));
        Bundle bundle3 = new Bundle();
        for (Map.Entry entry : map.entrySet()) {
            b(entry.getValue(), "methodDataMap's entry value");
            bundle3.putString((String) entry.getKey(), ((C1871zt2) entry.getValue()).b);
        }
        bundle.putParcelable("methodData", bundle3);
        bundle.putString("origin", str);
        bundle.putString("iframeOrigin", str2);
        if (parcelableArr != null) {
            bundle.putParcelableArray("certificateChain", parcelableArr);
        }
        String str3 = (String) ((Map.Entry) map.entrySet().iterator().next()).getKey();
        bundle.putString("methodName", str3);
        C1871zt2 c1871zt2 = (C1871zt2) map.get(str3);
        bundle.putString("data", c1871zt2 == null ? "{}" : c1871zt2.b);
        bundle.putParcelable("dataMap", bundle3);
    }

    public static void b(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(F.a(str, " should not be null."));
        }
    }

    public static void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2.concat(" should not be null or empty."));
        }
    }
}
