package defpackage;

import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: renamed from: eb2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0596eb2 {
    public static OnBackInvokedDispatcher a(Toolbar toolbar) {
        return toolbar.findOnBackInvokedDispatcher();
    }

    public static void b(Object obj, C0539db2 c0539db2) {
        ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, c0539db2);
    }

    public static void c(Object obj, C0539db2 c0539db2) {
        ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback(c0539db2);
    }
}
