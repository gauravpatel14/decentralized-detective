package defpackage;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Cy {
    public static String a(String str) {
        if (str != null) {
            return b(null, str);
        }
        throw new IllegalArgumentException("applicationId cannot be null");
    }

    public static String b(List list, String str) {
        StringBuilder sb = new StringBuilder("com.google.android.gms.cast.CATEGORY_CAST");
        if (str != null) {
            String upperCase = str.toUpperCase();
            if (!upperCase.matches("[A-F0-9]+")) {
                throw new IllegalArgumentException(str.length() != 0 ? "Invalid application ID: ".concat(str) : new String("Invalid application ID: "));
            }
            sb.append("/");
            sb.append(upperCase);
        }
        if (list != null) {
            if (list.isEmpty()) {
                throw new IllegalArgumentException("Must specify at least one namespace");
            }
            if (str == null) {
                sb.append("/");
            }
            sb.append("/");
            Iterator it = list.iterator();
            boolean z = true;
            while (it.hasNext()) {
                String string = (String) it.next();
                AbstractC0700gL2.d(string);
                if (z) {
                    z = false;
                } else {
                    sb.append(",");
                }
                if (!AbstractC0700gL2.a.matcher(string).matches()) {
                    StringBuilder sb2 = new StringBuilder(string.length());
                    for (int i = 0; i < string.length(); i++) {
                        char cCharAt = string.charAt(i);
                        if ((cCharAt < 'A' || cCharAt > 'Z') && ((cCharAt < 'a' || cCharAt > 'z') && !((cCharAt >= '0' && cCharAt <= '9') || cCharAt == '_' || cCharAt == '-' || cCharAt == '.' || cCharAt == ':'))) {
                            sb2.append(String.format("%%%04x", Integer.valueOf(cCharAt & 65535)));
                        } else {
                            sb2.append(cCharAt);
                        }
                    }
                    string = sb2.toString();
                }
                sb.append(string);
            }
        }
        if (str == null && list == null) {
            sb.append("/");
        }
        if (list == null) {
            sb.append("/");
        }
        sb.append("//ALLOW_IPV6");
        return sb.toString();
    }
}
