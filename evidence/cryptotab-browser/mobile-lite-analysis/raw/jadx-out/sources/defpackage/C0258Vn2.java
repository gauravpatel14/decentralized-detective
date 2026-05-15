package defpackage;

import android.view.View;

/* JADX INFO: renamed from: Vn2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0258Vn2 {
    public final C0277Wr1 a;
    public final Un2 b;

    public C0258Vn2(C0277Wr1 c0277Wr1) {
        this.a = c0277Wr1;
        Un2 un2 = new Un2();
        un2.a = 0;
        this.b = un2;
    }

    public final View a(int i, int i2, int i3, int i4) {
        View viewU;
        C0277Wr1 c0277Wr1 = this.a;
        int iD = c0277Wr1.d();
        int iC = c0277Wr1.c();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            switch (c0277Wr1.a) {
                case 0:
                    viewU = c0277Wr1.b.u(i);
                    break;
                default:
                    viewU = c0277Wr1.b.u(i);
                    break;
            }
            int iB = c0277Wr1.b(viewU);
            int iA = c0277Wr1.a(viewU);
            Un2 un2 = this.b;
            un2.b = iD;
            un2.c = iC;
            un2.d = iB;
            un2.e = iA;
            if (i3 != 0) {
                un2.a = i3;
                if (un2.a()) {
                    return viewU;
                }
            }
            if (i4 != 0) {
                un2.a = i4;
                if (un2.a()) {
                    view = viewU;
                }
            }
            i += i5;
        }
        return view;
    }

    public final boolean b(View view) {
        C0277Wr1 c0277Wr1 = this.a;
        int iD = c0277Wr1.d();
        int iC = c0277Wr1.c();
        int iB = c0277Wr1.b(view);
        int iA = c0277Wr1.a(view);
        Un2 un2 = this.b;
        un2.b = iD;
        un2.c = iC;
        un2.d = iB;
        un2.e = iA;
        un2.a = 24579;
        return un2.a();
    }
}
