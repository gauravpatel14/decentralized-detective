package org.chromium.media;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.os.Build;
import android.util.Log;
import defpackage.AbstractC1603vG;
import defpackage.LM0;
import defpackage.NM0;
import java.util.ArrayList;
import java.util.Locale;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class MediaCodecUtil {
    public static boolean a(MediaCodec mediaCodec, String str) {
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        if (mediaCodec == null) {
            return false;
        }
        try {
            MediaCodecInfo codecInfo = mediaCodec.getCodecInfo();
            if (codecInfo.isEncoder() || (capabilitiesForType = codecInfo.getCapabilitiesForType(str)) == null) {
                return false;
            }
            return capabilitiesForType.isFeatureSupported("adaptive-playback");
        } catch (IllegalArgumentException e) {
            Log.e("cr_MediaCodecUtil", "Cannot retrieve codec information", e);
            return false;
        }
    }

    public static LM0 b(String str, int i, MediaCrypto mediaCrypto) {
        LM0 lm0 = new LM0();
        if (!isDecoderSupportedForDevice(str)) {
            Log.e("cr_MediaCodecUtil", "Decoder for type " + str + " is not supported on this device");
            return lm0;
        }
        try {
            if ((str.startsWith("video") && i == 1) || (str.startsWith("audio") && mediaCrypto != null && mediaCrypto.requiresSecureDecoderComponent(str))) {
                String defaultCodecName = getDefaultCodecName(str, 0, false, false);
                if (defaultCodecName.equals("")) {
                    return lm0;
                }
                MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(defaultCodecName);
                lm0.b = a(mediaCodecCreateByCodecName, str);
                mediaCodecCreateByCodecName.release();
                lm0.a = MediaCodec.createByCodecName(defaultCodecName.concat(".secure"));
            } else {
                if (i == 2) {
                    lm0.a = MediaCodec.createByCodecName(getDefaultCodecName(str, 0, true, false));
                } else if (str.equals("audio/raw")) {
                    lm0.a = MediaCodec.createByCodecName("OMX.google.raw.decoder");
                } else {
                    lm0.a = MediaCodec.createDecoderByType(str);
                }
                lm0.b = a(lm0.a, str);
            }
        } catch (Exception e) {
            Log.e("cr_MediaCodecUtil", "Failed to create MediaCodec: " + str + ", codecType: " + i, e);
            lm0.a = null;
        }
        return lm0;
    }

    public static LM0 c(String str) {
        LM0 lm0 = new LM0();
        Integer numD = d(str);
        if (numD == null) {
            return lm0;
        }
        try {
            lm0.a = MediaCodec.createEncoderByType(str);
            int i = 0;
            lm0.b = false;
            int iIntValue = numD.intValue();
            if (iIntValue != 0 && iIntValue != 1 && iIntValue != 2) {
                if (iIntValue != 4 && iIntValue != 5 && iIntValue != 6 && iIntValue != 7) {
                    throw new IllegalArgumentException("Invalid HWEncoder decoder parameter.");
                }
                i = 1;
            }
            lm0.c = i;
        } catch (Exception e) {
            Log.e("cr_MediaCodecUtil", "Failed to create MediaCodec: " + str, e);
        }
        return lm0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean canDecode(String str, boolean z) {
        int codecCount;
        int codecCount2;
        if (!isDecoderSupportedForDevice(str)) {
            Log.e("cr_MediaCodecUtil", "Decoder for type " + str + " is not supported on this device");
            return false;
        }
        NM0 nm0 = new NM0();
        if ((nm0.t != null) != true) {
            MediaCodec mediaCodec = b(str, z ? 1 : 0, null).a;
            if (mediaCodec == null) {
                return false;
            }
            try {
                mediaCodec.release();
            } catch (IllegalStateException e) {
                Log.e("cr_MediaCodecUtil", "Cannot release media codec", e);
            }
            return true;
        }
        int i = 0;
        while (true) {
            MediaCodecInfo[] mediaCodecInfoArr = nm0.t;
            if (mediaCodecInfoArr != null) {
                codecCount = mediaCodecInfoArr.length;
            } else {
                try {
                    codecCount = MediaCodecList.getCodecCount();
                } catch (RuntimeException unused) {
                    codecCount = 0;
                }
            }
            if ((i < codecCount) != true) {
                return false;
            }
            MediaCodecInfo[] mediaCodecInfoArr2 = nm0.t;
            if (mediaCodecInfoArr2 != null) {
                codecCount2 = mediaCodecInfoArr2.length;
            } else {
                try {
                    codecCount2 = MediaCodecList.getCodecCount();
                } catch (RuntimeException unused2) {
                    codecCount2 = 0;
                }
            }
            if (i == codecCount2) {
                throw new NoSuchElementException();
            }
            int i2 = i + 1;
            MediaCodecInfo[] mediaCodecInfoArr3 = nm0.t;
            MediaCodecInfo codecInfoAt = mediaCodecInfoArr3 != null ? mediaCodecInfoArr3[i] : MediaCodecList.getCodecInfoAt(i);
            if (!codecInfoAt.isEncoder()) {
                try {
                    MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(str);
                    if (capabilitiesForType == null) {
                        continue;
                    } else {
                        if (z && capabilitiesForType.isFeatureSupported("secure-playback")) {
                            return true;
                        }
                        if (!z && !capabilitiesForType.isFeatureRequired("secure-playback")) {
                            return true;
                        }
                    }
                } catch (IllegalArgumentException unused3) {
                    continue;
                }
            }
            i = i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Integer d(java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.chromium.media.MediaCodecUtil.d(java.lang.String):java.lang.Integer");
    }

    public static boolean e(MediaCodecInfo mediaCodecInfo) {
        if (Build.VERSION.SDK_INT >= 29 && (!mediaCodecInfo.isHardwareAccelerated() || mediaCodecInfo.isSoftwareOnly())) {
            return true;
        }
        String lowerCase = mediaCodecInfo.getName().toLowerCase(Locale.ROOT);
        return lowerCase.startsWith("omx.google.") || lowerCase.startsWith("c2.android.") || lowerCase.contains(".sw.dec") || lowerCase.contains(".sw.enc");
    }

    public static String getDefaultCodecName(String str, int i, boolean z, boolean z2) {
        int codecCount;
        int codecCount2;
        NM0 nm0 = new NM0();
        int i2 = 0;
        while (true) {
            MediaCodecInfo[] mediaCodecInfoArr = nm0.t;
            if (mediaCodecInfoArr != null) {
                codecCount = mediaCodecInfoArr.length;
            } else {
                try {
                    codecCount = MediaCodecList.getCodecCount();
                } catch (RuntimeException unused) {
                    codecCount = 0;
                }
            }
            if (!(i2 < codecCount)) {
                Log.e("cr_MediaCodecUtil", (i == 1 ? "Encoder" : "Decoder") + " for type " + str + " is not supported on this device [requireSoftware=" + z + ", requireHardware=" + z2 + "].");
                return "";
            }
            MediaCodecInfo[] mediaCodecInfoArr2 = nm0.t;
            if (mediaCodecInfoArr2 != null) {
                codecCount2 = mediaCodecInfoArr2.length;
            } else {
                try {
                    codecCount2 = MediaCodecList.getCodecCount();
                } catch (RuntimeException unused2) {
                    codecCount2 = 0;
                }
            }
            if (i2 == codecCount2) {
                throw new NoSuchElementException();
            }
            int i3 = i2 + 1;
            MediaCodecInfo[] mediaCodecInfoArr3 = nm0.t;
            MediaCodecInfo codecInfoAt = mediaCodecInfoArr3 != null ? mediaCodecInfoArr3[i2] : MediaCodecList.getCodecInfoAt(i2);
            if (codecInfoAt.isEncoder() == i) {
                boolean zE = e(codecInfoAt);
                if ((!z || zE) && (!z2 || !zE)) {
                    for (String str2 : codecInfoAt.getSupportedTypes()) {
                        if (str2.equalsIgnoreCase(str)) {
                            return codecInfoAt.getName();
                        }
                    }
                }
            }
            i2 = i3;
        }
    }

    public static int[] getEncoderColorFormatsForMime(String str) {
        int codecCount;
        int codecCount2;
        NM0 nm0 = new NM0();
        int i = 0;
        while (true) {
            MediaCodecInfo[] mediaCodecInfoArr = nm0.t;
            if (mediaCodecInfoArr != null) {
                codecCount = mediaCodecInfoArr.length;
            } else {
                try {
                    codecCount = MediaCodecList.getCodecCount();
                } catch (RuntimeException unused) {
                    codecCount = 0;
                }
            }
            if (!(i < codecCount)) {
                return null;
            }
            MediaCodecInfo[] mediaCodecInfoArr2 = nm0.t;
            if (mediaCodecInfoArr2 != null) {
                codecCount2 = mediaCodecInfoArr2.length;
            } else {
                try {
                    codecCount2 = MediaCodecList.getCodecCount();
                } catch (RuntimeException unused2) {
                    codecCount2 = 0;
                }
            }
            if (i == codecCount2) {
                throw new NoSuchElementException();
            }
            int i2 = i + 1;
            MediaCodecInfo[] mediaCodecInfoArr3 = nm0.t;
            MediaCodecInfo codecInfoAt = mediaCodecInfoArr3 != null ? mediaCodecInfoArr3[i] : MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        try {
                            return codecInfoAt.getCapabilitiesForType(str2).colorFormats;
                        } catch (IllegalArgumentException unused3) {
                            continue;
                        }
                    }
                }
            }
            i = i2;
        }
    }

    public static Object[] getSupportedCodecProfileLevels() {
        int codecCount;
        int codecCount2;
        ArrayList arrayList = new ArrayList();
        NM0 nm0 = new NM0();
        int i = 0;
        while (true) {
            MediaCodecInfo[] mediaCodecInfoArr = nm0.t;
            if (mediaCodecInfoArr != null) {
                codecCount = mediaCodecInfoArr.length;
            } else {
                try {
                    codecCount = MediaCodecList.getCodecCount();
                } catch (RuntimeException unused) {
                    codecCount = 0;
                }
            }
            if (!(i < codecCount)) {
                return arrayList.toArray();
            }
            MediaCodecInfo[] mediaCodecInfoArr2 = nm0.t;
            if (mediaCodecInfoArr2 != null) {
                codecCount2 = mediaCodecInfoArr2.length;
            } else {
                try {
                    codecCount2 = MediaCodecList.getCodecCount();
                } catch (RuntimeException unused2) {
                    codecCount2 = 0;
                }
            }
            if (i == codecCount2) {
                throw new NoSuchElementException();
            }
            int i2 = i + 1;
            MediaCodecInfo[] mediaCodecInfoArr3 = nm0.t;
            MediaCodecInfo codecInfoAt = mediaCodecInfoArr3 != null ? mediaCodecInfoArr3[i] : MediaCodecList.getCodecInfoAt(i);
            for (String str : codecInfoAt.getSupportedTypes()) {
                if (isDecoderSupportedForDevice(str)) {
                    try {
                        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecInfoAt.getCapabilitiesForType(str).profileLevels) {
                            try {
                                final int iA = AbstractC1603vG.a(str);
                                final int iC = AbstractC1603vG.c(iA, codecProfileLevel.profile);
                                final int iB = AbstractC1603vG.b(iA, codecProfileLevel.level);
                                arrayList.add(new Object(iA, iC, iB) { // from class: org.chromium.media.CodecProfileLevelList$CodecProfileLevelAdapter
                                    public final int a;
                                    public final int b;
                                    public final int c;

                                    {
                                        this.a = iA;
                                        this.b = iC;
                                        this.c = iB;
                                    }

                                    public int getCodec() {
                                        return this.a;
                                    }

                                    public int getLevel() {
                                        return this.c;
                                    }

                                    public int getProfile() {
                                        return this.b;
                                    }
                                });
                            } catch (CodecProfileLevelList$UnsupportedCodecProfileException unused3) {
                            }
                        }
                    } catch (IllegalArgumentException unused4) {
                    }
                } else {
                    Log.w("cr_MediaCodecUtil", "Decoder for type " + str + " disabled on this device");
                }
            }
            i = i2;
        }
    }

    public static boolean isDecoderSupportedForDevice(String str) {
        if (str.equals("video/x-vnd.on2.vp8")) {
            String str2 = Build.HARDWARE;
            if (str2.startsWith("mt")) {
                int i = Build.VERSION.SDK_INT;
                if (i < 28) {
                    return false;
                }
                return i >= 33 || str2.startsWith("mt5599") || str2.startsWith("mt5895") || str2.startsWith("mt8768") || str2.startsWith("mt8696") || str2.startsWith("mt5887");
            }
        } else if (str.equals("video/x-vnd.on2.vp9")) {
            if (Build.MODEL.equals("Nexus Player")) {
                return false;
            }
        } else if (str.equals("video/av01") && Build.VERSION.SDK_INT < 29) {
            return false;
        }
        return true;
    }

    public static boolean isEncoderSupportedByDevice(String str) {
        return d(str) != null;
    }

    public static boolean isSetOutputSurfaceSupported() {
        String str = Build.HARDWARE;
        return (str.equalsIgnoreCase("hi6210sft") || str.equalsIgnoreCase("hi6250")) ? false : true;
    }
}
