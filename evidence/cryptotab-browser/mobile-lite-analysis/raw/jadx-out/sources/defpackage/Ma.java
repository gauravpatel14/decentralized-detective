package defpackage;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Ma {
    public final La a;
    public final boolean b = false;
    public final boolean c = false;
    public boolean d;

    public Ma(La la) {
        this.a = la;
    }

    public final void a() {
        La la = this.a;
        Drawable checkMarkDrawable = la.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.b || this.c) {
                Drawable drawableMutate = checkMarkDrawable.mutate();
                if (this.b) {
                    drawableMutate.setTintList(null);
                }
                if (this.c) {
                    drawableMutate.setTintMode(null);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(la.getDrawableState());
                }
                la.setCheckMarkDrawable(drawableMutate);
            }
        }
    }
}
