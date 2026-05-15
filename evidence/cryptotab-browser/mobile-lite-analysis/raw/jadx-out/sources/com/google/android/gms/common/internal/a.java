package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import defpackage.AbstractC1214oR1;
import defpackage.HandlerC0531dU2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends HandlerC0531dU2 {
    public final /* synthetic */ BaseGmsClient a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BaseGmsClient baseGmsClient, Looper looper) {
        super(looper);
        this.a = baseGmsClient;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        BaseGmsClient baseGmsClient = this.a;
        if (baseGmsClient.zzd.get() != message.arg1) {
            int i = message.what;
            if (i == 2 || i == 1 || i == 7) {
                zzc zzcVar = (zzc) message.obj;
                zzcVar.zzc();
                zzcVar.zzg();
                return;
            }
            return;
        }
        int i2 = message.what;
        if ((i2 == 1 || i2 == 7 || ((i2 == 4 && !baseGmsClient.enableLocalFallback()) || message.what == 5)) && !baseGmsClient.isConnecting()) {
            zzc zzcVar2 = (zzc) message.obj;
            zzcVar2.zzc();
            zzcVar2.zzg();
            return;
        }
        int i3 = message.what;
        if (i3 == 4) {
            baseGmsClient.zzB = new ConnectionResult(message.arg2);
            if (BaseGmsClient.zzo(baseGmsClient) && !baseGmsClient.zzC) {
                baseGmsClient.zzp(3, null);
                return;
            }
            ConnectionResult connectionResult = baseGmsClient.zzB != null ? baseGmsClient.zzB : new ConnectionResult(8);
            baseGmsClient.zzc.onReportServiceBinding(connectionResult);
            baseGmsClient.onConnectionFailed(connectionResult);
            return;
        }
        if (i3 == 5) {
            ConnectionResult connectionResult2 = baseGmsClient.zzB != null ? baseGmsClient.zzB : new ConnectionResult(8);
            baseGmsClient.zzc.onReportServiceBinding(connectionResult2);
            baseGmsClient.onConnectionFailed(connectionResult2);
            return;
        }
        if (i3 == 3) {
            Object obj = message.obj;
            ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            baseGmsClient.zzc.onReportServiceBinding(connectionResult3);
            baseGmsClient.onConnectionFailed(connectionResult3);
            return;
        }
        if (i3 == 6) {
            baseGmsClient.zzp(5, null);
            if (baseGmsClient.zzw != null) {
                baseGmsClient.zzw.onConnectionSuspended(message.arg2);
            }
            baseGmsClient.onConnectionSuspended(message.arg2);
            BaseGmsClient.zzn(baseGmsClient, 5, 1, null);
            return;
        }
        if (i3 == 2 && !baseGmsClient.isConnected()) {
            zzc zzcVar3 = (zzc) message.obj;
            zzcVar3.zzc();
            zzcVar3.zzg();
            return;
        }
        int i4 = message.what;
        if (i4 == 2 || i4 == 1 || i4 == 7) {
            ((zzc) message.obj).zze();
        } else {
            Log.wtf("GmsClient", AbstractC1214oR1.a(i4, "Don't know how to handle message: "), new Exception());
        }
    }
}
