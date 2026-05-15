package defpackage;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.signin.internal.zai;
import com.google.android.gms.signin.internal.zak;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class DI1 extends GmsClient implements InterfaceC0254Uz2 {
    public static final /* synthetic */ int x = 0;
    public final boolean t;
    public final ClientSettings u;
    public final Bundle v;
    public final Integer w;

    public DI1(Context context, Looper looper, ClientSettings clientSettings, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.t = true;
        this.u = clientSettings;
        this.v = bundle;
        this.w = clientSettings.zab();
    }

    @Override // defpackage.InterfaceC0254Uz2
    public final void a(IAccountAccessor iAccountAccessor, boolean z) {
        try {
            C0333aA2 c0333aA2 = (C0333aA2) getService();
            int iIntValue = ((Integer) Preconditions.checkNotNull(this.w)).intValue();
            Parcel parcelZaa = c0333aA2.zaa();
            AbstractC1646vz2.d(parcelZaa, iAccountAccessor);
            parcelZaa.writeInt(iIntValue);
            parcelZaa.writeInt(z ? 1 : 0);
            c0333aA2.zac(9, parcelZaa);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    @Override // defpackage.InterfaceC0254Uz2
    public final void b(AbstractBinderC1705wz2 abstractBinderC1705wz2) {
        Preconditions.checkNotNull(abstractBinderC1705wz2, "Expecting a valid ISignInCallbacks");
        try {
            Account accountOrDefault = this.u.getAccountOrDefault();
            zat zatVar = new zat(accountOrDefault, ((Integer) Preconditions.checkNotNull(this.w)).intValue(), "<<default account>>".equals(accountOrDefault.name) ? C1616vP1.a(getContext()).b() : null);
            C0333aA2 c0333aA2 = (C0333aA2) getService();
            zai zaiVar = new zai(1, zatVar);
            Parcel parcelZaa = c0333aA2.zaa();
            AbstractC1646vz2.c(parcelZaa, zaiVar);
            AbstractC1646vz2.d(parcelZaa, abstractBinderC1705wz2);
            c0333aA2.zac(12, parcelZaa);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                abstractBinderC1705wz2.zab(new zak(1, new ConnectionResult(8, null), null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof C0333aA2 ? (C0333aA2) iInterfaceQueryLocalInterface : new C0333aA2(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        ClientSettings clientSettings = this.u;
        boolean zEquals = getContext().getPackageName().equals(clientSettings.getRealClientPackageName());
        Bundle bundle = this.v;
        if (!zEquals) {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", clientSettings.getRealClientPackageName());
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresSignIn() {
        return this.t;
    }

    @Override // defpackage.InterfaceC0254Uz2
    public final void zaa() {
        try {
            C0333aA2 c0333aA2 = (C0333aA2) getService();
            int iIntValue = ((Integer) Preconditions.checkNotNull(this.w)).intValue();
            Parcel parcelZaa = c0333aA2.zaa();
            parcelZaa.writeInt(iIntValue);
            c0333aA2.zac(7, parcelZaa);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    @Override // defpackage.InterfaceC0254Uz2
    public final void zab() {
        connect(new BaseGmsClient.LegacyClientCallbackAdapter());
    }
}
