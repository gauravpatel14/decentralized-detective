package defpackage;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class q61 implements r61 {
    @Override // defpackage.r61
    public final ArrayList a(String str, PackageManager packageManager) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
        ArrayList arrayList = new ArrayList(packageInfo.signatures.length);
        for (Signature signature : packageInfo.signatures) {
            byte[] bArrA = s61.a(signature);
            if (bArrA == null) {
                return null;
            }
            arrayList.add(bArrA);
        }
        return arrayList;
    }

    @Override // defpackage.r61
    public final boolean b(String str, PackageManager packageManager, Ra2 ra2) throws IOException {
        ArrayList arrayListA;
        ra2.b();
        String str2 = ra2.b;
        if (str2 == null) {
            throw new IllegalStateException();
        }
        if (str.equals(str2) && (arrayListA = a(str, packageManager)) != null) {
            return ra2.equals(Ra2.a(arrayListA, str));
        }
        return false;
    }
}
