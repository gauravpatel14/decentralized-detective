package defpackage;

import android.os.RemoteException;
import java.util.List;

/* JADX INFO: renamed from: jE2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0885jE2 extends P23 {
    public final /* synthetic */ List u;
    public final /* synthetic */ H62 v;
    public final /* synthetic */ C0765hG2 w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0885jE2(C0765hG2 c0765hG2, H62 h62, List list, H62 h622) {
        super(h62);
        this.w = c0765hG2;
        this.u = list;
        this.v = h622;
    }

    @Override // defpackage.P23
    public final void a() {
        H62 h62 = this.v;
        List list = this.u;
        C0765hG2 c0765hG2 = this.w;
        try {
            c0765hG2.b.l.v(c0765hG2.a, C0765hG2.c(list), C0765hG2.d(), new VE2(c0765hG2, h62));
        } catch (RemoteException e) {
            C0765hG2.c.b(e, "deferredInstall(%s)", list);
            h62.c(new RuntimeException(e));
        }
    }
}
