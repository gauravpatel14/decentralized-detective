package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zav;
import defpackage.AbstractBinderC1705wz2;
import defpackage.AbstractC0169Nz2;
import defpackage.InterfaceC0254Uz2;
import defpackage.RunnableC0038Cz2;
import defpackage.RunnableC0053Dz2;
import java.util.Set;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class zact extends AbstractBinderC1705wz2 implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static final Api.AbstractClientBuilder zaa = AbstractC0169Nz2.a;
    private final Context zab;
    private final Handler zac;
    private final Api.AbstractClientBuilder zad;
    private final Set zae;
    private final ClientSettings zaf;
    private InterfaceC0254Uz2 zag;
    private zacs zah;

    public zact(Context context, Handler handler, ClientSettings clientSettings) {
        Api.AbstractClientBuilder abstractClientBuilder = zaa;
        this.zab = context;
        this.zac = handler;
        this.zaf = (ClientSettings) Preconditions.checkNotNull(clientSettings, "ClientSettings must not be null");
        this.zae = clientSettings.getRequiredScopes();
        this.zad = abstractClientBuilder;
    }

    public static void zad(zact zactVar, com.google.android.gms.signin.internal.zak zakVar) {
        ConnectionResult connectionResult = zakVar.u;
        if (connectionResult.isSuccess()) {
            zav zavVar = (zav) Preconditions.checkNotNull(zakVar.v);
            ConnectionResult connectionResultZaa = zavVar.zaa();
            if (!connectionResultZaa.isSuccess()) {
                String strValueOf = String.valueOf(connectionResultZaa);
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(strValueOf), new Exception());
                zactVar.zah.zae(connectionResultZaa);
                zactVar.zag.disconnect();
                return;
            }
            zactVar.zah.zaf(zavVar.zab(), zactVar.zae);
        } else {
            zactVar.zah.zae(connectionResult);
        }
        zactVar.zag.disconnect();
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.zag.b(this);
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zah.zae(connectionResult);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        this.zah.zag(i);
    }

    @Override // defpackage.InterfaceC0266Vz2
    public final void zab(com.google.android.gms.signin.internal.zak zakVar) {
        this.zac.post(new RunnableC0053Dz2(this, zakVar));
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [Uz2, com.google.android.gms.common.api.Api$Client] */
    public final void zae(zacs zacsVar) {
        InterfaceC0254Uz2 interfaceC0254Uz2 = this.zag;
        if (interfaceC0254Uz2 != null) {
            interfaceC0254Uz2.disconnect();
        }
        this.zaf.zae(Integer.valueOf(System.identityHashCode(this)));
        Api.AbstractClientBuilder abstractClientBuilder = this.zad;
        Context context = this.zab;
        Handler handler = this.zac;
        ClientSettings clientSettings = this.zaf;
        this.zag = abstractClientBuilder.buildClient(context, handler.getLooper(), clientSettings, (Object) clientSettings.zaa(), (GoogleApiClient.ConnectionCallbacks) this, (GoogleApiClient.OnConnectionFailedListener) this);
        this.zah = zacsVar;
        Set set = this.zae;
        if (set == null || set.isEmpty()) {
            this.zac.post(new RunnableC0038Cz2(this));
        } else {
            this.zag.zab();
        }
    }

    public final void zaf() {
        InterfaceC0254Uz2 interfaceC0254Uz2 = this.zag;
        if (interfaceC0254Uz2 != null) {
            interfaceC0254Uz2.disconnect();
        }
    }
}
