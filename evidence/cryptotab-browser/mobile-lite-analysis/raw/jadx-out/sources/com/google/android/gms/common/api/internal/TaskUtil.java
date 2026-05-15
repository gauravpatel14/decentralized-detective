package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import defpackage.C0078Fz2;
import defpackage.C0939k33;
import defpackage.G62;
import defpackage.H62;
import defpackage.K62;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public class TaskUtil {
    @KeepForSdk
    public static void setResultOrApiException(Status status, H62 h62) {
        setResultOrApiException(status, null, h62);
    }

    @KeepForSdk
    @Deprecated
    public static G62 toVoidTaskThatFailsOnFalse(G62 g62) {
        C0078Fz2 c0078Fz2 = new C0078Fz2();
        C0939k33 c0939k33 = (C0939k33) g62;
        c0939k33.getClass();
        return c0939k33.f(K62.a, c0078Fz2);
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public static boolean trySetResultOrApiException(Status status, Object obj, H62 h62) {
        return status.isSuccess() ? h62.d(obj) : h62.c(ApiExceptionUtil.fromStatus(status));
    }

    @KeepForSdk
    public static void setResultOrApiException(Status status, Object obj, H62 h62) {
        if (status.isSuccess()) {
            h62.b(obj);
        } else {
            h62.a(ApiExceptionUtil.fromStatus(status));
        }
    }
}
