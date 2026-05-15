package org.chromium.base;

import android.os.LocaleList;
import android.text.TextUtils;
import defpackage.CH;
import defpackage.F;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class LocaleUtils {
    public static String a(String str) {
        str.getClass();
        switch (str) {
            case "in":
                return "id";
            case "iw":
                return "he";
            case "ji":
                return "yi";
            case "jw":
                return "jv";
            case "tl":
                return "fil";
            case "gom":
                return "kok";
            default:
                return str;
        }
    }

    public static String b(String str) {
        int iIndexOf = str.indexOf(45);
        return iIndexOf < 0 ? str : str.substring(0, iIndexOf);
    }

    public static String c(Locale locale) {
        String strA = a(locale.getLanguage());
        String country = locale.getCountry();
        return (strA.equals("no") && country.equals("NO") && locale.getVariant().equals("NY")) ? "nn-NO" : country.isEmpty() ? strA : F.b(strA, "-", country);
    }

    public static String getDefaultCountryCode() {
        CH chC = CH.c();
        return chC.e("default-country-code") ? chC.d("default-country-code") : Locale.getDefault().getCountry();
    }

    public static String getDefaultLocaleListString() {
        LocaleList localeList = LocaleList.getDefault();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < localeList.size(); i++) {
            Locale localeBuild = localeList.get(i);
            String language = localeBuild.getLanguage();
            String strA = a(language);
            if (!strA.equals(language)) {
                localeBuild = new Locale.Builder().setLocale(localeBuild).setLanguage(strA).build();
            }
            arrayList.add(c(localeBuild));
        }
        return TextUtils.join(",", arrayList);
    }

    public static String getDefaultLocaleString() {
        return c(Locale.getDefault());
    }
}
