package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class La extends CheckedTextView {
    public final Ma t;
    public final Ha u;
    public final Mb v;
    public C1162nb w;

    /* JADX WARN: Illegal instructions before constructor call */
    public La(Context context, AttributeSet attributeSet) {
        int resourceId;
        int resourceId2;
        int i = Ep1.checkedTextViewStyle;
        AbstractC1161na2.a(context);
        super(context, attributeSet, i);
        Q82.a(getContext(), this);
        Mb mb = new Mb(this);
        this.v = mb;
        mb.e(attributeSet, i);
        mb.b();
        Ha ha = new Ha(this);
        this.u = ha;
        ha.b(attributeSet, i);
        this.t = new Ma(this);
        C1342qa2 c1342qa2F = C1342qa2.f(getContext(), attributeSet, AbstractC0305Yp1.CheckedTextView, i);
        TypedArray typedArray = c1342qa2F.b;
        AbstractC0604eo2.n(this, getContext(), AbstractC0305Yp1.CheckedTextView, attributeSet, c1342qa2F.b, i, 0);
        try {
            if (typedArray.hasValue(AbstractC0305Yp1.CheckedTextView_checkMarkCompat) && (resourceId2 = typedArray.getResourceId(AbstractC0305Yp1.CheckedTextView_checkMarkCompat, 0)) != 0) {
                try {
                    setCheckMarkDrawable(AbstractC1686wb.a(resourceId2, getContext()));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(AbstractC0305Yp1.CheckedTextView_android_checkMark)) {
                        setCheckMarkDrawable(AbstractC1686wb.a(resourceId, getContext()));
                    }
                }
            } else if (typedArray.hasValue(AbstractC0305Yp1.CheckedTextView_android_checkMark) && (resourceId = typedArray.getResourceId(AbstractC0305Yp1.CheckedTextView_android_checkMark, 0)) != 0) {
                setCheckMarkDrawable(AbstractC1686wb.a(resourceId, getContext()));
            }
            if (typedArray.hasValue(AbstractC0305Yp1.CheckedTextView_checkMarkTint)) {
                setCheckMarkTintList(c1342qa2F.a(AbstractC0305Yp1.CheckedTextView_checkMarkTint));
            }
            if (typedArray.hasValue(AbstractC0305Yp1.CheckedTextView_checkMarkTintMode)) {
                setCheckMarkTintMode(J30.c(typedArray.getInt(AbstractC0305Yp1.CheckedTextView_checkMarkTintMode, -1), null));
            }
            c1342qa2F.g();
            if (this.w == null) {
                this.w = new C1162nb(this);
            }
            this.w.b(attributeSet, i);
        } catch (Throwable th) {
            c1342qa2F.g();
            throw th;
        }
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Mb mb = this.v;
        if (mb != null) {
            mb.b();
        }
        Ha ha = this.u;
        if (ha != null) {
            ha.a();
        }
        Ma ma = this.t;
        if (ma != null) {
            ma.a();
        }
    }

    @Override // android.widget.TextView
    public final ActionMode.Callback getCustomSelectionActionModeCallback() {
        return F82.d(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        AbstractC1228ob.a(inputConnectionOnCreateInputConnection, editorInfo, this);
        return inputConnectionOnCreateInputConnection;
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

    @Override // android.widget.CheckedTextView
    public final void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        Ma ma = this.t;
        if (ma != null) {
            if (ma.d) {
                ma.d = false;
            } else {
                ma.d = true;
                ma.a();
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
    public final void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(F82.e(callback, this));
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        Mb mb = this.v;
        if (mb != null) {
            mb.f(i, context);
        }
    }

    @Override // android.widget.CheckedTextView
    public final void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(AbstractC1686wb.a(i, getContext()));
    }
}
