package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;

/* JADX INFO: renamed from: oT, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1216oT {
    public final Intent a;
    public final Bundle b;

    public C1216oT(Intent intent, Bundle bundle) {
        this.a = intent;
        this.b = bundle;
    }

    public static vR a(Intent intent, int i) {
        Bundle bundle;
        if (i < 0 || i > 2 || i == 0) {
            throw new IllegalArgumentException(AbstractC1214oR1.a(i, "Invalid colorScheme: "));
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return vR.a(null);
        }
        vR vRVarA = vR.a(extras);
        SparseArray sparseParcelableArray = extras.getSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS");
        if (sparseParcelableArray == null || (bundle = (Bundle) sparseParcelableArray.get(i)) == null) {
            return vRVarA;
        }
        vR vRVarA2 = vR.a(bundle);
        Integer num = vRVarA2.a;
        if (num == null) {
            num = vRVarA.a;
        }
        Integer num2 = vRVarA2.b;
        if (num2 == null) {
            num2 = vRVarA.b;
        }
        Integer num3 = vRVarA2.c;
        if (num3 == null) {
            num3 = vRVarA.c;
        }
        Integer num4 = vRVarA2.d;
        if (num4 == null) {
            num4 = vRVarA.d;
        }
        return new vR(num, num2, num3, num4);
    }
}
