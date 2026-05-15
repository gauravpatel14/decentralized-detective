package defpackage;

import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.os.PowerManager;
import android.util.Log;
import java.util.Calendar;

/* JADX INFO: renamed from: bb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0425bb {
    public C0486cb a;
    public final /* synthetic */ LayoutInflaterFactory2C0658fb b;
    public final /* synthetic */ int c;
    public final /* synthetic */ LayoutInflaterFactory2C0658fb d;
    public final Object e;

    public C0425bb(LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb) {
        this.b = layoutInflaterFactory2C0658fb;
    }

    public final void a() {
        C0486cb c0486cb = this.a;
        if (c0486cb != null) {
            try {
                this.b.D.unregisterReceiver(c0486cb);
            } catch (IllegalArgumentException unused) {
            }
            this.a = null;
        }
    }

    public final int b() {
        Location location;
        boolean z;
        long j;
        switch (this.c) {
            case 0:
                return ((PowerManager) this.e).isPowerSaveMode() ? 2 : 1;
            default:
                C1800yi2 c1800yi2 = (C1800yi2) this.e;
                C1747xi2 c1747xi2 = c1800yi2.c;
                if (c1747xi2.b <= System.currentTimeMillis()) {
                    Context context = c1800yi2.a;
                    int iA = if1.a(context, "android.permission.ACCESS_COARSE_LOCATION");
                    Location lastKnownLocation = null;
                    LocationManager locationManager = c1800yi2.b;
                    if (iA == 0) {
                        try {
                        } catch (Exception e) {
                            Log.d("TwilightManager", "Failed to get last known location", e);
                        }
                        Location lastKnownLocation2 = locationManager.isProviderEnabled("network") ? locationManager.getLastKnownLocation("network") : null;
                        location = lastKnownLocation2;
                    } else {
                        location = null;
                    }
                    if (if1.a(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        try {
                            if (locationManager.isProviderEnabled("gps")) {
                                lastKnownLocation = locationManager.getLastKnownLocation("gps");
                            }
                        } catch (Exception e2) {
                            Log.d("TwilightManager", "Failed to get last known location", e2);
                        }
                    }
                    if (lastKnownLocation == null || location == null ? lastKnownLocation != null : lastKnownLocation.getTime() > location.getTime()) {
                        location = lastKnownLocation;
                    }
                    if (location != null) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (C1689wi2.d == null) {
                            C1689wi2.d = new C1689wi2();
                        }
                        C1689wi2 c1689wi2 = C1689wi2.d;
                        c1689wi2.a(location.getLatitude(), location.getLongitude(), jCurrentTimeMillis - 86400000);
                        c1689wi2.a(location.getLatitude(), location.getLongitude(), jCurrentTimeMillis);
                        z = c1689wi2.c == 1;
                        long j2 = c1689wi2.b;
                        long j3 = c1689wi2.a;
                        c1689wi2.a(location.getLatitude(), location.getLongitude(), 86400000 + jCurrentTimeMillis);
                        long j4 = c1689wi2.b;
                        if (j2 == -1 || j3 == -1) {
                            j = jCurrentTimeMillis + 43200000;
                        } else {
                            if (jCurrentTimeMillis <= j3) {
                                j4 = jCurrentTimeMillis > j2 ? j3 : j2;
                            }
                            j = j4 + 60000;
                        }
                        c1747xi2.a = z;
                        c1747xi2.b = j;
                    } else {
                        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                        int i = Calendar.getInstance().get(11);
                        if (i < 6 || i >= 22) {
                            z = true;
                        }
                    }
                    break;
                } else {
                    z = c1747xi2.a;
                }
                return z ? 2 : 1;
        }
    }

    public final void c() {
        IntentFilter intentFilter;
        a();
        switch (this.c) {
            case 0:
                intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                break;
            default:
                intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.TIME_SET");
                intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
                intentFilter.addAction("android.intent.action.TIME_TICK");
                break;
        }
        if (intentFilter.countActions() == 0) {
            return;
        }
        if (this.a == null) {
            this.a = new C0486cb(this);
        }
        this.b.D.registerReceiver(this.a, intentFilter);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0425bb(LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb, C1800yi2 c1800yi2) {
        this(layoutInflaterFactory2C0658fb);
        this.c = 1;
        this.d = layoutInflaterFactory2C0658fb;
        this.e = c1800yi2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0425bb(LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb, Context context) {
        this(layoutInflaterFactory2C0658fb);
        this.c = 0;
        this.d = layoutInflaterFactory2C0658fb;
        this.e = (PowerManager) context.getApplicationContext().getSystemService("power");
    }
}
