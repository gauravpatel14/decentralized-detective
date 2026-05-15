package defpackage;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class s9 extends Drawable.ConstantState {
    public final Drawable.ConstantState a;

    public s9(Drawable.ConstantState constantState) {
        this.a = constantState;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final boolean canApplyTheme() {
        return this.a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        t9 t9Var = new t9(null);
        Drawable drawableNewDrawable = this.a.newDrawable();
        t9Var.t = drawableNewDrawable;
        drawableNewDrawable.setCallback(t9Var.y);
        return t9Var;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        t9 t9Var = new t9(null);
        Drawable drawableNewDrawable = this.a.newDrawable(resources);
        t9Var.t = drawableNewDrawable;
        drawableNewDrawable.setCallback(t9Var.y);
        return t9Var;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
        t9 t9Var = new t9(null);
        Drawable drawableNewDrawable = this.a.newDrawable(resources, theme);
        t9Var.t = drawableNewDrawable;
        drawableNewDrawable.setCallback(t9Var.y);
        return t9Var;
    }
}
