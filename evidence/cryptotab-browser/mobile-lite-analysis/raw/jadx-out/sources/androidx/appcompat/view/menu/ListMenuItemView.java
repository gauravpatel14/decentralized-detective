package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import defpackage.AbstractC0132Lp1;
import defpackage.AbstractC0305Yp1;
import defpackage.C1342qa2;
import defpackage.DQ0;
import defpackage.Ep1;
import defpackage.VQ0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements VQ0, AbsListView.SelectionBoundsAdjuster {
    public ImageView A;
    public LinearLayout B;
    public final Drawable C;
    public final int D;
    public final Context E;
    public boolean F;
    public final Drawable G;
    public final boolean H;
    public LayoutInflater I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f8J;
    public DQ0 t;
    public ImageView u;
    public RadioButton v;
    public TextView w;
    public CheckBox x;
    public TextView y;
    public ImageView z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i = Ep1.listMenuViewStyle;
        C1342qa2 c1342qa2F = C1342qa2.f(getContext(), attributeSet, AbstractC0305Yp1.MenuView, i);
        this.C = c1342qa2F.b(AbstractC0305Yp1.MenuView_android_itemBackground);
        int i2 = AbstractC0305Yp1.MenuView_android_itemTextAppearance;
        TypedArray typedArray = c1342qa2F.b;
        this.D = typedArray.getResourceId(i2, -1);
        this.F = typedArray.getBoolean(AbstractC0305Yp1.MenuView_preserveIconSpacing, false);
        this.E = context;
        this.G = c1342qa2F.b(AbstractC0305Yp1.MenuView_subMenuArrow);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, Ep1.dropDownListViewStyle, 0);
        this.H = typedArrayObtainStyledAttributes.hasValue(0);
        c1342qa2F.g();
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.A;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.A.getLayoutParams();
        rect.top = this.A.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x011e  */
    @Override // defpackage.VQ0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(defpackage.DQ0 r13) {
        /*
            Method dump skipped, instruction units count: 611
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.d(DQ0):void");
    }

    @Override // defpackage.VQ0
    public final DQ0 e() {
        return this.t;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.C);
        TextView textView = (TextView) findViewById(AbstractC0132Lp1.title);
        this.w = textView;
        int i = this.D;
        if (i != -1) {
            textView.setTextAppearance(this.E, i);
        }
        this.y = (TextView) findViewById(AbstractC0132Lp1.shortcut);
        ImageView imageView = (ImageView) findViewById(AbstractC0132Lp1.submenuarrow);
        this.z = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.G);
        }
        this.A = (ImageView) findViewById(AbstractC0132Lp1.group_divider);
        this.B = (LinearLayout) findViewById(AbstractC0132Lp1.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        if (this.u != null && this.F) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.u.getLayoutParams();
            int i3 = layoutParams.height;
            if (i3 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i3;
            }
        }
        super.onMeasure(i, i2);
    }
}
