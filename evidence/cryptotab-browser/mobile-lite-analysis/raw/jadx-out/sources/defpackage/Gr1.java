package defpackage;

import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Gr1 {
    public static int a(long j) {
        if (j > 2147483647L) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    public static void b(String str, boolean z) {
        Aj2.a.a(1, str, z ? 1 : 0, 0, 0, 0);
    }

    public static void c(int i, String str) {
        Aj2.a.a(2, str, i, 1, 1000, 50);
    }

    public static void d(int i, String str) {
        Aj2.a.a(2, str, i, 1, 100, 50);
    }

    public static void e(int i, String str) {
        Aj2.a.a(2, str, i, 1, 1000000, 50);
    }

    public static void f(int i, int i2, int i3, int i4, String str) {
        Aj2.a.a(2, str, i, i2, i3, i4);
    }

    public static void g(String str, long j, long j2, long j3, int i) {
        Aj2.a.a(2, str, a(j), a(j2), a(j3), i);
    }

    public static void h(int i, int i2, String str) {
        Aj2.a.a(3, str, i, 1, i2, i2 + 1);
    }

    public static void i(int i, int i2, int i3, int i4, String str) {
        Aj2.a.a(3, str, i, i2, i3, i4);
    }

    public static void j(long j, String str) {
        g(str, j, 1L, 3600000L, 50);
    }

    public static void k(long j, String str) {
        g(str, j, 10L, 180000L, 50);
    }

    public static void l(int i, String str) {
        h(i, 101, str);
    }

    public static void m(int i, String str) {
        Aj2.a.a(4, str, i, 0, 0, 0);
    }

    public static void n(long j, String str) {
        g(str, j, 1L, 10000L, 50);
    }
}
