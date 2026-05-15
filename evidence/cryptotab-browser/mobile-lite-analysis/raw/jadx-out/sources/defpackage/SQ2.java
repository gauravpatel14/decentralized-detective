package defpackage;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class SQ2 implements InterfaceC0522dK2 {
    public static final SQ2 a = new SQ2();

    @Override // defpackage.InterfaceC0522dK2
    public final boolean a(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case ConnectionResult.SERVICE_INVALID /* 9 */:
            case 10:
            case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
            case 12:
            case 13:
            case 14:
            case 15:
                return true;
            default:
                switch (i) {
                    case 22:
                    case ConnectionResult.API_DISABLED /* 23 */:
                    case ConnectionResult.API_DISABLED_FOR_CONNECTION /* 24 */:
                    case 25:
                    case 26:
                        return true;
                    default:
                        return false;
                }
        }
    }
}
