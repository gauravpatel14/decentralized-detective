package defpackage;

import android.os.Build;
import java.util.HashMap;
import org.chromium.ui.permissions.PermissionCallback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class M8 {
    public final PermissionCallback a;
    public final HashMap b = new HashMap();

    public M8(Q3 q3, String[] strArr, PermissionCallback permissionCallback) {
        if (Build.VERSION.SDK_INT >= 30) {
            for (String str : strArr) {
                this.b.put(str, Boolean.valueOf(q3.c(str)));
            }
        }
        this.a = permissionCallback;
    }
}
