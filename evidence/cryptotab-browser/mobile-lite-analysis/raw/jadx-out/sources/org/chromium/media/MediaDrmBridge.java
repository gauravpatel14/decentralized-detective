package org.chromium.media;

import J.N;
import android.annotation.SuppressLint;
import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrm$SessionException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import defpackage.AbstractC1872zv;
import defpackage.C0575eN0;
import defpackage.C0954kN0;
import defpackage.C1022lN0;
import defpackage.C1084mN0;
import defpackage.C1266pN0;
import defpackage.C1327qN0;
import defpackage.C1382rN0;
import defpackage.C1442sN0;
import defpackage.C1502tN0;
import defpackage.C1557uN0;
import defpackage.RunnableC0463cN0;
import defpackage.Xd0;
import defpackage.dN0;
import defpackage.fN0;
import defpackage.gN0;
import defpackage.iN0;
import defpackage.nN0;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"WrongConstant"})
public class MediaDrmBridge {
    public static final UUID l = UUID.fromString("edef8ba9-79d6-4ace-a3c8-27dcd51d21ed");
    public static final byte[] m;
    public static final byte[] n;
    public static final C1084mN0 o;
    public MediaDrm a;
    public MediaCrypto b;
    public long c;
    public final UUID d;
    public final boolean e;
    public C1382rN0 f;
    public C1502tN0 g;
    public final C1557uN0 h;
    public String i;
    public boolean j;
    public nN0 k;

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public class KeyStatus {
        public final byte[] a;
        public final int b;

        public KeyStatus(int i, byte[] bArr) {
            this.a = bArr;
            this.b = i;
        }

        public final byte[] getKeyId() {
            return this.a;
        }

        public final int getStatusCode() {
            return this.b;
        }
    }

    static {
        UUID.fromString("e2719d58-a985-b3c9-781a-b030af78d30e");
        m = new byte[]{0};
        n = "unprovision".getBytes(StandardCharsets.UTF_8);
        o = new C1084mN0();
    }

    public MediaDrmBridge(UUID uuid, boolean z, long j, long j2) {
        this.d = uuid;
        this.a = new MediaDrm(uuid);
        this.e = z;
        this.c = j;
        C1557uN0 c1557uN0 = new C1557uN0();
        c1557uN0.a = j2;
        this.h = c1557uN0;
        this.g = new C1502tN0(c1557uN0);
        this.a.setOnEventListener(new gN0(this));
        this.a.setOnExpirationUpdateListener(new iN0(this), (Handler) null);
        this.a.setOnKeyStatusChangeListener(new C0954kN0(this), (Handler) null);
        if (Build.VERSION.SDK_INT >= 29) {
            this.a.setOnSessionLostStateListener(new C1266pN0(this), (Handler) null);
        }
        if (k()) {
            this.a.setPropertyString("privacyMode", "enable");
            this.a.setPropertyString("sessionSharing", "enable");
        }
    }

    public static void a(MediaDrmBridge mediaDrmBridge, C1382rN0 c1382rN0, Runnable runnable) {
        nN0 nn0 = mediaDrmBridge.k;
        if (nn0 != null) {
            C1382rN0 c1382rN02 = nn0.a;
            c1382rN02.getClass();
            if (Arrays.equals(c1382rN02.a, c1382rN0.a)) {
                mediaDrmBridge.k.b.add(runnable);
                return;
            }
        }
        runnable.run();
    }

    public static C1382rN0 b(MediaDrmBridge mediaDrmBridge, byte[] bArr) {
        if (mediaDrmBridge.f == null) {
            Log.e("cr_media", "Session doesn't exist because media crypto session is not created.");
            return null;
        }
        C1442sN0 c1442sN0 = (C1442sN0) mediaDrmBridge.g.b.get(ByteBuffer.wrap(bArr));
        C1382rN0 c1382rN0 = c1442sN0 == null ? null : c1442sN0.a;
        if (c1382rN0 == null) {
            return null;
        }
        return c1382rN0;
    }

