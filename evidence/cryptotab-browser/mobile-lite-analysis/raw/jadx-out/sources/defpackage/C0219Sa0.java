package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.LocaleList;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.internal.zzbx;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: Sa0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0219Sa0 implements InterfaceC1023lN1 {
    public static final long o = TimeUnit.SECONDS.toMillis(1);
    public static final /* synthetic */ int p = 0;
    public final Handler a;
    public final Context b;
    public final Z13 c;
    public final QH2 d;
    public final C1604vH2 e;
    public final C1126n23 f;
    public final C1126n23 g;
    public final ThreadPoolExecutor h;
    public final GZ2 i;
    public final File j;
    public final AtomicReference k;
    public final Set l;
    public final Set m;
    public final AtomicBoolean n;

    public C0219Sa0(Context context, File file, Z13 z13, QH2 qh2) {
        ThreadPoolExecutor threadPoolExecutorA = GK2.a();
        C1604vH2 c1604vH2 = new C1604vH2(context);
        this.a = new Handler(Looper.getMainLooper());
        this.k = new AtomicReference();
        this.l = Collections.synchronizedSet(new HashSet());
        this.m = Collections.synchronizedSet(new HashSet());
        this.n = new AtomicBoolean(false);
        this.b = context;
        this.j = file;
        this.c = z13;
        this.d = qh2;
        this.h = threadPoolExecutorA;
        this.e = c1604vH2;
        this.g = new C1126n23();
        this.f = new C1126n23();
        this.i = GZ2.t;
    }

    @Override // defpackage.InterfaceC1023lN1
    public final G62 a(List list) {
        return Y62.d(new SplitInstallException(-5));
    }

    @Override // defpackage.InterfaceC1023lN1
    public final Set b() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.c.b());
        hashSet.addAll(this.l);
        return hashSet;
    }

    @Override // defpackage.InterfaceC1023lN1
    public final void c(InterfaceC1267pN1 interfaceC1267pN1) {
        C1126n23 c1126n23 = this.g;
        synchronized (c1126n23) {
            c1126n23.a.remove(interfaceC1267pN1);
        }
    }

    @Override // defpackage.InterfaceC1023lN1
    public final Set d() {
        HashSet hashSet = new HashSet();
        Z13 z13 = this.c;
        if (z13.c() != null) {
            hashSet.addAll(z13.c());
        }
        hashSet.addAll(this.m);
        return hashSet;
    }

    @Override // defpackage.InterfaceC1023lN1
    public final void e(InterfaceC1267pN1 interfaceC1267pN1) {
        C1126n23 c1126n23 = this.g;
        synchronized (c1126n23) {
            c1126n23.a.add(interfaceC1267pN1);
        }
    }

    @Override // defpackage.InterfaceC1023lN1
    public final G62 f(List list) {
        return Y62.d(new SplitInstallException(-5));
    }

    @Override // defpackage.InterfaceC1023lN1
    public final G62 g(C1207oN1 c1207oN1) {
        int iIndexOf;
        String string;
        ArrayList arrayList;
        Integer num;
        int i;
        File[] fileArr;
        String str;
        int i2;
        final C1207oN1 c1207oN12 = c1207oN1;
        char c = 0;
        int i3 = 2;
        try {
            IB2 ib2J = j(new K13() { // from class: mW2
                @Override // defpackage.K13
                public final IB2 a(IB2 ib2) {
                    int i4;
                    C1207oN1 c1207oN13 = c1207oN12;
                    int i5 = zzbx.t;
                    try {
                        int i6 = C0219Sa0.p;
                        if (ib2 != null && (i4 = ib2.b) != 0 && i4 != 5 && i4 != 6 && i4 != 7) {
                            throw new SplitInstallException(-1);
                        }
                        return IB2.a(ib2 != null ? 1 + ib2.a : 1, 1, 0, 0L, 0L, c1207oN13.a, new ArrayList());
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception e2) {
                        throw new zzbx("TunnelExceptions should always be unwrapped to deal with the checked exception underneath, this message should never be seen if TunnelException is used properly.", e2);
                    }
                }
            });
            if (ib2J == null) {
                return h(-100);
            }
            int i4 = ib2J.a;
            final ArrayList arrayList2 = new ArrayList();
            ArrayList<Locale> arrayList3 = c1207oN12.b;
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                arrayList2.add(((Locale) it.next()).getLanguage());
            }
            HashSet hashSet = new HashSet();
            final ArrayList arrayList4 = new ArrayList();
            File[] fileArrListFiles = this.j.listFiles(C1338qX2.a);
            String str2 = "FakeSplitInstallManager";
            if (fileArrListFiles == null) {
                Log.w("FakeSplitInstallManager", "Specified splits directory does not exist.");
                return h(-5);
            }
            int length = fileArrListFiles.length;
            int i5 = 0;
            long length2 = 0;
            while (true) {
                arrayList = c1207oN12.a;
                if (i5 >= length) {
                    break;
                }
                File file = fileArrListFiles[i5];
                String strA = FH2.a(file);
                String str3 = strA.split("\\.config\\.", i3)[c];
                hashSet.add(strA);
                if (arrayList.contains(str3)) {
                    String str4 = strA.split("\\.config\\.", 2)[c];
                    LocaleList locales = this.e.a.getResources().getConfiguration().getLocales();
                    fileArr = fileArrListFiles;
                    i2 = length;
                    ArrayList arrayList5 = new ArrayList(locales.size());
                    i = i4;
                    int i6 = 0;
                    while (true) {
                        str = str2;
                        if (i6 >= locales.size()) {
                            break;
                        }
                        Locale locale = locales.get(i6);
                        arrayList5.add(String.valueOf(locale.getLanguage()).concat(locale.getCountry().isEmpty() ? "" : "_".concat(String.valueOf(locale.getCountry()))));
                        i6++;
                        str2 = str;
                    }
                    HashSet<String> hashSet2 = new HashSet(arrayList5);
                    HashMap mapA = i().a(Arrays.asList(str4));
                    HashSet hashSet3 = new HashSet();
                    Iterator it2 = mapA.values().iterator();
                    while (it2.hasNext()) {
                        hashSet3.addAll((Set) it2.next());
                    }
                    HashSet hashSet4 = new HashSet();
                    for (String str5 : hashSet2) {
                        if (str5.contains("_")) {
                            str5 = str5.split("_", -1)[0];
                        }
                        hashSet4.add(str5);
                    }
                    hashSet4.addAll(this.m);
                    hashSet4.addAll(arrayList2);
                    HashSet hashSet5 = new HashSet();
                    for (Map.Entry entry : mapA.entrySet()) {
                        if (hashSet4.contains(entry.getKey())) {
                            hashSet5.addAll((Collection) entry.getValue());
                        }
                    }
                    if (!hashSet3.contains(strA) || hashSet5.contains(strA)) {
                        length2 = file.length() + length2;
                        arrayList4.add(file);
                        break;
                    }
                    i5++;
                    c1207oN12 = c1207oN1;
                    fileArrListFiles = fileArr;
                    length = i2;
                    i4 = i;
                    str2 = str;
                    c = 0;
                    i3 = 2;
                } else {
                    i = i4;
                    fileArr = fileArrListFiles;
                    str = str2;
                    i2 = length;
                }
                ArrayList arrayList6 = new ArrayList(this.l);
                arrayList6.addAll(Arrays.asList("", "base"));
                HashMap mapA2 = i().a(arrayList6);
                for (Locale locale2 : arrayList3) {
                    if (mapA2.containsKey(locale2.getLanguage()) && ((Set) mapA2.get(locale2.getLanguage())).contains(strA)) {
                        length2 = file.length() + length2;
                        arrayList4.add(file);
                        break;
                        break;
                    }
                }
                i5++;
                c1207oN12 = c1207oN1;
                fileArrListFiles = fileArr;
                length = i2;
                i4 = i;
                str2 = str;
                c = 0;
                i3 = 2;
            }
            int i7 = i4;
            Log.i(str2, "availableSplits " + hashSet.toString() + " want " + String.valueOf(arrayList));
            int size = arrayList.size();
            QH2 qh2 = this.d;
            if (size != 1 || (num = (Integer) ((C0830iI2) qh2.zza()).b.get(arrayList.get(0))) == null) {
                num = ((C0830iI2) qh2.zza()).a;
            }
            if (num != null) {
                return h(num.intValue());
            }
            if (!hashSet.containsAll(new HashSet(arrayList))) {
                return h(-2);
            }
            Long lValueOf = Long.valueOf(length2);
            Integer numValueOf = Integer.valueOf(i7);
            k(1, 0, numValueOf, 0L, lValueOf, arrayList, arrayList2);
            this.h.execute(new Runnable() { // from class: sY2
                @Override // java.lang.Runnable
                public final void run() {
                    final C0219Sa0 c0219Sa0 = this.t;
                    c0219Sa0.getClass();
                    final ArrayList arrayList7 = new ArrayList();
                    final ArrayList arrayList8 = new ArrayList();
                    for (File file2 : arrayList4) {
                        String strA2 = FH2.a(file2);
                        Uri uriFromFile = Uri.fromFile(file2);
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setDataAndType(uriFromFile, c0219Sa0.b.getContentResolver().getType(uriFromFile));
                        intent.addFlags(1);
                        intent.putExtra("module_name", strA2.split("\\.config\\.", 2)[0]);
                        intent.putExtra("split_id", strA2);
                        arrayList7.add(intent);
                        arrayList8.add(FH2.a(file2).split("\\.config\\.", 2)[0]);
                    }
                    IB2 ib2 = (IB2) c0219Sa0.k.get();
                    if (ib2 == null) {
                        return;
                    }
                    final ArrayList arrayList9 = arrayList2;
                    final long j = ib2.e;
                    c0219Sa0.h.execute(new Runnable() { // from class: XT2
                        @Override // java.lang.Runnable
                        public final void run() {
                            final long j2 = j;
                            long j3 = j2 / 3;
                            long jMin = 0;
                            int i8 = 0;
                            while (true) {
                                final C0219Sa0 c0219Sa02 = c0219Sa0;
                                if (i8 >= 3) {
                                    ThreadPoolExecutor threadPoolExecutor = c0219Sa02.h;
                                    final ArrayList arrayList10 = arrayList7;
                                    final ArrayList arrayList11 = arrayList8;
                                    final ArrayList arrayList12 = arrayList9;
                                    threadPoolExecutor.execute(new Runnable() { // from class: IK2
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            C0219Sa0 c0219Sa03 = c0219Sa02;
                                            if (c0219Sa03.n.get()) {
                                                c0219Sa03.k(6, -6, null, null, null, null, null);
                                                return;
                                            }
                                            GZ2 gz2 = c0219Sa03.i;
                                            gz2.getClass();
                                            AtomicReference atomicReference = GZ2.u;
                                            QD2 qd2 = (QD2) atomicReference.get();
                                            ArrayList arrayList13 = arrayList11;
                                            ArrayList arrayList14 = arrayList12;
                                            long j4 = j2;
                                            if (qd2 == null) {
                                                c0219Sa03.l.addAll(arrayList13);
                                                c0219Sa03.m.addAll(arrayList14);
                                                Long lValueOf2 = Long.valueOf(j4);
                                                c0219Sa03.k(5, 0, null, lValueOf2, lValueOf2, null, null);
                                                return;
                                            }
                                            ArrayList arrayList15 = arrayList10;
                                            gz2.getClass();
                                            QD2 qd22 = (QD2) atomicReference.get();
                                            C0877j13 c0877j13 = new C0877j13(c0219Sa03, arrayList13, arrayList14, j4, false, arrayList15);
                                            qd22.getClass();
                                            if (NM1.e.get() == null) {
                                                throw new IllegalStateException("Ingestion should only be called in SplitCompat mode.");
                                            }
                                            qd22.d.execute(new JD2(qd22, arrayList15, c0877j13));
                                        }
                                    });
                                    return;
                                }
                                c0219Sa02.getClass();
                                jMin = Math.min(j2, jMin + j3);
                                c0219Sa02.k(2, 0, null, Long.valueOf(jMin), Long.valueOf(j2), null, null);
                                SystemClock.sleep(C0219Sa0.o);
                                int i9 = ((IB2) c0219Sa02.k.get()).b;
                                if (i9 == 9 || i9 == 7 || i9 == 6) {
                                    return;
                                } else {
                                    i8++;
                                }
                            }
                        }
                    });
                }
            });
            return Y62.e(numValueOf);
        } catch (zzbx e) {
            Class[] clsArr = {SplitInstallException.class};
            for (int i8 = 0; i8 <= 0; i8++) {
                Class cls = clsArr[i8];
                if (RuntimeException.class.isAssignableFrom(cls)) {
                    Object[] objArr = new Object[2];
                    int i9 = 0;
                    objArr[0] = "getCause";
                    objArr[1] = cls;
                    int i10 = 0;
                    for (int i11 = 2; i10 < i11; i11 = 2) {
                        Object obj = objArr[i10];
                        if (obj == null) {
                            string = "null";
                        } else {
                            try {
                                string = obj.toString();
                            } catch (Exception e2) {
                                String str6 = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
                                "Exception during lenientFormat for ".concat(str6);
                                string = "<" + str6 + " threw " + e2.getClass().getName() + ">";
                            }
                        }
                        objArr[i10] = string;
                        i10++;
                    }
                    StringBuilder sb = new StringBuilder(118);
                    int i12 = 0;
                    while (i9 < 2 && (iIndexOf = "The cause of a TunnelException can never be a RuntimeException, but %s argument was %s".indexOf("%s", i12)) != -1) {
                        sb.append((CharSequence) "The cause of a TunnelException can never be a RuntimeException, but %s argument was %s", i12, iIndexOf);
                        sb.append(objArr[i9]);
                        i9++;
                        i12 = iIndexOf + 2;
                    }
                    sb.append((CharSequence) "The cause of a TunnelException can never be a RuntimeException, but %s argument was %s", i12, 86);
                    if (i9 < 2) {
                        sb.append(" [");
                        sb.append(objArr[i9]);
                        for (int i13 = i9 + 1; i13 < 2; i13++) {
                            sb.append(", ");
                            sb.append(objArr[i13]);
                        }
                        sb.append(']');
                    }
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            if (SplitInstallException.class.isInstance(e.getCause())) {
                return h(((SplitInstallException) ((Exception) SplitInstallException.class.cast(e.getCause()))).getErrorCode());
            }
            Exception cause = e.getCause();
            ClassCastException classCastException = new ClassCastException("getCause(" + SplitInstallException.class + ") doesn't match underlying exception");
            classCastException.initCause(cause);
            throw classCastException;
        }
    }

    public final C0939k33 h(final int i) {
        j(new K13() { // from class: v03
            @Override // defpackage.K13
            public final IB2 a(IB2 ib2) {
                int i2 = C0219Sa0.p;
                if (ib2 == null) {
                    return null;
                }
                List list = ib2.f;
                ArrayList arrayList = list != null ? new ArrayList(list) : new ArrayList();
                List list2 = ib2.g;
                return IB2.a(ib2.a, 6, i, ib2.d, ib2.e, arrayList, list2 != null ? new ArrayList(list2) : new ArrayList());
            }
        });
        return Y62.d(new SplitInstallException(i));
    }

    public final C1032lW2 i() {
        Context context = this.b;
        try {
            C1032lW2 c1032lW2A = this.c.a(context.getPackageManager().getPackageInfo(context.getPackageName(), 128).applicationInfo.metaData);
            if (c1032lW2A != null) {
                return c1032lW2A;
            }
            throw new IllegalStateException("Language information could not be found. Make sure you are using the target application context, not the tests context, and the app is built as a bundle.");
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalStateException("App is not found in PackageManager", e);
        }
    }

    public final synchronized IB2 j(K13 k13) {
        IB2 ib2 = (IB2) this.k.get();
        IB2 ib2A = k13.a(ib2);
        AtomicReference atomicReference = this.k;
        while (!atomicReference.compareAndSet(ib2, ib2A)) {
            if (atomicReference.get() != ib2 && atomicReference.get() != ib2) {
                return null;
            }
        }
        return ib2A;
    }

    public final boolean k(final int i, final int i2, final Integer num, final Long l, final Long l2, final ArrayList arrayList, final ArrayList arrayList2) {
        final IB2 ib2J = j(new K13() { // from class: CQ2
            @Override // defpackage.K13
            public final IB2 a(IB2 ib2) {
                ArrayList arrayList3;
                int i3 = C0219Sa0.p;
                if (ib2 == null) {
                    ib2 = IB2.a(0, 0, 0, 0L, 0L, new ArrayList(), new ArrayList());
                }
                Integer num2 = num;
                int iIntValue = num2 == null ? ib2.a : num2.intValue();
                Long l3 = l;
                long jLongValue = l3 == null ? ib2.d : l3.longValue();
                Long l4 = l2;
                long jLongValue2 = l4 == null ? ib2.e : l4.longValue();
                ArrayList arrayList4 = arrayList;
                if (arrayList4 == null) {
                    List list = ib2.f;
                    arrayList3 = list != null ? new ArrayList(list) : new ArrayList();
                } else {
                    arrayList3 = arrayList4;
                }
                ArrayList arrayList5 = arrayList2;
                if (arrayList5 == null) {
                    List list2 = ib2.g;
                    arrayList5 = list2 != null ? new ArrayList(list2) : new ArrayList();
                }
                return IB2.a(iIntValue, i, i2, jLongValue, jLongValue2, arrayList3, arrayList5);
            }
        });
        if (ib2J == null) {
            return false;
        }
        this.a.post(new Runnable() { // from class: KO2
            @Override // java.lang.Runnable
            public final void run() {
                C0219Sa0 c0219Sa0 = this.t;
                C1126n23 c1126n23 = c0219Sa0.f;
                IB2 ib2 = ib2J;
                c1126n23.a(ib2);
                c0219Sa0.g.a(ib2);
            }
        });
        return true;
    }
}
