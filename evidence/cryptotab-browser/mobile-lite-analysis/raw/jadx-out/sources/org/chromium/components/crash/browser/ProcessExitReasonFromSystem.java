package org.chromium.components.crash.browser;

import android.app.ActivityManager;
import android.os.Build;
import com.google.android.gms.common.ConnectionResult;
import defpackage.AbstractC1499tM;
import defpackage.Gr1;
import defpackage.P9;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ProcessExitReasonFromSystem {
    public static int a(int i) {
        if (Build.VERSION.SDK_INT < 30) {
            return -1;
        }
        List historicalProcessExitReasons = ((ActivityManager) AbstractC1499tM.a.getSystemService("activity")).getHistoricalProcessExitReasons(null, i, 1);
        if (historicalProcessExitReasons.isEmpty() || historicalProcessExitReasons.get(0) == null || P9.c(historicalProcessExitReasons.get(0)).getPid() != i) {
            return -1;
        }
        return P9.c(historicalProcessExitReasons.get(0)).getReason();
    }

    public static void b(int i, String str) {
        Integer num;
        switch (i) {
            case 0:
                num = 11;
                break;
            case 1:
                num = 5;
                break;
            case 2:
                num = 10;
                break;
            case 3:
                num = 7;
                break;
            case 4:
                num = 1;
                break;
            case 5:
                num = 2;
                break;
            case 6:
                num = 0;
                break;
            case 7:
                num = 6;
                break;
            case 8:
                num = 9;
                break;
            case ConnectionResult.SERVICE_INVALID /* 9 */:
                num = 4;
                break;
            case 10:
                num = 12;
                break;
            case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                num = 13;
                break;
            case 12:
                num = 3;
                break;
            case 13:
                num = 8;
                break;
            default:
                num = null;
                break;
        }
        if (num != null) {
            Gr1.h(num.intValue(), 14, str);
        }
    }

    public static void recordExitReasonToUma(int i, String str) {
        b(a(i), str);
    }
}