    public static MediaDrmBridge create(byte[] bArr, String str, String str2, String str3, boolean z, long j, long j2) {
        Log.i("cr_media", "Create MediaDrmBridge with level " + str2 + " and origin " + str + " for " + str3);
        try {
            UUID uuidI = i(bArr);
            if (uuidI != null && MediaDrm.isCryptoSchemeSupported(uuidI)) {
                MediaDrmBridge mediaDrmBridge = new MediaDrmBridge(uuidI, z, j, j2);
                if (!str2.isEmpty()) {
                    if (mediaDrmBridge.k()) {
                        String securityLevel = mediaDrmBridge.getSecurityLevel();
                        if (!securityLevel.equals("")) {
                            int i = AbstractC1872zv.a;
                            if (!str2.equals(securityLevel)) {
                                try {
                                    mediaDrmBridge.a.setPropertyString("securityLevel", str2);
                                } catch (IllegalArgumentException e) {
                                    Log.e("cr_media", "Failed to set security level ".concat(str2), e);
                                    Log.e("cr_media", "Security level " + str2 + " not supported!");
                                    mediaDrmBridge.r();
                                    return null;
                                } catch (IllegalStateException e2) {
                                    Log.e("cr_media", "Failed to set security level ".concat(str2), e2);
                                    Log.e("cr_media", "Security level " + str2 + " not supported!");
                                    mediaDrmBridge.r();
                                    return null;
                                }
                            }
                        }
                        mediaDrmBridge.r();
                        return null;
                    }
                    int i2 = AbstractC1872zv.a;
                }
                if (!str.isEmpty()) {
                    int i3 = AbstractC1872zv.a;
                    if (mediaDrmBridge.k()) {
                        try {
                            mediaDrmBridge.a.setPropertyString("origin", str);
                            mediaDrmBridge.i = str;
                            mediaDrmBridge.j = true;
                        } catch (MediaDrm.MediaDrmStateException e3) {
                            Log.e("cr_media", "Failed to set security origin ".concat(str), e3);
                            e3.getDiagnosticInfo();
                            Log.e("cr_media", "getDiagnosticInfo:");
                            if (Build.VERSION.SDK_INT >= 28) {
                                mediaDrmBridge.e();
                            }
                            Log.e("cr_media", "Security origin " + str + " not supported!");
                            mediaDrmBridge.r();
                            return null;
                        } catch (IllegalArgumentException e4) {
                            Log.e("cr_media", "Failed to set security origin ".concat(str), e4);
                            Log.e("cr_media", "Security origin " + str + " not supported!");
                            mediaDrmBridge.r();
                            return null;
                        } catch (IllegalStateException e5) {
                            Log.e("cr_media", "Failed to set security origin ".concat(str), e5);
                            Log.e("cr_media", "Security origin " + str + " not supported!");
                            mediaDrmBridge.r();
                            return null;
                        }
                    }
                }
                if (!z || mediaDrmBridge.d()) {
                    return mediaDrmBridge;
                }
                return null;
            }
            return null;
        } catch (UnsupportedSchemeException e6) {
            Log.e("cr_media", "Unsupported DRM scheme", e6);
            return null;
        } catch (IllegalArgumentException e7) {
            Log.e("cr_media", "Failed to create MediaDrmBridge", e7);
            return null;
        } catch (IllegalStateException e8) {
            Log.e("cr_media", "Failed to create MediaDrmBridge", e8);
            return null;
        }
    }

    public static int getFirstApiLevel() {
        try {
            return ((Integer) Class.forName("android.os.SystemProperties").getMethod("getInt", String.class, Integer.TYPE).invoke(null, "ro.product.first_api_level", 0)).intValue();
        } catch (Exception e) {
            Log.e("cr_media", "Exception while getting system property ro.product.first_api_level. Using default.", e);
            return 0;
        }
    }

    public static UUID i(byte[] bArr) {
        if (bArr.length != 16) {
            return null;
        }
        long j = 0;
        long j2 = 0;
        for (int i = 0; i < 8; i++) {
            j2 = (j2 << 8) | ((long) (bArr[i] & 255));
        }
        for (int i2 = 8; i2 < 16; i2++) {
            j = (j << 8) | ((long) (bArr[i2] & 255));
        }
        return new UUID(j2, j);
    }

