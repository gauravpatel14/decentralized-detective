package defpackage;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.result.IntentSenderRequest;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class fI extends u4 {
    public final /* synthetic */ iI h;

    public fI(iI iIVar) {
        this.h = iIVar;
    }

    @Override // defpackage.u4
    public final void b(final int i, AbstractC1065m4 abstractC1065m4, Object obj) {
        Bundle bundle;
        iI iIVar = this.h;
        final l4 l4VarB = abstractC1065m4.b(iIVar, obj);
        if (l4VarB != null) {
            final int i2 = 0;
            new Handler(Looper.getMainLooper()).post(new Runnable(this) { // from class: eI
                public final /* synthetic */ fI u;

                {
                    this.u = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i2) {
                        case 0:
                            Object obj2 = ((l4) l4VarB).a;
                            fI fIVar = this.u;
                            String str = (String) fIVar.a.get(Integer.valueOf(i));
                            if (str != null) {
                                q4 q4Var = (q4) fIVar.e.get(str);
                                if ((q4Var != null ? q4Var.a : null) != null) {
                                    k4 k4Var = q4Var.a;
                                    if (fIVar.d.remove(str)) {
                                        k4Var.a(obj2);
                                    }
                                } else {
                                    fIVar.g.remove(str);
                                    fIVar.f.put(str, obj2);
                                }
                                break;
                            }
                            break;
                        default:
                            this.u.a(i, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) l4VarB));
                            break;
                    }
                }
            });
            return;
        }
        Intent intentA = abstractC1065m4.a(obj);
        if (intentA.getExtras() != null && intentA.getExtras().getClassLoader() == null) {
            intentA.setExtrasClassLoader(iIVar.getClassLoader());
        }
        if (intentA.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            Bundle bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            bundle = bundleExtra;
        } else {
            bundle = null;
        }
        if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentA.getAction())) {
            String[] stringArrayExtra = intentA.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            U3.c(iIVar, stringArrayExtra, i);
            return;
        }
        if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentA.getAction())) {
            iIVar.startActivityForResult(intentA, i, bundle);
            return;
        }
        IntentSenderRequest intentSenderRequest = (IntentSenderRequest) intentA.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
        try {
            iIVar.startIntentSenderForResult(intentSenderRequest.t, i, intentSenderRequest.u, intentSenderRequest.v, intentSenderRequest.w, 0, bundle);
        } catch (IntentSender.SendIntentException e) {
            final int i3 = 1;
            new Handler(Looper.getMainLooper()).post(new Runnable(this) { // from class: eI
                public final /* synthetic */ fI u;

                {
                    this.u = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i3) {
                        case 0:
                            Object obj2 = ((l4) e).a;
                            fI fIVar = this.u;
                            String str = (String) fIVar.a.get(Integer.valueOf(i));
                            if (str != null) {
                                q4 q4Var = (q4) fIVar.e.get(str);
                                if ((q4Var != null ? q4Var.a : null) != null) {
                                    k4 k4Var = q4Var.a;
                                    if (fIVar.d.remove(str)) {
                                        k4Var.a(obj2);
                                    }
                                } else {
                                    fIVar.g.remove(str);
                                    fIVar.f.put(str, obj2);
                                }
                                break;
                            }
                            break;
                        default:
                            this.u.a(i, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) e));
                            break;
                    }
                }
            });
        }
    }
}
