package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamite.DynamiteModule$LoadingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class m50 {
    public static Boolean f = null;
    public static String g = null;
    public static boolean h = false;
    public static int i = -1;
    public static Boolean j;
    public static C1061m13 n;
    public static P13 o;
    public final Context a;
    public static final ThreadLocal k = new ThreadLocal();
    public static final MK2 l = new MK2();
    public static final C0956kN2 m = new C0956kN2();
    public static final OO2 b = new OO2();
    public static final C0357aU2 c = new C0357aU2();
    public static final C1219oV2 d = new C1219oV2();
    public static final C1454sW2 e = new C1454sW2();

    public m50(Context context) {
        Preconditions.checkNotNull(context);
        this.a = context;
    }

    public static int a(Context context, String str) {
        try {
            Class<?> clsLoadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.equal(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e2) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e2.getMessage())));
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0099, code lost:
    
        if (r10 != 0) goto L23;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0097 A[Catch: all -> 0x008d, TryCatch #10 {all -> 0x008d, blocks: (B:9:0x0053, B:13:0x0081, B:21:0x0097, B:24:0x009d, B:27:0x00b5, B:105:0x0219, B:106:0x0223, B:109:0x0226, B:110:0x0227, B:111:0x022e, B:112:0x022f, B:114:0x024d, B:116:0x025a), top: B:162:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009d A[Catch: all -> 0x008d, TRY_LEAVE, TryCatch #10 {all -> 0x008d, blocks: (B:9:0x0053, B:13:0x0081, B:21:0x0097, B:24:0x009d, B:27:0x00b5, B:105:0x0219, B:106:0x0223, B:109:0x0226, B:110:0x0227, B:111:0x022e, B:112:0x022f, B:114:0x024d, B:116:0x025a), top: B:162:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b3  */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v3, types: [bZ2] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.m50 c(android.content.Context r23, defpackage.l50 r24, java.lang.String r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 781
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m50.c(android.content.Context, l50, java.lang.String):m50");
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00b0 A[Catch: all -> 0x003c, TryCatch #12 {, blocks: (B:9:0x0026, B:11:0x0032, B:53:0x00b9, B:14:0x0038, B:19:0x0043, B:21:0x0049, B:26:0x004f, B:28:0x0053, B:32:0x005d, B:34:0x0065, B:37:0x006c, B:44:0x0098, B:45:0x00a0, B:40:0x0073, B:42:0x0079, B:43:0x008a, B:48:0x00a3, B:51:0x00a6, B:52:0x00b0, B:18:0x003f), top: B:144:0x0026, inners: #10 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int d(android.content.Context r10, java.lang.String r11, boolean r12) {
        /*
            Method dump skipped, instruction units count: 535
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m50.d(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0097 A[PHI: r9
      0x0097: PHI (r9v8 boolean) = (r9v7 boolean), (r9v12 boolean), (r9v12 boolean) binds: [B:11:0x0055, B:29:0x008e, B:31:0x0092] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int e(android.content.Context r8, java.lang.String r9, boolean r10, boolean r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m50.e(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    public static void f(ClassLoader classLoader) throws DynamiteModule$LoadingException {
        try {
            P13 p13 = null;
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if (iBinder != null) {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                p13 = iInterfaceQueryLocalInterface instanceof P13 ? (P13) iInterfaceQueryLocalInterface : new P13(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
            }
            o = p13;
        } catch (ClassNotFoundException e2) {
            e = e2;
            throw new DynamiteModule$LoadingException("Failed to instantiate dynamite loader", e);
        } catch (IllegalAccessException e3) {
            e = e3;
            throw new DynamiteModule$LoadingException("Failed to instantiate dynamite loader", e);
        } catch (InstantiationException e4) {
            e = e4;
            throw new DynamiteModule$LoadingException("Failed to instantiate dynamite loader", e);
        } catch (NoSuchMethodException e5) {
            e = e5;
            throw new DynamiteModule$LoadingException("Failed to instantiate dynamite loader", e);
        } catch (InvocationTargetException e6) {
            e = e6;
            throw new DynamiteModule$LoadingException("Failed to instantiate dynamite loader", e);
        }
    }

    public static boolean g(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(j)) {
            return true;
        }
        boolean z = false;
        if (j == null) {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 10000000) == 0 && providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                z = true;
            }
            j = Boolean.valueOf(z);
            if (z && (applicationInfo = providerInfoResolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                h = true;
            }
        }
        if (!z) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z;
    }

    public static C1061m13 h(Context context) {
        C1061m13 c1061m13;
        synchronized (m50.class) {
            C1061m13 c1061m132 = n;
            if (c1061m132 != null) {
                return c1061m132;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    c1061m13 = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    c1061m13 = iInterfaceQueryLocalInterface instanceof C1061m13 ? (C1061m13) iInterfaceQueryLocalInterface : new C1061m13(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
                }
                if (c1061m13 != null) {
                    n = c1061m13;
                    return c1061m13;
                }
            } catch (Exception e2) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e2.getMessage());
            }
            return null;
        }
    }

    public final IBinder b(String str) throws DynamiteModule$LoadingException {
        try {
            return (IBinder) this.a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            throw new DynamiteModule$LoadingException("Failed to instantiate module class: ".concat(str), e2);
        }
    }
}
