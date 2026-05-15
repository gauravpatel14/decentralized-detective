package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import defpackage.C0942kA2;
import defpackage.C1068mA2;
import defpackage.C1254pA2;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class zae extends zag {
    private final WeakReference zac;

    public zae(ImageView imageView, int i) {
        super(Uri.EMPTY, i);
        Asserts.checkNotNull(imageView);
        this.zac = new WeakReference(imageView);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zae)) {
            return false;
        }
        ImageView imageView = (ImageView) this.zac.get();
        ImageView imageView2 = (ImageView) ((zae) obj).zac.get();
        return (imageView2 == null || imageView == null || !Objects.equal(imageView2, imageView)) ? false : true;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // com.google.android.gms.common.images.zag
    public final void zaa(Drawable drawable, boolean z, boolean z2, boolean z3) {
        ImageView imageView = (ImageView) this.zac.get();
        if (imageView != null) {
            boolean z4 = (z2 || z) ? false : true;
            if (z4) {
                Drawable drawable2 = imageView.getDrawable();
                if (drawable2 == null) {
                    drawable2 = null;
                } else if (drawable2 instanceof C1254pA2) {
                    drawable2 = ((C1254pA2) drawable2).D;
                }
                C1254pA2 c1254pA2 = new C1254pA2(null);
                if (drawable2 == null) {
                    drawable2 = C0942kA2.a;
                }
                c1254pA2.C = drawable2;
                drawable2.setCallback(c1254pA2);
                C1068mA2 c1068mA2 = c1254pA2.B;
                c1068mA2.b = drawable2.getChangingConfigurations() | c1068mA2.b;
                if (drawable == null) {
                    drawable = C0942kA2.a;
                }
                c1254pA2.D = drawable;
                drawable.setCallback(c1254pA2);
                C1068mA2 c1068mA22 = c1254pA2.B;
                c1068mA22.b = drawable.getChangingConfigurations() | c1068mA22.b;
                drawable = c1254pA2;
            }
            imageView.setImageDrawable(drawable);
            if (drawable == null || !z4) {
                return;
            }
            C1254pA2 c1254pA22 = (C1254pA2) drawable;
            c1254pA22.v = c1254pA22.w;
            c1254pA22.y = 0;
            c1254pA22.x = 250;
            c1254pA22.t = 1;
            c1254pA22.invalidateSelf();
        }
    }

    public zae(ImageView imageView, Uri uri) {
        super(uri, 0);
        Asserts.checkNotNull(imageView);
        this.zac = new WeakReference(imageView);
    }
}
