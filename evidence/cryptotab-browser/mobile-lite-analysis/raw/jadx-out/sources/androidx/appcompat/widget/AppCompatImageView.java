package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import defpackage.AbstractC1161na2;
import defpackage.AbstractC1686wb;
import defpackage.C1343qb;
import defpackage.Ha;
import defpackage.J30;
import defpackage.Q82;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatImageView extends ImageView {
    public final Ha t;
    public final C1343qb u;
    public boolean v;

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Ha ha = this.t;
        if (ha != null) {
            ha.a();
        }
        C1343qb c1343qb = this.u;
        if (c1343qb != null) {
            c1343qb.a();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return !(this.u.a.getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public final void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        Ha ha = this.t;
        if (ha != null) {
            ha.c();
        }
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        Ha ha = this.t;
        if (ha != null) {
            ha.d(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C1343qb c1343qb = this.u;
        if (c1343qb != null) {
            c1343qb.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        C1343qb c1343qb = this.u;
        if (c1343qb != null && drawable != null && !this.v) {
            c1343qb.b = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (c1343qb != null) {
            c1343qb.a();
            if (this.v) {
                return;
            }
            ImageView imageView = c1343qb.a;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(c1343qb.b);
            }
        }
    }

    @Override // android.widget.ImageView
    public final void setImageLevel(int i) {
        super.setImageLevel(i);
        this.v = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        C1343qb c1343qb = this.u;
        if (c1343qb != null) {
            ImageView imageView = c1343qb.a;
            if (i != 0) {
                Drawable drawableA = AbstractC1686wb.a(i, imageView.getContext());
                if (drawableA != null) {
                    J30.a(drawableA);
                }
                imageView.setImageDrawable(drawableA);
            } else {
                imageView.setImageDrawable(null);
            }
            c1343qb.a();
        }
    }

    @Override // android.widget.ImageView
    public final void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C1343qb c1343qb = this.u;
        if (c1343qb != null) {
            c1343qb.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC1161na2.a(context);
        this.v = false;
        Q82.a(getContext(), this);
        Ha ha = new Ha(this);
        this.t = ha;
        ha.b(attributeSet, i);
        C1343qb c1343qb = new C1343qb(this);
        this.u = c1343qb;
        c1343qb.b(attributeSet, i);
    }
}
