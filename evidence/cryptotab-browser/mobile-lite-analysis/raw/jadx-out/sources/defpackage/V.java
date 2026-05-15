package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class V extends View.AccessibilityDelegate {
    public final W a;

    public V(W w) {
        this.a = w;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.a.a(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        p0 p0VarB = this.a.b(view);
        if (p0VarB != null) {
            return p0VarB.t;
        }
        return null;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.a.c(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        Object tag;
        Object tag2;
        Object tag3;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
        WeakHashMap weakHashMap = AbstractC0604eo2.a;
        int i = AbstractC0132Lp1.tag_screen_reader_focusable;
        Object objA = null;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = Boolean.valueOf(AbstractC0319Zn2.c(view));
        } else {
            tag = view.getTag(i);
            if (!Boolean.class.isInstance(tag)) {
                tag = null;
            }
        }
        Boolean bool = (Boolean) tag;
        boolean z = bool != null && bool.booleanValue();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            accessibilityNodeInfo.setScreenReaderFocusable(z);
        } else {
            accessibilityNodeInfoCompat.i(1, z);
        }
        int i3 = AbstractC0132Lp1.tag_accessibility_heading;
        if (Build.VERSION.SDK_INT >= 28) {
            tag2 = Boolean.valueOf(AbstractC0319Zn2.b(view));
        } else {
            tag2 = view.getTag(i3);
            if (!Boolean.class.isInstance(tag2)) {
                tag2 = null;
            }
        }
        Boolean bool2 = (Boolean) tag2;
        boolean z2 = bool2 != null && bool2.booleanValue();
        if (i2 >= 28) {
            accessibilityNodeInfo.setHeading(z2);
        } else {
            accessibilityNodeInfoCompat.i(2, z2);
        }
        int i4 = AbstractC0132Lp1.tag_accessibility_pane_title;
        if (i2 >= 28) {
            tag3 = AbstractC0319Zn2.a(view);
        } else {
            tag3 = view.getTag(i4);
            if (!CharSequence.class.isInstance(tag3)) {
                tag3 = null;
            }
        }
        CharSequence charSequence = (CharSequence) tag3;
        if (i2 >= 28) {
            accessibilityNodeInfo.setPaneTitle(charSequence);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
        int i5 = AbstractC0132Lp1.tag_state_description;
        if (Build.VERSION.SDK_INT >= 30) {
            objA = AbstractC0438bo2.a(view);
        } else {
            Object tag4 = view.getTag(i5);
            if (CharSequence.class.isInstance(tag4)) {
                objA = tag4;
            }
        }
        CharSequence charSequence2 = (CharSequence) objA;
        if (i2 >= 30) {
            AbstractC0873j0.b(accessibilityNodeInfo, charSequence2);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence2);
        }
        this.a.d(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfo.getText();
        List listEmptyList = (List) view.getTag(AbstractC0132Lp1.tag_accessibility_actions);
        if (listEmptyList == null) {
            listEmptyList = Collections.emptyList();
        }
        for (int i6 = 0; i6 < listEmptyList.size(); i6++) {
            accessibilityNodeInfoCompat.b((C0814i0) listEmptyList.get(i6));
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.a.e(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.a.f(viewGroup, view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return this.a.g(view, i, bundle);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void sendAccessibilityEvent(View view, int i) {
        this.a.h(view, i);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.a.i(view, accessibilityEvent);
    }
}
