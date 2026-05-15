package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.google.android.play.core.splitinstall.internal.zzbh;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class NM1 {
    public static final AtomicReference e = new AtomicReference(null);
    public final C0576eN2 a;
    public final C1491tG2 b;
    public final HashSet c = new HashSet();
    public final HB2 d;

    public NM1(Context context) {
        try {
            C0576eN2 c0576eN2 = new C0576eN2(context);
            this.a = c0576eN2;
            this.d = new HB2(c0576eN2);
            this.b = new C1491tG2(context);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new zzbh("Failed to initialize FileStorage", e2);
        }
    }

    public static boolean c(final Context context, boolean z) {
        boolean z2;
        AtomicReference atomicReference = e;
        NM1 nm1 = new NM1(context);
        while (true) {
            if (!atomicReference.compareAndSet(null, nm1)) {
                if (atomicReference.get() != null && atomicReference.get() != null) {
                    z2 = false;
                    break;
                }
            } else {
                z2 = true;
                break;
            }
        }
        NM1 nm12 = (NM1) atomicReference.get();
        if (z2) {
            GZ2 gz2 = GZ2.t;
            GZ2.u.set(new QD2(context, GK2.a(), new C0563eE2(context, nm12.a), nm12.a));
            C1536u03 c1536u03 = new C1536u03(nm12);
            AtomicReference atomicReference2 = I13.a;
            while (!atomicReference2.compareAndSet(null, c1536u03) && (atomicReference2.get() == null || atomicReference2.get() == null)) {
            }
            GK2.a().execute(new Runnable() { // from class: FZ2
                @Override // java.lang.Runnable
                public final void run() {
                    Context context2 = context;
                    AtomicReference atomicReference3 = NM1.e;
                    try {
                        C1189o33 c1189o33B = C1189o33.b(context2);
                        synchronized (c1189o33B) {
                            c1189o33B.f = true;
                            c1189o33B.a();
                        }
                    } catch (SecurityException unused) {
                        Log.e("SplitCompat", "Failed to set broadcast receiver to always on.");
                    }
                }
            });
        }
        try {
            nm12.b(context, z);
            return true;
        } catch (Exception e2) {
            Log.e("SplitCompat", "Error installing additional splits", e2);
            return false;
        }
    }

    public final void a(HashSet hashSet) throws IOException {
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            C0576eN2 c0576eN2 = this.a;
            c0576eN2.getClass();
            File file = new File(c0576eN2.g(), "verified-splits");
            C0576eN2.e(file);
            C0576eN2.c(C0576eN2.d(file, String.valueOf(str).concat(".apk")));
        }
        C1491tG2 c1491tG2 = this.b;
        c1491tG2.getClass();
        synchronized (C1491tG2.class) {
            c1491tG2.a.getSharedPreferences("playcore_split_install_internal", 0).edit().putStringSet("modules_to_uninstall_if_emulated", new HashSet()).apply();
        }
    }

    public final synchronized void b(Context context, boolean z) {
        try {
            if (z) {
                this.a.b();
            } else {
                GK2.a().execute(new RunnableC0817i13(this));
            }
            String packageName = context.getPackageName();
            try {
                String[] strArr = context.getPackageManager().getPackageInfo(packageName, 0).splitNames;
                List<String> arrayList = strArr == null ? new ArrayList() : Arrays.asList(strArr);
                HashSet<GF2> hashSetA = this.a.a();
                Set setA = this.b.a();
                HashSet hashSet = new HashSet();
                Iterator it = hashSetA.iterator();
                while (it.hasNext()) {
                    String str = ((GF2) it.next()).b;
                    if (!arrayList.contains(str)) {
                        C23 c23 = Z13.c;
                        if (setA.contains(str.startsWith("config.") ? "" : str.split("\\.config\\.", 2)[0])) {
                        }
                    }
                    hashSet.add(str);
                    it.remove();
                }
                if (z) {
                    a(hashSet);
                } else if (!hashSet.isEmpty()) {
                    GK2.a().execute(new H13(this, hashSet));
                }
                HashSet hashSet2 = new HashSet();
                Iterator it2 = hashSetA.iterator();
                while (it2.hasNext()) {
                    String str2 = ((GF2) it2.next()).b;
                    if (!Z13.d(str2)) {
                        hashSet2.add(str2);
                    }
                }
                for (String str3 : arrayList) {
                    if (!Z13.d(str3)) {
                        hashSet2.add(str3);
                    }
                }
                HashSet<GF2> hashSet3 = new HashSet(hashSetA.size());
                for (GF2 gf2 : hashSetA) {
                    String str4 = gf2.b;
                    C23 c232 = Z13.c;
                    if (!str4.startsWith("config.")) {
                        String str5 = gf2.b;
                        if (hashSet2.contains(str5.startsWith("config.") ? "" : str5.split("\\.config\\.", 2)[0])) {
                        }
                    }
                    hashSet3.add(gf2);
                }
                VY2 vy2 = new VY2(this.a);
                int i = Build.VERSION.SDK_INT;
                InterfaceC0946kE2 c1548uG2 = i != 26 ? (i == 27 && Build.VERSION.PREVIEW_SDK_INT == 0) ? new C1548uG2() : new FG2() : new C1198oG2();
                ClassLoader classLoader = context.getClassLoader();
                ZipFile zipFile = null;
                if (z) {
                    c1548uG2.b(classLoader, vy2.a());
                } else {
                    Iterator it3 = hashSet3.iterator();
                    while (it3.hasNext()) {
                        GF2 gf22 = (GF2) it3.next();
                        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
                        HashSet hashSet4 = new HashSet();
                        VY2.b(gf22, new C1561uS2(vy2, gf22, hashSet4, atomicBoolean));
                        if (!atomicBoolean.get()) {
                            hashSet4 = null;
                        }
                        if (hashSet4 == null) {
                            it3.remove();
                        } else {
                            c1548uG2.b(classLoader, hashSet4);
                        }
                    }
                }
                HashSet hashSet5 = new HashSet();
                for (GF2 gf23 : hashSet3) {
                    try {
                        ZipFile zipFile2 = new ZipFile(gf23.a);
                        try {
                            ZipEntry entry = zipFile2.getEntry("classes.dex");
                            zipFile2.close();
                            if (entry != null) {
                                C0576eN2 c0576eN2 = this.a;
                                String str6 = gf23.b;
                                c0576eN2.getClass();
                                File file = new File(c0576eN2.g(), "dex");
                                C0576eN2.e(file);
                                File fileD = C0576eN2.d(file, str6);
                                C0576eN2.e(fileD);
                                if (!c1548uG2.a(classLoader, fileD, gf23.a, z)) {
                                    Log.w("SplitCompat", "split was not installed ".concat(gf23.a.toString()));
                                }
                            }
                            hashSet5.add(gf23.a);
                        } catch (IOException e2) {
                            e = e2;
                            zipFile = zipFile2;
                            if (zipFile != null) {
                                try {
                                    zipFile.close();
                                } catch (IOException e3) {
                                    try {
                                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(e, e3);
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                            throw e;
                        }
                    } catch (IOException e4) {
                        e = e4;
                    }
                }
                this.d.a(context, hashSet5);
                HashSet hashSet6 = new HashSet();
                for (GF2 gf24 : hashSet3) {
                    if (hashSet5.contains(gf24.a)) {
                        hashSet6.add(gf24.b);
                    }
                }
                synchronized (this.c) {
                    this.c.addAll(hashSet6);
                }
            } catch (PackageManager.NameNotFoundException e5) {
                throw new IOException("Cannot load data for application '" + packageName + "'", e5);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
