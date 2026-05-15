package defpackage;

import android.app.PendingIntent;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: renamed from: nW2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1156nW2 extends AbstractC1439sL2 {
    public final /* synthetic */ String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1156nW2(GoogleApiClient googleApiClient, String str) {
        super(googleApiClient);
        this.a = str;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final void doExecute(Api.AnyClient anyClient) {
        OJ2 oj2 = (OJ2) anyClient;
        String str = this.a;
        if (TextUtils.isEmpty(str)) {
            setResult((Result) new Status(2001, "IllegalArgument: sessionId cannot be null or empty", (PendingIntent) null));
            return;
        }
        try {
            oj2.h(str, this);
        } catch (IllegalStateException unused) {
            a();
        }
    }
}
