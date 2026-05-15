package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import defpackage.C0063Ez2;
import defpackage.H62;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public abstract class TaskApiCall {
    private final Feature[] zaa;
    private final boolean zab;
    private final int zac;

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @KeepForSdk
    public class Builder {
        private RemoteCall zaa;
        private Feature[] zac;
        private boolean zab = true;
        private int zad = 0;

        private Builder() {
        }

        @KeepForSdk
        public TaskApiCall build() {
            Preconditions.checkArgument(this.zaa != null, "execute parameter required");
            return new C0063Ez2(this, this.zac, this.zab, this.zad);
        }

        @KeepForSdk
        @Deprecated
        public Builder execute(final BiConsumer biConsumer) {
            this.zaa = new RemoteCall() { // from class: com.google.android.gms.common.api.internal.zacu
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final void accept(Object obj, Object obj2) {
                    biConsumer.accept((Api.AnyClient) obj, (H62) obj2);
                }
            };
            return this;
        }

        @KeepForSdk
        public Builder run(RemoteCall remoteCall) {
            this.zaa = remoteCall;
            return this;
        }

        @KeepForSdk
        public Builder setAutoResolveMissingFeatures(boolean z) {
            this.zab = z;
            return this;
        }

        @KeepForSdk
        public Builder setFeatures(Feature... featureArr) {
            this.zac = featureArr;
            return this;
        }

        @KeepForSdk
        public Builder setMethodKey(int i) {
            this.zad = i;
            return this;
        }

        public /* synthetic */ Builder(zacw zacwVar) {
        }
    }

    @KeepForSdk
    @Deprecated
    public TaskApiCall() {
        this.zaa = null;
        this.zab = false;
        this.zac = 0;
    }

    @KeepForSdk
    public static Builder builder() {
        return new Builder(null);
    }

    @KeepForSdk
    public abstract void doExecute(Api.AnyClient anyClient, H62 h62);

    @KeepForSdk
    public boolean shouldAutoResolveMissingFeatures() {
        return this.zab;
    }

    public final int zaa() {
        return this.zac;
    }

    public final Feature[] zab() {
        return this.zaa;
    }

    @KeepForSdk
    public TaskApiCall(Feature[] featureArr, boolean z, int i) {
        this.zaa = featureArr;
        boolean z2 = false;
        if (featureArr != null && z) {
            z2 = true;
        }
        this.zab = z2;
        this.zac = i;
    }
}
