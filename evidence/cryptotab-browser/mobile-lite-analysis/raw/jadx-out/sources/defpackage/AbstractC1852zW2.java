package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: zW2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1852zW2 extends CU2 {
    private static final Map zza = new ConcurrentHashMap();
    protected EY2 zzc;
    protected int zzd;

    public AbstractC1852zW2() {
        this.zzb = 0;
        this.zzc = EY2.f;
        this.zzd = -1;
    }

    public static AbstractC1852zW2 f(Class cls) {
        Map map = zza;
        AbstractC1852zW2 abstractC1852zW2 = (AbstractC1852zW2) map.get(cls);
        if (abstractC1852zW2 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                abstractC1852zW2 = (AbstractC1852zW2) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (abstractC1852zW2 == null) {
            abstractC1852zW2 = (AbstractC1852zW2) ((AbstractC1852zW2) NY2.h(cls)).k(6);
            if (abstractC1852zW2 == null) {
                throw new IllegalStateException();
            }
            map.put(cls, abstractC1852zW2);
        }
        return abstractC1852zW2;
    }

    public static C0847iX2 g(JW2 jw2) {
        int size = jw2.size();
        int i = size == 0 ? 10 : size + size;
        C0847iX2 c0847iX2 = (C0847iX2) jw2;
        if (i >= c0847iX2.v) {
            return new C0847iX2(Arrays.copyOf(c0847iX2.u, i), c0847iX2.v);
        }
        throw new IllegalArgumentException();
    }

    public static LW2 h(LW2 lw2) {
        int size = lw2.size();
        return lw2.c(size == 0 ? 10 : size + size);
    }

    public static Object i(Method method, CU2 cu2, Object... objArr) {
        try {
            return method.invoke(cu2, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static void j(Class cls, AbstractC1852zW2 abstractC1852zW2) {
        zza.put(cls, abstractC1852zW2);
    }

    @Override // defpackage.CU2
    public final int c() {
        int i = this.zzd;
        if (i != -1) {
            return i;
        }
        int iC = C0482cY2.c.a(getClass()).c(this);
        this.zzd = iC;
        return iC;
    }

    public final AbstractC0360aW2 d() {
        return (AbstractC0360aW2) k(5);
    }

    public final AbstractC0360aW2 e() {
        AbstractC0360aW2 abstractC0360aW2 = (AbstractC0360aW2) k(5);
        abstractC0360aW2.b(this);
        return abstractC0360aW2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return C0482cY2.c.a(getClass()).f(this, (AbstractC1852zW2) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int iG = C0482cY2.c.a(getClass()).g(this);
        this.zzb = iG;
        return iG;
    }

    public abstract Object k(int i);

    public final String toString() {
        String string = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        RX2.c(this, sb, 0);
        return sb.toString();
    }
}
