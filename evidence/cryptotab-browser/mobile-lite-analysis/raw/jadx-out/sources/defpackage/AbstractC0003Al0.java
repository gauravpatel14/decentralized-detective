package defpackage;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: Al0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0003Al0 extends A {
    public static final ConcurrentHashMap d = new ConcurrentHashMap();
    public Zj2 b;
    public int c;

    public AbstractC0003Al0() {
        this.a = 0;
        this.b = Zj2.f;
        this.c = -1;
    }

    public static void e(AbstractC0003Al0 abstractC0003Al0) throws InvalidProtocolBufferException {
        if (!j(abstractC0003Al0, true)) {
            throw new InvalidProtocolBufferException(new UninitializedMessageException().getMessage());
        }
    }

    public static AbstractC0003Al0 g(Class cls) {
        ConcurrentHashMap concurrentHashMap = d;
        AbstractC0003Al0 abstractC0003Al0 = (AbstractC0003Al0) concurrentHashMap.get(cls);
        if (abstractC0003Al0 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                abstractC0003Al0 = (AbstractC0003Al0) concurrentHashMap.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (abstractC0003Al0 == null) {
            abstractC0003Al0 = (AbstractC0003Al0) ((AbstractC0003Al0) AbstractC1633vk2.a(cls)).f(EnumC1862zl0.y, null, null);
            if (abstractC0003Al0 == null) {
                throw new IllegalStateException();
            }
            concurrentHashMap.put(cls, abstractC0003Al0);
        }
        return abstractC0003Al0;
    }

    public static Object i(Method method, InterfaceC1787yS0 interfaceC1787yS0, Object... objArr) {
        try {
            return method.invoke(interfaceC1787yS0, objArr);
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

    public static final boolean j(AbstractC0003Al0 abstractC0003Al0, boolean z) {
        byte bByteValue = ((Byte) abstractC0003Al0.f(EnumC1862zl0.t, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        C0734gn1 c0734gn1 = C0734gn1.c;
        c0734gn1.getClass();
        boolean zF = c0734gn1.a(abstractC0003Al0.getClass()).f(abstractC0003Al0);
        if (z) {
            abstractC0003Al0.f(EnumC1862zl0.u, zF ? abstractC0003Al0 : null, null);
        }
        return zF;
    }

    public static AbstractC0003Al0 k(AbstractC0003Al0 abstractC0003Al0, C0199Qv c0199Qv) throws InvalidProtocolBufferException {
        C1191o90 c1191o90A = C1191o90.a();
        C1660wG c1660wGF = yG.f(c0199Qv.u, c0199Qv.s(), c0199Qv.size(), true);
        AbstractC0003Al0 abstractC0003Al0M = m(abstractC0003Al0, c1660wGF, c1191o90A);
        c1660wGF.a(0);
        e(abstractC0003Al0M);
        e(abstractC0003Al0M);
        return abstractC0003Al0M;
    }

    public static AbstractC0003Al0 l(AbstractC0003Al0 abstractC0003Al0, byte[] bArr) throws InvalidProtocolBufferException {
        AbstractC0003Al0 abstractC0003Al0N = n(abstractC0003Al0, bArr, bArr.length, C1191o90.a());
        e(abstractC0003Al0N);
        return abstractC0003Al0N;
    }

    public static AbstractC0003Al0 m(AbstractC0003Al0 abstractC0003Al0, yG yGVar, C1191o90 c1191o90) throws InvalidProtocolBufferException {
        AbstractC0003Al0 abstractC0003Al02 = (AbstractC0003Al0) abstractC0003Al0.f(EnumC1862zl0.w, null, null);
        try {
            C0734gn1 c0734gn1 = C0734gn1.c;
            c0734gn1.getClass();
            Cz1 cz1A = c0734gn1.a(abstractC0003Al02.getClass());
            zG zGVar = yGVar.b;
            if (zGVar == null) {
                zGVar = new zG(yGVar);
            }
            cz1A.i(abstractC0003Al02, zGVar, c1191o90);
            cz1A.d(abstractC0003Al02);
            return abstractC0003Al02;
        } catch (InvalidProtocolBufferException e) {
            throw e;
        } catch (UninitializedMessageException e2) {
            throw new InvalidProtocolBufferException(e2.getMessage());
        } catch (IOException e3) {
            if (e3.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e3.getCause());
            }
            throw new InvalidProtocolBufferException(e3.getMessage(), e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e4.getCause());
            }
            throw e4;
        }
    }

    public static AbstractC0003Al0 n(AbstractC0003Al0 abstractC0003Al0, byte[] bArr, int i, C1191o90 c1191o90) throws InvalidProtocolBufferException {
        AbstractC0003Al0 abstractC0003Al02 = (AbstractC0003Al0) abstractC0003Al0.f(EnumC1862zl0.w, null, null);
        try {
            C0734gn1 c0734gn1 = C0734gn1.c;
            c0734gn1.getClass();
            Cz1 cz1A = c0734gn1.a(abstractC0003Al02.getClass());
            We we = new We();
            c1191o90.getClass();
            cz1A.g(abstractC0003Al02, bArr, 0, i, we);
            cz1A.d(abstractC0003Al02);
            if (abstractC0003Al02.a == 0) {
                return abstractC0003Al02;
            }
            throw new RuntimeException();
        } catch (InvalidProtocolBufferException e) {
            throw e;
        } catch (UninitializedMessageException e2) {
            throw new InvalidProtocolBufferException(e2.getMessage());
        } catch (IOException e3) {
            if (e3.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e3.getCause());
            }
            throw new InvalidProtocolBufferException(e3.getMessage(), e3);
        } catch (IndexOutOfBoundsException unused) {
            throw InvalidProtocolBufferException.j();
        }
    }

    public static void o(Class cls, AbstractC0003Al0 abstractC0003Al0) {
        d.put(cls, abstractC0003Al0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0734gn1 c0734gn1 = C0734gn1.c;
        c0734gn1.getClass();
        return c0734gn1.a(getClass()).e(this, (AbstractC0003Al0) obj);
    }

    public abstract Object f(EnumC1862zl0 enumC1862zl0, Object obj, Object obj2);

    public final int h() {
        if (this.c == -1) {
            C0734gn1 c0734gn1 = C0734gn1.c;
            c0734gn1.getClass();
            this.c = c0734gn1.a(getClass()).h(this);
        }
        return this.c;
    }

    public final int hashCode() {
        int i = this.a;
        if (i != 0) {
            return i;
        }
        C0734gn1 c0734gn1 = C0734gn1.c;
        c0734gn1.getClass();
        int iB = c0734gn1.a(getClass()).b(this);
        this.a = iB;
        return iB;
    }

    public final void p(CG cg) {
        C0734gn1 c0734gn1 = C0734gn1.c;
        c0734gn1.getClass();
        Cz1 cz1A = c0734gn1.a(getClass());
        DG dg = cg.a;
        if (dg == null) {
            dg = new DG(cg);
        }
        cz1A.a(this, dg);
    }

    public final String toString() {
        String string = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        AbstractC1845zS0.c(this, sb, 0);
        return sb.toString();
    }
}
