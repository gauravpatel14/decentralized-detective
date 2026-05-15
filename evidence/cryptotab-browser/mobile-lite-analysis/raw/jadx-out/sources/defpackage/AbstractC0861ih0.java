package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: ih0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0861ih0 {
    public static final MJ0 a = new MJ0(16);
    public static final ThreadPoolExecutor b;
    public static final Object c;
    public static final UJ1 d;

    static {
        Gu1 gu1 = new Gu1();
        gu1.a = "fonts-androidx";
        gu1.b = 10;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), gu1);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        b = threadPoolExecutor;
        c = new Object();
        d = new UJ1(0);
    }

    public static C0795hh0 a(String str, Context context, C0599eh0 c0599eh0, int i) {
        MJ0 mj0 = a;
        Typeface typeface = (Typeface) mj0.b(str);
        if (typeface != null) {
            return new C0795hh0(typeface);
        }
        try {
            C1231oh0 c1231oh0A = AbstractC0543dh0.a(context, c0599eh0);
            int i2 = 1;
            C1289ph0[] c1289ph0Arr = c1231oh0A.b;
            int i3 = c1231oh0A.a;
            if (i3 != 0) {
                i2 = i3 != 1 ? -3 : -2;
            } else if (c1289ph0Arr != null && c1289ph0Arr.length != 0) {
                int length = c1289ph0Arr.length;
                i2 = 0;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        break;
                    }
                    int i5 = c1289ph0Arr[i4].e;
                    if (i5 == 0) {
                        i4++;
                    } else if (i5 >= 0) {
                        i2 = i5;
                    }
                }
            }
            if (i2 != 0) {
                return new C0795hh0(i2);
            }
            Typeface typefaceB = AbstractC0285Xi2.a.b(context, c1289ph0Arr, i);
            if (typefaceB == null) {
                return new C0795hh0(-3);
            }
            mj0.c(str, typefaceB);
            return new C0795hh0(typefaceB);
        } catch (PackageManager.NameNotFoundException unused) {
            return new C0795hh0(-1);
        }
    }
}
