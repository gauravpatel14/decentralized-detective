package defpackage;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import java.util.Arrays;
import org.chromium.components.payments.PaymentRequestUpdateEventListener;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Mc1 {
    public static Mc1 e;
    public InterfaceC0991ks0 a;
    public PaymentRequestUpdateEventListener b;
    public PackageInfo c;
    public t61 d;

    public static Mc1 a() {
        if (e == null) {
            e = new Mc1();
        }
        return e;
    }

    public static void c(String str, InterfaceC0991ks0 interfaceC0991ks0) {
        if (interfaceC0991ks0 == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("error", str);
        try {
            ((is0) interfaceC0991ks0).X0(bundle);
        } catch (RemoteException e2) {
            Log.e("cr_PaymentDetailsUpdate", "Error calling updateWith", e2);
        }
    }

    public final boolean b(int i) {
        t61 t61Var = this.d;
        if (t61Var == null) {
            Log.e("cr_PaymentDetailsUpdate", "Caller's signature or package name does not match invoked app's.");
            return false;
        }
        t61Var.getClass();
        String nameForUid = AbstractC1499tM.a.getPackageManager().getNameForUid(i);
        PackageInfo packageInfoC = nameForUid == null ? null : C61.c(nameForUid, 64);
        PackageInfo packageInfo = this.c;
        if (packageInfo == null || packageInfoC == null || !packageInfo.packageName.equals(packageInfoC.packageName)) {
            Log.e("cr_PaymentDetailsUpdate", "Caller's signature or package name does not match invoked app's.");
            return false;
        }
        boolean zEquals = Arrays.equals(packageInfoC.signatures, this.c.signatures);
        if (!zEquals) {
            Log.e("cr_PaymentDetailsUpdate", "Caller's signature or package name does not match invoked app's.");
        }
        return zEquals;
    }
}
