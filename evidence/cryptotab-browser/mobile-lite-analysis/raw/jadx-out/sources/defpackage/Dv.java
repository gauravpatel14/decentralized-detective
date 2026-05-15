package defpackage;

import android.os.Bundle;
import androidx.activity.result.ActivityResult;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Dv {
    public static Object a(String str, Bundle bundle) {
        return bundle.getParcelable(str, ActivityResult.class);
    }
}
