package org.chromium.chrome.browser.services.gcm;

import android.annotation.SuppressLint;
import android.content.Context;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.firebase.messaging.SendException;
import defpackage.aN1;
import org.chromium.base.BundleUtils;
import org.chromium.chrome.browser.base.SplitChromeApplication;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"MissingFirebaseInstanceTokenRefresh"})
public class ChromeGcmListenerService extends FirebaseMessagingService {
    public aN1 A;
    public String z = "Cf0";

    @Override // android.app.Service, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Context contextB = SplitChromeApplication.b(context);
        aN1 an1 = (aN1) BundleUtils.g(contextB, this.z);
        this.A = an1;
        an1.getClass();
        super.attachBaseContext(contextB);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void d() {
        this.A.b();
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void e(RemoteMessage remoteMessage) {
        this.A.c(remoteMessage);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void f(String str) {
        this.A.d();
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void g(String str) {
        this.A.e(str);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void h(String str, SendException sendException) {
        this.A.f(str, sendException);
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.A.a();
    }
}
