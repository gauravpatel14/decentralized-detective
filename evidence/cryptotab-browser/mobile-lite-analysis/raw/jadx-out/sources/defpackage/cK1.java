package defpackage;

import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class cK1 extends Pr1 {
    public final QJ0 w;
    public final aK1 x;
    public final SparseArray y = new SparseArray();

    public cK1(QJ0 qj0) {
        this.w = qj0;
        aK1 ak1 = new aK1(this);
        this.x = ak1;
        qj0.l(ak1);
    }

    public final void A(int i, RJ0 rj0, InterfaceC0436bn1 interfaceC0436bn1) {
        this.y.put(i, new Pair(rj0, interfaceC0436bn1));
    }

    @Override // defpackage.Pr1
    public final int b() {
        return this.w.u.size();
    }

    @Override // defpackage.Pr1
    public final int d(int i) {
        return ((PJ0) this.w.u.get(i)).a;
    }

    public View w(int i, ViewGroup viewGroup) {
        return ((RJ0) ((Pair) this.y.get(i)).first).a(viewGroup);
    }

    @Override // defpackage.Pr1
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void m(bK1 bk1, int i) {
        bk1.v(((PJ0) this.w.u.get(i)).b);
    }

    @Override // defpackage.Pr1
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public bK1 o(int i, ViewGroup viewGroup) {
        View viewW = w(i, viewGroup);
        InterfaceC0436bn1 interfaceC0436bn1 = (InterfaceC0436bn1) ((Pair) this.y.get(i)).second;
        bK1 bk1 = new bK1(viewW);
        bk1.O = interfaceC0436bn1;
        return bk1;
    }

    @Override // defpackage.Pr1
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void s(bK1 bk1) {
        bk1.v(null);
    }
}
