package org.chromium.ui.widget;

import android.R;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import defpackage.AbstractC0084Gp1;
import defpackage.AbstractC0292Xp1;
import defpackage.AbstractC0305Yp1;
import defpackage.Hp1;
import defpackage.Ia;
import defpackage.U3;
import defpackage.kw1;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ButtonCompat extends Ia {
    public final kw1 w;

    public ButtonCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC0292Xp1.FilledButtonThemeOverlay);
    }

    public ButtonCompat(Context context, AttributeSet attributeSet, int i) {
        float[] fArr;
        super(new ContextThemeWrapper(context, i), attributeSet, R.attr.buttonStyle);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC0305Yp1.ButtonCompat, R.attr.buttonStyle, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(AbstractC0305Yp1.ButtonCompat_buttonColor, AbstractC0084Gp1.blue_when_enabled_list);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(AbstractC0305Yp1.ButtonCompat_rippleColor, -1);
        int i2 = resourceId2 == -1 ? getContext().getColor(resourceId) == 0 ? AbstractC0084Gp1.text_button_ripple_color_list_baseline : AbstractC0084Gp1.filled_button_ripple_color : resourceId2;
        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(AbstractC0305Yp1.ButtonCompat_borderColor, R.color.transparent);
        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(AbstractC0305Yp1.ButtonCompat_borderWidth, Hp1.default_ripple_background_border_size);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(AbstractC0305Yp1.ButtonCompat_buttonRaised, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC0305Yp1.ButtonCompat_verticalInset, getResources().getDimensionPixelSize(Hp1.button_bg_vertical_inset));
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(Hp1.button_compat_corner_radius);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC0305Yp1.ButtonCompat_rippleCornerRadiusTopStart, dimensionPixelSize2);
        int dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC0305Yp1.ButtonCompat_rippleCornerRadiusTopEnd, dimensionPixelSize2);
        int dimensionPixelSize5 = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC0305Yp1.ButtonCompat_rippleCornerRadiusBottomStart, dimensionPixelSize2);
        int dimensionPixelSize6 = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC0305Yp1.ButtonCompat_rippleCornerRadiusBottomEnd, dimensionPixelSize2);
        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(AbstractC0305Yp1.ButtonCompat_buttonTextColor, -1);
        if (resourceId5 != -1) {
            setTextColor(U3.b(resourceId5, getContext()));
        }
        if (getLayoutDirection() == 1) {
            float f = dimensionPixelSize4;
            float f2 = dimensionPixelSize3;
            float f3 = dimensionPixelSize5;
            float f4 = dimensionPixelSize6;
            fArr = new float[]{f, f, f2, f2, f3, f3, f4, f4};
        } else {
            float f5 = dimensionPixelSize3;
            float f6 = dimensionPixelSize4;
            float f7 = dimensionPixelSize6;
            float f8 = dimensionPixelSize5;
            fArr = new float[]{f5, f5, f6, f6, f7, f7, f8, f8};
        }
        float[] fArr2 = fArr;
        typedArrayObtainStyledAttributes.recycle();
        this.w = new kw1(this, resourceId, i2, fArr2, resourceId3, resourceId4, dimensionPixelSize);
        if (!z) {
            setElevation(0.0f);
            setStateListAnimator(null);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(null, new int[]{R.attr.stateListAnimator}, 0, R.style.Widget.Material.Button);
            int resourceId6 = typedArrayObtainStyledAttributes2.getResourceId(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            setStateListAnimator(resourceId6 != 0 ? AnimatorInflater.loadStateListAnimator(getContext(), resourceId6) : null);
        }
    }
}
