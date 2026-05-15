package defpackage;

import android.animation.ObjectAnimator;
import org.chromium.ui.modelutil.PropertyModel;

/* JADX INFO: renamed from: Zm1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0318Zm1 {
    public static ObjectAnimator a(PropertyModel propertyModel, C0223Sm1 c0223Sm1, float f) {
        return ObjectAnimator.ofFloat(propertyModel, new C0304Ym1(c0223Sm1), f);
    }
}