    public static boolean isCryptoSchemeSupported(byte[] bArr, String str) {
        UUID uuidI = i(bArr);
        try {
            return str.isEmpty() ? MediaDrm.isCryptoSchemeSupported(uuidI) : MediaDrm.isCryptoSchemeSupported(uuidI, str);
        } catch (IllegalArgumentException e) {
            Log.e("cr_media", "Exception in isCryptoSchemeSupported", e);
            return false;
        }
    }

    public final void c(C1382rN0 c1382rN0) {
        Log.i("cr_media", "Closing session " + c1382rN0);
        try {
            this.a.closeSession(c1382rN0.b);
        } catch (Exception e) {
            Log.e("cr_media", "closeSession failed: ", e);
        }
    }

    public final void closeSession(byte[] bArr, long j) {
        if (this.a == null) {
            m(j, 1100001L, "closeSession() called when MediaDrm is null.");
            return;
        }
        C1382rN0 c1382rN0H = h(bArr);
        if (c1382rN0H == null) {
            m(j, 1100002L, Xd0.a("Invalid sessionId in closeSession(): ", C1382rN0.a(bArr)));
            return;
        }
        Log.i("cr_media", "closeSession(" + c1382rN0H + ")");
        try {
            this.a.removeKeys(c1382rN0H.b);
        } catch (Exception e) {
            Log.e("cr_media", "removeKeys failed: ", e);
        }
        c(c1382rN0H);
        C1502tN0 c1502tN0 = this.g;
        c1502tN0.a(c1382rN0H);
        HashMap map = c1502tN0.a;
        byte[] bArr2 = c1382rN0H.a;
        map.remove(ByteBuffer.wrap(bArr2));
        byte[] bArr3 = c1382rN0H.b;
        if (bArr3 != null) {
            c1502tN0.b.remove(ByteBuffer.wrap(bArr3));
        }
        if (j()) {
            N._V_JOO(113, this.c, this, bArr2);
        }
        if (j()) {
            N._V_JJO(12, this.c, j, this);
        }
        Log.i("cr_media", "Session " + c1382rN0H + " closed");
    }

