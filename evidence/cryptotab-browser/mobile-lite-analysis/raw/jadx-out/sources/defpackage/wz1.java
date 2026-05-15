package defpackage;

import android.app.Application;
import android.os.Bundle;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class wz1 implements InterfaceC0048Do2 {
    public final Application a;
    public final C0034Co2 b;
    public final Bundle c;
    public final AbstractC0514dF0 d;
    public final tz1 e;

    public wz1(Application application, vz1 vz1Var, Bundle bundle) {
        C0034Co2 c0034Co2;
        this.e = vz1Var.getSavedStateRegistry();
        this.d = vz1Var.getLifecycle();
        this.c = bundle;
        this.a = application;
        if (application != null) {
            if (C0034Co2.c == null) {
                C0034Co2.c = new C0034Co2(application);
            }
            c0034Co2 = C0034Co2.c;
        } else {
            c0034Co2 = new C0034Co2(null);
        }
        this.b = c0034Co2;
    }

    @Override // defpackage.InterfaceC0048Do2
    public final AbstractC1867zo2 a(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return d(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // defpackage.InterfaceC0048Do2
    public final AbstractC1867zo2 b(Class cls, C0533dW0 c0533dW0) {
        C0018Bo2 c0018Bo2 = AbstractC0070Fo2.a;
        LinkedHashMap linkedHashMap = c0533dW0.a;
        String str = (String) linkedHashMap.get(c0018Bo2);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (linkedHashMap.get(AbstractC1120mz1.a) == null || linkedHashMap.get(AbstractC1120mz1.b) == null) {
            if (this.d != null) {
                return d(str, cls);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) linkedHashMap.get(C0034Co2.d);
        boolean zIsAssignableFrom = AbstractC0448c9.class.isAssignableFrom(cls);
        Constructor constructorA = (!zIsAssignableFrom || application == null) ? xz1.a(cls, xz1.b) : xz1.a(cls, xz1.a);
        return constructorA == null ? this.b.b(cls, c0533dW0) : (!zIsAssignableFrom || application == null) ? xz1.b(cls, constructorA, AbstractC1120mz1.a(c0533dW0)) : xz1.b(cls, constructorA, application, AbstractC1120mz1.a(c0533dW0));
    }

    public final AbstractC1867zo2 d(String str, Class cls) {
        AutoCloseable autoCloseable;
        Application application;
        AbstractC0514dF0 abstractC0514dF0 = this.d;
        if (abstractC0514dF0 == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = AbstractC0448c9.class.isAssignableFrom(cls);
        Constructor constructorA = (!zIsAssignableFrom || this.a == null) ? xz1.a(cls, xz1.b) : xz1.a(cls, xz1.a);
        if (constructorA == null) {
            if (this.a != null) {
                return this.b.a(cls);
            }
            if (C0059Eo2.a == null) {
                C0059Eo2.a = new C0059Eo2();
            }
            C0059Eo2.a.getClass();
            return yB0.a(cls);
        }
        tz1 tz1Var = this.e;
        Bundle bundle = this.c;
        Bundle bundleA = tz1Var.a(str);
        Class[] clsArr = hz1.f;
        hz1 hz1VarA = gz1.a(bundleA, bundle);
        jz1 jz1Var = new jz1(str, hz1VarA);
        if (jz1Var.v) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        jz1Var.v = true;
        abstractC0514dF0.a(jz1Var);
        tz1Var.c(str, hz1VarA.e);
        cF0 cf0 = ((C0886jF0) abstractC0514dF0).c;
        if (cf0 == cF0.u || cf0.a(cF0.w)) {
            tz1Var.d();
        } else {
            abstractC0514dF0.a(new AE0(abstractC0514dF0, tz1Var));
        }
        AbstractC1867zo2 abstractC1867zo2B = (!zIsAssignableFrom || (application = this.a) == null) ? xz1.b(cls, constructorA, hz1VarA) : xz1.b(cls, constructorA, application, hz1VarA);
        C0005Ao2 c0005Ao2 = abstractC1867zo2B.a;
        if (c0005Ao2 != null) {
            if (c0005Ao2.d) {
                C0005Ao2.a(jz1Var);
            } else {
                synchronized (c0005Ao2.a) {
                    autoCloseable = (AutoCloseable) c0005Ao2.b.put("androidx.lifecycle.savedstate.vm.tag", jz1Var);
                }
                C0005Ao2.a(autoCloseable);
            }
        }
        return abstractC1867zo2B;
    }
}
