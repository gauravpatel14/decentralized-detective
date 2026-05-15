package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

/* JADX INFO: renamed from: x40, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1711x40 implements q7 {
    public BaseAdapter A;
    public final ListView B;
    public final Drawable C;
    public final int D;
    public final Context t;
    public final View u;
    public boolean v;
    public int w = -1;
    public final ViewOnLayoutChangeListenerC1594v40 x;
    public String y;
    public final ViewOnTouchListenerC1482t7 z;

    public C1711x40(Context context, View view) {
        this.t = context;
        this.u = view;
        view.setId(AbstractC0132Lp1.dropdown_popup_window);
        view.setTag(this);
        ViewOnLayoutChangeListenerC1594v40 viewOnLayoutChangeListenerC1594v40 = new ViewOnLayoutChangeListenerC1594v40(this);
        this.x = viewOnLayoutChangeListenerC1594v40;
        view.addOnLayoutChangeListener(viewOnLayoutChangeListenerC1594v40);
        C1653w40 c1653w40 = new C1653w40(this);
        ListView listView = new ListView(context);
        this.B = listView;
        ViewTreeObserverOnGlobalLayoutListenerC1410rp2 viewTreeObserverOnGlobalLayoutListenerC1410rp2 = new ViewTreeObserverOnGlobalLayoutListenerC1410rp2(view);
        viewTreeObserverOnGlobalLayoutListenerC1410rp2.d(true);
        Drawable drawableA = AbstractC1686wb.a(Ip1.menu_bg_baseline, context);
        this.C = drawableA;
        ViewOnTouchListenerC1482t7 viewOnTouchListenerC1482t7 = new ViewOnTouchListenerC1482t7(context, view, drawableA, listView, viewTreeObserverOnGlobalLayoutListenerC1410rp2);
        this.z = viewOnTouchListenerC1482t7;
        viewOnTouchListenerC1482t7.a(c1653w40);
        viewOnTouchListenerC1482t7.E = this;
        float dimensionPixelSize = context.getResources().getDimensionPixelSize(Hp1.dropdown_elevation);
        PopupWindow popupWindow = viewOnTouchListenerC1482t7.y;
        popupWindow.setElevation(dimensionPixelSize);
        Rect rect = new Rect();
        drawableA.getPadding(rect);
        Rect rect2 = new Rect(0, rect.bottom, 0, rect.top);
        Rect rect3 = viewTreeObserverOnGlobalLayoutListenerC1410rp2.w;
        if (!rect2.equals(rect3)) {
            rect3.set(rect2);
            viewTreeObserverOnGlobalLayoutListenerC1410rp2.c(true);
        }
        this.D = rect.right + rect.left;
        viewOnTouchListenerC1482t7.f38J = 1;
        viewOnTouchListenerC1482t7.N = true;
        popupWindow.setOutsideTouchable(true);
    }

    @Override // defpackage.q7
    public final void a(int i, Rect rect, int i2, boolean z) {
        this.C.setBounds(rect);
        this.z.y.setBackgroundDrawable(AbstractC1686wb.a(Ip1.menu_bg_baseline, this.t));
    }

    public final void b() {
        ViewOnTouchListenerC1482t7 viewOnTouchListenerC1482t7 = this.z;
        boolean zIsShowing = viewOnTouchListenerC1482t7.y.isShowing();
        viewOnTouchListenerC1482t7.L = false;
        viewOnTouchListenerC1482t7.M = true;
        int i = this.t.getResources().getDisplayMetrics().widthPixels;
        int i2 = AbstractC1632vj2.a(this.A, null)[0];
        int i3 = this.D;
        int i4 = i2 + i3;
        if (i < i4) {
            viewOnTouchListenerC1482t7.e(i - i3);
        } else {
            View view = this.u;
            if (view.getWidth() < i2) {
                viewOnTouchListenerC1482t7.e(i4);
            } else {
                viewOnTouchListenerC1482t7.e(view.getWidth() + i3);
            }
        }
        viewOnTouchListenerC1482t7.f();
        ListView listView = this.B;
        listView.setDividerHeight(0);
        listView.setLayoutDirection(this.v ? 1 : 0);
        if (!zIsShowing) {
            listView.setContentDescription(this.y);
            listView.sendAccessibilityEvent(32);
        }
        int i5 = this.w;
        if (i5 >= 0) {
            listView.setSelection(i5);
            this.w = -1;
        }
    }
}
