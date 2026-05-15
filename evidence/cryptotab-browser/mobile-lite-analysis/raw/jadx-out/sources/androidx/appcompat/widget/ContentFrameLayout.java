package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import defpackage.C1050lp2;
import defpackage.C1710x3;
import defpackage.C3;
import defpackage.InterfaceC1513tV;
import defpackage.LayoutInflaterFactory2C0658fb;
import defpackage.MenuC0775hQ0;
import defpackage.Va;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {
    public Va A;
    public TypedValue t;
    public TypedValue u;
    public TypedValue v;
    public TypedValue w;
    public TypedValue x;
    public TypedValue y;
    public final Rect z;

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.z = new Rect();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Va va = this.A;
        if (va != null) {
            va.getClass();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        C3 c3;
        super.onDetachedFromWindow();
        Va va = this.A;
        if (va != null) {
            LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb = va.u;
            InterfaceC1513tV interfaceC1513tV = layoutInflaterFactory2C0658fb.K;
            if (interfaceC1513tV != null) {
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC1513tV;
                actionBarOverlayLayout.j();
                ActionMenuView actionMenuView = actionBarOverlayLayout.x.a.t;
                if (actionMenuView != null && (c3 = actionMenuView.M) != null) {
                    c3.g();
                    C1710x3 c1710x3 = c3.M;
                    if (c1710x3 != null && c1710x3.b()) {
                        c1710x3.i.dismiss();
                    }
                }
            }
            if (layoutInflaterFactory2C0658fb.P != null) {
                layoutInflaterFactory2C0658fb.E.getDecorView().removeCallbacks(layoutInflaterFactory2C0658fb.Q);
                if (layoutInflaterFactory2C0658fb.P.isShowing()) {
                    try {
                        layoutInflaterFactory2C0658fb.P.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                layoutInflaterFactory2C0658fb.P = null;
            }
            C1050lp2 c1050lp2 = layoutInflaterFactory2C0658fb.R;
            if (c1050lp2 != null) {
                c1050lp2.b();
            }
            MenuC0775hQ0 menuC0775hQ0 = layoutInflaterFactory2C0658fb.A(0).h;
            if (menuC0775hQ0 != null) {
                menuC0775hQ0.c(true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00de  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }
}
