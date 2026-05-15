package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import defpackage.C0011Az2;
import defpackage.C0027Bz2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public class RegistrationMethods {

    @KeepForSdk
    public final RegisterListenerMethod register;
    public final UnregisterListenerMethod zaa;
    public final Runnable zab;

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @KeepForSdk
    public class Builder {
        private RemoteCall zaa;
        private RemoteCall zab;
        private ListenerHolder zad;
        private Feature[] zae;
        private int zag;
        private Runnable zac = zacj.zaa;
        private boolean zaf = true;

        private Builder() {
        }

        @KeepForSdk
        public RegistrationMethods build() {
            Preconditions.checkArgument(this.zaa != null, "Must set register function");
            Preconditions.checkArgument(this.zab != null, "Must set unregister function");
            Preconditions.checkArgument(this.zad != null, "Must set holder");
            return new RegistrationMethods(new C0011Az2(this, this.zad, this.zae, this.zaf, this.zag), new C0027Bz2(this, (ListenerHolder.ListenerKey) Preconditions.checkNotNull(this.zad.getListenerKey(), "Key must not be null")), this.zac, null);
        }

        @KeepForSdk
        public Builder onConnectionSuspended(Runnable runnable) {
            this.zac = runnable;
            return this;
        }

        @KeepForSdk
        public Builder register(RemoteCall remoteCall) {
            this.zaa = remoteCall;
            return this;
        }

        @KeepForSdk
        public Builder setAutoResolveMissingFeatures(boolean z) {
            this.zaf = z;
            return this;
        }

        @KeepForSdk
        public Builder setFeatures(Feature... featureArr) {
            this.zae = featureArr;
            return this;
        }

        @KeepForSdk
        public Builder setMethodKey(int i) {
            this.zag = i;
            return this;
        }

        @KeepForSdk
        public Builder unregister(RemoteCall remoteCall) {
            this.zab = remoteCall;
            return this;
        }

        @KeepForSdk
        public Builder withHolder(ListenerHolder listenerHolder) {
            this.zad = listenerHolder;
            return this;
        }

        public /* synthetic */ Builder(zacm zacmVar) {
        }
    }

    public /* synthetic */ RegistrationMethods(RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod, Runnable runnable, zacn zacnVar) {
        this.register = registerListenerMethod;
        this.zaa = unregisterListenerMethod;
        this.zab = runnable;
    }

    @KeepForSdk
    public static Builder builder() {
        return new Builder(null);
    }
}
