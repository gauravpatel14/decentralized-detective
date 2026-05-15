package defpackage;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class FS2 implements InterfaceC0522dK2 {
    public static final FS2 a = new FS2();

    @Override // defpackage.InterfaceC0522dK2
    public final boolean a(int i) {
        if (i == 17) {
            return true;
        }
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
                return true;
            default:
                return false;
        }
    }
}
