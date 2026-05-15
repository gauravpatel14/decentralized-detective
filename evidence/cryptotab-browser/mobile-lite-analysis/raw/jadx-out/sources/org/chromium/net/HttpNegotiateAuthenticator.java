package org.chromium.net;

import J.N;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import defpackage.AbstractC1499tM;
import defpackage.Qp0;
import defpackage.Sp0;
import defpackage.Xd0;
import org.chromium.base.ApplicationStatus;
import org.chromium.base.ThreadUtils;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class HttpNegotiateAuthenticator {
    public Bundle a;
    public final String b;

    public HttpNegotiateAuthenticator(String str) {
        this.b = str;
    }

    public static HttpNegotiateAuthenticator create(String str) {
        return new HttpNegotiateAuthenticator(str);
    }

    public void getNextAuthToken(long j, String str, String str2, boolean z) {
        Context context = AbstractC1499tM.a;
        Sp0 sp0 = new Sp0();
        sp0.d = Xd0.a("SPNEGO:HOSTBASED:", str);
        sp0.b = AccountManager.get(context);
        sp0.a = j;
        String[] strArr = {"SPNEGO"};
        Bundle bundle = new Bundle();
        sp0.c = bundle;
        if (str2 != null) {
            bundle.putString("incomingAuthToken", str2);
        }
        Bundle bundle2 = this.a;
        if (bundle2 != null) {
            sp0.c.putBundle("spnegoContext", bundle2);
        }
        sp0.c.putBoolean("canDelegate", z);
        Activity activity = ApplicationStatus.d;
        if (activity == null) {
            sp0.b.getAccountsByTypeAndFeatures(this.b, strArr, new Qp0(this, sp0, 0), new Handler(ThreadUtils.c()));
            return;
        }
        if (context.checkPermission("android.permission.GET_ACCOUNTS", Process.myPid(), Process.myUid()) != 0) {
            Log.e("cr_net_auth", "ERR_MISCONFIGURED_AUTH_ENVIRONMENT: android.permission.GET_ACCOUNTS permission not granted. Aborting authentication");
            N._V_IJOO(28, -343, sp0.a, this, null);
            return;
        }
        sp0.b.getAuthTokenByFeatures(this.b, sp0.d, strArr, activity, null, sp0.c, new Qp0(this, sp0, 1), new Handler(ThreadUtils.c()));
    }
}
