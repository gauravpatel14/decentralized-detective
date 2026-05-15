package defpackage;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: renamed from: Co2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0034Co2 extends C0059Eo2 {
    public static C0034Co2 c;
    public static final C0018Bo2 d = new C0018Bo2();
    public final Application b;

    public C0034Co2(Application application) {
        this.b = application;
    }

    public static AbstractC1867zo2 d(Class cls, Application application) {
        if (!AbstractC0448c9.class.isAssignableFrom(cls)) {
            return yB0.a(cls);
        }
        try {
            return (AbstractC1867zo2) cls.getConstructor(Application.class).newInstance(application);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot create an instance of " + cls, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Cannot create an instance of " + cls, e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("Cannot create an instance of " + cls, e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException("Cannot create an instance of " + cls, e4);
        }
    }

    @Override // defpackage.C0059Eo2, defpackage.InterfaceC0048Do2
    public final AbstractC1867zo2 a(Class cls) {
        Application application = this.b;
        if (application != null) {
            return d(cls, application);
        }
        throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // defpackage.C0059Eo2, defpackage.InterfaceC0048Do2
    public final AbstractC1867zo2 b(Class cls, C0533dW0 c0533dW0) {
        if (this.b != null) {
            return a(cls);
        }
        Application application = (Application) c0533dW0.a.get(d);
        if (application != null) {
            return d(cls, application);
        }
        if (AbstractC0448c9.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }
        return yB0.a(cls);
    }
}
