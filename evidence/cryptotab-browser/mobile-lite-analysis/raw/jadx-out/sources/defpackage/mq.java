package defpackage;

import android.graphics.Bitmap;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.chromium.base.SysUtils;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class mq {
    public static final HashMap d = new HashMap();
    public static int e;
    public final int a;
    public QZ b;
    public final RZ c;

    public mq(RZ rz, int i) {
        this.c = rz;
        this.a = i;
        this.b = rz.a(new C1051lq(i));
    }

    public final Bitmap a(String str) {
        if (this.b == null) {
            return null;
        }
        Bitmap bitmap = (Bitmap) b().b(str);
        int i = e + 1;
        e = i;
        if (i >= d.size()) {
            e = 0;
            Looper.myQueue().addIdleHandler(new kq());
        }
        return bitmap;
    }

    public final C1051lq b() {
        C1051lq c1051lq = (C1051lq) this.b.a;
        if (c1051lq != null) {
            return c1051lq;
        }
        C1051lq c1051lq2 = new C1051lq(this.a);
        this.b = this.c.a(c1051lq2);
        return c1051lq2;
    }

    public final void c(String str, Bitmap bitmap) {
        if (bitmap == null || this.b == null) {
            return;
        }
        if (!SysUtils.isLowEndDevice()) {
            b().c(str, bitmap);
        }
        int i = e + 1;
        e = i;
        if (i >= d.size()) {
            e = 0;
            Looper.myQueue().addIdleHandler(new kq());
        }
        d.put(str, new WeakReference(bitmap));
    }
}
