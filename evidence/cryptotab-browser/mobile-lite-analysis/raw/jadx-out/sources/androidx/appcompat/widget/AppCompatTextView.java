package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import defpackage.AbstractC0285Xi2;
import defpackage.AbstractC0493cj2;
import defpackage.AbstractC0752h60;
import defpackage.AbstractC1161na2;
import defpackage.AbstractC1228ob;
import defpackage.AbstractC1686wb;
import defpackage.C1162nb;
import defpackage.D82;
import defpackage.F82;
import defpackage.Ha;
import defpackage.Ib;
import defpackage.Jp2;
import defpackage.Mb;
import defpackage.Nb;
import defpackage.Ob;
import defpackage.Pb;
import defpackage.Q82;
import defpackage.Ub;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatTextView extends TextView {
    public final Ha t;
    public final Mb u;
    public final Ib v;
    public C1162nb w;
    public boolean x;
    public Nb y;

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
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
    public final int getAutoSizeMaxTextSize() {
        if (Jp2.c) {
            return super.getAutoSizeMaxTextSize();
        }
        Mb mb = this.u;
        if (mb != null) {
            return Math.round(mb.h.e);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public final int getAutoSizeMinTextSize() {
        if (Jp2.c) {
            return super.getAutoSizeMinTextSize();
        }
        Mb mb = this.u;
        if (mb != null) {
            return Math.round(mb.h.d);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public final int getAutoSizeStepGranularity() {
        if (Jp2.c) {
            return super.getAutoSizeStepGranularity();
        }
        Mb mb = this.u;
        if (mb != null) {
            return Math.round(mb.h.c);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public final int[] getAutoSizeTextAvailableSizes() {
        if (Jp2.c) {
            return super.getAutoSizeTextAvailableSizes();
        }
        Mb mb = this.u;
        return mb != null ? mb.h.f : new int[0];
    }

    @Override // android.widget.TextView
    public final int getAutoSizeTextType() {
        if (Jp2.c) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        Mb mb = this.u;
        if (mb != null) {
            return mb.h.a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public final ActionMode.Callback getCustomSelectionActionModeCallback() {
        return F82.d(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public final int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public final int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    @Override // android.widget.TextView
    public final TextClassifier getTextClassifier() {
        Ib ib;
        if (Build.VERSION.SDK_INT >= 28 || (ib = this.v) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = ib.b;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) ib.a.getContext().getSystemService(TextClassificationManager.class);
        return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
    }

    public final Nb h() {
        if (this.y == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 34) {
                this.y = new Pb(this);
            } else if (i >= 28) {
                this.y = new Ob(this);
            } else {
                this.y = new Nb(this);
            }
        }
        return this.y;
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.u.getClass();
        if (Build.VERSION.SDK_INT < 30 && inputConnectionOnCreateInputConnection != null) {
            AbstractC0752h60.a(editorInfo, getText());
        }
        AbstractC1228ob.a(inputConnectionOnCreateInputConnection, editorInfo, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i = Build.VERSION.SDK_INT;
        if (i < 30 || i >= 33 || !onCheckIsTextEditor()) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        Mb mb = this.u;
        if (mb == null || Jp2.c) {
            return;
        }
        mb.h.a();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        Mb mb = this.u;
        if (mb == null || Jp2.c) {
            return;
        }
        Ub ub = mb.h;
        if (ub.f()) {
            ub.a();
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

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (Jp2.c) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        Mb mb = this.u;
        if (mb != null) {
            mb.g(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (Jp2.c) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        Mb mb = this.u;
        if (mb != null) {
            mb.h(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeWithDefaults(int i) {
        if (Jp2.c) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        Mb mb = this.u;
        if (mb != null) {
            mb.i(i);
        }
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
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        Mb mb = this.u;
        if (mb != null) {
            mb.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        Mb mb = this.u;
        if (mb != null) {
            mb.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        Mb mb = this.u;
        if (mb != null) {
            mb.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(F82.e(callback, this));
    }

    @Override // android.widget.TextView
    public final void setFilters(InputFilter[] inputFilterArr) {
        if (this.w == null) {
            this.w = new C1162nb(this);
        }
        super.setFilters(this.w.a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public final void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            h().a(i);
        } else {
            F82.a(this, i);
        }
    }

    @Override // android.widget.TextView
    public final void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            h().b(i);
        } else {
            F82.b(this, i);
        }
    }

    @Override // android.widget.TextView
    public final void setLineHeight(int i) {
        F82.c(this, i);
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        Mb mb = this.u;
        if (mb != null) {
            mb.f(i, context);
        }
    }

    @Override // android.widget.TextView
    public final void setTextClassifier(TextClassifier textClassifier) {
        Ib ib;
        if (Build.VERSION.SDK_INT >= 28 || (ib = this.v) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            ib.b = textClassifier;
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i, float f) {
        boolean z = Jp2.c;
        if (z) {
            super.setTextSize(i, f);
            return;
        }
        Mb mb = this.u;
        if (mb == null || z) {
            return;
        }
        Ub ub = mb.h;
        if (ub.f()) {
            return;
        }
        ub.g(i, f);
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface typeface, int i) {
        Typeface typefaceCreate;
        if (this.x) {
            return;
        }
        if (typeface == null || i <= 0) {
            typefaceCreate = null;
        } else {
            Context context = getContext();
            AbstractC0493cj2 abstractC0493cj2 = AbstractC0285Xi2.a;
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null");
            }
            typefaceCreate = Typeface.create(typeface, i);
        }
        this.x = true;
        if (typefaceCreate != null) {
            typeface = typefaceCreate;
        }
        try {
            super.setTypeface(typeface, i);
        } finally {
            this.x = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC1161na2.a(context);
        this.x = false;
        this.y = null;
        Q82.a(getContext(), this);
        Ha ha = new Ha(this);
        this.t = ha;
        ha.b(attributeSet, i);
        Mb mb = new Mb(this);
        this.u = mb;
        mb.e(attributeSet, i);
        mb.b();
        this.v = new Ib(this);
        if (this.w == null) {
            this.w = new C1162nb(this);
        }
        this.w.b(attributeSet, i);
    }

    @Override // android.widget.TextView
    public final void setLineHeight(int i, float f) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 34) {
            h().c(i, f);
        } else if (i2 >= 34) {
            D82.a(this, i, f);
        } else {
            F82.c(this, Math.round(TypedValue.applyDimension(i, f, getResources().getDisplayMetrics())));
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i != 0 ? AbstractC1686wb.a(i, context) : null, i2 != 0 ? AbstractC1686wb.a(i2, context) : null, i3 != 0 ? AbstractC1686wb.a(i3, context) : null, i4 != 0 ? AbstractC1686wb.a(i4, context) : null);
        Mb mb = this.u;
        if (mb != null) {
            mb.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i != 0 ? AbstractC1686wb.a(i, context) : null, i2 != 0 ? AbstractC1686wb.a(i2, context) : null, i3 != 0 ? AbstractC1686wb.a(i3, context) : null, i4 != 0 ? AbstractC1686wb.a(i4, context) : null);
        Mb mb = this.u;
        if (mb != null) {
            mb.b();
        }
    }
}
