package org.chromium.ui.gfx;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import defpackage.AbstractC1499tM;
import defpackage.ComponentCallbacksC0804ho2;
import defpackage.Hp1;
import defpackage.LP1;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ViewConfigurationHelper {
    public ViewConfiguration a;
    public float b;

    public static ViewConfigurationHelper createWithListener() {
        ViewConfigurationHelper viewConfigurationHelper = new ViewConfigurationHelper();
        LP1 lp1B = LP1.b();
        try {
            viewConfigurationHelper.a = ViewConfiguration.get(AbstractC1499tM.a);
            lp1B.close();
            viewConfigurationHelper.b = AbstractC1499tM.a.getResources().getDisplayMetrics().density;
            AbstractC1499tM.a.registerComponentCallbacks(new ComponentCallbacksC0804ho2(viewConfigurationHelper));
            return viewConfigurationHelper;
        } catch (Throwable th) {
            try {
                lp1B.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    public static int getDoubleTapTimeout() {
        return ViewConfiguration.getDoubleTapTimeout();
    }

    public static int getLongPressTimeout() {
        return ViewConfiguration.getLongPressTimeout();
    }

    public static int getTapTimeout() {
        return ViewConfiguration.getTapTimeout();
    }

    public final float getDoubleTapSlop() {
        return this.a.getScaledDoubleTapSlop() / this.b;
    }

    public final float getMaximumFlingVelocity() {
        return this.a.getScaledMaximumFlingVelocity() / this.b;
    }

    public final float getMinScalingSpan() {
        int iApplyDimension;
        Resources resources = AbstractC1499tM.a.getResources();
        try {
            iApplyDimension = resources.getDimensionPixelSize(Hp1.config_min_scaling_span);
        } catch (Resources.NotFoundException unused) {
            iApplyDimension = (int) TypedValue.applyDimension(5, 12.0f, resources.getDisplayMetrics());
        }
        return iApplyDimension / this.b;
    }

    public final float getMinimumFlingVelocity() {
        return this.a.getScaledMinimumFlingVelocity() / this.b;
    }

    public final float getTouchSlop() {
        return this.a.getScaledTouchSlop() / this.b;
    }
}
