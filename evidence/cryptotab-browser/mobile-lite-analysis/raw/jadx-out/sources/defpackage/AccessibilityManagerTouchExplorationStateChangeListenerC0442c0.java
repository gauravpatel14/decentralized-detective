package defpackage;

import android.view.accessibility.AccessibilityManager;

/* JADX INFO: renamed from: c0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class AccessibilityManagerTouchExplorationStateChangeListenerC0442c0 implements AccessibilityManager.TouchExplorationStateChangeListener {
    public final b0 a;

    public AccessibilityManagerTouchExplorationStateChangeListenerC0442c0(b0 b0Var) {
        this.a = b0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AccessibilityManagerTouchExplorationStateChangeListenerC0442c0) {
            return this.a.equals(((AccessibilityManagerTouchExplorationStateChangeListenerC0442c0) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        this.a.onTouchExplorationStateChanged(z);
    }
}
