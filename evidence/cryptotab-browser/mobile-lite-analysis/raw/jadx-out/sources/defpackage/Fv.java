package defpackage;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.chromium.base.BundleUtils;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Fv extends ClassLoader {
    public Fv() {
        super(AbstractC1499tM.a.getClassLoader());
        Log.i("cr_SplitCompatClassLoader", String.format(Locale.US, "Splits: %s", BundleUtils.f));
    }

    @Override // java.lang.ClassLoader
    public final Class findClass(String str) throws ClassNotFoundException {
        Class<?> clsLoadClass;
        Class<?> clsLoadClass2;
        Iterator it = BundleUtils.d.values().iterator();
        while (true) {
            clsLoadClass = null;
            if (!it.hasNext()) {
                clsLoadClass2 = null;
                break;
            }
            try {
                clsLoadClass2 = ((ClassLoader) it.next()).loadClass(str);
                break;
            } catch (ClassNotFoundException unused) {
            }
        }
        if (clsLoadClass2 != null) {
            return clsLoadClass2;
        }
        if (!str.startsWith("android.")) {
            ArrayList<String> arrayList = BundleUtils.f;
            if (arrayList != null) {
                for (String str2 : arrayList) {
                    Map map = BundleUtils.d;
                    if (!map.containsKey(str2)) {
                        map.put(str2, BundleUtils.b(str2));
                    }
                }
                BundleUtils.f = null;
                Iterator it2 = BundleUtils.d.values().iterator();
                while (it2.hasNext()) {
                    try {
                        clsLoadClass = ((ClassLoader) it2.next()).loadClass(str);
                        break;
                    } catch (ClassNotFoundException unused2) {
                    }
                }
                if (clsLoadClass != null) {
                    return clsLoadClass;
                }
            }
            Log.w("cr_SplitCompatClassLoader", "No class " + str + " amongst " + TextUtils.join("\n", BundleUtils.d.keySet()));
        }
        throw new ClassNotFoundException(str);
    }
}
