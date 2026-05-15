package defpackage;

import java.lang.reflect.Field;
import java.util.Objects;
import sun.misc.Unsafe;

/* JADX INFO: renamed from: uk2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1577uk2 {
    public final Unsafe a;

    public AbstractC1577uk2(Unsafe unsafe) {
        this.a = unsafe;
    }

    public final int a(Class cls) {
        return this.a.arrayBaseOffset(cls);
    }

    public final int b(Class cls) {
        return this.a.arrayIndexScale(cls);
    }

    public abstract void c(long j, byte[] bArr, long j2);

    public abstract boolean d(long j, Object obj);

    public abstract byte e(long j);

    public abstract byte f(long j, Object obj);

    public abstract double g(long j, Object obj);

    public abstract float h(long j, Object obj);

    public final int i(long j, Object obj) {
        return this.a.getInt(obj, j);
    }

    public final long j(long j, Object obj) {
        return this.a.getLong(obj, j);
    }

    public final Object k(long j, Object obj) {
        return this.a.getObject(obj, j);
    }

    public final long l(Field field) {
        return this.a.objectFieldOffset(field);
    }

    public abstract void m(Object obj, long j, boolean z);

    public abstract void n(Object obj, long j, byte b);

    public abstract void o(Object obj, long j, double d);

    public abstract void p(float f, long j, Object obj);

    public final void q(int i, long j, Object obj) {
        this.a.putInt(obj, j, i);
    }

    public final void r(Object obj, long j, long j2) {
        this.a.putLong(obj, j, j2);
    }

    public final void s(long j, Object obj, Object obj2) {
        this.a.putObject(obj, j, obj2);
    }

    public boolean t() {
        Unsafe unsafe = this.a;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            return true;
        } catch (Throwable th) {
            Unsafe unsafe2 = AbstractC1633vk2.a;
            Objects.toString(th);
            return false;
        }
    }

    public abstract boolean u();
}
