package defpackage;

import android.R;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* JADX INFO: renamed from: i0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0814i0 {
    public static final C0814i0 A;
    public static final C0814i0 B;
    public static final C0814i0 C;
    public static final C0814i0 D;
    public static final C0814i0 E;
    public static final C0814i0 F;
    public static final C0814i0 G;
    public static final C0814i0 H;
    public static final C0814i0 I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final C0814i0 f30J;
    public static final C0814i0 K;
    public static final C0814i0 e = new C0814i0(1);
    public static final C0814i0 f = new C0814i0(2);
    public static final C0814i0 g;
    public static final C0814i0 h;
    public static final C0814i0 i;
    public static final C0814i0 j;
    public static final C0814i0 k;
    public static final C0814i0 l;
    public static final C0814i0 m;
    public static final C0814i0 n;
    public static final C0814i0 o;
    public static final C0814i0 p;
    public static final C0814i0 q;
    public static final C0814i0 r;
    public static final C0814i0 s;
    public static final C0814i0 t;
    public static final C0814i0 u;
    public static final C0814i0 v;
    public static final C0814i0 w;
    public static final C0814i0 x;
    public static final C0814i0 y;
    public static final C0814i0 z;
    public final Object a;
    public final int b;
    public final Class c;
    public final L0 d;

    static {
        new C0814i0(4);
        new C0814i0(8);
        g = new C0814i0(16);
        h = new C0814i0(32);
        i = new C0814i0(64);
        j = new C0814i0(128);
        k = new C0814i0(256, E0.class);
        l = new C0814i0(512, E0.class);
        m = new C0814i0(1024, F0.class);
        n = new C0814i0(2048, F0.class);
        o = new C0814i0(4096);
        p = new C0814i0(8192);
        q = new C0814i0(16384);
        r = new C0814i0(32768);
        s = new C0814i0(65536);
        t = new C0814i0(131072, J0.class);
        u = new C0814i0(262144);
        v = new C0814i0(524288);
        new C0814i0(1048576);
        w = new C0814i0(2097152, K0.class);
        int i2 = Build.VERSION.SDK_INT;
        x = new C0814i0(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
        y = new C0814i0(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, H0.class);
        z = new C0814i0(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
        A = new C0814i0(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
        B = new C0814i0(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
        C = new C0814i0(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
        D = new C0814i0(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
        E = new C0814i0(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
        F = new C0814i0(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
        G = new C0814i0(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
        H = new C0814i0(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
        I = new C0814i0(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, I0.class);
        new C0814i0(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, R.id.accessibilityActionMoveWindow, null, null, G0.class);
        new C0814i0(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
        new C0814i0(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
        new C0814i0(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
        f30J = new C0814i0(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
        new C0814i0(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
        new C0814i0(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
        new C0814i0(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
        new C0814i0(i2 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
        K = new C0814i0(i2 >= 34 ? AbstractC0997l0.a() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
    }

    public C0814i0(int i2) {
        this(null, i2, null, null, null);
    }

    public final int a() {
        return ((AccessibilityNodeInfo.AccessibilityAction) this.a).getId();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C0814i0)) {
            return false;
        }
        Object obj2 = ((C0814i0) obj).a;
        Object obj3 = this.a;
        return obj3 == null ? obj2 == null : obj3.equals(obj2);
    }

    public final int hashCode() {
        Object obj = this.a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AccessibilityActionCompat: ");
        String strE = AccessibilityNodeInfoCompat.e(this.b);
        if (strE.equals("ACTION_UNKNOWN")) {
            Object obj = this.a;
            if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                strE = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
            }
        }
        sb.append(strE);
        return sb.toString();
    }

    public C0814i0(int i2, Class cls) {
        this(null, i2, null, null, cls);
    }

    public C0814i0(Object obj, int i2, String str, L0 l0, Class cls) {
        this.b = i2;
        this.d = l0;
        if (obj == null) {
            this.a = new AccessibilityNodeInfo.AccessibilityAction(i2, str);
        } else {
            this.a = obj;
        }
        this.c = cls;
    }
}