    public final void createSessionFromNative(byte[] bArr, String str, int i, String[] strArr, long j) {
        C1382rN0 c1382rN0;
        HashMap map = new HashMap();
        if (strArr != null) {
            if (strArr.length % 2 != 0) {
                throw new IllegalArgumentException("Additional data array doesn't have equal keys/values");
            }
            for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                map.put(strArr[i2], strArr[i2 + 1]);
            }
        }
        int i3 = AbstractC1872zv.a;
        if (this.a == null) {
            Log.e("cr_media", "createSession() called when MediaDrm is null.");
            m(j, 1100001L, "MediaDrm released previously.");
            return;
        }
        try {
            byte[] bArrP = p();
            if (bArrP == null) {
                m(j, 1100005L, "Open session failed.");
                return;
            }
            if (i == 2) {
                char[] cArr = C1382rN0.d;
                c1382rN0 = new C1382rN0(UUID.randomUUID().toString().replace('-', '0').getBytes(StandardCharsets.UTF_8), bArrP, null);
            } else {
                c1382rN0 = new C1382rN0(bArrP, bArrP, null);
            }
            C1382rN0 c1382rN02 = c1382rN0;
            MediaDrm.KeyRequest keyRequestF = f(c1382rN02, bArr, str, i, map);
            if (keyRequestF == null) {
                c(c1382rN02);
                m(j, 1100009L, "Generate request failed.");
                return;
            }
            Log.i("cr_media", "createSession(): Session (" + c1382rN02 + ") created for origin " + this.i + ".");
            n(j, c1382rN02);
            o(c1382rN02, keyRequestF);
            C1502tN0 c1502tN0 = this.g;
            c1502tN0.getClass();
            C1442sN0 c1442sN0 = new C1442sN0(c1382rN02, str, i);
            c1502tN0.a.put(ByteBuffer.wrap(c1382rN02.a), c1442sN0);
            byte[] bArr2 = c1382rN02.b;
            if (bArr2 != null) {
                c1502tN0.b.put(ByteBuffer.wrap(bArr2), c1442sN0);
            }
        } catch (NotProvisionedException e) {
            Log.e("cr_media", "Device not provisioned", e);
            m(j, 1100003L, "Device not provisioned during createSession().");
        }
    }

    public final boolean d() {
        UUID uuid = this.d;
        try {
            byte[] bArrP = p();
            if (bArrP == null) {
                Log.e("cr_media", "Cannot create MediaCrypto Session.");
                return false;
            }
            this.f = new C1382rN0(bArrP, bArrP, null);
            int i = AbstractC1872zv.a;
            try {
            } catch (MediaCryptoException e) {
                Log.e("cr_media", "Cannot create MediaCrypto", e);
            }
            if (!MediaCrypto.isCryptoSchemeSupported(uuid)) {
                Log.e("cr_media", "Cannot create MediaCrypto for unsupported scheme.");
                r();
                return false;
            }
            MediaCrypto mediaCrypto = new MediaCrypto(uuid, this.f.b);
            this.b = mediaCrypto;
            if (j()) {
                N._V_JOO(112, this.c, this, mediaCrypto);
            }
            return true;
        } catch (NotProvisionedException unused) {
            Log.i("cr_media", "Not provisioned during openSession()");
            C1084mN0 c1084mN0 = o;
            if (!c1084mN0.a) {
                return s();
            }
            int i2 = AbstractC1872zv.a;
            c1084mN0.b.add(new RunnableC0463cN0(this));
            return true;
        }
    }

    public final void destroy() {
        Log.i("cr_media", "Destroying MediaDrmBridge for origin " + this.i);
        this.c = 0L;
        if (this.a != null) {
            r();
        }
    }

    public final void e() {
        if (k()) {
            try {
                byte[] propertyByteArray = this.a.getPropertyByteArray("metrics");
                if (propertyByteArray != null) {
                    C1382rN0.a(propertyByteArray);
                    Log.e("cr_media", "metrics: ");
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final MediaDrm.KeyRequest f(C1382rN0 c1382rN0, byte[] bArr, String str, int i, HashMap map) {
        MediaDrm.KeyRequest keyRequest;
        if (map == null) {
            map = new HashMap();
        }
        try {
            keyRequest = this.a.getKeyRequest(i == 3 ? c1382rN0.c : c1382rN0.b, bArr, str, i, map);
        } catch (NotProvisionedException e) {
            Log.e("cr_media", "The origin needs re-provision. Unprovision the origin so that the next MediaDrmBridge creation can trigger the provision flow.", e);
            unprovision();
            keyRequest = null;
        } catch (IllegalStateException e2) {
            Log.e("cr_media", "Failed to getKeyRequest().", e2);
            keyRequest = null;
        }
        if (keyRequest == null) {
            Log.e("cr_media", "getKeyRequest(" + c1382rN0 + ") failed");
        } else {
            int i2 = AbstractC1872zv.a;
        }
        return keyRequest;
    }

    public final String g(String str) {
        MediaDrm mediaDrm = this.a;
        if (mediaDrm != null) {
            try {
                return mediaDrm.getPropertyString(str);
            } catch (Exception e) {
                Log.e("cr_media", "Failed to get property ".concat(str), e);
                return "";
            }
        }
        Log.e("cr_media", "getPropertyString(" + str + "): MediaDrm is null.");
        return "";
    }

    public final String getCurrentHdcpLevel() {
        return g("hdcpLevel");
    }

    public final String getSecurityLevel() {
        return g("securityLevel");
    }

    public final String getVersion() {
        String strG = g("version");
        Log.i("cr_media", "Version: " + strG);
        if (k() && Build.VERSION.SDK_INT >= 28) {
            Log.i("cr_media", "oemCryptoBuildInformation: " + g("oemCryptoBuildInformation"));
        }
        return strG;
    }

    public final C1382rN0 h(byte[] bArr) {
        if (this.f == null) {
            Log.e("cr_media", "Session doesn't exist because media crypto session is not created.");
            return null;
        }
        C1442sN0 c1442sN0 = (C1442sN0) this.g.a.get(ByteBuffer.wrap(bArr));
        C1382rN0 c1382rN0 = c1442sN0 == null ? null : c1442sN0.a;
        if (c1382rN0 == null) {
            return null;
        }
        return c1382rN0;
    }

    public final boolean j() {
        return this.c != 0;
    }

    public final boolean k() {
        return this.d.equals(l);
    }

    public final void l(C1382rN0 c1382rN0, long j, Exception exc) {
        Log.w("cr_media", "Persistent license load failed for session " + c1382rN0, exc);
        c(c1382rN0);
        C1502tN0 c1502tN0 = this.g;
        dN0 dn0 = new dN0(this, j, 1);
        c1502tN0.getClass();
        c1382rN0.c = null;
        C1557uN0 c1557uN0 = c1502tN0.c;
        if (c1557uN0.a()) {
            N._V_JOOO(53, c1557uN0.a, c1557uN0, c1382rN0.a, dn0);
        } else {
            dn0.a0(Boolean.TRUE);
        }
    }

    public final void loadSession(byte[] bArr, long j) {
        int i = AbstractC1872zv.a;
        C1502tN0 c1502tN0 = this.g;
        dN0 dn0 = new dN0(this, j, 0);
        c1502tN0.getClass();
        C1327qN0 c1327qN0 = new C1327qN0(c1502tN0, dn0);
        C1557uN0 c1557uN0 = c1502tN0.c;
        if (c1557uN0.a()) {
            N._V_JOOO(54, c1557uN0.a, c1557uN0, bArr, c1327qN0);
        } else {
            c1327qN0.a0(null);
        }
    }

    public final void m(long j, long j2, String str) {
        Log.e("cr_media", "onPromiseRejected: " + str);
        if (j()) {
            N._V_JJJOO(2, this.c, j, j2, this, str);
        }
    }

    public final void n(long j, C1382rN0 c1382rN0) {
        if (j()) {
            N._V_JJOO(6, this.c, j, this, c1382rN0.a);
        }
    }

    public final void o(C1382rN0 c1382rN0, MediaDrm.KeyRequest keyRequest) {
        if (j()) {
            N._V_IJOOO(11, keyRequest.getRequestType(), this.c, this, c1382rN0.a, keyRequest.getData());
        }
    }

    public final byte[] p() throws NotProvisionedException {
        try {
            return (byte[]) this.a.openSession().clone();
        } catch (NotProvisionedException e) {
            throw e;
        } catch (MediaDrmException e2) {
            Log.e("cr_media", "Cannot open a new session", e2);
            r();
            return null;
        } catch (RuntimeException e3) {
            Log.e("cr_media", "Cannot open a new session", e3);
            r();
            return null;
        }
    }

    public final void processProvisionResponse(boolean z, byte[] bArr) {
        int i = AbstractC1872zv.a;
        boolean zQ = (this.a == null || !z) ? false : q(bArr);
        boolean z2 = this.e;
        if (!z2) {
            N._V_ZJO(29, zQ, this.c, this);
            if (!zQ) {
                r();
            }
        } else if (!zQ) {
            r();
        } else if (this.j) {
            fN0 fn0 = new fN0(this);
            C1557uN0 c1557uN0 = this.h;
            if (c1557uN0.a()) {
                N._V_JOO(114, c1557uN0.a, c1557uN0, fn0);
            } else {
                fn0.a0(Boolean.TRUE);
            }
        } else {
            d();
        }
        if (z2) {
            C1084mN0 c1084mN0 = o;
            c1084mN0.a = false;
            do {
                ArrayDeque arrayDeque = c1084mN0.b;
                if (arrayDeque.isEmpty()) {
                    return;
                }
                int i2 = AbstractC1872zv.a;
                Runnable runnable = (Runnable) arrayDeque.element();
                arrayDeque.remove();
                runnable.run();
            } while (!c1084mN0.a);
        }
    }

    public final void provision() {
        if (!this.j) {
            Log.e("cr_media", "Calling provision() without an origin.");
            N._V_ZJO(29, false, this.c, this);
            return;
        }
        try {
            byte[] bArrP = p();
            if (bArrP != null) {
                c(new C1382rN0(bArrP, bArrP, null));
            }
            N._V_ZJO(29, true, this.c, this);
        } catch (NotProvisionedException unused) {
            if (s()) {
                return;
            }
            N._V_ZJO(29, false, this.c, this);
        }
    }

    public final boolean q(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            Log.e("cr_media", "Invalid provision response.");
            return false;
        }
        try {
            this.a.provideProvisionResponse(bArr);
            return true;
        } catch (DeniedByServerException e) {
            Log.e("cr_media", "failed to provide provision response", e);
            return false;
        } catch (IllegalStateException e2) {
            Log.e("cr_media", "failed to provide provision response", e2);
            return false;
        }
    }

    public final void r() {
        C1502tN0 c1502tN0 = this.g;
        c1502tN0.getClass();
        ArrayList<C1382rN0> arrayList = new ArrayList();
        Iterator it = c1502tN0.a.values().iterator();
        while (it.hasNext()) {
            arrayList.add(((C1442sN0) it.next()).a);
        }
        for (C1382rN0 c1382rN0 : arrayList) {
            Log.i("cr_media", "Force closing session " + c1382rN0);
            try {
                this.a.removeKeys(c1382rN0.b);
            } catch (Exception e) {
                Log.e("cr_media", "removeKeys failed: ", e);
            }
            c(c1382rN0);
            if (j()) {
                N._V_JOO(113, this.c, this, c1382rN0.a);
            }
        }
        this.g = new C1502tN0(this.h);
        C1382rN0 c1382rN02 = this.f;
        if (c1382rN02 != null) {
            c(c1382rN02);
            this.f = null;
        }
        MediaDrm mediaDrm = this.a;
        if (mediaDrm != null) {
            mediaDrm.release();
            this.a = null;
        }
        MediaCrypto mediaCrypto = this.b;
        if (mediaCrypto != null) {
            mediaCrypto.release();
            this.b = null;
        } else if (j()) {
            N._V_JOO(112, this.c, this, null);
        }
    }

    public final void removeSession(byte[] bArr, long j) {
        C1382rN0 c1382rN0H = h(bArr);
        if (c1382rN0H == null) {
            m(j, 1100002L, "Session doesn't exist");
            return;
        }
        Log.i("cr_media", "removeSession(" + c1382rN0H + ")");
        C1442sN0 c1442sN0A = this.g.a(c1382rN0H);
        if (c1442sN0A == null) {
            m(j, 1100002L, "Internal error: No info for session: " + c1382rN0H);
            return;
        }
        if (c1442sN0A.c == 1) {
            m(j, 1100007L, "Removing temporary session isn't implemented");
            return;
        }
        C1502tN0 c1502tN0 = this.g;
        C0575eN0 c0575eN0 = new C0575eN0(this, j, c1382rN0H, c1442sN0A);
        C1442sN0 c1442sN0A2 = c1502tN0.a(c1382rN0H);
        c1442sN0A2.c = 3;
        C1382rN0 c1382rN0 = c1442sN0A2.a;
        MediaDrmStorageBridge$PersistentInfo mediaDrmStorageBridge$PersistentInfo = new MediaDrmStorageBridge$PersistentInfo(c1382rN0.a, c1382rN0.c, c1442sN0A2.b, 3);
        C1557uN0 c1557uN0 = c1502tN0.c;
        if (c1557uN0.a()) {
            N._V_JOOO(55, c1557uN0.a, c1557uN0, mediaDrmStorageBridge$PersistentInfo, c0575eN0);
        } else {
            c0575eN0.a0(Boolean.FALSE);
        }
    }

    public final boolean s() {
        int i = AbstractC1872zv.a;
        if (!j()) {
            return false;
        }
        if (this.e) {
            o.a = true;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return t(true);
        }
        try {
            MediaDrm.ProvisionRequest provisionRequest = this.a.getProvisionRequest();
            Log.i("cr_media", "Provisioning origin ID " + (this.j ? this.i : "<none>"));
            N._V_JOOO(52, this.c, this, provisionRequest.getDefaultUrl(), provisionRequest.getData());
            return true;
        } catch (IllegalStateException e) {
            Log.e("cr_media", "Failed to get provisioning request", e);
            return false;
        }
    }

    public final boolean setServerCertificate(byte[] bArr) {
        if (!k()) {
            int i = AbstractC1872zv.a;
            return true;
        }
        try {
            this.a.setPropertyByteArray("serviceCertificate", bArr);
            return true;
        } catch (IllegalArgumentException e) {
            Log.e("cr_media", "Failed to set server certificate", e);
            return false;
        } catch (IllegalStateException e2) {
            Log.e("cr_media", "Failed to set server certificate", e2);
            return false;
        }
    }

    public final boolean t(boolean z) {
        try {
            MediaDrm.ProvisionRequest provisionRequest = this.a.getProvisionRequest();
            Log.i("cr_media", "Provisioning origin ID " + (this.j ? this.i : "<none>"));
            N._V_JOOO(52, this.c, this, provisionRequest.getDefaultUrl(), provisionRequest.getData());
            return true;
        } catch (MediaDrm.MediaDrmStateException e) {
            Log.e("cr_media", "Failed to get provisioning request", e);
            e.getDiagnosticInfo();
            Log.e("cr_media", "getDiagnosticInfo:");
            e();
            return false;
        } catch (MediaDrm$SessionException e2) {
            if (z && Build.VERSION.SDK_INT >= 31 && e2.isTransient()) {
                return t(false);
            }
            Log.e("cr_media", "Failed to get provisioning request", e2);
            e();
            return false;
        } catch (IllegalStateException e3) {
            Log.e("cr_media", "Failed to get provisioning request", e3);
            e();
            return false;
        }
    }

    public final void unprovision() {
        if (this.a != null && this.j) {
            q(n);
        }
    }

    public final void updateSession(byte[] bArr, byte[] bArr2, long j) {
        int i;
        byte[] bArrProvideKeyResponse;
        if (this.a == null) {
            m(j, 1100001L, "updateSession() called when MediaDrm is null.");
            return;
        }
        C1382rN0 c1382rN0H = h(bArr);
        if (c1382rN0H == null) {
            m(j, 1100002L, Xd0.a("Invalid session in updateSession: ", C1382rN0.a(bArr)));
            return;
        }
        Log.i("cr_media", "updateSession(" + c1382rN0H + ")");
        try {
            C1442sN0 c1442sN0A = this.g.a(c1382rN0H);
            if (c1442sN0A == null) {
                m(j, 1100002L, "Internal error: No info for session: " + c1382rN0H);
                return;
            }
            boolean z = c1442sN0A.c == 3;
            if (z) {
                int i2 = AbstractC1872zv.a;
                this.a.provideKeyResponse(c1382rN0H.c, bArr2);
                bArrProvideKeyResponse = null;
            } else {
                bArrProvideKeyResponse = this.a.provideKeyResponse(c1382rN0H.b, bArr2);
            }
            C1022lN0 c1022lN0 = new C1022lN0(this, c1382rN0H, j, z);
            if (!z) {
                if (c1442sN0A.c != 2 || bArrProvideKeyResponse == null || bArrProvideKeyResponse.length <= 0) {
                    c1022lN0.a0(Boolean.TRUE);
                    return;
                } else {
                    this.g.b(c1382rN0H, bArrProvideKeyResponse, c1022lN0);
                    return;
                }
            }
            C1502tN0 c1502tN0 = this.g;
            c1502tN0.getClass();
            c1382rN0H.c = null;
            C1557uN0 c1557uN0 = c1502tN0.c;
            if (c1557uN0.a()) {
                N._V_JOOO(53, c1557uN0.a, c1557uN0, c1382rN0H.a, c1022lN0);
            } else {
                c1022lN0.a0(Boolean.TRUE);
            }
        } catch (DeniedByServerException e) {
            Log.e("cr_media", "failed to provide key response", e);
            i = 1100012;
            m(j, i, "Update session failed.");
            r();
        } catch (NotProvisionedException e2) {
            Log.e("cr_media", "failed to provide key response", e2);
            unprovision();
            i = 1100003;
            m(j, i, "Update session failed.");
            r();
        } catch (IllegalArgumentException e3) {
            Log.e("cr_media", "failed to provide key response", e3);
            i = 1100006;
            m(j, i, "Update session failed.");
            r();
        } catch (IllegalStateException e4) {
            Log.e("cr_media", "failed to provide key response", e4);
            i = 1100013;
            m(j, i, "Update session failed.");
            r();
        }
    }
}
