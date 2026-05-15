package defpackage;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Vb extends ToggleButton {
    public final Ha t;
    public final Mb u;
    public C1162nb v;

    public Vb(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.buttonStyleToggle);
        Q82.a(getContext(), this);
        Ha ha = new Ha(this);
        this.t = ha;
        ha.b(attributeSet, R.attr.buttonStyleToggle);
        Mb mb = new Mb(this);
        this.u = mb;
        mb.e(attributeSet, R.attr.buttonStyleToggle);
        if (this.v == null) {
            this.v = new C1162nb(this);
        }
        this.v.b(attributeSet, R.attr.buttonStyleToggle);
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Ha ha = this.t;
        if (ha != null) {
            ha.a();
        }
        Mb mb = this.u;
        if (mb != null) {
            mb.b();
        }
    }

    @Override // android.widget.TextView
    public final void setAllCaps(boolean z) {
        super.setAllCaps(z);
        if (this.v == null) {
            this.v = new C1162nb(this);
        }
        this.v.c(z);
    }

    @Override // android.widget.ToggleButton, android.view.View
    public final void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        Ha ha = this.t;
        if (ha != null) {
            ha.c();
        }
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        Ha ha = this.t;
        if (ha != null) {
            ha.d(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        Mb mb = this.u;
        if (mb != null) {
            mb.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        Mb mb = this.u;
        if (mb != null) {
            mb.b();
        }
    }

    @Override // android.widget.TextView
    public final void setFilters(InputFilter[] inputFilterArr) {
        if (this.v == null) {
            this.v = new C1162nb(this);
        }
        super.setFilters(this.v.a(inputFilterArr));
    }
}
