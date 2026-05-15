package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.media.MediaRouter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Xg1 extends AbstractC0430bh1 {
    public static final ArrayList L;
    public static final ArrayList M;
    public final bm0 B;
    public final MediaRouter C;
    public final C1271pP0 D;
    public final C1330qP0 E;
    public final MediaRouter.RouteCategory F;
    public int G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final ArrayList f6J;
    public final ArrayList K;

    static {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addCategory("android.media.intent.category.LIVE_AUDIO");
        ArrayList arrayList = new ArrayList();
        L = arrayList;
        arrayList.add(intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addCategory("android.media.intent.category.LIVE_VIDEO");
        ArrayList arrayList2 = new ArrayList();
        M = arrayList2;
        arrayList2.add(intentFilter2);
    }

    public Xg1(Context context, bm0 bm0Var) {
        super(context, new WO0(new ComponentName("android", AbstractC0430bh1.class.getName())));
        this.f6J = new ArrayList();
        this.K = new ArrayList();
        this.B = bm0Var;
        MediaRouter mediaRouter = (MediaRouter) context.getSystemService("media_router");
        this.C = mediaRouter;
        this.D = new C1271pP0(this);
        this.E = new C1330qP0(this);
        this.F = mediaRouter.createRouteCategory((CharSequence) context.getResources().getString(AbstractC0275Wp1.mr_user_route_category_name), false);
        r();
    }

    public static C0370ah1 l(MediaRouter.RouteInfo routeInfo) {
        Object tag = routeInfo.getTag();
        if (tag instanceof C0370ah1) {
            return (C0370ah1) tag;
        }
        return null;
    }

    public static void s(C0370ah1 c0370ah1) {
        int i;
        MediaRouter.UserRouteInfo userRouteInfo = c0370ah1.b;
        C0838iP0 c0838iP0 = c0370ah1.a;
        userRouteInfo.setName(c0838iP0.d);
        userRouteInfo.setPlaybackType(c0838iP0.l);
        userRouteInfo.setPlaybackStream(c0838iP0.m);
        userRouteInfo.setVolume(c0838iP0.p);
        userRouteInfo.setVolumeMax(c0838iP0.q);
        if (!c0838iP0.c()) {
            i = c0838iP0.o;
        } else if (C1087mP0.c == null) {
            i = 0;
        } else {
            C1087mP0.c().getClass();
            i = c0838iP0.o;
        }
        userRouteInfo.setVolumeHandling(i);
        userRouteInfo.setDescription(c0838iP0.e);
    }

    @Override // defpackage.ZO0
    public final XO0 b(String str) {
        int i = i(str);
        if (i >= 0) {
            return new Yg1(((Zg1) this.f6J.get(i)).a);
        }
        return null;
    }

    @Override // defpackage.ZO0
    public final void d(RO0 ro0) {
        boolean zB;
        int i = 0;
        if (ro0 != null) {
            ro0.a();
            ArrayList arrayListC = ro0.b.c();
            int size = arrayListC.size();
            int i2 = 0;
            while (i < size) {
                String str = (String) arrayListC.get(i);
                i2 = str.equals("android.media.intent.category.LIVE_AUDIO") ? i2 | 1 : str.equals("android.media.intent.category.LIVE_VIDEO") ? i2 | 2 : i2 | 8388608;
                i++;
            }
            zB = ro0.b();
            i = i2;
        } else {
            zB = false;
        }
        if (this.G == i && this.H == zB) {
            return;
        }
        this.G = i;
        this.H = zB;
        r();
    }

    public final boolean g(MediaRouter.RouteInfo routeInfo) {
        String str;
        if (l(routeInfo) != null || h(routeInfo) >= 0) {
            return false;
        }
        String str2 = this.C.getDefaultRoute() == routeInfo ? "DEFAULT_ROUTE" : String.format(Locale.US, "ROUTE_%08x", Integer.valueOf(k(routeInfo).hashCode()));
        if (i(str2) >= 0) {
            int i = 2;
            while (true) {
                str = str2 + "_" + i;
                if (i(str) < 0) {
                    break;
                }
                i++;
            }
            str2 = str;
        }
        Zg1 zg1 = new Zg1(routeInfo, str2);
        NO0 no0 = new NO0(str2, k(routeInfo));
        m(zg1, no0);
        zg1.c = no0.b();
        this.f6J.add(zg1);
        return true;
    }

    public final int h(MediaRouter.RouteInfo routeInfo) {
        ArrayList arrayList = this.f6J;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Zg1) arrayList.get(i)).a == routeInfo) {
                return i;
            }
        }
        return -1;
    }

    public final int i(String str) {
        ArrayList arrayList = this.f6J;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Zg1) arrayList.get(i)).b.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public final int j(C0838iP0 c0838iP0) {
        ArrayList arrayList = this.K;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((C0370ah1) arrayList.get(i)).a == c0838iP0) {
                return i;
            }
        }
        return -1;
    }

    public final String k(MediaRouter.RouteInfo routeInfo) {
        Context context = this.t;
        CharSequence name = routeInfo.getName(context);
        if (!TextUtils.isEmpty(name)) {
            return name.toString();
        }
        if ((routeInfo.getSupportedTypes() & 8388608) != 0) {
            return "";
        }
        int deviceType = routeInfo.getDeviceType();
        return context.getString(deviceType != 1 ? deviceType != 2 ? deviceType != 3 ? AbstractC0275Wp1.mr_route_name_unknown : AbstractC0275Wp1.mr_route_name_bluetooth : AbstractC0275Wp1.mr_route_name_speaker : AbstractC0275Wp1.mr_route_name_tv);
    }

    public final void m(Zg1 zg1, NO0 no0) {
        int supportedTypes = zg1.a.getSupportedTypes();
        if ((supportedTypes & 1) != 0) {
            no0.a(L);
        }
        if ((supportedTypes & 2) != 0) {
            no0.a(M);
        }
        MediaRouter.RouteInfo routeInfo = zg1.a;
        int playbackType = routeInfo.getPlaybackType();
        Bundle bundle = no0.a;
        bundle.putInt("playbackType", playbackType);
        bundle.putInt("playbackStream", routeInfo.getPlaybackStream());
        bundle.putInt("volume", routeInfo.getVolume());
        bundle.putInt("volumeMax", routeInfo.getVolumeMax());
        bundle.putInt("volumeHandling", routeInfo.getVolumeHandling());
        bundle.putBoolean("isSystemRoute", (supportedTypes & 8388608) == 0);
        if (!routeInfo.isEnabled()) {
            bundle.putBoolean("enabled", false);
        }
        if (routeInfo.isConnecting()) {
            bundle.putInt("connectionState", 1);
        }
        Display presentationDisplay = routeInfo.getPresentationDisplay();
        if (presentationDisplay != null) {
            bundle.putInt("presentationDisplayId", presentationDisplay.getDisplayId());
        }
        CharSequence description = routeInfo.getDescription();
        if (description != null) {
            bundle.putString("status", description.toString());
        }
        no0.a.putInt("deviceType", zg1.a.getDeviceType());
    }

    public final void n(C0838iP0 c0838iP0) {
        ZO0 zo0A = c0838iP0.a();
        MediaRouter mediaRouter = this.C;
        if (zo0A == this) {
            int iH = h(mediaRouter.getSelectedRoute(8388611));
            if (iH < 0 || !((Zg1) this.f6J.get(iH)).b.equals(c0838iP0.b)) {
                return;
            }
            c0838iP0.j(true);
            return;
        }
        MediaRouter.UserRouteInfo userRouteInfoCreateUserRoute = mediaRouter.createUserRoute(this.F);
        C0370ah1 c0370ah1 = new C0370ah1(c0838iP0, userRouteInfoCreateUserRoute);
        userRouteInfoCreateUserRoute.setTag(c0370ah1);
        userRouteInfoCreateUserRoute.setVolumeCallback(this.E);
        s(c0370ah1);
        this.K.add(c0370ah1);
        mediaRouter.addUserRoute(userRouteInfoCreateUserRoute);
    }

    public final void o(C0838iP0 c0838iP0) {
        int iJ;
        if (c0838iP0.a() == this || (iJ = j(c0838iP0)) < 0) {
            return;
        }
        C0370ah1 c0370ah1 = (C0370ah1) this.K.remove(iJ);
        c0370ah1.b.setTag(null);
        MediaRouter.UserRouteInfo userRouteInfo = c0370ah1.b;
        userRouteInfo.setVolumeCallback(null);
        try {
            this.C.removeUserRoute(userRouteInfo);
        } catch (IllegalArgumentException e) {
            Log.w("AxSysMediaRouteProvider", "Failed to remove user route", e);
        }
    }

    public final void p(C0838iP0 c0838iP0) {
        if (c0838iP0.e()) {
            ZO0 zo0A = c0838iP0.a();
            MediaRouter mediaRouter = this.C;
            if (zo0A != this) {
                int iJ = j(c0838iP0);
                if (iJ >= 0) {
                    mediaRouter.selectRoute(8388611, ((C0370ah1) this.K.get(iJ)).b);
                    return;
                }
                return;
            }
            int i = i(c0838iP0.b);
            if (i >= 0) {
                mediaRouter.selectRoute(8388611, ((Zg1) this.f6J.get(i)).a);
            }
        }
    }

    public final void q() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f6J;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            OO0 oo0 = ((Zg1) arrayList2.get(i)).c;
            if (oo0 == null) {
                throw new IllegalArgumentException("route must not be null");
            }
            if (arrayList.contains(oo0)) {
                throw new IllegalArgumentException("route descriptor already added");
            }
            arrayList.add(oo0);
        }
        e(new C0351aP0(arrayList, false));
    }

    public final void r() {
        boolean z = this.I;
        MediaRouter mediaRouter = this.C;
        C1271pP0 c1271pP0 = this.D;
        if (z) {
            mediaRouter.removeCallback(c1271pP0);
        }
        this.I = true;
        mediaRouter.addCallback(this.G, c1271pP0, (this.H ? 1 : 0) | 2);
        int routeCount = mediaRouter.getRouteCount();
        ArrayList arrayList = new ArrayList(routeCount);
        boolean zG = false;
        for (int i = 0; i < routeCount; i++) {
            arrayList.add(mediaRouter.getRouteAt(i));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            zG |= g((MediaRouter.RouteInfo) it.next());
        }
        if (zG) {
            q();
        }
    }
}
