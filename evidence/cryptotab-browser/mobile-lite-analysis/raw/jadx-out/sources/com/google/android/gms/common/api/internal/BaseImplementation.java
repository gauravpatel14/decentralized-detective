package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public class BaseImplementation {

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @KeepForSdk
    public interface ResultHolder {
        @KeepForSdk
        void setFailedResult(Status status);

        @KeepForSdk
        void setResult(Object obj);
    }

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @KeepForSdk
    public abstract class ApiMethodImpl extends BasePendingResult implements ResultHolder {

        @KeepForSdk
        private final Api api;

        @KeepForSdk
        private final Api.AnyClientKey clientKey;

        @KeepForSdk
        @Deprecated
        public ApiMethodImpl(Api.AnyClientKey anyClientKey, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) Preconditions.checkNotNull(googleApiClient, "GoogleApiClient must not be null"));
            this.clientKey = (Api.AnyClientKey) Preconditions.checkNotNull(anyClientKey);
            this.api = null;
        }

        @KeepForSdk
        private void setFailedResult(RemoteException remoteException) {
            setFailedResult(new Status(8, remoteException.getLocalizedMessage(), (PendingIntent) null));
        }

        @KeepForSdk
        public abstract void doExecute(Api.AnyClient anyClient);

        @KeepForSdk
        public final Api getApi() {
            return this.api;
        }

        @KeepForSdk
        public final Api.AnyClientKey getClientKey() {
            return this.clientKey;
        }

        @KeepForSdk
        public final void run(Api.AnyClient anyClient) throws DeadObjectException {
            try {
                doExecute(anyClient);
            } catch (DeadObjectException e) {
                setFailedResult(e);
                throw e;
            } catch (RemoteException e2) {
                setFailedResult(e2);
            }
        }

        @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
        @KeepForSdk
        public /* bridge */ /* synthetic */ void setResult(Object obj) {
            setResult((Result) obj);
        }

        @KeepForSdk
        public ApiMethodImpl(Api api, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) Preconditions.checkNotNull(googleApiClient, "GoogleApiClient must not be null"));
            Preconditions.checkNotNull(api, "Api must not be null");
            this.clientKey = api.zab();
            this.api = api;
        }

        @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
        @KeepForSdk
        public final void setFailedResult(Status status) {
            Preconditions.checkArgument(!status.isSuccess(), "Failed result must not be success");
            Result resultCreateFailedResult = createFailedResult(status);
            setResult(resultCreateFailedResult);
            onSetFailedResult(resultCreateFailedResult);
        }

        @KeepForSdk
        public ApiMethodImpl(BasePendingResult.CallbackHandler callbackHandler) {
            super(callbackHandler);
            this.clientKey = new Api.AnyClientKey();
            this.api = null;
        }

        @KeepForSdk
        public void onSetFailedResult(Result result) {
        }
    }
}
