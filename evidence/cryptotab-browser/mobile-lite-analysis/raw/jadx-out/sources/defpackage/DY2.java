package defpackage;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DY2 {
    public static String a(WU2 wu2) {
        StringBuilder sb = new StringBuilder(wu2.j());
        for (int i = 0; i < wu2.j(); i++) {
            byte bF = wu2.f(i);
            if (bF == 34) {
                sb.append("\\\"");
            } else if (bF == 39) {
                sb.append("\\'");
            } else if (bF != 92) {
                switch (bF) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case ConnectionResult.SERVICE_INVALID /* 9 */:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bF < 32 || bF > 126) {
                            sb.append('\\');
                            sb.append((char) (((bF >>> 6) & 3) + 48));
                            sb.append((char) (((bF >>> 3) & 7) + 48));
                            sb.append((char) ((bF & 7) + 48));
                        } else {
                            sb.append((char) bF);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
