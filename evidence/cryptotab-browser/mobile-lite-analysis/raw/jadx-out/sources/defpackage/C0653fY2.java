package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzaw;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: renamed from: fY2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0653fY2 extends US2 {
    public static final String[] g = {"firebase_", "google_", "ga_"};
    public static final String[] h = {"_err"};
    public SecureRandom c;
    public final AtomicLong d;
    public int e;
    public Integer f;

    public C0653fY2(C1391rR2 c1391rR2) {
        super(c1391rR2);
        this.f = null;
        this.d = new AtomicLong(0L);
    }

    public static boolean N(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    public static boolean P(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static boolean Q(String str) {
        Preconditions.checkNotEmpty(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    public static boolean R(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean S(String str, String str2, String str3, String str4) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        if (!zIsEmpty && !zIsEmpty2) {
            Preconditions.checkNotNull(str);
            return !str.equals(str2);
        }
        if (zIsEmpty && zIsEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (zIsEmpty) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    public static byte[] T(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    public static final boolean U(int i, Bundle bundle) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i);
        return true;
    }

    public static boolean X(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (Object obj : strArr) {
            if (str == obj) {
                return true;
            }
            if (str != null && str.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public static long e0(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int length = bArr.length;
        int i = 0;
        Preconditions.checkState(length > 0);
        long j = 0;
        for (int i2 = length - 1; i2 >= 0 && i2 >= bArr.length - 8; i2--) {
            j += (((long) bArr[i2]) & 255) << i;
            i += 8;
        }
        return j;
    }

    public static String m(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    public static MessageDigest n() {
        MessageDigest messageDigest;
        for (int i = 0; i < 2; i++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    public static ArrayList p(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzac zzacVar = (zzac) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzacVar.t);
            bundle.putString("origin", zzacVar.u);
            bundle.putLong("creation_timestamp", zzacVar.w);
            bundle.putString("name", zzacVar.v.u);
            YS2.b(bundle, Preconditions.checkNotNull(zzacVar.v.f2()));
            bundle.putBoolean("active", zzacVar.x);
            String str = zzacVar.y;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            zzaw zzawVar = zzacVar.z;
            if (zzawVar != null) {
                bundle.putString("timed_out_event_name", zzawVar.t);
                zzau zzauVar = zzawVar.u;
                if (zzauVar != null) {
                    bundle.putBundle("timed_out_event_params", zzauVar.f2());
                }
            }
            bundle.putLong("trigger_timeout", zzacVar.A);
            zzaw zzawVar2 = zzacVar.B;
            if (zzawVar2 != null) {
                bundle.putString("triggered_event_name", zzawVar2.t);
                zzau zzauVar2 = zzawVar2.u;
                if (zzauVar2 != null) {
                    bundle.putBundle("triggered_event_params", zzauVar2.f2());
                }
            }
            bundle.putLong("triggered_timestamp", zzacVar.v.v);
            bundle.putLong("time_to_live", zzacVar.C);
            zzaw zzawVar3 = zzacVar.D;
            if (zzawVar3 != null) {
                bundle.putString("expired_event_name", zzawVar3.t);
                zzau zzauVar3 = zzawVar3.u;
                if (zzauVar3 != null) {
                    bundle.putBundle("expired_event_params", zzauVar3.f2());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static void s(TU2 tu2, Bundle bundle, boolean z) {
        if (bundle != null && tu2 != null) {
            if (!bundle.containsKey("_sc") || z) {
                String str = tu2.a;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = tu2.b;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", tu2.c);
                return;
            }
            z = false;
        }
        if (bundle != null && tu2 == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public static void v(InterfaceC0536dY2 interfaceC0536dY2, String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        U(i, bundle);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", i2);
        }
        interfaceC0536dY2.a(str, bundle);
    }

    public final void A(NI2 ni2, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            ni2.e(bundle);
        } catch (RemoteException e) {
            WO2 wo2 = this.a.i;
            C1391rR2.k(wo2);
            wo2.i.b(e, "Error returning byte array to wrapper");
        }
    }

    public final void B(NI2 ni2, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            ni2.e(bundle);
        } catch (RemoteException e) {
            WO2 wo2 = this.a.i;
            C1391rR2.k(wo2);
            wo2.i.b(e, "Error returning int value to wrapper");
        }
    }

    public final void C(NI2 ni2, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            ni2.e(bundle);
        } catch (RemoteException e) {
            WO2 wo2 = this.a.i;
            C1391rR2.k(wo2);
            wo2.i.b(e, "Error returning long value to wrapper");
        }
    }

    public final void D(String str, NI2 ni2) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            ni2.e(bundle);
        } catch (RemoteException e) {
            WO2 wo2 = this.a.i;
            C1391rR2.k(wo2);
            wo2.i.b(e, "Error returning string value to wrapper");
        }
    }

    public final void E(String str, String str2, String str3, Bundle bundle, List list, boolean z) {
        int iB0;
        WO2 wo2;
        String str4;
        int I;
        if (bundle == null) {
            return;
        }
        C1391rR2 c1391rR2 = this.a;
        c1391rR2.getClass();
        int i = 0;
        for (String str5 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str5)) {
                iB0 = !z ? b0(str5) : 0;
                if (iB0 == 0) {
                    iB0 = a0(str5);
                }
            } else {
                iB0 = 0;
            }
            if (iB0 != 0) {
                r(bundle, iB0, str5, iB0 == 3 ? str5 : null);
                bundle.remove(str5);
            } else {
                boolean zN = N(bundle.get(str5));
                WO2 wo22 = c1391rR2.i;
                if (zN) {
                    C1391rR2.k(wo22);
                    wo22.k.d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str5);
                    I = 22;
                    wo2 = wo22;
                    str4 = str5;
                } else {
                    wo2 = wo22;
                    str4 = str5;
                    I = I(str, str2, str5, bundle.get(str5), bundle, list, z, false);
                }
                if (I != 0 && !"_ev".equals(str4)) {
                    r(bundle, I, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else if (Q(str4) && !X(str4, AbstractC0475cT2.d) && (i = i + 1) > 0) {
                    C1391rR2.k(wo2);
                    C1672wO2 c1672wO2 = c1391rR2.m;
                    wo2.h.c(c1672wO2.b(str2), c1672wO2.a(bundle), "Item cannot contain custom parameters");
                    U(23, bundle);
                    bundle.remove(str4);
                }
            }
        }
    }

    public final boolean F(String str, String str2) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        C1391rR2 c1391rR2 = this.a;
        if (!zIsEmpty) {
            Preconditions.checkNotNull(str);
            if (str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$")) {
                return true;
            }
            if (TextUtils.isEmpty(c1391rR2.b)) {
                WO2 wo2 = c1391rR2.i;
                C1391rR2.k(wo2);
                wo2.h.b(WO2.n(str), "Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id");
            }
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(c1391rR2.b)) {
                WO2 wo22 = c1391rR2.i;
                C1391rR2.k(wo22);
                wo22.h.a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        }
        Preconditions.checkNotNull(str2);
        if (str2.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$")) {
            return true;
        }
        WO2 wo23 = c1391rR2.i;
        C1391rR2.k(wo23);
        wo23.h.b(WO2.n(str2), "Invalid admob_app_id. Analytics disabled.");
        return false;
    }

    public final boolean G(int i, String str, String str2) {
        C1391rR2 c1391rR2 = this.a;
        if (str2 == null) {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.h.b(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        }
        WO2 wo22 = c1391rR2.i;
        C1391rR2.k(wo22);
        wo22.h.d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
        return false;
    }

    public final boolean H(String str, String[] strArr, String[] strArr2, String str2) {
        C1391rR2 c1391rR2 = this.a;
        if (str2 == null) {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.h.b(str, "Name is required and can't be null. Type");
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr3 = g;
        for (int i = 0; i < 3; i++) {
            if (str2.startsWith(strArr3[i])) {
                WO2 wo22 = c1391rR2.i;
                C1391rR2.k(wo22);
                wo22.h.c(str, str2, "Name starts with reserved prefix. Type, name");
                return false;
            }
        }
        if (strArr == null || !X(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && X(str2, strArr2)) {
            return true;
        }
        WO2 wo23 = c1391rR2.i;
        C1391rR2.k(wo23);
        wo23.h.c(str, str2, "Name is reserved. Type, name");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int I(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.Object r19, android.os.Bundle r20, java.util.List r21, boolean r22, boolean r23) {
        /*
            Method dump skipped, instruction units count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0653fY2.I(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    public final boolean J(Object obj, int i, String str, String str2) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String string = obj.toString();
            if (string.codePointCount(0, string.length()) > i) {
                WO2 wo2 = this.a.i;
                C1391rR2.k(wo2);
                wo2.k.d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(string.length()));
                return false;
            }
        }
        return true;
    }

    public final boolean K(String str, String str2) {
        C1391rR2 c1391rR2 = this.a;
        if (str2 == null) {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.h.b(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.length() == 0) {
            WO2 wo22 = c1391rR2.i;
            C1391rR2.k(wo22);
            wo22.h.b(str, "Name is required and can't be empty. Type");
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            if (iCodePointAt != 95) {
                WO2 wo23 = c1391rR2.i;
                C1391rR2.k(wo23);
                wo23.h.c(str, str2, "Name must start with a letter or _ (underscore). Type, name");
                return false;
            }
            iCodePointAt = 95;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                WO2 wo24 = c1391rR2.i;
                C1391rR2.k(wo24);
                wo24.h.c(str, str2, "Name must consist of letters, digits or _ (underscores). Type, name");
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final boolean L(String str, String str2) {
        C1391rR2 c1391rR2 = this.a;
        if (str2 == null) {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.h.b(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.length() == 0) {
            WO2 wo22 = c1391rR2.i;
            C1391rR2.k(wo22);
            wo22.h.b(str, "Name is required and can't be empty. Type");
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            WO2 wo23 = c1391rR2.i;
            C1391rR2.k(wo23);
            wo23.h.c(str, str2, "Name must start with a letter. Type, name");
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                WO2 wo24 = c1391rR2.i;
                C1391rR2.k(wo24);
                wo24.h.c(str, str2, "Name must consist of letters, digits or _ (underscores). Type, name");
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final boolean M(String str) {
        g();
        C1391rR2 c1391rR2 = this.a;
        if (Wrappers.packageManager(c1391rR2.a).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        WO2 wo2 = c1391rR2.i;
        C1391rR2.k(wo2);
        wo2.m.b(str, "Permission not granted");
        return false;
    }

    public final boolean O(Context context, String str) {
        Signature[] signatureArr;
        C1391rR2 c1391rR2 = this.a;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e) {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.f.b(e, "Package name not found");
            return true;
        } catch (CertificateException e2) {
            WO2 wo22 = c1391rR2.i;
            C1391rR2.k(wo22);
            wo22.f.b(e2, "Error obtaining certificate");
            return true;
        }
    }

    public final int V(String str) {
        boolean zEquals = "_ldl".equals(str);
        C1391rR2 c1391rR2 = this.a;
        if (zEquals) {
            c1391rR2.getClass();
            return 2048;
        }
        if ("_id".equals(str)) {
            c1391rR2.getClass();
            return 256;
        }
        if ("_lgclid".equals(str)) {
            c1391rR2.getClass();
            return 100;
        }
        c1391rR2.getClass();
        return 36;
    }

    public final Object W(int i, boolean z, boolean z2, Object obj) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(true != ((Boolean) obj).booleanValue() ? 0L : 1L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return m(obj.toString(), i, z);
        }
        if (!z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if (parcelable instanceof Bundle) {
                Bundle bundleH0 = h0((Bundle) parcelable);
                if (!bundleH0.isEmpty()) {
                    arrayList.add(bundleH0);
                }
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public final int Y(Object obj, String str) {
        return "_ldl".equals(str) ? J(obj, V(str), "user property referrer", str) : J(obj, V(str), "user property", str) ? 0 : 7;
    }

    public final int Z(String str) {
        if (!K("event", str)) {
            return 2;
        }
        if (!H("event", AbstractC0355aT2.a, AbstractC0355aT2.b, str)) {
            return 13;
        }
        this.a.getClass();
        return !G(40, "event", str) ? 2 : 0;
    }

    public final int a0(String str) {
        if (!K("event param", str)) {
            return 3;
        }
        if (!H("event param", null, null, str)) {
            return 14;
        }
        this.a.getClass();
        return !G(40, "event param", str) ? 3 : 0;
    }

    public final int b0(String str) {
        if (!L("event param", str)) {
            return 3;
        }
        if (!H("event param", null, null, str)) {
            return 14;
        }
        this.a.getClass();
        return !G(40, "event param", str) ? 3 : 0;
    }

    public final int c0(String str) {
        if (!K("user property", str)) {
            return 6;
        }
        if (!H("user property", AbstractC0645fT2.a, null, str)) {
            return 15;
        }
        this.a.getClass();
        return !G(24, "user property", str) ? 6 : 0;
    }

    public final int d0() {
        if (this.f == null) {
            this.f = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.a.a) / 1000);
        }
        return this.f.intValue();
    }

    public final long f0() {
        long andIncrement;
        long j;
        if (this.d.get() != 0) {
            synchronized (this.d) {
                this.d.compareAndSet(-1L, 1L);
                andIncrement = this.d.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (this.d) {
            long jNextLong = new Random(System.nanoTime() ^ this.a.n.currentTimeMillis()).nextLong();
            int i = this.e + 1;
            this.e = i;
            j = jNextLong + ((long) i);
        }
        return j;
    }

    public final Bundle g0(Uri uri, boolean z, boolean z2) {
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        String queryParameter5;
        String queryParameter6;
        String queryParameter7;
        if (uri != null) {
            try {
                if (uri.isHierarchical()) {
                    queryParameter = uri.getQueryParameter("utm_campaign");
                    queryParameter2 = uri.getQueryParameter("utm_source");
                    queryParameter3 = uri.getQueryParameter("utm_medium");
                    queryParameter4 = uri.getQueryParameter("gclid");
                    if (z) {
                        queryParameter5 = uri.getQueryParameter("utm_id");
                        queryParameter6 = uri.getQueryParameter("dclid");
                    } else {
                        queryParameter5 = null;
                        queryParameter6 = null;
                    }
                    queryParameter7 = z2 ? uri.getQueryParameter("srsltid") : null;
                } else {
                    queryParameter = null;
                    queryParameter2 = null;
                    queryParameter3 = null;
                    queryParameter4 = null;
                    queryParameter5 = null;
                    queryParameter6 = null;
                    queryParameter7 = null;
                }
                if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4) && ((!z || (TextUtils.isEmpty(queryParameter5) && TextUtils.isEmpty(queryParameter6))) && (!z2 || TextUtils.isEmpty(queryParameter7)))) {
                    return null;
                }
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(queryParameter)) {
                    bundle.putString("campaign", queryParameter);
                }
                if (!TextUtils.isEmpty(queryParameter2)) {
                    bundle.putString("source", queryParameter2);
                }
                if (!TextUtils.isEmpty(queryParameter3)) {
                    bundle.putString("medium", queryParameter3);
                }
                if (!TextUtils.isEmpty(queryParameter4)) {
                    bundle.putString("gclid", queryParameter4);
                }
                String queryParameter8 = uri.getQueryParameter("utm_term");
                if (!TextUtils.isEmpty(queryParameter8)) {
                    bundle.putString("term", queryParameter8);
                }
                String queryParameter9 = uri.getQueryParameter("utm_content");
                if (!TextUtils.isEmpty(queryParameter9)) {
                    bundle.putString("content", queryParameter9);
                }
                String queryParameter10 = uri.getQueryParameter("aclid");
                if (!TextUtils.isEmpty(queryParameter10)) {
                    bundle.putString("aclid", queryParameter10);
                }
                String queryParameter11 = uri.getQueryParameter("cp1");
                if (!TextUtils.isEmpty(queryParameter11)) {
                    bundle.putString("cp1", queryParameter11);
                }
                String queryParameter12 = uri.getQueryParameter("anid");
                if (!TextUtils.isEmpty(queryParameter12)) {
                    bundle.putString("anid", queryParameter12);
                }
                if (z) {
                    if (!TextUtils.isEmpty(queryParameter5)) {
                        bundle.putString("campaign_id", queryParameter5);
                    }
                    if (!TextUtils.isEmpty(queryParameter6)) {
                        bundle.putString("dclid", queryParameter6);
                    }
                    String queryParameter13 = uri.getQueryParameter("utm_source_platform");
                    if (!TextUtils.isEmpty(queryParameter13)) {
                        bundle.putString("source_platform", queryParameter13);
                    }
                    String queryParameter14 = uri.getQueryParameter("utm_creative_format");
                    if (!TextUtils.isEmpty(queryParameter14)) {
                        bundle.putString("creative_format", queryParameter14);
                    }
                    String queryParameter15 = uri.getQueryParameter("utm_marketing_tactic");
                    if (!TextUtils.isEmpty(queryParameter15)) {
                        bundle.putString("marketing_tactic", queryParameter15);
                    }
                }
                if (z2 && !TextUtils.isEmpty(queryParameter7)) {
                    bundle.putString("srsltid", queryParameter7);
                }
                return bundle;
            } catch (UnsupportedOperationException e) {
                WO2 wo2 = this.a.i;
                C1391rR2.k(wo2);
                wo2.i.b(e, "Install referrer url isn't a hierarchical URI");
            }
        }
        return null;
    }

    @Override // defpackage.US2
    public final boolean h() {
        return true;
    }

    public final Bundle h0(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object objK = k(bundle.get(str), str);
                if (objK == null) {
                    C1391rR2 c1391rR2 = this.a;
                    WO2 wo2 = c1391rR2.i;
                    C1391rR2.k(wo2);
                    wo2.k.b(c1391rR2.m.c(str), "Param value can't be null");
                } else {
                    w(bundle2, str, objK);
                }
            }
        }
        return bundle2;
    }

    public final Bundle i0(String str, String str2, Bundle bundle, List list, boolean z) {
        int iB0;
        int i;
        String str3;
        C1391rR2 c1391rR2;
        String str4 = str2;
        List list2 = list;
        boolean zX = X(str4, AbstractC0355aT2.d);
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        C1391rR2 c1391rR22 = this.a;
        int iJ = c1391rR22.g.j();
        int i2 = 0;
        for (String str5 : new TreeSet(bundle.keySet())) {
            if (list2 == null || !list2.contains(str5)) {
                iB0 = !z ? b0(str5) : 0;
                if (iB0 == 0) {
                    iB0 = a0(str5);
                }
            } else {
                iB0 = 0;
            }
            if (iB0 != 0) {
                r(bundle2, iB0, str5, iB0 == 3 ? str5 : null);
                bundle2.remove(str5);
                i = iJ;
                c1391rR2 = c1391rR22;
                str3 = str4;
            } else {
                i = iJ;
                C1391rR2 c1391rR23 = c1391rR22;
                int I = I(str, str2, str5, bundle.get(str5), bundle2, list, z, zX);
                if (I == 17) {
                    r(bundle2, 17, str5, Boolean.FALSE);
                } else {
                    if (I != 0 && !"_ev".equals(str5)) {
                        r(bundle2, I, I == 21 ? str2 : str5, bundle.get(str5));
                        bundle2.remove(str5);
                    }
                    str3 = str2;
                    c1391rR2 = c1391rR23;
                }
                if (Q(str5)) {
                    int i3 = i2 + 1;
                    if (i3 > i) {
                        StringBuilder sbA = AbstractC0672fs1.a(i, "Event can't contain more than ", " params");
                        WO2 wo2 = c1391rR23.i;
                        C1391rR2.k(wo2);
                        String string = sbA.toString();
                        C1672wO2 c1672wO2 = c1391rR23.m;
                        str3 = str2;
                        c1391rR2 = c1391rR23;
                        wo2.h.c(c1672wO2.b(str3), c1672wO2.a(bundle), string);
                        U(5, bundle2);
                        bundle2.remove(str5);
                    } else {
                        str3 = str2;
                        c1391rR2 = c1391rR23;
                    }
                    i2 = i3;
                } else {
                    str3 = str2;
                    c1391rR2 = c1391rR23;
                }
            }
            str4 = str3;
            c1391rR22 = c1391rR2;
            iJ = i;
            list2 = list;
        }
        return bundle2;
    }

    public final zzaw j0(String str, String str2, Bundle bundle, String str3, long j, boolean z) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (Z(str2) != 0) {
            C1391rR2 c1391rR2 = this.a;
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.f.b(c1391rR2.m.d(str2), "Invalid conditional property event name");
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str3);
        Bundle bundleI0 = i0(str, str2, bundle2, CollectionUtils.listOf("_o"), true);
        if (z) {
            bundleI0 = h0(bundleI0);
        }
        Preconditions.checkNotNull(bundleI0);
        return new zzaw(str2, new zzau(bundleI0), str3, j);
    }

    public final Object k(Object obj, String str) {
        boolean zEquals = "_ev".equals(str);
        int i = 256;
        C1391rR2 c1391rR2 = this.a;
        if (zEquals) {
            c1391rR2.getClass();
            return W(256, true, true, obj);
        }
        if (P(str)) {
            c1391rR2.getClass();
        } else {
            c1391rR2.getClass();
            i = 100;
        }
        return W(i, false, true, obj);
    }

    public final Object l(Object obj, String str) {
        return "_ldl".equals(str) ? W(V(str), true, false, obj) : W(V(str), false, false, obj);
    }

    public final SecureRandom o() {
        g();
        if (this.c == null) {
            this.c = new SecureRandom();
        }
        return this.c;
    }

    public final void q(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            WO2 wo2 = this.a.i;
            C1391rR2.k(wo2);
            wo2.i.b(Long.valueOf(j2), "Params already contained engagement");
        } else {
            j2 = 0;
        }
        bundle.putLong("_et", j + j2);
    }

    public final void r(Bundle bundle, int i, String str, Object obj) {
        if (U(i, bundle)) {
            this.a.getClass();
            bundle.putString("_ev", m(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", obj.toString().length());
                }
            }
        }
    }

    public final void t(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                C0653fY2 c0653fY2 = this.a.l;
                C1391rR2.i(c0653fY2);
                c0653fY2.w(bundle, str, bundle2.get(str));
            }
        }
    }

    public final void u(ZO2 zo2, int i) {
        Bundle bundle = zo2.d;
        int i2 = 0;
        for (String str : new TreeSet(bundle.keySet())) {
            if (Q(str) && (i2 = i2 + 1) > i) {
                StringBuilder sbA = AbstractC0672fs1.a(i, "Event can't contain more than ", " params");
                C1391rR2 c1391rR2 = this.a;
                WO2 wo2 = c1391rR2.i;
                C1391rR2.k(wo2);
                String string = sbA.toString();
                String str2 = zo2.a;
                C1672wO2 c1672wO2 = c1391rR2.m;
                wo2.h.c(c1672wO2.b(str2), c1672wO2.a(bundle), string);
                U(5, bundle);
                bundle.remove(str);
            }
        }
    }

    public final void w(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
            return;
        }
        if (str != null) {
            String simpleName = obj != null ? obj.getClass().getSimpleName() : null;
            C1391rR2 c1391rR2 = this.a;
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.k.c(c1391rR2.m.c(str), simpleName, "Not putting event parameter. Invalid value type. name, type");
        }
    }

    public final void x(NI2 ni2, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            ni2.e(bundle);
        } catch (RemoteException e) {
            WO2 wo2 = this.a.i;
            C1391rR2.k(wo2);
            wo2.i.b(e, "Error returning boolean value to wrapper");
        }
    }

    public final void y(NI2 ni2, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            ni2.e(bundle);
        } catch (RemoteException e) {
            WO2 wo2 = this.a.i;
            C1391rR2.k(wo2);
            wo2.i.b(e, "Error returning bundle list to wrapper");
        }
    }

    public final void z(NI2 ni2, Bundle bundle) {
        try {
            ni2.e(bundle);
        } catch (RemoteException e) {
            WO2 wo2 = this.a.i;
            C1391rR2.k(wo2);
            wo2.i.b(e, "Error returning bundle value to wrapper");
        }
    }
}
