package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import defpackage.InterfaceC1111ms0;
import defpackage.Li1;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class PostMessageService extends Service {
    public final Li1 t;

    public PostMessageService() {
        Li1 li1 = new Li1();
        li1.attachInterface(li1, InterfaceC1111ms0.g);
        this.t = li1;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.t;
    }
}
