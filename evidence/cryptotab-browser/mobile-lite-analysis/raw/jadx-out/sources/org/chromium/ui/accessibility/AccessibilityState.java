package org.chromium.ui.accessibility;

import J.N;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.view.accessibility.AccessibilityManager;
import android.view.autofill.AutofillManager;
import defpackage.A0;
import defpackage.AbstractC1499tM;
import defpackage.C1107mj2;
import defpackage.Gr1;
import defpackage.v0;
import defpackage.w0;
import defpackage.x0;
import defpackage.y0;
import defpackage.z0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import org.chromium.base.ThreadUtils;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class AccessibilityState {
    public static int a;
    public static int b;
    public static int c;
    public static int d;
    public static int e;
    public static int f;
    public static int g;
    public static int h;
    public static int i;
    public static A0 j;
    public static boolean k;
    public static Boolean l;
    public static boolean m;
    public static boolean n;
    public static boolean o;
    public static int p;
    public static z0 s;
    public static z0 t;
    public static z0 u;
    public static z0 v;
    public static AccessibilityManager w;
    public static ArrayList x;
    public static final w0 q = new w0();
    public static final x0 r = new x0();
    public static final Set y = Collections.newSetFromMap(new WeakHashMap());
    public static int z = 250;

    public static void a() {
        if (w != null) {
            return;
        }
        w = (AccessibilityManager) AbstractC1499tM.a.getSystemService("accessibility");
    }

    public static int b(int i2, int i3) {
        if (!k) {
            k();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            i3 = w.getRecommendedTimeoutMillis(i3, 7);
        } else if (d()) {
            i3 *= 2;
        }
        return Math.max(i2, i3);
    }

    public static boolean c() {
        return g() || e();
    }

    public static boolean d() {
        if (k) {
            return j.d;
        }
        a();
        return w.isEnabled();
    }

    public static boolean e() {
        if (k) {
            return j.c;
        }
        Boolean bool = l;
        if (bool != null) {
            return bool.booleanValue();
        }
        a();
        if (w.isEnabled()) {
            Iterator<AccessibilityServiceInfo> it = w.getEnabledAccessibilityServiceList(-1).iterator();
            while (it.hasNext()) {
                if ((it.next().getCapabilities() & 32) != 0) {
                    l = Boolean.TRUE;
                    return true;
                }
            }
        }
        l = Boolean.FALSE;
        return false;
    }

    public static boolean f() {
        if (!k) {
            k();
        }
        return j.a;
    }

    public static boolean g() {
        if (k) {
            return j.b;
        }
        a();
        return w.isTouchExplorationEnabled();
    }

    public static int getAccessibilityServiceCapabilitiesMask() {
        if (!k) {
            k();
        }
        return e;
    }

    public static int getAccessibilityServiceEventTypeMask() {
        if (!k) {
            k();
        }
        return b;
    }

    public static int getAccessibilityServiceFeedbackTypeMask() {
        if (!k) {
            k();
        }
        return c;
    }

    public static int getAccessibilityServiceFlagsMask() {
        if (!k) {
            k();
        }
        return d;
    }

    public static String[] getAccessibilityServiceIds() {
        if (!k) {
            k();
        }
        return (String[]) x.toArray(new String[0]);
    }

    public static void h() {
        l();
        if (!m) {
            l();
        }
        N._V_Z(10, n);
        if (!m) {
            l();
        }
        N._V_Z(9, o);
    }

    public static void i() {
        ContentResolver contentResolver = AbstractC1499tM.a.getContentResolver();
        t = new z0(ThreadUtils.b(), new v0(1));
        s = new z0(ThreadUtils.b(), new v0(2));
        u = new z0(ThreadUtils.b(), new v0(3));
        v = new z0(ThreadUtils.b(), new v0(3));
        contentResolver.registerContentObserver(Settings.Global.getUriFor("animator_duration_scale"), false, t);
        contentResolver.registerContentObserver(Settings.Secure.getUriFor("enabled_accessibility_services"), false, s);
        contentResolver.registerContentObserver(Settings.System.getUriFor("touch_exploration_enabled"), false, s);
        contentResolver.registerContentObserver(Settings.Secure.getUriFor("speak_password"), false, s);
        contentResolver.registerContentObserver(Settings.System.getUriFor("show_password"), false, s);
        contentResolver.registerContentObserver(Settings.Secure.getUriFor("accessibility_display_inversion_enabled"), false, u);
        contentResolver.registerContentObserver(Settings.Secure.getUriFor("high_text_contrast_enabled"), false, v);
    }

    public static HashSet j() {
        if (!k) {
            k();
        }
        HashSet hashSet = new HashSet();
        int i2 = b;
        while (i2 != 0) {
            int iNumberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(i2);
            hashSet.add(Integer.valueOf(iNumberOfTrailingZeros));
            i2 &= ~iNumberOfTrailingZeros;
        }
        return hashSet;
    }

    public static void k() {
        boolean z2;
        int i2;
        int i3;
        AutofillManager autofillManager;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
        if (!k) {
            j = new A0(false, false, false, false, false, false, false, false);
            a();
        }
        k = true;
        b = 0;
        c = 0;
        d = 0;
        e = 0;
        f = 0;
        g = 0;
        h = 0;
        i = 0;
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = w.getEnabledAccessibilityServiceList(-1);
        x = new ArrayList();
        ArrayList<String> arrayList = new ArrayList();
        boolean z3 = false;
        boolean z4 = false;
        for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
            if (accessibilityServiceInfo != null) {
                z4 |= Build.VERSION.SDK_INT < 31 || accessibilityServiceInfo.isAccessibilityTool();
                String id = accessibilityServiceInfo.getId();
                x.add(id);
                if (id != null && !id.isEmpty()) {
                    ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(id);
                    if (componentNameUnflattenFromString != null) {
                        arrayList.add(componentNameUnflattenFromString.flattenToShortString());
                    } else {
                        arrayList.add(id);
                    }
                }
                b |= accessibilityServiceInfo.eventTypes;
                c |= accessibilityServiceInfo.feedbackType;
                d |= accessibilityServiceInfo.flags;
                e |= accessibilityServiceInfo.getCapabilities();
                if (!accessibilityServiceInfo.getId().equals("android/com.android.server.autofill.AutofillCompatAccessibilityService")) {
                    f |= accessibilityServiceInfo.eventTypes;
                    g |= accessibilityServiceInfo.feedbackType;
                    h |= accessibilityServiceInfo.flags;
                    i = accessibilityServiceInfo.getCapabilities() | i;
                }
                z3 = true;
            }
        }
        Context context = AbstractC1499tM.a;
        if (Build.VERSION.SDK_INT >= 31) {
            p = context.getResources().getConfiguration().fontWeightAdjustment;
        } else {
            p = 0;
        }
        boolean z5 = Settings.System.getInt(context.getContentResolver(), "show_password", 1) == 1;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
        ArrayList arrayList2 = new ArrayList();
        if (string != null && !string.isEmpty()) {
            for (String str : string.split(":")) {
                if (str != null && !str.isEmpty()) {
                    ComponentName componentNameUnflattenFromString2 = ComponentName.unflattenFromString(str);
                    if (componentNameUnflattenFromString2 != null) {
                        arrayList2.add(componentNameUnflattenFromString2.flattenToShortString());
                    } else {
                        arrayList2.add(str);
                    }
                }
            }
        }
        Collections.sort(arrayList);
        Collections.sort(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (String str2 : arrayList) {
            if (!str2.equals("android/com.android.server.autofill.AutofillCompatAccessibilityService")) {
                arrayList3.add(str2);
            }
        }
        if (arrayList.equals(arrayList2) || arrayList3.equals(arrayList2)) {
            Log.i("cr_A11yState", "Enabled accessibility services list updated. " + arrayList2.toString());
            z = 250;
        } else {
            Log.i("cr_A11yState", "Enabled accessibility services: " + arrayList2.toString());
            Log.i("cr_A11yState", "Running accessibility services: " + arrayList.toString());
            int i4 = z;
            if (i4 < 5000) {
                Log.i("cr_A11yState", "Will check again after " + i4 + " milliseconds.");
                Gr1.b("Accessibility.Android.UpdateAccessibilityServices.DidPoll", true);
                ThreadUtils.b().postDelayed(new v0(0), (long) z);
                a = a + 1;
                z *= 2;
                return;
            }
            Log.i("cr_A11yState", "Max delay reached. Send information as is.");
            Gr1.b("Accessibility.Android.UpdateAccessibilityServices.PollTimeout", true);
            z = 250;
        }
        boolean z6 = (f & 20484) != 0;
        try {
            autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class);
        } catch (RuntimeException unused) {
            Log.e("cr_A11yState", "AutofillManager did not resolve before timelimit.");
        }
        if (autofillManager != null && autofillManager.isEnabled() && autofillManager.hasEnabledAutofillServices()) {
            if (!arrayList.isEmpty()) {
                if (arrayList.size() == 1) {
                    if (((String) arrayList.get(0)).equals("android/com.android.server.autofill.AutofillCompatAccessibilityService")) {
                    }
                }
                z2 = false;
            }
            z2 = true;
        } else {
            z2 = false;
        }
        int i5 = f;
        boolean z7 = i5 != 0 && (i2 = h) != 0 && (i3 = i) != 0 && (i5 | 2105) == 2105 && (i2 | 95) == 95 && (i3 | 1) == 1 && (g | 16) == 16;
        boolean z8 = Build.VERSION.SDK_INT < 31 ? z7 || z2 : !z4 && (z7 || z2);
        boolean z9 = (c & 1) != 0;
        boolean zIsTouchExplorationEnabled = C1107mj2.b.f("StartSurfaceAccessibilityCheck") ? ((e & 2) == 0 || (d & 4) == 0) ? false : true : w.isTouchExplorationEnabled();
        boolean z10 = (e & 32) != 0;
        Gr1.i((int) ((SystemClock.elapsedRealtimeNanos() / 1000) - jElapsedRealtimeNanos), 1, 16000, 100, "Accessibility.Android.UpdateAccessibilityServices.Runtime");
        Gr1.i(a, 1, 10, 11, "Accessibility.Android.UpdateAccessibilityServices.PollCount");
        a = 0;
        Log.i("cr_A11yState", "Informing listeners of changes.");
        A0 a0 = new A0(z6, zIsTouchExplorationEnabled, z10, z3, z4, z9, z5, z8);
        j = a0;
        Log.i("cr_A11yState", "New AccessibilityState: " + a0.toString());
        Iterator it = y.iterator();
        while (it.hasNext()) {
            ((y0) it.next()).c(a0);
        }
    }

    public static void l() {
        m = true;
        Context context = AbstractC1499tM.a;
        n = Settings.Secure.getInt(context.getContentResolver(), "accessibility_display_inversion_enabled", 0) == 1;
        o = Settings.Secure.getInt(context.getContentResolver(), "high_text_contrast_enabled", 0) == 1;
    }
}
