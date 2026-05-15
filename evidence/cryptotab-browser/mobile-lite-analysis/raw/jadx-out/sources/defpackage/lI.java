package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class lI extends Dialog implements InterfaceC0762hF0, K41, vz1 {
    public C0886jF0 t;
    public final uz1 u;
    public final J41 v;

    public lI(int i, Context context) {
        super(context, i);
        this.u = new uz1(this);
        this.v = new J41(new Runnable() { // from class: kI
            @Override // java.lang.Runnable
            public final void run() {
                lI.b(this.t);
            }
        });
    }

    public static void b(lI lIVar) {
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        d();
        super.addContentView(view, layoutParams);
    }

    public final C0886jF0 c() {
        C0886jF0 c0886jF0 = this.t;
        if (c0886jF0 != null) {
            return c0886jF0;
        }
        C0886jF0 c0886jF02 = new C0886jF0(this);
        this.t = c0886jF02;
        return c0886jF02;
    }

    public final void d() {
        AbstractC0019Bp2.a(getWindow().getDecorView(), this);
        getWindow().getDecorView().setTag(AbstractC0132Lp1.view_tree_on_back_pressed_dispatcher_owner, this);
        AbstractC0035Cp2.a(getWindow().getDecorView(), this);
    }

    @Override // defpackage.InterfaceC0762hF0
    public final AbstractC0514dF0 getLifecycle() {
        return c();
    }

    @Override // defpackage.vz1
    public final tz1 getSavedStateRegistry() {
        return this.u.b;
    }

    @Override // defpackage.K41
    public final J41 l() {
        return this.v;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        this.v.d();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            J41 j41 = this.v;
            j41.e = onBackInvokedDispatcher;
            j41.e(j41.g);
        }
        this.u.b(bundle);
        c().e(bF0.ON_CREATE);
    }

    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        this.u.c(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        c().e(bF0.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        c().e(bF0.ON_DESTROY);
        this.t = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        d();
        super.setContentView(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        d();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        d();
        super.setContentView(view, layoutParams);
    }
}
