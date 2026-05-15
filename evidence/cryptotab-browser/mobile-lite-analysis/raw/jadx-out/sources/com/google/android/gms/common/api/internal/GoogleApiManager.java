package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import defpackage.C0136Ly2;
import defpackage.C0939k33;
import defpackage.C0978kf;
import defpackage.C1058lz2;
import defpackage.C1301pz2;
import defpackage.C1811yz2;
import defpackage.C1875zz2;
import defpackage.G62;
import defpackage.GA2;
import defpackage.H62;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@ShowFirstParty
@KeepForSdk
public class GoogleApiManager implements Handler.Callback {
    public static final Status zaa = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status zab = new Status(4, "The user must be signed in to make this API call.");
    private static final Object zac = new Object();
    private static GoogleApiManager zad;
    private TelemetryData zag;
    private TelemetryLoggingClient zah;
    private final Context zai;
    private final GoogleApiAvailability zaj;
    private final com.google.android.gms.common.internal.zal zak;
    private final Handler zar;
    private volatile boolean zas;
    private long zae = 10000;
    private boolean zaf = false;
    private final AtomicInteger zal = new AtomicInteger(1);
    private final AtomicInteger zam = new AtomicInteger(0);
    private final Map zan = new ConcurrentHashMap(5, 0.75f, 1);
    private zaae zao = null;
    private final Set zap = new C0978kf(0);
    private final Set zaq = new C0978kf(0);

