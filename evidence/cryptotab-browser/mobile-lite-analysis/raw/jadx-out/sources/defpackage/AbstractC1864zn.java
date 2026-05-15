package defpackage;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: zn, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1864zn implements InterfaceC1670wN, qO, Serializable {
    public final InterfaceC1670wN t;

    public AbstractC1864zn(InterfaceC1670wN interfaceC1670wN) {
        this.t = interfaceC1670wN;
    }

    public InterfaceC1670wN a(Object obj, InterfaceC1670wN interfaceC1670wN) {
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    @Override // defpackage.qO
    public final qO b() {
        InterfaceC1670wN interfaceC1670wN = this.t;
        if (interfaceC1670wN instanceof qO) {
            return (qO) interfaceC1670wN;
        }
        return null;
    }

    @Override // defpackage.InterfaceC1670wN
    public final void d(Object obj) {
        InterfaceC1670wN interfaceC1670wN = this;
        while (true) {
            AbstractC1864zn abstractC1864zn = (AbstractC1864zn) interfaceC1670wN;
            InterfaceC1670wN interfaceC1670wN2 = abstractC1864zn.t;
            try {
                obj = abstractC1864zn.l(obj);
                if (obj == pO.t) {
                    return;
                }
            } catch (Throwable th) {
                obj = new Zv1(th);
            }
            abstractC1864zn.p();
            if (!(interfaceC1670wN2 instanceof AbstractC1864zn)) {
                interfaceC1670wN2.d(obj);
                return;
            }
            interfaceC1670wN = interfaceC1670wN2;
        }
    }

    public abstract Object l(Object obj);

    public String toString() {
        int iIntValue;
        String strC;
        StringBuilder sb = new StringBuilder("Continuation at ");
        gV gVVar = (gV) getClass().getAnnotation(gV.class);
        Object name = null;
        str = null;
        str = null;
        str = null;
        String str = null;
        if (gVVar != null) {
            int iV = gVVar.v();
            if (iV > 1) {
                throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + iV + ". Please update the Kotlin standard library.").toString());
            }
            try {
                Field declaredField = getClass().getDeclaredField("label");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(this);
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                iIntValue = (num != null ? num.intValue() : 0) - 1;
            } catch (Exception unused) {
                iIntValue = -1;
            }
            int i = iIntValue >= 0 ? gVVar.l()[iIntValue] : -1;
            zU0 zu0 = AU0.b;
            zU0 zu02 = AU0.a;
            if (zu0 == null) {
                try {
                    zU0 zu03 = new zU0(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
                    AU0.b = zu03;
                    zu0 = zu03;
                } catch (Exception unused2) {
                    AU0.b = zu02;
                    zu0 = zu02;
                }
            }
            if (zu0 != zu02) {
                Method method = zu0.a;
                Object objInvoke = method != null ? method.invoke(getClass(), null) : null;
                if (objInvoke != null) {
                    Method method2 = zu0.b;
                    Object objInvoke2 = method2 != null ? method2.invoke(objInvoke, null) : null;
                    if (objInvoke2 != null) {
                        Method method3 = zu0.c;
                        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
                        if (objInvoke3 instanceof String) {
                            str = (String) objInvoke3;
                        }
                    }
                }
            }
            if (str == null) {
                strC = gVVar.c();
            } else {
                strC = str + '/' + gVVar.c();
            }
            name = new StackTraceElement(strC, gVVar.m(), gVVar.f(), i);
        }
        if (name == null) {
            name = getClass().getName();
        }
        sb.append(name);
        return sb.toString();
    }

    public void p() {
    }
}
