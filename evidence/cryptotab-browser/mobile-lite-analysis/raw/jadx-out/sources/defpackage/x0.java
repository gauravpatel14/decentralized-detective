package defpackage;

import android.content.ContentResolver;
import org.chromium.ui.accessibility.AccessibilityState;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class x0 implements Td {
    @Override // defpackage.Td
    public final void q(int i) {
        int i2 = AccessibilityState.a;
        if (i == 1 || i == 2) {
            if (i != 1 || AccessibilityState.k) {
                return;
            }
            AccessibilityState.i();
            return;
        }
        ContentResolver contentResolver = AbstractC1499tM.a.getContentResolver();
        contentResolver.unregisterContentObserver(AccessibilityState.s);
        contentResolver.unregisterContentObserver(AccessibilityState.t);
        contentResolver.unregisterContentObserver(AccessibilityState.u);
        contentResolver.unregisterContentObserver(AccessibilityState.v);
        AccessibilityState.j = null;
        AccessibilityState.l = null;
        AccessibilityState.k = false;
        AccessibilityState.m = false;
        AccessibilityState.n = false;
        AccessibilityState.o = false;
        AccessibilityState.w = null;
    }
}
