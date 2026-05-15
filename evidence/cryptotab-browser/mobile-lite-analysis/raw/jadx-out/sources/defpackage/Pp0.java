package defpackage;

import android.util.Log;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Pp0 {
    public static C0994kw a(C1223oY0 c1223oY0) {
        boolean z;
        long j;
        long j2;
        long j3;
        long j4;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map map = c1223oY0.b;
        if (map == null) {
            return null;
        }
        String str = (String) map.get("Date");
        long jC = str != null ? c(str) : 0L;
        String str2 = (String) map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",", 0);
            z = false;
            j = 0;
            j2 = 0;
            while (i < strArrSplit.length) {
                String strTrim = strArrSplit[i].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j2 = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    z = true;
                }
                i++;
            }
            i = 1;
        } else {
            z = false;
            j = 0;
            j2 = 0;
        }
        String str3 = (String) map.get("Expires");
        long jC2 = str3 != null ? c(str3) : 0L;
        String str4 = (String) map.get("Last-Modified");
        long jC3 = str4 != null ? c(str4) : 0L;
        String str5 = (String) map.get("ETag");
        if (i != 0) {
            j4 = jCurrentTimeMillis + (j * 1000);
            j3 = z ? j4 : (j2 * 1000) + j4;
        } else {
            j3 = 0;
            if (jC <= 0 || jC2 < jC) {
                j4 = 0;
            } else {
                j4 = jCurrentTimeMillis + (jC2 - jC);
                j3 = j4;
            }
        }
        C0994kw c0994kw = new C0994kw();
        c0994kw.a = c1223oY0.a;
        c0994kw.b = str5;
        c0994kw.f = j4;
        c0994kw.e = j3;
        c0994kw.c = jC;
        c0994kw.d = jC3;
        c0994kw.g = map;
        c0994kw.h = c1223oY0.c;
        return c0994kw;
    }

    public static String b(Map map) {
        String str;
        if (map != null && (str = (String) map.get("Content-Type")) != null) {
            String[] strArrSplit = str.split(";", 0);
            for (int i = 1; i < strArrSplit.length; i++) {
                String[] strArrSplit2 = strArrSplit[i].trim().split("=", 0);
                if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                    return strArrSplit2[1];
                }
            }
        }
        return "utf-8";
    }

    public static long c(String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat.parse(str).getTime();
        } catch (ParseException e) {
            if ("0".equals(str) || "-1".equals(str)) {
                return 0L;
            }
            Log.e("Volley", AbstractC1583uq2.a("Unable to parse dateStr: %s, falling back to 0", str), e);
            return 0L;
        }
    }
}
