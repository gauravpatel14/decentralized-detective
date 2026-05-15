package defpackage;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: Wr1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0277Wr1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ AbstractC0306Yr1 b;

    public /* synthetic */ C0277Wr1(AbstractC0306Yr1 abstractC0306Yr1, int i) {
        this.a = i;
        this.b = abstractC0306Yr1;
    }

    public final int a(View view) {
        switch (this.a) {
            case 0:
                C0321Zr1 c0321Zr1 = (C0321Zr1) view.getLayoutParams();
                this.b.getClass();
                return AbstractC0306Yr1.B(view) + ((ViewGroup.MarginLayoutParams) c0321Zr1).rightMargin;
            default:
                C0321Zr1 c0321Zr12 = (C0321Zr1) view.getLayoutParams();
                this.b.getClass();
                return AbstractC0306Yr1.y(view) + ((ViewGroup.MarginLayoutParams) c0321Zr12).bottomMargin;
        }
    }

    public final int b(View view) {
        switch (this.a) {
            case 0:
                C0321Zr1 c0321Zr1 = (C0321Zr1) view.getLayoutParams();
                this.b.getClass();
                return AbstractC0306Yr1.A(view) - ((ViewGroup.MarginLayoutParams) c0321Zr1).leftMargin;
            default:
                C0321Zr1 c0321Zr12 = (C0321Zr1) view.getLayoutParams();
                this.b.getClass();
                return AbstractC0306Yr1.C(view) - ((ViewGroup.MarginLayoutParams) c0321Zr12).topMargin;
        }
    }

    public final int c() {
        switch (this.a) {
            case 0:
                AbstractC0306Yr1 abstractC0306Yr1 = this.b;
                return abstractC0306Yr1.n - abstractC0306Yr1.G();
            default:
                AbstractC0306Yr1 abstractC0306Yr12 = this.b;
                return abstractC0306Yr12.o - abstractC0306Yr12.E();
        }
    }

    public final int d() {
        switch (this.a) {
            case 0:
                return this.b.F();
            default:
                return this.b.H();
        }
    }
}
