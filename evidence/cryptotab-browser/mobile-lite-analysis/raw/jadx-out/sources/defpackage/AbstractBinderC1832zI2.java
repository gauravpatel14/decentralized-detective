package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzcl;
import java.util.HashMap;

/* JADX INFO: renamed from: zI2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC1832zI2 extends AbstractBinderC0458cH2 implements DI2 {
    public static DI2 asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return iInterfaceQueryLocalInterface instanceof DI2 ? (DI2) iInterfaceQueryLocalInterface : new uI2(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // defpackage.AbstractBinderC0458cH2
    public final boolean W0(int i, Parcel parcel, Parcel parcel2) {
        boolean z;
        NI2 gi2 = null;
        NI2 gi22 = null;
        NI2 gi23 = null;
        YI2 ri2 = null;
        YI2 ri22 = null;
        YI2 ri23 = null;
        NI2 gi24 = null;
        NI2 gi25 = null;
        NI2 gi26 = null;
        NI2 gi27 = null;
        NI2 gi28 = null;
        NI2 gi29 = null;
        InterfaceC0631fJ2 zi2 = null;
        NI2 gi210 = null;
        NI2 gi211 = null;
        NI2 gi212 = null;
        NI2 gi213 = null;
        NI2 gi214 = null;
        switch (i) {
            case 1:
                Zr0 zr0W0 = ObjectWrapper.W0(parcel.readStrongBinder());
                zzcl zzclVar = (zzcl) hH2.a(parcel, zzcl.CREATOR);
                long j = parcel.readLong();
                hH2.b(parcel);
                initialize(zr0W0, zzclVar, j);
                break;
            case 2:
                String string = parcel.readString();
                String string2 = parcel.readString();
                Bundle bundle = (Bundle) hH2.a(parcel, Bundle.CREATOR);
                boolean z2 = parcel.readInt() != 0;
                boolean z3 = parcel.readInt() != 0;
                long j2 = parcel.readLong();
                hH2.b(parcel);
                logEvent(string, string2, bundle, z2, z3, j2);
                break;
            case 3:
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                Bundle bundle2 = (Bundle) hH2.a(parcel, Bundle.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    gi2 = iInterfaceQueryLocalInterface instanceof NI2 ? (NI2) iInterfaceQueryLocalInterface : new GI2(strongBinder);
                }
                long j3 = parcel.readLong();
                hH2.b(parcel);
                logEventAndBundle(string3, string4, bundle2, gi2, j3);
                break;
            case 4:
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                Zr0 zr0W02 = ObjectWrapper.W0(parcel.readStrongBinder());
                ClassLoader classLoader = hH2.a;
                boolean z4 = parcel.readInt() != 0;
                long j4 = parcel.readLong();
                hH2.b(parcel);
                setUserProperty(string5, string6, zr0W02, z4, j4);
                break;
            case 5:
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                ClassLoader classLoader2 = hH2.a;
                z = parcel.readInt() != 0;
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    gi214 = iInterfaceQueryLocalInterface2 instanceof NI2 ? (NI2) iInterfaceQueryLocalInterface2 : new GI2(strongBinder2);
                }
                hH2.b(parcel);
                getUserProperties(string7, string8, z, gi214);
                break;
            case 6:
                String string9 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    gi213 = iInterfaceQueryLocalInterface3 instanceof NI2 ? (NI2) iInterfaceQueryLocalInterface3 : new GI2(strongBinder3);
                }
                hH2.b(parcel);
                getMaxUserProperties(string9, gi213);
                break;
            case 7:
                String string10 = parcel.readString();
                long j5 = parcel.readLong();
                hH2.b(parcel);
                setUserId(string10, j5);
                break;
            case 8:
                Bundle bundle3 = (Bundle) hH2.a(parcel, Bundle.CREATOR);
                long j6 = parcel.readLong();
                hH2.b(parcel);
                setConditionalUserProperty(bundle3, j6);
                break;
            case ConnectionResult.SERVICE_INVALID /* 9 */:
                String string11 = parcel.readString();
                String string12 = parcel.readString();
                Bundle bundle4 = (Bundle) hH2.a(parcel, Bundle.CREATOR);
                hH2.b(parcel);
                clearConditionalUserProperty(string11, string12, bundle4);
                break;
            case 10:
                String string13 = parcel.readString();
                String string14 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    gi212 = iInterfaceQueryLocalInterface4 instanceof NI2 ? (NI2) iInterfaceQueryLocalInterface4 : new GI2(strongBinder4);
                }
                hH2.b(parcel);
                getConditionalUserProperties(string13, string14, gi212);
                break;
            case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                ClassLoader classLoader3 = hH2.a;
                z = parcel.readInt() != 0;
                long j7 = parcel.readLong();
                hH2.b(parcel);
                setMeasurementEnabled(z, j7);
                break;
            case 12:
                long j8 = parcel.readLong();
                hH2.b(parcel);
                resetAnalyticsData(j8);
                break;
            case 13:
                long j9 = parcel.readLong();
                hH2.b(parcel);
                setMinimumSessionDuration(j9);
                break;
            case 14:
                long j10 = parcel.readLong();
                hH2.b(parcel);
                setSessionTimeoutDuration(j10);
                break;
            case 15:
                Zr0 zr0W03 = ObjectWrapper.W0(parcel.readStrongBinder());
                String string15 = parcel.readString();
                String string16 = parcel.readString();
                long j11 = parcel.readLong();
                hH2.b(parcel);
                setCurrentScreen(zr0W03, string15, string16, j11);
                break;
            case 16:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    gi211 = iInterfaceQueryLocalInterface5 instanceof NI2 ? (NI2) iInterfaceQueryLocalInterface5 : new GI2(strongBinder5);
                }
                hH2.b(parcel);
                getCurrentScreenName(gi211);
                break;
            case 17:
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    gi210 = iInterfaceQueryLocalInterface6 instanceof NI2 ? (NI2) iInterfaceQueryLocalInterface6 : new GI2(strongBinder6);
                }
                hH2.b(parcel);
                getCurrentScreenClass(gi210);
                break;
            case ConnectionResult.SERVICE_UPDATING /* 18 */:
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    zi2 = iInterfaceQueryLocalInterface7 instanceof InterfaceC0631fJ2 ? (InterfaceC0631fJ2) iInterfaceQueryLocalInterface7 : new ZI2(strongBinder7, "com.google.android.gms.measurement.api.internal.IStringProvider");
                }
                hH2.b(parcel);
                setInstanceIdProvider(zi2);
                break;
            case 19:
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    gi29 = iInterfaceQueryLocalInterface8 instanceof NI2 ? (NI2) iInterfaceQueryLocalInterface8 : new GI2(strongBinder8);
                }
                hH2.b(parcel);
                getCachedAppInstanceId(gi29);
                break;
            case 20:
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 != null) {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    gi28 = iInterfaceQueryLocalInterface9 instanceof NI2 ? (NI2) iInterfaceQueryLocalInterface9 : new GI2(strongBinder9);
                }
                hH2.b(parcel);
                getAppInstanceId(gi28);
                break;
            case CommonStatusCodes.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                IBinder strongBinder10 = parcel.readStrongBinder();
                if (strongBinder10 != null) {
                    IInterface iInterfaceQueryLocalInterface10 = strongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    gi27 = iInterfaceQueryLocalInterface10 instanceof NI2 ? (NI2) iInterfaceQueryLocalInterface10 : new GI2(strongBinder10);
                }
                hH2.b(parcel);
                getGmpAppId(gi27);
                break;
            case 22:
                IBinder strongBinder11 = parcel.readStrongBinder();
                if (strongBinder11 != null) {
                    IInterface iInterfaceQueryLocalInterface11 = strongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    gi26 = iInterfaceQueryLocalInterface11 instanceof NI2 ? (NI2) iInterfaceQueryLocalInterface11 : new GI2(strongBinder11);
                }
                hH2.b(parcel);
                generateEventId(gi26);
                break;
            case ConnectionResult.API_DISABLED /* 23 */:
                String string17 = parcel.readString();
                long j12 = parcel.readLong();
                hH2.b(parcel);
                beginAdUnitExposure(string17, j12);
                break;
            case ConnectionResult.API_DISABLED_FOR_CONNECTION /* 24 */:
                String string18 = parcel.readString();
                long j13 = parcel.readLong();
                hH2.b(parcel);
                endAdUnitExposure(string18, j13);
                break;
            case 25:
                Zr0 zr0W04 = ObjectWrapper.W0(parcel.readStrongBinder());
                long j14 = parcel.readLong();
                hH2.b(parcel);
                onActivityStarted(zr0W04, j14);
                break;
            case 26:
                Zr0 zr0W05 = ObjectWrapper.W0(parcel.readStrongBinder());
                long j15 = parcel.readLong();
                hH2.b(parcel);
                onActivityStopped(zr0W05, j15);
                break;
            case 27:
                Zr0 zr0W06 = ObjectWrapper.W0(parcel.readStrongBinder());
                Bundle bundle5 = (Bundle) hH2.a(parcel, Bundle.CREATOR);
                long j16 = parcel.readLong();
                hH2.b(parcel);
                onActivityCreated(zr0W06, bundle5, j16);
                break;
            case 28:
                Zr0 zr0W07 = ObjectWrapper.W0(parcel.readStrongBinder());
                long j17 = parcel.readLong();
                hH2.b(parcel);
                onActivityDestroyed(zr0W07, j17);
                break;
            case 29:
                Zr0 zr0W08 = ObjectWrapper.W0(parcel.readStrongBinder());
                long j18 = parcel.readLong();
                hH2.b(parcel);
                onActivityPaused(zr0W08, j18);
                break;
            case 30:
                Zr0 zr0W09 = ObjectWrapper.W0(parcel.readStrongBinder());
                long j19 = parcel.readLong();
                hH2.b(parcel);
                onActivityResumed(zr0W09, j19);
                break;
            case 31:
                Zr0 zr0W010 = ObjectWrapper.W0(parcel.readStrongBinder());
                IBinder strongBinder12 = parcel.readStrongBinder();
                if (strongBinder12 != null) {
                    IInterface iInterfaceQueryLocalInterface12 = strongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    gi25 = iInterfaceQueryLocalInterface12 instanceof NI2 ? (NI2) iInterfaceQueryLocalInterface12 : new GI2(strongBinder12);
                }
                long j20 = parcel.readLong();
                hH2.b(parcel);
                onActivitySaveInstanceState(zr0W010, gi25, j20);
                break;
            case 32:
                Bundle bundle6 = (Bundle) hH2.a(parcel, Bundle.CREATOR);
                IBinder strongBinder13 = parcel.readStrongBinder();
                if (strongBinder13 != null) {
                    IInterface iInterfaceQueryLocalInterface13 = strongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    gi24 = iInterfaceQueryLocalInterface13 instanceof NI2 ? (NI2) iInterfaceQueryLocalInterface13 : new GI2(strongBinder13);
                }
                long j21 = parcel.readLong();
                hH2.b(parcel);
                performAction(bundle6, gi24, j21);
                break;
            case 33:
                int i2 = parcel.readInt();
                String string19 = parcel.readString();
                Zr0 zr0W011 = ObjectWrapper.W0(parcel.readStrongBinder());
                Zr0 zr0W012 = ObjectWrapper.W0(parcel.readStrongBinder());
                Zr0 zr0W013 = ObjectWrapper.W0(parcel.readStrongBinder());
                hH2.b(parcel);
                logHealthData(i2, string19, zr0W011, zr0W012, zr0W013);
                break;
            case 34:
                IBinder strongBinder14 = parcel.readStrongBinder();
                if (strongBinder14 != null) {
                    IInterface iInterfaceQueryLocalInterface14 = strongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    ri23 = iInterfaceQueryLocalInterface14 instanceof YI2 ? (YI2) iInterfaceQueryLocalInterface14 : new RI2(strongBinder14);
                }
                hH2.b(parcel);
                setEventInterceptor(ri23);
                break;
            case 35:
                IBinder strongBinder15 = parcel.readStrongBinder();
                if (strongBinder15 != null) {
                    IInterface iInterfaceQueryLocalInterface15 = strongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    ri22 = iInterfaceQueryLocalInterface15 instanceof YI2 ? (YI2) iInterfaceQueryLocalInterface15 : new RI2(strongBinder15);
                }
                hH2.b(parcel);
                registerOnMeasurementEventListener(ri22);
                break;
            case 36:
                IBinder strongBinder16 = parcel.readStrongBinder();
                if (strongBinder16 != null) {
                    IInterface iInterfaceQueryLocalInterface16 = strongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    ri2 = iInterfaceQueryLocalInterface16 instanceof YI2 ? (YI2) iInterfaceQueryLocalInterface16 : new RI2(strongBinder16);
                }
                hH2.b(parcel);
                unregisterOnMeasurementEventListener(ri2);
                break;
            case 37:
                HashMap hashMap = parcel.readHashMap(hH2.a);
                hH2.b(parcel);
                initForTests(hashMap);
                break;
            case 38:
                IBinder strongBinder17 = parcel.readStrongBinder();
                if (strongBinder17 != null) {
                    IInterface iInterfaceQueryLocalInterface17 = strongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    gi23 = iInterfaceQueryLocalInterface17 instanceof NI2 ? (NI2) iInterfaceQueryLocalInterface17 : new GI2(strongBinder17);
                }
                int i3 = parcel.readInt();
                hH2.b(parcel);
                getTestFlag(gi23, i3);
                break;
            case 39:
                ClassLoader classLoader4 = hH2.a;
                z = parcel.readInt() != 0;
                hH2.b(parcel);
                setDataCollectionEnabled(z);
                break;
            case 40:
                IBinder strongBinder18 = parcel.readStrongBinder();
                if (strongBinder18 != null) {
                    IInterface iInterfaceQueryLocalInterface18 = strongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    gi22 = iInterfaceQueryLocalInterface18 instanceof NI2 ? (NI2) iInterfaceQueryLocalInterface18 : new GI2(strongBinder18);
                }
                hH2.b(parcel);
                isDataCollectionEnabled(gi22);
                break;
            case 41:
            default:
                return false;
            case 42:
                Bundle bundle7 = (Bundle) hH2.a(parcel, Bundle.CREATOR);
                hH2.b(parcel);
                setDefaultEventParameters(bundle7);
                break;
            case 43:
                long j22 = parcel.readLong();
                hH2.b(parcel);
                clearMeasurementEnabled(j22);
                break;
            case 44:
                Bundle bundle8 = (Bundle) hH2.a(parcel, Bundle.CREATOR);
                long j23 = parcel.readLong();
                hH2.b(parcel);
                setConsent(bundle8, j23);
                break;
            case 45:
                Bundle bundle9 = (Bundle) hH2.a(parcel, Bundle.CREATOR);
                long j24 = parcel.readLong();
                hH2.b(parcel);
                setConsentThirdParty(bundle9, j24);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
