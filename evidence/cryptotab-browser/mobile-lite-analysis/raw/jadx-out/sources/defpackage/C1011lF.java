package defpackage;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: lF, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1011lF {
    public static final C1011lF c = new C1011lF();
    public final HashMap a = new HashMap();
    public final HashMap b = new HashMap();

    public static void b(HashMap map, kF kFVar, bF0 bf0, Class cls) {
        bF0 bf02 = (bF0) map.get(kFVar);
        if (bf02 == null || bf0 == bf02) {
            if (bf02 == null) {
                map.put(kFVar, bf0);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + kFVar.b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + bf02 + ", new value " + bf0);
    }

    public final jF a(Class cls, Method[] methodArr) {
        int i;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        HashMap map2 = this.a;
        if (superclass != null) {
            jF jFVarA = (jF) map2.get(superclass);
            if (jFVarA == null) {
                jFVarA = a(superclass, null);
            }
            map.putAll(jFVarA.b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            jF jFVarA2 = (jF) map2.get(cls2);
            if (jFVarA2 == null) {
                jFVarA2 = a(cls2, null);
            }
            for (Map.Entry entry : jFVarA2.b.entrySet()) {
                b(map, (kF) entry.getKey(), (bF0) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
            }
        }
        boolean z = false;
        for (Method method : methodArr) {
            R41 r41 = (R41) method.getAnnotation(R41.class);
            if (r41 != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!InterfaceC0762hF0.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i = 1;
                }
                bF0 bf0Value = r41.value();
                if (parameterTypes.length > 1) {
                    if (!bF0.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (bf0Value != bF0.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                b(map, new kF(i, method), bf0Value, cls);
                z = true;
            }
        }
        jF jFVar = new jF(map);
        map2.put(cls, jFVar);
        this.b.put(cls, Boolean.valueOf(z));
        return jFVar;
    }
}
