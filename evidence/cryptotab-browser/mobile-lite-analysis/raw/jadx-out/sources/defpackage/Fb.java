package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import androidx.appcompat.widget.AppCompatSpinner;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Fb extends ZG0 implements Hb {
    public CharSequence V;
    public ListAdapter W;
    public final Rect X;
    public int Y;
    public final /* synthetic */ AppCompatSpinner Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Fb(AppCompatSpinner appCompatSpinner, Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Z = appCompatSpinner;
        this.X = new Rect();
        this.H = appCompatSpinner;
        this.R = true;
        this.S.setFocusable(true);
        this.I = new Db(this);
    }

    @Override // defpackage.ZG0, defpackage.Hb
    public final void A(ListAdapter listAdapter) {
        super.A(listAdapter);
        this.W = listAdapter;
    }

    public final void d() {
        int i;
        C1459sb c1459sb = this.S;
        Drawable background = c1459sb.getBackground();
        AppCompatSpinner appCompatSpinner = this.Z;
        if (background != null) {
            background.getPadding(appCompatSpinner.A);
            boolean z = Jp2.a;
            int layoutDirection = appCompatSpinner.getLayoutDirection();
            Rect rect = appCompatSpinner.A;
            i = layoutDirection == 1 ? rect.right : -rect.left;
        } else {
            Rect rect2 = appCompatSpinner.A;
            rect2.right = 0;
            rect2.left = 0;
            i = 0;
        }
        int paddingLeft = appCompatSpinner.getPaddingLeft();
        int paddingRight = appCompatSpinner.getPaddingRight();
        int width = appCompatSpinner.getWidth();
        int i2 = appCompatSpinner.z;
        if (i2 == -2) {
            int iA = appCompatSpinner.a((SpinnerAdapter) this.W, c1459sb.getBackground());
            int i3 = appCompatSpinner.getContext().getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = appCompatSpinner.A;
            int i4 = (i3 - rect3.left) - rect3.right;
            if (iA > i4) {
                iA = i4;
            }
            c(Math.max(iA, (width - paddingLeft) - paddingRight));
        } else if (i2 == -1) {
            c((width - paddingLeft) - paddingRight);
        } else {
            c(i2);
        }
        boolean z2 = Jp2.a;
        this.y = appCompatSpinner.getLayoutDirection() == 1 ? (((width - paddingRight) - this.x) - this.Y) + i : paddingLeft + this.Y + i;
    }

    @Override // defpackage.Hb
    public final void p(int i, int i2) {
        ViewTreeObserver viewTreeObserver;
        C1459sb c1459sb = this.S;
        boolean zIsShowing = c1459sb.isShowing();
        d();
        this.S.setInputMethodMode(2);
        a();
        V30 v30 = this.v;
        v30.setChoiceMode(1);
        v30.setTextDirection(i);
        v30.setTextAlignment(i2);
        AppCompatSpinner appCompatSpinner = this.Z;
        int selectedItemPosition = appCompatSpinner.getSelectedItemPosition();
        V30 v302 = this.v;
        if (c1459sb.isShowing() && v302 != null) {
            v302.A = false;
            v302.setSelection(selectedItemPosition);
            if (v302.getChoiceMode() != 0) {
                v302.setItemChecked(selectedItemPosition, true);
            }
        }
        if (zIsShowing || (viewTreeObserver = appCompatSpinner.getViewTreeObserver()) == null) {
            return;
        }
        Ab ab = new Ab(1, this);
        viewTreeObserver.addOnGlobalLayoutListener(ab);
        this.S.setOnDismissListener(new Eb(this, ab));
    }

    @Override // defpackage.Hb
    public final void t(CharSequence charSequence) {
        this.V = charSequence;
    }

    @Override // defpackage.Hb
    public final void w(int i) {
        this.Y = i;
    }

    @Override // defpackage.Hb
    public final CharSequence z() {
        return this.V;
    }
}