    @KeepForSdk
    private GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.zas = true;
        this.zai = context;
        GA2 ga2 = new GA2(looper, this);
        this.zar = ga2;
        this.zaj = googleApiAvailability;
        this.zak = new com.google.android.gms.common.internal.zal(googleApiAvailability);
        if (DeviceProperties.isAuto(context)) {
            this.zas = false;
        }
        ga2.sendMessage(ga2.obtainMessage(6));
    }

    @KeepForSdk
    public static void reportSignOut() {
        synchronized (zac) {
            try {
                GoogleApiManager googleApiManager = zad;
                if (googleApiManager != null) {
                    googleApiManager.zam.incrementAndGet();
                    Handler handler = googleApiManager.zar;
                    handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status zaF(ApiKey apiKey, ConnectionResult connectionResult) {
        return new Status(connectionResult, "API: " + apiKey.zaa() + " is not available on this device. Connection failed with: " + String.valueOf(connectionResult));
    }

    @ResultIgnorabilityUnspecified
    private final zabq zaG(GoogleApi googleApi) {
        Map map = this.zan;
        ApiKey apiKey = googleApi.getApiKey();
        zabq zabqVar = (zabq) map.get(apiKey);
        if (zabqVar == null) {
            zabqVar = new zabq(this, googleApi);
            this.zan.put(apiKey, zabqVar);
        }
        if (zabqVar.zaA()) {
            this.zaq.add(apiKey);
        }
        zabqVar.zao();
        return zabqVar;
    }

    private final TelemetryLoggingClient zaH() {
        if (this.zah == null) {
            this.zah = TelemetryLogging.getClient(this.zai);
        }
        return this.zah;
    }

    private final void zaI() {
        TelemetryData telemetryData = this.zag;
        if (telemetryData != null) {
            if (telemetryData.zaa() > 0 || zaD()) {
                zaH().log(telemetryData);
            }
            this.zag = null;
        }
    }

    private final void zaJ(H62 h62, int i, GoogleApi googleApi) {
        C1811yz2 c1811yz2;
        boolean methodTimingTelemetryEnabled;
        if (i != 0) {
            ApiKey apiKey = googleApi.getApiKey();
            if (zaD()) {
                RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
                if (config != null) {
                    if (config.getMethodInvocationTelemetryEnabled()) {
                        methodTimingTelemetryEnabled = config.getMethodTimingTelemetryEnabled();
                        zabq zabqVarZai = zai(apiKey);
                        if (zabqVarZai != null) {
                            if (zabqVarZai.zaf() instanceof BaseGmsClient) {
                                BaseGmsClient baseGmsClient = (BaseGmsClient) zabqVarZai.zaf();
                                if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                                    ConnectionTelemetryConfiguration connectionTelemetryConfigurationA = C1811yz2.a(zabqVarZai, baseGmsClient, i);
                                    if (connectionTelemetryConfigurationA != null) {
                                        zabqVarZai.zaq();
                                        methodTimingTelemetryEnabled = connectionTelemetryConfigurationA.getMethodTimingTelemetryEnabled();
                                    }
                                }
                            }
                        }
                    }
                    c1811yz2 = null;
                } else {
                    methodTimingTelemetryEnabled = true;
                }
                c1811yz2 = new C1811yz2(this, i, apiKey, methodTimingTelemetryEnabled ? System.currentTimeMillis() : 0L, methodTimingTelemetryEnabled ? SystemClock.elapsedRealtime() : 0L);
            } else {
                c1811yz2 = null;
            }
            if (c1811yz2 != null) {
                C0939k33 c0939k33 = h62.a;
                final Handler handler = this.zar;
                handler.getClass();
                c0939k33.m(new Executor() { // from class: com.google.android.gms.common.api.internal.zabk
                    @Override // java.util.concurrent.Executor
                    public final void execute(Runnable runnable) {
                        handler.post(runnable);
                    }
                }, c1811yz2);
            }
        }
    }

    public static GoogleApiManager zaj() {
        GoogleApiManager googleApiManager;
        synchronized (zac) {
            Preconditions.checkNotNull(zad, "Must guarantee manager is non-null before using getInstance");
            googleApiManager = zad;
        }
        return googleApiManager;
    }

    @ResultIgnorabilityUnspecified
    public static GoogleApiManager zak(Context context) {
        GoogleApiManager googleApiManager;
        synchronized (zac) {
            try {
                if (zad == null) {
                    zad = new GoogleApiManager(context.getApplicationContext(), GmsClientSupervisor.getOrStartHandlerThread().getLooper(), GoogleApiAvailability.getInstance());
                }
                googleApiManager = zad;
            } catch (Throwable th) {
                throw th;
            }
        }
        return googleApiManager;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        zabq zabqVar = null;
        switch (i) {
            case 1:
                this.zae = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.zar.removeMessages(12);
                for (ApiKey apiKey : this.zan.keySet()) {
                    Handler handler = this.zar;
                    handler.sendMessageDelayed(handler.obtainMessage(12, apiKey), this.zae);
                }
                return true;
            case 2:
                zal zalVar = (zal) message.obj;
                Iterator it = zalVar.zab().iterator();
                while (true) {
                    if (it.hasNext()) {
                        ApiKey apiKey2 = (ApiKey) it.next();
                        zabq zabqVar2 = (zabq) this.zan.get(apiKey2);
                        if (zabqVar2 == null) {
                            zalVar.zac(apiKey2, new ConnectionResult(13), null);
                        } else if (zabqVar2.zaz()) {
                            zalVar.zac(apiKey2, ConnectionResult.RESULT_SUCCESS, zabqVar2.zaf().getEndpointPackageName());
                        } else {
                            ConnectionResult connectionResultZad = zabqVar2.zad();
                            if (connectionResultZad != null) {
                                zalVar.zac(apiKey2, connectionResultZad, null);
                            } else {
                                zabqVar2.zat(zalVar);
                                zabqVar2.zao();
                            }
                        }
                    }
                }
                return true;
            case 3:
                for (zabq zabqVar3 : this.zan.values()) {
                    zabqVar3.zan();
                    zabqVar3.zao();
                }
                return true;
            case 4:
            case 8:
            case 13:
                zach zachVar = (zach) message.obj;
                zabq zabqVarZaG = (zabq) this.zan.get(zachVar.zac.getApiKey());
                if (zabqVarZaG == null) {
                    zabqVarZaG = zaG(zachVar.zac);
                }
                if (!zabqVarZaG.zaA() || this.zam.get() == zachVar.zab) {
                    zabqVarZaG.zap(zachVar.zaa);
                } else {
                    zachVar.zaa.zad(zaa);
                    zabqVarZaG.zav();
                }
                return true;
            case 5:
                int i2 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator it2 = this.zan.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        zabq zabqVar4 = (zabq) it2.next();
                        if (zabqVar4.zab() == i2) {
                            zabqVar = zabqVar4;
                        }
                    }
                }
                if (zabqVar == null) {
                    Log.wtf("GoogleApiManager", "Could not find API instance " + i2 + " while trying to fail enqueued calls.", new Exception());
                } else if (connectionResult.getErrorCode() == 13) {
                    zabqVar.zaE(new Status(17, "Error resolution was canceled by the user, original error message: " + this.zaj.getErrorString(connectionResult.getErrorCode()) + ": " + connectionResult.getErrorMessage()));
                } else {
                    zabqVar.zaE(zaF(zabqVar.zad, connectionResult));
                }
                return true;
            case 6:
                if (this.zai.getApplicationContext() instanceof Application) {
                    BackgroundDetector.initialize((Application) this.zai.getApplicationContext());
                    BackgroundDetector.getInstance().addListener(new C1058lz2(this));
                    if (!BackgroundDetector.getInstance().readCurrentStateIfPossible(true)) {
                        this.zae = 300000L;
                    }
                }
                return true;
            case 7:
                zaG((GoogleApi) message.obj);
                return true;
            case ConnectionResult.SERVICE_INVALID /* 9 */:
                if (this.zan.containsKey(message.obj)) {
                    ((zabq) this.zan.get(message.obj)).zau();
                }
                return true;
            case 10:
                Iterator it3 = this.zaq.iterator();
                while (it3.hasNext()) {
                    zabq zabqVar5 = (zabq) this.zan.remove((ApiKey) it3.next());
                    if (zabqVar5 != null) {
                        zabqVar5.zav();
                    }
                }
                this.zaq.clear();
                return true;
            case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                if (this.zan.containsKey(message.obj)) {
                    ((zabq) this.zan.get(message.obj)).zaw();
                }
                return true;
            case 12:
                if (this.zan.containsKey(message.obj)) {
                    ((zabq) this.zan.get(message.obj)).zaB();
                }
                return true;
            case 14:
                C0136Ly2 c0136Ly2 = (C0136Ly2) message.obj;
                ApiKey apiKey3 = c0136Ly2.a;
                boolean zContainsKey = this.zan.containsKey(apiKey3);
                H62 h62 = c0136Ly2.b;
                if (zContainsKey) {
                    h62.b(Boolean.valueOf(((zabq) this.zan.get(apiKey3)).zaO(false)));
                } else {
                    h62.b(Boolean.FALSE);
                }
                return true;
            case 15:
                C1301pz2 c1301pz2 = (C1301pz2) message.obj;
                if (this.zan.containsKey(c1301pz2.a)) {
                    zabq.zal((zabq) this.zan.get(c1301pz2.a), c1301pz2);
                }
                return true;
            case 16:
                C1301pz2 c1301pz22 = (C1301pz2) message.obj;
                if (this.zan.containsKey(c1301pz22.a)) {
                    zabq.zam((zabq) this.zan.get(c1301pz22.a), c1301pz22);
                }
                return true;
            case 17:
                zaI();
                return true;
            case ConnectionResult.SERVICE_UPDATING /* 18 */:
                C1875zz2 c1875zz2 = (C1875zz2) message.obj;
                long j = c1875zz2.c;
                MethodInvocation methodInvocation = c1875zz2.a;
                int i3 = c1875zz2.b;
                if (j == 0) {
                    zaH().log(new TelemetryData(i3, Arrays.asList(methodInvocation)));
                } else {
                    TelemetryData telemetryData = this.zag;
                    if (telemetryData != null) {
                        List listZab = telemetryData.zab();
                        if (telemetryData.zaa() != i3 || (listZab != null && listZab.size() >= c1875zz2.d)) {
                            this.zar.removeMessages(17);
                            zaI();
                        } else {
                            this.zag.zac(methodInvocation);
                        }
                    }
                    if (this.zag == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(methodInvocation);
                        this.zag = new TelemetryData(i3, arrayList);
                        Handler handler2 = this.zar;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), c1875zz2.c);
                    }
                }
                return true;
            case 19:
                this.zaf = false;
                return true;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + i);
                return false;
        }
    }

    public final void zaA(zaae zaaeVar) {
        synchronized (zac) {
            try {
                if (this.zao != zaaeVar) {
                    this.zao = zaaeVar;
                    this.zap.clear();
                }
                this.zap.addAll(zaaeVar.zaa());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zaB(zaae zaaeVar) {
        synchronized (zac) {
            try {
                if (this.zao == zaaeVar) {
                    this.zao = null;
                    this.zap.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zaD() {
        if (this.zaf) {
            return false;
        }
        RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
        if (config != null && !config.getMethodInvocationTelemetryEnabled()) {
            return false;
        }
        int iZaa = this.zak.zaa(this.zai, 203400000);
        return iZaa == -1 || iZaa == 0;
    }

    @ResultIgnorabilityUnspecified
    public final boolean zaE(ConnectionResult connectionResult, int i) {
        return this.zaj.zah(this.zai, connectionResult, i);
    }

    public final int zaa() {
        return this.zal.getAndIncrement();
    }

    public final zabq zai(ApiKey apiKey) {
        return (zabq) this.zan.get(apiKey);
    }

    public final G62 zam(Iterable iterable) {
        zal zalVar = new zal(iterable);
        this.zar.sendMessage(this.zar.obtainMessage(2, zalVar));
        return zalVar.zaa();
    }

    @ResultIgnorabilityUnspecified
    public final G62 zan(GoogleApi googleApi) {
        C0136Ly2 c0136Ly2 = new C0136Ly2(googleApi.getApiKey());
        this.zar.sendMessage(this.zar.obtainMessage(14, c0136Ly2));
        return c0136Ly2.b.a;
    }

    public final G62 zao(GoogleApi googleApi, RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod, Runnable runnable) {
        H62 h62 = new H62();
        zaJ(h62, registerListenerMethod.zaa(), googleApi);
        this.zar.sendMessage(this.zar.obtainMessage(8, new zach(new zaf(new zaci(registerListenerMethod, unregisterListenerMethod, runnable), h62), this.zam.get(), googleApi)));
        return h62.a;
    }

    public final G62 zap(GoogleApi googleApi, ListenerHolder.ListenerKey listenerKey, int i) {
        H62 h62 = new H62();
        zaJ(h62, i, googleApi);
        this.zar.sendMessage(this.zar.obtainMessage(13, new zach(new zah(listenerKey, h62), this.zam.get(), googleApi)));
        return h62.a;
    }

    public final void zau(GoogleApi googleApi, int i, BaseImplementation.ApiMethodImpl apiMethodImpl) {
        this.zar.sendMessage(this.zar.obtainMessage(4, new zach(new zae(i, apiMethodImpl), this.zam.get(), googleApi)));
    }

    public final void zav(GoogleApi googleApi, int i, TaskApiCall taskApiCall, H62 h62, StatusExceptionMapper statusExceptionMapper) {
        zaJ(h62, taskApiCall.zaa(), googleApi);
        this.zar.sendMessage(this.zar.obtainMessage(4, new zach(new zag(i, taskApiCall, h62, statusExceptionMapper), this.zam.get(), googleApi)));
    }

    public final void zaw(MethodInvocation methodInvocation, int i, long j, int i2) {
        this.zar.sendMessage(this.zar.obtainMessage(18, new C1875zz2(methodInvocation, i, j, i2)));
    }

    public final void zax(ConnectionResult connectionResult, int i) {
        if (zaE(connectionResult, i)) {
            return;
        }
        Handler handler = this.zar;
        handler.sendMessage(handler.obtainMessage(5, i, 0, connectionResult));
    }

    public final void zay() {
        Handler handler = this.zar;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void zaz(GoogleApi googleApi) {
        Handler handler = this.zar;
        handler.sendMessage(handler.obtainMessage(7, googleApi));
    }
}
