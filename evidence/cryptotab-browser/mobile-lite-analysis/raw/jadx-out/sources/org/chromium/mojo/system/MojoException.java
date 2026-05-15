package org.chromium.mojo.system;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class MojoException extends RuntimeException {
    public final int t;

    public MojoException(int i) {
        this.t = i;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        String str;
        int i = this.t;
        switch (i) {
            case 0:
                str = "OK";
                break;
            case 1:
                str = "CANCELLED";
                break;
            case 2:
            default:
                str = "UNKNOWN";
                break;
            case 3:
                str = "INVALID_ARGUMENT";
                break;
            case 4:
                str = "DEADLINE_EXCEEDED";
                break;
            case 5:
                str = "NOT_FOUND";
                break;
            case 6:
                str = "ALREADY_EXISTS";
                break;
            case 7:
                str = "PERMISSION_DENIED";
                break;
            case 8:
                str = "RESOURCE_EXHAUSTED";
                break;
            case ConnectionResult.SERVICE_INVALID /* 9 */:
                str = "FAILED_PRECONDITION";
                break;
            case 10:
                str = "ABORTED";
                break;
            case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                str = "OUT_OF_RANGE";
                break;
            case 12:
                str = "UNIMPLEMENTED";
                break;
            case 13:
                str = "INTERNAL";
                break;
            case 14:
                str = "UNAVAILABLE";
                break;
            case 15:
                str = "DATA_LOSS";
                break;
            case 16:
                str = "BUSY";
                break;
            case 17:
                str = "SHOULD_WAIT";
                break;
        }
        return "MojoResult(" + i + "): " + str;
    }
}
