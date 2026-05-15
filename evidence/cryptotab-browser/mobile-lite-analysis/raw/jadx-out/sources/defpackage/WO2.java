package defpackage;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class WO2 extends US2 {
    public char c;
    public long d;
    public String e;
    public final CO2 f;
    public final CO2 g;
    public final CO2 h;
    public final CO2 i;
    public final CO2 j;
    public final CO2 k;
    public final CO2 l;
    public final CO2 m;
    public final CO2 n;

    public WO2(C1391rR2 c1391rR2) {
        super(c1391rR2);
        this.c = (char) 0;
        this.d = -1L;
        this.f = new CO2(this, 6, false, false);
        this.g = new CO2(this, 6, true, false);
        this.h = new CO2(this, 6, false, true);
        this.i = new CO2(this, 5, false, false);
        this.j = new CO2(this, 5, true, false);
        this.k = new CO2(this, 5, false, true);
        this.l = new CO2(this, 4, false, false);
        this.m = new CO2(this, 3, false, false);
        this.n = new CO2(this, 2, false, false);
    }

    public static DO2 n(String str) {
        if (str == null) {
            return null;
        }
        return new DO2(str);
    }

    public static String o(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String strP = p(z, obj);
        String strP2 = p(z, obj2);
        String strP3 = p(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strP)) {
            sb.append(str2);
            sb.append(strP);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strP2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(strP2);
        }
        if (!TextUtils.isEmpty(strP3)) {
            sb.append(str3);
            sb.append(strP3);
        }
        return sb.toString();
    }

    public static String p(boolean z, Object obj) {
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            if (!z) {
                return obj.toString();
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return obj.toString();
            }
            String str = obj.toString().charAt(0) == '-' ? "-" : "";
            String strValueOf = String.valueOf(Math.abs(l.longValue()));
            return str + Math.round(Math.pow(10.0d, strValueOf.length() - 1)) + "..." + str + Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
        }
        if (obj instanceof Boolean) {
            return obj.toString();
        }
        if (!(obj instanceof Throwable)) {
            return obj instanceof DO2 ? ((DO2) obj).a : z ? "-" : obj.toString();
        }
        Throwable th = (Throwable) obj;
        StringBuilder sb = new StringBuilder(z ? th.getClass().getName() : th.toString());
        String canonicalName = C1391rR2.class.getCanonicalName();
        if (TextUtils.isEmpty(canonicalName)) {
            canonicalName = "";
        } else {
            int iLastIndexOf = canonicalName.lastIndexOf(46);
            if (iLastIndexOf != -1) {
                canonicalName = canonicalName.substring(0, iLastIndexOf);
            }
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i];
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null) {
                if (TextUtils.isEmpty(className)) {
                    className = "";
                } else {
                    int iLastIndexOf2 = className.lastIndexOf(46);
                    if (iLastIndexOf2 != -1) {
                        className = className.substring(0, iLastIndexOf2);
                    }
                }
                if (className.equals(canonicalName)) {
                    sb.append(": ");
                    sb.append(stackTraceElement);
                    break;
                }
            }
            i++;
        }
        return sb.toString();
    }

    @Override // defpackage.US2
    public final boolean h() {
        return false;
    }

    public final CO2 k() {
        return this.f;
    }

    public final CO2 l() {
        return this.n;
    }

    public final CO2 m() {
        return this.i;
    }

    public final String q() {
        String str;
        synchronized (this) {
            try {
                if (this.e == null) {
                    C1391rR2 c1391rR2 = this.a;
                    String str2 = c1391rR2.d;
                    if (str2 != null) {
                        this.e = str2;
                    } else {
                        c1391rR2.g.a.getClass();
                        this.e = "FA";
                    }
                }
                Preconditions.checkNotNull(this.e);
                str = this.e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public final void r(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && Log.isLoggable(q(), i)) {
            Log.println(i, q(), o(false, str, obj, obj2, obj3));
        }
        if (z2 || i < 5) {
            return;
        }
        Preconditions.checkNotNull(str);
        C0899jR2 c0899jR2 = this.a.j;
        if (c0899jR2 == null) {
            Log.println(6, q(), "Scheduler not set. Not logging error/warn");
        } else {
            if (!c0899jR2.b) {
                Log.println(6, q(), "Scheduler not initialized. Not logging error/warn");
                return;
            }
            if (i >= 9) {
                i = 8;
            }
            c0899jR2.o(new AO2(this, i, str, obj, obj2, obj3));
        }
    }
}
