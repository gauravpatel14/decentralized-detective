package defpackage;

import android.util.Log;
import com.google.android.play.core.splitinstall.internal.zzbh;
import com.google.android.play.core.splitinstall.internal.zzbl;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RE2 implements InterfaceC0946kE2 {
    public static boolean c(ClassLoader classLoader, File file, File file2, boolean z, bF2 bf2, String str, FE2 fe2) {
        ArrayList arrayList = new ArrayList();
        Field fieldC = TG2.c(classLoader, "pathList");
        try {
            Object objCast = Object.class.cast(fieldC.get(classLoader));
            LG2 lg2A = TG2.a(objCast, "dexElements", Object.class);
            List listAsList = Arrays.asList((Object[]) lg2A.a());
            ArrayList arrayList2 = new ArrayList();
            Iterator it = listAsList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                Field fieldC2 = TG2.c(next, str);
                Iterator it2 = it;
                try {
                    arrayList2.add((File) File.class.cast(fieldC2.get(next)));
                    it = it2;
                } catch (Exception e) {
                    throw new zzbl("Failed to get value of field " + fieldC2.getName() + " of type " + next.getClass().getName() + " on object of type " + File.class.getName(), e);
                }
            }
            if (arrayList2.contains(file2)) {
                return true;
            }
            if (!z && !fe2.a(objCast, file2, file)) {
                Log.w("SplitCompat", "Should be optimized ".concat(String.valueOf(file2.getPath())));
                return false;
            }
            ArrayList arrayList3 = new ArrayList(Collections.singleton(file2));
            bf2.getClass();
            try {
                lg2A.c(Arrays.asList((Object[]) Object[].class.cast(TG2.d(objCast.getClass(), "makePathElements", List.class, File.class, List.class).invoke(objCast, arrayList3, file, arrayList))));
                if (arrayList.isEmpty()) {
                    return true;
                }
                zzbh zzbhVar = new zzbh("DexPathList.makeDexElement failed");
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    IOException iOException = (IOException) arrayList.get(i);
                    Log.e("SplitCompat", "DexPathList.makeDexElement failed", iOException);
                    try {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(zzbhVar, iOException);
                    } catch (Exception unused) {
                    }
                }
                TG2.a(objCast, "dexElementsSuppressedExceptions", IOException.class).c(arrayList);
                throw zzbhVar;
            } catch (Exception e2) {
                throw new zzbl("Failed to invoke method makePathElements on an object of type " + objCast.getClass(), e2);
            }
        } catch (Exception e3) {
            throw new zzbl("Failed to get value of field " + fieldC.getName() + " of type " + classLoader.getClass().getName() + " on object of type " + Object.class.getName(), e3);
        }
    }
}
