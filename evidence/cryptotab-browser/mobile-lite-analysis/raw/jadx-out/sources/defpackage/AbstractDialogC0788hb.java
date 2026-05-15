package defpackage;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: hb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractDialogC0788hb extends lI implements Ja {
    public LayoutInflaterFactory2C0658fb w;
    public final C0722gb x;

    /* JADX WARN: Type inference failed for: r1v2, types: [gb] */
    public AbstractDialogC0788hb(int i, Context context) {
        int i2;
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(Ep1.dialogTheme, typedValue, true);
            i2 = typedValue.resourceId;
        } else {
            i2 = i;
        }
        super(i2, context);
        this.x = new EB0() { // from class: gb
            @Override // defpackage.EB0
            public final boolean F(KeyEvent keyEvent) {
                return this.t.h(keyEvent);
            }
        };
        AbstractC0231Ta abstractC0231TaF = f();
        if (i == 0) {
            TypedValue typedValue2 = new TypedValue();
            context.getTheme().resolveAttribute(Ep1.dialogTheme, typedValue2, true);
            i = typedValue2.resourceId;
        }
        ((LayoutInflaterFactory2C0658fb) abstractC0231TaF).n0 = i;
        abstractC0231TaF.f();
    }

    @Override // defpackage.lI, android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        g();
        LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb = (LayoutInflaterFactory2C0658fb) f();
        layoutInflaterFactory2C0658fb.x();
        ((ViewGroup) layoutInflaterFactory2C0658fb.U.findViewById(R.id.content)).addView(view, layoutParams);
        layoutInflaterFactory2C0658fb.F.a(layoutInflaterFactory2C0658fb.E.getCallback());
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        f().g();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return FB0.b(this.x, getWindow().getDecorView(), this, keyEvent);
    }

    public final AbstractC0231Ta f() {
        if (this.w == null) {
            Ra ra = AbstractC0231Ta.t;
            this.w = new LayoutInflaterFactory2C0658fb(getContext(), getWindow(), this, this);
        }
        return this.w;
    }

    @Override // android.app.Dialog
    public final View findViewById(int i) {
        LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb = (LayoutInflaterFactory2C0658fb) f();
        layoutInflaterFactory2C0658fb.x();
        return layoutInflaterFactory2C0658fb.E.findViewById(i);
    }

    public final void g() {
        AbstractC0019Bp2.a(getWindow().getDecorView(), this);
        AbstractC0035Cp2.a(getWindow().getDecorView(), this);
        getWindow().getDecorView().setTag(AbstractC0132Lp1.view_tree_on_back_pressed_dispatcher_owner, this);
    }

    public final boolean h(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        f().d();
    }

    @Override // defpackage.lI, android.app.Dialog
    public void onCreate(Bundle bundle) {
        f().c();
        super.onCreate(bundle);
        f().f();
    }

    @Override // defpackage.lI, android.app.Dialog
    public final void onStop() {
        super.onStop();
        LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb = (LayoutInflaterFactory2C0658fb) f();
        layoutInflaterFactory2C0658fb.B();
        AbstractC0508d3 abstractC0508d3 = layoutInflaterFactory2C0658fb.H;
        if (abstractC0508d3 != null) {
            abstractC0508d3.p(false);
        }
    }

    @Override // defpackage.lI, android.app.Dialog
    public final void setContentView(int i) {
        g();
        f().j(i);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        f().n(charSequence);
    }

    @Override // defpackage.lI, android.app.Dialog
    public final void setContentView(View view) {
        g();
        f().k(view);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        f().n(getContext().getString(i));
    }

    @Override // defpackage.lI, android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        g();
        f().l(view, layoutParams);
    }
}
