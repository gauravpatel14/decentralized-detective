package defpackage;

import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.api.internal.zabe;

/* JADX INFO: renamed from: gz2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0744gz2 implements ResultCallback {
    public final /* synthetic */ StatusPendingResult a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ GoogleApiClient c;
    public final /* synthetic */ zabe d;

    public C0744gz2(zabe zabeVar, GoogleApiClient googleApiClient, StatusPendingResult statusPendingResult, boolean z) {
        this.d = zabeVar;
        this.a = statusPendingResult;
        this.b = z;
        this.c = googleApiClient;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void onResult(Result result) {
        Status status = (Status) result;
        zabe zabeVar = this.d;
        C1616vP1 c1616vP1A = C1616vP1.a(zabeVar.zan);
        String strE = c1616vP1A.e("defaultGoogleSignInAccount");
        c1616vP1A.f("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(strE)) {
            c1616vP1A.f(C1616vP1.h("googleSignInAccount", strE));
            c1616vP1A.f(C1616vP1.h("googleSignInOptions", strE));
        }
        if (status.isSuccess() && zabeVar.isConnected()) {
            zabeVar.disconnect();
            zabeVar.connect();
        }
        this.a.setResult(status);
        if (this.b) {
            this.c.disconnect();
        }
    }
}
