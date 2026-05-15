package org.chromium.media;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.util.Log;
import android.util.Range;
import defpackage.AbstractC1603vG;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class VideoAcceleratorUtil {
    public static final String[] a = {"video/x-vnd.on2.vp8", "video/x-vnd.on2.vp9", "video/av01", "video/avc", "video/hevc"};
    public static final String[] b = {"video/x-vnd.on2.vp8", "video/x-vnd.on2.vp9", "video/av01", "video/avc", "video/hevc", "video/dolby-vision"};
    public static final Set c;

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public class SupportedProfileAdapter {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public boolean i;
        public boolean j;
        public String k;
        public boolean l;
        public boolean m;
        public boolean n;
        public int o;

        public int getLevel() {
            return this.b;
        }

        public int getMaxFramerateDenominator() {
            return this.h;
        }

        public int getMaxFramerateNumerator() {
            return this.g;
        }

        public int getMaxHeight() {
            return this.d;
        }

        public int getMaxNumberOfTemporalLayers() {
            return this.o;
        }

        public int getMaxWidth() {
            return this.c;
        }

        public int getMinHeight() {
            return this.f;
        }

        public int getMinWidth() {
            return this.e;
        }

        public String getName() {
            return this.k;
        }

        public int getProfile() {
            return this.a;
        }

        public boolean isSoftwareCodec() {
            return this.l;
        }

        public boolean requiresSecurePlayback() {
            return this.n;
        }

        public boolean supportsCbr() {
            return this.i;
        }

        public boolean supportsSecurePlayback() {
            return this.m;
        }

        public boolean supportsVbr() {
            return this.j;
        }
    }

    static {
        Object[] objArr = {"c2.qti.avc.encoder", "c2.exynos.h264.encoder"};
        HashSet hashSet = new HashSet(2);
        for (int i = 0; i < 2; i++) {
            Object obj = objArr[i];
            Objects.requireNonNull(obj);
            if (!hashSet.add(obj)) {
                throw new IllegalArgumentException("duplicate element: " + obj);
            }
        }
        c = Collections.unmodifiableSet(hashSet);
    }

    /* JADX WARN: Removed duplicated region for block: B:93:0x0287  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.chromium.media.VideoAcceleratorUtil.SupportedProfileAdapter[] getSupportedDecoderProfiles() {
        /*
            Method dump skipped, instruction units count: 925
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.chromium.media.VideoAcceleratorUtil.getSupportedDecoderProfiles():org.chromium.media.VideoAcceleratorUtil$SupportedProfileAdapter[]");
    }

    public static SupportedProfileAdapter[] getSupportedEncoderProfiles() {
        MediaCodecInfo[] mediaCodecInfoArr;
        String[] strArr;
        int i;
        ArrayList arrayList;
        ArrayList arrayList2;
        String str;
        int i2;
        try {
            int i3 = 0;
            MediaCodecInfo[] codecInfos = new MediaCodecList(0).getCodecInfos();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            String[] strArr2 = a;
            int i4 = 0;
            while (i4 < 5) {
                String str2 = strArr2[i4];
                int length = codecInfos.length;
                int i5 = i3;
                while (i5 < length) {
                    MediaCodecInfo mediaCodecInfo = codecInfos[i5];
                    if (!mediaCodecInfo.isAlias() && mediaCodecInfo.isEncoder() && (mediaCodecInfo.isHardwareAccelerated() || str2.equalsIgnoreCase("video/avc") || str2.equalsIgnoreCase("video/hevc"))) {
                        try {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str2);
                            int[] iArr = capabilitiesForType.colorFormats;
                            int length2 = iArr.length;
                            for (int i6 = i3; i6 < length2; i6++) {
                                if (iArr[i6] == 21) {
                                    MediaCodecInfo.EncoderCapabilities encoderCapabilities = capabilitiesForType.getEncoderCapabilities();
                                    boolean zIsBitrateModeSupported = encoderCapabilities.isBitrateModeSupported(2);
                                    boolean zIsBitrateModeSupported2 = encoderCapabilities.isBitrateModeSupported(1);
                                    MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                                    Range<Integer> supportedWidths = videoCapabilities.getSupportedWidths();
                                    Range<Integer> supportedHeightsFor = videoCapabilities.getSupportedHeightsFor(((Integer) supportedWidths.getUpper()).intValue());
                                    mediaCodecInfoArr = codecInfos;
                                    strArr = strArr2;
                                    if (((Integer) supportedWidths.getUpper()).intValue() < 3840 || ((Integer) supportedHeightsFor.getUpper()).intValue() < 2160) {
                                        if (((Integer) supportedHeightsFor.getUpper()).intValue() * ((Integer) supportedWidths.getUpper()).intValue() >= 8294400 && videoCapabilities.isSizeSupported(3840, 2160)) {
                                            supportedWidths = new Range<>((Integer) supportedWidths.getLower(), 3840);
                                            supportedHeightsFor = new Range<>((Integer) supportedHeightsFor.getLower(), 2160);
                                        }
                                    }
                                    boolean z = !((Integer) supportedHeightsFor.getUpper()).equals(supportedWidths.getUpper()) && videoCapabilities.isSizeSupported(((Integer) supportedHeightsFor.getUpper()).intValue(), ((Integer) supportedWidths.getUpper()).intValue());
                                    Range<Integer> supportedFrameRates = videoCapabilities.getSupportedFrameRates();
                                    HashSet hashSet = new HashSet();
                                    i = length;
                                    int iA = AbstractC1603vG.a(str2);
                                    MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType.profileLevels;
                                    arrayList = arrayList3;
                                    int length3 = codecProfileLevelArr.length;
                                    arrayList2 = arrayList4;
                                    int i7 = 0;
                                    while (i7 < length3) {
                                        int i8 = length3;
                                        MediaCodecInfo.CodecProfileLevel codecProfileLevel = codecProfileLevelArr[i7];
                                        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr2 = codecProfileLevelArr;
                                        try {
                                            hashSet.add(Integer.valueOf(AbstractC1603vG.c(iA, codecProfileLevel.profile)));
                                            i2 = iA;
                                        } catch (RuntimeException unused) {
                                            i2 = iA;
                                            Log.w("cr_VAUtil", "Unknown profile: " + codecProfileLevel.profile + " for codec " + str2);
                                        }
                                        i7++;
                                        length3 = i8;
                                        codecProfileLevelArr = codecProfileLevelArr2;
                                        iA = i2;
                                    }
                                    int i9 = (Build.VERSION.SDK_INT >= 30 && c.contains(mediaCodecInfo.getName().toLowerCase(Locale.getDefault()))) ? 3 : 1;
                                    ArrayList arrayList5 = mediaCodecInfo.isHardwareAccelerated() ? arrayList : arrayList2;
                                    Iterator it = hashSet.iterator();
                                    while (it.hasNext()) {
                                        int iIntValue = ((Integer) it.next()).intValue();
                                        SupportedProfileAdapter supportedProfileAdapter = new SupportedProfileAdapter();
                                        supportedProfileAdapter.a = iIntValue;
                                        String str3 = str2;
                                        supportedProfileAdapter.e = ((Integer) supportedWidths.getLower()).intValue();
                                        supportedProfileAdapter.f = ((Integer) supportedHeightsFor.getLower()).intValue();
                                        supportedProfileAdapter.c = ((Integer) supportedWidths.getUpper()).intValue();
                                        supportedProfileAdapter.d = ((Integer) supportedHeightsFor.getUpper()).intValue();
                                        supportedProfileAdapter.g = ((Integer) supportedFrameRates.getUpper()).intValue();
                                        supportedProfileAdapter.h = 1;
                                        supportedProfileAdapter.i = zIsBitrateModeSupported;
                                        supportedProfileAdapter.j = zIsBitrateModeSupported2;
                                        supportedProfileAdapter.k = mediaCodecInfo.getName();
                                        supportedProfileAdapter.l = mediaCodecInfo.isSoftwareOnly();
                                        supportedProfileAdapter.o = i9;
                                        arrayList5.add(supportedProfileAdapter);
                                        if (z) {
                                            SupportedProfileAdapter supportedProfileAdapter2 = new SupportedProfileAdapter();
                                            supportedProfileAdapter2.a = iIntValue;
                                            supportedProfileAdapter2.e = ((Integer) supportedHeightsFor.getLower()).intValue();
                                            supportedProfileAdapter2.f = ((Integer) supportedWidths.getLower()).intValue();
                                            supportedProfileAdapter2.c = ((Integer) supportedHeightsFor.getUpper()).intValue();
                                            supportedProfileAdapter2.d = ((Integer) supportedWidths.getUpper()).intValue();
                                            supportedProfileAdapter2.g = ((Integer) supportedFrameRates.getUpper()).intValue();
                                            supportedProfileAdapter2.h = 1;
                                            supportedProfileAdapter2.i = zIsBitrateModeSupported;
                                            supportedProfileAdapter2.j = zIsBitrateModeSupported2;
                                            supportedProfileAdapter2.k = mediaCodecInfo.getName();
                                            supportedProfileAdapter2.l = mediaCodecInfo.isSoftwareOnly();
                                            arrayList5.add(supportedProfileAdapter2);
                                        }
                                        str2 = str3;
                                    }
                                    str = str2;
                                }
                            }
                        } catch (IllegalArgumentException unused2) {
                        }
                        mediaCodecInfoArr = codecInfos;
                        arrayList = arrayList3;
                        arrayList2 = arrayList4;
                        strArr = strArr2;
                        str = str2;
                        i = length;
                    } else {
                        mediaCodecInfoArr = codecInfos;
                        arrayList = arrayList3;
                        arrayList2 = arrayList4;
                        strArr = strArr2;
                        str = str2;
                        i = length;
                    }
                    i5++;
                    strArr2 = strArr;
                    codecInfos = mediaCodecInfoArr;
                    length = i;
                    arrayList3 = arrayList;
                    arrayList4 = arrayList2;
                    str2 = str;
                    i3 = 0;
                }
                i4++;
                i3 = 0;
            }
            ArrayList arrayList6 = arrayList3;
            arrayList6.addAll(arrayList4);
            SupportedProfileAdapter[] supportedProfileAdapterArr = new SupportedProfileAdapter[arrayList6.size()];
            arrayList6.toArray(supportedProfileAdapterArr);
            return supportedProfileAdapterArr;
        } catch (Throwable th) {
            Log.e("cr_VAUtil", "Unable to retrieve MediaCodecInfo: ", th);
            return null;
        }
    }
}
