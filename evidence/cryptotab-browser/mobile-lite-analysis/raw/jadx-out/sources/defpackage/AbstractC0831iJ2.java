package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/* JADX INFO: renamed from: iJ2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0831iJ2 {
    public static HI2 a() {
        String str;
        ClassLoader classLoader = AbstractC0831iJ2.class.getClassLoader();
        if (HI2.class.equals(HI2.class)) {
            str = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";
        } else {
            if (!HI2.class.getPackage().equals(AbstractC0831iJ2.class.getPackage())) {
                throw new IllegalArgumentException(HI2.class.getName());
            }
            str = HI2.class.getPackage().getName() + ".BlazeGenerated" + HI2.class.getSimpleName() + "Loader";
        }
        try {
            try {
                try {
                    yi1.a(Class.forName(str, true, classLoader).getConstructor(null).newInstance(null));
                    throw null;
                } catch (IllegalAccessException e) {
                    throw new IllegalStateException(e);
                } catch (InvocationTargetException e2) {
                    throw new IllegalStateException(e2);
                }
            } catch (InstantiationException e3) {
                throw new IllegalStateException(e3);
            } catch (NoSuchMethodException e4) {
                throw new IllegalStateException(e4);
            }
        } catch (ClassNotFoundException unused) {
            Iterator it = ServiceLoader.load(AbstractC0831iJ2.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    if (it.next() == null) {
                        throw null;
                    }
                    throw new ClassCastException();
                } catch (ServiceConfigurationError unused2) {
                    "Unable to load ".concat(HI2.class.getSimpleName());
                }
            }
            if (arrayList.size() == 1) {
                return (HI2) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (HI2) HI2.class.getMethod("combine", Collection.class).invoke(null, arrayList);
            } catch (IllegalAccessException e5) {
                throw new IllegalStateException(e5);
            } catch (NoSuchMethodException e6) {
                throw new IllegalStateException(e6);
            } catch (InvocationTargetException e7) {
                throw new IllegalStateException(e7);
            }
        }
    }
}
