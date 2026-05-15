package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import defpackage.CA2;
import defpackage.G62;
import defpackage.H62;
import defpackage.vA2;
import defpackage.xA2;
import defpackage.yA2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public class PendingResultUtil {
    private static final zas zaa = new vA2();

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @KeepForSdk
    public interface ResultConverter {
        @KeepForSdk
        Object convert(Result result);
    }

    @KeepForSdk
    public static G62 toResponseTask(PendingResult pendingResult, Response response) {
        return toTask(pendingResult, new yA2(response));
    }

    @KeepForSdk
    public static G62 toTask(PendingResult pendingResult, ResultConverter resultConverter) {
        zas zasVar = zaa;
        H62 h62 = new H62();
        pendingResult.addStatusListener(new xA2(pendingResult, h62, resultConverter, zasVar));
        return h62.a;
    }

    @KeepForSdk
    public static G62 toVoidTask(PendingResult pendingResult) {
        return toTask(pendingResult, new CA2());
    }
}
