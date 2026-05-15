package defpackage;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: renamed from: lD2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1009lD2 extends QS2 {
    public Boolean b;
    public InterfaceC0393bD2 c;
    public Boolean d;

    public final String h(String str) {
        C1391rR2 c1391rR2 = this.a;
        try {
            String str2 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, "");
            Preconditions.checkNotNull(str2);
            return str2;
        } catch (ClassNotFoundException e) {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.f.b(e, "Could not find SystemProperties class");
            return "";
        } catch (IllegalAccessException e2) {
            WO2 wo22 = c1391rR2.i;
            C1391rR2.k(wo22);
            wo22.f.b(e2, "Could not access SystemProperties.get()");
            return "";
        } catch (NoSuchMethodException e3) {
            WO2 wo23 = c1391rR2.i;
            C1391rR2.k(wo23);
            wo23.f.b(e3, "Could not find SystemProperties.get() method");
            return "";
        } catch (InvocationTargetException e4) {
            WO2 wo24 = c1391rR2.i;
            C1391rR2.k(wo24);
            wo24.f.b(e4, "SystemProperties.get() threw an exception");
            return "";
        }
    }

    public final double i(String str, C0467cO2 c0467cO2) {
        if (str == null) {
            return ((Double) c0467cO2.a(null)).doubleValue();
        }
        String strA = this.c.a(str, c0467cO2.a);
        if (TextUtils.isEmpty(strA)) {
            return ((Double) c0467cO2.a(null)).doubleValue();
        }
        try {
            return ((Double) c0467cO2.a(Double.valueOf(Double.parseDouble(strA)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) c0467cO2.a(null)).doubleValue();
        }
    }

    public final int j() {
        C0653fY2 c0653fY2 = this.a.l;
        C1391rR2.i(c0653fY2);
        Boolean bool = c0653fY2.a.s().e;
        if (c0653fY2.d0() < 201500) {
            return (bool == null || bool.booleanValue()) ? 25 : 100;
        }
        return 100;
    }

    public final int k(String str, C0467cO2 c0467cO2) {
        if (str == null) {
            return ((Integer) c0467cO2.a(null)).intValue();
        }
        String strA = this.c.a(str, c0467cO2.a);
        if (TextUtils.isEmpty(strA)) {
            return ((Integer) c0467cO2.a(null)).intValue();
        }
        try {
            return ((Integer) c0467cO2.a(Integer.valueOf(Integer.parseInt(strA)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) c0467cO2.a(null)).intValue();
        }
    }

    public final void l() {
        this.a.getClass();
    }

    public final long m(String str, C0467cO2 c0467cO2) {
        if (str == null) {
            return ((Long) c0467cO2.a(null)).longValue();
        }
        String strA = this.c.a(str, c0467cO2.a);
        if (TextUtils.isEmpty(strA)) {
            return ((Long) c0467cO2.a(null)).longValue();
        }
        try {
            return ((Long) c0467cO2.a(Long.valueOf(Long.parseLong(strA)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) c0467cO2.a(null)).longValue();
        }
    }

    public final Bundle n() {
        C1391rR2 c1391rR2 = this.a;
        try {
            if (c1391rR2.a.getPackageManager() == null) {
                WO2 wo2 = c1391rR2.i;
                C1391rR2.k(wo2);
                wo2.f.a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(c1391rR2.a).getApplicationInfo(c1391rR2.a.getPackageName(), 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            WO2 wo22 = c1391rR2.i;
            C1391rR2.k(wo22);
            wo22.f.a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            WO2 wo23 = c1391rR2.i;
            C1391rR2.k(wo23);
            wo23.f.b(e, "Failed to load metadata: Package name not found");
            return null;
        }
    }

    public final Boolean o(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle bundleN = n();
        if (bundleN != null) {
            if (bundleN.containsKey(str)) {
                return Boolean.valueOf(bundleN.getBoolean(str));
            }
            return null;
        }
        WO2 wo2 = this.a.i;
        C1391rR2.k(wo2);
        wo2.f.a("Failed to load metadata: Metadata bundle is null");
        return null;
    }

    public final boolean p(String str, C0467cO2 c0467cO2) {
        if (str == null) {
            return ((Boolean) c0467cO2.a(null)).booleanValue();
        }
        String strA = this.c.a(str, c0467cO2.a);
        return TextUtils.isEmpty(strA) ? ((Boolean) c0467cO2.a(null)).booleanValue() : ((Boolean) c0467cO2.a(Boolean.valueOf("1".equals(strA)))).booleanValue();
    }

    public final boolean q(String str) {
        return "1".equals(this.c.a(str, "gaia_collection_enabled"));
    }

    public final boolean r() {
        Boolean boolO = o("google_analytics_automatic_screen_reporting_enabled");
        return boolO == null || boolO.booleanValue();
    }

    public final boolean s() {
        this.a.getClass();
        Boolean boolO = o("firebase_analytics_collection_deactivated");
        return boolO != null && boolO.booleanValue();
    }

    public final boolean t(String str) {
        return "1".equals(this.c.a(str, "measurement.event_sampling_enabled"));
    }

    public final boolean u() {
        if (this.b == null) {
            Boolean boolO = o("app_measurement_lite");
            this.b = boolO;
            if (boolO == null) {
                this.b = Boolean.FALSE;
            }
        }
        return this.b.booleanValue() || !this.a.e;
    }
}
