package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Api {
    private final AbstractClientBuilder zaa;
    private final ClientKey zab;
    private final String zac;

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @KeepForSdk
    public abstract class AbstractClientBuilder extends BaseClientBuilder {
        @KeepForSdk
        @Deprecated
        public Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return buildClient(context, looper, clientSettings, obj, (ConnectionCallbacks) connectionCallbacks, (OnConnectionFailedListener) onConnectionFailedListener);
        }

        @KeepForSdk
        public Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @KeepForSdk
    public interface AnyClient {
    }

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @KeepForSdk
    public class AnyClientKey {
    }

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public interface ApiOptions {
        public static final NoOptions NO_OPTIONS = new NoOptions(null);

        /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
        public interface HasAccountOptions extends HasOptions, NotRequiredOptions {
            Account getAccount();
        }

        /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
        public interface HasGoogleSignInAccountOptions extends HasOptions {
            GoogleSignInAccount getGoogleSignInAccount();
        }

        /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
        public interface HasOptions extends ApiOptions {
        }

        /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
        public final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }

            public /* synthetic */ NoOptions(zaa zaaVar) {
            }
        }

        /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
        public interface NotRequiredOptions extends ApiOptions {
        }

        /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @KeepForSdk
    public abstract class BaseClientBuilder {

        @KeepForSdk
        public static final int API_PRIORITY_GAMES = 1;

        @KeepForSdk
        public static final int API_PRIORITY_OTHER = Integer.MAX_VALUE;

        @KeepForSdk
        public static final int API_PRIORITY_PLUS = 2;

        @KeepForSdk
        public List getImpliedScopes(Object obj) {
            return Collections.emptyList();
        }

        @KeepForSdk
        public int getPriority() {
            return API_PRIORITY_OTHER;
        }
    }

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @KeepForSdk
    public interface Client extends AnyClient {
        @KeepForSdk
        void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks);

        @KeepForSdk
        void disconnect();

        @KeepForSdk
        void disconnect(String str);

        @KeepForSdk
        void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        @KeepForSdk
        Feature[] getAvailableFeatures();

        @KeepForSdk
        String getEndpointPackageName();

        @KeepForSdk
        String getLastDisconnectMessage();

        @KeepForSdk
        int getMinApkVersion();

        @KeepForSdk
        void getRemoteService(IAccountAccessor iAccountAccessor, Set set);

        @KeepForSdk
        Feature[] getRequiredFeatures();

        @KeepForSdk
        Set getScopesForConnectionlessNonSignIn();

        @KeepForSdk
        IBinder getServiceBrokerBinder();

        @KeepForSdk
        Intent getSignInIntent();

        @KeepForSdk
        boolean isConnected();

        @KeepForSdk
        boolean isConnecting();

        @KeepForSdk
        void onUserSignOut(BaseGmsClient.SignOutCallbacks signOutCallbacks);

        @KeepForSdk
        boolean providesSignIn();

        @KeepForSdk
        boolean requiresAccount();

        @KeepForSdk
        boolean requiresGooglePlayServices();

        @KeepForSdk
        boolean requiresSignIn();
    }

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @KeepForSdk
    public final class ClientKey extends AnyClientKey {
    }

    @KeepForSdk
    public Api(String str, AbstractClientBuilder abstractClientBuilder, ClientKey clientKey) {
        Preconditions.checkNotNull(abstractClientBuilder, "Cannot construct an Api with a null ClientBuilder");
        Preconditions.checkNotNull(clientKey, "Cannot construct an Api with a null ClientKey");
        this.zac = str;
        this.zaa = abstractClientBuilder;
        this.zab = clientKey;
    }

    public final AbstractClientBuilder zaa() {
        return this.zaa;
    }

    public final AnyClientKey zab() {
        return this.zab;
    }

    public final BaseClientBuilder zac() {
        return this.zaa;
    }

    public final String zad() {
        return this.zac;
    }
}
