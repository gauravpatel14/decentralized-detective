package defpackage;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.ProxyInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import org.chromium.net.ProxyChangeListener;

/* JADX INFO: renamed from: mn1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC1109mn1 implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ Intent u;
    public final /* synthetic */ Object v;

    public /* synthetic */ RunnableC1109mn1(Object obj, Intent intent, int i) {
        this.t = i;
        this.v = obj;
        this.u = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Intent intent = this.u;
        Object obj = this.v;
        switch (this.t) {
            case 0:
                ProxyChangeListener proxyChangeListener = (ProxyChangeListener) obj;
                proxyChangeListener.getClass();
                C1170nn1 c1170nn1A = C1170nn1.a(((ConnectivityManager) AbstractC1499tM.a.getSystemService("connectivity")).getDefaultProxy());
                if (c1170nn1A == null) {
                    c1170nn1 = C1170nn1.e;
                } else if (Build.VERSION.SDK_INT >= 29 && c1170nn1A.a.equals("localhost") && c1170nn1A.b == -1) {
                    Bundle extras = intent.getExtras();
                    C1170nn1 c1170nn1A2 = extras == null ? null : C1170nn1.a((ProxyInfo) extras.get("android.intent.extra.PROXY_INFO"));
                    Log.i("cr_ProxyChangeListener", "configFromConnectivityManager = " + c1170nn1A + ", configFromIntent = " + c1170nn1A2);
                    if (c1170nn1A2 != null) {
                        c1170nn1 = new C1170nn1(c1170nn1A2.a, c1170nn1A2.b, c1170nn1A.c, c1170nn1A.d);
                    }
                } else {
                    c1170nn1 = c1170nn1A;
                }
                proxyChangeListener.a(c1170nn1);
                break;
            default:
                int i = ProxyChangeListener.ProxyReceiver.b;
                ProxyChangeListener.ProxyReceiver proxyReceiver = (ProxyChangeListener.ProxyReceiver) obj;
                proxyReceiver.getClass();
                Bundle extras2 = intent.getExtras();
                proxyReceiver.a.a(extras2 != null ? C1170nn1.a((ProxyInfo) extras2.get("android.intent.extra.PROXY_INFO")) : null);
                break;
        }
    }
}
