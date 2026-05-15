package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import androidx.mediarouter.app.MediaRouteButton;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import org.chromium.components.media_router.caf.CastOptionsProvider;

/* JADX INFO: renamed from: By, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0025By {
    public static final YL2 h = new YL2("CastContext");
    public static C0025By i;
    public final Context a;
    public final InterfaceC0904jV2 b;
    public final eF1 c;
    public final HK2 d;
    public final CastOptions e;
    public final V23 f;
    public GQ2 g;

    public C0025By(Context context, CastOptions castOptions) {
        InterfaceC0904jV2 interfaceC0904jV2A1;
        F03 f03;
        Z23 z23;
        YL2 yl2 = h;
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.e = castOptions;
        V23 v23 = new V23(C1087mP0.d(applicationContext));
        this.f = v23;
        if (TextUtils.isEmpty(castOptions.t)) {
            this.g = null;
        } else {
            this.g = new GQ2(applicationContext, castOptions, this.f);
        }
        try {
            interfaceC0904jV2A1 = SM2.a(applicationContext).a1(new ObjectWrapper(applicationContext.getApplicationContext()), castOptions, v23, d());
        } catch (RemoteException unused) {
            SM2.a.getClass();
            interfaceC0904jV2A1 = null;
        }
        this.b = interfaceC0904jV2A1;
        try {
            AX2 ax2 = (AX2) interfaceC0904jV2A1;
            Parcel parcelX0 = ax2.X0(6, ax2.W0());
            IBinder strongBinder = parcelX0.readStrongBinder();
            if (strongBinder == null) {
                f03 = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.cast.framework.IDiscoveryManager");
                f03 = iInterfaceQueryLocalInterface instanceof F03 ? (F03) iInterfaceQueryLocalInterface : new F03(strongBinder, "com.google.android.gms.cast.framework.IDiscoveryManager");
            }
            parcelX0.recycle();
        } catch (RemoteException unused2) {
            yl2.getClass();
            f03 = null;
        }
        this.d = f03 == null ? null : new HK2(f03);
        try {
            AX2 ax22 = (AX2) this.b;
            Parcel parcelX02 = ax22.X0(5, ax22.W0());
            IBinder strongBinder2 = parcelX02.readStrongBinder();
            if (strongBinder2 == null) {
                z23 = null;
            } else {
                IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.cast.framework.ISessionManager");
                z23 = iInterfaceQueryLocalInterface2 instanceof Z23 ? (Z23) iInterfaceQueryLocalInterface2 : new Z23(strongBinder2, "com.google.android.gms.cast.framework.ISessionManager");
            }
            parcelX02.recycle();
        } catch (RemoteException unused3) {
            yl2.getClass();
            z23 = null;
        }
        eF1 ef1 = z23 == null ? null : new eF1(z23);
        this.c = ef1;
        if (ef1 == null) {
            return;
        }
        new C1320qJ2(this.a, C1320qJ2.a, null, GoogleApi.Settings.DEFAULT_SETTINGS);
        Preconditions.checkNotEmpty("PrecacheManager", "The log tag cannot be null or empty.");
    }

    public static C0025By b(Context context) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (i == null) {
            Context applicationContext = context.getApplicationContext();
            try {
                Bundle bundle = Wrappers.packageManager(applicationContext).getApplicationInfo(applicationContext.getPackageName(), 128).metaData;
                if (bundle == null) {
                    h.a(new Object[0]);
                }
                String string = bundle.getString("com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME");
                if (string == null) {
                    throw new IllegalStateException("The fully qualified name of the implementation of OptionsProvider must be provided as a metadata in the AndroidManifest.xml with key com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME.");
                }
                CastOptionsProvider castOptionsProvider = (CastOptionsProvider) Class.forName(string).getDeclaredConstructor(null).newInstance(null);
                context.getApplicationContext();
                castOptionsProvider.getClass();
                ArrayList arrayList = new ArrayList();
                new LaunchOptions();
                LaunchOptions launchOptions = new LaunchOptions();
                launchOptions.t = true;
                CastOptions castOptions = new CastOptions(null, arrayList, true, launchOptions, false, null, false, 0.05000000074505806d, false);
                context.getApplicationContext();
                i = new C0025By(context, castOptions);
            } catch (PackageManager.NameNotFoundException e) {
                e = e;
                throw new IllegalStateException("Failed to initialize CastContext.", e);
            } catch (ClassNotFoundException e2) {
                e = e2;
                throw new IllegalStateException("Failed to initialize CastContext.", e);
            } catch (IllegalAccessException e3) {
                e = e3;
                throw new IllegalStateException("Failed to initialize CastContext.", e);
            } catch (InstantiationException e4) {
                e = e4;
                throw new IllegalStateException("Failed to initialize CastContext.", e);
            } catch (NoSuchMethodException e5) {
                e = e5;
                throw new IllegalStateException("Failed to initialize CastContext.", e);
            } catch (NullPointerException e6) {
                e = e6;
                throw new IllegalStateException("Failed to initialize CastContext.", e);
            } catch (InvocationTargetException e7) {
                e = e7;
                throw new IllegalStateException("Failed to initialize CastContext.", e);
            }
        }
        return i;
    }

    public final eF1 a() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.c;
    }

    public final void c(String str) {
        C0025By c0025ByB;
        C0468cP0 c0468cP0B;
        FQ0 fq0B;
        YL2 yl2 = h;
        Preconditions.checkMainThread("Must be called from the main thread.");
        CastOptions castOptions = this.e;
        if (TextUtils.equals(str, castOptions.t)) {
            return;
        }
        castOptions.t = str;
        boolean zIsEmpty = TextUtils.isEmpty(castOptions.t);
        Context context = this.a;
        if (zIsEmpty) {
            this.g = null;
        } else {
            this.g = new GQ2(context, castOptions, this.f);
        }
        HashMap mapD = d();
        try {
            AX2 ax2 = (AX2) this.b;
            Parcel parcelW0 = ax2.W0();
            parcelW0.writeString(str);
            parcelW0.writeMap(mapD);
            ax2.Y0(11, parcelW0);
        } catch (RemoteException unused) {
            yl2.getClass();
        }
        for (WeakReference weakReference : AbstractC0009Ay.b) {
            try {
            } catch (IllegalArgumentException e) {
                YL2 yl22 = AbstractC0009Ay.a;
                Log.w(yl22.a, yl22.b("Unexpected exception when refreshing MediaRouteSelectors for Cast buttons", e));
            }
            if (weakReference.get() != null) {
                MenuItem menuItem = (MenuItem) weakReference.get();
                Preconditions.checkMainThread("Must be called from the main thread.");
                if (menuItem instanceof aS1) {
                    fq0B = ((aS1) menuItem).b();
                } else {
                    Log.w("MenuItemCompat", "getActionProvider: item does not implement SupportMenuItem; returning null");
                    fq0B = null;
                }
                if (fq0B != null) {
                    throw new ClassCastException();
                }
                throw new IllegalArgumentException();
            }
        }
        for (WeakReference weakReference2 : AbstractC0009Ay.c) {
            if (weakReference2.get() != null) {
                MediaRouteButton mediaRouteButton = (MediaRouteButton) weakReference2.get();
                Preconditions.checkMainThread("Must be called from the main thread.");
                Preconditions.checkMainThread("Must be called from the main thread.");
                try {
                    c0025ByB = b(context);
                } catch (RuntimeException e2) {
                    Log.e(yl2.a, yl2.b("Failed to load module from Google Play services. Cast will not work properly. Might due to outdated Google Play services. Ignoring this failure silently.", e2));
                    c0025ByB = null;
                }
                if (c0025ByB != null) {
                    Preconditions.checkMainThread("Must be called from the main thread.");
                    try {
                        AX2 ax22 = (AX2) c0025ByB.b;
                        Parcel parcelX0 = ax22.X0(1, ax22.W0());
                        Bundle bundle = (Bundle) QK2.a(parcelX0, Bundle.CREATOR);
                        parcelX0.recycle();
                        c0468cP0B = C0468cP0.b(bundle);
                    } catch (RemoteException unused2) {
                        yl2.getClass();
                        c0468cP0B = null;
                    }
                    mediaRouteButton.d(c0468cP0B);
                }
            }
        }
    }

    public final HashMap d() {
        HashMap map = new HashMap();
        GQ2 gq2 = this.g;
        if (gq2 != null) {
            map.put(gq2.b, gq2.c);
        }
        return map;
    }
}
