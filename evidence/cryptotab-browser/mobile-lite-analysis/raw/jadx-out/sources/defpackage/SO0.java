package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class SO0 implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ Vl0 u;
    public final /* synthetic */ OO0 v;
    public final /* synthetic */ ArrayList w;
    public final /* synthetic */ UO0 x;

    public /* synthetic */ SO0(UO0 uo0, Vl0 vl0, OO0 oo0, ArrayList arrayList, int i) {
        this.t = i;
        this.x = uo0;
        this.u = vl0;
        this.v = oo0;
        this.w = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.t) {
            case 0:
                ArrayList arrayList = this.w;
                this.u.a(this.x, this.v, arrayList);
                break;
            default:
                this.u.a(this.x, this.v, this.w);
                break;
        }
    }
}
