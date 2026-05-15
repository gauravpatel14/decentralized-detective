package defpackage;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: renamed from: z81, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1816z81 extends AF0 {
    public final /* synthetic */ A81 q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1816z81(A81 a81, Context context) {
        super(context);
        this.q = a81;
    }

    @Override // defpackage.AF0
    public final float d(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // defpackage.AF0
    public final int e(int i) {
        return Math.min(100, super.e(i));
    }

    @Override // defpackage.AF0
    public final void h(View view, ks1 ks1Var) {
        A81 a81 = this.q;
        int[] iArrB = a81.b(a81.a.G, view);
        int i = iArrB[0];
        int i2 = iArrB[1];
        int iCeil = (int) Math.ceil(((double) e(Math.max(Math.abs(i), Math.abs(i2)))) / 0.3356d);
        if (iCeil > 0) {
            DecelerateInterpolator decelerateInterpolator = this.j;
            ks1Var.a = i;
            ks1Var.b = i2;
            ks1Var.c = iCeil;
            ks1Var.e = decelerateInterpolator;
            ks1Var.f = true;
        }
    }
}
