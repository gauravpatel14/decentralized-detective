package defpackage;

import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 {
    public final Object a;

    public /* synthetic */ m0(Object obj) {
        this.a = obj;
    }

    public static m0 a(boolean z, int i, int i2, int i3, int i4) {
        return new m0(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, false, z));
    }
}
