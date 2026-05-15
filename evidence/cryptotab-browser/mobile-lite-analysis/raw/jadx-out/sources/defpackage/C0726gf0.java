package defpackage;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;

/* JADX INFO: renamed from: gf0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0726gf0 extends TaskApiCall {
    public final String a;
    public final InterfaceC0988kn1 b;

    public C0726gf0(InterfaceC0988kn1 interfaceC0988kn1, String str) {
        super(null, false, 13201);
        this.a = str;
        this.b = interfaceC0988kn1;
    }

    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final void doExecute(Api.AnyClient anyClient, H62 h62) {
        a50 a50Var = (a50) anyClient;
        BinderC0662ff0 binderC0662ff0 = new BinderC0662ff0(this.b, h62);
        String str = this.a;
        a50Var.getClass();
        try {
            ((rr0) ((tr0) a50Var.getService())).W0(binderC0662ff0, str);
        } catch (RemoteException unused) {
        }
    }
}
