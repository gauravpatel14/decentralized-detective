package defpackage;

import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: bh0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0429bh0 implements InvocationHandler {
    public Object a;

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        Bundle bundle;
        try {
            Object objInvoke = method.invoke(this.a, objArr);
            if (method.getReturnType() == ApplicationInfo.class && (bundle = ((ApplicationInfo) objInvoke).metaData) != null) {
                bundle.remove("preloaded_fonts");
            }
            return objInvoke;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Reflection failed when proxying IPackageManager", e);
        } catch (InvocationTargetException e2) {
            throw e2.getTargetException();
        }
    }
}
