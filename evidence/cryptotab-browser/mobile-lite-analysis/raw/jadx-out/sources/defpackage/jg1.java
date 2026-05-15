package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class jg1 extends o00 {
    public static final boolean v;
    public static Float w;
    public final Context r;
    public final ig1 s;
    public final Display t;
    public gg1 u;

    static {
        v = Build.VERSION.SDK_INT >= 31;
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [gg1] */
    public jg1(Display display) {
        super(display.getDisplayId());
        if (v) {
            Context context = AbstractC1499tM.a;
            LP1 lp1A = LP1.a();
            try {
                Context contextCreateWindowContext = context.createWindowContext(display, 2, null);
                this.r = contextCreateWindowContext;
                lp1A.close();
                ig1 ig1Var = new ig1(this);
                this.s = ig1Var;
                contextCreateWindowContext.registerComponentCallbacks(ig1Var);
                this.t = contextCreateWindowContext.getDisplay();
                e();
            } catch (Throwable th) {
                try {
                    lp1A.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } else {
            this.r = null;
            this.s = null;
            this.t = display;
        }
        if (Build.VERSION.SDK_INT < 34 || !this.t.isHdrSdrRatioAvailable()) {
            this.u = null;
            return;
        }
        ?? r4 = new Consumer() { // from class: gg1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                jg1 jg1Var = this.a;
                Display display2 = jg1Var.t;
                int i = Build.VERSION.SDK_INT;
                boolean z = false;
                if (i >= 34 && display2.isHdr() && display2.isHdrSdrRatioAvailable()) {
                    z = true;
                }
                jg1Var.c(null, null, null, null, null, null, null, null, null, null, null, null, Boolean.valueOf(z), i < 34 ? null : Float.valueOf(display2.getHdrSdrRatio()));
            }
        };
        this.u = r4;
        this.t.registerHdrSdrRatioChangedListener(new hg1(), r4);
    }

    public final void d(Point point, float f, float f2, float f3, Display display) {
        Float fValueOf;
        Float f4 = w;
        Float fValueOf2 = Float.valueOf(0.0f);
        if (f4 == null) {
            String strD = CH.c().d("force-device-scale-factor");
            if (strD == null) {
                w = fValueOf2;
            } else {
                try {
                    fValueOf = Float.valueOf(strD);
                    w = fValueOf;
                } catch (NumberFormatException unused) {
                }
                if (fValueOf.floatValue() <= 0.0f) {
                    Log.w("cr_DisplayAndroid", "Ignoring invalid forced DIP scale '" + strD + "'");
                    w = fValueOf2;
                }
            }
        }
        float fFloatValue = w.floatValue() > 0.0f ? w.floatValue() : f;
        int i = Build.VERSION.SDK_INT;
        boolean z = false;
        boolean zIsWideColorGamut = i >= 29 ? display.isWideColorGamut() : false;
        Display.Mode mode = display.getMode();
        Display.Mode[] supportedModes = display.getSupportedModes();
        List listAsList = (supportedModes == null || supportedModes.length <= 0) ? null : Arrays.asList(supportedModes);
        Float fValueOf3 = Float.valueOf(fFloatValue);
        Float fValueOf4 = Float.valueOf(f2);
        Float fValueOf5 = Float.valueOf(f3);
        Integer numValueOf = Integer.valueOf(display.getRotation());
        Boolean boolValueOf = Boolean.valueOf(zIsWideColorGamut);
        Float fValueOf6 = Float.valueOf(display.getRefreshRate());
        if (i >= 34 && display.isHdr() && display.isHdrSdrRatioAvailable()) {
            z = true;
        }
        c(point, fValueOf3, fValueOf4, fValueOf5, 24, 8, numValueOf, boolValueOf, null, fValueOf6, mode, listAsList, Boolean.valueOf(z), i < 34 ? null : Float.valueOf(display.getHdrSdrRatio()));
    }

    public final void e() {
        Point point = new Point();
        Context context = this.r;
        Rect bounds = ((WindowManager) context.getSystemService(WindowManager.class)).getMaximumWindowMetrics().getBounds();
        point.set(bounds.width(), bounds.height());
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = AbstractC1872zv.a;
        if (Bv.a.n && CH.c().e("automotive-web-ui-scale-up-enabled")) {
            this.t.getRealMetrics(displayMetrics);
            I00.d(context, displayMetrics);
        }
        d(point, displayMetrics.density, displayMetrics.xdpi, displayMetrics.ydpi, context.getDisplay());
    }

    public final void f(Display display) {
        if (v) {
            e();
            return;
        }
        Point point = new Point();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getRealSize(point);
        display.getRealMetrics(displayMetrics);
        int i = AbstractC1872zv.a;
        if (Bv.a.n && CH.c().e("automotive-web-ui-scale-up-enabled")) {
            I00.d(AbstractC1499tM.a, displayMetrics);
        }
        d(point, displayMetrics.density, displayMetrics.xdpi, displayMetrics.ydpi, display);
    }
}
