package defpackage;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class DU2 implements Runnable {
    public final /* synthetic */ boolean t;
    public final /* synthetic */ Uri u;
    public final /* synthetic */ String v;
    public final /* synthetic */ String w;
    public final /* synthetic */ GU2 x;

    public DU2(GU2 gu2, boolean z, Uri uri, String str, String str2) {
        this.x = gu2;
        this.t = z;
        this.u = uri;
        this.v = str;
        this.w = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundleG0;
        CharSequence charSequence;
        Uri uri = this.u;
        String str = this.w;
        IU2 iu2 = this.x.t;
        C1391rR2 c1391rR2 = iu2.a;
        iu2.g();
        try {
            C0653fY2 c0653fY2 = c1391rR2.l;
            C1391rR2.i(c0653fY2);
            BZ2 bz2 = BZ2.u;
            bz2.zza().getClass();
            C1009lD2 c1009lD2 = c1391rR2.g;
            C0467cO2 c0467cO2 = AbstractC0579eO2.q0;
            boolean zP = c1009lD2.p(null, c0467cO2);
            bz2.zza().getClass();
            C1009lD2 c1009lD22 = c1391rR2.g;
            C0467cO2 c0467cO22 = AbstractC0579eO2.r0;
            boolean zP2 = c1009lD22.p(null, c0467cO22);
            if (TextUtils.isEmpty(str)) {
                bundleG0 = null;
            } else {
                if (!str.contains("gclid") && !str.contains("utm_campaign") && !str.contains("utm_source") && !str.contains("utm_medium") && (!zP || (!str.contains("utm_id") && !str.contains("dclid")))) {
                    if (zP2 && str.contains("srsltid")) {
                        zP2 = true;
                    }
                    WO2 wo2 = c0653fY2.a.i;
                    C1391rR2.k(wo2);
                    wo2.m.a("Activity created with data 'referrer' without required params");
                    bundleG0 = null;
                }
                bundleG0 = c0653fY2.g0(Uri.parse("https://google.com/search?".concat(str)), zP, zP2);
                if (bundleG0 != null) {
                    bundleG0.putString("_cis", "referrer");
                }
            }
            String str2 = this.v;
            X13 x13 = iu2.n;
            if (this.t) {
                C0653fY2 c0653fY22 = c1391rR2.l;
                C1391rR2.i(c0653fY22);
                bz2.zza().getClass();
                charSequence = "utm_medium";
                boolean zP3 = c1391rR2.g.p(null, c0467cO2);
                bz2.zza().getClass();
                Bundle bundleG02 = c0653fY22.g0(uri, zP3, c1391rR2.g.p(null, c0467cO22));
                if (bundleG02 != null) {
                    bundleG02.putString("_cis", "intent");
                    if (!bundleG02.containsKey("gclid") && bundleG0 != null && bundleG0.containsKey("gclid")) {
                        bundleG02.putString("_cer", "gclid=" + bundleG0.getString("gclid"));
                    }
                    iu2.n(str2, "_cmp", bundleG02);
                    x13.a(str2, bundleG02);
                }
            } else {
                charSequence = "utm_medium";
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            WO2 wo22 = c1391rR2.i;
            C1391rR2.k(wo22);
            wo22.m.b(str, "Activity created with referrer");
            if (c1391rR2.g.p(null, AbstractC0579eO2.Y)) {
                if (bundleG0 != null) {
                    iu2.n(str2, "_cmp", bundleG0);
                    x13.a(str2, bundleG0);
                } else {
                    WO2 wo23 = c1391rR2.i;
                    C1391rR2.k(wo23);
                    wo23.m.b(str, "Referrer does not contain valid parameters");
                }
                iu2.v("auto", "_ldl", null, true, c1391rR2.n.currentTimeMillis());
                return;
            }
            if (str.contains("gclid") && (str.contains("utm_campaign") || str.contains("utm_source") || str.contains(charSequence) || str.contains("utm_term") || str.contains("utm_content"))) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                iu2.v("auto", "_ldl", str, true, c1391rR2.n.currentTimeMillis());
            } else {
                WO2 wo24 = c1391rR2.i;
                C1391rR2.k(wo24);
                wo24.m.a("Activity created with data 'referrer' without required params");
            }
        } catch (RuntimeException e) {
            WO2 wo25 = c1391rR2.i;
            C1391rR2.k(wo25);
            wo25.f.b(e, "Throwable caught in handleReferrerForOnActivityCreated");
        }
    }
}
