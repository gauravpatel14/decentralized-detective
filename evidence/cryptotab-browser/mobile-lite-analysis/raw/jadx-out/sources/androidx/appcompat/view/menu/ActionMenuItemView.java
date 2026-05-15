package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatTextView;
import defpackage.AbstractC0305Yp1;
import defpackage.C1652w3;
import defpackage.C1765y3;
import defpackage.D3;
import defpackage.DQ0;
import defpackage.InterfaceC0706gQ0;
import defpackage.VQ0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements VQ0, View.OnClickListener, D3 {
    public CharSequence A;
    public Drawable B;
    public InterfaceC0706gQ0 C;
    public C1652w3 D;
    public C1765y3 E;
    public boolean F;
    public final int G;
    public int H;
    public final int I;
    public DQ0 z;

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        this.F = i();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0305Yp1.ActionMenuItemView, 0, 0);
        this.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC0305Yp1.ActionMenuItemView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.I = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.H = -1;
        setSaveEnabled(false);
    }

    @Override // defpackage.D3
    public final boolean a() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // defpackage.D3
    public final boolean b() {
        return !TextUtils.isEmpty(getText()) && this.z.getIcon() == null;
    }

    @Override // defpackage.VQ0
    public final void d(DQ0 dq0) {
        this.z = dq0;
        Drawable icon = dq0.getIcon();
        this.B = icon;
        if (icon != null) {
            int intrinsicWidth = icon.getIntrinsicWidth();
            int intrinsicHeight = icon.getIntrinsicHeight();
            int i = this.I;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (intrinsicWidth * (i / intrinsicHeight));
            } else {
                i = intrinsicHeight;
            }
            icon.setBounds(0, 0, intrinsicWidth, i);
        }
        setCompoundDrawables(icon, null, null, null);
        j();
        this.A = dq0.getTitleCondensed();
        j();
        setId(dq0.a);
        setVisibility(dq0.isVisible() ? 0 : 8);
        setEnabled(dq0.isEnabled());
        if (dq0.hasSubMenu() && this.D == null) {
            this.D = new C1652w3(this);
        }
    }

    @Override // defpackage.VQ0
    public final DQ0 e() {
        return this.z;
    }

    @Override // android.widget.TextView, android.view.View
    public final CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    public final boolean i() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || (i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    public final void j() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.A);
        if (this.B != null && ((this.z.y & 4) != 4 || !this.F)) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.A : null);
        CharSequence charSequence = this.z.q;
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(z3 ? null : this.z.e);
        } else {
            setContentDescription(charSequence);
        }
        CharSequence charSequence2 = this.z.r;
        if (TextUtils.isEmpty(charSequence2)) {
            setTooltipText(z3 ? null : this.z.e);
        } else {
            setTooltipText(charSequence2);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InterfaceC0706gQ0 interfaceC0706gQ0 = this.C;
        if (interfaceC0706gQ0 != null) {
            interfaceC0706gQ0.a(this.z);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.F = i();
        j();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        boolean zIsEmpty = TextUtils.isEmpty(getText());
        if (!zIsEmpty && (i3 = this.H) >= 0) {
            super.setPadding(i3, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int i4 = this.G;
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, i4) : i4;
        if (mode != 1073741824 && i4 > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i2);
        }
        if (!zIsEmpty || this.B == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.B.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C1652w3 c1652w3;
        if (this.z.hasSubMenu() && (c1652w3 = this.D) != null && c1652w3.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
        this.H = i;
        super.setPadding(i, i2, i3, i4);
    }
}
