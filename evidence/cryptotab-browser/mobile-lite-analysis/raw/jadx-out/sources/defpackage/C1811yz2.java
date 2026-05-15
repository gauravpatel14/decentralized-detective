package defpackage;

import android.os.SystemClock;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.util.ArrayUtils;

/* JADX INFO: renamed from: yz2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1811yz2 implements N41 {
    public final GoogleApiManager a;
    public final int b;
    public final ApiKey c;
    public final long d;
    public final long e;

    public C1811yz2(GoogleApiManager googleApiManager, int i, ApiKey apiKey, long j, long j2) {
        this.a = googleApiManager;
        this.b = i;
        this.c = apiKey;
        this.d = j;
        this.e = j2;
    }

    public static ConnectionTelemetryConfiguration a(zabq zabqVar, BaseGmsClient baseGmsClient, int i) {
        int[] methodInvocationMethodKeyAllowlist;
        int[] methodInvocationMethodKeyDisallowlist;
        ConnectionTelemetryConfiguration telemetryConfiguration = baseGmsClient.getTelemetryConfiguration();
        if (telemetryConfiguration == null || !telemetryConfiguration.getMethodInvocationTelemetryEnabled() || ((methodInvocationMethodKeyAllowlist = telemetryConfiguration.getMethodInvocationMethodKeyAllowlist()) != null ? !ArrayUtils.contains(methodInvocationMethodKeyAllowlist, i) : !((methodInvocationMethodKeyDisallowlist = telemetryConfiguration.getMethodInvocationMethodKeyDisallowlist()) == null || !ArrayUtils.contains(methodInvocationMethodKeyDisallowlist, i))) || zabqVar.zac() >= telemetryConfiguration.getMaxMethodInvocationsLogged()) {
            return null;
        }
        return telemetryConfiguration;
    }

    @Override // defpackage.N41
    public final void onComplete(G62 g62) {
        zabq zabqVarZai;
        int version;
        int i;
        int i2;
        int errorCode;
        long j;
        long j2;
        int iElapsedRealtime;
        if (this.a.zaD()) {
            RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
            if ((config == null || config.getMethodInvocationTelemetryEnabled()) && (zabqVarZai = this.a.zai(this.c)) != null && (zabqVarZai.zaf() instanceof BaseGmsClient)) {
                BaseGmsClient baseGmsClient = (BaseGmsClient) zabqVarZai.zaf();
                int i3 = 0;
                boolean methodTimingTelemetryEnabled = this.d > 0;
                int gCoreServiceId = baseGmsClient.getGCoreServiceId();
                int statusCode = 100;
                if (config != null) {
                    methodTimingTelemetryEnabled &= config.getMethodTimingTelemetryEnabled();
                    int batchPeriodMillis = config.getBatchPeriodMillis();
                    int maxMethodInvocationsInBatch = config.getMaxMethodInvocationsInBatch();
                    version = config.getVersion();
                    if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                        ConnectionTelemetryConfiguration connectionTelemetryConfigurationA = a(zabqVarZai, baseGmsClient, this.b);
                        if (connectionTelemetryConfigurationA == null) {
                            return;
                        }
                        boolean z = connectionTelemetryConfigurationA.getMethodTimingTelemetryEnabled() && this.d > 0;
                        maxMethodInvocationsInBatch = connectionTelemetryConfigurationA.getMaxMethodInvocationsLogged();
                        methodTimingTelemetryEnabled = z;
                    }
                    i2 = batchPeriodMillis;
                    i = maxMethodInvocationsInBatch;
                } else {
                    version = 0;
                    i = 100;
                    i2 = 5000;
                }
                GoogleApiManager googleApiManager = this.a;
                if (g62.k()) {
                    errorCode = 0;
                } else if (((C0939k33) g62).d) {
                    i3 = statusCode;
                    errorCode = -1;
                } else {
                    Exception excG = g62.g();
                    if (excG instanceof ApiException) {
                        Status status = ((ApiException) excG).getStatus();
                        statusCode = status.getStatusCode();
                        ConnectionResult connectionResult = status.getConnectionResult();
                        if (connectionResult != null) {
                            errorCode = connectionResult.getErrorCode();
                            i3 = statusCode;
                        }
                        i3 = statusCode;
                        errorCode = -1;
                    } else {
                        i3 = 101;
                        errorCode = -1;
                    }
                }
                if (methodTimingTelemetryEnabled) {
                    long j3 = this.d;
                    long j4 = this.e;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - j4);
                    j2 = jCurrentTimeMillis;
                    j = j3;
                } else {
                    j = 0;
                    j2 = 0;
                    iElapsedRealtime = -1;
                }
                googleApiManager.zaw(new MethodInvocation(this.b, i3, errorCode, j, j2, null, null, gCoreServiceId, iElapsedRealtime), version, i2, i);
            }
        }
    }
}
