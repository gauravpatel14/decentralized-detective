package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import org.chromium.base.BundleUtils;
import org.chromium.base.JNIUtils;
import org.chromium.chrome.browser.base.SplitChromeApplication;

/* JADX INFO: renamed from: rN1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1383rN1 extends AbstractC1103mg {
    public final String h = "chrome";
    public MM1 i;
    public final /* synthetic */ C1443sN1 j;

    public C1383rN1(C1443sN1 c1443sN1, MM1 mm1) {
        this.j = c1443sN1;
        this.i = mm1;
    }

    @Override // defpackage.AbstractC1103mg
    public final Object b() {
        final Context contextN = n();
        if (this.i == null) {
            return null;
        }
        final HandlerThread handlerThread = new HandlerThread("ActivityPreload");
        handlerThread.start();
        new Handler(handlerThread.getLooper()).post(new Runnable() { // from class: LM1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    contextN.getClassLoader().loadClass("org.chromium.chrome.browser.ChromeTabbedActivity$Preload").newInstance();
                    handlerThread.quit();
                } catch (ReflectiveOperationException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return null;
    }

    @Override // defpackage.AbstractC1103mg
    public final void k(Object obj) throws IllegalAccessException, NoSuchFieldException {
        o();
    }

    public final Context n() {
        String str = this.h;
        boolean zF = BundleUtils.f(str);
        C1443sN1 c1443sN1 = this.j;
        if (!zF) {
            return c1443sN1.b;
        }
        Context contextA = BundleUtils.a(c1443sN1.b, str);
        Rl0 rl0 = Rl0.d;
        return rl0.c ? contextA.createConfigurationContext(rl0.a(contextA)) : contextA;
    }

    public final void o() throws IllegalAccessException, NoSuchFieldException {
        try {
            g();
        } catch (Exception unused) {
        }
        MM1 mm1 = this.i;
        if (mm1 != null) {
            Context contextN = n();
            if (!mm1.a.getClassLoader().equals(contextN.getClassLoader())) {
                ClassLoader classLoader = contextN.getClassLoader();
                SplitChromeApplication splitChromeApplication = mm1.b;
                BundleUtils.h(splitChromeApplication, classLoader);
                JNIUtils.a = contextN.getClassLoader();
                splitChromeApplication.w = contextN.getResources();
            }
            this.i = null;
        }
    }
}
