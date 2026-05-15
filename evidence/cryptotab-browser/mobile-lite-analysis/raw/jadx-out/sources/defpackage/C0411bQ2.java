package defpackage;

import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

/* JADX INFO: renamed from: bQ2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0411bQ2 {
    public final C1391rR2 a;

    public C0411bQ2(QX2 qx2) {
        this.a = qx2.l;
    }

    public final boolean a() {
        C1391rR2 c1391rR2 = this.a;
        try {
            PackageManagerWrapper packageManagerWrapperPackageManager = Wrappers.packageManager(c1391rR2.a);
            if (packageManagerWrapperPackageManager != null) {
                return packageManagerWrapperPackageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300;
            }
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.n.a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e) {
            WO2 wo22 = c1391rR2.i;
            C1391rR2.k(wo22);
            wo22.n.b(e, "Failed to retrieve Play Store version for Install Referrer");
            return false;
        }
    }
}
