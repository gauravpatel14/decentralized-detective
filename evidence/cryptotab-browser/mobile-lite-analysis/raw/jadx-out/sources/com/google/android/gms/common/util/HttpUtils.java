package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import defpackage.C1625vX2;
import defpackage.G23;
import defpackage.t23;
import defpackage.v33;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public class HttpUtils {
    private static final Pattern zza = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static final Pattern zzb = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    private static final Pattern zzc = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    private HttpUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.HashMap] */
    @KeepForSdk
    public static Map parse(URI uri, String str) {
        ?? EmptyMap = Collections.emptyMap();
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null && rawQuery.length() > 0) {
            EmptyMap = new HashMap();
            v33 v33Var = new v33(new G23(new C1625vX2('=')), false);
            v33 v33Var2 = new v33(new G23(new C1625vX2('&')), true);
            t23 t23Var = new t23(v33Var2.b, v33Var2, rawQuery);
            while (t23Var.hasNext()) {
                String str2 = (String) t23Var.next();
                str2.getClass();
                t23 t23Var2 = new t23(v33Var.b, v33Var, str2);
                ArrayList arrayList = new ArrayList();
                while (t23Var2.hasNext()) {
                    arrayList.add((String) t23Var2.next());
                }
                List listUnmodifiableList = Collections.unmodifiableList(arrayList);
                if (listUnmodifiableList.isEmpty() || listUnmodifiableList.size() > 2) {
                    throw new IllegalArgumentException("bad parameter");
                }
                EmptyMap.put(zza((String) listUnmodifiableList.get(0), str), listUnmodifiableList.size() == 2 ? zza((String) listUnmodifiableList.get(1), str) : null);
            }
        }
        return EmptyMap;
    }

    private static String zza(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLDecoder.decode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
