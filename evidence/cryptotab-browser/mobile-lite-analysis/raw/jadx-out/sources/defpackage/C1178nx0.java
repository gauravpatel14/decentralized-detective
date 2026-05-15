package defpackage;

import android.content.Context;
import android.util.Log;
import com.android.installreferrer.api.InstallReferrerClient;

/* JADX INFO: renamed from: nx0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1178nx0 {
    public jx0 a;
    public final InstallReferrerClient b;

    public C1178nx0(Context context, jx0 jx0Var) {
        C1116mx0 c1116mx0 = new C1116mx0(this);
        Log.i("cr_InstallReferrerService", "Initialization");
        this.a = jx0Var;
        InstallReferrerClient installReferrerClientBuild = InstallReferrerClient.newBuilder(context).build();
        this.b = installReferrerClientBuild;
        installReferrerClientBuild.startConnection(c1116mx0);
    }
}
