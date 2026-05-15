package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class GL {
    public static String a(String str, String[] strArr) {
        if (strArr != null) {
            String strA = BN0.a("--", str, "=");
            for (String str2 : strArr) {
                if (str2 != null && str2.startsWith(strA)) {
                    return str2.substring(strA.length());
                }
            }
        }
        return null;
    }
}
