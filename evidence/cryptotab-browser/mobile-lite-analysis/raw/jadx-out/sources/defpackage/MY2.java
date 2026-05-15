package defpackage;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MY2 {
    public final Unsafe a;

    public MY2(Unsafe unsafe) {
        this.a = unsafe;
    }

    public abstract double a(long j, Object obj);

    public abstract float b(long j, Object obj);

    public abstract void c(Object obj, long j, boolean z);

    public abstract void d(Object obj, long j, byte b);

    public abstract void e(Object obj, long j, double d);

    public abstract void f(float f, long j, Object obj);

    public abstract boolean g(long j, Object obj);

    public final int h(Class cls) {
        return this.a.arrayBaseOffset(cls);
    }

    public final int i(Class cls) {
        return this.a.arrayIndexScale(cls);
    }

    public final int j(long j, Object obj) {
        return this.a.getInt(obj, j);
    }

    public final long k(long j, Object obj) {
        return this.a.getLong(obj, j);
    }

    public final void l(Field field) {
        this.a.objectFieldOffset(field);
    }

    public final Object m(long j, Object obj) {
        return this.a.getObject(obj, j);
    }

    public final void n(int i, long j, Object obj) {
        this.a.putInt(obj, j, i);
    }

    public final void o(Object obj, long j, long j2) {
        this.a.putLong(obj, j, j2);
    }

    public final void p(long j, Object obj, Object obj2) {
        this.a.putObject(obj, j, obj2);
    }
}
