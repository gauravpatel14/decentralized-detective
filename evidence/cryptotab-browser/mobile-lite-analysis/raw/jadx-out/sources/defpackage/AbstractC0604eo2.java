package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: eo2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0604eo2 {
    public static WeakHashMap a = null;
    public static Field b = null;
    public static boolean c = false;
    public static final int[] d = {AbstractC0132Lp1.accessibility_custom_action_0, AbstractC0132Lp1.accessibility_custom_action_1, AbstractC0132Lp1.accessibility_custom_action_2, AbstractC0132Lp1.accessibility_custom_action_3, AbstractC0132Lp1.accessibility_custom_action_4, AbstractC0132Lp1.accessibility_custom_action_5, AbstractC0132Lp1.accessibility_custom_action_6, AbstractC0132Lp1.accessibility_custom_action_7, AbstractC0132Lp1.accessibility_custom_action_8, AbstractC0132Lp1.accessibility_custom_action_9, AbstractC0132Lp1.accessibility_custom_action_10, AbstractC0132Lp1.accessibility_custom_action_11, AbstractC0132Lp1.accessibility_custom_action_12, AbstractC0132Lp1.accessibility_custom_action_13, AbstractC0132Lp1.accessibility_custom_action_14, AbstractC0132Lp1.accessibility_custom_action_15, AbstractC0132Lp1.accessibility_custom_action_16, AbstractC0132Lp1.accessibility_custom_action_17, AbstractC0132Lp1.accessibility_custom_action_18, AbstractC0132Lp1.accessibility_custom_action_19, AbstractC0132Lp1.accessibility_custom_action_20, AbstractC0132Lp1.accessibility_custom_action_21, AbstractC0132Lp1.accessibility_custom_action_22, AbstractC0132Lp1.accessibility_custom_action_23, AbstractC0132Lp1.accessibility_custom_action_24, AbstractC0132Lp1.accessibility_custom_action_25, AbstractC0132Lp1.accessibility_custom_action_26, AbstractC0132Lp1.accessibility_custom_action_27, AbstractC0132Lp1.accessibility_custom_action_28, AbstractC0132Lp1.accessibility_custom_action_29, AbstractC0132Lp1.accessibility_custom_action_30, AbstractC0132Lp1.accessibility_custom_action_31};
    public static final ViewTreeObserverOnGlobalLayoutListenerC0290Xn2 e = new ViewTreeObserverOnGlobalLayoutListenerC0290Xn2();

    public static C1050lp2 a(View view) {
        if (a == null) {
            a = new WeakHashMap();
        }
        C1050lp2 c1050lp2 = (C1050lp2) a.get(view);
        if (c1050lp2 != null) {
            return c1050lp2;
        }
        C1050lp2 c1050lp22 = new C1050lp2(view);
        a.put(view, c1050lp22);
        return c1050lp22;
    }

    public static C0383aw2 b(View view, C0383aw2 c0383aw2) {
        WindowInsets windowInsetsF = c0383aw2.f();
        if (windowInsetsF != null) {
            WindowInsets windowInsetsDispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsetsF);
            if (!windowInsetsDispatchApplyWindowInsets.equals(windowInsetsF)) {
                return C0383aw2.g(view, windowInsetsDispatchApplyWindowInsets);
            }
        }
        return c0383aw2;
    }

    public static boolean c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList = C0548do2.d;
        C0548do2 c0548do2 = (C0548do2) view.getTag(AbstractC0132Lp1.tag_unhandled_key_event_manager);
        if (c0548do2 == null) {
            c0548do2 = new C0548do2();
            c0548do2.a = null;
            c0548do2.b = null;
            c0548do2.c = null;
            view.setTag(AbstractC0132Lp1.tag_unhandled_key_event_manager, c0548do2);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap weakHashMap = c0548do2.a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList2 = C0548do2.d;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    try {
                        if (c0548do2.a == null) {
                            c0548do2.a = new WeakHashMap();
                        }
                        for (int size = arrayList2.size() - 1; size >= 0; size--) {
                            ArrayList arrayList3 = C0548do2.d;
                            View view2 = (View) ((WeakReference) arrayList3.get(size)).get();
                            if (view2 == null) {
                                arrayList3.remove(size);
                            } else {
                                c0548do2.a.put(view2, Boolean.TRUE);
                                for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                    c0548do2.a.put((View) parent, Boolean.TRUE);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
        }
        View viewA = c0548do2.a(view);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (viewA != null && !KeyEvent.isModifierKey(keyCode)) {
                if (c0548do2.b == null) {
                    c0548do2.b = new SparseArray();
                }
                c0548do2.b.put(keyCode, new WeakReference(viewA));
            }
        }
        return viewA != null;
    }

    public static View.AccessibilityDelegate d(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return AbstractC0380ao2.a(view);
        }
        if (c) {
            return null;
        }
        if (b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                c = true;
                return null;
            }
        }
        try {
            Object obj = b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            c = true;
            return null;
        }
    }

    public static ArrayList e(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(AbstractC0132Lp1.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(AbstractC0132Lp1.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static String[] f(C1038lb c1038lb) {
        return Build.VERSION.SDK_INT >= 31 ? AbstractC0501co2.a(c1038lb) : (String[]) c1038lb.getTag(AbstractC0132Lp1.tag_on_receive_content_mime_types);
    }

    public static C0383aw2 g(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        C0383aw2 c0383aw2G = C0383aw2.g(null, rootWindowInsets);
        C0307Yv2 c0307Yv2 = c0383aw2G.a;
        c0307Yv2.q(c0383aw2G);
        c0307Yv2.d(view.getRootView());
        return c0383aw2G;
    }

    public static void h(View view, int i) {
        Object tag;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            int i2 = AbstractC0132Lp1.tag_accessibility_pane_title;
            int i3 = Build.VERSION.SDK_INT;
            Object objA = null;
            if (i3 >= 28) {
                tag = AbstractC0319Zn2.a(view);
            } else {
                tag = view.getTag(i2);
                if (!CharSequence.class.isInstance(tag)) {
                    tag = null;
                }
            }
            boolean z = ((CharSequence) tag) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i);
                if (z) {
                    List<CharSequence> text = accessibilityEventObtain.getText();
                    int i4 = AbstractC0132Lp1.tag_accessibility_pane_title;
                    if (i3 >= 28) {
                        objA = AbstractC0319Zn2.a(view);
                    } else {
                        Object tag2 = view.getTag(i4);
                        if (CharSequence.class.isInstance(tag2)) {
                            objA = tag2;
                        }
                    }
                    text.add((CharSequence) objA);
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                        return;
                    } catch (AbstractMethodError e2) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e2);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            accessibilityEventObtain2.setContentChangeTypes(i);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            List<CharSequence> text2 = accessibilityEventObtain2.getText();
            int i5 = AbstractC0132Lp1.tag_accessibility_pane_title;
            if (i3 >= 28) {
                objA = AbstractC0319Zn2.a(view);
            } else {
                Object tag3 = view.getTag(i5);
                if (CharSequence.class.isInstance(tag3)) {
                    objA = tag3;
                }
            }
            text2.add((CharSequence) objA);
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    public static C0383aw2 i(View view, C0383aw2 c0383aw2) {
        WindowInsets windowInsetsF = c0383aw2.f();
        if (windowInsetsF != null) {
            WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsetsF);
            if (!windowInsetsOnApplyWindowInsets.equals(windowInsetsF)) {
                return C0383aw2.g(view, windowInsetsOnApplyWindowInsets);
            }
        }
        return c0383aw2;
    }

    public static vL j(C1038lb c1038lb, vL vLVar) {
        if (Build.VERSION.SDK_INT >= 31) {
            return AbstractC0501co2.b(c1038lb, vLVar);
        }
        if (((G82) c1038lb.getTag(AbstractC0132Lp1.tag_on_receive_content_listener)) == null) {
            c1038lb.w.getClass();
            return G82.a(c1038lb, vLVar);
        }
        vL vLVarA = G82.a(c1038lb, vLVar);
        if (vLVarA == null) {
            return null;
        }
        c1038lb.w.getClass();
        return G82.a(c1038lb, vLVarA);
    }

    public static void k(View view, int i) {
        l(view, i);
        h(view, 0);
    }

    public static void l(View view, int i) {
        ArrayList arrayListE = e(view);
        for (int i2 = 0; i2 < arrayListE.size(); i2++) {
            if (((C0814i0) arrayListE.get(i2)).a() == i) {
                arrayListE.remove(i2);
                return;
            }
        }
    }

    public static void m(View view, C0814i0 c0814i0, String str, L0 l0) {
        if (l0 == null && str == null) {
            k(view, c0814i0.a());
            return;
        }
        C0814i0 c0814i02 = new C0814i0(null, c0814i0.b, str, l0, c0814i0.c);
        View.AccessibilityDelegate accessibilityDelegateD = d(view);
        W w = accessibilityDelegateD == null ? null : accessibilityDelegateD instanceof V ? ((V) accessibilityDelegateD).a : new W(accessibilityDelegateD);
        if (w == null) {
            w = new W();
        }
        o(view, w);
        l(view, c0814i02.a());
        e(view).add(c0814i02);
        h(view, 0);
    }

    public static void n(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            AbstractC0380ao2.b(view, context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    public static void o(View view, W w) {
        if (w == null && (d(view) instanceof V)) {
            w = new W();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        view.setAccessibilityDelegate(w == null ? null : w.b);
    }

    public static void p(CharSequence charSequence, View view) {
        new C0273Wn2(AbstractC0132Lp1.tag_accessibility_pane_title, CharSequence.class, 8, 28, 1).a(view, charSequence);
        ViewTreeObserverOnGlobalLayoutListenerC0290Xn2 viewTreeObserverOnGlobalLayoutListenerC0290Xn2 = e;
        if (charSequence == null) {
            viewTreeObserverOnGlobalLayoutListenerC0290Xn2.t.remove(view);
            view.removeOnAttachStateChangeListener(viewTreeObserverOnGlobalLayoutListenerC0290Xn2);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(viewTreeObserverOnGlobalLayoutListenerC0290Xn2);
        } else {
            viewTreeObserverOnGlobalLayoutListenerC0290Xn2.t.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(viewTreeObserverOnGlobalLayoutListenerC0290Xn2);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(viewTreeObserverOnGlobalLayoutListenerC0290Xn2);
            }
        }
    }

    public static void q(View view, y41 y41Var) {
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(AbstractC0132Lp1.tag_on_apply_window_listener, y41Var);
        }
        if (y41Var == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(AbstractC0132Lp1.tag_window_insets_animation_callback));
        } else {
            view.setOnApplyWindowInsetsListener(new Yn2(view, y41Var));
        }
    }
}
