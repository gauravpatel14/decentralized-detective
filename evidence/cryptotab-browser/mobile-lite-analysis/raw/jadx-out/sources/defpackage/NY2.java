package defpackage;

import java.security.AccessController;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NY2 {
    public static final Unsafe a;
    public static final Class b;
    public static final MY2 c;
    public static final boolean d;
    public static final boolean e;
    public static final long f;
    public static final boolean g;

    /* JADX WARN: Removed duplicated region for block: B:11:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0141 A[PHI: r0
      0x0141: PHI (r0v24 java.lang.reflect.Field) = (r0v18 java.lang.reflect.Field), (r0v20 java.lang.reflect.Field) binds: [B:43:0x012f, B:49:0x013f] A[DONT_GENERATE, DONT_INLINE]] */
    static {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.NY2.<clinit>():void");
    }

    public static void a(Class cls) {
        if (e) {
            c.i(cls);
        }
    }

    public static void b(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        MY2 my2 = c;
        int iJ = my2.j(j2, obj);
        int i = ((~((int) j)) & 3) << 3;
        my2.n(((255 & b2) << i) | (iJ & (~(255 << i))), j2, obj);
    }

    public static void c(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        MY2 my2 = c;
        int i = (((int) j) & 3) << 3;
        my2.n(((255 & b2) << i) | (my2.j(j2, obj) & (~(255 << i))), j2, obj);
    }

    public static double d(long j, Object obj) {
        return c.a(j, obj);
    }

    public static float e(long j, Object obj) {
        return c.b(j, obj);
    }

    public static int f(long j, Object obj) {
        return c.j(j, obj);
    }

    public static long g(long j, Object obj) {
        return c.k(j, obj);
    }

    public static Object h(Class cls) {
        try {
            return a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static Object i(long j, Object obj) {
        return c.m(j, obj);
    }

    public static Unsafe j() {
        try {
            return (Unsafe) AccessController.doPrivileged(new JY2());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void k(Object obj, long j, boolean z) {
        c.c(obj, j, z);
    }

    public static void l(Object obj, long j, double d2) {
        c.e(obj, j, d2);
    }

    public static void m(float f2, long j, Object obj) {
        c.f(f2, j, obj);
    }

    public static void n(AbstractC1852zW2 abstractC1852zW2, long j, int i) {
        c.n(i, j, abstractC1852zW2);
    }

    public static void o(long j, Object obj, Object obj2) {
        c.p(j, obj, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean p(long j, Object obj) {
        return ((byte) ((c.j((-4) & j, obj) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean q(long j, Object obj) {
        return ((byte) ((c.j((-4) & j, obj) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    public static boolean r(Class cls) {
        int i = FU2.a;
        try {
            Class cls2 = b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean s(long j, Object obj) {
        return c.g(j, obj);
    }

    public static int t(Class cls) {
        if (e) {
            return c.h(cls);
        }
        return -1;
    }
}
