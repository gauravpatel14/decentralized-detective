package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.NonGmsServiceBrokerClient;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zaae;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zabv;
import com.google.android.gms.common.api.internal.zact;
import com.google.android.gms.common.internal.AccountType;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import defpackage.G62;
import defpackage.H62;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class GoogleApi implements HasApiKey {
    protected final GoogleApiManager zaa;
    private final Context zab;
    private final String zac;
    private final Api zad;
    private final Api.ApiOptions zae;
    private final ApiKey zaf;
    private final Looper zag;
    private final int zah;
    private final GoogleApiClient zai;
    private final StatusExceptionMapper zaj;

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @KeepForSdk
    public class Settings {

        @KeepForSdk
        public static final Settings DEFAULT_SETTINGS = new Builder().build();
        public final StatusExceptionMapper zaa;
        public final Looper zab;

        /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
        @KeepForSdk
        public class Builder {
            private StatusExceptionMapper zaa;
            private Looper zab;

            @KeepForSdk
            public Builder() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @KeepForSdk
            public Settings build() {
                if (this.zaa == null) {
                    this.zaa = new ApiExceptionMapper();
                }
                if (this.zab == null) {
                    this.zab = Looper.getMainLooper();
                }
                return new Settings(this.zaa, this.zab);
            }

            @KeepForSdk
            public Builder setLooper(Looper looper) {
                Preconditions.checkNotNull(looper, "Looper must not be null.");
                this.zab = looper;
                return this;
            }

            @KeepForSdk
            public Builder setMapper(StatusExceptionMapper statusExceptionMapper) {
                Preconditions.checkNotNull(statusExceptionMapper, "StatusExceptionMapper must not be null.");
                this.zaa = statusExceptionMapper;
                return this;
            }
        }

        @KeepForSdk
        private Settings(StatusExceptionMapper statusExceptionMapper, Account account, Looper looper) {
            this.zaa = statusExceptionMapper;
            this.zab = looper;
        }
    }

    @KeepForSdk
    public GoogleApi(Activity activity, Api api, Api.ApiOptions apiOptions, Settings settings) {
        this(activity, activity, api, apiOptions, settings);
    }

    private final BaseImplementation.ApiMethodImpl zad(int i, BaseImplementation.ApiMethodImpl apiMethodImpl) {
        apiMethodImpl.zak();
        this.zaa.zau(this, i, apiMethodImpl);
        return apiMethodImpl;
    }

    private final G62 zae(int i, TaskApiCall taskApiCall) {
        H62 h62 = new H62();
        this.zaa.zav(this, i, taskApiCall, h62, this.zaj);
        return h62.a;
    }

    @KeepForSdk
    public GoogleApiClient asGoogleApiClient() {
        return this.zai;
    }

    @KeepForSdk
    public ClientSettings.Builder createClientSettingsBuilder() {
        GoogleSignInAccount googleSignInAccount;
        GoogleSignInAccount googleSignInAccount2;
        ClientSettings.Builder builder = new ClientSettings.Builder();
        Api.ApiOptions apiOptions = this.zae;
        Account account = null;
        if (!(apiOptions instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccount2 = ((Api.ApiOptions.HasGoogleSignInAccountOptions) apiOptions).getGoogleSignInAccount()) == null) {
            Api.ApiOptions apiOptions2 = this.zae;
            if (apiOptions2 instanceof Api.ApiOptions.HasAccountOptions) {
                account = ((Api.ApiOptions.HasAccountOptions) apiOptions2).getAccount();
            }
        } else {
            String str = googleSignInAccount2.w;
            if (str != null) {
                account = new Account(str, AccountType.GOOGLE);
            }
        }
        builder.zab(account);
        Api.ApiOptions apiOptions3 = this.zae;
        Collection collectionEmptySet = (!(apiOptions3 instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccount = ((Api.ApiOptions.HasGoogleSignInAccountOptions) apiOptions3).getGoogleSignInAccount()) == null) ? Collections.emptySet() : googleSignInAccount.f2();
        builder.zaa(collectionEmptySet);
        builder.zac(this.zab.getClass().getName());
        builder.setRealClientPackageName(this.zab.getPackageName());
        return builder;
    }

    @KeepForSdk
    public G62 disconnectService() {
        return this.zaa.zan(this);
    }

    @KeepForSdk
    public BaseImplementation.ApiMethodImpl doBestEffortWrite(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zad(2, apiMethodImpl);
        return apiMethodImpl;
    }

    @KeepForSdk
    public BaseImplementation.ApiMethodImpl doRead(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zad(0, apiMethodImpl);
        return apiMethodImpl;
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    @Deprecated
    public G62 doRegisterEventListener(RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod) {
        Preconditions.checkNotNull(registerListenerMethod);
        Preconditions.checkNotNull(unregisterListenerMethod);
        Preconditions.checkNotNull(registerListenerMethod.getListenerKey(), "Listener has already been released.");
        Preconditions.checkNotNull(unregisterListenerMethod.getListenerKey(), "Listener has already been released.");
        Preconditions.checkArgument(Objects.equal(registerListenerMethod.getListenerKey(), unregisterListenerMethod.getListenerKey()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.zaa.zao(this, registerListenerMethod, unregisterListenerMethod, new Runnable() { // from class: com.google.android.gms.common.api.zad
            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public G62 doUnregisterEventListener(ListenerHolder.ListenerKey listenerKey) {
        return doUnregisterEventListener(listenerKey, 0);
    }

    @KeepForSdk
    public BaseImplementation.ApiMethodImpl doWrite(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zad(1, apiMethodImpl);
        return apiMethodImpl;
    }

    public String getApiFallbackAttributionTag(Context context) {
        return null;
    }

    @Override // com.google.android.gms.common.api.HasApiKey
    public final ApiKey getApiKey() {
        return this.zaf;
    }

    @KeepForSdk
    public Api.ApiOptions getApiOptions() {
        return this.zae;
    }

    @KeepForSdk
    public Context getApplicationContext() {
        return this.zab;
    }

    @KeepForSdk
    public String getContextAttributionTag() {
        return this.zac;
    }

    @KeepForSdk
    @Deprecated
    public String getContextFeatureId() {
        return this.zac;
    }

    @KeepForSdk
    public Looper getLooper() {
        return this.zag;
    }

    @KeepForSdk
    public ListenerHolder registerListener(Object obj, String str) {
        return ListenerHolders.createListenerHolder(obj, this.zag, str);
    }

    public final int zaa() {
        return this.zah;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Api.Client zab(Looper looper, zabq zabqVar) {
        ClientSettings clientSettingsBuild = createClientSettingsBuilder().build();
        Api.Client clientBuildClient = ((Api.AbstractClientBuilder) Preconditions.checkNotNull(this.zad.zaa())).buildClient(this.zab, looper, clientSettingsBuild, (Object) this.zae, (GoogleApiClient.ConnectionCallbacks) zabqVar, (GoogleApiClient.OnConnectionFailedListener) zabqVar);
        String contextAttributionTag = getContextAttributionTag();
        if (contextAttributionTag != null && (clientBuildClient instanceof BaseGmsClient)) {
            ((BaseGmsClient) clientBuildClient).setAttributionTag(contextAttributionTag);
        }
        if (contextAttributionTag != null && (clientBuildClient instanceof NonGmsServiceBrokerClient)) {
            ((NonGmsServiceBrokerClient) clientBuildClient).zac(contextAttributionTag);
        }
        return clientBuildClient;
    }

    public final zact zac(Context context, Handler handler) {
        return new zact(context, handler, createClientSettingsBuilder().build());
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(Activity activity, Api api, Api.ApiOptions apiOptions, StatusExceptionMapper statusExceptionMapper) {
        Settings.Builder builder = new Settings.Builder();
        builder.setMapper(statusExceptionMapper);
        builder.setLooper(activity.getMainLooper());
        this(activity, api, apiOptions, builder.build());
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public G62 doBestEffortWrite(TaskApiCall taskApiCall) {
        return zae(2, taskApiCall);
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public G62 doRead(TaskApiCall taskApiCall) {
        return zae(0, taskApiCall);
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public G62 doUnregisterEventListener(ListenerHolder.ListenerKey listenerKey, int i) {
        Preconditions.checkNotNull(listenerKey, "Listener key cannot be null.");
        return this.zaa.zap(this, listenerKey, i);
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public G62 doWrite(TaskApiCall taskApiCall) {
        return zae(1, taskApiCall);
    }

    private GoogleApi(Context context, Activity activity, Api api, Api.ApiOptions apiOptions, Settings settings) {
        String apiFallbackAttributionTag;
        Preconditions.checkNotNull(context, "Null context is not permitted.");
        Preconditions.checkNotNull(api, "Api must not be null.");
        Preconditions.checkNotNull(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context context2 = (Context) Preconditions.checkNotNull(context.getApplicationContext(), "The provided context did not have an application context.");
        this.zab = context2;
        if (Build.VERSION.SDK_INT >= 30) {
            apiFallbackAttributionTag = context.getAttributionTag();
        } else {
            apiFallbackAttributionTag = getApiFallbackAttributionTag(context);
        }
        this.zac = apiFallbackAttributionTag;
        this.zad = api;
        this.zae = apiOptions;
        this.zag = settings.zab;
        ApiKey sharedApiKey = ApiKey.getSharedApiKey(api, apiOptions, apiFallbackAttributionTag);
        this.zaf = sharedApiKey;
        this.zai = new zabv(this);
        GoogleApiManager googleApiManagerZak = GoogleApiManager.zak(context2);
        this.zaa = googleApiManagerZak;
        this.zah = googleApiManagerZak.zaa();
        this.zaj = settings.zaa;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            zaae.zad(activity, googleApiManagerZak, sharedApiKey);
        }
        googleApiManagerZak.zaz(this);
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public G62 doRegisterEventListener(RegistrationMethods registrationMethods) {
        Preconditions.checkNotNull(registrationMethods);
        Preconditions.checkNotNull(registrationMethods.register.getListenerKey(), "Listener has already been released.");
        Preconditions.checkNotNull(registrationMethods.zaa.getListenerKey(), "Listener has already been released.");
        return this.zaa.zao(this, registrationMethods.register, registrationMethods.zaa, registrationMethods.zab);
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(Context context, Api api, Api.ApiOptions apiOptions, Looper looper, StatusExceptionMapper statusExceptionMapper) {
        Settings.Builder builder = new Settings.Builder();
        builder.setLooper(looper);
        builder.setMapper(statusExceptionMapper);
        this(context, api, apiOptions, builder.build());
    }

    @KeepForSdk
    public GoogleApi(Context context, Api api, Api.ApiOptions apiOptions, Settings settings) {
        this(context, (Activity) null, api, apiOptions, settings);
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(Context context, Api api, Api.ApiOptions apiOptions, StatusExceptionMapper statusExceptionMapper) {
        Settings.Builder builder = new Settings.Builder();
        builder.setMapper(statusExceptionMapper);
        this(context, api, apiOptions, builder.build());
    }
}
