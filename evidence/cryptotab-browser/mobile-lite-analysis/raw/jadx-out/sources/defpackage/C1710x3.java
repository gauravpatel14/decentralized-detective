package defpackage;

import android.content.Context;
import android.view.View;

/* JADX INFO: renamed from: x3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1710x3 extends OQ0 {
    public final /* synthetic */ int l = 1;
    public final /* synthetic */ C3 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1710x3(C3 c3, Context context, MenuC0775hQ0 menuC0775hQ0, View view) {
        super(Ep1.actionOverflowMenuStyle, menuC0775hQ0, context, view, true);
        this.m = c3;
        this.f = 8388613;
        C1765y3 c1765y3 = c3.P;
        this.h = c1765y3;
        MQ0 mq0 = this.i;
        if (mq0 != null) {
            mq0.d(c1765y3);
        }
    }

    @Override // defpackage.OQ0
    public final void c() {
        switch (this.l) {
            case 0:
                C3 c3 = this.m;
                c3.M = null;
                c3.getClass();
                super.c();
                break;
            default:
                C3 c32 = this.m;
                MenuC0775hQ0 menuC0775hQ0 = c32.v;
                if (menuC0775hQ0 != null) {
                    menuC0775hQ0.c(true);
                }
                c32.L = null;
                super.c();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1710x3(C3 c3, Context context, SubMenuC1273pR1 subMenuC1273pR1, View view) {
        super(Ep1.actionOverflowMenuStyle, subMenuC1273pR1, context, view, false);
        this.m = c3;
        if (!subMenuC1273pR1.A.f()) {
            View view2 = c3.B;
            this.e = view2 == null ? (View) c3.A : view2;
        }
        C1765y3 c1765y3 = c3.P;
        this.h = c1765y3;
        MQ0 mq0 = this.i;
        if (mq0 != null) {
            mq0.d(c1765y3);
        }
    }
}
