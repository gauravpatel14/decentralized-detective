package org.chromium.media;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.util.SparseArray;
import android.view.Surface;
import defpackage.AbstractC1611vN0;
import defpackage.JM0;
import defpackage.LM0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class MediaCodecBridgeBuilder {
    public static MediaCodecBridge createAudioDecoder(String str, MediaCrypto mediaCrypto, int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z, boolean z2) {
        try {
            Log.i("cr_MediaCodecBridge", "create MediaCodec audio decoder, mime " + str);
            LM0 lm0B = MediaCodecUtil.b(str, 0, mediaCrypto);
            MediaCodec mediaCodec = lm0B.a;
            if (mediaCodec == null) {
                return null;
            }
            MediaCodecBridge mediaCodecBridge = new MediaCodecBridge(mediaCodec, lm0B.c, z2);
            MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat(str, i, i2);
            AbstractC1611vN0.c(mediaFormatCreateAudioFormat, new byte[][]{bArr, bArr2, bArr3});
            if (z) {
                mediaFormatCreateAudioFormat.setInteger("is-adts", 1);
            }
            try {
                try {
                    mediaCodecBridge.a.configure(mediaFormatCreateAudioFormat, (Surface) null, mediaCrypto, 0);
                    if (mediaCodecBridge.e()) {
                        return mediaCodecBridge;
                    }
                    mediaCodecBridge.release();
                    return null;
                } catch (IllegalArgumentException e) {
                    Log.e("cr_MediaCodecBridge", "Cannot configure the audio codec", e);
                    return null;
                } catch (IllegalStateException e2) {
                    Log.e("cr_MediaCodecBridge", "Cannot configure the audio codec", e2);
                    return null;
                }
            } catch (MediaCodec.CryptoException e3) {
                Log.e("cr_MediaCodecBridge", "Cannot configure the audio codec: DRM error", e3);
                return null;
            } catch (Exception e4) {
                Log.e("cr_MediaCodecBridge", "Cannot configure the audio codec", e4);
                return null;
            }
        } catch (Exception e5) {
            Log.e("cr_MediaCodecBridge", "Failed to create MediaCodec audio decoder: " + str, e5);
            return null;
        }
    }

    public static MediaCodecBridge createVideoDecoder(String str, int i, MediaCrypto mediaCrypto, int i2, int i3, Surface surface, byte[] bArr, byte[] bArr2, HdrMetadata hdrMetadata, boolean z, boolean z2, String str2) {
        LM0 lm0B;
        try {
            Log.i("cr_MediaCodecBridge", "create MediaCodec video decoder, mime " + str + ", decoder name " + str2);
            if (str2.isEmpty()) {
                lm0B = MediaCodecUtil.b(str, i, mediaCrypto);
            } else {
                lm0B = new LM0();
                try {
                    MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str2);
                    lm0B.a = mediaCodecCreateByCodecName;
                    lm0B.b = MediaCodecUtil.a(mediaCodecCreateByCodecName, str);
                } catch (Exception e) {
                    Log.e("cr_MediaCodecUtil", "Failed to create MediaCodec by decoder name ".concat(str2), e);
                    lm0B.a = null;
                }
            }
            MediaCodec mediaCodec = lm0B.a;
            if (mediaCodec == null) {
                return null;
            }
            MediaCodecBridge mediaCodecBridge = new MediaCodecBridge(mediaCodec, lm0B.c, z2);
            if (!mediaCodecBridge.a(AbstractC1611vN0.b(str, i2, i3, new byte[][]{bArr, bArr2}, hdrMetadata, lm0B.b && z), surface, mediaCrypto, 0)) {
                return null;
            }
            if (mediaCodecBridge.e()) {
                return mediaCodecBridge;
            }
            mediaCodecBridge.release();
            return null;
        } catch (Exception e2) {
            Log.e("cr_MediaCodecBridge", "Failed to create MediaCodec video decoder: " + str + ", codecType: " + i, e2);
            return null;
        }
    }

    public static MediaCodecBridge createVideoEncoder(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        MediaCodecBridge mediaCodecBridge;
        LM0 lm0 = new LM0();
        try {
            Log.i("cr_MediaCodecBridge", "create MediaCodec video encoder, mime " + str);
            lm0 = MediaCodecUtil.c(str);
        } catch (Exception e) {
            Log.e("cr_MediaCodecBridge", "Failed to create MediaCodec video encoder: " + str, e);
        }
        if (lm0.a == null) {
            return null;
        }
        int iMin = 0;
        if (str.equals("video/avc")) {
            JM0 jm0 = new JM0(lm0.a, lm0.c, false);
            jm0.o = new SparseArray();
            mediaCodecBridge = jm0;
        } else {
            mediaCodecBridge = new MediaCodecBridge(lm0.a, lm0.c, false);
        }
        int i8 = lm0.c;
        if (i8 == 0) {
            iMin = Math.min(i5, 30);
        } else if (i8 == 1) {
            iMin = 30;
        }
        boolean z = lm0.b;
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(str, i, i2);
        mediaFormatCreateVideoFormat.setInteger("bitrate", i4);
        mediaFormatCreateVideoFormat.setInteger("frame-rate", iMin);
        mediaFormatCreateVideoFormat.setInteger("i-frame-interval", i6);
        mediaFormatCreateVideoFormat.setInteger("color-format", i7);
        mediaFormatCreateVideoFormat.setInteger("bitrate-mode", i3);
        AbstractC1611vN0.a(mediaFormatCreateVideoFormat, z);
        if (!mediaCodecBridge.a(mediaFormatCreateVideoFormat, null, null, 1)) {
            return null;
        }
        if (mediaCodecBridge.e()) {
            return mediaCodecBridge;
        }
        mediaCodecBridge.release();
        return null;
    }
}
