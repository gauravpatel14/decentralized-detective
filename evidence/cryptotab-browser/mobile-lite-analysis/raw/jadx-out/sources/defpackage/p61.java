package defpackage;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class p61 implements r61 {
    @Override // defpackage.r61
    public final ArrayList a(String str, PackageManager packageManager) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = packageManager.getPackageInfo(str, 134217728);
        ArrayList arrayList = new ArrayList();
        SigningInfo signingInfo = packageInfo.signingInfo;
        if (signingInfo.hasMultipleSigners()) {
            for (Signature signature : signingInfo.getApkContentsSigners()) {
                arrayList.add(s61.a(signature));
            }
        } else {
            arrayList.add(s61.a(signingInfo.getSigningCertificateHistory()[0]));
        }
        return arrayList;
    }

    @Override // defpackage.r61
    public final boolean b(String str, PackageManager packageManager, Ra2 ra2) throws PackageManager.NameNotFoundException, IOException {
        ra2.b();
        String str2 = ra2.b;
        if (str2 == null) {
            throw new IllegalStateException();
        }
        if (!str2.equals(str)) {
            return false;
        }
        ArrayList arrayListA = a(str, packageManager);
        if (arrayListA.size() != 1) {
            return ra2.equals(Ra2.a(arrayListA, str));
        }
        ra2.b();
        ArrayList arrayList = ra2.c;
        if (arrayList != null) {
            return packageManager.hasSigningCertificate(str, Arrays.copyOf((byte[]) arrayList.get(0), ((byte[]) ra2.c.get(0)).length), 1);
        }
        throw new IllegalStateException();
    }
}
