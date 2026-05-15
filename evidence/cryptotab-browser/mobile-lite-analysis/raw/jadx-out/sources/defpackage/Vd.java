package defpackage;

import android.app.Activity;
import android.view.Window;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.chromium.base.ApplicationStatus;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Vd implements InvocationHandler {
    public final Window.Callback a;
    public final Activity b;

    public Vd(Activity activity, Window.Callback callback) {
        this.a = callback;
        this.b = activity;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        boolean zEquals = method.getName().equals("onWindowFocusChanged");
        Window.Callback callback = this.a;
        if (zEquals && objArr.length == 1) {
            Object obj2 = objArr[0];
            if (obj2 instanceof Boolean) {
                boolean zBooleanValue = ((Boolean) obj2).booleanValue();
                callback.onWindowFocusChanged(zBooleanValue);
                M21 m21 = ApplicationStatus.h;
                if (m21 == null) {
                    return null;
                }
                Iterator it = m21.iterator();
                while (true) {
                    L21 l21 = (L21) it;
                    if (!l21.hasNext()) {
                        return null;
                    }
                    ((Wd) l21.next()).c(this.b, zBooleanValue);
                }
            }
        }
        try {
            return method.invoke(callback, objArr);
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof AbstractMethodError) {
                throw e.getCause();
            }
            throw e;
        }
    }
}
