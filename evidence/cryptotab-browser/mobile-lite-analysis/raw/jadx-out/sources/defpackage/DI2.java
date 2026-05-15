package defpackage;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.internal.measurement.zzcl;
import java.util.Map;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public interface DI2 extends IInterface {
    void beginAdUnitExposure(String str, long j);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    void clearMeasurementEnabled(long j);

    void endAdUnitExposure(String str, long j);

    void generateEventId(NI2 ni2);

    void getAppInstanceId(NI2 ni2);

    void getCachedAppInstanceId(NI2 ni2);

    void getConditionalUserProperties(String str, String str2, NI2 ni2);

    void getCurrentScreenClass(NI2 ni2);

    void getCurrentScreenName(NI2 ni2);

    void getGmpAppId(NI2 ni2);

    void getMaxUserProperties(String str, NI2 ni2);

    void getTestFlag(NI2 ni2, int i);

    void getUserProperties(String str, String str2, boolean z, NI2 ni2);

    void initForTests(Map map);

    void initialize(Zr0 zr0, zzcl zzclVar, long j);

    void isDataCollectionEnabled(NI2 ni2);

    void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j);

    void logEventAndBundle(String str, String str2, Bundle bundle, NI2 ni2, long j);

    void logHealthData(int i, String str, Zr0 zr0, Zr0 zr02, Zr0 zr03);

    void onActivityCreated(Zr0 zr0, Bundle bundle, long j);

    void onActivityDestroyed(Zr0 zr0, long j);

    void onActivityPaused(Zr0 zr0, long j);

    void onActivityResumed(Zr0 zr0, long j);

    void onActivitySaveInstanceState(Zr0 zr0, NI2 ni2, long j);

    void onActivityStarted(Zr0 zr0, long j);

    void onActivityStopped(Zr0 zr0, long j);

    void performAction(Bundle bundle, NI2 ni2, long j);

    void registerOnMeasurementEventListener(YI2 yi2);

    void resetAnalyticsData(long j);

    void setConditionalUserProperty(Bundle bundle, long j);

    void setConsent(Bundle bundle, long j);

    void setConsentThirdParty(Bundle bundle, long j);

    void setCurrentScreen(Zr0 zr0, String str, String str2, long j);

    void setDataCollectionEnabled(boolean z);

    void setDefaultEventParameters(Bundle bundle);

    void setEventInterceptor(YI2 yi2);

    void setInstanceIdProvider(InterfaceC0631fJ2 interfaceC0631fJ2);

    void setMeasurementEnabled(boolean z, long j);

    void setMinimumSessionDuration(long j);

    void setSessionTimeoutDuration(long j);

    void setUserId(String str, long j);

    void setUserProperty(String str, String str2, Zr0 zr0, boolean z, long j);

    void unregisterOnMeasurementEventListener(YI2 yi2);
}
