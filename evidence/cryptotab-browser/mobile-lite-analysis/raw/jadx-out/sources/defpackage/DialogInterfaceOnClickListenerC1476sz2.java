package defpackage;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import androidx.activity.result.IntentSenderRequest;
import com.google.android.gms.common.GoogleApiAvailability;

/* JADX INFO: renamed from: sz2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class DialogInterfaceOnClickListenerC1476sz2 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Activity t;
    public final /* synthetic */ int u;
    public final /* synthetic */ o4 v;
    public final /* synthetic */ GoogleApiAvailability w;

    public DialogInterfaceOnClickListenerC1476sz2(GoogleApiAvailability googleApiAvailability, Activity activity, int i, o4 o4Var) {
        this.w = googleApiAvailability;
        this.t = activity;
        this.u = i;
        this.v = o4Var;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        PendingIntent errorResolutionPendingIntent = this.w.getErrorResolutionPendingIntent(this.t, this.u, 0);
        if (errorResolutionPendingIntent == null) {
            return;
        }
        this.v.a(new IntentSenderRequest(errorResolutionPendingIntent.getIntentSender(), null, 0, 0));
    }
}
