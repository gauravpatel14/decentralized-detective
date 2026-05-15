package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class t9 extends AbstractC0437bn2 implements InterfaceC0820i9 {
    public static final /* synthetic */ int z = 0;
    public final Context v;
    public C1308q9 w = null;
    public ArrayList x = null;
    public final C1251p9 y = new C1251p9(this);
    public final C1364r9 u = new C1364r9();

    public t9(Context context) {
        this.v = context;
    }

    public static t9 a(int i, Context context) {
        t9 t9Var = new t9(context);
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        ThreadLocal threadLocal = kv1.a;
        Drawable drawable = resources.getDrawable(i, theme);
        drawable.setCallback(t9Var.y);
        new s9(drawable.getConstantState());
        t9Var.t = drawable;
        return t9Var;
    }

    @Override // defpackage.AbstractC0437bn2, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.applyTheme(theme);
        }
    }

    public final void b(AbstractC0754h9 abstractC0754h9) {
        if (abstractC0754h9 == null) {
            return;
        }
        Drawable drawable = this.t;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).registerAnimationCallback(abstractC0754h9.a());
            return;
        }
        if (this.x == null) {
            this.x = new ArrayList();
        }
        if (this.x.contains(abstractC0754h9)) {
            return;
        }
        this.x.add(abstractC0754h9);
        if (this.w == null) {
            this.w = new C1308q9(this);
        }
        this.u.b.addListener(this.w);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.t;
        if (drawable != null) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        C1364r9 c1364r9 = this.u;
        c1364r9.a.draw(canvas);
        if (c1364r9.b.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.t;
        return drawable != null ? drawable.getAlpha() : this.u.a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.t;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        int changingConfigurations = super.getChangingConfigurations();
        this.u.getClass();
        return changingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.t;
        return drawable != null ? drawable.getColorFilter() : this.u.a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.t != null) {
            return new s9(this.t.getConstantState());
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.t;
        return drawable != null ? drawable.getIntrinsicHeight() : this.u.a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.t;
        return drawable != null ? drawable.getIntrinsicWidth() : this.u.a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.t;
        return drawable != null ? drawable.getOpacity() : this.u.a.getOpacity();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00bf, code lost:
    
        if (r3.b != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c1, code lost:
    
        r3.b = new android.animation.AnimatorSet();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c8, code lost:
    
        r3.b.playTogether(r3.c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cf, code lost:
    
        return;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void inflate(android.content.res.Resources r9, org.xmlpull.v1.XmlPullParser r10, android.util.AttributeSet r11, android.content.res.Resources.Theme r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.t9.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.t;
        return drawable != null ? drawable.isAutoMirrored() : this.u.a.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        Drawable drawable = this.t;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.u.b.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.t;
        return drawable != null ? drawable.isStateful() : this.u.a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.u.a.setBounds(rect);
        }
    }

    @Override // defpackage.AbstractC0437bn2, android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        Drawable drawable = this.t;
        return drawable != null ? drawable.setLevel(i) : this.u.a.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.t;
        return drawable != null ? drawable.setState(iArr) : this.u.a.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.u.a.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z2) {
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.setAutoMirrored(z2);
        } else {
            this.u.a.setAutoMirrored(z2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.u.a.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        Drawable drawable = this.t;
        if (drawable != null) {
            C30.a(drawable, i);
        } else {
            this.u.a.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        } else {
            this.u.a.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.setTintMode(mode);
        } else {
            this.u.a.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z2, boolean z3) {
        Drawable drawable = this.t;
        if (drawable != null) {
            return drawable.setVisible(z2, z3);
        }
        this.u.a.setVisible(z2, z3);
        return super.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable drawable = this.t;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
            return;
        }
        C1364r9 c1364r9 = this.u;
        if (c1364r9.b.isStarted()) {
            return;
        }
        c1364r9.b.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable drawable = this.t;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.u.b.end();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
