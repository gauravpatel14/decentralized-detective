package defpackage;

import android.net.Uri;
import android.util.Log;
import java.net.URLEncoder;
import org.chromium.ui.base.DeviceFormFactor;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class lQ {
    public static final Jd a;
    public static final C1726xM1[] b;
    public static final C0377am2[] c;

    static {
        int i = AbstractC1872zv.a;
        a = Jd.a("6.2.34");
        C1726xM1 c1726xM1 = new C1726xM1("/affiliate/dashboard", "Balance", Ip1.ic_balance);
        C1726xM1 c1726xM12 = new C1726xM1("/affiliate/referrals", "Referrals", Ip1.ic_referrals);
        C1726xM1 c1726xM13 = new C1726xM1("/faq", "FAQ", Ip1.ic_faq);
        C1726xM1 c1726xM14 = new C1726xM1("/affiliate/boost", "Boost", Ip1.ic_boost);
        int i2 = Ip1.ic_mining;
        b = new C1726xM1[]{c1726xM1, c1726xM12, c1726xM13, c1726xM14, new C1726xM1("/mobile/android", "Mining", i2), new C1726xM1("/mobile/android/tutorial", "Tutorial", i2), new C1726xM1("/mobile/android/default_browser_tutorial", "Default browser tutorial", i2), new C1726xM1("/api/v1/browser/android/install", "", 0), new C1726xM1("/login", "login", i2)};
        c = new C0377am2[]{new C0377am2("https://ncwallet.net/benefits", "NC Wallet", Ip1.ic_nc_wallet), new C0377am2("https://pool.cryptobrowser.site/landing", "CT Pool", Ip1.ic_ct_pool), new C0377am2("chrome://bot", "CB Game", Ip1.ic_cb_game)};
    }

    public static AbstractC1743xa2 a(String str) {
        AbstractC1743xa2 abstractC1743xa2 = null;
        if (str != null && Uri.parse(str).getHost().equals("cryptobrowser.site")) {
            C1726xM1[] c1726xM1Arr = b;
            int length = c1726xM1Arr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                C1726xM1 c1726xM1 = c1726xM1Arr[i];
                if (d(str, c1726xM1.c)) {
                    abstractC1743xa2 = c1726xM1;
                    break;
                }
                i++;
            }
        }
        if (abstractC1743xa2 == null) {
            for (C0377am2 c0377am2 : c) {
                if (str.startsWith(c0377am2.c)) {
                    abstractC1743xa2 = c0377am2;
                }
            }
        }
        return abstractC1743xa2;
    }

    public static String b(int i) {
        if (i == 0) {
            return "";
        }
        if (aM1.a(i, 5)) {
            return "chrome://cryptotabdash/";
        }
        if (aM1.a(i, 6)) {
            return "chrome://welcome/";
        }
        try {
            return "https://cryptobrowser.site" + b[aM1.b(i)].c + "/";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String c() {
        String strEncode;
        String strA = Sj1.a("referrer_pref", "");
        if (RP1.a(strA)) {
            strEncode = "";
        } else {
            try {
                strEncode = URLEncoder.encode(strA, "UTF-8");
            } catch (Exception e) {
                Log.e("cr_UrlSafeEncoder", "Encode error", e);
                strEncode = "";
            }
        }
        String strA2 = Xd0.a("?referrer=", strEncode);
        int i = AbstractC1872zv.a;
        return F.b(F.b(F.b(F.a(strA2, "&v=6.2.34"), "&device=", DeviceFormFactor.isTablet() ? "tablet" : "phone"), "&bid=", Sj1.a("bid_pref", "")), "&app_id=", AbstractC1499tM.a.getPackageName());
    }

    public static boolean d(String str, String str2) {
        if (str == null) {
            return false;
        }
        Uri uri = Uri.parse(str);
        String host = uri.getHost();
        if ("cryptobrowser.site".equals(host) && (str.endsWith(str2) || str.endsWith(str2.concat("/")))) {
            return true;
        }
        String path = uri.getPath();
        if (path != null && "cryptobrowser.site".equals(host) && (path.endsWith(str2) || path.endsWith(str2.concat("/")))) {
            return true;
        }
        int iLastIndexOf = str.lastIndexOf(63);
        if (iLastIndexOf == -1) {
            return false;
        }
        return d(str.substring(0, iLastIndexOf), str2);
    }

    public static boolean e(int i, String str) {
        if (str != null && i != 0) {
            try {
                Uri uri = Uri.parse(str);
                if (aM1.a(i, 5)) {
                    return uri.getScheme().equals("chrome") && uri.getHost().equals("cryptotabdash");
                }
                return d(str, b[aM1.b(i)].c);
            } catch (Exception unused) {
                Log.e("cr_CryptoTabUtils", "invalid comparison for url:".concat(str));
            }
        }
        return false;
    }

    public static boolean f(String str) {
        if (str != null) {
            try {
                Uri.parse(str);
                return d(str, b[aM1.b(5)].c);
            } catch (Exception unused) {
                Log.e("cr_CryptoTabUtils", "invalid comparison for url:".concat(str));
            }
        }
        return false;
    }
}
