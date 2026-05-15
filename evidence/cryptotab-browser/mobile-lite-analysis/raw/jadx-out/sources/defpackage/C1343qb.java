package defpackage;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: renamed from: qb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1343qb {
    public final ImageView a;
    public int b = 0;

    public C1343qb(ImageView imageView) {
        this.a = imageView;
    }

    public final void a() {
        Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            J30.a(drawable);
        }
    }

    public final void b(AttributeSet attributeSet, int i) {
        int resourceId;
        ImageView imageView = this.a;
        C1342qa2 c1342qa2F = C1342qa2.f(imageView.getContext(), attributeSet, AbstractC0305Yp1.AppCompatImageView, i);
        AbstractC0604eo2.n(imageView, imageView.getContext(), AbstractC0305Yp1.AppCompatImageView, attributeSet, c1342qa2F.b, i, 0);
        try {
            Drawable drawable = imageView.getDrawable();
            TypedArray typedArray = c1342qa2F.b;
            if (drawable == null && (resourceId = typedArray.getResourceId(AbstractC0305Yp1.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = AbstractC1686wb.a(resourceId, imageView.getContext())) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                J30.a(drawable);
            }
            if (typedArray.hasValue(AbstractC0305Yp1.AppCompatImageView_tint)) {
                imageView.setImageTintList(c1342qa2F.a(AbstractC0305Yp1.AppCompatImageView_tint));
            }
            if (typedArray.hasValue(AbstractC0305Yp1.AppCompatImageView_tintMode)) {
                imageView.setImageTintMode(J30.c(typedArray.getInt(AbstractC0305Yp1.AppCompatImageView_tintMode, -1), null));
            }
            c1342qa2F.g();
        } catch (Throwable th) {
            c1342qa2F.g();
            throw th;
        }
    }
}
