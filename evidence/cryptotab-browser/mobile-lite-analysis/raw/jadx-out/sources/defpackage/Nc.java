package defpackage;

import android.text.TextUtils;
import java.util.Arrays;
import org.chromium.ui.base.ResourceBundle;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Nc {
    public static final Mc a = new Mc();

    public static boolean a(String str, Mc mc) {
        return TextUtils.equals(str, null) || Arrays.binarySearch(ResourceBundle.a, str, mc) >= 0;
    }
}
