package defpackage;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class F01 {
    public final boolean A;
    public final Notification B;
    public boolean C;
    public Icon D;
    public final ArrayList E;
    public final Context a;
    public CharSequence e;
    public CharSequence f;
    public PendingIntent g;
    public IconCompat h;
    public int i;
    public int j;
    public H01 l;
    public CharSequence m;
    public int n;
    public int o;
    public boolean p;
    public String q;
    public boolean r;
    public String t;
    public Bundle u;
    public Notification x;
    public String y;
    public long z;
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();
    public final ArrayList d = new ArrayList();
    public boolean k = true;
    public boolean s = false;
    public int v = 0;
    public int w = 0;

    public F01(Context context, String str) {
        Notification notification = new Notification();
        this.B = notification;
        this.a = context;
        this.y = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.j = 0;
        this.E = new ArrayList();
        this.A = true;
    }

    public static CharSequence b(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public final Notification a() {
        Bundle bundle;
        L01 l01 = new L01(this);
        F01 f01 = l01.c;
        H01 h01 = f01.l;
        if (h01 != null) {
            h01.a(l01);
        }
        Notification notificationBuild = l01.b.build();
        if (h01 != null) {
            f01.l.getClass();
        }
        if (h01 != null && (bundle = notificationBuild.extras) != null) {
            if (h01.c) {
                bundle.putCharSequence("android.summaryText", h01.b);
            }
            String strB = h01.b();
            if (strB != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", strB);
            }
        }
        return notificationBuild;
    }

    public final void c(boolean z) {
        g(16, z);
    }

    public final void d(CharSequence charSequence) {
        this.f = b(charSequence);
    }

    public final void e(CharSequence charSequence) {
        this.e = b(charSequence);
    }

    public final void f(int i) {
        Notification notification = this.B;
        notification.defaults = i;
        if ((i & 4) != 0) {
            notification.flags |= 1;
        }
    }

    public final void g(int i, boolean z) {
        Notification notification = this.B;
        if (z) {
            notification.flags = i | notification.flags;
        } else {
            notification.flags = (~i) & notification.flags;
        }
    }

    public final void h(Bitmap bitmap) {
        IconCompat iconCompat;
        if (bitmap == null) {
            iconCompat = null;
        } else {
            if (Build.VERSION.SDK_INT < 27) {
                Resources resources = this.a.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(Hp1.compat_notification_large_icon_max_width);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(Hp1.compat_notification_large_icon_max_height);
                if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                    double dMin = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
                    bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * dMin), (int) Math.ceil(((double) bitmap.getHeight()) * dMin), true);
                }
            }
            PorterDuff.Mode mode = IconCompat.k;
            bitmap.getClass();
            IconCompat iconCompat2 = new IconCompat(1);
            iconCompat2.b = bitmap;
            iconCompat = iconCompat2;
        }
        this.h = iconCompat;
    }

    public final void i(H01 h01) {
        if (this.l != h01) {
            this.l = h01;
            if (h01 == null || h01.a == this) {
                return;
            }
            h01.a = this;
            i(h01);
        }
    }
}
