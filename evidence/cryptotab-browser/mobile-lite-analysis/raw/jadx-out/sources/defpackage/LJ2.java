package defpackage;

import com.google.android.gms.common.api.Api;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LJ2 extends AbstractC0948kF2 {
    private static final Map zzb = new ConcurrentHashMap();
    protected C1088mP2 zzc;
    private int zzd;

    public LJ2() {
        this.zza = 0;
        this.zzd = -1;
        this.zzc = C1088mP2.f;
    }

    public static LJ2 d(Class cls) {
        Map map = zzb;
        LJ2 lj2 = (LJ2) map.get(cls);
        if (lj2 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                lj2 = (LJ2) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (lj2 == null) {
            lj2 = (LJ2) ((LJ2) SP2.h(cls)).k(6);
            if (lj2 == null) {
                throw new IllegalStateException();
            }
            map.put(cls, lj2);
        }
        return lj2;
    }

    public static Object e(Method method, AbstractC0948kF2 abstractC0948kF2, Object... objArr) {
        try {
            return method.invoke(abstractC0948kF2, objArr);
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

    public static void g(Class cls, LJ2 lj2) {
        lj2.f();
        zzb.put(cls, lj2);
    }

    public static final boolean i(LJ2 lj2, boolean z) {
        byte bByteValue = ((Byte) lj2.k(1)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zD = ZN2.c.a(lj2.getClass()).d(lj2);
        if (z) {
            lj2.k(2);
        }
        return zD;
    }

    @Override // defpackage.AbstractC0948kF2
    public final int a(InterfaceC0773hO2 interfaceC0773hO2) {
        if (j()) {
            int iG = interfaceC0773hO2.g(this);
            if (iG >= 0) {
                return iG;
            }
            throw new IllegalStateException(AbstractC1214oR1.a(iG, "serialized size must be non-negative, was "));
        }
        int i = this.zzd & Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iG2 = interfaceC0773hO2.g(this);
        if (iG2 < 0) {
            throw new IllegalStateException(AbstractC1214oR1.a(iG2, "serialized size must be non-negative, was "));
        }
        this.zzd = (this.zzd & Integer.MIN_VALUE) | iG2;
        return iG2;
    }

    public final int b() {
        int iG;
        if (j()) {
            iG = ZN2.c.a(getClass()).g(this);
            if (iG < 0) {
                throw new IllegalStateException(AbstractC1214oR1.a(iG, "serialized size must be non-negative, was "));
            }
        } else {
            iG = this.zzd & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            if (iG == Integer.MAX_VALUE) {
                iG = ZN2.c.a(getClass()).g(this);
                if (iG < 0) {
                    throw new IllegalStateException(AbstractC1214oR1.a(iG, "serialized size must be non-negative, was "));
                }
                this.zzd = (this.zzd & Integer.MIN_VALUE) | iG;
            }
        }
        return iG;
    }

    public final AbstractC1495tJ2 c() {
        return (AbstractC1495tJ2) k(5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return ZN2.c.a(getClass()).i(this, (LJ2) obj);
    }

    public final void f() {
        this.zzd &= Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final void h() {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final int hashCode() {
        if (j()) {
            return ZN2.c.a(getClass()).f(this);
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iF = ZN2.c.a(getClass()).f(this);
        this.zza = iF;
        return iF;
    }

    public final boolean j() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public abstract Object k(int i);

    public final String toString() {
        String string = super.toString();
        char[] cArr = BN2.a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        BN2.c(this, sb, 0);
        return sb.toString();
    }
}
