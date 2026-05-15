package org.chromium.net;

import J.N;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import defpackage.AbstractC1499tM;
import defpackage.AbstractC1872zv;
import defpackage.C1048ln1;
import defpackage.C1170nn1;
import defpackage.RunnableC1109mn1;
import org.chromium.base.TraceEvent;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ProxyChangeListener {
    public final Looper a;
    public final Handler b;
    public long c;
    public ProxyReceiver d;
    public C1048ln1 e;

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public class ProxyReceiver extends BroadcastReceiver {
        public static final /* synthetic */ int b = 0;

        public ProxyReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.PROXY_CHANGE")) {
                RunnableC1109mn1 runnableC1109mn1 = new RunnableC1109mn1(this, intent, 1);
                ProxyChangeListener proxyChangeListener = ProxyChangeListener.this;
                if (proxyChangeListener.a == Looper.myLooper()) {
                    runnableC1109mn1.run();
                } else {
                    proxyChangeListener.b.post(runnableC1109mn1);
                }
            }
        }
    }

    public ProxyChangeListener() {
        Looper looperMyLooper = Looper.myLooper();
        this.a = looperMyLooper;
        this.b = new Handler(looperMyLooper);
    }

    public static ProxyChangeListener create() {
        return new ProxyChangeListener();
    }

    public static String getProperty(String str) {
        return System.getProperty(str);
    }

    public final void a(C1170nn1 c1170nn1) {
        int i = AbstractC1872zv.a;
        long j = this.c;
        if (j == 0) {
            return;
        }
        if (c1170nn1 != null) {
            N._V_IJOOOO(2, c1170nn1.b, j, this, c1170nn1.a, c1170nn1.c, c1170nn1.d);
        } else {
            N._V_JO(277, j, this);
        }
    }

    public final void b() {
        int i = AbstractC1872zv.a;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PROXY_CHANGE");
        this.d = new ProxyReceiver();
        if (!(Build.VERSION.SDK_INT >= 33 ? Process.isSdkSandbox() : false)) {
            AbstractC1499tM.a.registerReceiver(this.d, new IntentFilter(), null, null, 4);
        }
        C1048ln1 c1048ln1 = new C1048ln1(this);
        this.e = c1048ln1;
        AbstractC1499tM.d(AbstractC1499tM.a, c1048ln1, intentFilter);
    }

    public void start(long j) {
        TraceEvent traceEventJ = TraceEvent.j("ProxyChangeListener.start", null);
        try {
            int i = AbstractC1872zv.a;
            this.c = j;
            b();
            if (traceEventJ != null) {
                traceEventJ.close();
            }
        } catch (Throwable th) {
            if (traceEventJ != null) {
                try {
                    traceEventJ.close();
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
    }

    public void stop() {
        int i = AbstractC1872zv.a;
        this.c = 0L;
        AbstractC1499tM.a.unregisterReceiver(this.d);
        C1048ln1 c1048ln1 = this.e;
        if (c1048ln1 != null) {
            AbstractC1499tM.a.unregisterReceiver(c1048ln1);
        }
        this.d = null;
        this.e = null;
    }
}
