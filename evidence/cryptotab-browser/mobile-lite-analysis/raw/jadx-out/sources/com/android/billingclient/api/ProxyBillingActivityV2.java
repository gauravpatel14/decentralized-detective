package com.android.billingclient.api;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import com.android.billingclient.api.ProxyBillingActivityV2;
import com.google.android.apps.common.proguard.UsedByReflection;
import defpackage.AbstractC1659wF2;
import defpackage.C1127n4;
import defpackage.C1480t4;
import defpackage.fI;
import defpackage.iI;
import defpackage.k4;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@UsedByReflection("PlatformActivityProxy")
public class ProxyBillingActivityV2 extends iI {
    public C1480t4 N;
    public C1480t4 O;
    public ResultReceiver P;
    public ResultReceiver Q;

    @Override // defpackage.iI, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1127n4 c1127n4 = new C1127n4(2);
        k4 k4Var = new k4() { // from class: fK2
            @Override // defpackage.k4
            public final void a(Object obj) {
                ActivityResult activityResult = (ActivityResult) obj;
                ProxyBillingActivityV2 proxyBillingActivityV2 = this.a;
                proxyBillingActivityV2.getClass();
                Intent intent = activityResult.u;
                int i = AbstractC1659wF2.c("ProxyBillingActivityV2", intent).a;
                ResultReceiver resultReceiver = proxyBillingActivityV2.P;
                if (resultReceiver != null) {
                    resultReceiver.send(i, intent == null ? null : intent.getExtras());
                }
                int i2 = activityResult.t;
                if (i2 != -1 || i != 0) {
                    AbstractC1659wF2.e("ProxyBillingActivityV2", "Alternative billing only dialog finished with resultCode " + i2 + " and billing's responseCode: " + i);
                }
                proxyBillingActivityV2.finish();
            }
        };
        StringBuilder sb = new StringBuilder("activity_rq#");
        AtomicInteger atomicInteger = this.A;
        sb.append(atomicInteger.getAndIncrement());
        String string = sb.toString();
        fI fIVar = this.B;
        this.N = fIVar.d(string, this, c1127n4, k4Var);
        this.O = fIVar.d("activity_rq#" + atomicInteger.getAndIncrement(), this, new C1127n4(2), new k4() { // from class: mK2
            @Override // defpackage.k4
            public final void a(Object obj) {
                ActivityResult activityResult = (ActivityResult) obj;
                ProxyBillingActivityV2 proxyBillingActivityV2 = this.a;
                proxyBillingActivityV2.getClass();
                Intent intent = activityResult.u;
                int i = AbstractC1659wF2.c("ProxyBillingActivityV2", intent).a;
                ResultReceiver resultReceiver = proxyBillingActivityV2.Q;
                if (resultReceiver != null) {
                    resultReceiver.send(i, intent == null ? null : intent.getExtras());
                }
                int i2 = activityResult.t;
                if (i2 != -1 || i != 0) {
                    AbstractC1659wF2.e("ProxyBillingActivityV2", "External offer dialog finished with resultCode: " + i2 + " and billing's responseCode: " + i);
                }
                proxyBillingActivityV2.finish();
            }
        });
        if (bundle != null) {
            if (bundle.containsKey("alternative_billing_only_dialog_result_receiver")) {
                this.P = (ResultReceiver) bundle.getParcelable("alternative_billing_only_dialog_result_receiver");
                return;
            } else {
                if (bundle.containsKey("external_payment_dialog_result_receiver")) {
                    this.Q = (ResultReceiver) bundle.getParcelable("external_payment_dialog_result_receiver");
                    return;
                }
                return;
            }
        }
        int i = AbstractC1659wF2.a;
        if (getIntent().hasExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT")) {
            PendingIntent pendingIntent = (PendingIntent) getIntent().getParcelableExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT");
            this.P = (ResultReceiver) getIntent().getParcelableExtra("alternative_billing_only_dialog_result_receiver");
            this.N.a(new IntentSenderRequest(pendingIntent.getIntentSender(), null, 0, 0));
        } else if (getIntent().hasExtra("external_payment_dialog_pending_intent")) {
            PendingIntent pendingIntent2 = (PendingIntent) getIntent().getParcelableExtra("external_payment_dialog_pending_intent");
            this.Q = (ResultReceiver) getIntent().getParcelableExtra("external_payment_dialog_result_receiver");
            this.O.a(new IntentSenderRequest(pendingIntent2.getIntentSender(), null, 0, 0));
        }
    }

    @Override // defpackage.iI, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.P;
        if (resultReceiver != null) {
            bundle.putParcelable("alternative_billing_only_dialog_result_receiver", resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.Q;
        if (resultReceiver2 != null) {
            bundle.putParcelable("external_payment_dialog_result_receiver", resultReceiver2);
        }
    }
}
