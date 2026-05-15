package defpackage;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;

/* JADX INFO: renamed from: rb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1401rb extends MultiAutoCompleteTextView {
    public static final int[] w = {R.attr.popupBackground};
    public final Ha t;
    public final Mb u;
    public final C1102mb v;

    /* JADX WARN: Illegal instructions before constructor call */
    public C1401rb(Context context, AttributeSet attributeSet) {
        int i = Ep1.autoCompleteTextViewStyle;
        AbstractC1161na2.a(context);
        super(context, attributeSet, i);
        Q82.a(getContext(), this);
        C1342qa2 c1342qa2F = C1342qa2.f(getContext(), attributeSet, w, i);
        if (c1342qa2F.b.hasValue(0)) {
            setDropDownBackgroundDrawable(c1342qa2F.b(0));
        }
        c1342qa2F.g();
        Ha ha = new Ha(this);
        this.t = ha;
        ha.b(attributeSet, i);
        Mb mb = new Mb(this);
        this.u = mb;
        mb.e(attributeSet, i);
        mb.b();
        C1102mb c1102mb = new C1102mb(this);
        this.v = c1102mb;
        c1102mb.b(attributeSet, i);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean zIsFocusable = isFocusable();
        boolean zIsClickable = isClickable();
        boolean zIsLongClickable = isLongClickable();
        int inputType = getInputType();
        KeyListener keyListenerA = c1102mb.a(keyListener);
        if (keyListenerA == keyListener) {
            return;
        }
        super.setKeyListener(keyListenerA);
        setRawInputType(inputType);
        setFocusable(zIsFocusable);
        setClickable(zIsClickable);
        setLongClickable(zIsLongClickable);
    }

    @Override // android.widget.TextView, android.view.View
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

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        AbstractC1228ob.a(inputConnectionOnCreateInputConnection, editorInfo, this);
        return this.v.c(inputConnectionOnCreateInputConnection);
    }

    @Override // android.view.View
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

    @Override // android.widget.AutoCompleteTextView
    public final void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(AbstractC1686wb.a(i, getContext()));
    }

    @Override // android.widget.TextView
    public final void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.v.a(keyListener));
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        Mb mb = this.u;
        if (mb != null) {
            mb.f(i, context);
        }
    }
}
