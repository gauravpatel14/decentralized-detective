package defpackage;

import android.os.RemoteException;

/* JADX INFO: renamed from: nY2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1158nY2 extends UY2 {
    public final /* synthetic */ String u;
    public final /* synthetic */ H62 v;
    public final /* synthetic */ F13 w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1158nY2(H62 h62, H62 h622, String str, F13 f13) {
        super(h62);
        this.w = f13;
        this.u = str;
        this.v = h622;
    }

    @Override // defpackage.UY2
    public final void a() {
        H62 h62 = this.v;
        F13 f13 = this.w;
        String str = this.u;
        try {
            f13.a.l.r0(f13.b, F13.a(f13, str), new BinderC1420s13(f13, h62, str));
        } catch (RemoteException e) {
            F13.e.a(e, "requestUpdateInfo(%s)", str);
            h62.c(new RuntimeException(e));
        }
    }
}
