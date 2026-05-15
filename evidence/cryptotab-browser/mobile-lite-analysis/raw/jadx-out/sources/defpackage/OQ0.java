package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class OQ0 {
    public final Context a;
    public final MenuC0775hQ0 b;
    public final boolean c;
    public final int d;
    public View e;
    public boolean g;
    public SQ0 h;
    public MQ0 i;
    public NQ0 j;
    public int f = 8388611;
    public final NQ0 k = new NQ0(this);

    public OQ0(int i, MenuC0775hQ0 menuC0775hQ0, Context context, View view, boolean z) {
        this.a = context;
        this.b = menuC0775hQ0;
        this.e = view;
        this.c = z;
        this.d = i;
    }

    public final MQ0 a() {
        MQ0 sn1;
        if (this.i == null) {
            Context context = this.a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(Hp1.abc_cascading_menus_min_smallest_width)) {
                sn1 = new ry(this.d, context, this.e, this.c);
            } else {
                View view = this.e;
                Context context2 = this.a;
                boolean z = this.c;
                sn1 = new SN1(this.d, this.b, context2, view, z);
            }
            sn1.k(this.b);
            sn1.r(this.k);
            sn1.m(this.e);
            sn1.d(this.h);
            sn1.n(this.g);
            sn1.o(this.f);
            this.i = sn1;
        }
        return this.i;
    }

    public final boolean b() {
        MQ0 mq0 = this.i;
        return mq0 != null && mq0.q();
    }

    public void c() {
        this.i = null;
        NQ0 nq0 = this.j;
        if (nq0 != null) {
            nq0.onDismiss();
        }
    }

    public final void d(int i, int i2, boolean z, boolean z2) {
        MQ0 mq0A = a();
        mq0A.s(z2);
        if (z) {
            if ((Gravity.getAbsoluteGravity(this.f, this.e.getLayoutDirection()) & 7) == 5) {
                i -= this.e.getWidth();
            }
            mq0A.p(i);
            mq0A.t(i2);
            int i3 = (int) ((this.a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            mq0A.t = new Rect(i - i3, i2 - i3, i + i3, i2 + i3);
        }
        mq0A.a();
    }
}
