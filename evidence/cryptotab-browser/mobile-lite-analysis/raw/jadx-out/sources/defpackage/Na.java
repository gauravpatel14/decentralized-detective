package defpackage;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Na {
    public final CompoundButton a;
    public PorterDuff.Mode b = null;
    public boolean c = false;
    public boolean d = false;
    public boolean e;

    public Na(CompoundButton compoundButton) {
        this.a = compoundButton;
    }

    public final void a() {
        CompoundButton compoundButton = this.a;
        Drawable buttonDrawable = compoundButton.getButtonDrawable();
        if (buttonDrawable != null) {
            if (this.c || this.d) {
                Drawable drawableMutate = buttonDrawable.mutate();
                if (this.c) {
                    drawableMutate.setTintList(null);
                }
                if (this.d) {
                    drawableMutate.setTintMode(this.b);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(drawableMutate);
            }
        }
    }

    public final void b(AttributeSet attributeSet, int i) {
        int resourceId;
        int resourceId2;
        CompoundButton compoundButton = this.a;
        C1342qa2 c1342qa2F = C1342qa2.f(compoundButton.getContext(), attributeSet, AbstractC0305Yp1.CompoundButton, i);
        TypedArray typedArray = c1342qa2F.b;
        AbstractC0604eo2.n(compoundButton, compoundButton.getContext(), AbstractC0305Yp1.CompoundButton, attributeSet, c1342qa2F.b, i, 0);
        try {
            if (typedArray.hasValue(AbstractC0305Yp1.CompoundButton_buttonCompat) && (resourceId2 = typedArray.getResourceId(AbstractC0305Yp1.CompoundButton_buttonCompat, 0)) != 0) {
                try {
                    compoundButton.setButtonDrawable(AbstractC1686wb.a(resourceId2, compoundButton.getContext()));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(AbstractC0305Yp1.CompoundButton_android_button)) {
                        compoundButton.setButtonDrawable(AbstractC1686wb.a(resourceId, compoundButton.getContext()));
                    }
                }
            } else if (typedArray.hasValue(AbstractC0305Yp1.CompoundButton_android_button) && (resourceId = typedArray.getResourceId(AbstractC0305Yp1.CompoundButton_android_button, 0)) != 0) {
                compoundButton.setButtonDrawable(AbstractC1686wb.a(resourceId, compoundButton.getContext()));
            }
            if (typedArray.hasValue(AbstractC0305Yp1.CompoundButton_buttonTint)) {
                compoundButton.setButtonTintList(c1342qa2F.a(AbstractC0305Yp1.CompoundButton_buttonTint));
            }
            if (typedArray.hasValue(AbstractC0305Yp1.CompoundButton_buttonTintMode)) {
                compoundButton.setButtonTintMode(J30.c(typedArray.getInt(AbstractC0305Yp1.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            c1342qa2F.g();
        }
    }
}
