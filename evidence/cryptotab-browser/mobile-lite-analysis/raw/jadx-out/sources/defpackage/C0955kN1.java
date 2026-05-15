package defpackage;

import com.google.android.play.core.review.model.ReviewErrorCode;

/* JADX INFO: renamed from: kN1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0955kN1 {
    public static int a(int i) {
        if (i == -100) {
            return 18;
        }
        switch (i) {
            case -13:
                return 15;
            case -12:
                return 16;
            case -11:
                return 17;
            case -10:
                return 8;
            case -9:
                return 13;
            case -8:
                return 7;
            case -7:
                return 4;
            case -6:
                return 11;
            case -5:
                return 6;
            case -4:
                return 14;
            case -3:
                return 9;
            case ReviewErrorCode.INVALID_REQUEST /* -2 */:
                return 10;
            case -1:
                return 5;
            case 0:
                return 12;
            default:
                return -1;
        }
    }

    public static void b(int i, String str) {
        Gr1.h(i, 22, "Android.FeatureModules.InstallStatus." + str);
    }
}
