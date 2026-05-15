package defpackage;

import android.content.pm.FeatureInfo;
import android.os.Build;

/* JADX INFO: renamed from: wx1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1704wx1 {
    public static Boolean a;

    public static int a(int i) {
        Boolean bool = a;
        if (bool == null && bool == null) {
            if ("SAMSUNG".equalsIgnoreCase(Build.MANUFACTURER)) {
                FeatureInfo[] systemAvailableFeatures = AbstractC1499tM.a.getPackageManager().getSystemAvailableFeatures();
                int length = systemAvailableFeatures.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        a = Boolean.FALSE;
                        break;
                    }
                    if ("com.sec.feature.spen_usp".equalsIgnoreCase(systemAvailableFeatures[i2].name)) {
                        a = Boolean.TRUE;
                        break;
                    }
                    i2++;
                }
            } else {
                a = Boolean.FALSE;
            }
        }
        if (!a.booleanValue()) {
            return i;
        }
        switch (i) {
        }
        return i;
    }
}
