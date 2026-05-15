package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class Ka extends CheckBox {
    public final Na t;
    public final Ha u;
    public final Mb v;
    public C1162nb w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ka(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC1161na2.a(context);
        Q82.a(getContext(), this);
        Na na = new Na(this);
        this.t = na;
        na.b(attributeSet, i);
        Ha ha = new Ha(this);
        this.u = ha;
        ha.b(attributeSet, i);
        Mb mb = new Mb(this);
        this.v = mb;
        mb.e(attributeSet, i);
        if (this.w == null) {
            this.w = new C1162nb(this);
        }
        this.w.b(attributeSet, i);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Ha ha = this.u;
        if (ha != null) {
            ha.a();
        }
        Mb mb = this.v;
        if (mb != null) {
            mb.b();
        }
    }

    @Override // android.widget.TextView
    public final void setAllCaps(boolean z) {
        super.setAllCaps(z);
        if (this.w == null) {
            this.w = new C1162nb(this);
        }
        this.w.c(z);
    }

    @Override // android.view.View
    public final void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        Ha ha = this.u;
        if (ha != null) {
            ha.c();
        }
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        Ha ha = this.u;
        if (ha != null) {
            ha.d(i);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        Na na = this.t;
        if (na != null) {
            if (na.e) {
                na.e = false;
            } else {
                na.e = true;
                na.a();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        Mb mb = this.v;
        if (mb != null) {
            mb.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        Mb mb = this.v;
        if (mb != null) {
            mb.b();
        }
    }

    @Override // android.widget.TextView
    public final void setFilters(InputFilter[] inputFilterArr) {
        if (this.w == null) {
            this.w = new C1162nb(this);
        }
        super.setFilters(this.w.a(inputFilterArr));
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(AbstractC1686wb.a(i, getContext()));
    }
}
