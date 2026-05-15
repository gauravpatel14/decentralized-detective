package defpackage;

import com.google.android.play.core.splitinstall.internal.zzbh;
import com.google.android.play.core.splitinstall.internal.zzbl;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: mF2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1073mF2 implements InterfaceC0946kE2 {
    public static void c(ClassLoader classLoader, HashSet hashSet, C0397bG2 c0397bG2) {
        if (hashSet.isEmpty()) {
            return;
        }
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            hashSet2.add(((File) it.next()).getParentFile());
        }
        Field fieldC = TG2.c(classLoader, "pathList");
        try {
            Object objCast = Object.class.cast(fieldC.get(classLoader));
            PG2 pg2 = new PG2(objCast, TG2.c(objCast, "nativeLibraryDirectories"), List.class);
            synchronized (WY2.class) {
                ArrayList arrayList = new ArrayList((Collection) pg2.a());
                hashSet2.removeAll(arrayList);
                arrayList.addAll(hashSet2);
                pg2.b(arrayList);
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList(hashSet2);
            c0397bG2.getClass();
            Object[] objArr = (Object[]) TG2.b(objCast, "makePathElements", Object[].class, List.class, arrayList3);
            if (arrayList2.isEmpty()) {
                synchronized (WY2.class) {
                    TG2.a(objCast, "nativeLibraryPathElements", Object.class).d(Arrays.asList(objArr));
                }
                return;
            }
            zzbh zzbhVar = new zzbh("Error in makePathElements");
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(zzbhVar, (IOException) arrayList2.get(i));
                } catch (Exception unused) {
                }
            }
            throw zzbhVar;
        } catch (Exception e) {
            throw new zzbl("Failed to get value of field " + fieldC.getName() + " of type " + classLoader.getClass().getName() + " on object of type " + Object.class.getName(), e);
        }
    }
}
