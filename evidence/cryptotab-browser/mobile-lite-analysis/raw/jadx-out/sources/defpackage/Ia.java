package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class Ia extends Button {
    public final Ha t;
    public final Mb u;
    public C1162nb v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ia(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC1161na2.a(context);
        Q82.a(getContext(), this);
        Ha ha = new Ha(this);
        this.t = ha;
        ha.b(attributeSet, i);
        Mb mb = new Mb(this);
        this.u = mb;
        mb.e(attributeSet, i);
        mb.b();
        if (this.v == null) {
            this.v = new C1162nb(this);
        }
        this.v.b(attributeSet, i);
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

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        Mb mb = this.u;
        if (mb == null || Jp2.c) {
            return;
        }
        mb.h.a();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
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
        if (this.v == null) {
            this.v = new C1162nb(this);
        }
        this.v.c(z);
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
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        Ha ha = this.t;
        if (ha != null) {
            ha.c();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        Ha ha = this.t;
        if (ha != null) {
            ha.d(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(F82.e(callback, this));
    }

    @Override // android.widget.TextView
    public final void setFilters(InputFilter[] inputFilterArr) {
        if (this.v == null) {
            this.v = new C1162nb(this);
        }
        super.setFilters(this.v.a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        Mb mb = this.u;
        if (mb != null) {
            mb.f(i, context);
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
}
