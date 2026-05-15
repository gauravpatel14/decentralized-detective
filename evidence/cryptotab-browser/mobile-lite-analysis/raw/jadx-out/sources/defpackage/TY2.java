package defpackage;

import android.os.RemoteException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TY2 extends UY2 {
    public final /* synthetic */ H62 u;
    public final /* synthetic */ String v;
    public final /* synthetic */ F13 w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TY2(H62 h62, H62 h622, String str, F13 f13) {
        super(h62);
        this.w = f13;
        this.u = h622;
        this.v = str;
    }

    @Override // defpackage.UY2
    public final void a() {
        H62 h62 = this.u;
        F13 f13 = this.w;
        try {
            f13.a.l.w(f13.b, F13.b(), new E03(f13, new C1224oY2("OnCompleteUpdateCallback"), h62));
        } catch (RemoteException e) {
            F13.e.a(e, "completeUpdate(%s)", this.v);
            h62.c(new RuntimeException(e));
        }
    }
}
