package com.google.android.play.core.splitinstall;

import com.google.android.gms.common.api.ApiException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class SplitInstallException extends ApiException {
    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SplitInstallException(int r7) {
        /*
            r6 = this;
            com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            java.util.HashMap r2 = defpackage.KB2.a
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            boolean r4 = r2.containsKey(r3)
            if (r4 == 0) goto L41
            java.util.HashMap r4 = defpackage.KB2.b
            boolean r5 = r4.containsKey(r3)
            if (r5 != 0) goto L1b
            goto L41
        L1b:
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.String r2 = " (https://developer.android.com/reference/com/google/android/play/core/splitinstall/model/SplitInstallErrorCode.html#"
            r4.append(r2)
            r4.append(r3)
            java.lang.String r2 = ")"
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            goto L43
        L41:
            java.lang.String r2 = ""
        L43:
            java.lang.Object[] r1 = new java.lang.Object[]{r1, r2}
            java.lang.String r2 = "Split Install Error(%d): %s"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            r0.<init>(r7, r1)
            r6.<init>(r0)
            if (r7 == 0) goto L56
            return
        L56:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "errorCode should not be 0."
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitinstall.SplitInstallException.<init>(int):void");
    }

    public final int getErrorCode() {
        return super.getStatusCode();
    }
}
