package defpackage;

import android.os.RemoteException;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class UD2 extends P23 {
    public final /* synthetic */ ArrayList u;
    public final /* synthetic */ ArrayList v;
    public final /* synthetic */ XY2 w;
    public final /* synthetic */ H62 x;
    public final /* synthetic */ C0765hG2 y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UD2(C0765hG2 c0765hG2, H62 h62, ArrayList arrayList, ArrayList arrayList2, XY2 xy2, H62 h622) {
        super(h62);
        this.y = c0765hG2;
        this.u = arrayList;
        this.v = arrayList2;
        this.w = xy2;
        this.x = h622;
    }

    @Override // defpackage.P23
    public final void a() {
        H62 h62 = this.x;
        C0765hG2 c0765hG2 = this.y;
        XY2 xy2 = this.w;
        ArrayList arrayList = this.u;
        ArrayList arrayListC = C0765hG2.c(arrayList);
        ArrayList arrayList2 = this.v;
        arrayListC.addAll(C0765hG2.b(arrayList2));
        try {
            xy2.a.add(new HZ2(2, System.currentTimeMillis()));
            c0765hG2.b.l.C0(c0765hG2.a, arrayListC, C0765hG2.a(xy2), new WF2(c0765hG2, h62));
        } catch (RemoteException e) {
            C0765hG2.c.b(e, "startInstall(%s,%s)", arrayList, arrayList2);
            h62.c(new RuntimeException(e));
        }
    }
}
