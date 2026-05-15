package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.util.DefaultClock;
import com.google.firebase.dynamiclinks.internal.DynamicLinkData;

/* JADX INFO: renamed from: We1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0267We1 {
    public final DynamicLinkData a;

    public C0267We1(DynamicLinkData dynamicLinkData) {
        Bundle bundle;
        if (dynamicLinkData.w == 0) {
            dynamicLinkData.w = DefaultClock.getInstance().currentTimeMillis();
        }
        this.a = dynamicLinkData;
        Bundle bundle2 = new Bundle();
        if (dynamicLinkData.x == null) {
            new Bundle();
        }
        Bundle bundle3 = dynamicLinkData.x;
        Bundle bundle4 = (bundle3 == null ? new Bundle() : bundle3).getBundle("scionData");
        if (bundle4 == null || (bundle = bundle4.getBundle("_cmp")) == null) {
            return;
        }
        String string = bundle.getString("medium");
        if (!TextUtils.isEmpty(string)) {
            bundle2.putString("utm_medium", string);
        }
        String string2 = bundle.getString("source");
        if (!TextUtils.isEmpty(string2)) {
            bundle2.putString("utm_source", string2);
        }
        String string3 = bundle.getString("campaign");
        if (TextUtils.isEmpty(string3)) {
            return;
        }
        bundle2.putString("utm_campaign", string3);
    }
}
