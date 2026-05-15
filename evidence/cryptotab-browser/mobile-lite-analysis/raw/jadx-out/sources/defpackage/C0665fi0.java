package defpackage;

import androidx.fragment.app.Fragment$InstantiationException;
import androidx.fragment.app.n;
import androidx.fragment.app.s;

/* JADX INFO: renamed from: fi0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0665fi0 {
    public static final UJ1 b = new UJ1(0);
    public final /* synthetic */ s a;

    public C0665fi0(s sVar) {
        this.a = sVar;
    }

    public static Class b(ClassLoader classLoader, String str) throws ClassNotFoundException {
        UJ1 uj1 = b;
        UJ1 uj12 = (UJ1) uj1.get(classLoader);
        if (uj12 == null) {
            uj12 = new UJ1(0);
            uj1.put(classLoader, uj12);
        }
        Class cls = (Class) uj12.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        uj12.put(str, cls2);
        return cls2;
    }

    public static Class c(ClassLoader classLoader, String str) {
        try {
            return b(classLoader, str);
        } catch (ClassCastException e) {
            throw new Fragment$InstantiationException(BN0.a("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e);
        } catch (ClassNotFoundException e2) {
            throw new Fragment$InstantiationException(BN0.a("Unable to instantiate fragment ", str, ": make sure class name exists"), e2);
        }
    }

    public final n a(String str) {
        return n.instantiate(this.a.w.u, str, null);
    }
}
