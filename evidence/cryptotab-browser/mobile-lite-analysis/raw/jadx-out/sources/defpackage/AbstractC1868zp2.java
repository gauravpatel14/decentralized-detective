package defpackage;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: zp2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1868zp2 {
    public boolean A;
    public boolean B;
    public boolean C;
    public ViewTreeObserverOnDrawListenerC1806yp2 D;
    public int t;
    public int u;
    public Activity v;
    public ViewGroup w;
    public e50 x;
    public C1755xp2 y;
    public View z;

    public AbstractC1868zp2(int i, int i2, Activity activity, ViewGroup viewGroup, e50 e50Var) {
        this.t = i;
        this.u = i2;
        this.v = activity;
        this.w = viewGroup;
        this.x = e50Var;
    }

    public void a() {
        if (this.z == null) {
            return;
        }
        e50 e50Var = this.x;
        if (e50Var != null) {
            e50Var.e(this.u);
        }
        this.y = null;
        this.z.post(new Runnable() { // from class: wp2
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC1868zp2 abstractC1868zp2 = this.t;
                abstractC1868zp2.b();
                abstractC1868zp2.z = null;
                abstractC1868zp2.w = null;
            }
        });
        this.t = -1;
        this.u = -1;
        this.v = null;
        this.x = null;
    }

    public final void b() {
        if (this.C) {
            if (this.D != null) {
                this.z.getViewTreeObserver().removeOnDrawListener(this.D);
                this.D = null;
            }
            this.w.removeView(this.z);
            this.C = false;
        }
    }

    public int c() {
        return View.MeasureSpec.makeMeasureSpec(0, 0);
    }

    public final void d() {
        if (this.z != null) {
            return;
        }
        this.z = LayoutInflater.from(this.v).inflate(this.t, this.w, false);
        h();
        if (this.y == null) {
            this.y = new C1755xp2(this, this.z.findViewById(this.u));
        }
        e50 e50Var = this.x;
        if (e50Var != null) {
            e50Var.d(this.u, this.y);
        }
        this.A = true;
    }

    public void e(boolean z) {
        C1755xp2 c1755xp2;
        if (this.z == null) {
            d();
        }
        this.B = true;
        if (!this.C && i() && !this.C) {
            this.w.addView(this.z);
            this.C = true;
            if (this.D == null) {
                this.D = new ViewTreeObserverOnDrawListenerC1806yp2(this);
                this.z.getViewTreeObserver().addOnDrawListener(this.D);
            }
        }
        if (!this.C) {
            f();
            if (this.B && this.z != null && (c1755xp2 = this.y) != null) {
                this.B = false;
                c1755xp2.g(null);
            }
        } else if (z || this.A) {
            int iC = c();
            int size = View.MeasureSpec.getMode(iC) == 1073741824 ? View.MeasureSpec.getSize(iC) : -2;
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int size2 = View.MeasureSpec.getMode(iMakeMeasureSpec) == 1073741824 ? View.MeasureSpec.getSize(iMakeMeasureSpec) : -2;
            ViewGroup.LayoutParams layoutParams = this.z.getLayoutParams();
            layoutParams.width = size;
            layoutParams.height = size2;
            this.z.setLayoutParams(layoutParams);
        }
        this.A = false;
    }

    public final void f() {
        this.z.measure(c(), View.MeasureSpec.makeMeasureSpec(0, 0));
        View view = this.z;
        view.layout(0, 0, view.getMeasuredWidth(), this.z.getMeasuredHeight());
    }

    public void g() {
        if (j()) {
            b();
        }
    }

    public boolean i() {
        return true;
    }

    public boolean j() {
        return true;
    }

    public void h() {
    }
}
