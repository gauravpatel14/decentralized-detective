package org.chromium.ui.listmenu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.PopupWindow;
import defpackage.AbstractC0275Wp1;
import defpackage.AbstractC0292Xp1;
import defpackage.AbstractC0305Yp1;
import defpackage.CG0;
import defpackage.DG0;
import defpackage.Hp1;
import defpackage.InterfaceC1772yG0;
import defpackage.M21;
import defpackage.ViewOnTouchListenerC1482t7;
import defpackage.q7;
import org.chromium.ui.listmenu.ListMenuButton;
import org.chromium.ui.widget.ChromeImageButton;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ListMenuButton extends ChromeImageButton implements q7 {
    public static final /* synthetic */ int F = 0;
    public DG0 A;
    public final M21 B;
    public boolean C;
    public final boolean D;
    public boolean E;
    public final boolean w;
    public final boolean x;
    public int y;
    public ViewOnTouchListenerC1482t7 z;

    public ListMenuButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.B = new M21();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0305Yp1.ListMenuButton);
        this.y = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC0305Yp1.ListMenuButton_menuMaxWidth, getResources().getDimensionPixelSize(Hp1.list_menu_width));
        this.x = typedArrayObtainStyledAttributes.getBoolean(AbstractC0305Yp1.ListMenuButton_menuHorizontalOverlapAnchor, true);
        this.w = typedArrayObtainStyledAttributes.getBoolean(AbstractC0305Yp1.ListMenuButton_menuVerticalOverlapAnchor, true);
        this.D = typedArrayObtainStyledAttributes.getBoolean(AbstractC0305Yp1.ListMenuButton_menuPositionedAtEnd, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // defpackage.q7
    public final void a(int i, Rect rect, int i2, boolean z) {
        if (this.D) {
            ViewOnTouchListenerC1482t7 viewOnTouchListenerC1482t7 = this.z;
            int i3 = z ? AbstractC0292Xp1.EndIconMenuAnim : AbstractC0292Xp1.EndIconMenuAnimBottom;
            viewOnTouchListenerC1482t7.P = i3;
            viewOnTouchListenerC1482t7.y.setAnimationStyle(i3);
            return;
        }
        ViewOnTouchListenerC1482t7 viewOnTouchListenerC1482t72 = this.z;
        int i4 = z ? AbstractC0292Xp1.StartIconMenuAnim : AbstractC0292Xp1.StartIconMenuAnimBottom;
        viewOnTouchListenerC1482t72.P = i4;
        viewOnTouchListenerC1482t72.y.setAnimationStyle(i4);
    }

    public final void b() {
        ViewOnTouchListenerC1482t7 viewOnTouchListenerC1482t7 = this.z;
        if (viewOnTouchListenerC1482t7 != null) {
            viewOnTouchListenerC1482t7.b();
        }
    }

    public final void c(boolean z) {
        for (CG0 cg0 : this.B.t) {
            if (z) {
                cg0.b();
            } else {
                cg0.a();
            }
        }
    }

    public final void d(DG0 dg0, boolean z) {
        b();
        this.A = dg0;
        if (z) {
            setOnClickListener(new View.OnClickListener() { // from class: zG0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i = ListMenuButton.F;
                    this.t.e();
                }
            });
        }
    }

    public final void e() {
        if (this.E) {
            b();
            DG0 dg0 = this.A;
            if (dg0 == null) {
                throw new IllegalStateException("Delegate was not set.");
            }
            InterfaceC1772yG0 interfaceC1772yG0B = dg0.b();
            interfaceC1772yG0B.a(new Runnable() { // from class: AG0
                @Override // java.lang.Runnable
                public final void run() {
                    this.t.b();
                }
            });
            View viewG = interfaceC1772yG0B.g();
            ViewParent parent = viewG.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(viewG);
            }
            ViewOnTouchListenerC1482t7 viewOnTouchListenerC1482t7 = new ViewOnTouchListenerC1482t7(getContext(), this, new ColorDrawable(0), viewG, this.A.a(this));
            this.z = viewOnTouchListenerC1482t7;
            viewOnTouchListenerC1482t7.L = this.w;
            viewOnTouchListenerC1482t7.M = this.x;
            viewOnTouchListenerC1482t7.e(this.y);
            if (this.C) {
                int paddingRight = viewG.getPaddingRight() + viewG.getPaddingLeft();
                this.z.H = interfaceC1772yG0B.b() + paddingRight;
            }
            this.z.d(true);
            ViewOnTouchListenerC1482t7 viewOnTouchListenerC1482t72 = this.z;
            viewOnTouchListenerC1482t72.E = this;
            viewOnTouchListenerC1482t72.a(new PopupWindow.OnDismissListener() { // from class: BG0
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    ListMenuButton listMenuButton = this.t;
                    listMenuButton.z = null;
                    listMenuButton.c(false);
                }
            });
            this.z.y.setOutsideTouchable(true);
            this.z.f();
            c(true);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.E = true;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        b();
        this.E = false;
        super.onDetachedFromWindow();
    }

    @Override // org.chromium.ui.widget.ChromeImageButton, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (TextUtils.isEmpty(getContentDescription())) {
            if (TextUtils.isEmpty("")) {
                setContentDescription(getContext().getResources().getString(AbstractC0275Wp1.accessibility_toolbar_btn_menu));
            } else {
                setContentDescription(getContext().getResources().getString(AbstractC0275Wp1.accessibility_list_menu_button, ""));
            }
        }
    }
}
