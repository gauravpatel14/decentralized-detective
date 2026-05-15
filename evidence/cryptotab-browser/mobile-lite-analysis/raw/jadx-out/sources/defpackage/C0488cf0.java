package defpackage;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.InvalidRegistrarException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: cf0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0488cf0 {
    public static final Object j = new Object();
    public static final ExecutorC0367af0 k = new ExecutorC0367af0();
    public static final gf l = new gf(0);
    public final Context a;
    public final String b;
    public final C0001Af0 c;
    public final sI d;
    public final mE0 g;
    public final InterfaceC0988kn1 h;
    public final AtomicBoolean e = new AtomicBoolean(false);
    public final AtomicBoolean f = new AtomicBoolean();
    public final CopyOnWriteArrayList i = new CopyOnWriteArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.util.List] */
    public C0488cf0(final Context context, String str, C0001Af0 c0001Af0) {
        ?? arrayList;
        new CopyOnWriteArrayList();
        this.a = (Context) Preconditions.checkNotNull(context);
        this.b = Preconditions.checkNotEmpty(str);
        this.c = (C0001Af0) Preconditions.checkNotNull(c0001Af0);
        ArrayList arrayList2 = new ArrayList();
        Bundle bundle = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                Log.w("ComponentDiscovery", "Context has no PackageManager.");
            } else {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) ComponentDiscoveryService.class), 128);
                if (serviceInfo == null) {
                    Log.w("ComponentDiscovery", ComponentDiscoveryService.class + " has no service info.");
                } else {
                    bundle = serviceInfo.metaData;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("ComponentDiscovery", "Application info not found.");
        }
        if (bundle == null) {
            Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
            arrayList = Collections.emptyList();
        } else {
            arrayList = new ArrayList();
            for (String str2 : bundle.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(bundle.get(str2)) && str2.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str2.substring(31));
                }
            }
        }
        for (final String str3 : arrayList) {
            arrayList2.add(new InterfaceC0988kn1() { // from class: mI
                @Override // defpackage.InterfaceC0988kn1
                public final Object get() {
                    String str4 = str3;
                    try {
                        Class<?> cls = Class.forName(str4);
                        if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                            return (ComponentRegistrar) cls.getDeclaredConstructor(null).newInstance(null);
                        }
                        throw new InvalidRegistrarException("Class " + str4 + " is not an instance of com.google.firebase.components.ComponentRegistrar");
                    } catch (ClassNotFoundException unused2) {
                        Log.w("ComponentDiscovery", "Class " + str4 + " is not an found.");
                        return null;
                    } catch (IllegalAccessException e) {
                        throw new InvalidRegistrarException(BN0.a("Could not instantiate ", str4, "."), e);
                    } catch (InstantiationException e2) {
                        throw new InvalidRegistrarException(BN0.a("Could not instantiate ", str4, "."), e2);
                    } catch (NoSuchMethodException e3) {
                        throw new InvalidRegistrarException(Xd0.a("Could not instantiate ", str4), e3);
                    } catch (InvocationTargetException e4) {
                        throw new InvalidRegistrarException(Xd0.a("Could not instantiate ", str4), e4);
                    }
                }
            });
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        arrayList3.addAll(arrayList2);
        final FirebaseCommonRegistrar firebaseCommonRegistrar = new FirebaseCommonRegistrar();
        arrayList3.add(new InterfaceC0988kn1() { // from class: rI
            @Override // defpackage.InterfaceC0988kn1
            public final Object get() {
                return firebaseCommonRegistrar;
            }
        });
        arrayList4.add(UH.b(context, Context.class, new Class[0]));
        arrayList4.add(UH.b(this, C0488cf0.class, new Class[0]));
        arrayList4.add(UH.b(c0001Af0, C0001Af0.class, new Class[0]));
        sI sIVar = new sI(k, arrayList3, arrayList4);
        this.d = sIVar;
        this.g = new mE0(new InterfaceC0988kn1() { // from class: Xe0
            @Override // defpackage.InterfaceC0988kn1
            public final Object get() {
                boolean z;
                ApplicationInfo applicationInfo;
                Bundle bundle2;
                C0488cf0 c0488cf0 = this.a;
                String strD = c0488cf0.d();
                KT kt = new KT();
                Context contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
                SharedPreferences sharedPreferences = contextCreateDeviceProtectedStorageContext.getSharedPreferences("com.google.firebase.common.prefs:" + strD, 0);
                boolean z2 = true;
                if (sharedPreferences.contains("firebase_data_collection_default_enabled")) {
                    z = sharedPreferences.getBoolean("firebase_data_collection_default_enabled", true);
                } else {
                    try {
                        PackageManager packageManager2 = contextCreateDeviceProtectedStorageContext.getPackageManager();
                        if (packageManager2 != null && (applicationInfo = packageManager2.getApplicationInfo(contextCreateDeviceProtectedStorageContext.getPackageName(), 128)) != null && (bundle2 = applicationInfo.metaData) != null && bundle2.containsKey("firebase_data_collection_default_enabled")) {
                            z2 = applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
                        }
                    } catch (PackageManager.NameNotFoundException unused2) {
                    }
                    z = z2;
                }
                kt.a = z;
                return kt;
            }
        });
        this.h = sIVar.b(RV.class);
        Ye0 ye0 = new Ye0(this);
        a();
        if (this.e.get()) {
            BackgroundDetector.getInstance().isInBackground();
        }
        this.i.add(ye0);
    }

    public static C0488cf0 c() {
        C0488cf0 c0488cf0;
        synchronized (j) {
            try {
                c0488cf0 = (C0488cf0) l.get("[DEFAULT]");
                if (c0488cf0 == null) {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.getMyProcessName() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0488cf0;
    }

    public static C0488cf0 f(Context context, C0001Af0 c0001Af0) {
        C0488cf0 c0488cf0;
        AtomicReference atomicReference = C0311Ze0.a;
        if (PlatformVersion.isAtLeastIceCreamSandwich() && (context.getApplicationContext() instanceof Application)) {
            Application application = (Application) context.getApplicationContext();
            AtomicReference atomicReference2 = C0311Ze0.a;
            if (atomicReference2.get() == null) {
                C0311Ze0 c0311Ze0 = new C0311Ze0();
                while (true) {
                    if (atomicReference2.compareAndSet(null, c0311Ze0)) {
                        BackgroundDetector.initialize(application);
                        BackgroundDetector.getInstance().addListener(c0311Ze0);
                        break;
                    }
                    if (atomicReference2.get() != null) {
                        break;
                    }
                }
            }
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (j) {
            gf gfVar = l;
            Preconditions.checkState(!gfVar.containsKey("[DEFAULT]"), "FirebaseApp name [DEFAULT] already exists!");
            Preconditions.checkNotNull(context, "Application context cannot be null.");
            c0488cf0 = new C0488cf0(context, "[DEFAULT]", c0001Af0);
            gfVar.put("[DEFAULT]", c0488cf0);
        }
        c0488cf0.e();
        return c0488cf0;
    }

    public final void a() {
        Preconditions.checkState(!this.f.get(), "FirebaseApp was deleted");
    }

    public final Object b(Class cls) {
        a();
        return this.d.a(cls);
    }

    public final String d() {
        StringBuilder sb = new StringBuilder();
        a();
        sb.append(Base64Utils.encodeUrlSafeNoPadding(this.b.getBytes(Charset.defaultCharset())));
        sb.append("+");
        a();
        sb.append(Base64Utils.encodeUrlSafeNoPadding(this.c.b.getBytes(Charset.defaultCharset())));
        return sb.toString();
    }

    public final void e() {
        HashMap map;
        if (!((UserManager) this.a.getSystemService(UserManager.class)).isUserUnlocked()) {
            StringBuilder sb = new StringBuilder("Device in Direct Boot Mode: postponing initialization of Firebase APIs for app ");
            a();
            sb.append(this.b);
            Log.i("FirebaseApp", sb.toString());
            Context context = this.a;
            AtomicReference atomicReference = C0427bf0.b;
            if (atomicReference.get() == null) {
                C0427bf0 c0427bf0 = new C0427bf0(context);
                while (!atomicReference.compareAndSet(null, c0427bf0)) {
                    if (atomicReference.get() != null) {
                        return;
                    }
                }
                context.registerReceiver(c0427bf0, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder("Device unlocked: initializing all Firebase APIs for app ");
        a();
        sb2.append(this.b);
        Log.i("FirebaseApp", sb2.toString());
        sI sIVar = this.d;
        a();
        boolean zEquals = "[DEFAULT]".equals(this.b);
        AtomicReference atomicReference2 = sIVar.e;
        Boolean boolValueOf = Boolean.valueOf(zEquals);
        while (true) {
            if (atomicReference2.compareAndSet(null, boolValueOf)) {
                synchronized (sIVar) {
                    map = new HashMap(sIVar.a);
                }
                sIVar.e(map, zEquals);
                break;
            } else if (atomicReference2.get() != null) {
                break;
            }
        }
        ((RV) this.h.get()).b();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0488cf0)) {
            return false;
        }
        C0488cf0 c0488cf0 = (C0488cf0) obj;
        c0488cf0.a();
        return this.b.equals(c0488cf0.b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("name", this.b).add("options", this.c).toString();
    }
}
