package defpackage;

import android.content.Context;
import android.media.MediaRoute2Info;
import android.media.MediaRouter2;
import android.media.MediaRouter2$RouteCallback;
import android.media.RouteDiscoveryPreference;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: hO0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0772hO0 extends ZO0 {
    public final MediaRouter2 B;
    public final Vl0 C;
    public final ArrayMap D;
    public final MediaRouter2$RouteCallback E;
    public final C0704gO0 F;
    public final C0349aO0 G;
    public final ZN0 H;
    public ArrayList I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final ArrayMap f29J;

    /* JADX WARN: Type inference failed for: r3v2, types: [ZN0] */
    public C0772hO0(Context context, Vl0 vl0) {
        super(context, null);
        this.D = new ArrayMap();
        this.F = new C0704gO0(this);
        this.G = new C0349aO0(this);
        this.I = new ArrayList();
        this.f29J = new ArrayMap();
        this.B = MediaRouter2.getInstance(context);
        this.C = vl0;
        final Handler handler = new Handler(Looper.getMainLooper());
        this.H = new Executor() { // from class: ZN0
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
        if (Build.VERSION.SDK_INT >= 34) {
            this.E = new C0639fO0(this, 1);
        } else {
            this.E = new C0639fO0(this, 0);
        }
    }

    @Override // defpackage.ZO0
    public final UO0 a(String str) {
        Iterator it = this.D.entrySet().iterator();
        while (it.hasNext()) {
            C0526dO0 c0526dO0 = (C0526dO0) ((Map.Entry) it.next()).getValue();
            if (TextUtils.equals(str, c0526dO0.f)) {
                return c0526dO0;
            }
        }
        return null;
    }

    @Override // defpackage.ZO0
    public final XO0 b(String str) {
        return new C0578eO0((String) this.f29J.get(str), null);
    }

    @Override // defpackage.ZO0
    public final XO0 c(String str, String str2) {
        String str3 = (String) this.f29J.get(str);
        for (C0526dO0 c0526dO0 : this.D.values()) {
            OO0 oo0 = c0526dO0.o;
            if (TextUtils.equals(str2, oo0 != null ? oo0.d() : c0526dO0.g.getId())) {
                return new C0578eO0(str3, c0526dO0);
            }
        }
        Log.w("MR2Provider", "Could not find the matching GroupRouteController. routeId=" + str + ", routeGroupId=" + str2);
        return new C0578eO0(str3, null);
    }

    @Override // defpackage.ZO0
    public final void d(RO0 ro0) {
        ArrayList<String> arrayList;
        C0468cP0 c0468cP0;
        RouteDiscoveryPreference routeDiscoveryPreferenceBuild;
        MediaRouter2$RouteCallback mediaRouter2$RouteCallback = this.E;
        int i = C1087mP0.c == null ? 0 : C1087mP0.c().y;
        C0349aO0 c0349aO0 = this.G;
        C0704gO0 c0704gO0 = this.F;
        if (i <= 0) {
            this.B.unregisterRouteCallback(mediaRouter2$RouteCallback);
            this.B.unregisterTransferCallback(c0704gO0);
            this.B.unregisterControllerCallback(c0349aO0);
            return;
        }
        C1087mP0.c().getClass();
        if (ro0 == null) {
            ro0 = new RO0(C0468cP0.c, false);
        }
        ro0.a();
        ArrayList<String> arrayListC = ro0.b.c();
        arrayListC.remove("android.media.intent.category.LIVE_AUDIO");
        if (arrayListC.isEmpty()) {
            arrayList = null;
        } else {
            arrayList = null;
            for (String str : arrayListC) {
                if (str == null) {
                    throw new IllegalArgumentException("category must not be null");
                }
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        if (arrayList == null) {
            c0468cP0 = C0468cP0.c;
        } else {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("controlCategories", arrayList);
            c0468cP0 = new C0468cP0(bundle, arrayList);
        }
        boolean zB = ro0.b();
        if (c0468cP0 == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("selector", c0468cP0.a);
        bundle2.putBoolean("activeScan", zB);
        MediaRouter2 mediaRouter2 = this.B;
        c0468cP0.a();
        if (c0468cP0.b.contains(null)) {
            AbstractC0897jP0.g();
            routeDiscoveryPreferenceBuild = AbstractC0897jP0.b(new ArrayList()).build();
        } else {
            boolean z = bundle2.getBoolean("activeScan");
            ArrayList arrayList2 = new ArrayList();
            for (String str2 : c0468cP0.c()) {
                str2.getClass();
                switch (str2) {
                    case "android.media.intent.category.REMOTE_PLAYBACK":
                        str2 = "android.media.route.feature.REMOTE_PLAYBACK";
                        break;
                    case "android.media.intent.category.LIVE_AUDIO":
                        str2 = "android.media.route.feature.LIVE_AUDIO";
                        break;
                    case "android.media.intent.category.LIVE_VIDEO":
                        str2 = "android.media.route.feature.LIVE_VIDEO";
                        break;
                    case "android.media.intent.category.REMOTE_AUDIO_PLAYBACK":
                        str2 = "android.media.route.feature.REMOTE_AUDIO_PLAYBACK";
                        break;
                    case "android.media.intent.category.REMOTE_VIDEO_PLAYBACK":
                        str2 = "android.media.route.feature.REMOTE_VIDEO_PLAYBACK";
                        break;
                }
                arrayList2.add(str2);
            }
            routeDiscoveryPreferenceBuild = AbstractC0897jP0.c(arrayList2, z).build();
        }
        ZN0 zn0 = this.H;
        mediaRouter2.registerRouteCallback(zn0, mediaRouter2$RouteCallback, routeDiscoveryPreferenceBuild);
        this.B.registerTransferCallback(zn0, c0704gO0);
        this.B.registerControllerCallback(zn0, c0349aO0);
    }

    public final void g() {
        ArrayList arrayList = new ArrayList();
        ArraySet arraySet = new ArraySet();
        Iterator it = this.B.getRoutes().iterator();
        while (it.hasNext()) {
            MediaRoute2Info mediaRoute2InfoB = YN0.b(it.next());
            if (mediaRoute2InfoB != null && !arraySet.contains(mediaRoute2InfoB) && !mediaRoute2InfoB.isSystemRoute()) {
                arraySet.add(mediaRoute2InfoB);
                arrayList.add(mediaRoute2InfoB);
            }
        }
        if (arrayList.equals(this.I)) {
            return;
        }
        this.I = arrayList;
        ArrayMap arrayMap = this.f29J;
        arrayMap.clear();
        Iterator it2 = this.I.iterator();
        while (it2.hasNext()) {
            MediaRoute2Info mediaRoute2InfoB2 = YN0.b(it2.next());
            Bundle extras = mediaRoute2InfoB2.getExtras();
            if (extras == null || extras.getString("androidx.mediarouter.media.KEY_ORIGINAL_ROUTE_ID") == null) {
                Log.w("MR2Provider", "Cannot find the original route Id. route=" + mediaRoute2InfoB2);
            } else {
                arrayMap.put(mediaRoute2InfoB2.getId(), extras.getString("androidx.mediarouter.media.KEY_ORIGINAL_ROUTE_ID"));
            }
        }
        ArrayList<OO0> arrayList2 = new ArrayList();
        Iterator it3 = this.I.iterator();
        while (it3.hasNext()) {
            OO0 oo0B = AbstractC1026lP0.b(YN0.b(it3.next()));
            if (oo0B != null) {
                arrayList2.add(oo0B);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        if (!arrayList2.isEmpty()) {
            for (OO0 oo0 : arrayList2) {
                if (oo0 == null) {
                    throw new IllegalArgumentException("route must not be null");
                }
                if (arrayList3.contains(oo0)) {
                    throw new IllegalArgumentException("route descriptor already added");
                }
                arrayList3.add(oo0);
            }
        }
        e(new C0351aP0(arrayList3, true));
    }

    public final void h(MediaRouter2.RoutingController routingController) {
        NO0 no0;
        C0526dO0 c0526dO0 = (C0526dO0) this.D.get(routingController);
        if (c0526dO0 == null) {
            Log.w("MR2Provider", "setDynamicRouteDescriptors: No matching routeController found. routingController=" + routingController);
            return;
        }
        List selectedRoutes = routingController.getSelectedRoutes();
        if (selectedRoutes.isEmpty()) {
            Log.w("MR2Provider", "setDynamicRouteDescriptors: No selected routes. This may happen when the selected routes become invalid.routingController=" + routingController);
            return;
        }
        ArrayList<String> arrayListA = AbstractC1026lP0.a(selectedRoutes);
        OO0 oo0B = AbstractC1026lP0.b(YN0.b(selectedRoutes.get(0)));
        Bundle controlHints = routingController.getControlHints();
        String string = this.t.getString(AbstractC0275Wp1.mr_dialog_default_group_name);
        OO0 oo0 = null;
        if (controlHints != null) {
            try {
                String string2 = controlHints.getString("androidx.mediarouter.media.KEY_SESSION_NAME");
                if (!TextUtils.isEmpty(string2)) {
                    string = string2;
                }
                Bundle bundle = controlHints.getBundle("androidx.mediarouter.media.KEY_GROUP_ROUTE");
                if (bundle != null) {
                    oo0 = new OO0(bundle);
                }
            } catch (Exception e) {
                Log.w("MR2Provider", "Exception while unparceling control hints.", e);
            }
        }
        if (oo0 == null) {
            no0 = new NO0(routingController.getId(), string);
            Bundle bundle2 = no0.a;
            bundle2.putInt("connectionState", 2);
            bundle2.putInt("playbackType", 1);
        } else {
            no0 = new NO0(oo0);
        }
        int volume = routingController.getVolume();
        Bundle bundle3 = no0.a;
        bundle3.putInt("volume", volume);
        bundle3.putInt("volumeMax", routingController.getVolumeMax());
        bundle3.putInt("volumeHandling", routingController.getVolumeHandling());
        no0.c.clear();
        no0.a(oo0B.b());
        ArrayList arrayList = no0.b;
        arrayList.clear();
        if (!arrayListA.isEmpty()) {
            for (String str : arrayListA) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("groupMemberId must not be empty");
                }
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        OO0 oo0B2 = no0.b();
        ArrayList arrayListA2 = AbstractC1026lP0.a(routingController.getSelectableRoutes());
        ArrayList arrayListA3 = AbstractC1026lP0.a(routingController.getDeselectableRoutes());
        C0351aP0 c0351aP0 = this.z;
        if (c0351aP0 == null) {
            Log.w("MR2Provider", "setDynamicRouteDescriptors: providerDescriptor is not set.");
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        List<OO0> list = c0351aP0.a;
        if (!list.isEmpty()) {
            for (OO0 oo02 : list) {
                String strD = oo02.d();
                arrayList2.add(new TO0(oo02, arrayListA.contains(strD) ? 3 : 1, arrayListA3.contains(strD), arrayListA2.contains(strD), true));
            }
        }
        c0526dO0.o = oo0B2;
        c0526dO0.j(oo0B2, arrayList2);
    }
}
