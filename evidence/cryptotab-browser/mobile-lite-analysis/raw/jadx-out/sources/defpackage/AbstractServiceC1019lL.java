package defpackage;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import org.chromium.base.BuildInfo;
import org.chromium.content.app.ContentChildProcessServiceDelegate;

/* JADX INFO: renamed from: lL, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractServiceC1019lL extends Service {
    public CA t;

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        CA ca = this.t;
        if (!ca.m) {
            ca.b.stopSelf();
            ca.f = intent.getBooleanExtra("org.chromium.base.process_launcher.extra.bind_to_caller", false);
            ca.m = true;
            ca.a.getClass();
            OE0 oe0 = OE0.h;
            NE0 ne0 = oe0.d;
            intent.getExtras().getLong("org.chromium.base.android.linker.base_load_address", 0L);
            oe0.f(intent.getExtras().getInt("org.chromium.content.common.child_service_params.library_process_type", 2));
            String stringExtra = intent.getStringExtra("org.chromium.base.process_launcher.extra.browser_package_name");
            if (stringExtra == null) {
                stringExtra = ca.c.getApplicationInfo().packageName;
            }
            new Handler(Looper.getMainLooper()).post(new RunnableC1818zA(ca, stringExtra));
        }
        return ca.o;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        Context applicationContext = getApplicationContext();
        ContentChildProcessServiceDelegate contentChildProcessServiceDelegate = new ContentChildProcessServiceDelegate();
        if (!BuildInfo.a()) {
            Thread.setDefaultUncaughtExceptionHandler(new KC0());
        }
        CA ca = new CA(contentChildProcessServiceDelegate, this, applicationContext);
        this.t = ca;
        Log.i("cr_ChildProcessService", "Creating new ChildProcessService pid=" + Process.myPid());
        if (CA.p) {
            throw new RuntimeException("Illegal child process reuse.");
        }
        CA.p = true;
        int i = AbstractC1872zv.a;
        AbstractC1499tM.a = ca.c;
        ca.a.getClass();
        Thread thread = new Thread(null, new RunnableC1818zA(ca), "ChildProcessMain", Process.is64Bit() ? 8388608L : 4194304L);
        ca.i = thread;
        thread.start();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.t.getClass();
        Log.i("cr_ChildProcessService", "Destroying ChildProcessService pid=" + Process.myPid());
        System.exit(0);
        this.t = null;
    }
}
