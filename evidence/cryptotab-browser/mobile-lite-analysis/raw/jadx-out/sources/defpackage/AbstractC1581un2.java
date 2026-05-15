package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: un2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1581un2 {
    public final UJ1 a;
    public final UJ1 b;
    public final UJ1 c;

    public AbstractC1581un2(UJ1 uj1, UJ1 uj12, UJ1 uj13) {
        this.a = uj1;
        this.b = uj12;
        this.c = uj13;
    }

    public abstract C1637vn2 a();

    public final Class b(Class cls) throws ClassNotFoundException {
        String name = cls.getName();
        UJ1 uj1 = this.c;
        Class cls2 = (Class) uj1.get(name);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(cls.getPackage().getName() + "." + cls.getSimpleName() + "Parcelizer", false, cls.getClassLoader());
        uj1.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method c(String str) throws NoSuchMethodException {
        UJ1 uj1 = this.a;
        Method method = (Method) uj1.get(str);
        if (method != null) {
            return method;
        }
        Method declaredMethod = Class.forName(str, true, AbstractC1581un2.class.getClassLoader()).getDeclaredMethod("read", AbstractC1581un2.class);
        uj1.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method d(Class cls) throws NoSuchMethodException {
        String name = cls.getName();
        UJ1 uj1 = this.b;
        Method method = (Method) uj1.get(name);
        if (method != null) {
            return method;
        }
        Method declaredMethod = b(cls).getDeclaredMethod("write", cls, AbstractC1581un2.class);
        uj1.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public abstract boolean e(int i);

    public final int f(int i, int i2) {
        return !e(i2) ? i : ((C1637vn2) this).e.readInt();
    }

    public final Parcelable g(Parcelable parcelable, int i) {
        if (!e(i)) {
            return parcelable;
        }
        return ((C1637vn2) this).e.readParcelable(C1637vn2.class.getClassLoader());
    }

    public final InterfaceC1694wn2 h() {
        String string = ((C1637vn2) this).e.readString();
        if (string == null) {
            return null;
        }
        try {
            return (InterfaceC1694wn2) c(string).invoke(null, a());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            Throwable cause = e4.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException(e4);
        }
    }

    public abstract void i(int i);

    public final void j(int i, int i2) {
        i(i2);
        ((C1637vn2) this).e.writeInt(i);
    }

    public final void k(Parcelable parcelable, int i) {
        i(i);
        ((C1637vn2) this).e.writeParcelable(parcelable, 0);
    }

    public final void l(InterfaceC1694wn2 interfaceC1694wn2) {
        if (interfaceC1694wn2 == null) {
            ((C1637vn2) this).e.writeString(null);
            return;
        }
        try {
            ((C1637vn2) this).e.writeString(b(interfaceC1694wn2.getClass()).getName());
            C1637vn2 c1637vn2A = a();
            try {
                d(interfaceC1694wn2.getClass()).invoke(null, interfaceC1694wn2, c1637vn2A);
                int i = c1637vn2A.i;
                if (i >= 0) {
                    int i2 = c1637vn2A.d.get(i);
                    Parcel parcel = c1637vn2A.e;
                    int iDataPosition = parcel.dataPosition();
                    parcel.setDataPosition(i2);
                    parcel.writeInt(iDataPosition - i2);
                    parcel.setDataPosition(iDataPosition);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException(e3);
            } catch (InvocationTargetException e4) {
                Throwable cause = e4.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                if (!(cause instanceof Error)) {
                    throw new RuntimeException(e4);
                }
                throw ((Error) cause);
            }
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException(interfaceC1694wn2.getClass().getSimpleName().concat(" does not have a Parcelizer"), e5);
        }
    }
}
