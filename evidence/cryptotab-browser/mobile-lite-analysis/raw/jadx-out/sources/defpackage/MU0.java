package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class MU0 {
    public final String a;
    public final LU0 b;
    public LU0 c;

    public MU0(String str) {
        LU0 lu0 = new LU0();
        this.b = lu0;
        this.c = lu0;
        this.a = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.a);
        sb.append('{');
        LU0 lu0 = this.b.b;
        String str = "";
        while (lu0 != null) {
            Object obj = lu0.a;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String strDeepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
            }
            lu0 = lu0.b;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
