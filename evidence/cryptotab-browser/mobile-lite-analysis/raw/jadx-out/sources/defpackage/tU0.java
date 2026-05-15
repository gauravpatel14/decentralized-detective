package defpackage;

import J.N;
import android.content.Context;
import org.chromium.base.BundleUtils;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class tU0 {
    public final String a;
    public final Class b;
    public final String c;
    public wU0 d;
    public Context e;
    public Object f;
    public xU0 g;
    public boolean h;

    public tU0(String str, Class cls, String str2) {
        this.a = str;
        this.b = cls;
        this.c = str2;
    }

    public final void a() {
        if (this.h) {
            return;
        }
        wU0 wu0D = d();
        String[] strArrC = wu0D.c();
        String[] strArrB = wu0D.b();
        if (strArrC.length > 0 || strArrB.length > 0) {
            N._V_OOO(8, this.a, strArrC, strArrB);
        }
        this.h = true;
    }

    public final Object b() {
        Class cls = this.b;
        Object obj = this.f;
        if (obj != null) {
            return obj;
        }
        C0975ka2 c0975ka2 = new C0975ka2();
        try {
            if (d().a()) {
                a();
            }
            Object objF = f(this.c);
            try {
                Object objCast = cls.cast(objF);
                this.f = objCast;
                c0975ka2.close();
                return objCast;
            } catch (ClassCastException e) {
                ClassLoader classLoader = cls.getClassLoader();
                ClassLoader classLoader2 = objF.getClass().getClassLoader();
                throw new RuntimeException("Failure casting " + this.a + " module class, interface ClassLoader: " + classLoader + " (parent " + classLoader.getParent() + "), impl ClassLoader: " + classLoader2 + " (parent " + classLoader2.getParent() + "), equal: " + classLoader.equals(classLoader2) + " (parents equal: " + classLoader.getParent().equals(classLoader2.getParent()) + ")", e);
            }
        } catch (Throwable th) {
            try {
                c0975ka2.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    public final ex0 c() {
        if (this.g == null) {
            C0975ka2 c0975ka2 = new C0975ka2();
            try {
                this.g = new xU0(this.c);
                c0975ka2.close();
            } catch (Throwable th) {
                try {
                    c0975ka2.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        }
        return this.g;
    }

    public final wU0 d() {
        wU0 su0 = this.d;
        if (su0 == null) {
            if (BundleUtils.e()) {
                su0 = (wU0) f("org.chromium.components.module_installer.builder.ModuleDescriptor_" + this.a);
            } else {
                su0 = new sU0();
            }
            this.d = su0;
        }
        return su0;
    }

    public final void e(fx0 fx0Var) {
        C0975ka2 c0975ka2 = new C0975ka2();
        try {
            ((xU0) c()).b(this.a, fx0Var);
            c0975ka2.close();
        } catch (Throwable th) {
            try {
                c0975ka2.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    public final Object f(String str) {
        Context contextA = this.e;
        if (contextA == null) {
            contextA = AbstractC1499tM.a;
            String str2 = this.a;
            if (BundleUtils.f(str2)) {
                contextA = BundleUtils.a(contextA, str2);
            }
        }
        try {
            LP1 lp1C = LP1.c();
            try {
                Object objNewInstance = contextA.getClassLoader().loadClass(str).newInstance();
                this.e = contextA;
                lp1C.close();
                return objNewInstance;
            } catch (Throwable th) {
                try {
                    lp1C.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public final boolean g() {
        C0975ka2 c0975ka2 = new C0975ka2();
        try {
            ex0 ex0VarC = c();
            String str = this.a;
            xU0 xu0 = (xU0) ex0VarC;
            xu0.getClass();
            boolean z = true;
            if (!BundleUtils.f(str)) {
                try {
                    LP1 lp1C = LP1.c();
                    try {
                        AbstractC1499tM.a.getClassLoader().loadClass(xu0.b);
                        lp1C.close();
                    } catch (Throwable th) {
                        try {
                            lp1C.close();
                        } catch (Throwable unused) {
                        }
                        throw th;
                    }
                } catch (ClassNotFoundException unused2) {
                    z = false;
                }
            }
            return z;
        } finally {
            try {
                c0975ka2.close();
            } catch (Throwable unused3) {
            }
        }
    }
}
