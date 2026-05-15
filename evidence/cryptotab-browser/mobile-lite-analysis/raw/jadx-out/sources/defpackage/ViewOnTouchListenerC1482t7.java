package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

/* JADX INFO: renamed from: t7, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnTouchListenerC1482t7 implements View.OnTouchListener {
    public boolean B;
    public final M21 C;
    public View.OnTouchListener D;
    public q7 E;
    public int F;
    public int G;
    public int H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f38J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public int P;
    public boolean Q;
    public r7 u;
    public final Handler v;
    public final View w;
    public final Lr1 x;
    public final PopupWindow y;
    public final Lr1 z;
    public final Rect t = new Rect();
    public final o7 A = new o7(this);

    public ViewOnTouchListenerC1482t7(Context context, View view, Drawable drawable, View view2, Lr1 lr1) {
        p7 p7Var = new p7(this);
        this.C = new M21();
        this.I = 0;
        this.f38J = 0;
        View rootView = view.getRootView();
        this.w = rootView;
        this.x = new ViewOnLayoutChangeListenerC1424s7(rootView);
        if (C1748xj2.a == null) {
            C1748xj2.a = new C1748xj2();
        }
        C1748xj2.a.getClass();
        PopupWindow popupWindow = new PopupWindow(context);
        this.y = popupWindow;
        this.v = new Handler();
        this.z = lr1;
        this.u = new r7(new Rect(), false, false);
        popupWindow.setWidth(-2);
        popupWindow.setHeight(-2);
        popupWindow.setBackgroundDrawable(drawable);
        popupWindow.setContentView(view2);
        popupWindow.setTouchInterceptor(this);
        popupWindow.setOnDismissListener(p7Var);
    }

    public final void a(PopupWindow.OnDismissListener onDismissListener) {
        this.C.e(onDismissListener);
    }

    public final void b() {
        this.y.dismiss();
    }

    public final boolean c() {
        float f = this.w.getResources().getDisplayMetrics().density * 50.0f;
        return ((float) this.u.c.height()) >= f && ((float) this.u.c.width()) >= f;
    }

    public final void d(boolean z) {
        this.y.setFocusable(z);
    }

    public final void e(int i) {
        this.G = Math.max(i, (int) Math.ceil(this.w.getResources().getDisplayMetrics().density * 50.0f));
    }

    public final void f() {
        if (this.y.isShowing()) {
            return;
        }
        this.z.a(this);
        this.x.a(this);
        h();
        if (c()) {
            g();
        }
    }

    public final void g() {
        boolean z = this.Q;
        PopupWindow popupWindow = this.y;
        if (z && this.P == 0) {
            r7 r7Var = this.u;
            boolean z2 = r7Var.a;
            popupWindow.setAnimationStyle(r7Var.b ? z2 ? AbstractC0292Xp1.AnchoredPopupAnimEndTop : AbstractC0292Xp1.AnchoredPopupAnimEndBottom : z2 ? AbstractC0292Xp1.AnchoredPopupAnimStartTop : AbstractC0292Xp1.AnchoredPopupAnimStartBottom);
        }
        try {
            View view = this.w;
            Rect rect = this.u.c;
            popupWindow.showAtLocation(view, 8388659, rect.left, rect.top);
        } catch (WindowManager.BadTokenException unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00c1 A[PHI: r2
      0x00c1: PHI (r2v23 boolean) = (r2v22 boolean), (r2v22 boolean), (r2v26 boolean), (r2v26 boolean) binds: [B:38:0x00b2, B:39:0x00b4, B:43:0x00bb, B:44:0x00bd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x011d A[PHI: r15
      0x011d: PHI (r15v6 boolean) = (r15v5 boolean), (r15v5 boolean), (r15v12 boolean), (r15v12 boolean) binds: [B:74:0x0107, B:75:0x0109, B:79:0x0110, B:80:0x0112] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            Method dump skipped, instruction units count: 566
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ViewOnTouchListenerC1482t7.h():void");
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener = this.D;
        boolean z = onTouchListener != null && onTouchListener.onTouch(view, motionEvent);
        Hr1.a(motionEvent.getAction() == 4 ? "InProductHelp.OutsideTouch" : "InProductHelp.InsideTouch");
        if (this.B && (z || !this.y.getContentView().dispatchTouchEvent(motionEvent))) {
            b();
        }
        return z;
    }
}
