package org.chromium.components.payments;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import defpackage.Lc1;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class PaymentDetailsUpdateService extends Service {
    public final Lc1 t;

    public PaymentDetailsUpdateService() {
        Lc1 lc1 = new Lc1();
        lc1.attachInterface(lc1, "org.chromium.components.payments.IPaymentDetailsUpdateService");
        this.t = lc1;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.t;
    }
}
