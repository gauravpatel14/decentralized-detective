package defpackage;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: fb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutInflaterFactory2C0658fb extends AbstractC0231Ta implements InterfaceC0641fQ0, LayoutInflater.Factory2 {
    public static final UJ1 B0 = new UJ1(0);
    public static final int[] C0 = {R.attr.windowBackground};
    public static final boolean D0 = !"robolectric".equals(Build.FINGERPRINT);
    public Za A0;
    public final Object C;
    public final Context D;
    public Window E;
    public WindowCallbackC0365ab F;
    public final Object G;
    public AbstractC0508d3 H;
    public ZR1 I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public CharSequence f27J;
    public InterfaceC1513tV K;
    public Va L;
    public Va M;
    public H3 N;
    public ActionBarContextView O;
    public PopupWindow P;
    public Ua Q;
    public boolean T;
    public ViewGroup U;
    public TextView V;
    public View W;
    public boolean X;
    public boolean Y;
    public boolean Z;
    public boolean a0;
    public boolean b0;
    public boolean c0;
    public boolean d0;
    public boolean e0;
    public C0595eb[] f0;
    public C0595eb g0;
    public boolean h0;
    public boolean i0;
    public boolean j0;
    public boolean k0;
    public Configuration l0;
    public int m0;
    public int n0;
    public int o0;
    public boolean p0;
    public C0425bb q0;
    public C0425bb r0;
    public boolean s0;
    public int t0;
    public boolean v0;
    public Rect w0;
    public Rect x0;
    public Xb y0;
    public OnBackInvokedDispatcher z0;
    public C1050lp2 R = null;
    public boolean S = true;
    public final Ua u0 = new Ua(this, 0);

    public LayoutInflaterFactory2C0658fb(Context context, Window window, Ja ja, Object obj) {
        Fa fa = null;
        this.m0 = -100;
        this.D = context;
        this.C = obj;
        if (obj instanceof Dialog) {
            while (true) {
                if (context != null) {
                    if (!(context instanceof Fa)) {
                        if (!(context instanceof ContextWrapper)) {
                            break;
                        } else {
                            context = ((ContextWrapper) context).getBaseContext();
                        }
                    } else {
                        fa = (Fa) context;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (fa != null) {
                this.m0 = ((LayoutInflaterFactory2C0658fb) fa.X0()).m0;
            }
        }
        if (this.m0 == -100) {
            UJ1 uj1 = B0;
            Integer num = (Integer) uj1.get(this.C.getClass().getName());
            if (num != null) {
                this.m0 = num.intValue();
                uj1.remove(this.C.getClass().getName());
            }
        }
        if (window != null) {
            p(window);
        }
        C0914jb.d();
    }

    public static TH0 q(Context context) {
        TH0 th0;
        TH0 th02;
        if (Build.VERSION.SDK_INT >= 33 || (th0 = AbstractC0231Ta.v) == null) {
            return null;
        }
        TH0 th0A = TH0.a(context.getApplicationContext().getResources().getConfiguration().getLocales().toLanguageTags());
        UH0 uh0 = th0.a;
        if (uh0.a.isEmpty()) {
            th02 = TH0.b;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i = 0;
            while (i < th0A.a.a.size() + uh0.a.size()) {
                Locale locale = i < uh0.a.size() ? uh0.a.get(i) : th0A.a.a.get(i - uh0.a.size());
                if (locale != null) {
                    linkedHashSet.add(locale);
                }
                i++;
            }
            th02 = new TH0(new UH0(new LocaleList((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]))));
        }
        return th02.a.a.isEmpty() ? th0A : th02;
    }

    public static Configuration u(Context context, int i, TH0 th0, Configuration configuration, boolean z) {
        int i2 = i != 1 ? i != 2 ? z ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i2 | (configuration2.uiMode & (-49));
        if (th0 != null) {
            configuration2.setLocales(LocaleList.forLanguageTags(th0.a.a.toLanguageTags()));
        }
        return configuration2;
    }

    public final C0595eb A(int i) {
        C0595eb[] c0595ebArr = this.f0;
        if (c0595ebArr == null || c0595ebArr.length <= i) {
            C0595eb[] c0595ebArr2 = new C0595eb[i + 1];
            if (c0595ebArr != null) {
                System.arraycopy(c0595ebArr, 0, c0595ebArr2, 0, c0595ebArr.length);
            }
            this.f0 = c0595ebArr2;
            c0595ebArr = c0595ebArr2;
        }
        C0595eb c0595eb = c0595ebArr[i];
        if (c0595eb != null) {
            return c0595eb;
        }
        C0595eb c0595eb2 = new C0595eb();
        c0595eb2.a = i;
        c0595eb2.n = false;
        c0595ebArr[i] = c0595eb2;
        return c0595eb2;
    }

    public final void B() {
        x();
        if (this.Z && this.H == null) {
            Object obj = this.C;
            if (obj instanceof Activity) {
                this.H = new C1586uv2((Activity) obj, this.a0);
            } else if (obj instanceof Dialog) {
                this.H = new C1586uv2((Dialog) obj);
            }
            AbstractC0508d3 abstractC0508d3 = this.H;
            if (abstractC0508d3 != null) {
                abstractC0508d3.m(this.v0);
            }
        }
    }

    public final void C(int i) {
        this.t0 = (1 << i) | this.t0;
        if (this.s0) {
            return;
        }
        View decorView = this.E.getDecorView();
        Ua ua = this.u0;
        WeakHashMap weakHashMap = AbstractC0604eo2.a;
        decorView.postOnAnimation(ua);
        this.s0 = true;
    }

    public final int D(int i, Context context) {
        if (i == -100) {
            return -1;
        }
        if (i == -1) {
            return i;
        }
        if (i == 0) {
            if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                return -1;
            }
            return z(context).b();
        }
        if (i == 1 || i == 2) {
            return i;
        }
        if (i != 3) {
            throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
        }
        if (this.r0 == null) {
            this.r0 = new C0425bb(this, context);
        }
        return this.r0.b();
    }

    public final boolean E() {
        boolean z = this.h0;
        this.h0 = false;
        C0595eb c0595ebA = A(0);
        if (c0595ebA.m) {
            if (!z) {
                t(c0595ebA, true);
            }
            return true;
        }
        H3 h3 = this.N;
        if (h3 != null) {
            h3.c();
            return true;
        }
        B();
        AbstractC0508d3 abstractC0508d3 = this.H;
        return abstractC0508d3 != null && abstractC0508d3.b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x0173, code lost:
    
        if (r3.z.getCount() > 0) goto L88;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F(defpackage.C0595eb r18, android.view.KeyEvent r19) {
        /*
            Method dump skipped, instruction units count: 472
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.LayoutInflaterFactory2C0658fb.F(eb, android.view.KeyEvent):void");
    }

    public final boolean G(C0595eb c0595eb, int i, KeyEvent keyEvent) {
        MenuC0775hQ0 menuC0775hQ0;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((c0595eb.k || H(c0595eb, keyEvent)) && (menuC0775hQ0 = c0595eb.h) != null) {
            return menuC0775hQ0.performShortcut(i, keyEvent, 1);
        }
        return false;
    }

    public final boolean H(C0595eb c0595eb, KeyEvent keyEvent) {
        InterfaceC1513tV interfaceC1513tV;
        InterfaceC1513tV interfaceC1513tV2;
        Resources.Theme themeNewTheme;
        InterfaceC1513tV interfaceC1513tV3;
        InterfaceC1513tV interfaceC1513tV4;
        if (this.k0) {
            return false;
        }
        if (c0595eb.k) {
            return true;
        }
        C0595eb c0595eb2 = this.g0;
        if (c0595eb2 != null && c0595eb2 != c0595eb) {
            t(c0595eb2, false);
        }
        Window.Callback callback = this.E.getCallback();
        int i = c0595eb.a;
        if (callback != null) {
            c0595eb.g = callback.onCreatePanelView(i);
        }
        boolean z = i == 0 || i == 108;
        if (z && (interfaceC1513tV4 = this.K) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC1513tV4;
            actionBarOverlayLayout.j();
            actionBarOverlayLayout.x.l = true;
        }
        if (c0595eb.g == null && (!z || !(this.H instanceof mb2))) {
            MenuC0775hQ0 menuC0775hQ0 = c0595eb.h;
            if (menuC0775hQ0 == null || c0595eb.o) {
                if (menuC0775hQ0 == null) {
                    Context context = this.D;
                    if ((i == 0 || i == 108) && this.K != null) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme = context.getTheme();
                        theme.resolveAttribute(Ep1.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            themeNewTheme = context.getResources().newTheme();
                            themeNewTheme.setTo(theme);
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                            themeNewTheme.resolveAttribute(Ep1.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme.resolveAttribute(Ep1.actionBarWidgetTheme, typedValue, true);
                            themeNewTheme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (themeNewTheme == null) {
                                themeNewTheme = context.getResources().newTheme();
                                themeNewTheme.setTo(theme);
                            }
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                        }
                        if (themeNewTheme != null) {
                            C1264pM c1264pM = new C1264pM(0, context);
                            c1264pM.getTheme().setTo(themeNewTheme);
                            context = c1264pM;
                        }
                    }
                    MenuC0775hQ0 menuC0775hQ02 = new MenuC0775hQ0(context);
                    menuC0775hQ02.e = this;
                    MenuC0775hQ0 menuC0775hQ03 = c0595eb.h;
                    if (menuC0775hQ02 != menuC0775hQ03) {
                        if (menuC0775hQ03 != null) {
                            menuC0775hQ03.r(c0595eb.i);
                        }
                        c0595eb.h = menuC0775hQ02;
                        JG0 jg0 = c0595eb.i;
                        if (jg0 != null) {
                            menuC0775hQ02.b(jg0, menuC0775hQ02.a);
                        }
                    }
                    if (c0595eb.h == null) {
                        return false;
                    }
                }
                if (z && (interfaceC1513tV2 = this.K) != null) {
                    if (this.L == null) {
                        this.L = new Va(this, 2);
                    }
                    ((ActionBarOverlayLayout) interfaceC1513tV2).m(c0595eb.h, this.L);
                }
                c0595eb.h.w();
                if (!callback.onCreatePanelMenu(i, c0595eb.h)) {
                    MenuC0775hQ0 menuC0775hQ04 = c0595eb.h;
                    if (menuC0775hQ04 != null) {
                        if (menuC0775hQ04 != null) {
                            menuC0775hQ04.r(c0595eb.i);
                        }
                        c0595eb.h = null;
                    }
                    if (z && (interfaceC1513tV = this.K) != null) {
                        ((ActionBarOverlayLayout) interfaceC1513tV).m(null, this.L);
                    }
                    return false;
                }
                c0595eb.o = false;
            }
            c0595eb.h.w();
            Bundle bundle = c0595eb.p;
            if (bundle != null) {
                c0595eb.h.s(bundle);
                c0595eb.p = null;
            }
            if (!callback.onPreparePanel(0, c0595eb.g, c0595eb.h)) {
                if (z && (interfaceC1513tV3 = this.K) != null) {
                    ((ActionBarOverlayLayout) interfaceC1513tV3).m(null, this.L);
                }
                c0595eb.h.v();
                return false;
            }
            c0595eb.h.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            c0595eb.h.v();
        }
        c0595eb.k = true;
        c0595eb.l = false;
        this.g0 = c0595eb;
        return true;
    }

    public final void I() {
        if (this.T) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [Za] */
    public final void J() {
        Za za;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z = false;
            if (this.z0 != null && (A(0).m || this.N != null)) {
                z = true;
            }
            if (z && this.A0 == null) {
                OnBackInvokedDispatcher onBackInvokedDispatcher = this.z0;
                ?? r1 = new OnBackInvokedCallback() { // from class: Za
                    public final void onBackInvoked() {
                        this.a.E();
                    }
                };
                Ya.b(onBackInvokedDispatcher).registerOnBackInvokedCallback(1000000, r1);
                this.A0 = r1;
                return;
            }
            if (z || (za = this.A0) == null) {
                return;
            }
            Ya.b(this.z0).unregisterOnBackInvokedCallback(za);
            this.A0 = null;
        }
    }

    @Override // defpackage.InterfaceC0641fQ0
    public final boolean a(MenuC0775hQ0 menuC0775hQ0, MenuItem menuItem) {
        C0595eb c0595eb;
        Window.Callback callback = this.E.getCallback();
        if (callback != null && !this.k0) {
            MenuC0775hQ0 menuC0775hQ0K = menuC0775hQ0.k();
            C0595eb[] c0595ebArr = this.f0;
            int length = c0595ebArr != null ? c0595ebArr.length : 0;
            int i = 0;
            while (true) {
                if (i < length) {
                    c0595eb = c0595ebArr[i];
                    if (c0595eb != null && c0595eb.h == menuC0775hQ0K) {
                        break;
                    }
                    i++;
                } else {
                    c0595eb = null;
                    break;
                }
            }
            if (c0595eb != null) {
                return callback.onMenuItemSelected(c0595eb.a, menuItem);
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
    
        if (r6.k() != false) goto L20;
     */
    @Override // defpackage.InterfaceC0641fQ0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(defpackage.MenuC0775hQ0 r6) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.LayoutInflaterFactory2C0658fb.b(hQ0):void");
    }

    @Override // defpackage.AbstractC0231Ta
    public final void c() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.D);
        if (layoutInflaterFrom.getFactory() == null) {
            layoutInflaterFrom.setFactory2(this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof LayoutInflaterFactory2C0658fb) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // defpackage.AbstractC0231Ta
    public final void d() {
        if (this.H != null) {
            B();
            if (this.H.g()) {
                return;
            }
            C(0);
        }
    }

    @Override // defpackage.AbstractC0231Ta
    public final void f() {
        String strC;
        this.i0 = true;
        o(false, true);
        y();
        Object obj = this.C;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    strC = ZW0.c(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            } catch (IllegalArgumentException unused) {
                strC = null;
            }
            if (strC != null) {
                AbstractC0508d3 abstractC0508d3 = this.H;
                if (abstractC0508d3 == null) {
                    this.v0 = true;
                } else {
                    abstractC0508d3.m(true);
                }
            }
            synchronized (AbstractC0231Ta.A) {
                AbstractC0231Ta.h(this);
                AbstractC0231Ta.z.add(new WeakReference(this));
            }
        }
        this.l0 = new Configuration(this.D.getResources().getConfiguration());
        this.j0 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    @Override // defpackage.AbstractC0231Ta
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.C
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L11
            java.lang.Object r0 = defpackage.AbstractC0231Ta.A
            monitor-enter(r0)
            defpackage.AbstractC0231Ta.h(r3)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            goto L11
        Le:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r1
        L11:
            boolean r0 = r3.s0
            if (r0 == 0) goto L20
            android.view.Window r0 = r3.E
            android.view.View r0 = r0.getDecorView()
            Ua r1 = r3.u0
            r0.removeCallbacks(r1)
        L20:
            r0 = 1
            r3.k0 = r0
            int r0 = r3.m0
            r1 = -100
            if (r0 == r1) goto L4d
            java.lang.Object r0 = r3.C
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L4d
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L4d
            UJ1 r0 = defpackage.LayoutInflaterFactory2C0658fb.B0
            java.lang.Object r1 = r3.C
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.m0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L5c
        L4d:
            UJ1 r0 = defpackage.LayoutInflaterFactory2C0658fb.B0
            java.lang.Object r1 = r3.C
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L5c:
            d3 r0 = r3.H
            if (r0 == 0) goto L63
            r0.i()
        L63:
            bb r0 = r3.q0
            if (r0 == 0) goto L6a
            r0.a()
        L6a:
            bb r0 = r3.r0
            if (r0 == 0) goto L71
            r0.a()
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.LayoutInflaterFactory2C0658fb.g():void");
    }

    @Override // defpackage.AbstractC0231Ta
    public final boolean i(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i = 108;
        } else if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i = 109;
        }
        if (this.d0 && i == 108) {
            return false;
        }
        if (this.Z && i == 1) {
            this.Z = false;
        }
        if (i == 1) {
            I();
            this.d0 = true;
            return true;
        }
        if (i == 2) {
            I();
            this.X = true;
            return true;
        }
        if (i == 5) {
            I();
            this.Y = true;
            return true;
        }
        if (i == 10) {
            I();
            this.b0 = true;
            return true;
        }
        if (i == 108) {
            I();
            this.Z = true;
            return true;
        }
        if (i != 109) {
            return this.E.requestFeature(i);
        }
        I();
        this.a0 = true;
        return true;
    }

    @Override // defpackage.AbstractC0231Ta
    public final void j(int i) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.U.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.D).inflate(i, viewGroup);
        this.F.a(this.E.getCallback());
    }

    @Override // defpackage.AbstractC0231Ta
    public final void k(View view) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.U.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.F.a(this.E.getCallback());
    }

    @Override // defpackage.AbstractC0231Ta
    public final void l(View view, ViewGroup.LayoutParams layoutParams) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.U.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.F.a(this.E.getCallback());
    }

    @Override // defpackage.AbstractC0231Ta
    public final void n(CharSequence charSequence) {
        this.f27J = charSequence;
        InterfaceC1513tV interfaceC1513tV = this.K;
        if (interfaceC1513tV == null) {
            AbstractC0508d3 abstractC0508d3 = this.H;
            if (abstractC0508d3 != null) {
                abstractC0508d3.s(charSequence);
                return;
            }
            TextView textView = this.V;
            if (textView != null) {
                textView.setText(charSequence);
                return;
            }
            return;
        }
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC1513tV;
        actionBarOverlayLayout.j();
        C0791hd2 c0791hd2 = actionBarOverlayLayout.x;
        if (c0791hd2.g) {
            return;
        }
        c0791hd2.h = charSequence;
        if ((c0791hd2.b & 8) != 0) {
            Toolbar toolbar = c0791hd2.a;
            toolbar.G(charSequence);
            if (c0791hd2.g) {
                AbstractC0604eo2.p(charSequence, toolbar.getRootView());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:71:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean o(boolean r13, boolean r14) {
        /*
            Method dump skipped, instruction units count: 491
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.LayoutInflaterFactory2C0658fb.o(boolean, boolean):boolean");
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (this.y0 == null) {
            int[] iArr = AbstractC0305Yp1.AppCompatTheme;
            Context context2 = this.D;
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(iArr);
            String string = typedArrayObtainStyledAttributes.getString(AbstractC0305Yp1.AppCompatTheme_viewInflaterClass);
            typedArrayObtainStyledAttributes.recycle();
            if (string == null) {
                this.y0 = new Xb();
            } else {
                try {
                    this.y0 = (Xb) context2.getClassLoader().loadClass(string).getDeclaredConstructor(null).newInstance(null);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.y0 = new Xb();
                }
            }
        }
        Xb xb = this.y0;
        int i = AbstractC1049ln2.a;
        return xb.f(view, str, context, attributeSet);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(android.view.Window r4) {
        /*
            r3 = this;
            android.view.Window r0 = r3.E
            java.lang.String r1 = "AppCompat has already installed itself into the Window"
            if (r0 != 0) goto L6a
            android.view.Window$Callback r0 = r4.getCallback()
            boolean r2 = r0 instanceof defpackage.WindowCallbackC0365ab
            if (r2 != 0) goto L64
            ab r1 = new ab
            r1.<init>(r3, r0)
            r3.F = r1
            r4.setCallback(r1)
            int[] r0 = defpackage.LayoutInflaterFactory2C0658fb.C0
            android.content.Context r1 = r3.D
            r2 = 0
            qa2 r0 = defpackage.C1342qa2.e(r1, r2, r0)
            r1 = 0
            android.graphics.drawable.Drawable r1 = r0.c(r1)
            if (r1 == 0) goto L2b
            r4.setBackgroundDrawable(r1)
        L2b:
            r0.g()
            r3.E = r4
            int r4 = android.os.Build.VERSION.SDK_INT
            r0 = 33
            if (r4 < r0) goto L63
            android.window.OnBackInvokedDispatcher r4 = r3.z0
            if (r4 != 0) goto L63
            if (r4 == 0) goto L49
            Za r0 = r3.A0
            if (r0 == 0) goto L49
            android.window.OnBackInvokedDispatcher r4 = defpackage.Ya.b(r4)
            defpackage.Ya.d(r4, r0)
            r3.A0 = r2
        L49:
            java.lang.Object r4 = r3.C
            boolean r0 = r4 instanceof android.app.Activity
            if (r0 == 0) goto L5e
            android.app.Activity r4 = (android.app.Activity) r4
            android.view.Window r0 = r4.getWindow()
            if (r0 == 0) goto L5e
            android.window.OnBackInvokedDispatcher r4 = defpackage.Ya.a(r4)
            r3.z0 = r4
            goto L60
        L5e:
            r3.z0 = r2
        L60:
            r3.J()
        L63:
            return
        L64:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            r4.<init>(r1)
            throw r4
        L6a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            r4.<init>(r1)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.LayoutInflaterFactory2C0658fb.p(android.view.Window):void");
    }

    public final void r(int i, C0595eb c0595eb, MenuC0775hQ0 menuC0775hQ0) {
        if (menuC0775hQ0 == null) {
            if (c0595eb == null && i >= 0) {
                C0595eb[] c0595ebArr = this.f0;
                if (i < c0595ebArr.length) {
                    c0595eb = c0595ebArr[i];
                }
            }
            if (c0595eb != null) {
                menuC0775hQ0 = c0595eb.h;
            }
        }
        if ((c0595eb == null || c0595eb.m) && !this.k0) {
            WindowCallbackC0365ab windowCallbackC0365ab = this.F;
            Window.Callback callback = this.E.getCallback();
            windowCallbackC0365ab.getClass();
            try {
                windowCallbackC0365ab.x = true;
                callback.onPanelClosed(i, menuC0775hQ0);
            } finally {
                windowCallbackC0365ab.x = false;
            }
        }
    }

    public final void s(MenuC0775hQ0 menuC0775hQ0) {
        C3 c3;
        if (this.e0) {
            return;
        }
        this.e0 = true;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.K;
        actionBarOverlayLayout.j();
        ActionMenuView actionMenuView = actionBarOverlayLayout.x.a.t;
        if (actionMenuView != null && (c3 = actionMenuView.M) != null) {
            c3.g();
            C1710x3 c1710x3 = c3.M;
            if (c1710x3 != null && c1710x3.b()) {
                c1710x3.i.dismiss();
            }
        }
        Window.Callback callback = this.E.getCallback();
        if (callback != null && !this.k0) {
            callback.onPanelClosed(108, menuC0775hQ0);
        }
        this.e0 = false;
    }

    public final void t(C0595eb c0595eb, boolean z) {
        C0538db c0538db;
        InterfaceC1513tV interfaceC1513tV;
        if (z && c0595eb.a == 0 && (interfaceC1513tV = this.K) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC1513tV;
            actionBarOverlayLayout.j();
            if (actionBarOverlayLayout.x.a.u()) {
                s(c0595eb.h);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.D.getSystemService("window");
        if (windowManager != null && c0595eb.m && (c0538db = c0595eb.e) != null) {
            windowManager.removeView(c0538db);
            if (z) {
                r(c0595eb.a, c0595eb, null);
            }
        }
        c0595eb.k = false;
        c0595eb.l = false;
        c0595eb.m = false;
        c0595eb.f = null;
        c0595eb.n = true;
        if (this.g0 == c0595eb) {
            this.g0 = null;
        }
        if (c0595eb.a == 0) {
            J();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean v(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instruction units count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.LayoutInflaterFactory2C0658fb.v(android.view.KeyEvent):boolean");
    }

    public final void w(int i) {
        C0595eb c0595ebA = A(i);
        if (c0595ebA.h != null) {
            Bundle bundle = new Bundle();
            c0595ebA.h.t(bundle);
            if (bundle.size() > 0) {
                c0595ebA.p = bundle;
            }
            c0595ebA.h.w();
            c0595ebA.h.clear();
        }
        c0595ebA.o = true;
        c0595ebA.n = true;
        if ((i == 108 || i == 0) && this.K != null) {
            C0595eb c0595ebA2 = A(0);
            c0595ebA2.k = false;
            H(c0595ebA2, null);
        }
    }

    public final void x() {
        ViewGroup viewGroup;
        int i = 1;
        int i2 = 0;
        if (this.T) {
            return;
        }
        int[] iArr = AbstractC0305Yp1.AppCompatTheme;
        Context context = this.D;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(AbstractC0305Yp1.AppCompatTheme_windowActionBar)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(AbstractC0305Yp1.AppCompatTheme_windowNoTitle, false)) {
            i(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(AbstractC0305Yp1.AppCompatTheme_windowActionBar, false)) {
            i(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(AbstractC0305Yp1.AppCompatTheme_windowActionBarOverlay, false)) {
            i(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(AbstractC0305Yp1.AppCompatTheme_windowActionModeOverlay, false)) {
            i(10);
        }
        this.c0 = typedArrayObtainStyledAttributes.getBoolean(AbstractC0305Yp1.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        y();
        this.E.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (this.d0) {
            viewGroup = this.b0 ? (ViewGroup) layoutInflaterFrom.inflate(AbstractC0189Pp1.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(AbstractC0189Pp1.abc_screen_simple, (ViewGroup) null);
        } else if (this.c0) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(AbstractC0189Pp1.abc_dialog_title_material, (ViewGroup) null);
            this.a0 = false;
            this.Z = false;
        } else if (this.Z) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(Ep1.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new C1264pM(typedValue.resourceId, context) : context).inflate(AbstractC0189Pp1.abc_screen_toolbar, (ViewGroup) null);
            InterfaceC1513tV interfaceC1513tV = (InterfaceC1513tV) viewGroup.findViewById(AbstractC0132Lp1.decor_content_parent);
            this.K = interfaceC1513tV;
            Window.Callback callback = this.E.getCallback();
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC1513tV;
            actionBarOverlayLayout.j();
            actionBarOverlayLayout.x.k = callback;
            if (this.a0) {
                ((ActionBarOverlayLayout) this.K).i(109);
            }
            if (this.X) {
                ((ActionBarOverlayLayout) this.K).i(2);
            }
            if (this.Y) {
                ((ActionBarOverlayLayout) this.K).i(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.Z + ", windowActionBarOverlay: " + this.a0 + ", android:windowIsFloating: " + this.c0 + ", windowActionModeOverlay: " + this.b0 + ", windowNoTitle: " + this.d0 + " }");
        }
        AbstractC0604eo2.q(viewGroup, new Va(this, i2));
        if (this.K == null) {
            this.V = (TextView) viewGroup.findViewById(AbstractC0132Lp1.title);
        }
        boolean z = Jp2.a;
        try {
            Method method = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", null);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(viewGroup, null);
        } catch (IllegalAccessException e) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e);
        } catch (NoSuchMethodException unused) {
        } catch (InvocationTargetException e2) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e2);
        }
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(AbstractC0132Lp1.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.E.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.E.setContentView(viewGroup);
        contentFrameLayout.A = new Va(this, i);
        this.U = viewGroup;
        Object obj = this.C;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.f27J;
        if (!TextUtils.isEmpty(title)) {
            InterfaceC1513tV interfaceC1513tV2 = this.K;
            if (interfaceC1513tV2 != null) {
                ActionBarOverlayLayout actionBarOverlayLayout2 = (ActionBarOverlayLayout) interfaceC1513tV2;
                actionBarOverlayLayout2.j();
                C0791hd2 c0791hd2 = actionBarOverlayLayout2.x;
                if (!c0791hd2.g) {
                    c0791hd2.h = title;
                    if ((c0791hd2.b & 8) != 0) {
                        Toolbar toolbar = c0791hd2.a;
                        toolbar.G(title);
                        if (c0791hd2.g) {
                            AbstractC0604eo2.p(title, toolbar.getRootView());
                        }
                    }
                }
            } else {
                AbstractC0508d3 abstractC0508d3 = this.H;
                if (abstractC0508d3 != null) {
                    abstractC0508d3.s(title);
                } else {
                    TextView textView = this.V;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.U.findViewById(R.id.content);
        View decorView = this.E.getDecorView();
        contentFrameLayout2.z.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        if (contentFrameLayout2.isLaidOut()) {
            contentFrameLayout2.requestLayout();
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(AbstractC0305Yp1.AppCompatTheme);
        int i3 = AbstractC0305Yp1.AppCompatTheme_windowMinWidthMajor;
        if (contentFrameLayout2.t == null) {
            contentFrameLayout2.t = new TypedValue();
        }
        typedArrayObtainStyledAttributes2.getValue(i3, contentFrameLayout2.t);
        int i4 = AbstractC0305Yp1.AppCompatTheme_windowMinWidthMinor;
        if (contentFrameLayout2.u == null) {
            contentFrameLayout2.u = new TypedValue();
        }
        typedArrayObtainStyledAttributes2.getValue(i4, contentFrameLayout2.u);
        if (typedArrayObtainStyledAttributes2.hasValue(AbstractC0305Yp1.AppCompatTheme_windowFixedWidthMajor)) {
            int i5 = AbstractC0305Yp1.AppCompatTheme_windowFixedWidthMajor;
            if (contentFrameLayout2.v == null) {
                contentFrameLayout2.v = new TypedValue();
            }
            typedArrayObtainStyledAttributes2.getValue(i5, contentFrameLayout2.v);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(AbstractC0305Yp1.AppCompatTheme_windowFixedWidthMinor)) {
            int i6 = AbstractC0305Yp1.AppCompatTheme_windowFixedWidthMinor;
            if (contentFrameLayout2.w == null) {
                contentFrameLayout2.w = new TypedValue();
            }
            typedArrayObtainStyledAttributes2.getValue(i6, contentFrameLayout2.w);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(AbstractC0305Yp1.AppCompatTheme_windowFixedHeightMajor)) {
            int i7 = AbstractC0305Yp1.AppCompatTheme_windowFixedHeightMajor;
            if (contentFrameLayout2.x == null) {
                contentFrameLayout2.x = new TypedValue();
            }
            typedArrayObtainStyledAttributes2.getValue(i7, contentFrameLayout2.x);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(AbstractC0305Yp1.AppCompatTheme_windowFixedHeightMinor)) {
            int i8 = AbstractC0305Yp1.AppCompatTheme_windowFixedHeightMinor;
            if (contentFrameLayout2.y == null) {
                contentFrameLayout2.y = new TypedValue();
            }
            typedArrayObtainStyledAttributes2.getValue(i8, contentFrameLayout2.y);
        }
        typedArrayObtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.T = true;
        C0595eb c0595ebA = A(0);
        if (this.k0 || c0595ebA.h != null) {
            return;
        }
        C(108);
    }

    public final void y() {
        if (this.E == null) {
            Object obj = this.C;
            if (obj instanceof Activity) {
                p(((Activity) obj).getWindow());
            }
        }
        if (this.E == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final C0425bb z(Context context) {
        if (this.q0 == null) {
            if (C1800yi2.d == null) {
                Context applicationContext = context.getApplicationContext();
                C1800yi2.d = new C1800yi2(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.q0 = new C0425bb(this, C1800yi2.d);
        }
        return this.q0;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
