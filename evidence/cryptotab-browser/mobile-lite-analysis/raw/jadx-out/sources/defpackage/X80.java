package defpackage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class X80 extends W {
    public static final Rect n = new Rect(Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER, Integer.MIN_VALUE, Integer.MIN_VALUE);
    public final AccessibilityManager h;
    public final View i;
    public W80 j;
    public final Rect d = new Rect();
    public final Rect e = new Rect();
    public final Rect f = new Rect();
    public final int[] g = new int[2];
    public int k = Integer.MIN_VALUE;
    public int l = Integer.MIN_VALUE;
    public int m = Integer.MIN_VALUE;

    public X80(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.i = view;
        this.h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    @Override // defpackage.W
    public final p0 b(View view) {
        if (this.j == null) {
            this.j = new W80(this);
        }
        return this.j;
    }

    @Override // defpackage.W
    public final void d(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        this.a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.a);
    }

    public final AccessibilityEvent j(int i, int i2) {
        View view = this.i;
        if (i == -1) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i2);
            view.onInitializeAccessibilityEvent(accessibilityEventObtain);
            return accessibilityEventObtain;
        }
        AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain(i2);
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatL = l(i);
        accessibilityEventObtain2.getText().add(accessibilityNodeInfoCompatL.h());
        AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompatL.a;
        accessibilityEventObtain2.setContentDescription(accessibilityNodeInfo.getContentDescription());
        accessibilityEventObtain2.setScrollable(accessibilityNodeInfo.isScrollable());
        accessibilityEventObtain2.setPassword(accessibilityNodeInfo.isPassword());
        accessibilityEventObtain2.setEnabled(accessibilityNodeInfo.isEnabled());
        accessibilityEventObtain2.setChecked(accessibilityNodeInfo.isChecked());
        n(i, accessibilityEventObtain2);
        if (accessibilityEventObtain2.getText().isEmpty() && accessibilityEventObtain2.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain2.setClassName(accessibilityNodeInfo.getClassName());
        accessibilityEventObtain2.setSource(view, i);
        accessibilityEventObtain2.setPackageName(view.getContext().getPackageName());
        return accessibilityEventObtain2;
    }

    public abstract void k(ArrayList arrayList);

    public final AccessibilityNodeInfoCompat l(int i) {
        View view = this.i;
        if (i == -1) {
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(view);
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(accessibilityNodeInfoObtain);
            WeakHashMap weakHashMap = AbstractC0604eo2.a;
            view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
            ArrayList arrayList = new ArrayList();
            k(arrayList);
            if (accessibilityNodeInfoObtain.getChildCount() > 0 && arrayList.size() > 0) {
                throw new RuntimeException("Views cannot have both real and virtual children");
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                accessibilityNodeInfoCompat.a.addChild(view, ((Integer) arrayList.get(i2)).intValue());
            }
            return accessibilityNodeInfoCompat;
        }
        AccessibilityNodeInfo accessibilityNodeInfoObtain2 = AccessibilityNodeInfo.obtain();
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = new AccessibilityNodeInfoCompat(accessibilityNodeInfoObtain2);
        accessibilityNodeInfoObtain2.setEnabled(true);
        accessibilityNodeInfoObtain2.setFocusable(true);
        accessibilityNodeInfoCompat2.k("android.view.View");
        Rect rect = n;
        accessibilityNodeInfoCompat2.j(rect);
        accessibilityNodeInfoObtain2.setBoundsInScreen(rect);
        accessibilityNodeInfoCompat2.b = -1;
        accessibilityNodeInfoObtain2.setParent(view);
        o(i, accessibilityNodeInfoCompat2);
        if (accessibilityNodeInfoCompat2.h() == null && accessibilityNodeInfoObtain2.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.e;
        accessibilityNodeInfoObtain2.getBoundsInParent(rect2);
        Rect rect3 = this.d;
        accessibilityNodeInfoObtain2.getBoundsInScreen(rect3);
        if (rect2.equals(rect) && rect3.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds or screen bounds in populateNodeForVirtualViewId()");
        }
        int actions = accessibilityNodeInfoObtain2.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        accessibilityNodeInfoObtain2.setPackageName(view.getContext().getPackageName());
        accessibilityNodeInfoCompat2.c = i;
        accessibilityNodeInfoObtain2.setSource(view, i);
        if (this.k == i) {
            accessibilityNodeInfoObtain2.setAccessibilityFocused(true);
            accessibilityNodeInfoCompat2.a(128);
        } else {
            accessibilityNodeInfoObtain2.setAccessibilityFocused(false);
            accessibilityNodeInfoCompat2.a(64);
        }
        boolean z = this.l == i;
        if (z) {
            accessibilityNodeInfoCompat2.a(2);
        } else if (accessibilityNodeInfoObtain2.isFocusable()) {
            accessibilityNodeInfoCompat2.a(1);
        }
        accessibilityNodeInfoObtain2.setFocused(z);
        int[] iArr = this.g;
        view.getLocationOnScreen(iArr);
        boolean zEquals = rect3.equals(rect);
        AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat2.a;
        if (zEquals) {
            accessibilityNodeInfoCompat2.j(rect2);
            Rect rect4 = new Rect();
            rect4.set(rect2);
            if (accessibilityNodeInfoCompat2.b != -1) {
                AccessibilityNodeInfoCompat accessibilityNodeInfoCompat3 = new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain());
                Rect rect5 = new Rect();
                for (int i3 = accessibilityNodeInfoCompat2.b; i3 != -1; i3 = accessibilityNodeInfoCompat3.b) {
                    accessibilityNodeInfoCompat3.b = -1;
                    AccessibilityNodeInfo accessibilityNodeInfo2 = accessibilityNodeInfoCompat3.a;
                    accessibilityNodeInfo2.setParent(view, -1);
                    accessibilityNodeInfoCompat3.j(rect);
                    o(i3, accessibilityNodeInfoCompat3);
                    accessibilityNodeInfo2.getBoundsInParent(rect5);
                    rect4.offset(rect5.left, rect5.top);
                }
            }
            view.getLocationOnScreen(iArr);
            rect4.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
            accessibilityNodeInfo.setBoundsInScreen(rect4);
            accessibilityNodeInfo.getBoundsInScreen(rect3);
        }
        Rect rect6 = this.f;
        if (view.getLocalVisibleRect(rect6)) {
            rect6.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
            if (rect3.intersect(rect6)) {
                accessibilityNodeInfo.setBoundsInScreen(rect3);
                if (!rect3.isEmpty() && view.getWindowVisibility() == 0) {
                    Object parent = view.getParent();
                    while (true) {
                        if (parent instanceof View) {
                            View view2 = (View) parent;
                            if (view2.getAlpha() <= 0.0f || view2.getVisibility() != 0) {
                                break;
                            }
                            parent = view2.getParent();
                        } else if (parent != null) {
                            accessibilityNodeInfo.setVisibleToUser(true);
                        }
                    }
                }
            }
        }
        return accessibilityNodeInfoCompat2;
    }

    public abstract boolean m(int i, int i2);

    public abstract void n(int i, AccessibilityEvent accessibilityEvent);

    public abstract void o(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    public final void p(int i, int i2) {
        View view;
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.h.isEnabled() || (parent = (view = this.i).getParent()) == null) {
            return;
        }
        parent.requestSendAccessibilityEvent(view, j(i, i2));
    }
}
