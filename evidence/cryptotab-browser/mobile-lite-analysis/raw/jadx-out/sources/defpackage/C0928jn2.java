package defpackage;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;

/* JADX INFO: renamed from: jn2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0928jn2 extends Drawable.ConstantState {
    public final Drawable.ConstantState a;

    public C0928jn2(Drawable.ConstantState constantState) {
        this.a = constantState;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final boolean canApplyTheme() {
        return this.a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        C0989kn2 c0989kn2 = new C0989kn2();
        c0989kn2.t = (VectorDrawable) this.a.newDrawable();
        return c0989kn2;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        C0989kn2 c0989kn2 = new C0989kn2();
        c0989kn2.t = (VectorDrawable) this.a.newDrawable(resources);
        return c0989kn2;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
        C0989kn2 c0989kn2 = new C0989kn2();
        c0989kn2.t = (VectorDrawable) this.a.newDrawable(resources, theme);
        return c0989kn2;
    }
}
