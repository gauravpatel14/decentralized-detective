package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: Ta, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0231Ta {
    public static final Ra t = new Ra(new Sa());
    public static int u = -100;
    public static TH0 v = null;
    public static TH0 w = null;
    public static Boolean x = null;
    public static boolean y = false;
    public static final C0978kf z = new C0978kf(0);
    public static final Object A = new Object();
    public static final Object B = new Object();

    public static boolean e(Context context) {
        if (x == null) {
            try {
                int i = Oc.t;
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) Oc.class), 640).metaData;
                if (bundle != null) {
                    x = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                x = Boolean.FALSE;
            }
        }
        return x.booleanValue();
    }

    public static void h(LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb) {
        synchronized (A) {
            try {
                C0978kf c0978kf = z;
                c0978kf.getClass();
                C0917jf c0917jf = new C0917jf(c0978kf);
                while (c0917jf.hasNext()) {
                    AbstractC0231Ta abstractC0231Ta = (AbstractC0231Ta) ((WeakReference) c0917jf.next()).get();
                    if (abstractC0231Ta == layoutInflaterFactory2C0658fb || abstractC0231Ta == null) {
                        c0917jf.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void m(int i) {
        if ((i == -1 || i == 0 || i == 1 || i == 2 || i == 3) && u != i) {
            u = i;
            synchronized (A) {
                try {
                    C0978kf c0978kf = z;
                    c0978kf.getClass();
                    C0917jf c0917jf = new C0917jf(c0978kf);
                    while (c0917jf.hasNext()) {
                        AbstractC0231Ta abstractC0231Ta = (AbstractC0231Ta) ((WeakReference) c0917jf.next()).get();
                        if (abstractC0231Ta != null) {
                            ((LayoutInflaterFactory2C0658fb) abstractC0231Ta).o(true, true);
                        }
                    }
                } finally {
                }
            }
        }
    }

    public abstract void c();

    public abstract void d();

    public abstract void f();

    public abstract void g();

    public abstract boolean i(int i);

    public abstract void j(int i);

    public abstract void k(View view);

    public abstract void l(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void n(CharSequence charSequence);
}
