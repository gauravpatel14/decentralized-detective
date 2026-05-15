package defpackage;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import sun.misc.Unsafe;

/* JADX INFO: renamed from: vk2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1633vk2 {
    public static final Unsafe a;
    public static final AbstractC1577uk2 b;
    public static final boolean c;
    public static final boolean d;
    public static final long e;
    public static final long f;
    public static final boolean g;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Object[] objArr = 0;
        int i = 1;
        Unsafe unsafeL = l();
        a = unsafeL;
        Class cls = AbstractC1541u7.a;
        boolean zE = e(Long.TYPE);
        boolean zE2 = e(Integer.TYPE);
        AbstractC1577uk2 c1525tk2 = null;
        if (unsafeL != null) {
            if (!AbstractC1541u7.a()) {
                c1525tk2 = new C1525tk2(unsafeL);
            } else if (zE) {
                c1525tk2 = new C1466sk2(unsafeL, i);
            } else if (zE2) {
                c1525tk2 = new C1466sk2(unsafeL, objArr == true ? 1 : 0);
            }
        }
        b = c1525tk2;
        c = c1525tk2 == null ? false : c1525tk2.u();
        d = c1525tk2 == null ? false : c1525tk2.t();
        e = b(byte[].class);
        b(boolean[].class);
        c(boolean[].class);
        b(int[].class);
        c(int[].class);
        b(long[].class);
        c(long[].class);
        b(float[].class);
        c(float[].class);
        b(double[].class);
        c(double[].class);
        b(Object[].class);
        c(Object[].class);
        Field fieldD = d();
        f = (fieldD == null || c1525tk2 == null) ? -1L : c1525tk2.l(fieldD);
        g = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static Object a(Class cls) {
        try {
            return a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static int b(Class cls) {
        if (d) {
            return b.a(cls);
        }
        return -1;
    }

    public static void c(Class cls) {
        if (d) {
            b.b(cls);
        }
    }

    public static Field d() {
        Field declaredField;
        Field declaredField2;
        if (AbstractC1541u7.a()) {
            try {
                declaredField2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused) {
                declaredField2 = null;
            }
            if (declaredField2 != null) {
                return declaredField2;
            }
        }
        try {
            declaredField = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            declaredField = null;
        }
        if (declaredField == null || declaredField.getType() != Long.TYPE) {
            return null;
        }
        return declaredField;
    }

    public static boolean e(Class cls) {
        if (!AbstractC1541u7.a()) {
            return false;
        }
        try {
            Class cls2 = AbstractC1541u7.a;
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

    public static byte f(byte[] bArr, long j) {
        return b.f(e + j, bArr);
    }

    public static byte g(long j, Object obj) {
        return (byte) ((b.i((-4) & j, obj) >>> ((int) (((~j) & 3) << 3))) & 255);
    }

    public static byte h(long j, Object obj) {
        return (byte) ((b.i((-4) & j, obj) >>> ((int) ((j & 3) << 3))) & 255);
    }

    public static int i(A a2, long j) {
        return b.i(j, a2);
    }

    public static long j(A a2, long j) {
        return b.j(j, a2);
    }

    public static Object k(long j, Object obj) {
        return b.k(j, obj);
    }

    public static Unsafe l() {
        try {
            return (Unsafe) AccessController.doPrivileged(new C1406rk2());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void m(Object obj, long j, boolean z) {
        b.m(obj, j, z);
    }

    public static void n(byte[] bArr, long j, byte b2) {
        b.n(bArr, e + j, b2);
    }

    public static void o(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = b.i(j2, obj);
        int i2 = ((~((int) j)) & 3) << 3;
        s(((255 & b2) << i2) | (i & (~(255 << i2))), j2, obj);
    }

    public static void p(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        s(((255 & b2) << i) | (b.i(j2, obj) & (~(255 << i))), j2, obj);
    }

    public static void q(Object obj, long j, double d2) {
        b.o(obj, j, d2);
    }

    public static void r(float f2, long j, Object obj) {
        b.p(f2, j, obj);
    }

    public static void s(int i, long j, Object obj) {
        b.q(i, j, obj);
    }

    public static void t(Object obj, long j, long j2) {
        b.r(obj, j, j2);
    }

    public static void u(long j, Object obj, Object obj2) {
        b.s(j, obj, obj2);
    }
}
